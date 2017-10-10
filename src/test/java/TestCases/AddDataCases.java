package TestCases;


import Utilities.ExcelUtilities;
import static Utilities.LoginEnvUtilities.*;
import static Utilities.PathUtilities.*;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class AddDataCases {
    private static final Logger log = LogManager.getLogger(AddDataCases.class.getName()); //Log4j object
    private WebDriver driver; // Selenium object    
    /**
     * The Page Object variables. Each variable contains the elements of the specific page
     * with it's accompanied methods
     */
    private LogInPg logInPgTest;
    private NavBarFooterPg navBarFooterPgTest;
    private AddPatientPg addPatientPgTest;
    private PatientListPg patientListPgTest;
    private CliniciansListPg cliniciansListPgTest;
    private ProtocolsListPg protocolsListPgTest;
    
    /**
     * DataProvider(testNG) methods these call the static function for reading the data
     * from the excel sheet. Data input can also be hard-coded like on the patientData() method
     */
    @DataProvider(name = "logInInputs")
    public static Object[][] logInData() {
        return new Object[][] {{"andres.gomez@reflexionhealth.com", "Reflexion1"}};       
    }
    
    @DataProvider(name = "logInInputsExcel")
    public static Object[][] logInDataExcel() {
        Object[][] testData = ExcelUtilities.getTestData("CALog");
        return testData;
    }
    
    @DataProvider(name = "patientInputs")
    public static Object[][] patientData() {
        return new Object[][] {{"Dummy 5", "Dummy1", 'm', 07, 11, 1948}, {"Dummy 2", "Dummy2"
        , 'f', 8, 10, 1969}};
    }
    
    @DataProvider(name = "patientInputsExcel")
    public static Object[][] patientDataExcel() {
        Object[][] testData = ExcelUtilities.getTestData("PatInput");
        return testData;
    }
    
    @DataProvider(name = "protocolInputsExcel")
    public static Object[][] protocolDataExcel() {
        Object[][] testData = ExcelUtilities.getTestData("ProtInput");
        return testData;
    }
    
    @DataProvider(name = "clinicianInputsExcel")
    public static Object[][] clinicianDataExcel() {
        Object[][] testData = ExcelUtilities.getTestData("ClinInput");
        return testData;
    }
    
    @Parameters("browserType") //This is for reading the browserType parameter in the addData.xml
    @BeforeClass //TestNG annotation specifying that method should be run before the class is executed
    public void setup(String browser) throws Exception {
        
        //Sets the browser driver path to Firefox or Chrome dependant on the addData.xml file
        if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", getGeckoDriverPath());
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", getChromeDriverPath());
            driver = new ChromeDriver();
        }        
        //Selenium methods to set waits, maximize and open the browser for automation
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(finalEnvironment());
        
        //Initializes all required PageObject variables
        logInPgTest = new LogInPg(driver);
        navBarFooterPgTest = new NavBarFooterPg(driver);
        addPatientPgTest = new AddPatientPg(driver);
        patientListPgTest = new PatientListPg(driver);
        cliniciansListPgTest =  new CliniciansListPg(driver);
        protocolsListPgTest =  new ProtocolsListPg(driver);        
        ExcelUtilities.setExcelFile(getExcelPath(), "Sheet1"); //Sets the excel file and the sheet
    }
    
    /**
     * TestNG test methods and @Test annotations
     * priority sets order
     * enabled sets if it is going to be run, all 3 test methods for inputing 
     * data(addPatientCase, addProtocolCase, addClinicianCase) can be run at 
     * the same time. Data is going to be read from an excel file testData.xlsx
     */     
    @Test(priority = 1, enabled = true)
    public void logInCase() throws InterruptedException {
        logInPgTest.logIn(finalEmail(), finalPass());
        log.info("Entered login email: " + finalEmail());
        patientListPgTest.waitPgLoad();
        Reporter.log("Logged in with " + finalEmail() + " and pw: Reflexion1");
    }
    
    // Method for using sets of username and pass for trying login attempts 
    @Test(dataProvider = "logInInputsExcel", priority = 1, enabled = false)
    public void testExcelData(String email, String pw) throws InterruptedException {
        logInPgTest.clearLogInText();
        logInPgTest.logIn(email, pw);
        Reporter.log("Logging in with " + email + "and pw: " + pw);
        patientListPgTest.waitPgLoad();
    }
    
    // Method for adding patients uses the DataProvider annotation for reading data from the excel file
    @Test(dataProvider = "patientInputsExcel", priority = 2, enabled = true)
    public void addPatientCase(String testfName, String testlName, String testGender,
    String testdobM, String testdobD, String testdobY, String email) {
        navBarFooterPgTest.clickAddPatientBtn();
        log.info("Clicked Add Patient Button");        
        addPatientPgTest.addBasicPatient(testfName, testlName, testGender, testdobM, testdobD, testdobY, email);        
    }
    
    // Method for adding protocols with fixed exercises uses the DataProvider annotation for reading data from the excel file
    @Test(dataProvider = "protocolInputsExcel", priority = 3, enabled = false)
    public void addProtocolCase(String testName, String testDescription) {
        navBarFooterPgTest.clickProtocolsTabNav();
        log.info("Clicked Protocols Navigation Tab");
        protocolsListPgTest.waitPgLoad();
        protocolsListPgTest.addProtocol(testName, testDescription);
    }
    
    // Method for clinicians uses the DataProvider annotation for reading data from the excel file
    @Test(dataProvider = "clinicianInputsExcel", priority = 4, enabled = false)
    public void addClinicianCase(String testfName, String testlName, String testEmail, String testPhoneNum) {
        navBarFooterPgTest.clickCliniciansTabNav();
        log.info("Clicked Clinicians Navigation Tab");
        cliniciansListPgTest.waitPgLoad(); 
        cliniciansListPgTest.addClinician(testfName, testlName, testEmail, testPhoneNum);
    }
    
    //Loop for discharging patients 
    @Test(enabled = false, priority = 2)
    public void dischargePatient() throws InterruptedException {
        navBarFooterPgTest.clickPatientsTabNav();
        log.info("Clicked Patients Navigation Tab");
        StringBuilder name = new StringBuilder("Excel  ");
        for(int i = 125; i <= 225; i++) {
            name.replace(6, 9, Integer.toString(i));
            patientListPgTest.dischargePat(name.toString());        
        }
    }
    //Loop for deleting protocols
    @Test(enabled = false, priority = 2)
    public void deleteProtocol() {
        navBarFooterPgTest.clickProtocolsTabNav();
        log.info("Clicked Protocols Navigation Bar");
        protocolsListPgTest.waitPgLoad();
        StringBuilder name = new StringBuilder("Excel  ");        
        for(int i = 104; i <= 180; i++) {
            name.replace(6, 9, Integer.toString(i));
            protocolsListPgTest.deleteProtocol(name.toString());
        }        
    }
}

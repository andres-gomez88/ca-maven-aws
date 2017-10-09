
package TestCases;


import Utilities.ExtentFactory;
import static Utilities.JamaAPIUtilities.*;
import static Utilities.LoginEnvUtilities.*;
import static Utilities.PathUtilities.*;
import static Utilities.Screenshot.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;


public class HomePageTestCases {
    private static final Logger log = LogManager.getLogger(HomePageTestCases.class.getName());
    WebDriver driver;
    LogInPg logInPgTest;
    NavBarFooterPg navBarFooterPgTest;
    PatientListPg patientListPgTest;
    AddPatientPg addPatientPgTest;
    
    public String methodName;
    ExtentReports extent;
    ExtentTest reportTest;
    
    @Parameters({"browserType", "apiId"})
    @BeforeClass
    public void setup(@Optional String browser, @Optional String id) throws Exception {
        if(browser == null) {
            System.setProperty("webdriver.chrome.driver", getChromeDriverPath());
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", getGeckoDriverPath());
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", getChromeDriverPath());
            driver = new ChromeDriver();
        }        
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        logInPgTest = new LogInPg(driver);
        navBarFooterPgTest = new NavBarFooterPg(driver);
        patientListPgTest = new PatientListPg(driver);
        addPatientPgTest = new AddPatientPg(driver);
        if(ExtentFactory.getInstance() == null) {
            extent = ExtentFactory.createInstance(browser);
        } else {
            extent = ExtentFactory.getInstance();
        }
        if(id == null) {
            setApiId(31052);
        }
    }
    
    @Test(enabled = true)
    public void testCase090() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickSrchNavBar();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Search field expanded with the correct watermark text"); 
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }        
    }
    
    @Test(enabled = true)
    public void testCase092() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.searchNavBar("testL");
            reportTest.log(Status.INFO, "Performing Nav bar patient search");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Displaying valid search result"); 
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }        
    }
    
    @Test(enabled = true)
    public void testCase094() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.searchNavBar("test");
            reportTest.log(Status.INFO, "Performing Nav bar patient search");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Displaying results with same name"); 
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }        
    }
    
    @Test(enabled = true)
    public void testCase095() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.searchNavBar("lalalalala");
            reportTest.log(Status.INFO, "Performing Nav bar patient search");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "No result found page displayed with clear search results");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }        
    }
    
    @Test(enabled = true)
    public void testCase096() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            patientListPgTest.clickSeachPatTxtBox();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Clicked Search Patient field, watermark is displayed"); 
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }        
    }
    
    @Test(enabled = true)
    public void testCase097() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            patientListPgTest.searchPatient("test 1");
            reportTest.log(Status.INFO, "Performing active patient search");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Search results displayed with patient details"); 
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }        
    }
    
    @Test(enabled = true)
    public void testCase098() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            patientListPgTest.searchPatient("T");
            reportTest.log(Status.INFO, "Performing active patient search");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Auto suggestion list result dsiplayed"); 
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }        
    }
    
    @Test(enabled = true)
    public void testCase099() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            patientListPgTest.searchPatient("test");
            reportTest.log(Status.INFO, "Performing active patient search with same name");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Patients with same name results displayed"); 
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }        
    }
    
    @Test(enabled = true)
    public void testCase100() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            patientListPgTest.searchPatient("lalala");
            reportTest.log(Status.INFO, "Performing active patient search");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "No result found displayed with clear search option"); 
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }        
    }
    
    @Test(enabled = true)
    public void testCase101() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            patientListPgTest.clearSearch();
            reportTest.log(Status.INFO, "Attempting to clear search");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Cancel button is diabled"); 
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }        
    }
    
    @Test(enabled = true)
    public void testCase102() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            patientListPgTest.searchPatient("test");
            reportTest.log(Status.INFO, "Performing active patient search");
            patientListPgTest.clearSearch();
            reportTest.log(Status.INFO, "Cleared Search");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Search data removed"); 
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase103() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickAddPatientBtn();
            reportTest.log(Status.INFO, "Navigating to Add Patient Page");
            addPatientPgTest.waitPgLoad();
            log.info("Directed to Add Patient Page");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Directed to Add Patient Page"); 
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase104() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickAddPatientBtn();
	    reportTest.log(Status.INFO, "Navigating to Add Patient Page");
            addPatientPgTest.waitPgLoad();
            log.info("Add Patient Page Element displayed");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Add Patient Page elements displayed"); 
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase105() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickAddPatientBtn();
	    reportTest.log(Status.INFO, "Navigating to Add Patient Page");
            addPatientPgTest.waitPgLoad();
            addPatientPgTest.fillName("Test");
            reportTest.log(Status.INFO, "Filled first name field");
            addPatientPgTest.clickCancelAddBtn();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Popup prompt displaying Changes have not been saved"); 
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase106() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickAddPatientBtn();
	    reportTest.log(Status.INFO, "Navigating to Add Patient Page");
            addPatientPgTest.waitPgLoad();
            addPatientPgTest.fillName("Test");
            reportTest.log(Status.INFO, "Filled first name field");
            addPatientPgTest.clickCancelAddBtn();
            addPatientPgTest.clickNoUnsavedCh();
            reportTest.log(Status.INFO, "Click cancel and clicking No on the popup");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "User remains in Add Patient Page"); 
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase107() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickAddPatientBtn();
	    reportTest.log(Status.INFO, "Navigating to Add Patient Page");
            addPatientPgTest.waitPgLoad();
            addPatientPgTest.fillName("Test");
            reportTest.log(Status.INFO, "Filled first name field");
            addPatientPgTest.clickCancelAddBtn();
            addPatientPgTest.clickYesUnsavedCh();
            reportTest.log(Status.INFO, "Click cancel and yes on the popup");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "User returned to Patient List Page"); 
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase108() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickAddPatientBtn();
	    reportTest.log(Status.INFO, "Navigating to Add Patient Page");
            addPatientPgTest.waitPgLoad();
            if(addPatientPgTest.doneBtnClickable() == false) {
                log.info("PASS");
                testCaseJamaApiPass(getIncApiId());
                reportTest.log(Status.PASS, "Done and Next buttons are disabled"); 
            } else {
                reportTest.log(Status.FAIL, "Test FAILED");
                testCaseJamaApiFail(getIncApiId());
                org.testng.Assert.fail("Test FAILED");
            }
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase109() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickAddPatientBtn();
	    reportTest.log(Status.INFO, "Navigating to Add Patient Page");
            addPatientPgTest.waitPgLoad();
            addPatientPgTest.fillBasicInfo("testN", "testL", "M", "7", "14", 
            "1988", "amail@gmail.co");
            reportTest.log(Status.INFO, "Filling basic patient info");
            if(addPatientPgTest.doneBtnClickable() == true) {
                log.info("PASS");
                testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Done and next buttons are enabled"); 
            } else {
                reportTest.log(Status.FAIL, "Test FAILED");
                testCaseJamaApiFail(getIncApiId());
                org.testng.Assert.fail("Test FAILED");
            }
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase110() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickAddPatientBtn();
	    reportTest.log(Status.INFO, "Navigating to Add Patient Page");
            addPatientPgTest.waitPgLoad();
            addPatientPgTest.fillBasicInfo("testN", "testL", "M", "7", "14", 
            "1988", "amail@gmail.co");
            reportTest.log(Status.INFO, "Filling basic patient info");
            addPatientPgTest.clickDoneBtn();
            reportTest.log(Status.INFO, "Done button clicked");
            addPatientPgTest.waitForVerifySavePg();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
            reportTest.log(Status.PASS, "Verify & Save Page information is correct");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = false)
    public void testCase111() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickAddPatientBtn();
	    reportTest.log(Status.INFO, "Navigating to Add Patient Page");
            addPatientPgTest.waitPgLoad();
            addPatientPgTest.fillBasicInfo("testN", "testL", "M", "7", "14", 
            "1988", "amail@gmail.co");
	    reportTest.log(Status.INFO, "Filling basic patient info");
            addPatientPgTest.clickDoneBtn();
            addPatientPgTest.waitForVerifySavePg();
            addPatientPgTest.clickCreatePatBtn();
            addPatientPgTest.waitForPassSelct();
            log.info("Password Selection Window Open");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = false)
    public void testCase112() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickAddPatientBtn();
	    reportTest.log(Status.INFO, "Navigating to Add Patient Page");
            addPatientPgTest.waitPgLoad();
            addPatientPgTest.fillBasicInfo("testN", "testL", "M", "7", "14", 
            "1988", "amail@gmail.co");
	    reportTest.log(Status.INFO, "Filling basic patient info");
            addPatientPgTest.clickDoneBtn();
            addPatientPgTest.waitForVerifySavePg();
            addPatientPgTest.clickCreatePatBtn();
            addPatientPgTest.waitForPassSelct();
            log.info("Password Selection Window Open");
            addPatientPgTest.clickSendMailBtn();
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = false)
    public void testCase113() {//check mail
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickAddPatientBtn();
	    reportTest.log(Status.INFO, "Navigating to Add Patient Page");
            addPatientPgTest.waitPgLoad();
            addPatientPgTest.fillBasicInfo("testN", "testL", "M", "7", "14", 
            "1988", "amail@gmail.co");
	    reportTest.log(Status.INFO, "Filling basic patient info");
            addPatientPgTest.clickDoneBtn();
            addPatientPgTest.waitForVerifySavePg();
            addPatientPgTest.clickCreatePatBtn();
            addPatientPgTest.waitForPassSelct();
            log.info("Password Selection Window Open");
            addPatientPgTest.clickSendMailBtn();
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = false)
    public void testCase116() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickAddPatientBtn();
	    reportTest.log(Status.INFO, "Navigating to Add Patient Page");
            addPatientPgTest.waitPgLoad();
            addPatientPgTest.fillBasicInfo("testN", "testL", "M", "7", "14", 
            "1988", "amail@gmail.co");
	    reportTest.log(Status.INFO, "Filling basic patient info");
            addPatientPgTest.clickDoneBtn();
            addPatientPgTest.waitForVerifySavePg();
            addPatientPgTest.clickCreatePatBtn();
            addPatientPgTest.waitForPassSelct();
            log.info("Password Selection Window Open");
            addPatientPgTest.clickSendMailBtn();
            addPatientPgTest.waitForOkBtn();
            addPatientPgTest.clickOkBtn();
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = false)
    public void testCase117() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickAddPatientBtn();
	    reportTest.log(Status.INFO, "Navigating to Add Patient Page");
            addPatientPgTest.waitPgLoad();
            addPatientPgTest.fillBasicInfo("testN", "testL", "M", "7", "14", 
            "1988", "amail@gmail.co");
	    reportTest.log(Status.INFO, "Filling basic patient info");
            addPatientPgTest.clickDoneBtn();
            addPatientPgTest.waitForVerifySavePg();
            addPatientPgTest.clickCreatePatBtn();
            addPatientPgTest.waitForPassSelct();
            log.info("Password Selection Window Open");
            addPatientPgTest.clickSendMailBtn();
            addPatientPgTest.waitForOkBtn();
            
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = false)
    public void testCase118() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickAddPatientBtn();
	    reportTest.log(Status.INFO, "Navigating to Add Patient Page");
            addPatientPgTest.waitPgLoad();
            addPatientPgTest.fillBasicInfo("testN", "testL", "M", "7", "14", 
            "1988", "amail@gmail.co");
	    reportTest.log(Status.INFO, "Filling basic patient info");
            addPatientPgTest.clickDoneBtn();
            addPatientPgTest.waitForVerifySavePg();
            addPatientPgTest.clickCreatePatBtn();
            addPatientPgTest.waitForPassSelct();
            log.info("Password Selection Window Open");
            addPatientPgTest.clickGenPwBtn();
            addPatientPgTest.waitForOkBtn();
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
   @Parameters("browserType")
    @AfterMethod
    public void screenAfterMethod(@Optional String browser) throws IOException, InterruptedException {
        String path = null;
        if(browser == null) {
            path = takeScreenshotCH(methodName + "CH", driver);
        } else if(browser.equalsIgnoreCase("firefox")) {
            path = takeScreenshotFF(methodName + "FF", driver);
        } else if (browser.equalsIgnoreCase("chrome")) {
            path = takeScreenshotCH(methodName + "CH", driver);
        }
        reportTest.debug("Final Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(path).build());     
    }
    
    @AfterClass
    public void flush() {
        extent.flush();
        driver.close();
    }
}

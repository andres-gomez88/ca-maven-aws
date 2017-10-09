
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


public class PatExtraOptnTestCases {
    private static final Logger log = LogManager.getLogger(PatExtraOptnTestCases.class.getName());    
    WebDriver driver;
    LogInPg logInPgTest;
    PatientListPg patientListPgTest;
    ProfilePg profilePgTest;
    
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
        patientListPgTest = new PatientListPg(driver);
        profilePgTest =  new ProfilePg(driver);
        if(ExtentFactory.getInstance() == null) {
            extent = ExtentFactory.createInstance(browser);
        } else {
            extent = ExtentFactory.getInstance();
        }
        if(id == null) {
            setApiId(32244);
        }
    }
    
    @Test(enabled = true)
    public void testCase249() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.reqKitExtraOptn();
            reportTest.log(Status.INFO, "Selected Kit Install from Extra Options");
            patientListPgTest.waitForKitInstPopup();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Popup kit installation request window displayed");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase250() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.reqKitExtraOptn();
            reportTest.log(Status.INFO, "Selected Kit Install from Extra Options");
            patientListPgTest.waitForKitInstPopup();
            reportTest.log(Status.INFO, "Clicked on cancel button ");
            patientListPgTest.clickCancelBtn();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Popup window closed");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase251() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.reqKitExtraOptn();
            reportTest.log(Status.INFO, "Selected Kit Install from Extra Options");
            patientListPgTest.clickEditProfileBtn();
            reportTest.log(Status.INFO, "Clicked Edit Profile Button");
            //profilePgTest.waitPgLoad();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Navigated to Kit Information Tab");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase252() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.dischrgPatExtraOptn();
            reportTest.log(Status.INFO, "Selected Discharge from Extra Options");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Popup windows displayed to confirmate the discharge");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }        
    }
    
    @Test(enabled = true)
    public void testCase253() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.dischrgPatExtraOptn();
            reportTest.log(Status.INFO, "Selected Discharge from Extra Options");
            patientListPgTest.clickOkBtn();
            reportTest.log(Status.INFO, "Clicked OK button");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Patient is now Discharged ");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }        
    }
    
    @Test(enabled = true)
    public void testCase254() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.dischrgPatExtraOptn();
            reportTest.log(Status.INFO, "Selected Discharge from Extra Options");
            patientListPgTest.clickCancelBtn();
            reportTest.log(Status.INFO, "Clicked Cancel Button");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Popup windows is now closed");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }        
    }
    
    @Test(enabled = true)
    public void testCase255() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.dischrgPatExtraOptn();
            reportTest.log(Status.INFO, "Selected Discharge from Extra Options");
            patientListPgTest.clickCancelBtn(); //patientListPgTest.clickClosePopupBtn();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Clicked cancel popup closing");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }        
    }
    
    @Test(enabled = true)
    public void testCase256() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.plOnHoldExtraOptn();
            reportTest.log(Status.INFO, "Selected On Hold from Extra Options");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Popup Windows displayed with On Hold parameters");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }        
    }
    
    @Test(enabled = true)
    public void testCase257() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.plOnHoldExtraOptn();
            reportTest.log(Status.INFO, "Selected On Hold from Extra Options");
            patientListPgTest.clickCalendarBtn();
            reportTest.log(Status.INFO, "Clicked Calendar Button");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Drop-down Calendar Displayed");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }        
    }
    
    @Test(enabled = true)
    public void testCase258() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.plOnHoldExtraOptn();
            reportTest.log(Status.INFO, "Selected On Hold from Extra Options");
            patientListPgTest.fillFromHoldDate("04/30/17");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Filled with 04/30/17");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }        
    }
    
    @Test(enabled = true)
    public void testCase259() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.plOnHoldExtraOptn();
            reportTest.log(Status.INFO, "Selected On Hold from Extra Options");
            patientListPgTest.clickToHoldDrpDown();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "All options displayed in dropdown");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }        
    }
    
    @Test(enabled = true)
    public void testCase260() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.plOnHoldExtraOptn();
            reportTest.log(Status.INFO, "Selected On Hold from Extra Options");
            patientListPgTest.clickToHoldDrpDown();
            reportTest.log(Status.INFO, "Clicked To Hold Dropdown");
            patientListPgTest.fillToSelctTxtBox("specific");
            reportTest.log(Status.INFO, "Selected Specific Date");
            patientListPgTest.fillToHoldDate("05/10/17");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Filled in date manually");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }        
    }
    
    @Test(enabled = true)
    public void testCase261() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.plOnHoldExtraOptn();
            reportTest.log(Status.INFO, "Selected On Hold from Extra Options");
            patientListPgTest.clickSaveHoldBtn();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Popup displayed with confirmation. Patient On Hold");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }        
    }
    
    @Test(enabled = true)
    public void testCase262() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.plOnHoldExtraOptn();
            reportTest.log(Status.INFO, "Selected On Hold from Extra Options");
            patientListPgTest.fillFromHoldDate("04/15/17");
            reportTest.log(Status.INFO, "Filled Hold Date with an earlier date than today");
            patientListPgTest.clickSaveHoldBtn();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Warning Message Displayed Start Date can't be Earlier than Today");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }        
    }
    
    @Test(enabled = true)
    public void testCase263() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.plOnHoldExtraOptn();
            reportTest.log(Status.INFO, "Selected On Hold from Extra Options");
            patientListPgTest.fillFromHoldDate("08/15/17");
            reportTest.log(Status.INFO, "Filled in From Hold Date");
            patientListPgTest.clickSaveHoldBtn();
            reportTest.log(Status.INFO, "Clicked Save Hold");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Status Updated popup displayed, patient does not display on hold");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }        
    }
    
    @Test(enabled = true)
    public void testCase264() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.cancelHoldOptn();
            reportTest.log(Status.INFO, "Selected Cancel Hold from Extra Options");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Patient Hold Removed from Patient");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }        
    }
    
    @Test(enabled = true)
    public void testCase265() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.resetPwExtraOptn();
            reportTest.log(Status.INFO, "Selected Reset Password from Extra Options");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Popup Window Displayed with Options");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }        
    }
    
    @Test(enabled = true)
    public void testCase266() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.resetPwExtraOptn();
            reportTest.log(Status.INFO, "Selected Reset Password from Extra Options");
            patientListPgTest.clickSendEmailPwBtn();
            reportTest.log(Status.INFO, "Clicked Send Email Password Button");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Confirmation Window Displayed of Email Sent");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase267() throws UnirestException {// Check finalEmail()
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.resetPwExtraOptn();
            reportTest.log(Status.INFO, "Selected Reset Password from Extra Options");
            patientListPgTest.clickSendEmailPwBtn();
            reportTest.log(Status.INFO, "Clicked Send Email Password Button");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Email sent, Please Check Email");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
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
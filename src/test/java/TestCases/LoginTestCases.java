
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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;


public class LoginTestCases {
    private static final Logger log = LogManager.getLogger(LoginTestCases.class.getName());
    private WebDriver driver;
    private LogInPg logInPgTest;
    private ResetpwLogInPg resetpwLogInPgTest;
    private PatientListPg patientListPgTest;
    private NavBarFooterPg navBarFooterPgTest;    
    private String methodName;
    private ExtentReports extent;
    private ExtentTest reportTest;
        
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
        //driver.manage().window().maximize();
        logInPgTest = new LogInPg(driver);
        resetpwLogInPgTest = new ResetpwLogInPg(driver);
        patientListPgTest = new PatientListPg(driver);
        navBarFooterPgTest = new NavBarFooterPg(driver);
        if(ExtentFactory.getInstance() == null) {
            extent = ExtentFactory.createInstance(browser);
        } else {
            extent = ExtentFactory.getInstance();
        }
        if(id == null) {
            setApiId(27883);
        } else {
            setApiId(Integer.parseInt(id));
        }
    }
    
    @Test(enabled = true)
    public void testCase001() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        reportTest = extent.createTest(methodName); 
        driver.get(finalEnvironment());
        log.info("Opened: " + finalEnvironment());
        reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
        try {
            logInPgTest.checkLoginElements();
            log.info("Page loaded");
            log.info("PASS");
            reportTest.log(Status.PASS, "Login Page Loaded");
            testCaseJamaApiPass(getIncApiId());
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
            org.testng.Assert.fail("Test FAILED");            
        }
    }
    
    @Test(enabled = true)
    public void testCase002() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        reportTest = extent.createTest(methodName);        
        reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
        driver.get(finalEnvironment()); 
        log.info("Opened: " + finalEnvironment());
        try {
            logInPgTest.checkLoginElements();
            log.info("Elements are present");
            log.info("PASS");
            reportTest.log(Status.PASS, "Elements are present");
            testCaseJamaApiPass(getIncApiId());
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
            org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase003() throws UnirestException {
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
            reportTest.log(Status.PASS, "Patient Dashboard Displayed");
            log.info("PASS");
            testCaseJamaApiPass(getIncApiId());
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
            org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase004() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
            reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logInNoCred();//Method tries to login without credentials
            reportTest.log(Status.INFO, "Login Attempt with no credentials");
            reportTest.log(Status.PASS, "Submit button is disbaled");
            log.info("PASS");
            testCaseJamaApiPass(getIncApiId());
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
            org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase005() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
            reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logInInvalid("asdvhyi", "123");
            reportTest.log(Status.INFO, "Login Attempt with invalid user");
            log.info("PASS");
            reportTest.log(Status.PASS, "Validation message displayed");
            testCaseJamaApiPass(getIncApiId());
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
            org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase006() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
            reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logInInvalid(finalEmail(), "lalala");
            reportTest.log(Status.INFO, "Login Attempt with invalid pw");
            log.info("PASS");
            reportTest.log(Status.PASS, "Validation message displayed");
            testCaseJamaApiPass(getIncApiId());
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
            org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase007() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        reportTest = extent.createTest(methodName); 
        try {
        driver.get(finalEnvironment()); 
        log.info("Opened: " + finalEnvironment());
        reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
        logInPgTest.logInInvalid("agomez@gmail.com", finalPass());
        reportTest.log(Status.INFO, "Login Attempt with invalid user");
        log.info("PASS");
        reportTest.log(Status.PASS, "Validation message displayed");
        testCaseJamaApiPass(getIncApiId());
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
            org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase008() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
            reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.rememberMeClickable();
            logInPgTest.clickRemMeChkBox();
            log.info("PASS");
            reportTest.log(Status.PASS, "Remember Me checkbox is selectable");
            testCaseJamaApiPass(getIncApiId());
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
            org.testng.Assert.fail("Test FAILED");
        }        
    }
    
    @Test(enabled = true)
    public void testCase009() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
            reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logInRemember(finalEmail(), finalPass());
            patientListPgTest.waitPgLoad();
            log.info("PASS");
            reportTest.log(Status.PASS, "Remember Me check box is checked username saved");
            testCaseJamaApiPass(getIncApiId());
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
            org.testng.Assert.fail("Test FAILED");
        }    
    }
    
    @Test(enabled = true)
    public void testCase010() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
            reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.clearLogInText();
            log.info("Cleared rememebered info");
            logInPgTest.logInRemember(finalEmail(), finalPass());
            patientListPgTest.waitPgLoad();
            log.info("PASS");
            reportTest.log(Status.PASS, "Remember Me check box is unchecked username not saved");
            testCaseJamaApiPass(getIncApiId());
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
            org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase011() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
            reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.clickResetPw();
            reportTest.log(Status.INFO, "Clicked Reset Password Link");
            resetpwLogInPgTest.checkResetPwElements();
            log.info("Page loaded");
            log.info("PASS");
            reportTest.log(Status.PASS, "Directed to reset finalPass()word page");
            testCaseJamaApiPass(getIncApiId());
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
            org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase012() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
            reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.clickResetPw();
            reportTest.log(Status.INFO, "Clicked Reset Password Link");
            resetpwLogInPgTest.checkResetPwElements();
            log.info("Elements present in page");
            log.info("PASS");
            reportTest.log(Status.PASS, "Elements in Reset Password page displayed");
            testCaseJamaApiPass(getIncApiId());
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
            org.testng.Assert.fail("Test FAILED");
        }        
    }
    
    @Test(enabled = true)
    public void testCase013() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        reportTest = extent.createTest(methodName); 
        try {
        driver.get(finalEnvironment()); 
        log.info("Opened: " + finalEnvironment());
        reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
        logInPgTest.clickResetPw();
        reportTest.log(Status.INFO, "Clicked Reset Password Link");
        resetpwLogInPgTest.checkResetPwElements();
        resetpwLogInPgTest.sendResetLink(finalEmail());        
        log.info("PASS");
        reportTest.log(Status.PASS, "Confirmation message displayed");
        testCaseJamaApiPass(getIncApiId());
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
            org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase014() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        reportTest = extent.createTest(methodName); 
        driver.get(finalEnvironment()); 
        log.info("Opened: " + finalEnvironment());
        reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
        logInPgTest.clickResetPw();
        reportTest.log(Status.INFO, "Clicked Reset Password Link");
        try {
            resetpwLogInPgTest.submitBtnClickable();
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
            org.testng.Assert.fail("Test FAILED");
        } catch (Exception e) {
            log.info("Submit Button not clickable");
            log.info("PASS");
            reportTest.log(Status.PASS, "Send Reset Link button is disabled");
            testCaseJamaApiPass(getIncApiId());
        }        
    }
    
    @Test(enabled = true)
    public void testCase015() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        reportTest = extent.createTest(methodName); 
        try {
        driver.get(finalEnvironment()); 
        log.info("Opened: " + finalEnvironment());
        reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
        logInPgTest.clickUserGuide();
        reportTest.log(Status.INFO, "Clicked User Guide link");
        reportTest.log(Status.PASS, "Directed to User Guide in new link");
        log.info("PASS");
        testCaseJamaApiPass(getIncApiId());
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
            org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase016() throws UnirestException {
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
            log.info("PASS");
            reportTest.log(Status.PASS, "Elements displayed on Patient Page");
            testCaseJamaApiPass(getIncApiId());
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
            org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase017() throws UnirestException {
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
            navBarFooterPgTest.searchNavBar("test3");
            reportTest.log(Status.INFO, "Searched Nav Bar: test3");
            log.info("PASS");
            reportTest.log(Status.PASS, "Search displayed all details");
            testCaseJamaApiPass(getIncApiId());
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
            org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase018() throws UnirestException {
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
            navBarFooterPgTest.searchNavBar("lala");
            reportTest.log(Status.INFO, "Searched Nav Bar with invalid patient name: lala");
            log.info("PASS");
            reportTest.log(Status.PASS, "No results found message displayed");
            testCaseJamaApiPass(getIncApiId());
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

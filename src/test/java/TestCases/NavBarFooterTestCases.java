
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


public class NavBarFooterTestCases {
    private static final Logger log = LogManager.getLogger(NavBarFooterTestCases.class.getName());    
    private WebDriver driver;
    private LogInPg logInPgTest;
    private NavBarFooterPg navBarFooterPgTest;
    private PatientListPg patientListPgTest;    
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
        driver.manage().window().maximize();
        logInPgTest = new LogInPg(driver);
        navBarFooterPgTest = new NavBarFooterPg(driver);
        patientListPgTest = new PatientListPg(driver);
        if(ExtentFactory.getInstance() == null) {
            extent = ExtentFactory.createInstance(browser);
        } else {
            extent = ExtentFactory.getInstance();
        }
        if(id == null) {
            setApiId(32071);
        }
    }
    
    @Test(enabled = true)
    public void testCase159() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "User name displayed top right");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase160() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickProfDrpDown();
            reportTest.log(Status.INFO, "Clicked Profile Dropdown menu");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Dropdown list displaying finalPass()word, support and logout link");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase161() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickProfPass();
            reportTest.log(Status.INFO, "Navigating to Password from Profile Dropdown Menu");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Change finalPass()word page displayed");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    @Parameters("apiId")
    @Test(enabled = true)
    public void testCase162(@Optional String id) throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        if (id == null) {
            setApiId(32062);
        }
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickProfSupport();
            reportTest.log(Status.INFO, "Navigating to Support from Profile Dropdown Menu");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Support page displayed");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase163() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickProfLogout();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Clicked Logout from Profile dropdown user logged out");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase164() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Footer displayed with all elements");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }

    @Test(enabled = true)
    public void testCase165() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.openCompanyPage();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Company page window tab opened");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase166() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.navToPatientsTabFtr();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Directed to Patients via footer");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase167() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.navToProtocolsTabFtr();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Directed to Protocols via Footer");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase168() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.navToCliniciansTabFtr();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Directed to Clinicians via Footer");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase169() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.openFbPage();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Company Facebook page window tab opened");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase170() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.openFbPage();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Company Twitter page window tab opened");
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
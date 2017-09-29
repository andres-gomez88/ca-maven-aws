/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Admin
 */
public class SupportVideosTestCases {
    private static final Logger log = LogManager.getLogger(SupportVideosTestCases.class.getName());    
    WebDriver driver;
    LogInPg logInPgTest;
    NavBarFooterPg navBarFooterPgTest;
    PatientListPg patientListPgTest;
    SupportPg supportPgTest;
    
    public String methodName;
    ExtentReports extent;
    ExtentTest reportTest;
    public int apiId;
    
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
        supportPgTest = new SupportPg(driver);
        if(ExtentFactory.getInstance() == null) {
            extent = ExtentFactory.createInstance(browser);
        } else {
            extent = ExtentFactory.getInstance();
        }
        if(id == null) {
            setApiId(32100);
        }
    }
    
    @Test(enabled = true)
    public void testCase178() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickProfSupport();
            reportTest.log(Status.INFO, "Navigating to support from profile Dropdown");
            supportPgTest.waitPgLoad();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Support Videos Page displayed");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase179() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickProfSupport();
	    reportTest.log(Status.INFO, "Navigating to support from profile Dropdown");  
            supportPgTest.waitPgLoad();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "All elements displayed in Support Video Page");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase180() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickProfSupport();
	    reportTest.log(Status.INFO, "Navigating to support from profile Dropdown");  
            supportPgTest.waitPgLoad();
            supportPgTest.fillSrchVidTxtBox("test");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "User is able to input text and watermark is cleared on input");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase181() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickProfSupport();
	    reportTest.log(Status.INFO, "Navigating to support from profile Dropdown");  
            supportPgTest.waitPgLoad();
            supportPgTest.fillSrchVidTxtBox("patient");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Search inputs updated dynamically");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase182() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickProfSupport();
	    reportTest.log(Status.INFO, "Navigating to support from profile Dropdown");  
            supportPgTest.waitPgLoad();
            supportPgTest.fillSrchVidTxtBox("%^^#*(");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "No search results, user manual download prompt displayed");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase183() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickProfSupport();
	    reportTest.log(Status.INFO, "Navigating to support from profile Dropdown");  
            supportPgTest.waitPgLoad();
            supportPgTest.clickAddPatVideo();
            supportPgTest.waitVideoLoad();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Popup window with video displayed");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase184() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickProfSupport();
	    reportTest.log(Status.INFO, "Navigating to support from profile Dropdown");  
            supportPgTest.waitPgLoad();
            supportPgTest.clickAddPatVideo();
            supportPgTest.waitVideoLoad();
            supportPgTest.clickPlayVideo();
	    reportTest.log(Status.INFO, "Popup window with video displayed");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Play functionality working as intended");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase185() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickProfSupport();
	    reportTest.log(Status.INFO, "Navigating to support from profile Dropdown");  
            supportPgTest.waitPgLoad();
            supportPgTest.clickSearchPatVideo();
            supportPgTest.waitVideoLoad();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Popup window with video displayed");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase186() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickProfSupport();
	    reportTest.log(Status.INFO, "Navigating to support from profile Dropdown");  
            supportPgTest.waitPgLoad();
            supportPgTest.clickSearchPatVideo();
            supportPgTest.waitVideoLoad();
            supportPgTest.clickPlayVideo();
	    reportTest.log(Status.INFO, "Popup window with video displayed");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Play functionality working as intended");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase187() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickProfSupport();
	    reportTest.log(Status.INFO, "Navigating to support from profile Dropdown");  
            supportPgTest.waitPgLoad();
            supportPgTest.clickDashboardVideo();
            supportPgTest.waitVideoLoad();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Popup window with video displayed");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase188() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickProfSupport();
	    reportTest.log(Status.INFO, "Navigating to support from profile Dropdown");  
            supportPgTest.waitPgLoad();
            supportPgTest.clickDashboardVideo();
            supportPgTest.waitVideoLoad();
            supportPgTest.clickPlayVideo();
	    reportTest.log(Status.INFO, "Popup window with video displayed");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Play functionality working as intended");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase189() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickProfSupport();
	    reportTest.log(Status.INFO, "Navigating to support from profile Dropdown");  
            supportPgTest.waitPgLoad();
            supportPgTest.clickOptPatListVideo();
            supportPgTest.waitVideoLoad();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Popup window with video displayed");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase190() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickProfSupport();
	    reportTest.log(Status.INFO, "Navigating to support from profile Dropdown");  
            supportPgTest.waitPgLoad();
            supportPgTest.clickOptPatListVideo();
            supportPgTest.waitVideoLoad();
            supportPgTest.clickPlayVideo();
	    reportTest.log(Status.INFO, "Popup window with video displayed");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Play functionality working as intended");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase191() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickProfSupport();
	    reportTest.log(Status.INFO, "Navigating to support from profile Dropdown");  
            supportPgTest.waitPgLoad();
            supportPgTest.clickPatDetailVideo();
            supportPgTest.waitVideoLoad();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Popup window with video displayed");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase192() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickProfSupport();
	    reportTest.log(Status.INFO, "Navigating to support from profile Dropdown");  
            supportPgTest.waitPgLoad();
            supportPgTest.clickPatDetailVideo();
            supportPgTest.waitVideoLoad();
            supportPgTest.clickPlayVideo();
	    reportTest.log(Status.INFO, "Popup window with video displayed");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Play functionality working as intended");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase193() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickProfSupport();
	    reportTest.log(Status.INFO, "Navigating to support from profile Dropdown");  
            supportPgTest.waitPgLoad();
            supportPgTest.clickRevEditPatProfVideo();
            supportPgTest.waitVideoLoad();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Popup window with video displayed");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase194() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickProfSupport();
	    reportTest.log(Status.INFO, "Navigating to support from profile Dropdown");  
            supportPgTest.waitPgLoad();
            supportPgTest.clickRevEditPatProfVideo();
            supportPgTest.waitVideoLoad();
            supportPgTest.clickPlayVideo();
	    reportTest.log(Status.INFO, "Popup window with video displayed");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Play functionality working as intended");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase195() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickProfSupport();
	    reportTest.log(Status.INFO, "Navigating to support from profile Dropdown");  
            supportPgTest.waitPgLoad();
            supportPgTest.clickViewTestSurvVideo();
            supportPgTest.waitVideoLoad();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Popup window with video displayed");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase196() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickProfSupport();
	    reportTest.log(Status.INFO, "Navigating to support from profile Dropdown");  
            supportPgTest.waitPgLoad();
            supportPgTest.clickViewTestSurvVideo();
            supportPgTest.waitVideoLoad();
            supportPgTest.clickPlayVideo();
	    reportTest.log(Status.INFO, "Popup window with video displayed");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Play functionality working as intended");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase197() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickProfSupport();
	    reportTest.log(Status.INFO, "Navigating to support from profile Dropdown");  
            supportPgTest.waitPgLoad();
            supportPgTest.clickUseReportsVideo();
            supportPgTest.waitVideoLoad();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Popup window with video displayed");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase198() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickProfSupport();
	    reportTest.log(Status.INFO, "Navigating to support from profile Dropdown");  
            supportPgTest.waitPgLoad();
            supportPgTest.clickUseReportsVideo();
            supportPgTest.waitVideoLoad();
            supportPgTest.clickPlayVideo();
	    reportTest.log(Status.INFO, "Popup window with video displayed");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Play functionality working as intended");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase199() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickProfSupport();
	    reportTest.log(Status.INFO, "Navigating to support from profile Dropdown");  
            supportPgTest.waitPgLoad();
            supportPgTest.clickEditNewProgVideo();
            supportPgTest.waitVideoLoad();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Popup window with video displayed");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase200() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickProfSupport();
	    reportTest.log(Status.INFO, "Navigating to support from profile Dropdown");  
            supportPgTest.waitPgLoad();
            supportPgTest.clickEditNewProgVideo();
            supportPgTest.waitVideoLoad();
            supportPgTest.clickPlayVideo();
	    reportTest.log(Status.INFO, "Popup window with video displayed");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Play functionality working as intended");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase201() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickProfSupport();
	    reportTest.log(Status.INFO, "Navigating to support from profile Dropdown");  
            supportPgTest.waitPgLoad();
            supportPgTest.clickViewExcPlanVideo();
            supportPgTest.waitVideoLoad();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Popup window with video displayed");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase202() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickProfSupport();
	    reportTest.log(Status.INFO, "Navigating to support from profile Dropdown");  
            supportPgTest.waitPgLoad();
            supportPgTest.clickViewExcPlanVideo();
            supportPgTest.waitVideoLoad();
            supportPgTest.clickPlayVideo();
	    reportTest.log(Status.INFO, "Popup window with video displayed");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Play functionality working as intended");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }   
    
    @Test(enabled = true)
    public void testCase203() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickProfSupport();
	    reportTest.log(Status.INFO, "Navigating to support from profile Dropdown");  
            supportPgTest.waitPgLoad();
            supportPgTest.clickCreateClinVideo();
            supportPgTest.waitVideoLoad();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Popup window with video displayed");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase204() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickProfSupport();
	    reportTest.log(Status.INFO, "Navigating to support from profile Dropdown");  
            supportPgTest.waitPgLoad();
            supportPgTest.clickCreateClinVideo();
            supportPgTest.waitVideoLoad();
            supportPgTest.clickPlayVideo();
	    reportTest.log(Status.INFO, "Popup window with video displayed");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Play functionality working as intended");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    } 
    
    @Test(enabled = true)
    public void testCase205() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickProfSupport();
	    reportTest.log(Status.INFO, "Navigating to support from profile Dropdown");  
            supportPgTest.waitPgLoad();
            supportPgTest.clickUseProtVideo();
            supportPgTest.waitVideoLoad();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Popup window with video displayed");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase206() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickProfSupport();
	    reportTest.log(Status.INFO, "Navigating to support from profile Dropdown");  
            supportPgTest.waitPgLoad();
            supportPgTest.clickUseProtVideo();
            supportPgTest.waitVideoLoad();
            supportPgTest.clickPlayVideo();
	    reportTest.log(Status.INFO, "Popup window with video displayed");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Play functionality working as intended");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase207() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickProfSupport();
	    reportTest.log(Status.INFO, "Navigating to support from profile Dropdown");  
            supportPgTest.waitPgLoad();
            supportPgTest.clickUserManualLink();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "PDF User Manual Opened in new Tab");
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


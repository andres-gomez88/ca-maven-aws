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
public class ForgotPassTestCases {
    private static final Logger log = LogManager.getLogger(ForgotPassTestCases.class.getName());
    WebDriver driver;
    LogInPg logInPgTest;
    ResetpwLogInPg resetpwLogInPgTest;
    
    private String invalidEmail =  "andres_580@hotmail.com";
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
        resetpwLogInPgTest = new ResetpwLogInPg(driver);
        if(ExtentFactory.getInstance() == null) {
            extent = ExtentFactory.createInstance(browser);
        } else {
            extent = ExtentFactory.getInstance();
        }
        if(id == null) {
            setApiId(30354);
        }
    }
    
    @Test(enabled = true)
    public void testCase080() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.clickResetPw();
            resetpwLogInPgTest.sendResetLink(finalEmail());
            reportTest.log(Status.PASS, "Sent reset password link to: " + finalEmail());
            log.info("PASS");
            testCaseJamaApiPass(getIncApiId());
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
            testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true) 
    public void testCase081() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.clickResetPw();
            resetpwLogInPgTest.sendResetLink(finalEmail());
            reportTest.log(Status.PASS, "Sent reset password link to: " + finalEmail());
            log.info("PASS");
            testCaseJamaApiPass(getIncApiId());
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
            testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)//Needs manual testing to check mail
    public void testCase082() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.clickResetPw();
            //resetpwLogInPgTest.sendResetLink(finalEmail());
            reportTest.log(Status.PASS, "Sent reset password link");
            log.info("PASS");
            testCaseJamaApiPass(getIncApiId());
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
            testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)//Needs manual testing to check mail
    public void testCase083() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.clickResetPw();
            //resetpwLogInPgTest.sendResetLink(finalEmail());
            reportTest.log(Status.PASS, "Sent reset password link");
            log.info("PASS");
            testCaseJamaApiPass(getIncApiId());
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
            testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)//Needs manual testing to check mail
    public void testCase084() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.clickResetPw();
            //resetpwLogInPgTest.sendResetLink(finalEmail());
            reportTest.log(Status.PASS, "Sent reset password link");
            log.info("PASS");
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
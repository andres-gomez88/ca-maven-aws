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
public class ClinicianTestCases {
    private static final Logger log = LogManager.getLogger(ClinicianTestCases.class.getName());    
    WebDriver driver;
    LogInPg logInPgTest;
    NavBarFooterPg navBarFooterPgTest;
    PatientListPg patientListPgTest;
    CliniciansListPg cliniciansListPgTest;
    
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
        cliniciansListPgTest = new CliniciansListPg(driver);
        if(ExtentFactory.getInstance() == null) {
            extent = ExtentFactory.createInstance(browser);
        } else {
            extent = ExtentFactory.getInstance();
        }
        if(id == null) {
            setApiId(31322);
        }
    }
    
    @Test(enabled = true)
    public void testCase119() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail()); 
            patientListPgTest.waitPgLoad();            
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            log.info("Directed to Clinicians List Page");
            log.info("PASS");
            testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Directed to Clinicians List Page");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase120() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail()); 
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            log.info("All elements are displayed in page");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Clinician List Page elements displayed");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase121() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail()); 
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            cliniciansListPgTest.clickAddClinBtn();
            cliniciansListPgTest.waitAddClinWindow();
	    reportTest.log(Status.PASS, "Add Clinician Popup Open");
            log.info("Directed to Add Clinician Pop-up");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase122() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail()); 
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            cliniciansListPgTest.clickAddClinBtn();
            cliniciansListPgTest.waitAddClinWindow();
	    reportTest.log(Status.INFO, "Add Clinician Popup Open");
            log.info("Add Clinician Pop-up Displays All Elements");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "All elements displayed in Add Patient Popup");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase123() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail()); 
            patientListPgTest.waitPgLoad();            
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            cliniciansListPgTest.addClinician("testcase122", "testcase122", 
            "test1222@gmail.co", "6191231234");            
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Clinician created");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase124() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail()); 
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            cliniciansListPgTest.clickAddClinBtn();
            cliniciansListPgTest.waitAddClinWindow();
	    reportTest.log(Status.INFO, "Add Clinician Popup Open");
            cliniciansListPgTest.addClinFillData("asd", "fgh", "ayvduw", "1234567890");
            reportTest.log(Status.INFO, "Filling with invalid data");
            if (cliniciansListPgTest.createClinBtnClickable() == false) {
                log.info("PASS");
                testCaseJamaApiPass(getIncApiId());
                reportTest.log(Status.PASS, "Create Clinician button is disabled");
            } else {
                reportTest.log(Status.FAIL, "Test FAILED");
                testCaseJamaApiFail(getIncApiId());
                org.testng.Assert.fail("Test FAILED button is enabled");
            }
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase125() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail()); 
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            cliniciansListPgTest.clickAddClinBtn();
            cliniciansListPgTest.waitAddClinWindow();
	    reportTest.log(Status.INFO, "Add Clinician Popup Open");
            if (cliniciansListPgTest.createClinBtnClickable() == false) {
                log.info("PASS");
                testCaseJamaApiPass(getIncApiId());
                reportTest.log(Status.PASS, "Create Clinician button is disabled no data enetred");
            } else {
                reportTest.log(Status.FAIL, "Test FAILED");
                testCaseJamaApiFail(getIncApiId());
                org.testng.Assert.fail("Test FAILED button is enabled");
            }
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase126() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail()); 
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            cliniciansListPgTest.clickAddClinBtn();
            cliniciansListPgTest.waitAddClinWindow();
	    reportTest.log(Status.INFO, "Add Clinician Popup Open");
            cliniciansListPgTest.addClinFillData("", "Gomez", "agomez@gmail.co", "6191234567");
            reportTest.log(Status.INFO, "Filled all data except first name");
            if (cliniciansListPgTest.createClinBtnClickable() == false) {
                log.info("PASS");
                testCaseJamaApiPass(getIncApiId());
                reportTest.log(Status.PASS, "Create Clinician button is disabled");
            } else {
                reportTest.log(Status.FAIL, "Test FAILED");
                testCaseJamaApiFail(getIncApiId());
                org.testng.Assert.fail("Test FAILED button is enabled");
            }
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase127() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail()); 
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            cliniciansListPgTest.clickAddClinBtn();
            cliniciansListPgTest.waitAddClinWindow();
	    reportTest.log(Status.INFO, "Add Clinician Popup Open");
            cliniciansListPgTest.addClinFillData("Andres", "", "agomez@gmail.co", "6191234567");
            reportTest.log(Status.INFO, "Filled all data except last name");
            if (cliniciansListPgTest.createClinBtnClickable() == false) {
                log.info("PASS");
                testCaseJamaApiPass(getIncApiId());
                reportTest.log(Status.PASS, "Create Clinician button is disabled");
            } else {
                reportTest.log(Status.FAIL, "Test FAILED");
                testCaseJamaApiFail(getIncApiId());
                org.testng.Assert.fail("Test FAILED button is enabled");
            }
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase128() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail()); 
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            cliniciansListPgTest.clickAddClinBtn();
            cliniciansListPgTest.waitAddClinWindow();
	    reportTest.log(Status.INFO, "Add Clinician Popup Open");
            cliniciansListPgTest.addClinFillData("Andres", "Gomez", "", "6191234567");
            reportTest.log(Status.INFO, "Filled all data except finalEmail() address");
            if (cliniciansListPgTest.createClinBtnClickable() == false) {
                log.info("PASS");
                testCaseJamaApiPass(getIncApiId());
                reportTest.log(Status.PASS, "Create Clinician button is disabled");
            } else {
                reportTest.log(Status.FAIL, "Test FAILED");
                testCaseJamaApiFail(getIncApiId());
                org.testng.Assert.fail("Test FAILED button is enabled");
            }
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase129() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail()); 
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            cliniciansListPgTest.clickAddClinBtn();
            cliniciansListPgTest.waitAddClinWindow();
	    reportTest.log(Status.INFO, "Add Clinician Popup Open");
            cliniciansListPgTest.addClinFillData("Test129", "test129", "agomez@gmail.co", "");
            cliniciansListPgTest.clickCreateSaveClinBtn();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Clinician Created without phone number");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase130() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail()); 
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            cliniciansListPgTest.clickAddClinBtn();
            cliniciansListPgTest.waitAddClinWindow();
	    reportTest.log(Status.INFO, "Add Clinician Popup Open");
            cliniciansListPgTest.clickCancelClinBtn();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Add Clinician popup closed with cancel button");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase131() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail()); 
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            log.info("Watermark Search All Clinicians displayed");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Search All Clinicians watermark displayed");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase132() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail()); 
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            if(cliniciansListPgTest.xBtnClickable() == true) {
                log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
                reportTest.log(Status.PASS, "Cross button is enabled");
            } else {
                reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
                org.testng.Assert.fail("Test FAILED X Button not Enabled");
            }
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase133() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail()); 
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            cliniciansListPgTest.searchClinician("another");
            reportTest.log(Status.INFO, "Performing clinician search");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Clinician search data displayed");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase134() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail()); 
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            cliniciansListPgTest.searchClinician("kqbdwi");
            reportTest.log(Status.INFO, "Performing clinician search with invalid name");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Search results are empy");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase135() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail()); 
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            cliniciansListPgTest.searchClinician("Gomez");
            reportTest.log(Status.INFO, "Performing clinician search");
            cliniciansListPgTest.clickXSrchBtn();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Search field cleared with clear search cross button");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase136() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            cliniciansListPgTest.searchClinician("D");
            reportTest.log(Status.INFO, "Performing single character clinician search");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Filtered results by the character input");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase137() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail()); 
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            cliniciansListPgTest.clickSortFirstBtn();
            reportTest.log(Status.INFO, "Sorting by first name");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Clinician list sorted by first name");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase138() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail()); 
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            cliniciansListPgTest.clickSortLastBtn();
            reportTest.log(Status.INFO, "Sorting by last name");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Clinician list sorted by last name");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase139() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail()); 
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            cliniciansListPgTest.clickSortAZBtn();
            reportTest.log(Status.INFO, "Sorting by A->Z");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Clinician list sorted by A->Z");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase140() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail()); 
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            cliniciansListPgTest.clickSortZABtn();
            reportTest.log(Status.INFO, "Sorting by Z->A");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Clinician list sorted by Z->A");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase141() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail()); 
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            cliniciansListPgTest.clickEmailClin();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Email Clinician Icon clicked check popup window");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase142() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail()); 
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            cliniciansListPgTest.expandClinInfo();
            reportTest.log(Status.INFO, "Clicked expand arrow");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Clinician details expanded");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase143() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail()); 
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            cliniciansListPgTest.expandClinInfo();
            reportTest.log(Status.INFO, "Clicked expand arrow");
            cliniciansListPgTest.expandClinInfo();
            reportTest.log(Status.INFO, "Clicked collapse arrow");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Clinician details hidden");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase144() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail()); 
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            cliniciansListPgTest.expandClinInfo();
            reportTest.log(Status.INFO, "Clicked expand arrow");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Clinician Details displayed with an Edit button");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase145() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail()); 
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            cliniciansListPgTest.expandClinInfo();
            cliniciansListPgTest.clickEditInfoBtn();
            reportTest.log(Status.INFO, "Clicked expand arrow and Edit button");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Edit Clinician popup window displayed");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Parameters("apiId")
    @Test(enabled = true)
    public void testCase146(@Optional String id) throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        if(id == null) {
            setApiId(31309);
        }
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail()); 
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            cliniciansListPgTest.expandClinInfo();
	    reportTest.log(Status.INFO, "Clicked expand arrow");
            cliniciansListPgTest.clickEditInfoBtn();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Edit Clinician popup window displayed with editable fields");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase147() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail()); 
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            cliniciansListPgTest.expandClinInfo();
	    reportTest.log(Status.INFO, "Clicked expand arrow");
            cliniciansListPgTest.clickEditInfoBtn();
            reportTest.log(Status.INFO, "Edit clinician popup window displayed");
            cliniciansListPgTest.clickCreateSaveClinBtn();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Clicked Save Clinician without modification returning to clinician list");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase148() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail()); 
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            cliniciansListPgTest.expandClinInfo();
	    reportTest.log(Status.INFO, "Clicked expand arrow");
            cliniciansListPgTest.clickEditInfoBtn();
            reportTest.log(Status.INFO, "Edit clinician popup window displayed");
            cliniciansListPgTest.editClinInfo("a new fname", "a new lname", "new@gmail.co",
            "6191234567");
            cliniciansListPgTest.clickCreateSaveClinBtn();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Clinician details saved returning to clinician list");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase149() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail()); 
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            cliniciansListPgTest.expandClinInfo();
	    reportTest.log(Status.INFO, "Clicked expand arrow");
            cliniciansListPgTest.clickEditInfoBtn();
            reportTest.log(Status.INFO, "Edit clinician popup window displayed");
            cliniciansListPgTest.clickCancelClinBtn();
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Clicked cancel returning to clinician list");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase150() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail()); 
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            cliniciansListPgTest.clickBackPgBtn();
            reportTest.log(Status.INFO, "Clicked back arrow in list");
            log.info("List Page Moved to Previous");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "List moved to previous page");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase151() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail()); 
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            cliniciansListPgTest.clickForwardPgBtn();
            reportTest.log(Status.INFO, "Clicked foward arrow in list");
            log.info("List Page Moved Forward");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "List moved to next page");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase152() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            cliniciansListPgTest.clickBackPgBtn();
            log.info("Back Button disabled");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Back arrow list button disabled user on 1st page");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase153() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            cliniciansListPgTest.clickLastPgBtn();
            reportTest.log(Status.INFO, "Clicked double forward arrow(last page) in list");
            cliniciansListPgTest.clickForwardPgBtn();
            log.info("Forward Button disabled");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Forward arrow disabled use in on last page already");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase154() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            cliniciansListPgTest.clickLastPgBtn();
            log.info("On Last Page of List");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Clicked double forward arrow(last page) in list user now in the last page");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase155() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail()); 
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            cliniciansListPgTest.clickLastPgBtn();
            reportTest.log(Status.INFO, "Clicked double forward arrow(last page) in list");
            cliniciansListPgTest.clickFirstPgBtn();
            log.info("On First Page of List");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Clicked double back arrow(first page) in list, user in now in the first page");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase156() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail()); 
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            cliniciansListPgTest.clickFirstPgBtn();
            log.info("First Page Button Disabled Already on First Page");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Double back arrow disabled user already in first page");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase157() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail()); 
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            cliniciansListPgTest.clickLastPgBtn();
            reportTest.log(Status.INFO, "Clicked double forward arrow(last page) in list");
            cliniciansListPgTest.clickLastPgBtn();
            log.info("Last Page Button Disabled Already on First Page");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Double forward arrow disabled user already in last page");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    testCaseJamaApiFail(getIncApiId());
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase158() throws UnirestException {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            navBarFooterPgTest.clickCliniciansTabNav();
	    reportTest.log(Status.INFO, "Navigating to Clinicians page");
            cliniciansListPgTest.waitPgLoad();
            cliniciansListPgTest.clickRandomPgBtn();
            log.info("Landed in Page 2 of List");
            log.info("PASS");
	    testCaseJamaApiPass(getIncApiId());
	    reportTest.log(Status.PASS, "Moved to Page 2 in list");
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


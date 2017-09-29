/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pageObjects;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Keys;
import pageObjects.LogInPg;
import pageObjects.ResetpwLogInPg;
import pageObjects.NavBarFooterPg;
import pageObjects.PatientListPg;
import pageObjects.ProtocolsListPg;
import pageObjects.CliniciansListPg;
import pageObjects.AddPatientPg;
import pageObjects.ChangePwPg;
import pageObjects.ExercisePlanPg;
import pageObjects.TestSurveysPg;
import pageObjects.ReportsPg;
import pageObjects.ProfilePg;
import pageObjects.SupportPg;
import pageObjects.CreateEditProgramPg;
import pageObjects.CreateEditProtocolPg;
import static Utilities.WaitUtilities.*;
/**
 *
 * @author Admin
 */
public class testPgObj {
    static WebDriver driver;
    
    static LogInPg logInPgTest;
    static ResetpwLogInPg resetpwLogInPgTest;
    static NavBarFooterPg navBarFooterPgTest;
    static PatientListPg patientListPgTest; 
    static ProtocolsListPg protocolsListPgTest;
    static CliniciansListPg cliniciansListPgTest;
    static AddPatientPg addPatientPgTest;
    static ChangePwPg changePwPgTest;
    static ExercisePlanPg exercisePlanPgTest;
    static TestSurveysPg testSurveysPgTest;
    static ReportsPg reportsPgTest;
    static ProfilePg profilePgTest;
    static SupportPg supportPgTest;
    static CreateEditProgramPg createEditProgramPgTest;
    static CreateEditProtocolPg createEditProtocolPgTest;
    
    public static void main(String[] args) throws InterruptedException {
        String prever = "https://prerelease-wc.prod.reflexionhealth.com";
        String testver = "https://test-wc.test.reflexionhealth.com";
        String exePath = "C:\\seleniumdriver\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", exePath);
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(testver);
        
    }   
    
}


package pageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static Utilities.WaitUtilities.*;


public class NavBarFooterPg {
    WebDriver driver;
    PatientListPg patientListPgTest;
    List<WebElement> navBarElements;
    private static final Logger log = LogManager.getLogger(NavBarFooterPg.class.getName());
    
    //Navigation Bar    
    @FindBy(xpath = "//*[@id='navbar']/div/div[1]/button")
    WebElement searchClickNavBar;
    
    @FindBy(xpath = "//div[@id='navbar']//input")
    WebElement searchTxtBoxNavBar;
    
    @FindBy(xpath = "//*[@id='navbar']/div/ul/li[1]/a")
    WebElement patientsNavBar;
    
    @FindBy(xpath = "//*[@id='navbar']/div/ul/li[2]/a")
    WebElement protocolsNavBar;
    
    @FindBy(xpath = "//*[@id='navbar']/div/ul/li[3]/a")
    WebElement cliniciansNavBar;
    
    @FindBy(xpath = "//button[text()='Add Patient']")
    WebElement addPatientNavBar;
    
    @FindBy(xpath = "//div[@class='notification-toggle']")
    WebElement notificationsNavBar;
    
    @FindBy(xpath = "//div[@class='nav-dropdown']")
    WebElement userNavBar;
    
    //Navigation Drop-down
    @FindBy(xpath = "//ul[@class='nav-menu']/li[1]")
    WebElement passwordDrpDown;
    
    @FindBy(xpath = "//li[@class='help-button']")
    WebElement supportDrpDown;
    
    @FindBy(xpath = "//li[@class='sign-out']")
    WebElement logoutDrpDown;
    
    //Bottom Footer
    @FindBy(xpath = "//img")
    WebElement footerCompPage;
    
    @FindBy(xpath = "//ul[@class='bottom-links']//a[text()='Patients']")
    WebElement patientsFooter;
    
    @FindBy(xpath = "//ul[@class='bottom-links']//a[text()='Protocols']")
    WebElement protocolsFooter;
    
    @FindBy(xpath = "//ul[@class='bottom-links']//a[text()='Clinicians']")
    WebElement cliniciansFooter;
    
    @FindBy(xpath = "//a[@class='fa fa-facebook']")
    WebElement footerFB;
    
    @FindBy(xpath = "//a[@class='fa fa-twitter']")
    WebElement footerTwitter;
    
    public NavBarFooterPg(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.patientListPgTest = new PatientListPg(driver);
        this.navBarElements = new ArrayList<>(Arrays.asList(patientsNavBar,
        protocolsNavBar, cliniciansNavBar, addPatientNavBar));
    }
    
    public void searchNavBar(String input) throws InterruptedException {
        clickSrchNavBar();
        waitForVisibility(searchTxtBoxNavBar, 3, driver);
        Thread.sleep(1000);
        searchTxtBoxNavBar.sendKeys(input, Keys.ENTER);
        log.info("Entered for Search: " + input);
        patientListPgTest.waitPgLoad();
    }
    
    public void clickSrchNavBar() {
        searchClickNavBar.click();
        log.info("Clicked Search Button in Navigation");
    }
    public void clickPatientsTabNav() {
        patientsNavBar.click();
        log.info("Clicked Patients Nav Tab");
    }
    
    public void clickProtocolsTabNav() {
        protocolsNavBar.click();        
        log.info("Clicked Protocols Nav Tab");
    }
    
    public void clickCliniciansTabNav() {
        //cliniciansNavBar.click();
        cliniciansNavBar.sendKeys(Keys.ENTER);
        log.info("Clicked Clinicians Nav Tab");
        //Thread.sleep(1000);
    }
    
    public void clickAddPatientBtn() {
        addPatientNavBar.click();
        log.info("Clicked Add Patient Button");
    }
    
    public void viewNotifications() {
        notificationsNavBar.click();
    }
    
    public void clickProfDrpDown() {
        userNavBar.click();
        log.info("Clicked Profile Drop Down Menu");
    }
    
    public void clickProfPass() {
        clickProfDrpDown();
        passwordDrpDown.click();
        log.info("Clicked Password Option");
    }
    
    public void clickProfSupport() {
        clickProfDrpDown();
        supportDrpDown.click();
        log.info("Clicked Support Option");
    }
    
    public void clickProfLogout() {
        clickProfDrpDown();
        logoutDrpDown.click();
        log.info("Clicked Logout Option");
    }
    
    public void openCompanyPage() {
        footerCompPage.click();
        log.info("Clicked Reflection Health Company Link");
    }
    
    public void navToPatientsTabFtr() {
        patientsFooter.click();
        log.info("Clicked Patients Footer Link");
    }
    
    public void navToProtocolsTabFtr() {
        protocolsFooter.click();
        log.info("Clicked Protocols Footer Link");
    }
    
    public void navToCliniciansTabFtr() {
        cliniciansFooter.click();
        log.info("Clicked Clinicians Footer Link");
    }
    
    public void openFbPage() {
        footerFB.click();
        log.info("Clicked Facebook Footer Link");
    }
    
    public void openTwitterPage() {
        footerTwitter.click();
        log.info("Clicked Twitter Footer Link");
    }
    
    public WebElement getSearchClickNavBar() {
        return searchClickNavBar;
    }
    
    public void waitNavBarLoad() {
        waitForVisibilityList(navBarElements, 7, driver);
    }
    
    public void waitClinNavBar() {
        waitForVisibility(cliniciansNavBar, 7, driver);
    }
    
    public void waitProfileMenu() {
        waitForVisibility(passwordDrpDown, 2, driver);
    }
    
}

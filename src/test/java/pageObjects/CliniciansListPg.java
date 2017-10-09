
package pageObjects;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
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


public class CliniciansListPg {
    WebDriver driver;
    List<WebElement> addClinElements;
    private static final Logger log = LogManager.getLogger(CliniciansListPg.class.getName());
    ExtentTest reportTest;
    
    //Clinician Search Bar
    @FindBy(xpath = "//input[@ng-model='vm.query']")
    WebElement clinicianSearchTxtBox;
    
    @FindBy(xpath = "//div[@id='clinician-list']//span/a")
    WebElement clearSearchBtn;
    
    @FindBy(xpath = "//button[text()='Add Clinician']")
    WebElement addClinicianBtn;
    
    @FindBy(xpath = "//a[text()='First']")
    WebElement sortFirstBtn;
    
    @FindBy(xpath = "//a[text()='Last']")
    WebElement sortLastBtn;
    
    @FindBy(xpath = "//div[@class='btn-group'][2]//a[1]")
    WebElement sortAZBtn;
    
    @FindBy(xpath = "//div[@class='btn-group'][2]//a[2]")
    WebElement sortZABtn;
    
    /**
     * Clinician row
     * xpath of row = "//div[@id='clinician-list']//section[n]"
     * n =  row number
     */
    @FindBy(xpath = "//div[@id='clinician-list']//section[1]//a[@ng-click='vm.toggleExpanded(clinician)']")
    WebElement clinicianInfoRow;
    
    @FindBy(xpath = "//div[@id='clinician-list']//section[1]//input[@value='Edit']")
    WebElement editInfoBtnRow;
    
    @FindBy(xpath = "//div[@id='clinician-list']//section[1]//a[@analytics-event='Email Clinician']")
    WebElement sendEmailRow;
    
    //Edit/Create Clinician Info Popup
    @FindBy(xpath = "//div[@class='form-group'][1]/input")
    WebElement clinicianFName;
    
    @FindBy(xpath = "//div[@class='form-group'][2]/input")
    WebElement clinicianLName;
    
    @FindBy(xpath = "//div[@class='form-group'][3]/input")
    WebElement clinicianEmail;
    
    @FindBy(xpath = "//div[@class='form-group'][4]/input")
    WebElement clinicianPhone;
    
    @FindBy(xpath = "//div[@class='modal-footer ng-scope']//button[2]")
    WebElement createSaveClinBtn;
    
    @FindBy(xpath = "//div[@class='modal-footer ng-scope']//button[1]")
    WebElement cancelClinBtn;
    
    //List Navigation   
    @FindBy(xpath = "//a[text()='«']")
    WebElement firstPgNavBtn;
    
    @FindBy(xpath = "//a[text()='‹']")
    WebElement backPgNavBtn;
    
    @FindBy(xpath = "//a[text()='›']")
    WebElement forwardPgNavBtn;
    
    @FindBy(xpath = "//a[text()='»']")
    WebElement lastPgNavBtn;
    
    @FindBy(xpath = "//*[@id='clinician-list']/div[4]/span/ul/li[4]/a")
    WebElement randomPgBtn;
    
    public CliniciansListPg(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.addClinElements = new ArrayList<>(Arrays.asList(clinicianFName));
    }
    
    public void waitPgLoad() {
        waitForVisibility(clinicianInfoRow, 7, driver);
    }
    
    public void addClinician(String afName, String alName, String aEmail, String aPhoneNum) {
        try {
            addClinicianBtn.click();
            log.info("Clicked Add Clinician Button");
            waitForVisibility(clinicianFName, 5, driver);
            clinicianFName.sendKeys(afName);
            log.info("Entered first name: " + afName);
            clinicianLName.sendKeys(alName);
            log.info("Entered last name: " + alName);
            clinicianEmail.sendKeys(aEmail);
            log.info("Entered email: " + aEmail);
            clinicianPhone.sendKeys(aPhoneNum, Keys.ENTER);
            log.info("Entered phone number: " + aPhoneNum);
            createSaveClinBtn.click();
            log.info("Clicked Create Clinician Button");
            waitForNoVisibility(addClinElements, 6, driver);
            log.info("Clinician " + afName + " " + alName + " successfully created");
        } catch (Exception e) {
            log.warn("Clinician " + afName + " " + alName + " not created");
            cancelClinBtn.click();
            log.info("Clicked Cancel Button");
            reportTest.log(Status.FAIL, "Test FAILED");
            org.testng.Assert.fail("Test FAILED");
        }
    }
    
    public void addClinFillData(String afName, String alName, String aEmail, String aPhoneNum) {
        clinicianFName.sendKeys(afName);
        log.info("Entered first name: " + afName);
        clinicianLName.sendKeys(alName);
        log.info("Entered last name: " + alName);
        clinicianEmail.sendKeys(aEmail);
        log.info("Entered email: " + aEmail);
        clinicianPhone.sendKeys(aPhoneNum, Keys.ENTER);
        log.info("Entered phone number: " + aPhoneNum);
    }
    
    public void clickAddClinBtn() {
        addClinicianBtn.click();
        log.info("Clicked Add Clinician Button");
    }
    
    public void waitAddClinWindow() {
        waitForVisibility(clinicianFName, 8, driver);
    }
    
    public Boolean createClinBtnClickable() {
        Boolean clickable;    
        try {
            waitForClick(createSaveClinBtn, 2, driver);
            log.info("Create Clinician Button Clickable");
            clickable = true;
        } catch (Exception e) {
            log.info("Create Clinician Button not Clickable");
            clickable = false;
        }
        return clickable;
    }
    
    public Boolean xBtnClickable() {
        Boolean clickable;    
        try {
            waitForClick(clearSearchBtn, 2, driver);
            log.info("Cross(X) Button Clickable");
            clickable = true;
        } catch (Exception e) {
            log.info("Cross(X) Button not Clickable");
            clickable = false;
        }
        return clickable;
    }
    
    public void searchClinician(String input) {
        clinicianSearchTxtBox.sendKeys(input);
        log.info("Searched for Clinician: " + input);
    }
    
    public void clickXSrchBtn() {
        clearSearchBtn.click();
        log.info("Clicked X Clear Search Button");
    }
    
    public void clickSortFirstBtn() {
        sortFirstBtn.click();
        log.info("Clicked First Name Sort Button");
    }
    
    public void clickSortLastBtn() {
        sortLastBtn.click();
        log.info("Clicked Last Name Sort Button");
    }
    
    public void clickSortAZBtn() {
        sortAZBtn.click();
        log.info("Clicked AZ Sort Button");
    }
    
    public void clickSortZABtn() {
        sortZABtn.click();
        log.info("Clicked ZA Sort Button");
    }
    
    public void clickEmailClin() {
        sendEmailRow.click();
        log.info("Clicked Email Clinician Button");
    }
    
    public void expandClinInfo() {
        clinicianInfoRow.click();
        log.info("Clicked Expand Arrow for Clinician Details");
    }
    
    public void clickEditInfoBtn() {
        editInfoBtnRow.click();
        log.info("Clicked Edit Button");
    }
    
    public void clickCancelClinBtn() {
        cancelClinBtn.click();
        log.info("Clicked Cancel Clinician Edit Pop-up");
    }
    
    public void clickCreateSaveClinBtn() {
        createSaveClinBtn.click();
        log.info("Clicked Save Button");
    }
    
    public void editClinInfo(String fName, String lName, String email, String phone) {
        waitForVisibility(clinicianFName, 5, driver);
        clinicianFName.clear(); clinicianLName.clear(); clinicianEmail.clear();
        clinicianPhone.clear();
        clinicianFName.sendKeys(fName);
        log.info("Edited first name: " + fName);
        clinicianLName.sendKeys(lName);
        log.info("Edited last name: " + lName);
        clinicianEmail.sendKeys(email);
        log.info("Edited email: " + email);
        clinicianPhone.sendKeys(phone, Keys.ENTER);
        log.info("Edited phone number: " + phone);
    }
    
    public void clickBackPgBtn() {
        backPgNavBtn.click();
        log.info("Clicked Back Arrow Button");
    }
    
    public void clickForwardPgBtn() {
        forwardPgNavBtn.click();
        log.info("Clicked Forward Arrow Button");
    }
    
    public void clickFirstPgBtn() {
        firstPgNavBtn.click();
        log.info("Clicked First Page Button");
    }
    
    public void clickLastPgBtn() {
        lastPgNavBtn.click();
        log.info("Clicked Last Page Button");
    }
    
    public void clickRandomPgBtn() {
        randomPgBtn.click();
        log.info("Clicked Random Page Button");
    }
}

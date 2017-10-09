
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


public class AddPatientPg {    
    WebDriver driver;
    List<WebElement> btnElements;
    private static final Logger log = LogManager.getLogger(AddPatientPg.class.getName());
    
    //Patient Information
    @FindBy(name = "first_name")
    WebElement firstName; // Locating WebElement by name
    
    @FindBy(name = "last_name")
    WebElement lastName;
    
    @FindBy(xpath = "//*[@id='patient-add']//article[1]/rflx-select[1]/div/div/span")
    WebElement genderClick; // Locating WebElement by X-Path
    
    @FindBy(xpath = "//input[@placeholder='Gender']")
    WebElement gender;
    
    @FindBy(xpath = "//*[@id='birth-date-input']//div[1]/rflx-select/div/div/span")
    WebElement dobMClick;
    
    @FindBy(xpath = "//input[@placeholder='MM']")
    WebElement dobM;
    
    @FindBy(xpath = "//*[@id='birth-date-input']//div[2]/rflx-select/div/div/span/span[1]")
    WebElement dobDClick;
    
    @FindBy(xpath = "//input[@placeholder='DD']")
    WebElement dobD;
    
    @FindBy(xpath = "//*[@id='birth-date-input']//div[3]/rflx-select/div/div/span/span[1]")
    WebElement dobYClick;
    
    @FindBy(xpath = "//input[@placeholder='YYYY']")
    WebElement dobY;
    
    @FindBy(name = "email")
    WebElement email;
    
    @FindBy(name = "phone_number")
    WebElement primPhoneNum;
    
    @FindBy(xpath = "//label[contains(text(),'no email')]")
    WebElement noEmailChkBox;
    
    @FindBy(name = "other_phone_number")
    WebElement secPhoneNum;
    
    @FindBy(name = "address_line1")
    WebElement addressLine1;
    
    @FindBy(name = "address_line2")
    WebElement addressLine2;
    
    @FindBy(name = "city")
    WebElement city;
    
    @FindBy(xpath = "//*[@id='patient-add']//article[1]/rflx-select[2]/div/div/span")
    WebElement stateClick;
    
    @FindBy(xpath = "//input[@placeholder='State']")
    WebElement state;
    
    @FindBy(name = "zip")
    WebElement zipcode;
    
    @FindBy(xpath = "//label[contains(text(),'demo')]")
    WebElement demoChkBox;
    
    //Buttons
    @FindBy(xpath = "//footer//button[1]")
    WebElement cancelBtn;
    
    @FindBy(xpath = "//footer//button[4]")
    WebElement doneBtn;
    
    @FindBy(xpath = "//footer//button[3]")
    WebElement nextBtn;
    
    @FindBy(xpath = "//footer//button[2]")
    WebElement backBtn;
    
    @FindBy(xpath = "//footer//button[5]")
    WebElement createPatBtn;
    
    @FindBy(xpath = "//section[@id='patient-add']/header/button")
    WebElement closeAddPatBtn;
    
    @FindBy(xpath = "//div[@class='modal-footer ng-scope']/button[2]")
    WebElement yesCloseAddBtn;
    
    @FindBy(xpath  = "//div[@class='modal-footer ng-scope']/button[1]")
    WebElement noCloseAddBtn;
    
    //Clinical Information
    @FindBy(name = "medical_id")
    WebElement medicalRecNum;
    
    @FindBy(xpath = "//*[@id='patient-add']//article[2]/rflx-select[1]/div/div/span")
    WebElement diagnosisClick;
    
    @FindBy(xpath = "//input[@placeholder='Diagnosis']")
    WebElement diagnosis;
    
    @FindBy(xpath = "//*[@id='patient-add']//article[2]/rflx-select[2]/div/div/span")
    WebElement biasClick;
    
    @FindBy(xpath = "//input[@placeholder='Bias']")
    WebElement bias;
    
    @FindBy(xpath = "//textarea[@placeholder='Diagnosis notes']")
    WebElement diagnosisNotes;
    
    @FindBy(xpath = "//*[@id='patient-add']//article[2]/rflx-select[3]/div/div/span")
    WebElement clinicianClick;
    
    @FindBy(xpath = "//input[@placeholder='Clinician']")
    WebElement clinician;
    
    @FindBy(xpath = "//input[@placeholder='Care Team']")
    WebElement careTeam;
    
    @FindBy(name = "surgeon")
    WebElement surgeonName;
    
    @FindBy(name = "injury_date")
    WebElement injuryDate;
    
    @FindBy(name = "surgery_date")
    WebElement surgeryDate;
    
    //Kit Installation
    @FindBy(xpath = "//label[text()='Yes']")
    WebElement kitInstYesChkBox;
    
    @FindBy(xpath = "//label[text()='No']")
    WebElement kitInstNoChkBox;
    
    @FindBy(xpath = "//label[contains(text(),'Use home')]")
    WebElement useHomeAddrChkBox;
    
    @FindBy(name = "install_address_line1")
    WebElement instAddrLine1;
    
    @FindBy(name = "install_address_line2")
    WebElement instAddrLine2;
    
    @FindBy(name = "install_city")
    WebElement instCity;
    
    @FindBy(xpath = "//*[@id='patient-add']//article[3]/rflx-select/div/div/span")
    WebElement instStateClick;
    
    @FindBy(xpath = "//*[@id='patient-add']/form/article[3]/rflx-select/div/input[1]")
    WebElement instState;
    
    @FindBy(name = "install_zip")
    WebElement instZipcode;
    
    //Patient Password Window
    @FindBy(xpath = "//button[text()='Send Email']")
    WebElement sendEmailPwBtn;
    
    @FindBy(xpath = "//button[text()='Generate Password']")
    WebElement generatePwBtn;
    
    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement cancelPwBtn;
    
    @FindBy(xpath = "//i[contains(@class,'fa-print')]")
    WebElement printPwBtn;
    
    @FindBy(xpath = "//button[text()='OK']")
    WebElement okBtn;
    
    @FindBy(xpath = "//button[@class='close']")
    WebElement closeBtn;
    
    @FindBy(xpath = "//div[@ng-show='passwordComplete']/div[2]/span[2]")//Need to wait time for generated pw
    WebElement genPwField;
    
    @FindBy(xpath = "//div[@ng-show='passwordComplete']/div[1]/span[2]")
    WebElement genEmailField;
    
    public AddPatientPg(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        //List of WebElements to check visibility
        this.btnElements = new ArrayList<>(Arrays.asList(nextBtn, backBtn));
    }
    
    public void addBasicPatient(String afName, String alName, String aGender, 
    String adobM, String adobD, String adobY, String aEmail) {
        try {
            waitPgLoad();
            firstName.sendKeys(afName); 
            log.info("Entered first name: " + afName);
            lastName.sendKeys(alName);
            log.info("Entered last name: " + alName);
            genderClick.click();
            // Fill Gender
            gender.sendKeys(aGender, Keys.ENTER);
            log.info("Entered Gender: " + aGender);
            // Fill DOB Month
            dobMClick.click();
            dobM.sendKeys(adobM, Keys.ENTER);
            // Fill DOB Day
            dobDClick.click();
            dobD.sendKeys(adobD, Keys.ENTER);
            // Fill DOB Year
            dobYClick.click();
            dobY.sendKeys(adobY, Keys.ENTER);
            log.info("Entered DOB: " + adobM + "/" + adobD + "/" + adobY);
            email.sendKeys(aEmail + Keys.ENTER);
            log.info("Entered email: " + aEmail);
            doneBtn.click();
            log.info("Clicked Done button");
            waitForVisibility(createPatBtn, 5, driver);
            createPatBtn.click();
            Thread.sleep(1000);
            log.info("Clicked Create Patient Button");
            waitForVisibility(generatePwBtn, 7, driver);
            generatePwBtn.click();
            log.info("Clicked Generate Pw Button");
            waitForVisibility(okBtn, 5, driver);
            okBtn.click();
            log.info("Patient " + afName + " " + alName + " successfully created");           
        } catch (Exception e) {            
            log.warn("Patient " + afName + " " + alName + " not created");
            waitForVisibility(closeAddPatBtn, 8, driver);
            closeAddPatBtn.click();
            log.info("Clicked X To Close Add Patient Window");
            waitForVisibility(yesCloseAddBtn, 5, driver);
            yesCloseAddBtn.click();
            log.info("Clicked Yes button to exit");
            waitForNoVisibility(btnElements, 6, driver);
            org.testng.Assert.fail("Test FAILED");
        }
    }
    
    public void clearPatientInfo() {
        firstName.clear();
        lastName.clear();
    }
    
    public void clickCancelAddBtn() {
        cancelBtn.click();
        log.info("Clicked Cancel Button");
    }
    
    public void fillName(String name) {
        firstName.sendKeys(name);
        log.info("Enetred first name: " + name);
    }
    
    public void clickNoUnsavedCh() {
        noCloseAddBtn.click();
        log.info("Clicked No Button to Cancel");
    }
    
    public void clickYesUnsavedCh() {
        yesCloseAddBtn.click();
        log.info("Clicked Yes Button to Cancel");
    }
    
    public void waitPgLoad() {
        waitForVisibility(firstName, 5, driver);
    }
    
    public Boolean doneBtnClickable() {
        Boolean clickable;    
        try {
            waitForClick(doneBtn, 2, driver);
            log.info("Done Button Clickable");
            clickable = true;
        } catch (Exception e) {
            log.info("Done Button not Clickable");
            clickable = false;
        }
        return clickable;
    }
    
    public void fillBasicInfo(String afName, String alName, String aGender, 
    String adobM, String adobD, String adobY, String aEmail) {
        try {
            waitPgLoad();
            firstName.sendKeys(afName);
            log.info("Entered first name: " + afName);
            lastName.sendKeys(alName);
            log.info("Entered last name: " + alName);
            genderClick.click();
            gender.sendKeys(aGender, Keys.ENTER);
            log.info("Entered Gender: " + aGender);
            dobMClick.click();
            dobM.sendKeys(adobM, Keys.ENTER);
            dobDClick.click();
            dobD.sendKeys(adobD, Keys.ENTER);
            dobYClick.click();
            dobY.sendKeys(adobY, Keys.ENTER);
            log.info("Entered DOB: " + adobM + "/" + adobD + "/" + adobY);
            email.sendKeys(aEmail + Keys.ENTER);
            log.info("Entered email: " + aEmail);
        } catch (Exception e) {
            org.testng.Assert.fail("Test FAILED, Error inputing info");
        }
    }
    
    public void clickDoneBtn() {
        doneBtn.click();
        log.info("Clicked Done Button");
    }
    
    public void clickCreatePatBtn() {
        createPatBtn.click();
        log.info("Clicked Create Patient Button");
    }
    
    public void clickSendMailBtn() {
        sendEmailPwBtn.click();
        log.info("Clicked Send Mail Button");
    }
    
    public void waitForVerifySavePg() {
        waitForVisibility(createPatBtn, 3, driver);
    }
    public void waitForPassSelct() {
        waitForVisibility(generatePwBtn, 5, driver);
    }
    
    public void clickGenPwBtn() {
        generatePwBtn.click();
        log.info("Clicked Generate Password Button");
    }
    
    public void waitForOkBtn() {
        waitForVisibility(okBtn, 3, driver);
    }
    
    public void clickOkBtn() {
        okBtn.click();
        log.info("Clicked OK button");
    }
    
    public void clickXBtn() {
        closeBtn.click();
        log.info("Clicked X Button");
    }
}

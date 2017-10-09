
package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static Utilities.WaitUtilities.*;


public class ProfilePg {
    WebDriver driver;
    private static final Logger log = LogManager.getLogger(ProfilePg.class.getName());
    
    @FindBy(xpath = "//*[@id='patient-profile']/section[1]/div[1]/div/a/i")
    WebElement sendEmailtoPatBtn;
    
    @FindBy(xpath = "//div[@class='patient-name']/h2/a")
    WebElement patientPlanLink;
    
    //Information Types
    @FindBy(xpath = "//button[text()='Patient Information']")
    WebElement patientInfoTab;
    
    @FindBy(xpath = "//button[text()='Clinical Information']")
    WebElement clinicalInfoTab;
    
    @FindBy(xpath = "//button[text()='Kit Information']")
    WebElement kitInfoTab;
    
    @FindBy(xpath = "//button[text()='Login Information']")
    WebElement loginInfoTab;
    
    @FindBy(xpath = "//button[text()='Discharge']")
    WebElement dischargeBtn;
    
    //Discharge confirmation
    @FindBy(xpath = "//button[text()='OK']")
    WebElement okDischrgBtn;
    
    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement cancelDischrgBtn;
    
    //Patient Info tab
    @FindBy(name = "first_name")
    WebElement firstName;
    
    @FindBy(name = "last_name")
    WebElement lastName;
    
    @FindBy(name = "email")
    WebElement email;
    
    @FindBy(xpath = "//label[contains(text(),'no email')]")
    WebElement noEmailChkBox;
    
    @FindBy(xpath = "//*[@id='patient-profile']//div[5]/div/rflx-select/div/div/span")
    WebElement genderClick;
    
    @FindBy(xpath = "//input[@placeholder='Gender']")
    WebElement gender;
    
    @FindBy(xpath = "//*[@id='patient-profile']//div[6]/div/div[1]/rflx-select/div/div/span")
    WebElement dobMClick;
    
    @FindBy(xpath = "//input[@placeholder='Month']")
    WebElement dobM;
    
    @FindBy(xpath = "//*[@id='patient-profile']//div[6]/div/div[2]/rflx-select/div/div/span")
    WebElement dobDClick;
    
    @FindBy(xpath = "//input[@placeholder='Day']")
    WebElement dobD;
    
    @FindBy(xpath  = "//*[@id='patient-profile']//div[6]/div/div[3]/rflx-select/div/div/span")
    WebElement dobYClick;
    
    @FindBy(xpath = "//input[@placeholder='Year']")
    WebElement dobY;
    
    @FindBy(name = "phone_number")
    WebElement primPhoneNum;
    
    @FindBy(name = "other_phone_number")
    WebElement altPhoneNum;
    
    @FindBy(name = "address_line1")
    WebElement addressLine1;
    
    @FindBy(name =  "address_line2")
    WebElement addressLine2;
    
    @FindBy(name = "city")
    WebElement city;
    
    @FindBy(xpath = "//*[@id='patient-profile']/section[3]/div[1]/form/div[12]/div/div[1]/rflx-select/div/div/span")
    WebElement stateClick;
    
    @FindBy(xpath = "//input[@placeholder='State']")
    WebElement state;
    
    @FindBy(name = "zip")
    WebElement zipcode;
    
    @FindBy(xpath = "//label[contains(text(),'demo patient')]")
    WebElement demoPatientChkBox;
    
    @FindBy(xpath = "//*[@id='patient-profile']//div[14]/button")
    WebElement savePatientInfoBtn;
    
    //Clinical Information Tab
    @FindBy(name = "medical_id")
    WebElement medicalRecNum;
    
    @FindBy(xpath = "//*[@id='patient-profile']/section[3]/div[2]/form/div[2]/div/div[1]/rflx-select/div/div/span")
    WebElement diagnosisClick;////*[@id='patient-profile']//div[2]/div/div[1]/rflx-select/div/div/span/span[2]
    
    @FindBy(xpath = "//input[@placeholder='Diagnosis']")
    WebElement diagnosis;
    
    @FindBy(xpath = "//*[@id='patient-profile']//div[2]/div/div[2]/rflx-select/div/div/span")
    WebElement biasClick;
    
    @FindBy(xpath = "//input[@placeholder='Bias']")
    WebElement bias;
    
    @FindBy(xpath = "//textarea[@placeholder='Diagnosis notes']")
    WebElement diagnosisNotes;
    
    @FindBy(xpath = "//*[@id='patient-profile']//div[4]/div/rflx-select/div/div/span")
    WebElement clinicianClick;
    
    @FindBy(xpath = "//*[@id='patient-profile']//div[4]/div/rflx-select/div/input[1]")
    WebElement clinician;
    
    @FindBy(xpath = "//*[@id='patient-profile']//div[5]/div/rflx-multi-select-input/div/input")
    WebElement careTeam;
    
    @FindBy(name = "surgeon")
    WebElement surgeonName;
    
    @FindBy(name = "incident_date")// "mm/dd/yyyy"
    WebElement injuryDate;
    
    @FindBy(xpath = "//*[@id='patient-profile']//div[7]/div/div/span/button")
    WebElement injDateCal;
    
    @FindBy(name = "surgery_date")// "mm/dd/yyyy"
    WebElement surgeryDate;
    
    @FindBy(xpath = "//*[@id='patient-profile']//div[8]/div/div/span/button")
    WebElement surgDateCal;
    
    @FindBy(xpath = "//*[@id='patient-profile']//div[9]/button")
    WebElement saveClinInfoBtn;
    
    //Calendar 
    @FindBy(xpath = "//table[@role='grid']/thead/tr[1]/th[1]/button")
    WebElement calLArrow;
    
    @FindBy(xpath = "//table[@role='grid']/thead/tr[1]/th[3]/button")
    WebElement calRArrow;
    
    @FindBy(xpath = "//li[@class='ng-scope']/span/button[1]")
    WebElement calTodayBtn;
    
    @FindBy(xpath = "//li[@class='ng-scope']/span/button[2]")
    WebElement calClearBtn;
    
    @FindBy(xpath = "//li[@class='ng-scope']/button")
    WebElement calDoneBtn;
    
    //Unsaved Changes Window
    @FindBy(xpath = "//div[@class='modal-footer ng-scope']/button")
    WebElement saveChangesConfBtn;
    
    @FindBy(xpath = "//div[@class='modal-footer ng-scope']/a")
    WebElement contNoChangesConfBtn;
    
    //Kit Information Tab
    @FindBy(xpath = "//label[text()='Request Kit Install']")
    WebElement reqKitInstChkBox;
    
    @FindBy(xpath = ".//*[@id='patient-profile']/section[3]/div[3]/form/div[2]/div[1]/div")
    WebElement instDifAddrChkBox;
    
    @FindBy(xpath = "//*[@id='patient-profile']//div[3]/div[1]/div/input")
    WebElement primKitPhoneNuml;
    
    @FindBy(name = "install_address_line1")
    WebElement instAddrLine1;
    
    @FindBy(name = "install_address_line2")
    WebElement instAddrLine2;
    
    @FindBy(name = "install_city")
    WebElement instCity;
    
    @FindBy(xpath = "//*[@id='patient-profile']//div[5]/div/div[1]/rflx-select/div/div/span")
    WebElement instStateClick;
    
    @FindBy(xpath = ".//*[@id='patient-profile']/section[3]/div[3]/form/div[3]/div[5]/div/div[1]/rflx-select/div/input[1]")
    WebElement instState;
    
    @FindBy(name = "install_zip")
    WebElement instZipcode;
    
    @FindBy(xpath = "//*[@id='patient-profile']//div[5]/button")
    WebElement saveKitInfoBtn;
    
    //Login Information tab
    @FindBy(xpath = "//a[text()='Reset Password']")
    WebElement resetPwLink;
    
    //Reset Pw Window
    @FindBy(xpath = "//button[text()='Send Email']")
    WebElement sendEmailPwRBtn;
    
    @FindBy(xpath = "//button[text()='Generate Password']")
    WebElement generatePwRBtn;
    
    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement cancelPwRBtn;
    
    @FindBy(xpath = "//button[@class='close']")
    WebElement closePwRBtn;
    
    @FindBy(xpath = "//button[text()='OK']")
    WebElement okPwRBtn;
    
    @FindBy(xpath = "//div[@ng-show='passwordComplete']/div[2]/span[2]")//Need to wait time for generated pw
    WebElement genPwRField;
    
    @FindBy(xpath = "//div[@ng-show='passwordComplete']/div[1]/span[2]")
    WebElement genEmailPwRField;
    
    @FindBy(xpath = "//i[contains(@class,'fa-print')]")
    WebElement printPwRBtn;
    
    
    public ProfilePg(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);        
    }
    
    public void waitPgLoad() {
        waitForVisibility(firstName, 2, driver);
    }
    
    public void clickDischrgBtn() {
        dischargeBtn.click();
        log.info("Clicked Discharge Button");
    }
    
    public void waitForDischrgPopup() {
        waitForVisibility(okDischrgBtn, 3, driver);
    }
    
    public void clickCancelBtn() {
        cancelDischrgBtn.click();
        log.info("Clicked Cancel Button");
    }
    
    public void clickOkDischrgBtn() {
        okDischrgBtn.click();
        log.info("Clicked Ok Button");
    }
    
    public void closePopup() {
        closePwRBtn.click();
        log.info("Clicked X Close Button");
    }
    
    public void clickPatNamePlan() {
        patientPlanLink.click();
        log.info("Clicked Patient Name Plan Link");
    }
    
    public void clickPatEmailBtn() {
        sendEmailtoPatBtn.click();
        log.info("Clicked Email Patient Button");
    }
    
    public void clickNoEmailChkBox() {
        noEmailChkBox.click();
        log.info("Clicked No Email Checkbox");
    }
    
    public void clearEmail() {
        email.clear();
        log.info("Cleared Email");
    }
    
    public void clickGenderDrpDown() {
        genderClick.click();
        log.info("Clicked Gender Dropdown");
    }
    
    public void clickDateDrpDown() {
        dobMClick.click();
        log.info("Clicked Month Drop Down");
        dobDClick.click();
        log.info("Clicked Day Drop Down");
        dobYClick.click();
        log.info("Clicked Year Drop Down");
    }
    
    public void fillPrimPhone(String phone) {
        primPhoneNum.clear();
        primPhoneNum.sendKeys(phone);
        log.info("Entered Primary Phone: " + phone);        
    }
    
    public void fillAltPhone(String phone) {
        altPhoneNum.clear();
        altPhoneNum.sendKeys(phone);
        log.info("Entered Alternate Phone: " + phone);        
    }
    
    public void fillAddress(String fAddress, String fCity, String fState, String fZip) {
        addressLine1.clear();
        addressLine1.sendKeys(fAddress);
        log.info("Entered Address Line 1: " + fAddress);
        city.clear();
        city.sendKeys(fCity);
        log.info("Entered City: " + fCity);
        stateClick.click();
        state.sendKeys(fState, Keys.ENTER);
        log.info("Entered State: " + fState);
        zipcode.clear();
        zipcode.sendKeys(fZip);
        log.info("Entered Zipcode: " + fZip);
    }
    
    public void clickClinicialTab() {
        clinicalInfoTab.click();
        log.info("Clicked Clinical Information Tab");
    }
    
    public void fillMRN(String mrn) {
        medicalRecNum.clear();
        medicalRecNum.sendKeys(mrn);
        log.info("Entered MRN: ");
    }
    
    public void clickDiagDrpDown() {
        diagnosisClick.click();
        log.info("Clicked Diagnosis Dropdown");
    }
    
    public void clickBiasDrpDown() {
        biasClick.click();
        log.info("Clicked Bias Dropdown");
    }
    
    public void fillNotes(String notes) {
        diagnosisNotes.clear();
        diagnosisNotes.sendKeys(notes);
        log.info("Entered Diagnosis Notes");
    }
    
    public void clickClinDrpDown() {
        clinicianClick.click();
        log.info("Clicked Clinician Dropdown");
    }
    
    public void fillCareTeam(String careT) {
        careTeam.sendKeys(careT);
        log.info("Entered Care Team: " + careT);
    }
    
    public void fillSurgeon(String surgName) {
        surgeonName.sendKeys(surgName);
        log.info("Entered Surgeon Name: " + surgName);
    }
    
    public void clickInjuryCal() {
        injDateCal.click();
        log.info("Clicked Injury Date Calendar Button");
    }
    
    public void clickCalLArrow() {
        calLArrow.click();
        log.info("Clicked Calendar Left Arrow");
    }
    
    public void clickCalRArrow() {
        calRArrow.click();
        log.info("Clicked Calendar Right Arrow");
    }
    
    public void clickCalTodayBtn() {
        calTodayBtn.click();
        log.info("Clicked Calendar Today Button");
    }
    
    public void clickCalClearBtn() {
        calClearBtn.click();
        log.info("Clicked Calendar Clear Button");
    }
    
    public void clickCalDoneBtn() {
        calDoneBtn.click();
        log.info("Clicked Calendar Done Button");
    }
    
    public void fillInjuryDate(String date) {
        injuryDate.clear();
        injuryDate.sendKeys(date);
        log.info("Entered Injury Date: " + date);
    }
    
    public void clickKitInfoTab() {
        kitInfoTab.click();
        log.info("Clicked Kit Info Tab");
    }
    
    public void clickReqKitInstChkBox() {
        reqKitInstChkBox.click();
        log.info("Clicked Request Kit Install Checkbox");
    }
    
    public void clickInstDifAddChkBox(){
        instDifAddrChkBox.click();
        log.info("Clicked Different Installation Address Checkbox");
    }
    
    public void clickLoginInfoTab() {
        loginInfoTab.click();
        log.info("Clicked Login Info Tab");
    }
    
    public void clickResetPwLink() {
        resetPwLink.click();
        log.info("Clicked Reset PW Link");
    }
    
    public void clickSendEmailBtn() {
        sendEmailPwRBtn.click();
        log.info("Clicked Send Email Button");
    }
    
    public void clickGenPWBtn() {
        generatePwRBtn.click();
        log.info("Clicked Generate PW Button");
    }
    
    public void waitResetPWPopup() {
        waitForVisibility(sendEmailPwRBtn, 2, driver);
    }
}

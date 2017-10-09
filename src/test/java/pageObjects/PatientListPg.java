
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


public class PatientListPg {
    WebDriver driver;
    //NavBarFooterPg navBarFooterPgTest;
    List<WebElement> patListElements;
    private static final Logger log = LogManager.getLogger(PatientListPg.class.getName());
        
    //Patient Search Bar
    @FindBy(xpath = "//input[@ng-model='vm.query']")
    WebElement patientSearchTxtBox;
    
    @FindBy(xpath = "//a[@class='btn btn-tertiary']")
    WebElement clearSearchBtn;
    
    @FindBy(xpath = "//button[text()='My Patients']")
    WebElement myPatientFltrBtn;
    
    @FindBy(xpath = "//button[text()='All Patients']")
    WebElement allPatientsFltrBtn;
    
    @FindBy(xpath = "//a[text()='Active']")
    WebElement activeFltrBtn;
    
    @FindBy(xpath = "//a[text()='Discharged']")
    WebElement dischargedFltrBtn;
    
    //Sorting List Bar
    @FindBy(xpath = "//div[@class='sort-row']/div[1]")
    WebElement nameSort;
    
    @FindBy(xpath = "//div[@class='sort-row']/div[2]")
    WebElement statusSort;
    
    @FindBy(xpath = "//div[@class='sort-row']/div[3]")
    WebElement faSort;
    
    @FindBy(xpath = "//div[@class='sort-row']/div[4]")
    WebElement recentactSort;
         
    /**
     * Patient row
     * xpath of row = "//div[contains(@class,'patient-row')][n]"
     * n = number of row    
    **/
    @FindBy(xpath = "//div[contains(@class,'patient-row')][1]//a[contains(@class,'patient-name')]")
    WebElement patientLinkRow;
    
    @FindBy(xpath = "//div[contains(@class,'patient-row')][1]//a[2]")
    WebElement clinicianLinkRow;
    
    @FindBy(xpath = "//div[contains(@class,'patient-row')][1]//a[@analytics-event='Edit Program']")
    WebElement editPrgmLinkRow;
    
    @FindBy(xpath = "//div[contains(@class,'patient-row')][1]//i[contains(@analytics-event,'FA')]")
    WebElement reviewFA;
    
    @FindBy(xpath = "//div[contains(@class,'patient-row')][1]//a[@class='dropdown-toggle']")
    WebElement extraOptnRow;
    
    //Extra Options    
    @FindBy(xpath = "//div[contains(@class,'patient-row')][1]//li[1]")
    WebElement profileExOptn;
    
    @FindBy(xpath = "//div[contains(@class,'patient-row')][1]//li[2]")
    WebElement creatPrgExOptn;
    
    @FindBy(xpath = "//div[contains(@class,'patient-row')][1]//li[3]")
    WebElement reqKitExOptn;
    
    @FindBy(xpath = "//div[contains(@class,'patient-row')][1]//li[4]")
    WebElement emailPatExOptn;
    
    @FindBy(xpath = "//div[contains(@class,'patient-row')][1]//li[6]")
    WebElement dischrgPatExOptn;
    
    @FindBy(xpath = "//div[contains(@class,'patient-row')][1]//li[7]")
    WebElement placeHoldExOptn;
    
    @FindBy(xpath = "//div[contains(@class,'patient-row')][1]//li[8]")
    WebElement resetPwExOptn;
    
    //List Navigation    
    @FindBy(xpath = "//a[text()='«']")
    WebElement firstPgNavBtn;
    
    @FindBy(xpath = "//a[text()='‹']")
    WebElement backPgNavBtn;
    
    @FindBy(xpath = "//a[text()='›']")
    WebElement fowardPgNavBtn;
    
    @FindBy(xpath = "//a[text()='»']")
    WebElement lastPgNavBtn;
    
    //Discharge Confirmation Window
    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement cancelDischBtn;
    
    @FindBy(xpath = "//button[text()='OK']")
    WebElement okBtn;
    
    //Place On Hold Window
    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement cancelHoldBtn;
    
    @FindBy(xpath = "//button[text()='Save']")
    WebElement saveHoldBtn;
    
    @FindBy(name = "start_date")
    WebElement startDateHoldTxtBox;
    
    @FindBy(xpath = "//span[text()='Next time patient logs in']")
    WebElement toClick;
    
    @FindBy(xpath = "//div[@class='input-row']/rflx-select//input[1]")
    WebElement toSelctTxtBox;
    
    @FindBy(xpath = "//button[@class='close']")
    WebElement closePopupBtn;
    
    @FindBy(xpath = "//div[@class='input-row']//button")
    WebElement calendarFromBtn;
    
    @FindBy(xpath = "html/body/div[4]/div/div/form/div[1]/div[3]/div/span/button")
    WebElement calendarToBtn;
    
    @FindBy(name = "end_date")
    WebElement toDateTxtBox;
    
    //Cancel On Hold Window
    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement cancelCHoldBtn;
    
    @FindBy(xpath = "//button[text()='Yes']")
    WebElement yesCHoldBtn;
    
    //Reset Pw Window
    @FindBy(xpath = "//button[text()='Send Email']")//Wait after this is clicked
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
    
    //Request Kit Window
    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement cancelKitBtn;
    
    @FindBy(xpath = "//button[text()='Edit Profile']")
    WebElement editProfKitBtn;
    
    public PatientListPg(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        //navBarFooterPgTest = new NavBarFooterPg(driver);
        this.patListElements = new ArrayList<>(Arrays.asList(patientSearchTxtBox,
        patientLinkRow));
    }
    
    public void searchPatient(String patientSrch) {
        patientSearchTxtBox.sendKeys(patientSrch);
        log.info("Searched patient: " + patientSrch);        
    }
    
    public void waitPgLoad() throws InterruptedException {
        //waitForVisibilityList(patListElements, 8, driver);
        clearSearchBtn.click();
        Thread.sleep(1500);
    }
    
    public void dischargePat(String name) throws InterruptedException {
        try {
            waitForVisibility(clearSearchBtn, 3, driver);
            clearSearchBtn.click();
            patientSearchTxtBox.sendKeys(name);
            Thread.sleep(1000);
            log.info(patientLinkRow.getText() + " = " + name);
            log.info("Searched for patient: " + name);
            waitForVisibilityText(patientLinkRow, 2, name, driver);//Checks search
            extraOptnRow.click();
            log.info("Clicked Extra Options");
            dischrgPatExOptn.click();
            log.info("Clicked Discharge Patient Extra Option");
            waitForVisibility(okBtn, 2, driver);
            okBtn.click();
            log.info("Clicked OK to discharge");
            log.info("Patient " + name + " discharged");
        } catch(Exception e) {
            log.warn("Patient " + name + " not found");
        }        
    }
    
    public void clickSeachPatTxtBox() {
        patientSearchTxtBox.click();
        log.info("Clicked Patient Search Text Box");
        log.info("Pointer in the search field");
    }
    
    public void clearSearch() {
        clearSearchBtn.click();
        log.info("Clicked Clear Search Button X");
    }
    
    public void clickExtraOptn() {
        extraOptnRow.click();
        log.info("Clicked Extra Options");
    }
    
    public void profileExtraOptn() {
        clickExtraOptn();
        waitForVisibility(profileExOptn, 3, driver);
        //Thread.sleep(1000);
        profileExOptn.click();
        log.info("Clicked Profile Extra Option");
        
    }
    
    public void reqKitExtraOptn() {
        clickExtraOptn();
        waitForVisibility(reqKitExOptn, 3, driver);
        reqKitExOptn.click();
        log.info("Clicked Request Option");
    }
    
    public void clickCancelBtn() {
        cancelKitBtn.click();
        log.info("Clicked Cancel Button");
    }
    
    public void clickEditProfileBtn() {
        editProfKitBtn.click();
        log.info("Clicked Edit Profile Button");
    }
    
    public void dischrgPatExtraOptn() {
        clickExtraOptn();
        waitForVisibility(dischrgPatExOptn, 3, driver);
        dischrgPatExOptn.click();
        log.info("Clicked Discharge Patient Button");
        waitForVisibility(cancelKitBtn, 3, driver);
    }
    
    public void clickOkBtn() {
        okBtn.click();
        log.info("Clicked OK Button");
    }
    
    public void clickClosePopupBtn() {
        closePopupBtn.click();
        log.info("Clicked X Close Button");
    }
    
    public void plOnHoldExtraOptn() {
        clickExtraOptn();
        waitForVisibility(placeHoldExOptn, 2, driver);
        placeHoldExOptn.click();
        waitForVisibility(cancelKitBtn, 5, driver);
    }
    
    public void cancelHoldOptn() {
        clickExtraOptn();
        waitForVisibility(placeHoldExOptn, 2, driver);
        placeHoldExOptn.click();
        waitForVisibility(closePopupBtn, 2, driver);
    }
    
    public void clickCalendarBtn() {
        calendarFromBtn.click();
        log.info("Clicked Calendar Button");
    }
    
    public void fillFromHoldDate(String date) {
        startDateHoldTxtBox.clear();
        startDateHoldTxtBox.sendKeys(date);
        log.info("Entered Start Date: " + date);
    }
    
    public void clickToHoldDrpDown() {
        toClick.click();
        log.info("Clicked To Hold Dropdown");
    }
    
    public void fillToSelctTxtBox(String input) {
        toSelctTxtBox.sendKeys(input, Keys.ENTER);
        log.info("Entered To Selection: " + input);
    }
    
    public void fillToHoldDate(String input) {
        toDateTxtBox.sendKeys(input);
        log.info("Entered To Date: " + input);
    }
    
    public void clickSaveHoldBtn() {
        saveHoldBtn.click();
        log.info("Clicked Save Hold Button");
        waitForVisibility(closePopupBtn, 2, driver);
    }
    
    public void resetPwExtraOptn() {
        clickExtraOptn();
        waitForVisibility(resetPwExOptn, 2, driver);
        resetPwExOptn.click();
        log.info("Clicked Reset Pw Extra Option");        
    }
    
    public void clickSendEmailPwBtn() {
        sendEmailPwRBtn.click();
        log.info("Clicked Send Email Pw Button");
    }
    
    public void waitForKitInstPopup() {
        waitForVisibility(editProfKitBtn, 2, driver);
    }
}

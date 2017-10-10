
package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ExercisePlanPg {
    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(ExercisePlanPg.class.getName());
    
    //Patient Tab Navigation
    @FindBy(xpath = "//*[@id='patient-navigation']//li[1]")
    WebElement exercisePlanNav;
    
    @FindBy(xpath = "//*[@id='patient-navigation']//li[2]")
    WebElement testSurvNav;
    
    @FindBy(xpath = "//*[@id='patient-navigation']//li[3]")
    WebElement reportsNav;
    
    @FindBy(xpath = "//*[@id='patient-navigation']//li[4]")
    WebElement profileNav;
    
    //Patient info tab
    @FindBy(xpath = "//span[@class='dropdown-toggle']")
    WebElement managePatDropDown;
    
    @FindBy(xpath = "//*[@id='patient-summary']//div[1]/a/i")
    WebElement expandInfo;
    
    //Manage Patient Options
    @FindBy(xpath = "//*[@id='patient-summary']//li[1]")
    WebElement profileDropDown;
    
    @FindBy(xpath = "//*[@id='patient-summary']//li[2]")
    WebElement createPrgmMngDrpDown;
    
    @FindBy(xpath = "//*[@id='patient-summary']//li[3]")
    WebElement requestKitDropDown;
    
    @FindBy(xpath = "//*[@id='patient-summary']//li[4]")
    WebElement emailPatDropDown;
    
    @FindBy(xpath = "//*[@id='patient-summary']//li[6]")
    WebElement dischrgPatDropDown;
    
    @FindBy(xpath = "//*[@id='patient-summary']//li[7]")
    WebElement placeHoldDropDown;
    
    @FindBy(xpath = "//*[@id='patient-summary']//li[8]")
    WebElement resetPwDropDown;
    
    //Request Kit Window
    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement cancelKitBtn;
    
    @FindBy(xpath = "//button[text()='Edit Profile']")
    WebElement editProfKitBtn;
    
    //Discharge Confirmation Window
    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement cancelDischBtn;
    
    @FindBy(xpath = "//button[text()='OK']")
    WebElement okDischBtn;
    
    //Place On Hold Window
    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement cancelHoldBtn;
    
    @FindBy(xpath = "//button[text()='Save']")
    WebElement saveHoldBtn;
    
    @FindBy(name = "start_date")
    WebElement startDateHoldTxtBox;
    
    @FindBy(xpath = "//span[text()='Next time patient logs in']")
    WebElement toClick;
    
    @FindBy(xpath = "html/body/div[162]/div/div/form/div[1]/div[2]/rflx-select/div/input[1]")
    WebElement toTxtBox;
    
    @FindBy(xpath = "//*[@id='ui-select-choices-row-43-0']/a/div")
    WebElement toNextTimeSlctn;
    
    @FindBy(xpath = "//*[@id='ui-select-choices-row-43-1']/a/div")
    WebElement toNoEndSlctn;
    
    @FindBy(xpath = "//*[@id='ui-select-choices-row-43-2']/a/div")
    WebElement toSpecDateSlctn;
    
    @FindBy(xpath = "//button[@class='close']")
    WebElement closeHoldBtn;
    
    //Cancel On Hold Window
    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement cancelCHoldBtn;
    
    @FindBy(xpath = "//button[text()='Yes']")
    WebElement yesCHoldBtn;
    
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
    
    //Exercise Plan tab
    @FindBy(xpath = "//*[@id='patient-monitor']//rflx-select[1]/div/div/span")
    WebElement selectWeekClick;
    
    @FindBy(xpath = "//input[@placeholder='Select week']")
    WebElement selectWeekTxtBox;
    
    @FindBy(xpath = "//span[text()='Select plan']")
    WebElement selectPlanClick;
    
    @FindBy(xpath = "//input[@placeholder='Select plan']")
    WebElement selectPlanTxtBox;
    
    @FindBy(xpath = "//*[@id='patient-monitor']//button")
    WebElement changePrgmDrpDown;
    
    @FindBy(xpath = "//i[contains(@class,'fa-print')]")
    WebElement printPwRBtn;
    
    //Change Program dropdown menu
    @FindBy(xpath = "//a[text()='Edit Current Program']")
    WebElement editProgDrpDown;
    
    @FindBy(xpath = "//a[text()='Create New Program']")
    WebElement createProgChDrpDown;
    
    @FindBy(xpath = "//a[text()='Apply a Protocol']")
    WebElement applyProtDrpDown;
    
    //Apply Protocol Window
    @FindBy(xpath = "//span[text()='Select Protocol']")
    WebElement selectProtClick;
    
    @FindBy(xpath  = "//input[@placeholder='Select Protocol']")
    WebElement selectProtTxtBox;
    
    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement cancelApplyProtBtn;
    
    @FindBy(xpath = "//button[text()='Apply']")
    WebElement applyProtBtn;
    
    @FindBy(xpath = "//i[contains(@class,'fa-print')]")
    WebElement printPlanBtn;
    
    @FindBy(xpath = "//span[text()='Print plan']")
    WebElement printPlanLink;
    
    @FindBy(xpath = "//a[contains(@ng-click,'vm.showDetails')]")//Not visible got to wait
    WebElement showSessionDetails;
    
    
    public ExercisePlanPg(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

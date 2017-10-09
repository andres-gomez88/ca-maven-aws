
package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ReportsPg {
    WebDriver driver;
    private static final Logger log = LogManager.getLogger(ReportsPg.class.getName());
    
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
    
    //Reports Tab    
    @FindBy(xpath = "//button[@analytics-event='Create Report']")
    WebElement createReport;
    
    //Create Report Window
    @FindBy(name = "reportStart")//Clear text box before sending keys
    WebElement reportStartTxtBox;
    
    @FindBy(name = "reportEnd")//Clear text box before sending keys
    WebElement reportEndTxtBox;
    
    @FindBy(xpath = "//button[text()='Run Report']")
    WebElement runReportBtn;
    
    //Type of reports
    @FindBy(xpath = "//ul[@class='nav-items']/li[1]")
    WebElement weeklyReports;
    
    @FindBy(xpath = "//ul[@class='nav-items']/li[2]")
    WebElement monthlyReports;
    
    @FindBy(xpath = "//ul[@class='nav-items']/li[3]")
    WebElement episodeReports;
    
    @FindBy(xpath = "//ul[@class='nav-items']/li[4]")
    WebElement oneTimeReports;    
    
    public ReportsPg(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

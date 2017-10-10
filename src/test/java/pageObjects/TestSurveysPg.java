
package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TestSurveysPg {
    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(TestSurveysPg.class.getName());
    
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
    
    //Tests & Surveys tab
    @FindBy(xpath = "//*[@id='patient-monitor']//button")
    WebElement changePrgmDrpDown;
    
    @FindBy(xpath = "//i[contains(@class,'fa-print')]")
    WebElement printPwRBtn;
    
    //Functional Assesment Graphs
    @FindBy(xpath = "//button[text()='Tests']")
    WebElement testsTabBtn;
    
    @FindBy(xpath = "//button[text()='Surveys']")
    WebElement surveysTabBtn;
    
    //Functional Assesment Summary
    @FindBy(xpath = "//button[text()='Calendar']")
    WebElement calendarTabBtn;
    
    @FindBy(xpath = "//button[text()='List']")
    WebElement listTabBtn;
    
    //Calendar Tab Gotta wait for elements to work
    @FindBy(xpath = "//button[text()='Next >']")
    WebElement nextMonthCal;
    
    @FindBy(xpath = "//button[text()='< Previous']")
    WebElement prevMonth;
    
    @FindBy(xpath = "//div[@class='nav-arrows noselect']//i[2]")
    WebElement nextDay;
    
    @FindBy(xpath = "//div[@class='nav-arrows noselect']//i[1]")
    WebElement prevDay;
    
    //List Tab    
    @FindBy(xpath = "//button[text()='Episode']")
    WebElement byEpisodeList;
    
    @FindBy(xpath = "//button[text()='Last 30 Days']")    
    WebElement byLast30DaysList;
    
    @FindBy(xpath = "//button[text()='Last 7 Days']")
    WebElement byLast7DaysList;
    
    @FindBy(xpath = "//span[@class='dropdown']")
    WebElement showDrpDown;
    
    @FindBy(xpath = "//span[@class='dropdown-menu']//ul[1]/li[1]")
    WebElement allAssessmentsFltr;
    
    @FindBy(xpath = "//span[@class='dropdown-menu']//ul[1]/li[2]")
    WebElement toReviewFltr;
    
    @FindBy(xpath = "//span[@class='dropdown-menu']//ul[1]/li[3]")
    WebElement newSurveyFltr;
    
    @FindBy(xpath = "//span[@class='dropdown-menu']//ul[1]/li[4]")
    WebElement missedFltr;
    
    @FindBy(xpath = "//span[@class='dropdown-menu']//ul[1]/li[5]")
    WebElement scheduledFltr;
    
    @FindBy(xpath = "//span[@class='dropdown-menu']//ul[1]/li[6]")
    WebElement completeFltr;
    
    @FindBy(xpath = "//span[@class='dropdown-menu']//ul[2]/li[1]")
    WebElement hoosSurveyFltr;
    
    @FindBy(xpath = "//span[@class='dropdown-menu']//ul[2]/li[2]")
    WebElement womacSurveyFltr;
    
    @FindBy(xpath = "//span[@class='dropdown-menu']//ul[2]/li[3]")
    WebElement extensionTestFltr;
    
    @FindBy(xpath = "//span[@class='dropdown-menu']//ul[2]/li[4]")
    WebElement flexionTestFltr;
    
    @FindBy(xpath = "//span[@class='dropdown-menu']//ul[2]/li[5]")
    WebElement sitToStandTestFltr;
    
    public TestSurveysPg(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

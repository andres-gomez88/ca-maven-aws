
package pageObjects;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static Utilities.WaitUtilities.*;


public class ProtocolsListPg {
    private WebDriver driver;
    private CreateEditProtocolPg createEditProtocolPgTest;
    private static final Logger log = LogManager.getLogger(ProtocolsListPg.class.getName());
    private List<WebElement> protocolElements;
    private ExtentTest reportTest;
    
    //Protocol Search Bar
    @FindBy(xpath = "//input[@ng-model='vm.query']")
    WebElement protocolSearchTxtBox;
    
    @FindBy(xpath = ".//*[@id='protocol-list']/div[1]/div/div/span/a")
    WebElement clearSearchBtn;
    
    @FindBy(xpath = "//a[@class='add-link']")
    WebElement addProtocol;
    
    /**
     * Protocol row
     * xpath of row = "//div[@id='protocol-list']//section[2]"
     * n = number of row starts @ 2    
    **/    
    @FindBy(xpath = "//div[@id='protocol-list']//section[2]//span[contains(@class,'name')]")
    WebElement editInfoProtocolRow;
    
    @FindBy(name = "name")
    WebElement editNameRow;
    
    @FindBy(name = "description")
    WebElement editDescRow;
    
    @FindBy(xpath = "//div[@id='protocol-list']//section[2]//button[1]")
    WebElement submitInfoBtnRow;
    
    @FindBy(xpath = "//div[@id='protocol-list']//section[2]//button[2]")
    WebElement cancelInfoBtnRow;
    
    @FindBy(xpath = "//div[@id='protocol-list']//section[2]//i[contains(@class,'fa-fw')]")
    WebElement protocolDetailRow;
    
    @FindBy(xpath = "//div[@id='protocol-list']//section[2]//i[contains(@class,'fa-ellipsis')]")
    WebElement extraOptnRow;
    
    @FindBy(xpath = "//div[@id='protocol-list']//section[2]//a[@analytics-event='Edit Protocol']")
    WebElement editExtraOptnRow;
    
    @FindBy(xpath = "//div[@id='protocol-list']//section[2]//a[@analytics-event='Delete Protocol']")
    WebElement delProtExtraOptnRow;
    
    //List Navigation   
    @FindBy(xpath = "//a[text()='«']")
    WebElement firstPgNavBtn;
    
    @FindBy(xpath = "//a[text()='‹']")
    WebElement backPgNavBtn;
    
    @FindBy(xpath = "//a[text()='›']")
    WebElement fowardPgNavBtn;
    
    @FindBy(xpath = "//a[text()='»']")
    WebElement lastPgNavBtn;
    
    //Protocol Delete Confirmation Window
    @FindBy(xpath = "//button[text()='OK']")
    WebElement okDelProtBtn;
    
    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement cancelDelProtBtn;
    
    @FindBy(xpath = "//button[@class='close']")
    WebElement closeWinDel;
    
    public ProtocolsListPg(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.createEditProtocolPgTest = new CreateEditProtocolPg(driver);
        this.protocolElements = new ArrayList<>(Arrays.asList(addProtocol, protocolSearchTxtBox
        , editInfoProtocolRow));
    }
    
    public void waitPgLoad() {
        waitForVisibilityList(protocolElements, 8, driver);
    }
    
    public void addProtocol(String name, String description) {
        try {
            addProtocol.click();
            log.info("Clicked Add New Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.e01Bal3WayStarGrid.click();
            log.info("Clicked an excercise");
            createEditProtocolPgTest.saveAsProtBtn.click();
            log.info("Clicked Save as New Protocol Button");
            waitForVisibility(createEditProtocolPgTest.protNameSaveTxtBox, 4, driver);
            createEditProtocolPgTest.protNameSaveTxtBox.sendKeys(name);
            log.info("Entered protocol name: " + name);
            createEditProtocolPgTest.protDescSaveTxtBox.sendKeys(description);
            log.info("Entered protocol description: " + description);
            createEditProtocolPgTest.saveProtSaveBtn.click();
            log.info("Clicked Save Button");
            waitPgLoad();
            log.info("Protocol " + name + " successfully created");
        } catch(Exception e) {
            //Prerelease has a confirmation for navigating out of Program/Protocol
            log.warn("Protocol " + name + " not created");
            reportTest.log(Status.FAIL, "Test FAILED");
            createEditProtocolPgTest.cancelProtBtn.click();
            log.info("Clicked cancel Button");
            createEditProtocolPgTest.waitForOkBtn();
            createEditProtocolPgTest.clickOKBtn();
            waitPgLoad();
            org.testng.Assert.fail("Test FAILED");
        }        
    }
    
    public void deleteProtocol(String protName) {
         try {
             clearSearchBtn.click();
             log.info("Clicked Clear Search Button");
             protocolSearchTxtBox.sendKeys(protName);
             log.info("Searched for protcol " + protName);
             log.info(editInfoProtocolRow.getText() + " = " + protName);
             waitForVisibilityText(editInfoProtocolRow, 3, protName, driver);//Checks search
             extraOptnRow.click();
             log.info("Clicked extra options");
             delProtExtraOptnRow.click();
             log.info("Clicked Delete in Extra Options");
             waitForVisibility(okDelProtBtn, 3, driver);
             okDelProtBtn.click();
             log.info("Clicked Ok to delete protocol");
             log.info("Protocol " + protName + " deleted");
         } catch(Exception e) {
             log.warn("Protocol " + protName + " not found");
             clearSearchBtn.click();
             //org.testng.Assert.fail("Test FAILED");
         }
     }
    
    public void clickAddProtocol() {
        addProtocol.click();
    }
    
}

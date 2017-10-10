
package pageObjects;

import com.aventstack.extentreports.ExtentReports;
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


public class ResetpwLogInPg {
    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(ResetpwLogInPg.class.getName());
    private List<WebElement> resetPwElements;
    private ExtentTest reportTest;
    
    @FindBy(xpath = "//input[@name='email']")
    WebElement emailTxtBox;
    
    @FindBy(id = "submit")
    WebElement submitBtn;
    
    public ResetpwLogInPg(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.resetPwElements = new ArrayList<>(Arrays.asList(emailTxtBox, submitBtn));
    }
    
    public void sendResetLink(String email) {
        try {
            emailTxtBox.sendKeys(email);
            submitBtn.click();
            waitForNoVisibility(resetPwElements, 5, driver);
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
            org.testng.Assert.fail("Test FAILED");
        }
    }
    
    public void sendResetLinkInvalid(String email) {
        try {
            emailTxtBox.sendKeys(email);
            waitForClick(submitBtn, 2, driver);
        } catch (Exception e) {
            
        }
    }
    
    public void submitBtnClickable() {
        waitForClick(submitBtn, 2, driver);
    }
    
    public void checkResetPwElements() {
        waitForVisibilityList(resetPwElements, 3, driver);
    }
}
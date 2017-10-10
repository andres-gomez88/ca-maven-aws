
package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static Utilities.WaitUtilities.*;


public class ChangePwPg {
    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(ChangePwPg.class.getName());
    
    @FindBy(name = "password")
    WebElement oldPwTxtBox;
    
    @FindBy(name = "new_password")
    WebElement newPwTxtBox;
    
    @FindBy(name = "confirm_password")
    WebElement confirmNewPwTxtBox;
    
    @FindBy(id = "submit")
    WebElement submitBtn;
    
    @FindBy(xpath = "//*[@id='password-container']//p/span")
    WebElement pwStrengthTxt;
    
    @FindBy(xpath = "//*[@id='save-success']//a")
    WebElement returnDashboard;
    
    public ChangePwPg(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void fillOldPW(String oldPW) {
        oldPwTxtBox.sendKeys(oldPW);
        log.info("Entered Old Password: " + oldPW);
    }
    
    public void fillNewPW(String newPW) {
         newPwTxtBox.sendKeys(newPW);
         log.info("Entered New Password: " + newPW);
    }
    
    public void fillConfPW(String confPW) {
        confirmNewPwTxtBox.sendKeys(confPW);
        log.info("Entered New Password Confirmation: " + confPW);
    }    
    
    public Boolean submitBtnEnabled() {
        Boolean enabled;
        try {
            waitForClick(submitBtn, 2, driver);
            log.info("Submit Button Enabled");
            enabled = true;
        } catch (Exception e) {
            log.info("Submit Button Disabled");
            enabled = false;
        }
        return enabled;
    }
    
    public void clickSubmitBtn() {
        submitBtn.click();
        log.info("Clicked Submit Button");
    }
}

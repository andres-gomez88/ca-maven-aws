/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pageObjects;

import com.aventstack.extentreports.ExtentTest;
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

/**
 *
 * @author Admin
 */
public class LogInPg {    
    WebDriver driver;
    private static final Logger log = LogManager.getLogger(LogInPg.class.getName());
    List<WebElement> loginElements;
    ExtentTest reportTest;
    
    @FindBy(name = "username")
    WebElement emailTxtBox;
    
    @FindBy(name = "password")
    WebElement passwordTxtBox;
    
    @FindBy(xpath = "//label[text()='Remember me']")
    WebElement rememberMeChkBox;
    
    @FindBy(xpath = "//input[@value='Submit']")
    WebElement submitBtn;
    
    @FindBy(xpath = "//a[contains(text(),'reset')]")
    WebElement resetpwLink;
    
    @FindBy(xpath = "//a[text()='User guide']")
    WebElement userguideLink;
    
    @FindBy(xpath = "//div[contains(@class,'growl-item')]")
    WebElement invalidUsrEmailPopup;
    
    public LogInPg(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.loginElements = new ArrayList<>(Arrays.asList(emailTxtBox, 
        passwordTxtBox, rememberMeChkBox, submitBtn, resetpwLink, userguideLink));
    }
    
    public void logIn(String email, String pw) {
        emailTxtBox.sendKeys(email);
        log.info("Email for Login: " + email);
        passwordTxtBox.sendKeys(pw);
        log.info("Password for Login: " + pw);
        submitBtn.click();
        log.info("Submit button clicked");
    }
    
    public void logInNoCred() {
        if(submitBtn.isEnabled()){
            org.testng.Assert.fail("Test FAILED submit button is enabled");
        } else {
            log.info("Submit Button is disabled");
        }
    }
    
    public void logInRemember(String email, String pw) {
        emailTxtBox.sendKeys(email);
        log.info("Email for Login: " + email);
        passwordTxtBox.sendKeys(pw);
        log.info("Password for Login: " + pw);
        rememberMeChkBox.click();
        log.info("Clicked Remember Me Checkbox");
        submitBtn.click();
        log.info("Submit button clicked");
    }
    
    public void logInInvalid(String email, String pw) {
        try {
            emailTxtBox.sendKeys(email);
            log.info("Email for Login: " + email);
            passwordTxtBox.sendKeys(pw);
            log.info("Password for Login: " + pw);
            submitBtn.click();
            log.info("Submit button clicked");
            waitForVisibility(invalidUsrEmailPopup, 2, driver);
            log.info("Invalid email/pw popup");
        } catch (Exception e) {
            org.testng.Assert.fail("Test FAILED");
        }
        
    }
    public void clearLogInText() {
        emailTxtBox.clear();
        passwordTxtBox.clear();
    }
    
    public void checkLoginElements() {
        waitForVisibilityList(loginElements, 3, driver);
    }
    
    public void clickUserGuide() {
        userguideLink.click();
    }
    
    public void logInRemember(String pw) {
        passwordTxtBox.sendKeys(pw);
        submitBtn.click();
    }
    
    public void rememberMeClickable() {
        waitForClick(rememberMeChkBox, 3, driver);
    }
    
    public void clickResetPw() {
        resetpwLink.click();
        log.info("Clicked Send Reset Link Button");
    }
    
    public void clickRemMeChkBox() {
        rememberMeChkBox.click();
        log.info("Clicked Remember Me Check Box");
    }
}

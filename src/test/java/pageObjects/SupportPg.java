
package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static Utilities.WaitUtilities.*;


public class SupportPg {
    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(SupportPg.class.getName());
    
    @FindBy(xpath = "html/body/div[2]/div/div/section[1]/div/div/input")
    WebElement searchVideosTxtBox;
    
    @FindBy(xpath = "//a[text()='Download User Manual']")
    WebElement dlUserManualLink;
    
    //Videos
    @FindBy(xpath = "//section[@class='support-videos']/div[1]/div")
    WebElement addPatVideo;
    
    @FindBy(xpath = "//section[@class='support-videos']/div[2]")
    WebElement searchPatVideo;
    
    @FindBy(xpath = "//section[@class='support-videos']/div[3]")
    WebElement dashboardVideo;
    
    @FindBy(xpath = "//section[@class='support-videos']/div[4]")
    WebElement optPatListVideo;
    
    @FindBy(xpath = "//section[@class='support-videos']/div[5]")
    WebElement patDetailVideo;
    
    @FindBy(xpath = "//section[@class='support-videos']/div[6]")
    WebElement revEditPatProfVideo;
    
    @FindBy(xpath = "//section[@class='support-videos']/div[7]")
    WebElement viewTestSurvVideo;
    
    @FindBy(xpath = "//section[@class='support-videos']/div[8]")
    WebElement useReportsVideo;
    
    @FindBy(xpath = "//section[@class='support-videos']/div[9]")
    WebElement editNewProgVideo;
    
    @FindBy(xpath = "//section[@class='support-videos']/div[10]")
    WebElement viewExcPlanVideo;
    
    @FindBy(xpath = "//section[@class='support-videos']/div[11]")
    WebElement createClinVideo;
    
    @FindBy(xpath = "//section[@class='support-videos']/div[12]")
    WebElement useProtVideo;
    
    @FindBy(xpath = "//section[@class='support-videos']/div[13]")
    WebElement apEdFuncAssSurvVideo;
    
    @FindBy(xpath = "//section[@class='support-videos']/div[14]")
    WebElement putPatOnHoldVideo;
    
    @FindBy(xpath = "//section[@class='support-videos']/div[15]")
    WebElement dischPatVideo;
    
    @FindBy(xpath = "//section[@class='support-videos']/div[16]")
    WebElement reactPatVideo;
    
    //Video Window Controls
    @FindBy(xpath = "//button[@class='close']")
    WebElement closeVideoBtn;
    
    @FindBy(xpath = "//*[@id='videoPlayer']/video")//Gotta wait for video to load
    WebElement playVideo;
    
    public SupportPg(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void waitPgLoad() {
        waitForVisibility(searchVideosTxtBox, 3, driver);
    }
    
    public void waitVideoLoad() {
        waitForVisibility(playVideo, 10, driver);
    }
    
    public void fillSrchVidTxtBox(String input) {
        searchVideosTxtBox.sendKeys(input);
        log.info("Entered Video Search: " + input);
    } 
    
    public void clickAddPatVideo() {
        addPatVideo.click();
        log.info("Clicked How to Add Patient Video");
    }
    
    public void clickPlayVideo() {
        playVideo.click();
        log.info("Clicked Play Video");
    }
    
    public void clickSearchPatVideo() {
        searchPatVideo.click();
        log.info("Clicked How to Search Patients Video");
    } 
    
    public void clickDashboardVideo() {
        dashboardVideo.click();
        log.info("Clicked How to Use the Dashboard Video");
    } 
    
    public void clickOptPatListVideo() {
        optPatListVideo.click();
        log.info("Clicked Options on your Patient List Video");
    }
    
    public void clickPatDetailVideo() {
        patDetailVideo.click();
        log.info("Clicked Patient's Detail Page Video");
    }
    
    public void clickRevEditPatProfVideo() {
        revEditPatProfVideo.click();
        log.info("Clicked Review & Edit Patient's Profile Video");
    }
    
    public void clickViewTestSurvVideo() {
        viewTestSurvVideo.click();
        log.info("Clicked View and Score Tests and Surverys Video");
    }
    
    public void clickUseReportsVideo() {
        useReportsVideo.click();
        log.info("Clicked How to use Reports Video");
    }
    
    public void clickEditNewProgVideo() {
        editNewProgVideo.click();
        log.info("Clicked How to Edit/Create Patient's Program Video");
    }
    
    
    public void clickViewExcPlanVideo() {
        viewExcPlanVideo.click();
        log.info("Clicked Viewing Patient's Home Exercise Plan Video");
    }
    
    public void clickCreateClinVideo() {
        createClinVideo.click();
        log.info("Clicked How to Create a Clinician Video");
    }
    
    public void clickUseProtVideo() {
        useProtVideo.click();
        log.info("Clicked How to Use Protocols Video");
    }
    
    public void clickVideo() {
        
        log.info("Clicked Video");
    }
    
    public void click1Video() {
        
        log.info("Clicked Video");
    }
    
    public void click2Video() {
        
        log.info("Clicked Video");
    }
    
    public void click3Video() {
        
        log.info("Clicked Video");
    }
    
    public void clickUserManualLink() {
        dlUserManualLink.click();
        log.info("Clicked Download User Manual Link");
    }
}

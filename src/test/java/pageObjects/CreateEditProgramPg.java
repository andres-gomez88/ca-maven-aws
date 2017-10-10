
package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CreateEditProgramPg {
    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(CreateEditProgramPg.class.getName());
    
    @FindBy(xpath = "//*[@id='patient-summary']//div[1]/a/i")
    WebElement expandInfo;
    
    @FindBy(xpath = "//*[@id='plan-builder']/div[1]/div[1]/button")
    WebElement applyProtToPlan;
    
    //Apply Protocol Window
    @FindBy(xpath = "//span[text()='Select Protocol']")
    WebElement selectProtClick;
    
    @FindBy(xpath = "//input[@placeholder='Select Protocol']")
    WebElement selectProtTxtBox;
    
    @FindBy(xpath = "//div[@class='modal-footer ng-scope']//button[1]")
    WebElement cancelApplyProtBtn;
    
    @FindBy(xpath = "//div[@class='modal-footer ng-scope']//button[2]")
    WebElement applyProtBtn;
    
    //Search exercise and type
    @FindBy(xpath = "//div[@class='input-group search']/input")
    WebElement searchExcTxtBox;
    
    @FindBy(xpath = "//a[@class='btn btn-tertiary']")
    WebElement clearSearchBtn;
    
    @FindBy(xpath = "//div[@class='btn-group']/button[1]")
    WebElement exercisesTab;
    
    @FindBy(xpath = "//div[@class='btn-group']/button[2]")
    WebElement assessmentsTab;
    
    //Filters Tab Drop Down
    @FindBy(xpath = "//*[@id='plan-builder']//div[2]/div[2]/div[1]/button")
    WebElement bodyAreaFltrDrop;
    
    @FindBy(xpath = "//*[@id='plan-builder']//div[2]/div[2]/div[2]/button")
    WebElement movTypeFltrDrop;
    
    @FindBy(xpath = "//*[@id='plan-builder']//div[2]/div[2]/div[3]/button")
    WebElement modifiersFltrDrop;
    
    @FindBy(xpath = "//*[@id='plan-builder']//div[2]/div[2]/div[4]/button")
    WebElement equipTypeFltrDrop;
    
    //Body Area Filters
    @FindBy(xpath = "//*[@id='plan-builder']//div[1]/ul/li[1]/label/input")
    WebElement headBdyFltr;
    
    @FindBy(xpath = "//*[@id='plan-builder']//div[1]/ul/li[2]/label/input")
    WebElement spineBdyFltr;
    
    @FindBy(xpath = "//*[@id='plan-builder']//div[1]/ul/li[3]/label/input")
    WebElement cervicalBdyFltr;
    
    @FindBy(xpath = "//*[@id='plan-builder']//div[1]/ul/li[4]/label/input")
    WebElement thoracicBdyFltr;
    
    @FindBy(xpath = "//*[@id='plan-builder']//div[1]/ul/li[5]/label/input")
    WebElement lumbarBdyFltr;
    
    @FindBy(xpath = "//*[@id='plan-builder']//div[1]/ul/li[6]/label/input")
    WebElement upperBdyFltr;
    
    @FindBy(xpath = "//*[@id='plan-builder']//div[1]/ul/li[7]/label/input")
    WebElement lowerBdyFltr;
    
    @FindBy(xpath = "//*[@id='plan-builder']//div[1]/ul/li[8]/label/input")
    WebElement hipBdyFltr;
    
    @FindBy(xpath = "//*[@id='plan-builder']//div[1]/ul/li[9]/label/input")
    WebElement kneeBdyFltr;
    
    @FindBy(xpath = "//*[@id='plan-builder']//div[1]/ul/li[10]/label/input")
    WebElement ankleBdyFltr;
    
    @FindBy(xpath = "//*[@id='plan-builder']//div[1]/ul/li[11]/label/input")
    WebElement footBdyFltr;
    
    //Movement Type Filters
    @FindBy(xpath = "//*[@id='plan-builder']//div[2]/ul/li[1]/label/input")
    WebElement promMovFltr;
    
    @FindBy(xpath = "//*[@id='plan-builder']//div[2]/ul/li[2]/label/input")
    WebElement aaromMovFltr;
    
    @FindBy(xpath = "//*[@id='plan-builder']//div[2]/ul/li[3]/label/input")
    WebElement aromMovFltr;
    
    @FindBy(xpath = "//*[@id='plan-builder']//div[2]/ul/li[4]/label/input")
    WebElement stabiliMovFltr;
    
    @FindBy(xpath = "//*[@id='plan-builder']//div[2]/ul/li[5]/label/input")
    WebElement strengthMovFltr;
    
    @FindBy(xpath = "//*[@id='plan-builder']//div[2]/ul/li[6]/label/input")
    WebElement isometricMovFltr;    
    
    @FindBy(xpath = "//*[@id='plan-builder']//div[2]/ul/li[7]/label/input")
    WebElement balanceMovFltr;    
    
    @FindBy(xpath = "//*[@id='plan-builder']//div[2]/ul/li[8]/label/input")
    WebElement stretchMovFltr;    
    
    @FindBy(xpath = "//*[@id='plan-builder']//div[2]/ul/li[9]/label/input")
    WebElement adlMovFltr;
        
    @FindBy(xpath = "//*[@id='plan-builder']//div[2]/ul/li[10]/label/input")
    WebElement standTallMovFltr;
        
    @FindBy(xpath = "//*[@id='plan-builder']//div[2]/ul/li[11]/label/input")
    WebElement supineMovFltr;
    
    @FindBy(xpath = "//*[@id='plan-builder']//div[2]/ul/li[12]/label/input")
    WebElement sidelyingMovFltr;
    
    @FindBy(xpath = "//*[@id='plan-builder']//div[2]/ul/li[13]/label/input")
    WebElement proneMovFltr;
    
    @FindBy(xpath = "//*[@id='plan-builder']//div[2]/ul/li[14]/label/input")
    WebElement sitMovFltr;
    
    @FindBy(xpath = "//*[@id='plan-builder']//div[2]/ul/li[15]/label/input")
    WebElement standMovFltr;    
    
    //Modifiers Filters
    @FindBy(xpath = "//*[@id='plan-builder']//div[3]/ul/li[1]/label/input")
    WebElement nonWgBModFltr;
    
    @FindBy(xpath = "//*[@id='plan-builder']//div[3]/ul/li[2]/label/input")
    WebElement wgBearingModFltr;
    
    @FindBy(xpath = "//*[@id='plan-builder']//div[3]/ul/li[3]/label/input")
    WebElement openChainModFltr;
    
    @FindBy(xpath = "//*[@id='plan-builder']//div[3]/ul/li[4]/label/input")
    WebElement closedChainModFltr;
    
    //Equipment Type Filters
    @FindBy(xpath = "//*[@id='plan-builder']//div[4]/ul/li[1]/label/input")
    WebElement bandEquipFltr;
    
    @FindBy(xpath = "//*[@id='plan-builder']//div[4]/ul/li[2]/label/input")
    WebElement ballEquipFltr;
    
    @FindBy(xpath = "//*[@id='plan-builder']//div[4]/ul/li[3]/label/input")
    WebElement ankleWgEquipFltr;
    
    @FindBy(xpath = "//*[@id='plan-builder']//div[4]/ul/li[4]/label/input")
    WebElement chairEquipFltr;
    
    @FindBy(xpath = "//*[@id='plan-builder']//div[4]/ul/li[5]/label/input")
    WebElement tableEquipFltr;
    
    @FindBy(xpath = "//*[@id='plan-builder']//div[4]/ul/li[6]/label/input")
    WebElement stoolEquipFltr;
    
    @FindBy(xpath = "//*[@id='plan-builder']//div[4]/ul/li[7]/label/input")
    WebElement otherEquipFltr;
    
    //Exercises
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[1]/div")
    WebElement e01Bal3WayStarGrid;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[2]/div")
    WebElement e02AltDeepLunge;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[3]/div")
    WebElement e03AltShallowLunge;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[4]/div")
    WebElement e04CalfStretch;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[5]/div")
    WebElement e05CervSpineChinTuck;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[6]/div")
    WebElement e06CervSpineRotation;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[7]/div")
    WebElement e07Clams;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[8]/div")
    WebElement e08DeepLunge;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[9]/div")
    WebElement e09DeepSquat;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[10]/div")
    WebElement e10DblLegBridging;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[11]/div")
    WebElement e11DblLegWallSlide;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[12]/div")
    WebElement e12FeetTgthrBalance;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[13]/div")
    WebElement e13FwrdHeelTap;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[14]/div")
    WebElement e14HamstringStretch;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[15]/div")
    WebElement e15HeelProp;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[16]/div")
    WebElement e16HeelPropChair;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[17]/div")
    WebElement e17HeelSlideChair;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[18]/div")
    WebElement e18HeelToeBckwrd1H;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[19]/div")
    WebElement e19HeelToeBckwrd0H;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[20]/div")
    WebElement e20HeelToeFwrd1H;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[21]/div")
    WebElement e21HeelToeFwrd0H;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[22]/div")
    WebElement e22HeelWlk1H;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[23]/div")
    WebElement e23HeelWlk0H;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[24]/div")
    WebElement e24IsoHamstrngSet;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[25]/div")
    WebElement e25IsoQuadSet;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[26]/div")
    WebElement e26KneeBendChair0H;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[27]/div")
    WebElement e27KneeBendChair1H;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[28]/div")
    WebElement e28KneeBendChair2H;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[29]/div")
    WebElement e29KneeExt;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[30]/div")
    WebElement e30LatHeelTap;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[31]/div")
    WebElement e31LatWalk;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[32]/div")
    WebElement e32LatWalkResistBand;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[33]/div")
    WebElement e33LongSitHeelSlide;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[34]/div")
    WebElement e34PatellaMobiliztn;  
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[35]/div")
    WebElement e35Planks;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[36]/div")
    WebElement e36ProneHipExt;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[37]/div")
    WebElement e37ProneKneeHang;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[38]/div")
    WebElement e38QuadStretch;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[39]/div")
    WebElement e39SeatKneeFlexStrch;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[40]/div")
    WebElement e40ShallowLunge;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[41]/div")
    WebElement e41ShallowSquat;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[42]/div")
    WebElement e42ShortArcQuad;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[43]/div")
    WebElement e43SidelyingHipAbduct;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[44]/div")
    WebElement e44SidelyingHipAdduct;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[45]/div")
    WebElement e45SingleLegBal;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[46]/div")
    WebElement e46SingleLegBalChrOpp;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[47]/div")
    WebElement e47SingleLegBalChrSame;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[48]/div")
    WebElement e48SingleLegBridging;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[49]/div")
    WebElement e49SingleLegDeadlift;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[50]/div")
    WebElement e50SingleLegHeelRise;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[51]/div")
    WebElement e51SingleLegSquat;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[52]/div")
    WebElement e52SitStndChair0H;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[53]/div")
    WebElement e53SitStndChair1H;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[54]/div")
    WebElement e54SitStndChair2H;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[55]/div")
    WebElement e55SitAnklPumpChair;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[56]/div")
    WebElement e56SitBallSquezsChair;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[57]/div")
    WebElement e57SitCalfStrchWBand;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[58]/div")
    WebElement e58SitQuadBrainTrck;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[59]/div")
    WebElement e59StaggrdBal;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[60]/div")
    WebElement e60StaggrdSquat;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[61]/div")
    WebElement e61StandBackExt;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[62]/div")
    WebElement e62StandDblLegHeelRaise0H;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[63]/div")
    WebElement e63StandDblLegHeelRaise1H;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[64]/div")
    WebElement e64StandDblLegHeelRaise2H;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[65]/div")
    WebElement e65StandHipAbduct;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[66]/div")
    WebElement e66StandHipAdduct;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[67]/div")
    WebElement e67StandHipExt;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[68]/div")
    WebElement e68StandHipFlex;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[69]/div")
    WebElement e69StandHipFlexMarch;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[70]/div")
    WebElement e70StandKneeFlex;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[71]/div")
    WebElement e71StandToeRaises0H;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[72]/div")
    WebElement e72StandToeRaises1H;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[73]/div")
    WebElement e73StandToeRaises2H;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[74]/div")
    WebElement e74StandTrunkRot;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[75]/div")
    WebElement e75StepUp;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[76]/div")
    WebElement e76SupGluteSet;
    
    //@FindBy(xpath = "//ul[@class='exercises clearfix']/li[77]/div")
    //WebElement e77SupAnklePump;    
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[77]/div")
    WebElement e77SupHipAbduct;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[78]/div")
    WebElement e78SupQuadBrainTrck;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[79]/div")
    WebElement e79SupStrghtLegRaise;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[80]/div")
    WebElement e80TandemBal;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[81]/div")
    WebElement e81TermKneeExt;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[82]/div")
    WebElement e82ToeWalk1H;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[83]/div")
    WebElement e83ToeWalk0H;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[84]/div")
    WebElement e84VMOKicks;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[85]/div")
    WebElement e85WalkBack1H;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[86]/div")
    WebElement e86WalkBack0H;
    
    @FindBy(xpath = "//ul[@class='exercises clearfix']/li[87]/div")
    WebElement e87WalknTurn;
    
    //Assesments
    @FindBy(xpath = "//ul[@class='assessments clearfix']/li[1]/div")
    WebElement a01SitStand5Times;
    
    @FindBy(xpath = "//ul[@class='assessments clearfix']/li[2]/div")
    WebElement a02FeetTgthrBalTest;
    
    @FindBy(xpath = "//ul[@class='assessments clearfix']/li[3]/div")
    WebElement a03KneeExtTest;
    
    @FindBy(xpath = "//ul[@class='assessments clearfix']/li[4]/div")
    WebElement a04KneeFlexSitTest;
    
    @FindBy(xpath = "//ul[@class='assessments clearfix']/li[5]/div")
    WebElement a05SingleLegBalTest;
    
    @FindBy(xpath = "//ul[@class='assessments clearfix']/li[6]/div")
    WebElement a06SitStandTest;
    
    @FindBy(xpath = "//ul[@class='assessments clearfix']/li[7]/div")
    WebElement a07StaggrdBaltest;
    
    @FindBy(xpath = "//ul[@class='assessments clearfix']/li[8]/div")
    WebElement a08TandemBalTest;
    
    @FindBy(xpath = "//ul[@class='assessments clearfix']/li[9]/div")
    WebElement a09HOOSJr;
    
    @FindBy(xpath = "//ul[@class='assessments clearfix']/li[10]/div")
    WebElement a10KOOSJr;
    
    @FindBy(xpath = "//ul[@class='assessments clearfix']/li[11]/div")
    WebElement a11WOMAC;
    
    //Exercises Selection List
    @FindBy(xpath = "//a[@class='clear-all']")
    WebElement clearAllBtn;
    
    @FindBy(xpath = "//span[@ng-show='vm.exercises.length']")
    WebElement expColExcercises;
    
    @FindBy(xpath = "//button[text()='OK']")
    WebElement okBtn;
    
    /**
     * Exercise Row and Options
     * xpath of row = "//div[@class='plan-table']/div[2]/div[n]"
     * n = row number
     */
    @FindBy(xpath = "//div[@class='plan-table']/div[2]/div[1]/div[3]/div[1]/div[1]//a")
    WebElement excDesLinkRowE;
    
    @FindBy(xpath = "//div[@class='plan-table']/div[2]/div[1]/div[3]/div[1]/div[2]")
    WebElement srChkBoxRowE;
    
    @FindBy(xpath = "//div[@class='plan-table']/div[2]/div[1]/div[3]/div[1]/div[3]")
    WebElement biasClickDrpRowE;
    
    @FindBy(xpath = "//div[@class='plan-table']/div[2]/div[1]/div[3]/div[1]/div[3]//input[1]")
    WebElement biasTxtBoxRowE;
    
    @FindBy(xpath = "//div[@class='plan-table']/div[2]/div[1]/div[3]/div[1]/div[4]")
    WebElement setsClickDrpRowE;
    
    @FindBy(xpath = "//div[@class='plan-table']/div[2]/div[1]/div[3]/div[1]/div[4]//input[1]")
    WebElement setsTxtBoxRowE;
    
    @FindBy(xpath = "//div[@class='plan-table']/div[2]/div[1]/div[3]/div[1]/div[5]")
    WebElement repsClickDrpRowE;
    
    @FindBy(xpath = "//div[@class='plan-table']/div[2]/div[1]/div[3]/div[1]/div[5]//input[1]")
    WebElement repsTxtBoxRowE;
    
    @FindBy(xpath = "//div[@class='plan-table']/div[2]/div[1]/div[3]/div[1]/div[6]")
    WebElement xDayClickDrpRowE;
    
    @FindBy(xpath = "//div[@class='plan-table']/div[2]/div[1]/div[3]/div[1]/div[6]//input[1]")
    WebElement xDayTxtBoxRowE;
    
    @FindBy(xpath = "//div[@class='plan-table']/div[2]/div[1]/div[3]/div[1]/div[7]")
    WebElement freqClickDrpRowE;
    
    @FindBy(xpath = "//div[@class='plan-table']/div[2]/div[1]/div[3]/div[1]/div[7]//input[1]")
    WebElement freqTxtBoxRowE;
    
    @FindBy(xpath = "//div[@class='plan-table']/div[2]/div[1]/div[3]/div[2]/div[2]/a")
    WebElement editOptLinkRowE;
    
    @FindBy(xpath = "//div[@class='plan-table']/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]")
    WebElement equipClickDrpRowE;
    
    @FindBy(xpath = "//div[@class='plan-table']/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]//input[1]")
    WebElement equipTxtBoxRowE;
    
    @FindBy(xpath = "//div[@class='plan-table']/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]")
    WebElement holdPosClickDrpRowE;
    
    @FindBy(xpath = "//div[@class='plan-table']/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]//input[1]")
    WebElement holdPosTxtBoxRowE;
    
    @FindBy(xpath = "//div[@class='plan-table']/div[2]/div[1]/div[3]/div[2]/div[1]/div[3]")
    WebElement restRepClickDrpRowE;
    
    @FindBy(xpath = "//div[@class='plan-table']/div[2]/div[1]/div[3]/div[2]/div[1]/div[3]//input[1]")
    WebElement restRepTxtBoxRowE;
    
    @FindBy(xpath = "//div[@class='plan-table']/div[2]/div[1]/div[3]/div[2]/div[1]/div[4]")
    WebElement restSetClickDrpRowE;
    
    @FindBy(xpath = "//div[@class='plan-table']/div[2]/div[1]/div[3]/div[2]/div[1]/div[4]//input[1]")
    WebElement restSetTxtBoxRowE;
    
    @FindBy(xpath = "//div[@class='plan-table']/div[2]/div[1]/div[4]")
    WebElement extraOptRowE;
    
    @FindBy(xpath = "//div[@class='plan-table']/div[2]/div[1]/div[4]//li[1]")
    WebElement delExtraOptnRowE;
    
    @FindBy(xpath = "//div[@class='plan-table']/div[2]/div[1]/div[4]//li[2]")
    WebElement copyExtraOptnRowE;
    
    @FindBy(xpath = "//div[@class='plan-table']/div[2]/div[1]/div[4]//li[3]")
    WebElement resetExtraOptnRowE;   
    
    //Assessments Selection list
    @FindBy(xpath = "//*[@id='plan-builder']/div[3]/div/div[1]/span")
    WebElement expColAssessmnt;
    
    /**
     * Assessment Row and Options
     * xpath of row = "//form[@name='testForm']/div/div[n]/div[2]"
     * n = row number
     */
    @FindBy(xpath = "//form[@name='testForm']/div/div[1]/div[2]/div[2]//input")//Clear first
    WebElement startDateTxtBoxRowA;
    
    @FindBy(xpath = "//form[@name='testForm']//div[1]/div[2]/div[3]/div[2]/rflx-select[1]/div")
    WebElement freqClickDrpRowA;
    
    @FindBy(xpath = "//form[@name='testForm']//div[1]/div[2]/div[3]/div[2]/rflx-select[1]/div//input[1]")
    WebElement freqTxtBoxRowA;
    
    @FindBy(xpath = "//form[@name='testForm']/div/div[1]/div[2]/div[4]")
    WebElement biasClickDrpRowA;
    
    @FindBy(xpath = "//form[@name='testForm']/div/div[1]/div[2]/div[4]//input[1]")
    WebElement biasTxtBoxRowA;
    
    @FindBy(xpath = "//form[@name='testForm']/div/div[1]/div[2]/div[5]")
    WebElement extraOptRowA;
    
    @FindBy(xpath = "//form[@name='testForm']/div/div[1]/div[2]/div[5]//li[1]")
    WebElement delExtraOptnRowA;
    
    @FindBy(xpath = "//form[@name='testForm']/div/div[1]/div[2]/div[5]//li[3]")
    WebElement copyExtraOptnRowA;
    
    @FindBy(xpath = "//form[@name='testForm']/div/div[1]/div[2]/div[5]//li[4]")
    WebElement resetExtraOptnRowA;
    
    //Bottom Tab
    @FindBy(xpath = "//div[@class='pull-right']/div[1]")
    WebElement applyPrgmBtn;
    
    @FindBy(xpath = "//div[@class='pull-right']/div[2]")
    WebElement saveAsProtBtn;
    
    @FindBy(xpath = "//*[@id='plan-builder']/div[4]/div/div[3]")
    WebElement cancelPlanBtn;
    
    //Apply Program Confirmation Window
    @FindBy(xpath = "//div[@class='modal-footer ng-scope']/button[1]")
    WebElement cancelApplyBtn;
    
    @FindBy(xpath = "//div[@class='modal-footer ng-scope']/button[2]")
    WebElement contApplyBtn;
    
    //Save as Protocol Confirmation Window
    @FindBy(id = "name-input")
    WebElement protNameSaveTxtBox;
    
    @FindBy(id = "description-input")
    WebElement protDescSaveTxtBox;
    
    @FindBy(xpath = "//div[@class='modal-content']/div[3]/button[1]")
    WebElement cancelProtSaveBtn;
    
    @FindBy(xpath = "//div[@class='modal-content']/div[3]/button[2]")
    WebElement saveProtSaveBtn;
    
    public CreateEditProgramPg(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
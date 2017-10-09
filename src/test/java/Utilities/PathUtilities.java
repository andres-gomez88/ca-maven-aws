
package Utilities;

public class PathUtilities {
    private static String geckoDriverPath =   "/usr/local/share/geckodriver"; // "C:\\seleniumdriver\\geckodriver.exe";
    private static String chromeDriverPath = "/usr/local/share/chromedriver"; // "C:\\seleniumdriver\\chromedriver.exe";
    private static String excelPath = "C:\\Users\\User\\Documents\\NetBeansProjects\\CATest\\testData.xlsx";
    private static String extentRepPath = "/usr/local/share/reports/";
    private static String extentConfPath = "/var/lib/jenkins/workspace/ca-maven-aws-full/src/test/resources/extent-config.xml";
    private static String screenshotFFPath = "/usr/local/share/reports/firefox/";
    private static String screenshotCHPath = "/usr/local/share/reports/chrome/";

    public static String getGeckoDriverPath() {
        return geckoDriverPath;
    }

    public static String getChromeDriverPath() {
        return chromeDriverPath;
    }

    public static String getExcelPath() {
        return excelPath;
    }

    public static String getExtentRepPath() {
        return extentRepPath;
    }

    public static String getExtentConfPath() {
        return extentConfPath;
    }

    public static String getScreenshotFFPath() {
        return screenshotFFPath;
    }

    public static String getScreenshotCHPath() {
        return screenshotCHPath;
    }
}
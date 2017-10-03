/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

public class PathUtilities {
    private static String geckoDriverPath =   "geckodriver"; // "C:\\seleniumdriver\\geckodriver.exe";
    private static String chromeDriverPath = "/usr/local/share/chromedriver"; // "C:\\seleniumdriver\\chromedriver.exe";
    private static String excelPath = "C:\\Users\\User\\Documents\\NetBeansProjects\\CATest\\testData.xlsx";
    private static String extentRepPath = "/usr/local/share/reports/";
    private static String extentConfPath = "/var/lib/jenkins/workspace/ca-maven-aws/src/test/resources/extent-config.xml";
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

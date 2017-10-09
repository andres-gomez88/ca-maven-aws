
package Utilities;

import static Utilities.LoginEnvUtilities.finalEnvironment;
import static Utilities.PathUtilities.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentFactory {
    private static ExtentReports extent;
    
    public static ExtentReports createInstance(String browser) {
        ExtentHtmlReporter htmlReporter;
        htmlReporter = new ExtentHtmlReporter(getExtentRepPath() + browser + "report.html");
        htmlReporter.loadXMLConfig(getExtentConfPath());
        extent = new ExtentReports();        
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Browser", browser);
        String env = finalEnvironment().split("-")[0].substring(8);
        extent.setSystemInfo("Environment", env);
        return extent;
    }
    
    public static ExtentReports getInstance() {
        return extent;
    }
}

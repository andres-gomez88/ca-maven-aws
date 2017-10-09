
package Utilities;

import static Utilities.PathUtilities.*;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Screenshot {
    private static String finalPath = null;
    
    public static String takeScreenshotFF(String fileName, WebDriver driver) throws IOException, InterruptedException {
        Thread.sleep(2000);
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        finalPath = getScreenshotFFPath() + fileName + ".png";
        FileUtils.copyFile(screenshot, new File(finalPath));        
        return finalPath;        
    }
    
    public static String takeScreenshotCH(String fileName, WebDriver driver) throws IOException, InterruptedException {
        Thread.sleep(2000);
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        finalPath = getScreenshotCHPath() + fileName + ".png";
        FileUtils.copyFile(screenshot, new File(finalPath));        
        return finalPath;
    }
}

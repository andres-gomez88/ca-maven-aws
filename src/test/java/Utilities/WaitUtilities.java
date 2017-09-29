package Utilities;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities {


  public static void waitForVisibility(WebElement element, int sec, WebDriver driver) {
      (new WebDriverWait(driver, sec)).until(ExpectedConditions.visibilityOf(element));
  }

  public static void waitForClick(WebElement element, int sec, WebDriver driver) {
      (new WebDriverWait(driver, sec)).until(ExpectedConditions.elementToBeClickable(element));
  }

  public static void waitForVisibilityList(List<WebElement> elements, int sec, WebDriver driver) {
      (new WebDriverWait(driver, sec)).until(ExpectedConditions.visibilityOfAllElements(elements));
  }

  public static void waitForNoVisibility(List<WebElement> elements, int sec, WebDriver driver) {
      (new WebDriverWait(driver, sec)).until(ExpectedConditions.invisibilityOfAllElements(elements));
  }

  public static void waitForVisibilityText(WebElement element, int sec, String text, WebDriver driver) {
      (new WebDriverWait(driver, sec)).until(ExpectedConditions.textToBePresentInElement(element, text));
  }
}

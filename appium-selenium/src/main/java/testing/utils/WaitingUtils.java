package testing.utils;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testing.driver.DriverManager;

public class WaitingUtils {
    private static WebDriverWait wait = DriverManager.getWebDriverWait(10);

    public static MobileElement waitForVisibleOfElement(MobileElement element) {
        wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        return element;
    }

    /*
    public static void waitForPageToBeLoaded() {
        scriptWaiter("return document.readyState == 'complete'");
        scriptWaiter("return jQuery.active == 0");
    }
     */

}

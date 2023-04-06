package testing.assertions;

import io.appium.java_client.MobileElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testing.driver.DriverManager;

import static org.testng.Assert.assertTrue;

public class Assertions {
    static final Logger LOG = LogManager.getRootLogger();
    static final WebDriverWait webDriverWait = DriverManager.getWebDriverWait(10);

    public void assertThatElementIsVisible(MobileElement element) {
        assertTrue(webDriverWait.until(ExpectedConditions.visibilityOf(element)).isDisplayed(), "Assert on the page should be visible element " + element);
        LOG.info("Assert on the page should be visible element: " + element);
    }
}

package testing.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import testing.driver.DriverManager;

public class BasePage {
    protected AppiumDriver<MobileElement> driver;

    /*
    public BasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }
     */

    public BasePage() {
        this.driver = DriverManager.getDriver();
    }

}
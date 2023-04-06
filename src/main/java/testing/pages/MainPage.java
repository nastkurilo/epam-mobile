package testing.pages;

import io.appium.java_client.MobileElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import testing.utils.WaitingUtils;

public class MainPage extends BasePage{

    private static final Logger LOG = LogManager.getRootLogger();

    public MobileElement skipButton() {
        return driver.findElementByXPath("//android.view.ViewGroup[@content-desc='onBoarding-btn-skip']");
    }

    public MobileElement nextButton() {
        return driver.findElementByXPath("//android.widget.TextView[@text='Next']");
    }

    public MobileElement logInButton() {
        return WaitingUtils.waitForVisibleOfElement(driver.findElementByXPath("//android.widget.TextView[@text='Log In']"));
    }

    public MobileElement signUpButton() {
        return WaitingUtils.waitForVisibleOfElement(driver.findElementByXPath("//android.widget.TextView[@text='Sign Up']"));
    }

    public LogInPage clickLogInButton() {
        logInButton().click();
        return new LogInPage();
    }

    public void clickSkipButton() {
        WaitingUtils.waitForVisibleOfElement(skipButton()).click();
    }

    public MainPage clickNextButton() {
        nextButton().click();
        return this;
    }

    public SignUpPage clickSignUpButton() {
        signUpButton().click();
        return new SignUpPage();
    }

}

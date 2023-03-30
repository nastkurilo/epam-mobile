package testing.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MainPage extends BasePage{

    @AndroidBy(id = "onBoarding-btn-skip")
    private MobileElement skipButton;

    @AndroidBy(xpath = "//*[@resource-id='button_stretched']")
    private MobileElement nextButton;

    @AndroidBy(xpath = "//*[@resource-id='button_stretched'][1]")
    private MobileElement logInButton;

    @AndroidFindBy(id = "//*[@resource-id='button_stretched'][2]")
    private MobileElement signUpButton;

    public LogInPage clickLogInButton() {
        logInButton.click();
        return new LogInPage();
    }

    public SignUpPage clickSignUpButton() {
        signUpButton.click();
        return new SignUpPage();
    }

}

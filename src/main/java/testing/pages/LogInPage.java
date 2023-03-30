package testing.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LogInPage extends BasePage {

    @AndroidFindBy(id = "username")
    private MobileElement userNameField;

    @AndroidFindBy(id = "kc-login-next")
    private MobileElement continueButton;

    @AndroidFindBy(id = "form-login-social-show-more")
    private MobileElement showMoreButton;

    public LogInPage setUserNameField(String user) {
        userNameField.sendKeys(user);
        return this;
    }

    public LogInPage clickContinue() {
        continueButton.click();
        return this;
    }

}

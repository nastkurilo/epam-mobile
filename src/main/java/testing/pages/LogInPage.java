package testing.pages;

import io.appium.java_client.MobileElement;

public class LogInPage extends BasePage {

    public MobileElement userNameField() {
        return driver.findElementById("username");
    }

    public MobileElement continueButton() {
        return driver.findElementById("kc-login-next");
    }

    public MobileElement showMoreButton() {
        return driver.findElementById("form-login-social-show-more");
    }

    public LogInPage setUserNameField(String user) {
        userNameField().sendKeys(user);
        return this;
    }

    public LogInPage clickContinue() {
        continueButton().click();
        return this;
    }

    public LogInPage clickShowMoreButton() {
        showMoreButton().click();
        return this;
    }

}

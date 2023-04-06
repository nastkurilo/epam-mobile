package mobile.testing;

import org.testng.annotations.Test;
import testing.assertions.Assertions;
import testing.pages.MainPage;

public class LogInTest extends BaseTest {

    @Test
    public void setData() {
        MainPage mainPage = new MainPage();
        Assertions assertions = new Assertions();
        mainPage.clickSkipButton();
//        mainPage.clickNextButton();
        assertions.assertThatElementIsVisible(mainPage.logInButton());
        assertions.assertThatElementIsVisible(mainPage.signUpButton());

    }

}

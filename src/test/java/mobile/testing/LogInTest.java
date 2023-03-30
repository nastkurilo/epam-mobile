package mobile.testing;

import mobile.testing.BaseTest;
import org.testng.annotations.Test;
import testing.pages.MainPage;

public class LogInTest extends BaseTest {

    @Test
    public void setData() {
        MainPage m = new MainPage();
        m.clickLogInButton().setUserNameField("test").clickContinue();
    }

}

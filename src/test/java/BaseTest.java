import page.object.*;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import page.object.*;

public class BaseTest {
    WebDriver webDriver = BrowserSwitcher.get("chrome");

    SignInPage signInPage = new SignInPage(webDriver);
    MainPage mainPage = new MainPage(webDriver);
    SignUpPage signUpPage = new SignUpPage(webDriver);
    RecoverPasswordPage recoverPasswordPage = new RecoverPasswordPage(webDriver);
    PersonalAccountPage personalAccountPage = new PersonalAccountPage(webDriver);

    protected static String EMAIL = "burgerenjoyer@gmail.com";
    protected static String PASSWORD = "012345";
    protected static String INVALID_PASSWORD = "01234";
    protected static String NAME = "John";
    protected static String TOKEN;

    @After
    public void tearDownAndClearData() {
        webDriver.close();
        TOKEN = SignUpPage.getToken(EMAIL, PASSWORD);
        if (TOKEN != null) {
            SignUpPage.deleteUser(TOKEN);
        }
    }
}
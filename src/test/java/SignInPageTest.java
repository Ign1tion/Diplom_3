import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class SignInPageTest extends BaseTest {

    @Before
    public void setUp() {
        signUpPage.createUser(EMAIL, PASSWORD, NAME);
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    @Description("Signing in using button 'Войти в аккаунт' from the main page")
    public void signInFromMainPageTest() {
        webDriver.get(URLS.MAIN_PAGE);
        mainPage.loginButtonClick();
        signInPage.enterEmail(EMAIL);
        signInPage.enterPassword(PASSWORD);
        signInPage.clickEnter();
        Assert.assertTrue(mainPage.checkCreateOrderButtonVisibility());
    }

    @Test
    @Description("Signing in using button 'Личный кабинет' from the header")
    public void signInFromPersonalAccountTest() {
        webDriver.get(URLS.MAIN_PAGE);
        mainPage.personalAccountButtonClick();
        signInPage.enterEmail(EMAIL);
        signInPage.enterPassword(PASSWORD);
        signInPage.clickEnter();
        Assert.assertTrue(mainPage.checkCreateOrderButtonVisibility());
    }

    @Test
    @Description("Signing in using button 'Войти' from the sign up page")
    public void signInFromSignUpPageTest() {
        webDriver.get(URLS.SIGNUP_PAGE);
        signUpPage.signInButtonClick();
        signInPage.enterEmail(EMAIL);
        signInPage.enterPassword(PASSWORD);
        signInPage.clickEnter();
        Assert.assertTrue(mainPage.checkCreateOrderButtonVisibility());
    }

    @Test
    @Description("Signing in using button 'Войти' from the password recovery page")
    public void signInFromRecoveryPage() {
        webDriver.get(URLS.RECOVER_PASSWORD_PAGE);
        recoverPasswordPage.signInButtonClick();
        signInPage.enterEmail(EMAIL);
        signInPage.enterPassword(PASSWORD);
        signInPage.clickEnter();
        Assert.assertTrue(mainPage.checkCreateOrderButtonVisibility());

    }
}


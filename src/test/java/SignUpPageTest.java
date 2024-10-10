import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class SignUpPageTest extends BaseTest {
    @Before
    public void setUp() {
        signUpPage.openSignUpPage(URLS.SIGNUP_PAGE);
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    @Description("valid sign up test")
    public void signUpValidTest() {
        signUpPage.enterName(NAME);
        signUpPage.enterEmail(EMAIL);
        signUpPage.enterPassword(PASSWORD);
        signUpPage.signUpButtonClick();
        Assert.assertTrue(signInPage.checkEnterButton());
    }

    @Test
    @Description("invalid test with incorrect password length")
    public void signUpWithWrongPasswordLengthTest() {
        signUpPage.enterName(NAME);
        signUpPage.enterEmail(EMAIL);
        signUpPage.enterPassword(INVALID_PASSWORD);
        signUpPage.signUpButtonClick();
        Assert.assertTrue(signUpPage.checkPasswordError());

    }
}

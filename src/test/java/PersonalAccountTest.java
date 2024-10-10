import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class PersonalAccountTest extends BaseTest {
    @Before
    public void setUp() {
        signUpPage.createUser(EMAIL, PASSWORD, NAME);
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get(URLS.SIGNIN_PAGE);
        signInPage.enterEmail(EMAIL);
        signInPage.enterPassword(PASSWORD);
        signInPage.clickEnter();
    }

    @Test
    @Description("checking redirection from main page to personal account page with signed in user")
    public void personalAccountRedirectionTest() {
        mainPage.personalAccountButtonClick();
        Assert.assertTrue(personalAccountPage.checkIfExitButtonVisible());
    }

    @Test
    @Description("checking redirection from personal account page to main page using 'Конструктор' button")
    public void personalAccountPageToMainPageConstructorButtonClickTest() {
        mainPage.personalAccountButtonClick();
        mainPage.constructorButtonClick();
        Assert.assertTrue(mainPage.checkCreateOrderButtonVisibility());
    }

    @Test
    @Description("checking redirection from personal account page to main page using 'stellar-burgers' logo button")
    public void personalAccountPageToMainPageLogoButtonClickTest() {
        mainPage.personalAccountButtonClick();
        mainPage.logoClick();
        Assert.assertTrue(mainPage.checkCreateOrderButtonVisibility());
    }

    @Test
    @Description("signing out using 'Выход' button and redirecting from personal account page to login page")
    public void signOutTest() {
        mainPage.personalAccountButtonClick();
        personalAccountPage.signOutButtonClick();
        Assert.assertTrue(signInPage.checkEnterButton());
    }

}

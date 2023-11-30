import io.qameta.allure.Description;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class MainPageTest extends BaseTest {
    @Before
    public void setUp() {
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get(URLS.MAIN_PAGE);
    }

    @Test
    @Description("checking if 'Булки' tab is active")
    public void checkIfBunsTabActive() {
        mainPage.checkActiveTab("Булки");
    }

    @Test
    @Description("clicking on 'Соусы' tab and checking if it's active")
    public void clickSauseTabAndCheckActivity() {
        mainPage.sauseButtonClick();
        mainPage.checkActiveTab("Соусы");
    }

    @Test
    @Description("clicking on 'Начинки' tab and checking if its active")
    public void clickFillingTabAndCheckActivity() {
        mainPage.fillingButtonClick();
        mainPage.checkActiveTab("Начинки");
    }

}

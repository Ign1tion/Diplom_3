package page.object;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver webDriver;
    private By personalAccountButton = (By.linkText("Личный Кабинет"));
    private By loginButton = (By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']"));
    private By bunButton = (By.xpath(".//div/span[text()='Булки']"));
    private By sauseButton = (By.xpath(".//div/span[text()='Соусы']"));
    private By fillingButton = (By.xpath(".//div/span[text()='Начинки']"));
    private By activeButton = (By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']"));
    private By constructorButton = (By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2']"));
    private By logoButton = (By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']"));
    private By createOrderButton = (By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']"));

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("clicking on 'Личный кабинет' button")
    public void personalAccountButtonClick() {
        webDriver.findElement(personalAccountButton).click();
    }

    @Step("clicking on'Войти в аккаунт' button")
    public void loginButtonClick() {
        webDriver.findElement(loginButton).click();
    }

    @Step("clicking on 'Булки' button")
    public void bunButtonClick() {
        webDriver.findElement(bunButton).click();
    }

    @Step("clicking on 'Соусы' button")
    public void sauseButtonClick() {
        webDriver.findElement(sauseButton).click();
    }

    @Step("clicking on 'Начинки' button")
    public void fillingButtonClick() {
        webDriver.findElement(fillingButton).click();
    }

    @Step("clicking on 'Конструктор' button")
    public void constructorButtonClick() {
        webDriver.findElement(constructorButton).click();
    }

    @Step("clicking on header logo 'stellar burgers'")
    public void logoClick() {
        webDriver.findElement(logoButton).click();
    }

    @Step("Checking 'Оформить заказ' button visibility")
    public boolean checkCreateOrderButtonVisibility() {
        return webDriver.findElement(createOrderButton).isDisplayed();
    }

    @Step("Active tab check")
    public String getActiveTab() {
        return webDriver.findElement(activeButton).getText();
    }
}
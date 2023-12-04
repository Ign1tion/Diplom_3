package page.object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    WebDriver webDriver;

    private final By emailField = By.xpath(".//fieldset[1]//input");
    private By passwordField = By.xpath(".//input[@name='Пароль']");
    private By enterButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private By registerButton = By.xpath(".//a[.='Зарегистрироваться']");
    private By recoverPasswordButton = By.xpath(".//a[.='Восстановить пароль']");

    public SignInPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("entering data in 'Email' field")
    public void enterEmail(String email) {
        webDriver.findElement(emailField).sendKeys(email);

    }

    @Step("entering data in 'Пароль' field")

    public void enterPassword(String password) {
        webDriver.findElement(passwordField).sendKeys(password);
    }

    @Step("clicking 'Войти' button")
    public void clickEnter() {
        webDriver.findElement(enterButton).click();
    }

    @Step("clicking register button")
    public void clickRegister() {
        webDriver.findElement(registerButton).click();
    }

    @Step("clicking 'Восстановить пароль' button")
    public void clickRecoverPasswordButton() {
        webDriver.findElement(recoverPasswordButton).click();
    }

    @Step("'Вход' button check")
    public boolean checkEnterButton() {
        return webDriver.findElement(enterButton).isDisplayed();
    }
}






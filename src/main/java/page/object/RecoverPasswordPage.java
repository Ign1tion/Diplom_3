package page.object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoverPasswordPage {
    private WebDriver webDriver;
    private By emailField = By.xpath(".//div[@class='input pr-6 pl-6 input_type_text input_size_default']");
    private By recoverButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private By loginButton = By.xpath(".//a[@class='Auth_link__1fOlj']");

    public RecoverPasswordPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("entering data in 'Email' field")
    public void enterEmail(String email) {
        webDriver.findElement(emailField).sendKeys(email);
    }

    @Step("clicking 'Восстановить' button")
    public void recoverButtonClick() {
        webDriver.findElement(recoverButton).click();
    }

    @Step("clicking 'Войти' button")
    public void signInButtonClick() {
        webDriver.findElement(loginButton).click();
    }
}

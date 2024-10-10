package page.object;

import io.qameta.allure.Step;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static io.restassured.RestAssured.given;

public class SignUpPage {
    WebDriver webDriver;

    private By nameField = By.xpath(".//fieldset[1]//input[@type='text']");
    private By emailField = By.xpath(".//fieldset[2]//input[@type='text']");
    private By passwordField = By.xpath(".//input[@type='password']");
    private By signUpButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private By signInButton = By.xpath(".//a[@class='Auth_link__1fOlj']");
    private By incorrectPasswordError = By.cssSelector(".input__error");

    public SignUpPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("opening sign up page")
    public void openSignUpPage(String url) {
        webDriver.get(url);
    }

    @Step("entering data in 'Имя' field")
    public void enterName(String name) {
        webDriver.findElement(nameField).sendKeys(name);
    }

    @Step("entering data in 'Email' field")
    public void enterEmail(String email) {
        webDriver.findElement(emailField).sendKeys(email);
    }

    @Step("entering data in 'Пароль' field")
    public void enterPassword(String password) {
        webDriver.findElement(passwordField).sendKeys(password);
    }

    @Step("clicking on 'Зарегистрироваться' button")
    public void signUpButtonClick() {
        webDriver.findElement(signUpButton).click();
    }

    @Step("clicking on 'Войти' button")
    public void signInButtonClick() {
        webDriver.findElement(signInButton).click();
    }

    @Step("password error message check")
    public boolean checkPasswordError() {
        return webDriver.findElement(incorrectPasswordError).isDisplayed();
    }


    @Step("authorizing user via api")
    public static String getToken(String email, String password) {
        User user = new User(email, password);
        return given()
                .header("content-type", "application/json")
                .body(user)
                .when()
                .post("https://stellarburgers.nomoreparties.site/api/auth/login")
                .then()
                .extract().path("accessToken");
    }

    @Step("Creating user via api")
    public static Response createUser(String email, String password, String name) {
        User user = new User(email, password, name);
        return given()
                .header("content-type", "application/json")
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .body(user)
                .when()
                .post("https://stellarburgers.nomoreparties.site/api/auth/register");
    }

    @Step("deleting user via api")
    public static void deleteUser(String token) {
        given()
                .header("authorization", token)
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .when()
                .delete("https://stellarburgers.nomoreparties.site/api/auth/user")
                .then()
                .assertThat()
                .statusCode(202);
    }
}

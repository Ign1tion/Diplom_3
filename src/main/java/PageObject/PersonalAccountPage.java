package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage {
    WebDriver webDriver;
    private By signOutButton = By.xpath(".//button[text()='Выход']");

    public PersonalAccountPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("clicking 'Выход' button")
    public void signOutButtonClick() {
        webDriver.findElement(signOutButton).click();
    }

    @Step("checking visibility of 'Выход' button")
    public boolean checkIfExitButtonVisible() {
        return webDriver.findElement(signOutButton).isDisplayed();
    }
}

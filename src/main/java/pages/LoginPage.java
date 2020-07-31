package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(id = "Email")
    WebElement emailInput;

    @FindBy(id = "identifierNext")
    WebElement nextButton;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "passwordNext")
    WebElement nextButton2;

    private String email = "testqaqmoneuman@gmail.com";
    private String password = "Moneymanaqa1";

    public void login() {
        emailInput.sendKeys(email);
        nextButton.click();
        passwordInput.sendKeys(password);
        nextButton2.click();
    }
}

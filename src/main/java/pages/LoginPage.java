package pages;

import static core.Locators.get;
import static core.WebDriverContainer.findElement;
import static core.WebDriverContainer.getDriver;

import core.Locators;
import core.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {
    WebDriver driver;

    private static By emailInput = get("LoginPage.emailInput");
    private static By nextButton = get("LoginPage.nextButton");
    private static By passwordInput = get("LoginPage.passwordInput");
    private static By nextButton2 = get("LoginPage.nextButton2");

    private static String email = "testqaqmoneuman@gmail.com";
    private static String password = "Moneymanaqa1";
    private static final String TITLE = "Login page title";

    public static void shouldAppear() {
        shouldAppear(TITLE);
    }

    public static void login() {
        findElement(emailInput).sendKeys(email);
        findElement(nextButton).click();
        findElement(passwordInput).sendKeys(password);
        findElement(nextButton2).click();
    }
}

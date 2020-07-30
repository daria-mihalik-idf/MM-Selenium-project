package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private static By emailInput = By.id("identifierId");
    private static By nextButton = By.id("identifierNext");
    private static By nextButton2 = By.id("passwordNext");
    private static By passwordInput = By.name("password");
    private static String email = "testqaqmoneuman@gmail.com";
    private static String password = "Moneymanaqa1";

    public static void login(WebDriver driver) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(nextButton).click();
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(nextButton2).click();
    }

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    WebDriver driver;

    private By emailInput = By.id("Email");
    private By nextButton = By.id("nextButton");
    private By passwordInput = By.id("password");
    private By nextButton2 = By.id("passwordNext");
    private String email = "testqaqmoneuman@gmail.com";
    private String password = "Moneymanaqa1";

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public GoogleHomePage login() {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(nextButton).click();
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(nextButton2).click();
        return new GoogleHomePage(driver);
    }
}

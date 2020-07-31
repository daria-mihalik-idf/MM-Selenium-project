package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleHomePage {

    private By signInButton = By.id ("gb_70");
    private By gmailButton = By.cssSelector ("[href=\"https://mail.google.com/mail/?tab=wm&ogbl\"]");
    WebDriver driver;
    public GoogleHomePage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage clickSignInButton() {
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public GMailPage goToGmail() {
        driver.findElement(gmailButton).click();
        return new GMailPage(driver);
    }

}

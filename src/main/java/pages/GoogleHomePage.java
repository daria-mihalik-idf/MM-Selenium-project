package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleHomePage {
    private static final By signInButton = By.id("gb_70");
    private static final By gmailButton = By.cssSelector("[href=\"https://mail.google.com/mail/?tab=wm&ogbl\"]");

    public static void clickSignInButton(WebDriver driver) {
        driver.findElement(signInButton).click();
    }

    public static void goToGmail(WebDriver driver) {
        driver.findElement(gmailButton).click();
    }

}

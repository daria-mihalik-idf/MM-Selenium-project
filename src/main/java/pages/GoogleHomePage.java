package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleHomePage {

    @FindBy(id = "gb_70")
    WebElement signInButton;

    @FindBy(css = "[href=\"https://mail.google.com/mail/?tab=wm&ogbl\"]")
    WebElement gmailButton;

    public void clickSignInButton() {
        signInButton.click();
    }

    public void goToGmail() {
        gmailButton.click();
    }
}

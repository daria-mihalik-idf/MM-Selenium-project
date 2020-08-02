package pages;

import core.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static core.Locators.get;
import static core.WebDriverContainer.findElement;
import static core.WebDriverContainer.getDriver;
import static helpers.Waiter.waitForJQuery;


public class GoogleHomePage extends PageBase {

    private static By signInButton = get("GoogleHomePage.signInButton");
    private static By gmailButton = get("GoogleHomePage.gmailButton");
    private static final String TITLE = "Home age title";


    public static void clickSignInButton(WebDriver driver) {
        findElement(signInButton).click();
    }

    public static void goToGmail() {
        findElement(gmailButton).click();
        waitForJQuery();
    }

    public static void shouldAppear() {
        shouldAppear(TITLE);
    }

    public static void clickSignInButton() {
    }
}

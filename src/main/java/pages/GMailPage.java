package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GMailPage {

    private By emailLinks = By.cssSelector("div[role='grid'] tbody>tr");
    WebDriver driver;

    public GMailPage(WebDriver driver) {
        this.driver = driver;
    }


    public GMailPage assertNumberOfEmailsIs(int number) {
        assertEquals(driver.findElements(emailLinks).size(), number);
        return this;
    }
}

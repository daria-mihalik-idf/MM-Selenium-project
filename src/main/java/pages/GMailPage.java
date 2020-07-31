package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GMailPage {

    @FindAll({@FindBy(css = "div[role='grid'] tbody>tr")})
    List<WebElement> emailLinks;

    public int countEmails() {
        return emailLinks.size();
    }
}

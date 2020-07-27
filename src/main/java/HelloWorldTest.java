import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class HelloWorldTest extends BaseTest {
    @Test
    public void googleTest() {
        driver.get("https://www.google.by/");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        searchBox.submit();
        List<WebElement> searchResults = driver.findElements(By.cssSelector(".r"));
        for (WebElement searchResult : searchResults) {
            System.out.println(searchResult.getText() + "=====");
            if (!searchResult.getText().toLowerCase().contains("selenium")) {
                fail("Not all elements contain the search phrase");
            }
        }
    }
}

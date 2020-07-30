import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LocatorsTest extends BaseTest {
    @Test
    public void locatorsTest() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement startButton = driver.findElement(By.cssSelector("#start>button"));
        startButton.click();
        WebDriverWait waiter = new WebDriverWait(driver, 10);
        WebElement helloWorld = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish>h4")));
//        WebElement helloWorld = driver.findElement(By.cssSelector("#finish>h4"));
        helloWorld.click();
//        WebElement searchBox = driver.findElement(By.name("q"));
//        searchBox.sendKeys("Hello,world");

//        WebElement searchButton = driver.findElement(By.name("btnK"));
//        searchButton.click();

//        WebElement searchResult = driver.findElement(By.linkText("HELLO WORLD"));
//        WebElement searchResult = driver.findElement(By.partialLinkText("Hello, World!"));
//        searchResult.click();
//        List<WebElement> searchResults = driver.findElements(By.className("r"));
//        System.out.println(searchResults.size());

//        WebElement firstSearchResult = driver.findElement(By.className("h3[class='r']"));
////        WebElement firstSearchResult = driver.findElement(By.className("h3[class=\"r\"]"));
//        WebElement resultLink = firstSearchResult.findElement(By.tagName("a"));
//        firstSearchResult.click();
//        resultLink.click();
    }
}

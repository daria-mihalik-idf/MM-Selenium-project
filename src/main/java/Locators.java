import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Locators {
    @Test
    public void locatorsTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.by/");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Hello,world");
        WebElement searchButton = driver.findElement(By.name("btnK"));
        searchButton.click();
//        WebElement searchResult = driver.findElement(By.linkText("HELLO WORLD"));
        WebElement searchResult = driver.findElement(By.partialLinkText("Hello, World!"));
        searchResult.click();
//        List<WebElement> searchResults = driver.findElements(By.className("r"));
//        System.out.println(searchResults.size());

//        WebElement firstSearchResult = driver.findElement(By.className("r"));
//        WebElement resultLink = firstSearchResult.findElement(By.tagName("a"));
//        firstSearchResult.click();
//        resultLink.click();
    }
}

import com.sun.tracing.dtrace.Attributes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.fail;

public class HelloWorld {
    @Test
    public void googleTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
        driver.quit();
    }
}

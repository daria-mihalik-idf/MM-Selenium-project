import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControllingTest extends BaseTest {
    @Test
    public void customWaitTest() {
        Boolean jQueryFinished = (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                return (Boolean) js.executeScript("return jQuery.active === 0");
            }
        });
    }

    @Test
    public void multipleWindowTest() {
        driver.get("https://the-internet.herokuapp.com/windows/new");
        String initialWindowHandle = driver.getWindowHandle();
        driver.findElement(By.cssSelector(".example>a")).click();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        WebElement text = driver.findElement(By.tagName("h3"));
        assertEquals(text.getText(), "New Window");
        driver.close();
        driver.switchTo().window(initialWindowHandle);
        text = driver.findElement(By.tagName("h3"));
        assertEquals(text.getText(), "Opening a new window");
    }

    @Test
    public void alertTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//        driver.findElement(By.cssSelector("[onclick='jsAlert()']")).click();
//        driver.findElement(By.cssSelector("[onclick='jsConfirm()']")).click();
        driver.findElement(By.cssSelector("[onclick='jsPrompt()']")).click();
        Alert alert = driver.switchTo().alert();
//        assertEquals(alert.getText(), "I am a JS Alert");
//        Thread.sleep(1000);
//        alert.accept();
        alert.sendKeys("Selenium is awesome");
        Thread.sleep(1000);
        alert.accept();

    }

    @Test
    public void framesTest() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        assertEquals(driver.findElement(By.tagName("body")).getText(), "LEFT");

//        driver.switchTo().defaultContent();
//        driver.switchTo().frame("frame-top");
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        assertEquals(driver.findElement(By.tagName("body")).getText(), "RIGHT");
    }
}
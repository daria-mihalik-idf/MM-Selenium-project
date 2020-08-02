import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static org.junit.Assert.assertEquals;

public class WebStorageTest extends BaseTest {

    @Test
    public void webStorageTest() {
        String localStr = "Local";
        String sessionStr = "Session";

        driver.get("https://bestvpn.org/html5demos/storage/");

        driver.findElement(By.id("session")).sendKeys(sessionStr);
        driver.findElement(By.id("local")).sendKeys(localStr);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        String localStorage = (String) js.executeScript("return localStorage.value");
        String sessionStorage = (String) js.executeScript("return sessionStorage.value");

        assertEquals(localStorage, localStr);
        assertEquals(sessionStorage, sessionStr);
    }
}

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    public WebDriver driver;

    @BeforeEach
    public void init() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver.exe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterEach
    public void quitSession() {
        driver.quit();
    }
}


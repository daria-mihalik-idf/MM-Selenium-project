import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.GMailPage;
import pages.GoogleHomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GMailTest {
    WebDriver driver;

    @Test
    public void loginTest() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver.exe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.google.by/");
        GoogleHomePage.clickSignInButton(driver);
        LoginPage.login(driver);
        GoogleHomePage.goToGmail(driver);
        assertEquals(GMailPage.countEmails(driver), 3);
    }
}

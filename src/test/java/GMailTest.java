import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.GMailPage;
import pages.GoogleHomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GMailTest extends BaseTest {

    @Test
    public void loginTest() {
        GoogleHomePage page = new GoogleHomePage(driver);
        driver.get("https://www.google.by/");
        page
                .clickSignInButton()
                .login()
                .goToGmail()
                .assertNumberOfEmailsIs(3);
    }
}

import core.TestBase;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import pages.GMailPage;
import pages.GoogleHomePage;
import pages.LoginPage;

import java.net.URL;

class GMailTest extends TestBase {

    @Test
    public void loginTest() {
        GoogleHomePage.clickSignInButton();
        LoginPage.shouldAppear();
        LoginPage.login();
        GoogleHomePage.shouldAppear();
        GoogleHomePage.goToGmail();
        GMailPage.shouldAppear();
        GMailPage.assertNumberOfEmailsIs(3);
    }

    @Test
    public void seleniumGridTest() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setPlatform(Platform.WIN10);
        caps.setBrowserName("chrome");

        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:444/wb/hub"), caps);

        driver.get("https://mail.google.com/");
        Thread.sleep(3000);
    }
}

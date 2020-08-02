package core;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static core.WebDriverContainer.*;

public class TestBase {
    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver.exe");
        setDriver(WebDriverContainer.Driver.Chrome);
        open("https://www.google.by/");
    }

    @AfterTest
    public void tearDown() {
        quit();
    }
}



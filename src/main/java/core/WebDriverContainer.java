package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebDriverContainer {
    public enum Driver {
        Firefox, Chrome, IE
    }

    private static Driver driverType;
    private static WebDriver driver = null;

    private WebDriverContainer() {
        //block constructor
    }

    public static void setDriver(Driver driverType) {
        WebDriverContainer.driverType = driverType;
    }

    public static WebDriver getDriver() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        if (driver == null) {
            switch (driverType) {
                case Firefox:
                    caps.setBrowserName("firefox");
                    break;
                case Chrome:
                    caps.setBrowserName("chrome");
                    break;
                case IE:
                    caps.setBrowserName("internet explorer");
                    break;
                default:
                    caps.setBrowserName("chrome");
                    break;
            }
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:444/wb/hub"), caps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static WebElement findElement(By locator) {
        return getDriver().findElement(locator);
    }

    public static List<WebElement> findElements(By locator) {
        return getDriver().findElements(locator);
    }

    public static void open(String url) {
        getDriver().get(url);
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}

package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

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

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (driverType) {
                case Firefox:
                    driver = new FirefoxDriver();
                    break;
                case Chrome:
                    driver = new ChromeDriver();
                    break;
                case IE:
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    driver = new ChromeDriver();
                    break;
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

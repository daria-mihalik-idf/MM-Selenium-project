package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.WebDriverContainer.getDriver;

public class Waiter {
    private static final int DEFAULT_TIMEOUT = 10;

    public static void waitFor(ExpectedCondition condition) {
        new WebDriverWait(getDriver(), DEFAULT_TIMEOUT).until(condition);
    }

    public static void waitForJQuery() {
        new WebDriverWait(getDriver(), DEFAULT_TIMEOUT).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                JavascriptExecutor js = (JavascriptExecutor) webDriver;
                return (Boolean) js.executeScript("return jQuery.active === 0");
            }
        });
    }
}

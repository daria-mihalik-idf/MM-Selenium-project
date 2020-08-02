import org.junit.Test;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.logging.Level;

public class LoggingTest extends BaseTest {

    @Test
    public void loggingTest() {
        LoggingPreferences logs = new LoggingPreferences();
        logs.enable(LogType.DRIVER, Level.INFO);
        logs.enable(LogType.PERFORMANCE, Level.ALL);
        logs.enable(LogType.BROWSER, Level.SEVERE);

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(CapabilityType.LOGGING_PREFS, logs);
        driver.get("https://the-internet.herokuapp.com/");
        printLogs();
    }

    private void printLogs() {
        LogEntries logEntries = driver.manage().logs().get(LogType.DRIVER);
        for (LogEntry logEntry : logEntries) {
            System.out.println(logEntry.getMessage());
        }
    }
}

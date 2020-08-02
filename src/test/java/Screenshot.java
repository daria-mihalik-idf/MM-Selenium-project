import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class Screenshot extends BaseTest {

    public static File captureScreenshot(WebDriver driver, WebElement element) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage img = ImageIO.read(screenshot);
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();

        Rectangle rectangle = new Rectangle(width, height);
        org.openqa.selenium.Point point = element.getLocation();
        BufferedImage dest = img.getSubimage(point.getX(), point.getY(), rectangle.width, rectangle.height);
        ImageIO.write(dest, "png", screenshot);

        return screenshot;
    }

    @Test
    public void screenshotTest() throws IOException {
        driver.get("https://www.google.com/search?q=nice+pictire&rlz=1C1GCEU_ruBY853BY853&oq=nice+pictire&aqs=chrome..69i57.6498j0j1&sourceid=chrome&ie=UTF-8");

        WebElement picture = driver.findElement(By.className("BA0A6c"));
        FileUtils.copyFile(captureScreenshot(driver, picture), new File("C:\\Users\\USER\\Pictures\\picture.png"));
    }
}

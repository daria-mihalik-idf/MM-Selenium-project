import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.xml.transform.Result;
import java.awt.*;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CanvasTest extends BaseTest {
    @Test
    public void CanvasTest() throws InterruptedException, IOException {
        String initialFilePath = "C:\\Users\\USER\\Pictures\\initialFile.png";
        String actualFilePath = "C:\\Users\\USER\\Pictures\\actualFile.png";

        driver.get("https://www.youidraw.com/apps/painter/");
        WebElement canvas = driver.findElement(By.id("catch"));

        driver.findElement(By.id("brush")).click();

        FileUtils.copyFile(Screenshot.captureScreenshot(driver, canvas), new File(initialFilePath));


        Actions builder = new Actions(driver);
        builder.clickAndHold(canvas)
                .moveByOffset(50, 50)
                .moveByOffset(-50, 50)
                .moveByOffset(-50, 50)
                .moveByOffset(50, -50)
                .release().perform();

        FileUtils.copyFile(Screenshot.captureScreenshot(driver, canvas), new File(actualFilePath));

        assertEquals(Screenshot.Result.PIXEL_MISMATCH, Screenshot.compareImages(initialFilePath, actualFilePath));

        Thread.sleep(1000);
    }

    public static Result compareImages(String baseFile, String actualFile) throws InterruptedException {
        Result compareResult = Result.PIXEL_MISMATCH;
        Image baseImage = Toolkit.getDefaultToolkit().getImage(baseFile);
        Image actualImage = Toolkit.getDefaultToolkit().getImage(actualFile);

        PixelGrabber baseImageGrab = new PixelGrabber(baseImage, 0, 0, -1, -1, false);
        PixelGrabber actualImageGrab = new PixelGrabber(actualImage, 0, 0, -1, -1, false);
        int[] baseImageData = null;
        int[] actualImageData = null;

        if (baseImageGrab.grabPixels()) {
            baseImageData = (int[]) baseImageGrab.getPixels();

        }
        if (actualImageGrab.grabPixels()) {
            actualImageData = (int[]) actualImageGrab.getPixels();
        }

        if ((baseImageGrab.getHeight() != actualImageGrab.getHeight() || (baseImageGrab.getWidth() != actualImageGrab.getWidth()))) {
            compareResult = Result.SIZE_MISMATCH;
        } else if (Arrays.equals(baseImageData, actualImageData)) {
            compareResult = Result.MATCH;
        }
        return compareResult;
    }
}

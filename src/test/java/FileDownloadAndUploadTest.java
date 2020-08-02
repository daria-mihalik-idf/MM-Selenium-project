import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpHead;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

public class FileDownloadAndUploadTest extends BaseTest {

    @Test
    public void fileDownloadTest() throws IOException {
        driver.get("https://the-internet.herokuapp.com/download");
        WebElement link = driver.findElement(By.cssSelector("div.example>a"));
        String linkText = link.getAttribute("href");

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpHead request = new HttpHead(linkText);
        HttpResponse response = httpClient.execute(request);

        String contentType = response.getFirstHeader("Content-Type").getValue();
        int contentLength = Integer.parseInt(response.getFirstHeader("Content-Length").getValue());

        assertEquals(contentType, "video/mp2t");
        assertTrue(contentLength == 0);
    }

    @Test
    public void fileUpload() throws InterruptedException, MalformedURLException {
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        RemoteWebDriver driver = new RemoteWebDriver(new URL("hub.url"), caps);
        driver.setFileDetector(new LocalFileDetector());

        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement upload = driver.findElement(By.id("file-upload"));

        File file = new File("src/test/resources/testng.xml");
        upload.sendKeys(file.getAbsolutePath());
        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(3000);
    }
}




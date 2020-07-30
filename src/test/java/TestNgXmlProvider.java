import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;

public class TestNgXmlProvider extends BaseTest {
    @Test
    @Parameters(value = "searchText")
    public void googleSearchTest(String searchText) throws InterruptedException {
        driver.get("https://www.google.by/");
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys(searchText);
        searchField.submit();
        Thread.sleep(2000);
    }
}

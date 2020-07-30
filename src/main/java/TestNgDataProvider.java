import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNgDataProvider extends BaseTest {
    @DataProvider(name = "TestNG Data Provider")
    public Object[][] data() {
        return new Object[][]{{"Selenium"}, {"Hello World"}, {"TestNG Data Proveder"}};
    }

    @Test(dataProvider = "TestNG Data Provider")
    public void googleSearchTest(String searchText) throws InterruptedException {
        driver.get("https://www.google.by/");
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys(searchText);
        searchField.submit();
        Thread.sleep(2000);
    }
}


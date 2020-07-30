import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
class JUnitDataDriven extends BaseTest {
    String searchText;

    public JUnitDataDriven(String searchText) {
        this.searchText = searchText;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{"Selenium"}, {"Hello World"}, {"JUnit Data Driven Testing"}};
        return Arrays.asList(data);
    }

    @Test
    public void googleSearchTest() throws InterruptedException {
        driver.get("https://www.google.by/");
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys(searchText);
        searchField.submit();
        Thread.sleep(2000);
    }
}


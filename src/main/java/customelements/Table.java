package customelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Table {
    WebElement webTable;

    public Table(WebElement element) {
        webTable = element;
    }

    public int getRowsNumber() {
        List<WebElement> tableRows = webTable.findElements(By.tagName("tr"));
        return tableRows.size();
    }

    public int getColumnsNumber() {
        WebElement firstRow = webTable.findElement(By.tagName("th"));
        List<WebElement> tableColumns = firstRow.findElements(By.tagName("th"));
        return tableColumns.size();
    }

    public String getCellContents(int colIndex, int rowIndex) {
        WebElement currentCell = getCell(colIndex, rowIndex);
        return currentCell.getText();
    }

    public void sendKeysToCell(String text, int colIndex, int rowIndex) {
        WebElement currentCell = getCell(colIndex, rowIndex);
        currentCell.sendKeys(text);
    }

    private WebElement getCell(int colIndex, int rowIndex) {
        List<WebElement> tableRows = webTable.findElements(By.tagName("tr"));
        WebElement currentRow = tableRows.get(rowIndex - 1);

        List<WebElement> tableColumns = currentRow.findElements(By.tagName("th"));
        WebElement currentCell = tableColumns.get(colIndex - 1);
        return currentCell;
    }

}

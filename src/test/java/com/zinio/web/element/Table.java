package com.zinio.web.element;

import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zinio.web.utilities.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Table extends BasePage {
	
	public Table (WebDriver driver) {
		super(driver);
	}
    public Table(WebDriver driver,String controlDescription, String xpath) {
        super(driver, controlDescription, xpath);
    }

    private void waitDataLoading() {
        new BasePage(getDriver(), "loading icon", "//i[@class='fa fa-spinner']").waitDisappear();
    }

    public String[] getAllCellTextInColumn(String column) {
        String[] columnText = {};
        int colIndex = getColumnIndex(column);
        List<WebElement> cells = this.getChild(column + " column", "/tbody/tr/td[" + colIndex + "]").loadElements();
        for (WebElement cell : cells) {
            columnText = ArrayUtils.add(columnText, cell.getText());
        }
        return columnText;
    }

    public String[] getAllColumns() {
        String[] columnList = {};
        List<WebElement> columns = this.getChild(controlDescription, "//th").loadElements();
        for (WebElement col : columns) {
            String columnText = col.getText().trim();
            if (!columnText.isEmpty())
                columnList = StringUtils.addStringToArray(columnList, columnText);
        }
        return columnList;
    }

    public String[] getSortableColumn() {
        String[] columnList = {};
        List<WebElement> columns = this.getChild(controlDescription, "//th").loadElements();
        for (WebElement col : columns) {
            try {
                col.findElement(By.tagName("i"));
                columnList = StringUtils.addStringToArray(columnList, col.getText().trim());
            } catch (Exception ex) {
                ex.getMessage();
            }
        }
        return columnList;
    }

    public int getColumnIndex(String columnName) {
        List<WebElement> columns = this.getChild(columnName + " column", "//th").loadElements();
        for (WebElement col : columns) {
            if (col.getText().startsWith(columnName))
                return columns.indexOf(col) + 1;
        }
        return 0;
    }

    public int getRowIndex(String row, String col) {
        int colIndex = getColumnIndex(col);
        int number =0;
        List<WebElement> cells = this.getChild(col + " column", "/tbody/tr/td[" + colIndex + "]").loadElements();
        for (WebElement cell : cells) {
            if (cell.getText().equals(row)) {
                number = cells.indexOf(cell) + 1;
                break;
            }
        }

        return number;
    }

    public String getCellValue(String row, String col) {
        int colIndex;

        if (StringUtils.isStringNumeric(col))
            colIndex = Integer.parseInt(col);
        else
            colIndex = getColumnIndex(col);

        if (StringUtils.isStringNumeric(row)) {
            return this.getChild(col + " column", "/tbody/tr[" + row + "]//td[" + colIndex + "]").getText();
        } else {
            return this.getChild(col + " column", "/tbody/tr[contains(.,'" + row + "')]//td[" + colIndex + "]").getText();
        }
    }

    public void shouldBeSortedByColumn(String columnName, String sortDirection) {
        String description = "Check column [" + columnName + "] is being sorted [" + sortDirection + "] in [" + controlDescription + "]";
        String[] columnText = getAllCellTextInColumn(columnName);
        boolean condition1;
        boolean condition2;
        for (int row = 0; row < columnText.length - 1; row++) {
            String cell_value_1 = columnText[row].toLowerCase();
            String cell_value_2 = columnText[row + 1].toLowerCase();
            try {
                int cell1 = Integer.parseInt(cell_value_1);
                int cell2 = Integer.parseInt(cell_value_2);
                condition1 = cell1 < cell2 && sortDirection.equals("Descending");
                condition2 = cell1 > cell2 && sortDirection.equals("Ascending");
            } catch (Exception ex) {
                condition1 = cell_value_1.compareTo(cell_value_2) < 0 && sortDirection.equals("Descending");
                condition2 = cell_value_1.compareTo(cell_value_2) > 0 && sortDirection.equals("Ascending");
            }
            if (condition1 || condition2) {
                browserConfig.check(description, cell_value_1 + "->" + cell_value_2, cell_value_2 + "->" + cell_value_1);
                return;
            }
        }
        browserConfig.check(description, true, true);
    }

    public void shouldBeSortedTextByColumn(String columnName, String sortDirection) {
        String description = "Check column [" + columnName + "] is being sorted [" + sortDirection + "] in [" + controlDescription + "]";
        String[] columnText = getAllCellTextInColumn(columnName);
        String[] textAfterSort = columnText;

        if (sortDirection.equals("Descending")) {
            Arrays.sort(textAfterSort, Collections.reverseOrder());

        } else {
            Arrays.sort(textAfterSort);
        }

        browserConfig.check(description, Arrays.toString(columnText), Arrays.toString(textAfterSort));
    }

    public void shouldHaveSameValueInColumn(String column, String value) {
        String description = "Check all cells have the same value [" + value + "] in column [" + column + "] of [" + controlDescription + "]";
        String[] columnText = getAllCellTextInColumn(column);
        browserConfig.check(description, Arrays.stream(columnText).distinct().count() == 1, true);
    }

    public void shouldHaveContainsValueInColumn(String column, String value) {
        String description = "Check all cells have the same value [" + value + "] in column [" + column + "] of [" + controlDescription + "]";
        String[] columnText = getAllCellTextInColumn(column);

        browserConfig.check(description, Arrays.stream(columnText).anyMatch(x->x.contains(value)), true);
    }

    public void shouldShowCells(String... cellValue) {
        for (String value : cellValue) {
            String description = "The cell '" + value + "' of '" + controlDescription + "'";
            this.getChild(description, "//td[contains(.,'" + value + "')]").shouldBeDisplayed();
        }
    }

    public boolean isCellExisted(String... cellValue) {
        for (String value : cellValue) {
            String description = "The cell '" + value + "' of '" + controlDescription + "'";
            if (!this.getChild(description, "//td[contains(.,'" + value + "')]").isPresent()) {
                return false;
            }
        }
        return true;
    }

    public void shouldNotShowCells(String... cellValue) {
        for (String value : cellValue) {
            String description = "The cell '" + value + "' of '" + controlDescription + "'";
            this.getChild(description, "//td[contains(.,'" + value + "')]").shouldNotBeDisplayed();
        }
    }

    public void shouldHaveCellValue(String row, String column, String cellValue) {
        String description = "Check the cell value of [" + row + "][" + column + "] in [" + controlDescription + "]";
        browserConfig.check(description, getCellValue(row, column), cellValue);
    }

    public void shouldHaveColumns(String... columnNames) {
        String description = "Check [" + controlDescription + "] shows these columns: " + Arrays.toString(columnNames);
        String[] allcolumns = getAllColumns();
        Arrays.sort(allcolumns);
        Arrays.sort(columnNames);
        System.out.println(Arrays.toString(allcolumns));
        System.out.println(Arrays.toString(columnNames));
        browserConfig.check(description, Arrays.toString(allcolumns), Arrays.toString(columnNames));
    }

    private int getRowCount() {
        try {
            return this.getChild("rows", "//tbody//tr").loadElements().size();
        } catch (Exception ex) {
            return 0;
        }
    }

    public void shouldHaveRowCount(int totalRow) {
        String description = "Check [" + controlDescription + "] has [" + totalRow + "] row(s)";
        waitDataLoading();
        browserConfig.check(description, getRowCount(), totalRow);
    }

    public void sortColumn(String sortColumn, String sortDirection) {
        String description = "Sort icon of column [" + sortColumn + "]";
        BasePage sortIcon = this.getChild(description, "//th[starts-with(.,'" + sortColumn + "')]//i");
        boolean condition1 = sortIcon.getAttribute("class").contains("-asc") && sortDirection.equals("Descending");
        boolean condition2 = sortIcon.getAttribute("class").contains("-desc") && sortDirection.equals("Ascending");

        if (condition1 || condition2) {
            sortIcon.clickByJavascript();
            waitDataLoading();
        }
    }

    public void shouldHaveSortIconInColumn(String columnName, String sortDirection) {
        BasePage sortIcon = this.getChild("sort icon", "//th[starts-with(.,'" + columnName + "')]//i");
        String description = "Check the sort icon in column [" + columnName + "] changes to the [" + sortDirection + "] icon";
        String expectedIcon = sortDirection.equals("Ascending") ? "-asc" : "-desc";
        browserConfig.check(description, sortIcon.getAttribute("class").contains(expectedIcon), true);
    }

    public void shouldHaveColumnCellOrder(String columnName, String... cellValues) {
        String description = "Check correct order: " + Arrays.toString(cellValues);
        List<String> allCells = Arrays.asList(getAllCellTextInColumn(columnName));
        for (int i = 0; i < cellValues.length - 1; i++) {
            if (allCells.indexOf(cellValues[i]) > allCells.indexOf(cellValues[i + 1]))
            	browserConfig.check(description, false, true);
        }
        browserConfig.check(description, true, true);
    }

    public BasePage cellElementWithCondition(String[] listName, String[] listCondition, String condition, String elementName) {
        int value = 0;
        if (listCondition != null) {
            value = listCondition.length;
            for (int i = 0; i < value; i++) {
                if (listCondition[i].equals(condition)) {
                    value = i;
                    break;
                }
            }
        }
        if (value == listCondition.length) value = value - 1;
        return new BasePage(getDriver(), "Cell displays" + listName[value], "//td[contains(.,'" + listName[value] + "')]" +
                "/following::tr[contains(.,'" + elementName + "')]");

    }

    public void shouldShowRow(String... rowValues) {
        for (String value : rowValues) {
            String description = "The row '" + value + "' of '" + controlDescription + "'";
            new BasePage(getDriver(), description, "//tr[contains(.,'" + value + "')]").shouldBeDisplayed();
        }
    }

    public void shouldNotShowRow(String... rowValues) {
        for (String value : rowValues) {
            String description = "The row '" + value + "' of '" + controlDescription + "'";
            new BasePage(getDriver(), description, "//tr[contains(.,'" + value + "')]").shouldNotBeDisplayed();
        }
    }

    public int getRowCountWithStatus(String status) {
        BasePage rows = new BasePage(getDriver(), "Table", "//tbody//tr");
        List<WebElement> elements = rows.loadElements();
        int count = 0;
        for (WebElement element : elements) {
            if (status.equals("active") && element.getAttribute("class").equals("")) count ++;
            else if(element.getAttribute("class").equals(status))
                    count ++;
        }

        return count;
    }

    public void clickOnCellValue(String row, String col) {
        int colIndex;

        if (StringUtils.isStringNumeric(col))
            colIndex = Integer.parseInt(col);
        else
            colIndex = getColumnIndex(col);

        if (StringUtils.isStringNumeric(row)) {
            this.getChild(col + " column", "/tbody/tr[" + row + "]//td[" + colIndex + "]").click();
        } else {
            this.getChild(col + " column", "/tbody/tr[contains(.,'" + row + "')]//td[" + colIndex + "]").click();
        }
    }
}

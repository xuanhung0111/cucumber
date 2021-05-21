package com.zinio.web.element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zinio.web.utilities.Logging;
import com.zinio.web.utilities.PropertyUtils;
import com.zinio.zenith.identity.steps.AbstractPageStepDefinition;

import junit.framework.Assert;
import net.thucydides.core.pages.PageObject;

/**
 * 
 * Author : Hung Nguyen Created : 21/3/18 All the overridden methods can be
 * implemented in this class that will be used by the pages
 * 
 **/
public class BasePage extends PageObject {

	WebDriverWait waitUltil;
	public String xpath;
	protected String controlDescription;
	protected AbstractPageStepDefinition browserConfig;
	private int timeout = 5;

	public BasePage(WebDriver driver) {
		super(driver);
		waitUltil = new WebDriverWait(driver, 30);
	}
	
	public BasePage(WebDriver driver, String controlDescription, String xpath) {
		super(driver);
		this.xpath = xpath;
		this.controlDescription = controlDescription;
		this.browserConfig = new AbstractPageStepDefinition();
		this.timeout = PropertyUtils.getPropAsInt("timeout");
	}

	public BasePage(WebDriver driver, String controlDescription) {
		super(driver);
        this.controlDescription = controlDescription;
        this.browserConfig = new AbstractPageStepDefinition();
        this.timeout = PropertyUtils.getPropAsInt("timeout");
	}
	
	// Customer Methods can be defined in this area

	private void waitForElementToBePresent(By by) {
		waitFor(ExpectedConditions.presenceOfElementLocated(by));
		waitFor(ExpectedConditions.visibilityOfElementLocated(by));
		waitFor(ExpectedConditions.elementToBeClickable(by));
	}

	private WebElement FindElement(By by) {
		waitForElementToBePresent(by);
		return getDriver().findElement(by);
	}

	public void selectOption(By by, String option) {
		if (option == null) {
			return;
		}
		Select select = new Select(FindElement(by));
		select.selectByVisibleText(option);
	}

	public List<String> getColumnTableName(String tableEl, String tableName) {
		Logging.info("Get Column Table Name of : " + tableName);
		List<String> columnName = new ArrayList<String>();
		List<WebElement> col = getDriver().findElements(By.xpath(tableEl + "//thead/tr/th/div"));
		for (int i = 0; i < col.size(); i++) {
			columnName.add(col.get(i).getText());
		}
		return columnName;
	}

	public List<Map<String, String>> getItemsTable(String tableEl, String tableName) {
		// Return List of Dict: key _ value inside the table
		List<Map<String, String>> listHashUser = new ArrayList<Map<String, String>>();
		try {
			Logging.info("Get Items in Table: " + tableName);
			List<String> columnName = getColumnTableName(tableEl, tableName);

			WebElement data = getDriver().findElement(By.xpath(tableEl + "//tbody"));
			List<WebElement> rows_table = data.findElements(By.tagName("tr"));
			int rows_count = rows_table.size();
			for (int row = 0; row < rows_count; row++) {
				Map<String, String> hashTable = new HashMap<String, String>();
				List<WebElement> columnsRow = rows_table.get(row).findElements(By.tagName("td"));
				ListIterator<String> iteratorColumn = columnName.listIterator();
				while (iteratorColumn.hasNext()) {
					String keyValue = iteratorColumn.next().replaceFirst(".$", "");
					int index = iteratorColumn.nextIndex();
					String value = columnsRow.get(index - 1).getText();
					hashTable.put(keyValue, value);
				}
				listHashUser.add(hashTable);
			}
			return listHashUser;
		} catch (Exception e) {
			return listHashUser;
		}
	}

	// Overridden method above
	public List<Map<String, WebElement>> getItemsTable(String tableEl, String tableName, boolean isHref) {
		// Return List of Dict: key _ WebElement inside the table
		List<Map<String, WebElement>> listHashUser = new ArrayList<Map<String, WebElement>>();

		if (isHref == true) {
			try {
				Logging.info("Get Items in Table: " + tableName);
				List<String> columnName = getColumnTableName(tableEl, tableName);

				WebElement data = getDriver().findElement(By.xpath(tableEl + "//tbody"));

				List<WebElement> rows_table = data.findElements(By.tagName("tr"));
				int rows_count = rows_table.size();
				for (int row = 0; row < rows_count; row++) {
					Map<String, WebElement> hashTable = new HashMap<String, WebElement>();

					List<WebElement> columnsRow = rows_table.get(row).findElements(By.tagName("td"));
					ListIterator<String> iteratorColumn = columnName.listIterator();
					while (iteratorColumn.hasNext()) {
						String keyValue = iteratorColumn.next().replaceFirst(".$", "");
						int index = iteratorColumn.nextIndex();
						WebElement value = columnsRow.get(index - 1).findElement(By.className("table-cell"));
						hashTable.put(keyValue, value);
					}
					listHashUser.add(hashTable);
				}
			} catch (Exception e) {
				return listHashUser;
			}
		}
		return listHashUser;
	}

	public Map<String, String> getDictData(List<WebElement> el) {
		System.out.println("Size element is " + el.size());
		String orderKey = null;
		String orderValue = null;
		int count = 0;
		Logging.info("Push value into Key of Dict");
		Map<String, String> dataDict = new HashMap<String, String>();
		for (int i = 0; i < el.size(); i++) {
			count++;
			if (i % 2 == 0) {
				orderKey = el.get(i).getText();
				if(i==14) {
					orderKey= "FlatformCode";
				}
			} else {
				orderValue = el.get(i).getText();
			}
			if (count % 2 == 0) {
				dataDict.put(orderKey, orderValue);
			}
		}
		return dataDict;
	}

	public WebElement loadElement() {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		} catch (Exception timeOut) {
			Logging.info("ERROR: Cannot find [" + controlDescription + "]");
			Assert.fail("Test stopped because of error!!!");
			return null;
		}
	}

	public WebElement loadHiddenElement() {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
			return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		} catch (Exception timeOut) {
			Logging.info("ERROR: Cannot find [" + controlDescription + "]");
			Assert.fail("Test stopped because of error!!!");
			return null;
		}
	}

	public List<WebElement> loadElements() {
		loadElement();
		return getDriver().findElements(By.xpath(xpath));
	}

	public String[] getTexOfListElements() {

		List<WebElement> elements = loadElements();
		String[] result = new String[elements.size()];
		for (int i = 0; i < elements.size(); i++) {
			result[i] = elements.get(i).getText();
		}
		return result;
	}

	public void hoverByJavascript() {
		String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',"
				+ "true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
		((JavascriptExecutor) getDriver()).executeScript(mouseOverScript, loadElement());
//		JavascriptExecutor js=(JavascriptExecutor) getDriver();
//		js.executeScript("mouseOverScript", loadElement());
	}

	public BasePage getChild(String controlDescription, String xpath) {
		return new BasePage(getDriver(), controlDescription, this.xpath + xpath);
	}

	public void click() {
		Logging.info("Click [" + controlDescription + "]");
		this.loadElement().click();
	}

	public void clickByJavascript() {
		Logging.info("Click [" + controlDescription + "]");
		WebElement element = getDriver().findElement(By.xpath(xpath));
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
	}

	public void jsClick() {
		WebElement element = getDriver().findElement(By.xpath(xpath));
		element.isDisplayed();
		Logging.info("Click [" + controlDescription + "]");
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
	}

	public String getDescription() {
		return this.controlDescription;
	}

	public String getTagName() {
		return loadElement().getTagName();
	}

	public String getAttribute(String s) {
		return loadElement().getAttribute(s);
	}

	public String getText() {
		return loadElement().getText().trim();
	}

	public boolean isDisplayed() {
		return isDisplayed(timeout);
	}

	public boolean isDisplayedBySelenium() {
		try {
			WebElement element = getDriver().findElement(By.xpath(xpath));
			return element.isDisplayed();
		} catch (Exception ex) {
			return false;
		}
	}

	public boolean isDisplayed(long timeoutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), timeoutInSeconds);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).isDisplayed();
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).isDisplayed();
		} catch (Exception ex) {
			return false;
		}
	}

	public boolean isPresent() {
		try {
			return getDriver().findElements(By.xpath(xpath)).size() != 0;
		} catch (Exception ex) {
			return false;
		}
	}

	public boolean isEnabled() {
		if (getAttribute("readonly") != null || getAttribute("disabled") != null
				|| getAttribute("class").contains("disabled")) {
			return false;
		} else {
			return true;
		}
	}

	public boolean waitDisappear() {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
			return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(this.xpath)));
		} catch (Exception ex) {
			return false;
		}
	}

	public boolean waitAttributeToBe(String attribute, String value) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
			return wait.until(ExpectedConditions.attributeToBe(loadElement(), attribute, value));
		} catch (Exception ex) {
			return false;
		}
	}

	public boolean waitAttributeContains(String attribute, String value) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
			return wait.until(ExpectedConditions.attributeContains(loadElement(), attribute, value));
		} catch (Exception ex) {
			return false;
		}
	}

	public boolean waitAttributeNotContain(String attribute, String value) {
		long baseTime = System.currentTimeMillis();
		while (System.currentTimeMillis() - baseTime < timeout * 1000)
			if (!getAttribute(attribute).contains(value))
				return true;
		return false;
	}

	public boolean waitTextToBe(String value) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
			return wait.until(ExpectedConditions.textToBe(By.xpath(this.xpath), value));
		} catch (Exception ex) {
			return false;
		}
	}

	public boolean waitTextContains(String value) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
			return wait.until(ExpectedConditions.textToBePresentInElement(loadElement(), value));
		} catch (Exception ex) {
			return false;
		}
	}

	public boolean waitTextNotContain(String value) {
		long baseTime = System.currentTimeMillis();
		while (System.currentTimeMillis() - baseTime < timeout * 1000)
			if (!getText().contains(value))
				return true;
		return false;
	}

	public void shouldBeDisplayed() {
		String description = "Check [" + controlDescription + "] is displayed";
		browserConfig.check(description, isDisplayed(), true);
	}

	public void shouldNotBeDisplayed() {
		String description = "Check [" + controlDescription + "] is NOT displayed";
		browserConfig.check(description, waitDisappear(), true);
	}

	public void shouldHaveAttribute(String attribute, String value) {
		String description = "Check [" + attribute + "] of﻿[" + controlDescription + "] is [" + value + "]";
		waitAttributeToBe(attribute, value);
		browserConfig.check(description, getAttribute(attribute), value);
	}

	public void shouldContainAttribute(String attribute, String value) {
		String description = "Check [" + attribute + "] of [" + controlDescription + "] contains [" + value + "]";
		browserConfig.check(description, waitAttributeContains(attribute, value), true);
	}

	public void shouldNotContainAttribute(String attribute, String value) {
		String description = "Check [" + attribute + "] of [" + controlDescription + "] contains [" + value + "]";
		browserConfig.check(description, waitAttributeContains(attribute, value), false);
	}

	public boolean shouldHaveText(String text) {
		String description = "Check [" + controlDescription + "] is [" + text + "]";
		if (text.equals(""))
			return this.shouldBeBlank();
		else {
			return browserConfig.check(description, getText(), text);
		}
	}

	public void shouldContainText(String text) {
		String description = "Check [" + controlDescription + "] contains the text [" + text + "]";
		waitTextContains(text);
		if (getText().contains(text))
			browserConfig.check(description, getText().contains(text), true);
		else
			browserConfig.checkAdmin(description, getText(), false);
	}

	public void shouldNotContainText(String text) {
		String description = "Check [" + controlDescription + "] does NOT contain the text [" + text + "]";
		browserConfig.check(description, !getText().contains(text), true);
	}

	public void shouldBeDisabled() {
		String description = "Check [" + controlDescription + "] is disabled";
		browserConfig.check(description, isDisabled(), true);
	}

	public boolean isDisabled() {
		boolean disabled1 = getAttribute("class") != null ? getAttribute("class").toLowerCase().contains("disabled")
				: false;
		boolean disabled2 = getAttribute("readonly") != null;
		boolean disabled3 = getAttribute("disabled") != null;
		boolean disabled4 = getAttribute("inactive") != null;
		return disabled1 | disabled2 | disabled3 | disabled4;
	}

	public void shouldBeSelected() {
		String description = "Check [" + controlDescription + "] is selected";
		browserConfig.check(description, isSelected(), true);
	}

	public boolean isSelected() {
		return getAttribute("aria-selected").equals("true");
	}

	public boolean shouldBeBlank() {
		String description = "Check [" + controlDescription + "] is blank";
		return browserConfig.check(description, this.getText(), "");
	}

	public void scrollElementIntoView() {
		WebElement element = getDriver().findElement(By.xpath(xpath));
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", element);

	}

	public String getCssColorValue() {
		WebElement element = getDriver().findElement(By.xpath(xpath));
		return element.getCssValue("color");
	}

	public void waitLoadingIconDisappear() {
		new BasePage(getDriver(), "loading icon", "//i[@class='fa fa-spinner']").waitDisappear();
		new BasePage(getDriver(), "//div[@class='loading']").waitDisappear();
	}

	public void hoverOnElement() {
		WebElement element = getDriver().findElement(By.xpath(xpath));
		if (element.isDisplayed()) {
			Actions actions = new Actions(getDriver());
			actions.moveToElement(element).build().perform();
		}
	}
	
	public String getToolTip(WebElement element) {
		String toolTipText = "";
		if (element.isDisplayed()) {
			Actions actions = new Actions(getDriver());
			actions.clickAndHold(element).build().perform();
			waitABit(3000);
			toolTipText = element.getAttribute("title");
		} 
		return toolTipText;
	}
}

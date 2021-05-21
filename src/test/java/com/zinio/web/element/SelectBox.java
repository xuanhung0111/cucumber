package com.zinio.web.element;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zinio.web.utilities.Logging;
import com.zinio.web.utilities.PropertyUtils;
import com.zinio.web.utilities.StringUtils;

import java.util.Arrays;
import java.util.List;

public class SelectBox extends BasePage {
	
	public SelectBox(WebDriver driver) {
		super(driver);
	}
    public SelectBox(WebDriver driver, String controlDescription, String xpath) {
        super(driver, controlDescription, xpath);
    }

    @Override
    public void click() {
        this.loadElement().findElement(By.tagName("*")).click();
    }

    private void waitSelectBoxLoading(String expectedState) {
        boolean isExpanded = getAttribute("class").contains("open");
        if ((expectedState.equals("open") && !isExpanded) | (!expectedState.equals("open") && isExpanded)) {
            waitLoadingIconDisappear();
        }
    }

    public void expandSelectBox() {
        boolean isExpanded = this.getAttribute("class").contains("open");
        if (!isExpanded) {
            this.getChild("Expand select box", "//button").click();
            waitLoadingIconDisappear();
        }
    }

    public void collapseSelectBox() {
        boolean isExpanded = this.getAttribute("class").contains("open");
        if (isExpanded) {
            this.getChild("Collapse select box", "//button").click();
        }
    }

    public void selectOption(String value) {
        String description = "Option '" + value + "' in '" + controlDescription + "'";
        this.isDisplayed(5000);
        expandSelectBox();
        new BasePage(getDriver(), description, "(" + xpath + "//li[.='" + value + "'])").click();

    }

    public void selectPagination(String value) {
        String description = "Option '" + value + "' in '" + controlDescription + "'";
        this.isDisplayed(5000);
        expandSelectBox();
        new BasePage(getDriver(), description, "//div[@class='dropdown-menu animated fadeInDown pull-left']" +
                "//label[.='" + value + "']").clickByJavascript();
    }

    public void selectPartialOption(String value) {
        String description = "Option that contains '" + value + "' in '" + controlDescription + "'";
        expandSelectBox();
        new BasePage(getDriver(), description, "(" + xpath + "//li[contains(.,'" + value + "')])").click();
    }

    public String selectIndex(int index) {
        String description = "Option at position '" + index + "' of '" + controlDescription + "'";
        waitSelectBoxLoading("open");
        this.getChild(description, "//li[" + index + "]").click();
        int time = 500;
        int timeout = PropertyUtils.getPropAsInt("timeToWaitSelectBox");
        while (this.getAttribute("class").contains("open")) {
            this.getChild(description, "//li[" + index + "]").click();
            time = time + 100;
            if (time >= timeout) break;
        }
        return this.getText();
    }

    public String selectRandomValue() {
        expandSelectBox();
        waitLoadingIconDisappear();
        int index = StringUtils.randomNumberInRange(2, this.getChild("options", "//li").loadElements().size() - 1);
        return selectIndex(index);
    }

    public String selectRandomValueExceptValues(String... values) {
        expandSelectBox();
        waitLoadingIconDisappear();
        int numberOfElements = this.getChild("options", "//li").loadElements().size();
        int index = StringUtils.randomNumberInRange(2, numberOfElements);
        String value = this.getChild("", "//li[" + index + "]").getText();
        while (Arrays.asList(values).contains(value)) {
            index = StringUtils.randomNumberInRange(2, numberOfElements);
            value = this.getChild("", "//li[" + index + "]").getText();
        }
        Logging.info("Random value: " + value);
        BasePage itemElement = this.getChild("Option '" + value + "' in '" + controlDescription + "'", "//li[" + index + "]");
        itemElement.isDisplayed(PropertyUtils.getPropAsInt("timeToWaitSelectBox"));
        itemElement.click();
        Logging.info("Click on [" + value + "]");
        waitLoadingIconDisappear();
        return value;
    }

    public String getValueAttribute(String option) {
        return this.loadElement().findElement(By.xpath("//li[.='" + option + "']")).getAttribute("value");
    }

    public SelectBox filter(String value) {
        expandSelectBox();
        waitLoadingIconDisappear();
        TextBox txtFilter = new TextBox(getDriver(),"Filter textbox", this.xpath + "//input[@name='containt-text']");
        while (!txtFilter.isDisplayed(PropertyUtils.getPropAsInt("timeToWaitSelectBox"))) {
            expandSelectBox();
        }
        txtFilter.setText(value);
        txtFilter.pressKey(Keys.ENTER);
        waitLoadingIconDisappear();
        txtFilter.loadElement();
        waitLoadingIconDisappear();
        return this;
    }

    public void shouldHaveOptions(String... items) {
        String description = "Check [" + controlDescription + "] contains these options: " + Arrays.toString(items);
        String[] missingOptions = {};
        expandSelectBox();
        for (String item : items) {
            if (!this.getChild("option", "//ul//li[.='" + item + "']").isDisplayed(1))
                missingOptions = StringUtils.addStringToArray(missingOptions, item);
        }

        if (missingOptions.length == 0) {
        		browserConfig.check(description, true, true);
        } else {
        		browserConfig.check(description, "Missing these options: " + Arrays.toString(missingOptions), Arrays.toString(items));
        }
        collapseSelectBox();
        waitSelectBoxLoading("close");
    }

    public boolean optionsExist(String... items) {
        boolean isFound = false;
        for (String item : items) {
            if (this.getChild("option", "//ul//li[contains(text(),'" + item + "')]").isDisplayed(1)) {
                isFound = true;
            } else {
                isFound = false;
                break;
            }
        }
        return isFound;
    }

    public void shouldHavePagination(String... items) {
        String description = "Check [" + controlDescription + "] contains these options: " + Arrays.toString(items);
        String[] missingOptions = {};
        this.click();
        for (String item : items) {
            if (!this.getChild("option", "/..//div[@class='dropdown-menu animated fadeInDown pull-left']//label[.='" + item + "']").isDisplayed(1)) {
                missingOptions = StringUtils.addStringToArray(missingOptions, item);
            }
        }

        if (missingOptions.length == 0) {
            browserConfig.check(description, true, true);
        } else {
        		browserConfig.check(description, "Missing these options: " + Arrays.toString(missingOptions), Arrays.toString(items));
        }
        	this.click();
    }

    public void shouldNotHaveOptions(String... items) {
        String description = "Check [" + controlDescription + "] does NOT contain these options: " + Arrays.toString(items);
        String[] existOptions = {};
        waitSelectBoxLoading("open");

        for (String item : items)
            if (this.getChild("option", "//*[.='" + item + "']").isDisplayed(1))
                existOptions = StringUtils.addStringToArray(existOptions, item);

        if (existOptions.length == 0)
        	browserConfig.check(description, true, true);
        else
            browserConfig.check(description, "Still see these options " + Arrays.toString(existOptions), Arrays.toString(items));

        waitSelectBoxLoading("close");
    }

    public String[] listTextOfOptions() {
        String[] value = {};
        expandSelectBox();
        try {
            Long timeToWait = Long.parseLong(PropertyUtils.getPropAsString("timeToWaitSelectBox"));
            Thread.sleep(timeToWait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        BasePage listOptions = this.getChild("option", "//ul/li");
        List<WebElement> elements = listOptions.loadElements();
        int numberOfElements = elements.size();
        for (int i = 1; i < numberOfElements; i++) {
            value = StringUtils.addStringToArray(value, elements.get(i).getText());
        }
        return value;
    }
}
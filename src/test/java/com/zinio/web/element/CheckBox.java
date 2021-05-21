package com.zinio.web.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zinio.web.utilities.StringUtils;

public class CheckBox extends BasePage {
    private BasePage hiddenCheckBox;
    private BasePage visibleCheckBox;

    public CheckBox(WebDriver driver) {
		super(driver);
	}
    
    public CheckBox(WebDriver driver, String controlDescription, String label) {
        super(driver, controlDescription, "//label[contains(.,'" + label + "')]");
    }

    public CheckBox(WebDriver driver, String controlDescription) {
        super(driver, controlDescription);
        xpath = "//div[@class='form-chk-group row']";
        visibleCheckBox = this.getChild(controlDescription, "//child::label[2]");
    }

    public void setValue(boolean value) {
        WebElement checkbox = hiddenCheckBox.loadHiddenElement();
        if ((!checkbox.isSelected() && value) || (checkbox.isSelected() && !value))
            visibleCheckBox.click();
    }

    public boolean isSelected() {
        hiddenCheckBox = this.getChild(controlDescription, "//preceding::input[1]");
        WebElement checkbox = hiddenCheckBox.loadHiddenElement();
        return checkbox.isSelected();
    }

    public void shouldBeSelected() {
    		browserConfig.check("Check [" + controlDescription + " is selected", this.isSelected(), true);
    }

    public void shouldNotBeSelected() {
    		browserConfig.check("Check [" + controlDescription + " is NOT selected", this.isSelected(), false);
    }

    public String selectRandomValue() {
        int size = visibleCheckBox.loadElements().size();
        int randomIndex = size == 1 ? 0 : StringUtils.randomNumberInRange(0,size - 1);
        visibleCheckBox.loadElements().get(randomIndex).click();
        return visibleCheckBox.loadElements().get(randomIndex).getText();
    }

    public String[] selectRandomValues() {
        String[] values = {};
        int size = visibleCheckBox.loadElements().size();
        int numberValues = StringUtils.randomNumberInRange(0, size - 1);
        for (int i = 0; i < numberValues; i++) {
            visibleCheckBox.loadElements().get(i).click();
            values = StringUtils.addStringToArray(values, visibleCheckBox.loadElements().get(i).getText());
        }

        return values;
    }

    public String[] selectAllValues() {
        String[] values = {};
        int size = visibleCheckBox.loadElements().size();
        for (int i = 0; i < size; i++) {
            visibleCheckBox.loadElements().get(i).click();
            values = StringUtils.addStringToArray(values, visibleCheckBox.loadElements().get(i).getText());
        }

        return values;
    }

    public void shouldHaveOptions(String... options) {
        for (String option : options) {
            this.getChild("Option: " + option, "/following::label[contains(.,'" + option + "')]").shouldBeDisplayed();
        }
    }

    public void selectOptions(String... options) {
        for (String option : options) {
        		BasePage item = new BasePage(getDriver(), "Click on: " + option, "//label[contains(.,'" + option + "')]");
            WebElement checkbox = item.getChild("Checkbox of option: " + option, "/preceding-sibling::input[1]")
                    .loadHiddenElement();
            if (!checkbox.isSelected()) item.click();
        }
    }

    public void unSelectOptions(String... options) {
        for (String option : options) {
        		BasePage item = this.getChild("Click on: " + option, "/following::label[contains(.,'" + option + "')]");
            WebElement checkbox = item.getChild("Checkbox of option: " + option, "/preceding-sibling::input")
                    .loadHiddenElement();
            if (checkbox.isSelected()) item.click();
        }
    }

    public void shouldSelectedOptions(String... options) {
        for (String option : options) {
        		BasePage item = this.getChild("Click on: " + option, "/following::label[contains(.,'" + option + "')]");
            WebElement checkbox = item.getChild("Checkbox of option: " + option, "/preceding-sibling::input")
                    .loadHiddenElement();
            browserConfig.check("Option: " + option + " is selected", checkbox.isSelected(), true);
        }
    }

    public void shouldUnSelectedOptions(String... options) {
        for (String option : options) {
        		BasePage item = this.getChild("Click on: " + option, "/following::label[contains(.,'" + option + "')]");
            WebElement checkbox = item.getChild("Checkbox of option: " + option, "/preceding-sibling::input")
                    .loadHiddenElement();
            browserConfig.check("Option: " + option + " is NOT selected", checkbox.isSelected(), false);
        }
    }

    public void checkOnCheckbox() {
        if (!this.loadElement().getAttribute("class").contains("ic-input ic-checkbox")) {
            visibleCheckBox = this.getChild("Checked", "//preceding::label[1]");
            visibleCheckBox.click();
        } else this.click();

    }
}

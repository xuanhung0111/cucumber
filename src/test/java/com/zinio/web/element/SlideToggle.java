package com.zinio.web.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SlideToggle extends BasePage {
    private BasePage hiddenCheckBox;

    public SlideToggle(WebDriver driver) {
    		super(driver);
    }
    
    public SlideToggle(WebDriver driver, String controlDescription, String xpath) {
        super(driver, controlDescription, xpath);
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
}

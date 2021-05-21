package com.zinio.web.element;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zinio.web.utilities.Logging;
import com.zinio.web.utilities.StringUtils;

public class TextBox extends BasePage {
	
	public TextBox (WebDriver driver) {
		super(driver);
	}
    public TextBox(WebDriver driver, String controlDescription, String xpath) {
        super(driver, controlDescription, xpath);
    }

    @Override
    public String getText() {
        return this.getAttribute("value");
    }

    public TextBox setText(String value) {

        this.loadElement().clear();
        if (loadElement().getAttribute("value").length() > 0) this.clearByJavascript();
        if (!value.equals("")) {
            this.isDisplayed(2000);
            loadElement().sendKeys(value);
            Logging.info("Enter [" + value + "] into [" + controlDescription + "]");
        } else {
            Logging.info("Clear text from [" + controlDescription + "]");
        }
        return this;
    }

    public boolean shouldBeBlank() {
        String description = "Check [" + controlDescription + "] is blank";
        return browserConfig.check(description, this.getText(), "");
    }

    @Override
    public boolean shouldHaveText(String text) {
        if (text.equals("")) {
            return this.shouldBeBlank();
        } else {
            String description = "Check [" + controlDescription + "] displays [" + text + "]";
            waitAttributeToBe("value", text);
            return browserConfig.check(description, this.getText(), text);
        }
    }

    public void shouldHaveLengthLimitation(int limitation) {
        this.clear();
        this.loadElement().sendKeys(StringUtils.randomString("", limitation + 1));

        Logging.info("Try to enter more than [" + limitation + "] chars into [" + controlDescription + "]");
        String description = "Check [" + controlDescription + "] is limited to [" + limitation + "] chars";
        browserConfig.check(description, this.getText().length(), limitation);
    }

    public void pressKey(Keys keys) {
        loadElement().sendKeys(keys);
    }

    public void clear() {
        int i = 0;
        Integer length = loadElement().getAttribute("value").length();
        if (length > 0) {
            loadElement().click();
            loadElement().sendKeys(Keys.END);
        }
        while (length > 0) {
            loadElement().sendKeys(Keys.BACK_SPACE);
            length = loadElement().getAttribute("value").length();
            i++;
            if (i == 1000) {
                Logging.info("Clear text from [" + controlDescription + "] is not successful");
                break;
            }
        }
    }

    public void clearByJavascript() {
        Integer length = loadElement().getAttribute("value").length();
        if (length > 0)
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].value ='';", this.loadElement());
    }

    public TextBox visibleElement(){
        WebElement element = getDriver().findElement(By.xpath(xpath));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style='opacity: 1;';", element);
        return this;
    }
}

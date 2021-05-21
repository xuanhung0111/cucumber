package com.zinio.admin.ui;

import org.openqa.selenium.WebDriver;

import com.zinio.web.element.BasePage;
import com.zinio.web.element.TextBox;
import com.zinio.web.element.CheckBox;
import com.zinio.web.element.SelectBox;

public class PricePageObject extends BasePage {

	public PricePageObject(WebDriver driver) {
		super(driver);
	}

	public BasePage defaultPriceTab = new BasePage(getDriver(), "Default Price tab", "//a[.='Default Price']");

	public SelectBox currencySelectBox = new SelectBox(getDriver(), "Currency combo box",
			"//label[.='Currency']/following-sibling::div");

	public CheckBox overrideCheckbox = new CheckBox(getDriver(), "Override Default Price checkbox",
			"Override default price");

	public BasePage saveButton = new BasePage(getDriver(), "Save button", "//button[.='Save']");

	public BasePage resetButton = new BasePage(getDriver(), "Reset button", "//button[.='Reset']");

	public BasePage backButton = new BasePage(getDriver(), "Back button", "//button[.='Back']");

	public BasePage exceptionList = new BasePage(getDriver(), "Exception list",
			"//li[contains(@class,'has-children')]");

	public SelectBox projectListSelectBox = new SelectBox(getDriver(), "Copy Project List",
			"//label[.='I want to copy']/following-sibling::div");

	// Standard Issue
	public TextBox braintreeStandardPrice = new TextBox(getDriver(), "Braintree Standard Issue Price textbox",
			"//td[.='Standard Issue']/following::input[1]");
	public SelectBox iTunesStandardPrice = new SelectBox(getDriver(), "iTunes Standard Issue Price selectbox",
			"//td[.='Standard Issue']/..//div[contains(@class,'btn-group-select')]");
	public TextBox relayStandardPrice = new TextBox(getDriver(), "Relay Credit Standard Issue textbox",
			"//td[.='Standard Issue']/following::input[@data-issuetype = 2][2]");
	public BasePage notForSaleStandard = new BasePage(getDriver(), "Not for sale button",
			"//td[.='Standard Issue']/following::button[.='Not for sale']");

	// Back Issue
	public TextBox braintreeBackPrice = new TextBox(getDriver(), "Braintree Back Issue Price textbox",
			"//td[.='Back Issue']/following::input[1]");
	public SelectBox iTunesBackPrice = new SelectBox(getDriver(), "iTunes Back Issue Price selectbox",
			"//td[.='Back Issue']/..//div[contains(@class,'btn-group-select')]");
	public TextBox relayBackPrice = new TextBox(getDriver(), "Relay Credit Back Issue textbox",
			"//td[.='Back Issue']/following::input[@data-issuetype = 2][2]");
	public BasePage notForSaleBack = new BasePage(getDriver(), "Not for sale button",
			"//td[.='Back Issue']/following::button[.='Not for sale']");

	// Single issue
	public TextBox braintreeSinglePrice = new TextBox(getDriver(), "Braintree Single Issue Price textbox",
			"//td[.='Single Issue']/following::input[1]");
	public SelectBox iTunesSinglePrice = new SelectBox(getDriver(), "iTunes Single Issue Price selectbox",
			"//td[.='Single Issue']/..//div[contains(@class,'btn-group-select')]");
	public TextBox relaySinglePrice = new TextBox(getDriver(), "Relay Credit Single Issue textbox",
			"//td[.='Single Issue']/following::input[3]");
	public BasePage notForSaleSingle = new BasePage(getDriver(), "Not for sale button in Single Issue",
			"//td[.='Single Issue']/following::button[.='Not for sale']");

}

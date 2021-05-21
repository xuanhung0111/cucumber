package com.zinio.admin.ui;

import org.openqa.selenium.WebDriver;

import com.zinio.web.element.BasePage;
import com.zinio.web.element.TextBox;

public class MailinatorPageObject extends BasePage {

	public MailinatorPageObject(WebDriver driver) {
		super(driver);
	}

	public TextBox searchEmailTextbox = new TextBox(getDriver(), "Search Email textbox",
			"//input[@placeholder='Check Any Inbox!']");

	public BasePage goButton = new BasePage(getDriver(), "signin button", "//div[@class='input-group']//button");

	public BasePage emailLink = new BasePage(getDriver(), "Email link",
			"//div[contains(@class,'outermail')]//div[contains(string(),'ZINIO Unlimited Password')]");

	public BasePage createNewPasswordLink = new BasePage(getDriver(), "Create a New Password link",
			"//div[.='Create a New Admin Password']");

}

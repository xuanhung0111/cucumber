package com.zinio.admin.ui;

import org.openqa.selenium.WebDriver;

import com.zinio.web.element.BasePage;

public class NotFoundPageObject extends BasePage {

	public NotFoundPageObject(WebDriver driver) {
		super(driver);
	}

	public BasePage errorIcon = new BasePage(getDriver(), "Error icon", "//div[@class='error-icon']");
	public BasePage goToHomeButton = new BasePage(getDriver(), "Go to Home button", "//a[.='Go to home']");

}

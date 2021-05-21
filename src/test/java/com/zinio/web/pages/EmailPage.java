package com.zinio.web.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.findby.By;

import com.zinio.web.element.BasePage;
import com.zinio.web.utilities.Logging;

import org.openqa.selenium.support.FindBy;

public class EmailPage extends BasePage {

	public EmailPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "identifierId")
	WebElementFacade emailOrPhoneField;

	@FindBy(id = "identifierNext")
	WebElementFacade nextEmailBtn;

	@FindBy(xpath = "//*[@id='password']//input")
	WebElementFacade passwordPlaceHolder;
	
	@FindBy(id = "passwordNext")
	WebElementFacade nextPasswordBtn;
	
	@FindBy(xpath = "//*[contains(@class, 'button-wrap')]//a")
	List<WebElement> createNewPasswordBtn;
	
	@FindBy(id = ":il")
	WebElementFacade hideExpandContent;
	
	@FindBy(id = "reset-password")
	WebElementFacade newPasswordField;
	
	@FindBy(id = "reset-confirmPassword")
	WebElementFacade resetPasswordField;
	
	@FindBy(id = "reset-submitButton")
	WebElementFacade resetSubmitPassword;
	
	public void loadLoginEmail() {
		getDriver()
		.get("https://accounts.google.com/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&osid=1&service=mail&ss=1&ltmpl=default&rm=false#identifier");
	}

	public void enterEmail(String email) {
		Logging.info("Enter your email or phone: " + email);
		emailOrPhoneField.sendKeys(email);
	}

	public void clickNextEmailBtn() {
		Logging.info("Click Next Email Btn");
		nextEmailBtn.click();
	}

	public void enterPassword(String password) {
		Logging.info("Enter your password: ***");
		passwordPlaceHolder.click();
		passwordPlaceHolder.sendKeys(password);
	}

	public void clickNextPasswordBtn() {
		Logging.info("Enter your password: ***");
		nextPasswordBtn.click();
	}

	public void openInboxEmail() {
		List<WebElement> a = getDriver().findElements(By.xpath("//*[@class='yW']/span"));
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i).getText().equals("Zinio")) {
				a.get(i).click();
			}
		}
	}

	public void enterNewPassword(String password) {
		Logging.info("Enter new password");
		newPasswordField.sendKeys(password);
	}
	
	public void enterConfirmNewPassword(String password) {
		Logging.info("Enter confirm new password");
		resetPasswordField.sendKeys(password);
	}
	
	public void submitResetPassword() {
		Logging.info("Submit reset password");
		resetSubmitPassword.click();
	}
	
	public void clickExpandedContent() {
		Logging.info("Click Expand Content if exist");
		if(hideExpandContent.isDisplayed()) {
			hideExpandContent.click();
		}
	}
	
	public void clickCreateNewPassword() {
		Logging.info("Click Create New Password");
		clickExpandedContent();
		createNewPasswordBtn.get(createNewPasswordBtn.size()-1).click();
	}
	
	
	
	
	
}

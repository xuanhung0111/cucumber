package com.zinio.admin.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zinio.web.element.BasePage;
import com.zinio.web.utilities.Logging;

import net.serenitybdd.core.pages.WebElementFacade;

public class AdminLoginPage  extends BasePage{

	public AdminLoginPage(WebDriver driver) {
		super(driver);
	}
	/*
	 * *****Declaration Elements ****
	 */
	// Admin Login Page
	
	@FindBy(name = "username")
	WebElementFacade txtUserName;
	
	@FindBy(name = "password")
	WebElementFacade txtPassWord;
	
	@FindBy(xpath = "//*[@class='btn btn-primary btn-login']")
	WebElementFacade signInButton;
	
	@FindBy(xpath = "//*[contains(text(), 'Forgot password?')]")
	WebElementFacade forgetPassword;
	
	// Action
	
	public void enterUserName(String userName) {
		Logging.info(String.format("Enter username : %s", userName));
		txtUserName.sendKeys(userName);
	}
	
	public void enterPassWord(String passWord) {
		Logging.info("Enter password *****");
		txtPassWord.sendKeys(passWord);
	}
	
	public void clickOnSignInButton() {
		Logging.info("Click SignIn Button");
		signInButton.click();
	}
	
	public void clcikOnForgetPassword() {
		Logging.info("Click Forget Password Button");
		forgetPassword.click();
	}
	
}

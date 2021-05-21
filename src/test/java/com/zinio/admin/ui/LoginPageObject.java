package com.zinio.admin.ui;

import org.openqa.selenium.WebDriver;

import com.zinio.web.element.BasePage;
import com.zinio.web.element.TextBox;

public class LoginPageObject extends BasePage{

	public LoginPageObject(WebDriver driver) {
		super(driver);
	}

	public TextBox userNameTextBox = new TextBox(getDriver(), "Username textbox", "//input[@name='username']");

	public TextBox passwordTextBox = new TextBox(getDriver(), "password textbox", "//input[@name='password']");

	public BasePage submitButton = new BasePage(getDriver(), "signin button",
			"//button[@class='btn btn-primary btn-login']");
	
	public  BasePage errorMessage = new BasePage(getDriver(), "Error message",
			"//p[.='Authentication failed. Please try again.']");

	public  BasePage forgotPasswordLink = new BasePage(getDriver(), "Forgot password", "//a[@href='/forget-password']");

	public  BasePage resetPassword = new BasePage(getDriver(), "Reset password", "//button[.='Reset password']");

	public  BasePage returnToLoginLink = new BasePage(getDriver(), "Return to Login Page", "//a[@href='/login']");

	public  BasePage loginTitle = new BasePage(getDriver(), "Login title", "//div[@class='form-title']//h2");

	public  TextBox confirmPasswordTextbox = new TextBox(getDriver(), "Confirm Password textbox",
			"//input[@name='confirm-password']");

	public  BasePage createPasswordButton = new BasePage(getDriver(), "Create Password button",
			"//button[.='Create password']");
}

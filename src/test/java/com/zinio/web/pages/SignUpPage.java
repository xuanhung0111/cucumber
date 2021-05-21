package com.zinio.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.zinio.web.element.BasePage;
import com.zinio.web.utilities.Logging;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;

public class SignUpPage extends BasePage {

	// Elements Declaration 
	
	
	@FindBy(className = "Register")
    WebElementFacade signUpPage;
	
    @FindBy(name =  "register.email")
    WebElementFacade txtRegisterUserName;
    
    @FindBy(name = "register.passwd1")
    WebElementFacade txtRegisterPassword;
    
    @FindBy(name = "register.passwd2")
    WebElementFacade txtRegisterConfirmPassword;
    
    @FindBy(id = "signUp-submit")
    WebElementFacade signUpBtn;
    
    @FindBy(xpath = "//*[@class='Register']//*[contains(text(), 'Terms of Service')]")
    WebElementFacade termsOfServiceLink;
    
    @FindBy(xpath = "//*[@class='Register']//*[contains(text(), 'Privacy Policy')]")
    WebElementFacade privacyPolicyLink;
    
    @FindBy(name = "register.allow_marketing")
    WebElementFacade allowMarketingCheckbox;
    
    @FindBy(id = "fb-button")
    WebElementFacade fbBtn;
    
    @FindBy(xpath="//*[contains(text(), 'Sign In')]")
    WebElementFacade signInbtn;
    
    @FindBy(id="Login-error")
    WebElementFacade loginError;
    
    @FindBy(className="Login-errorMessage")
    WebElementFacade loginErrorMessage;
    
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    // Actions
    
    public void enterRegisterUserName(String RegisterUserName) 
    {
    			Logging.info("Register Your User Name: " + RegisterUserName);
        		txtRegisterUserName.sendKeys(RegisterUserName);
    }
    
    public void enterRegisterPassword(String password)
    {
    		Logging.info("Register Your Password ");
    		txtRegisterPassword.sendKeys(password);
    }
    
    public void enterRegisterConfirmPassword(String password) 
    {
 		Logging.info("Confirm Register Password");
 		txtRegisterConfirmPassword.sendKeys(password);
 		txtRegisterConfirmPassword.shouldBeCurrentlyVisible();
    }
    
    public void clickSignUpBtn()
    {
    		Logging.info("Click Sign Up Button");
    		signUpBtn.click();
    }
	
	public void gotoTermsOfServicePage()
	{
		Logging.info("Click on Terms Of Service Link");
		termsOfServiceLink.click();
	}
	
	public void gotoPrivacyPolicyPage()
	{
		Logging.info("Click on Privacy Policy Link");
		termsOfServiceLink.click();
	}
	
	public void loginViaFabookAcount()
	{
		Logging.info("Login Via Facebook Account");
		fbBtn.click();
	}
	
	public void backToLoginPage()
	{
		Logging.info("Back to Login Page");
		signInbtn.click();
	}
	
	public boolean checkSignUpPageIsPresent()
	{
		Logging.info("Check Sign Up Page Is Present");
	 	try
	    	{
	    		return signUpPage.isDisplayed();
		} catch (Exception noSuchElement) {
			return false;
		}
	}
	
	 public boolean checkLoginError ()
	    {
			Logging.info("Check Login Error is displayed");
			try {
				return loginError.isDisplayed();
			} catch (Exception noSuchElement) {
				return false;
			}
	    }
	 
	  public String getLoginErrorMessage ()
		{
		    	Logging.info("Get login error message");
		    	return loginErrorMessage.getText();
		}
}

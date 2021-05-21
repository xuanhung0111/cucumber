package com.zinio.web.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zinio.web.element.BasePage;
import com.zinio.web.utilities.Logging;

import net.serenitybdd.core.pages.WebElementFacade;

/**
 * 
 * Author : Hung Nguyen
 * Created on 25/11/2017
 * Page definition of Sign In Page is implemented in this class.
 * As Page object model is used, it will make the maintenance easier
 *
 */

public class SignInPage extends BasePage {
	
	@FindBy(className = "Login")
	WebElementFacade loginPage;

	@FindBy(id = "signIn-email")
	WebElementFacade txtUserName;

    @FindBy(name= "login.password")
    WebElementFacade txtPassword;
    
    @FindBy(xpath = "//*[@class='fullwidth u-Button' and contains(text(), 'SIGN IN')]")
    WebElementFacade signInBtn;
    
    @FindBy(id="signIn-signUpLink")
    WebElementFacade createAccountLink;
    
    @FindBy(className="Login-forgotPassword")
    WebElementFacade forgotPwdLink;
    
    @FindBy(id="btn-fb")
    WebElementFacade facebookSigninBtn;
    
    @FindBy(id="Login-error")
    WebElementFacade loginError;
    
    @FindBy(className="Login-errorMessage")
    WebElementFacade loginErrorMessage;
    
    @FindBy(className="RequestPassword")
    WebElementFacade requestPassword;
    
    @FindBy(name="reset.email")
    WebElementFacade txtResetEmail;
    
    @FindBy(xpath="//*[@type='submit' and contains(text(), 'RESET PASSWORD')]")
    WebElementFacade resetPasswordBt;
    
    @FindBy(xpath="//*[contains(text(), 'Check your email')]")
    WebElementFacade txtCheckYourEmail;
    
    @FindBy(className="fullwidth u-Button")
    WebElementFacade OkButton;
    
    @FindBy(linkText="mailto:support@zinio.com")
    WebElementFacade mailToSupport;
    
    // Login via Facebook account or create new account Facebook
    
    @FindBy(id="email")
    WebElementFacade txtEmailFb;
    
    @FindBy(id="pass")
    WebElementFacade txtPassFb;
    
    @FindBy(xpath="//*[@name='login'][@value='Log In']")
    WebElementFacade loginFbBtn;
    
    @FindBy(id="forgot-password-link")
    WebElementFacade forgotPasswordLink;
    
    @FindBy(xpath="//*[contains(text(), 'Create New Account')]")
    WebElementFacade createNewAccontBtn;
    
    public SignInPage(WebDriver driver) {
		super(driver);
	}

    // Actions
    
    public void enterUsername(String userName) 
    {
    		Logging.info("Enter username is : " + userName);
    		txtUserName.clear();
    		txtUserName.sendKeys(userName);
    }
    
    public void enterPassword(String password) 
    {
    		Logging.info("Enter password : ***");
    		txtPassword.clear();
    		txtPassword.sendKeys(password);
    }
    
    public void clickSignInBtn()
    {
    		Logging.info("Click Sign In Button");
    		signInBtn.click();
    }
    
    public void clickForgotPw()
    {
    		Logging.info("Click Forgot Password Button");
    		forgotPwdLink.click();
    }
    
    public void loginViaFb()
    {
    		Logging.info("Click Login via Facebook");
    		facebookSigninBtn.click();
    }
    
    public void createNewAccount()
    {
    		Logging.info("Click on Create New Account");
    		createAccountLink.click();
    }
    
    public void enterResetEmail (String emailReset)
    {
    		Logging.info("Enter Reset Email: " + emailReset);
    		txtResetEmail.sendKeys(emailReset);
    }
    
    public void clickResetPasswordBtn ()
    {
    		Logging.info("Click on Reset Password Button");
    		resetPasswordBt.click();
    }
    
    public void clickOkButton ()
    {
    		Logging.info("Click on Ok button");
    		OkButton.click();
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
    
    public void goToSupportPage ()
	{
	    	Logging.info("Go To Support Page");
	    	mailToSupport.click();
	}
    
    public boolean checkLoginPageIsPresent ()
   	{
   	    	Logging.info("Check Login Page / SignIn pop up is present");
   	    	try
   	    	{
   	    		return loginPage.isDisplayed();
		} catch (Exception noSuchElement) {
			return false;
   		}
   	}

    public String getLoginErrorMessage ()
	{
	    	Logging.info("Get login error message");
	    	return loginErrorMessage.getText();
	}
    
    // Login via Fb account
    
    public void fillInEmailFb(String emailFb)
   	{
   	    	Logging.info("Fill in Email Facebook");
   	    	txtEmailFb.sendKeys(emailFb);
   	}
    
    public void fillInPassFb(String passWord)
   	{
   	    	Logging.info("Fill in Email Facebook");
   	    	txtPassFb.sendKeys(passWord);
   	}
    
    public void clickLogInFbBtn()
   	{
   	    	Logging.info("Click Login FaceBook button");
   	    	loginFbBtn.click();
   	}
    
    public void clickForgotPassFb()
   	{
   	    	Logging.info("Click forget password Facebook");
   	    	forgotPasswordLink.click();
   	}
    
    public void createNewAccountFacebook()
   	{
   	    	Logging.info("Create New Account Facebook");
   	    	createNewAccontBtn.click();
   	}

}

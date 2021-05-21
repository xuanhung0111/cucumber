package com.zinio.android.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zinio.web.utilities.Logging;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AndroidAcountTabPage extends BasePageAndroid {

	int timeout = 5;

	public AndroidAcountTabPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// Items in first boarding page

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/btn_start")
	WebElement startBtn;

	// Menu Account button in the bottom
	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/menu_account")
	WebElement menuAccount;

	// Account Tab
	@FindBy(xpath = "//android.widget.TextView[@text='Sign In']")
	WebElement signInTab;
	
	// International Stores
	@FindBy(xpath = "//android.widget.TextView[@text='International Stores']")
	WebElement internationalStoreTab;
	
	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/tv_newsstand_country_name")
	List<WebElement> listNewsstand;
	
	// Start Reading part

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/sign_in_zenith_button")
	WebElement signInZenithBtn;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/fb_login_button")
	WebElement fbLoginBtn;

	// Content in the Sign Up -Sig In popup

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/sign_in_title")
	WebElement signInTitle;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/email_field")
	WebElement emailField;
	
	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/password_field")
	WebElement passwordField;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/confirm_password_field")
	WebElement confirmPasswordField;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/create_account_button")
	WebElement createAccountBtn;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/sign_up_button")
	WebElement signUpBtn;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/sign_in_button")
	WebElement signInBtn;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/forgot_button")
	WebElement forgotButton;

	// User profile

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/setting_text")
	WebElement userSettingText;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/change_password_container")
	WebElement changePassword;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/sign_out_button")
	WebElement signOut;

	// Change Password
	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/old_password_field")
	WebElement oldPasswordField;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/new_password_field")
	WebElement newPasswordField;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/cancel_button")
	WebElement cancelBtn;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/confirm_button")
	WebElement confirmBtn;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/forgot_button")
	WebElement forgotPasswordBtn;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/send_button")
	WebElement submitBtn;

	// Payment Information
	@FindBy(xpath = "//android.widget.TextView[@text='Payment Information']")
	WebElement paymentInfoTab;
	
	@FindBy(xpath = "//android.widget.Button[@text='Add payment method']")
	WebElement addPaymentMethod;
	
	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/btn_update")
	WebElement updateBtn;

	// Subsciptions
	@FindBy(xpath = "//android.widget.TextView[@text='Subscriptions']")
	WebElement subscriptionsTab;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/tv_empty_library")
	WebElement emptyLibrary;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/iv_cover")
	List<WebElement> subscriptionCover;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/tv_title")
	List<WebElement> subscriptionTitle;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/tv_sub_title")
	List<WebElement> totalIssueSub;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/tv_status")
	List<WebElement> subscriptionStatus;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/tv_status_info_value")
	List<WebElement> issueRemaining;
	 
	// How to navigate
	@FindBy(xpath = "//android.widget.TextView[@text='How to navigate']")
	WebElement howToNavigageTab;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Legal notices']")
	WebElement legalNoticesTab;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Preferences']")
	WebElement preferencesTab;
	
	//Login by Facebook 
	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/fb_login_button")
	WebElement facebookBtn;
	
	@FindBy(id = "m_login_email")
	WebElement fbEmail;
	
	@FindBy(id = "m_login_password")
	WebElement fbPassword;
	
	@FindBy(id = "u_0_5")
	WebElement fbLogin;
	
	@FindBy(id = "u_0_9")
	WebElement continueFbBtn;
	
	@FindBy(id = "u_0_3")
	WebElement continueBtn;
	// ---------------Action on element-----------------

	public void startOnboarding() {
		rightLeftSwipe(1000);
		waitReady(1000);
		rightLeftSwipe(1000);
		waitReady(1000);
		rightLeftSwipe(1000);
		waitReady(1000);
		rightLeftSwipe(1000);
		pressStartButton();
	}

	public void goToSignUpMode() {
		menuAccount.click();
		signInTab.click();
		signUpBtn.click();
	}

	public void tapOnAccount() {
		menuAccount.click();
	}

	public void enterRegisterUsernamePassword(String registerUserName, String registerPassword) {
		emailField.sendKeys(registerUserName);
		passwordField.sendKeys(registerPassword);
		confirmPasswordField.sendKeys(registerPassword);
	}

	public void pressStartButton() {
		startBtn.click();
		waitReady(2000);
	}

	public void tapOnSignUpBtn() {
		createAccountBtn.click();
		waitReady(5000);
	}

	public void goToSignInModal() {
		menuAccount.click();
		signInTab.click();
		signInZenithBtn.click();
	}

	public void signIn(String email, String password) {
		Logging.info("Enter user name :" + email + "and password: ***");
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		signInBtn.click();
	}

	public void goToChangePasswordScreen() {
		userSettingText.click();
		changePassword.click();
	}

	public void changePAssword(String oldPassword, String newPassword) {
		oldPasswordField.sendKeys(oldPassword);
		newPasswordField.sendKeys(newPassword);
		confirmPasswordField.sendKeys(newPassword);
		confirmBtn.click();
	}

	public void waitUntilOnboardingPageDisplay() {
		WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("com.zinio.mobile.android.reader.sbx:id/iv_onboarding")));
	}

	public void goToForgetPasswordScreen(String oldPassword, String newPassword) {
		goToSignInModal();
		forgotPasswordBtn.click();
	}

	public boolean isSignInScreenPresent() {
		Logging.info("Check Sign In Zinio screen is present");
		try {
			return signInTitle.isDisplayed();
		} catch (Exception noSuchElement) {
			return false;
		}
	}

	public void signUpNewAccount(String registerUserName, String registerPassword) {
		Logging.info("Sign Up a new account");
		signUpBtn.click();
		enterRegisterUsernamePassword(registerUserName, registerPassword);
		waitReady(1000);
	}

	public void tapOnChangePassword() {
		changePassword.click();
	}

	public void tapOnSubscriptionTab() {
		Logging.info("Click on Subcriptions Tab");
		subscriptionsTab.click();
	}

	public boolean isLibraryEmpty() {
		Logging.info("Click on Subcriptions Tab");
		try {
			return emptyLibrary.isDisplayed();
		} catch (Exception noSuchElement) {
			return false;
		}
	}

	public boolean checkSubInSubscriptionTab(String SubsName) {
		Logging.info("Check subcription cover is shown in the Subscription Tab");
		for (int i = 0; i < subscriptionTitle.size(); i++) {
			if (subscriptionTitle.get(i).getText().equals(SubsName)) {
				return true;
			}
		}
		return false;
	}

	public void tapOnInternationalStore() {
		Logging.info("Tap on International Stores");
		internationalStoreTab.click();
	}
	
	
	public void tapOnNewsstand(String newsstand) {
		Logging.info("Tap on newsstand : " + newsstand);
		scrollToView(newsstand);
		for(int i=0; i< listNewsstand.size(); i++) {
			if(listNewsstand.get(i).getText().equals(newsstand)) {
				listNewsstand.get(i).click();
				break;
			}
		}
	}
	
	public void tapOnPamentInformationTab() {
		Logging.info("Tap on Payment Information tabs");
		paymentInfoTab.click();
	}
	
	public void addPaymentMethod() {
		Logging.info("Adding payment medthod......");
		addPaymentMethod.click();
	}
	
	public void tapOnUpdateBtn() {
		Logging.info("Tap on update button");
		updateBtn.click();
	}
	
	public void tapOnHowToNavigateTab() {
		Logging.info("Tap on How to Navigate Tab");
		howToNavigageTab.click();
	}
	
	public void tapOnLegalNoticesTab() {
		Logging.info("Tap on Legal Notices Tab");
		legalNoticesTab.click();
	}
	
	public void tapOnContinueWithFacebook() {
		Logging.info("Tap on Continue with Facebook");
		facebookBtn.click();
	}
	
	public void inputFacebookEmail(String Email) {
		Logging.info("Input Facebook Email");
		fbEmail.sendKeys(Email);
	}
	
	public void inputFacebookPassword(String password) {
		Logging.info("Input Facebook Password");
		fbPassword.sendKeys(password);
	}
	
	public void tapOnFacebookLogin() {
		Logging.info("Tap on Login Facebook button");
		fbLogin.click();
	}
	
	public void tapOnContinueFbBtn() {
		Logging.info("Tap on contunue Facebook Btn");
		continueFbBtn.click();
	}
	
	public void goToFacebookModal() {
		menuAccount.click();
		signInTab.click();
		facebookBtn.click();
	}
	
	public void loginViaFbAccount(String email, String password) {
		try {
			if(continueBtn.isDisplayed()) {
				continueBtn.click();
			} else {
				inputFacebookEmail(email);
				inputFacebookPassword(password);
				tapOnFacebookLogin();
				tapOnContinueFbBtn();
			}
		} catch (Exception noSuchElement) {
			inputFacebookEmail(email);
			inputFacebookPassword(password);
			tapOnFacebookLogin();
			tapOnContinueFbBtn();
		}
		
	}
}
package com.zinio.zenith.identity.steps;

import java.net.MalformedURLException;
import java.util.List;

import com.zinio.android.page.AndroidAcountTabPage;
import com.zinio.android.page.AndroidProductPage;
import com.zinio.android.page.AndroidSearchTabPage;
import com.zinio.android.page.AndroidShopTabPage;
import com.zinio.web.data.UserData;
import com.zinio.web.utilities.AssertResult;
import com.zinio.web.utilities.DataUtils;
import com.zinio.web.utilities.Logging;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AndroidStepDefs extends AbstractPageStepDefinition {

//	AndroidDriver<AndroidElement> androidDriver = AndroidDriverManager.capabilities();
	AndroidDriver<AndroidElement> androidDriver = getAndroidDriver();
	AndroidAcountTabPage loginAndroidPage = new AndroidAcountTabPage(androidDriver);
	AndroidShopTabPage homeAndroidPage = new AndroidShopTabPage(androidDriver);
	AndroidProductPage androidProductPage = new AndroidProductPage(androidDriver);
	AndroidSearchTabPage androidSearchPage = new AndroidSearchTabPage(androidDriver);
	
	public AndroidStepDefs() throws MalformedURLException {
	}

	@Given("^Launch Zinio app, tap on Account > User Profile > Sign In > Sign Up$")
	public void launch_ZINIO_APP_AND_GO_TO_SIGN_UP_MODE() throws MalformedURLException, InterruptedException {
		waitReady(5000);
		loginAndroidPage.startOnboarding();
		loginAndroidPage.goToSignUpMode();
	}
	
	@And("^Tap on Account > User Profile > Sign In > Sign Up$")
	public void GO_TO_SIGN_UP_MODE() throws MalformedURLException, InterruptedException {
		waitReady(5000);
		loginAndroidPage.goToSignUpMode();
	}


	@And("^Fill in register username and password on android$")
	public void FILL_IN_REGISTER_USERNAME_PASSWORD_ANDROID()
			throws MalformedURLException, InterruptedException {
		String registerUserName = DataUtils.getPropAsString("registerUserName") + getRandomNumber() +  "@zinio.com";
		String registerPassword = DataUtils.getPropAsString("registerPassword");
		DataUtils.setProperty("registerUserName", registerUserName);
		loginAndroidPage.enterRegisterUsernamePassword(registerUserName, registerPassword);
	}

	@When("^Tap on the Sign UP button$")
	public void TAP_ON_SIGN_IP_BTN_ANDROID() throws InterruptedException, MalformedURLException {
		loginAndroidPage.tapOnSignUpBtn();
	}
	
	@And("^Fill in email and password as info below then click Sign Up button on Android$")
	public void FILL_IN_EMAIL_AND_PASSWORD_AS_INFO_BELOW_THEN_CLICK_SIGN_UP_BUTTON(DataTable emailTable) throws Throwable {
		List<List<String>> data = emailTable.raw();
		String username = data.get(1).get(0);
		String password = data.get(1).get(1);
		Logging.info("username is: "+ username + "password is:" + password);
		waitReady(2000);
		loginAndroidPage.enterRegisterUsernamePassword(username, password);
		loginAndroidPage.tapOnSignUpBtn();
		waitReady(2000);
	}

	@Given("^Launch Zinio app, tap on Account > User Profile > Sign In > Sign In$")
	public void LAUNCH_ZINIO_APP_AND_GO_TO_SIGN_IN_MODE() {
		waitReady(10000);
		loginAndroidPage.waitUntilOnboardingPageDisplay();
		loginAndroidPage.startOnboarding();
		loginAndroidPage.goToSignInModal();
	}

	@Given("^Tap on Account > User Profile > Continue With Facebook$")
	public void LAUNCH_ZINIO_APP_AND_GO_TO_FACEBOKK_MODE() {
		loginAndroidPage.goToFacebookModal();
	}

	@And("^Fill in facebook account$")
	public void FILL_IN_FACEBOOK_ACCOUNT() {
		String email = DataUtils.getPropAsString("fbEmail");
		String password = DataUtils.getPropAsString("fbPassword");
		loginAndroidPage.loginViaFbAccount(email, password);
	}
	
	@And("^Login with existed username and password on android$")
	public void FILL_IN_USERNAME_PASSWORD_ANDROID() {
		String username = DataUtils.getPropAsString("newUser");
		String password = DataUtils.getPropAsString("password");
		loginAndroidPage.signIn(username, password);
		waitReady(5000);
	}
	
	@And("^Access Change Password screen$")
	public void ACCESS_CHANGE_PASSWORD_SCREEN() {
		loginAndroidPage.goToChangePasswordScreen();
	}
	
	@And("^Reset default password for user on android$")
	public void RESET_DEFUALT_PASSWORD() {
		loginAndroidPage.tapOnChangePassword();
		String newPassword  = DataUtils.getPropAsString("password");
		String oldPassword = DataUtils.getPropAsString("newPassword");
		loginAndroidPage.changePAssword(oldPassword, newPassword);
	}
	
	@And("^Change account user password on android$")
	public void CHANGE_PASSWORD() {
		String oldPassword = DataUtils.getPropAsString("password");
		String newPassword = DataUtils.getPropAsString("newPassword");
		loginAndroidPage.changePAssword(oldPassword, newPassword);
		waitReady(2000);
	}
	
	@Given("^Launch Zinio app$")
	public void launch_ZINIO_APP() {
		waitReady(5000);
		loginAndroidPage.startOnboarding();
	}
	
	@And("^Tap on Shop$")
	public void TAP_ON_SHOP() {
		homeAndroidPage.tapOnShop();
	}
	
	@And("^Tap on Account$")
	public void TAP_ON_ACCOUNT() {
		loginAndroidPage.tapOnAccount();
	}
	
	@And("^Tab on Subscriptions tab$")
	public void TAP_ON_SUBSCRIPTION_TAB() {
		loginAndroidPage.tapOnSubscriptionTab();
		waitReady(5000);
	}
	
	@And("^Tap on issue cover$")
	public void TAP_ON_ISSUE_COVER() {
		String issueNameCover = DataUtils.getPropAsString("publicationName");
		homeAndroidPage.tapOnIssueCover(issueNameCover);
		waitReady(1000);
	}
	
	@And("^Tap on subcrition cover$")
	public void TAP_ON_SUBCRIPTION_COVER() {
		String subsNameCover = DataUtils.getPropAsString("subscriptionName");
		homeAndroidPage.tapOnIssueCover(subsNameCover);
		waitReady(2000);
	}
	
	
	@When("^Tap on Buy Issue button$")
	public void TAP_ON_BUY_ISSUE_BTN() {
		androidProductPage.tapOnBuyIssue();
		waitReady(2000);
	}
	
	@When("^Tap on Subscribe button$")
	public void TAP_ON_SUBCRIBE_BTN() {
		androidProductPage.tapOnSubscribe();
		waitReady(2000);
	}
	
	@And("^Tap on confirm Subscribe button$")
	public void TAP_ON_CONFIRM_SUBCRIBE_BTN() {
		androidProductPage.tapOnConfirmSubscribe();
		waitReady(1000);
	}
	
	@Then("^Verify that A Sign Into Zinio screen should appear$")
	public void VERIFY_SIGN_IN_SCREEN_APPEAR() {
		AssertResult.pass("SignIn screen is not present, please check again", loginAndroidPage.isSignInScreenPresent());
	}
	
	@Then("^Verify that the Payment Information screen should appear$")
	public void VERIFY_PAYMENT_INFORMATION_APPREAR() {
		if(!androidProductPage.isPaymentExisted()) {
			AssertResult.pass("Payment Information field is not displayed", androidProductPage.isPaymentProfilePresent());
		} else {
			AssertResult.pass("Payment Information field is not displayed", androidProductPage.isPurchaseBtnPresent());
		}
	}
	
	@Then("^Verify that subcription is shown in Subscriptions tab$")
	public void VERIFY_SUBSCRIPTION_IS_SHOWN_SUBSCRIPTION_TAB() {
		String subscriptionName = DataUtils.getPropAsString("subscriptionName");
		AssertResult.pass("Subcription is not shown after puschased", loginAndroidPage.checkSubInSubscriptionTab(subscriptionName));
	}
	
	@When("^Input correct credentials and proceed the payment$")
	public void INPUT_PROCEED_THE_PAYMENT() {
		if(!androidProductPage.isPaymentExisted()) {
			androidProductPage.inputProceedThePayment();
		}
		androidProductPage.tapOnPuchaseBtn();
		waitReady(40000);
		Logging.info("Finished waiting purchasing......");
	}
	
	@Then("^Verify that Thank You Page should appear$")
	public void VERIFY_THANKYOUU_PAGE_APPEAR() {
		AssertResult.pass("Thankyou page should appear", androidProductPage.isThankYouPagePresent());
		androidProductPage.tapOnBackToShop();
	}
	
	@And("^Sign up a new account$")
	public void SIGN_UP_NEW_ACCOUNT() {
		String registerUserName = DataUtils.getPropAsString("registerUserName") + getRandomNumber() + "@zinio.com";
		String registerPassword = DataUtils.getPropAsString("registerPassword");
		DataUtils.setProperty("registerUserName", registerUserName);
		loginAndroidPage.signUpNewAccount(registerUserName, registerPassword);
		loginAndroidPage.tapOnSignUpBtn();
	}
	
	@Then("^Verify product page displays price correctly on android app$")
	public void VERIFY_ANDROID_APP_DISPLAY_PRICE_CORERCTLY() {
		String appIssuePrice = androidProductPage.getIssuePrice();
		String appSubPrice = androidProductPage.getSubcribePrice();
		String appTotalIssue = androidProductPage.getTotalIssueInSubcribe();
		
		System.out.println("ON Android app ++++++++++ issue price:  " +appIssuePrice);
		System.out.println("ON Android app ++++++++++ subscription price : " +appSubPrice);
		System.out.println("ON Android app ++++++++++ total issue is: " + appTotalIssue);
		System.out.println("ON Android app ++++++++++ currency is: " + androidProductPage.getIssueCurrency());
		System.out.println("ON Android app ++++++++++ currency 2 is: " + androidProductPage.getSubcCurrency());
		
		AssertResult.pass("Currency should be the same", androidProductPage.getIssueCurrency().equals(androidProductPage.getSubcCurrency()));
		
		AssertResult.pass("Issue price should be the same", appIssuePrice.equals(DataUtils.getPropAsString("issuePrice")));
		AssertResult.pass("Subscription price should be the same", appSubPrice.equals(DataUtils.getPropAsString("totalPrice")));
		AssertResult.pass("Total issue should be the same", appTotalIssue.equals(DataUtils.getPropAsString("totalIssue")));
		AssertResult.pass("Currency issue should be the same", androidProductPage.getSubcCurrency().equals(DataUtils.getPropAsString("currency")));
	}
	
	@Then("^Verify product page displays price correctly on android app on different newsstand$")
	public void VERIFY_ANDROID_APP_DISPLAY_PRICE_CORERCTLY_DIFFERENT_NEWSSTAND() {
		String appIssuePrice = androidProductPage.getIssuePrice();
		String appSubPrice = androidProductPage.getSubcribePrice();
		String appTotalIssue = androidProductPage.getTotalIssueInSubcribe();
		
		AssertResult.pass("Currency should be the same", androidProductPage.getIssueCurrency().equals(androidProductPage.getSubcCurrency()));
		
		AssertResult.pass("Total issue should be the same", appTotalIssue.equals(DataUtils.getPropAsString("totalIssue")));
		
		AssertResult.pass("Issue price should be correctly", appIssuePrice.equals(DataUtils.getPropAsString("issuePrice")));
		
		AssertResult.pass("Subscription price should be correctly", appSubPrice.equals(DataUtils.getPropAsString("totalPrice")));
		
		AssertResult.pass("Currency issue should be correctly", androidProductPage.getSubcCurrency().equals(DataUtils.getPropAsString("currency")));
	}
	
	@And("^Change newsstand to \"([^\"]*)\" Store$")
	public void CHANGE_NEWSSTAND_TO_STORE(String newsstand) {
		loginAndroidPage.tapOnAccount();
		loginAndroidPage.tapOnInternationalStore();
		loginAndroidPage.tapOnNewsstand(newsstand);
		loginAndroidPage.tapOnBackBtn();
	}
	
	@And("^Search out any magazine on android app$")
	public void SEARCH_OUT_MAGAZINE() {
		androidSearchPage.tapOnSearchTap();
		String publicationName = DataUtils.getPropAsString("publicationName");
		androidSearchPage.searchingArticle(publicationName);
		waitReady(4000);
		AssertResult.pass("Publication should be displayed", androidSearchPage.checkPublicationIsPresent(publicationName));
		androidSearchPage.tapPublicationAfterSearching(publicationName);
		waitReady(2000);
	}
	
	@And("^Tap on Payment Information tab in Settings menu$")
	public void TAP_ON_PAYMENT_INFORMATION_TAB() {
		loginAndroidPage.tapOnAccount();
		loginAndroidPage.tapOnPamentInformationTab();
	}
	
	@And("^Tap on the 'Add Payment Method' button$")
	public void ADDING_PAYMENT_METHOD() {
		loginAndroidPage.addPaymentMethod();
	}
	
	@Then("^Complete the form with correct values and Hit 'Save' button$")
	public void COMPLETE_PAYMENT_CREDIT_CARD_FORM() {
		androidProductPage.inputProceedThePayment();
	}
	
	@Then("^Complete the form with paypal account and Hit 'Save' button$")
	public void COMPLETE_PAYMENT_PAYPAL_FORM() {
		androidProductPage.addPaymentByPaypalMethod();
	}
	
	@When("^Edit Payment Information on Android then hit 'Save' button$")
	public void EDIT_PAYMENT_INFORMATION_ON_ANDROID() {
		loginAndroidPage.tapOnUpdateBtn();
		androidProductPage.updateThePayment();
	}
}

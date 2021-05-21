package com.zinio.zenith.identity.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;
import cucumber.api.java.en.Then;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zinio.admin.page.methods.LoginAdminPage;
import com.zinio.admin.page.methods.UsersAdminPage;
import com.zinio.admin.pages.AdminOrdersPage;
import com.zinio.android.page.AndroidAcountTabPage;
import com.zinio.web.data.UserData;
import com.zinio.web.pages.CheckoutPage;
import com.zinio.web.pages.EmailPage;
import com.zinio.web.pages.FooterPage;
import com.zinio.web.pages.HomePage;
import com.zinio.web.pages.PaymentInfoPage;
import com.zinio.web.pages.ProductPage;
import com.zinio.web.pages.ReaderPage;
import com.zinio.web.pages.SettingPage;
import com.zinio.web.pages.SignInPage;
import com.zinio.web.pages.SignUpPage;
import com.zinio.web.utilities.AssertResult;
import com.zinio.web.utilities.DataUtils;
import com.zinio.web.utilities.Logging;
import com.zinio.web.utilities.PropertyUtils;
import com.zinio.web.utilities.ReadJsonFile;
import com.zinio.web.workflow.AdminWorkFlow;
import com.zinio.web.workflow.WebWorkFlow;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;

public class WebStepDefinition extends AbstractPageStepDefinition{
	
	WebDriver driver = getDriver();
	SignInPage signInPage = new SignInPage(driver);
	SignUpPage signUpPage = new SignUpPage(driver);
	WebWorkFlow webWorkFlowPage = new WebWorkFlow(driver);
	WebWorkFlow webWorkFlow = new WebWorkFlow(driver);
	HomePage homePage = new HomePage(driver);
	AdminOrdersPage adminOrdersPage = new AdminOrdersPage(driver);
	WebDriverWait waitUntil;
	ProductPage productPage = new ProductPage(driver);
	CheckoutPage checkOutPage = new CheckoutPage(driver);
	PaymentInfoPage paymentInfoPage = new PaymentInfoPage(driver);
	ReaderPage readerPage = new ReaderPage(driver);
	FooterPage footerPage = new FooterPage(driver);
	EmailPage emailPage = new EmailPage(driver);
	SettingPage settingPage = new SettingPage(driver);

	int currentThumbnailSize;
	String bookmarkTitle;
	public WebStepDefinition() throws MalformedURLException {
	}

	@After()
	public void CLEAR_ALL_TEST() {
		Logging.info("Clean all test case ...............................");
		afterAllTest();
		DataUtils.setProperty("registerUserName", "xuanhung.nguyen+register");
		DataUtils.setProperty("newUser", "xuanhung.nguyen+newandroid");
	}

	@Given("^Create new user$")
	public void CREATE_NEW_USER() throws Throwable {
		goToSignUpPage();
		String newUser = DataUtils.getPropAsString("newUser") + getRandomNumber();
		String newUserDomain = newUser + "@zinio.com";
		String password = DataUtils.getPropAsString("password");
		DataUtils.setProperty("newUser", newUserDomain);
		signUpPage.enterRegisterUserName(newUserDomain);
		signUpPage.enterRegisterPassword(password);
		signUpPage.enterRegisterConfirmPassword(password);
		signUpPage.clickSignUpBtn();
		waitReady(4000);
		homePage.clickOnAccount();
		waitReady(1000);
		homePage.clickSignOut();
		waitReady(3000);
	}
	
	@Given("^Go to Zinio Home page$")
	public void ACCESS_ZINIO_HOME_PAGE() throws Throwable {
		goToHomePage();
//		waitPageLoading();
	}

	@Given("^Go to Shop All page$")
	public void ACCESS_SHOP_ALL_PAGE() throws Throwable {
		goToHomePage();
		homePage.clickShopDropDown();
		homePage.selectShopOption("Shop All");
		waitReady(3000);
	}

	@Given("^Access ([^\"]*) page$")
	public void ACCESS_PAGE_OPTION(String shopOption) throws Throwable {
		goToHomePage();
		if (!shopOption.equals("Zinio Home")) {
			homePage.clickShopDropDown();
			homePage.selectShopOption(shopOption);
		}
	}

	@Then("^Verify that user can access Shop All Page successfully$")
	public void VERIFY_SHOP_PAGE_PRESENT() throws Throwable {
		AssertResult.pass("Title Header is not shown as Shop All", homePage.getTitleHeader().equals("Shop All"));
		AssertResult.pass("Top Sellers section is not shown on Shop All page",
				homePage.isTopSellersPresentAtShopAllPage());
		AssertResult.pass("Featured section is not shown on Shop All page", homePage.isFeaturedPresentAtShopAllPage());
		AssertResult.pass("News Weeklies section is not shown on Shop All page",
				homePage.isNewsWeekliesPresentAtShopAllPage());
		// AssertResult.pass("News Arrival section is not shown on Shop All page",
		// homePage.isNewsArrivalPresentAtShopAllPage());
	}

	@Then("^Verify that user can access Zinio Home Page successfully$")
	public void VERIFY_HOME_PAGE_PRESENT() throws Throwable {
		AssertResult.pass("Top Sellers section is not shown on Home page", homePage.isTopSellersPresentAtHomePage());
		AssertResult.pass("Featured section is not shown on Home page", homePage.isFeaturedPresentAtHomePage());
		AssertResult.pass("Categories section is not shown on Home page", homePage.isCategoriesPresent());
	}

	@Then("^Verify that user can redirect to ([^\"]*) Page successfully$")
	public void VERIFY_FEATURED_PAGE_PRESENT(String featuredName) throws Throwable {
		AssertResult.pass("User cannot access " + featuredName + "Page",
				homePage.getTitleHeader().equals(featuredName));
	}

	@And("^Open login modal$")
	public void OPEN_LOGIN_MODAL() throws Throwable {
		homePage.clickLoginBtn();
		waitReady(2000);
	}

	@And("^Click on the Create your ZINIO account$")
	public void CLICK_CREATE_ZINIO_ACCOUNT() throws Throwable {
		signInPage.createNewAccount();
	}

	@And("^Sign in with register username and password on web$")
	public void SIGN_IN_REGISTER_NEW_USER() throws Throwable {
		String registerUserName = DataUtils.getPropAsString("registerUserName");
		String registerUserNameDomain = registerUserName + "@zinio.com";
		String registerPassword = DataUtils.getPropAsString("registerPassword");
		
		signUpPage.enterRegisterUserName(registerUserNameDomain);
		signUpPage.enterRegisterPassword(registerPassword);
		signUpPage.enterRegisterConfirmPassword(registerPassword);
	}
	
	@And("^Fill in register username and password on web$")
	public void FILL_IN_REGISTER_NEW_USER() throws Throwable {
		String registerUserName = DataUtils.getPropAsString("registerUserName") + getRandomNumber();
		String registerUserNameDomain = registerUserName + "@zinio.com";
		String registerPassword = DataUtils.getPropAsString("registerPassword");
		DataUtils.setProperty("registerUserName", registerUserName);
		signUpPage.enterRegisterUserName(registerUserNameDomain);
		signUpPage.enterRegisterPassword(registerPassword);
		signUpPage.enterRegisterConfirmPassword(registerPassword);
	}
	
	@When("^Click on Sign Up button$")
	public void CLICK_SIGN_UP_BTN() throws Throwable {
		signUpPage.clickSignUpBtn();
		waitReady(3000);
	}

	@Then("^Verify user can create new account successfully$")
	public void VERIFY_USER_CREATED_SUCCESSFULLY() throws Throwable {
		AssertResult.fail("Sign Up page still present", signUpPage.checkSignUpPageIsPresent());
		AssertResult.pass("User is not present on Home Page", homePage.isUserNamePresent(DataUtils.getPropAsString("registerUserName")));
	}

	@And("^Log out$")
	public void LOGOUT_USER() throws Throwable {
		homePage.clickOnAccount();
		homePage.clickSignOut();
		AssertResult.fail("User is present on Home Page", homePage.isUserNamePresent(DataUtils.getPropAsString("username")));
	}

	@And("^Login with register username and password on web$")
	public void LOGIN_REGISTER_USERNAME_PASSWORD() throws Throwable {
		String registerUserName = DataUtils.getPropAsString("registerUserName") + "@zinio.com";
		String registerPassword = DataUtils.getPropAsString("registerPassword");
		signInPage.enterUsername(registerUserName);
		signInPage.enterPassword(registerPassword);
		signInPage.clickSignInBtn();
		waitReady(3000);
	}
	
	@And("^Login with existed username and password on web$")
	public void LOGIN_EXISTED_USERNAME_PASSWORD() throws Throwable {
		String username = DataUtils.getPropAsString("username");
		String password = DataUtils.getPropAsString("password");
		signInPage.enterUsername(username);
		signInPage.enterPassword(password);
		signInPage.clickSignInBtn();
		waitReady(3000);
	}
	
	@And("^Fill in changed password user on web$")
	public void FILL_IN_CHANGED_PASSWORD_USERNAME() throws Throwable {
		String username = DataUtils.getPropAsString("username");
		String password = DataUtils.getPropAsString("newPassword");
		signInPage.enterUsername(username);
		signInPage.enterPassword(password);
		signInPage.clickSignInBtn();
		waitReady(3000);
	}

	@When("^Click on Sign In button$")
	public void CLICK_SIGN_IN_BTN() {
		signInPage.clickSignInBtn();
		waitReady(3000);
	}

	@Then("^Verify user can login successfully$")
	public void VERIFY_USER_IS_SIGN_IN() throws Throwable {
		AssertResult.fail("There is error message is shown", signInPage.checkLoginError());
		AssertResult.pass("User is not present on Home Page", homePage.isUserNamePresent(DataUtils.getPropAsString("username")));
	}

	@Then("^Verify register user can login successfully$")
	public void VERIFY_REGISTER_USER_IS_SIGN_IN() throws Throwable {
		AssertResult.fail("There is error message is shown", signInPage.checkLoginError());
		AssertResult.pass("User is not present on Home Page", homePage.isUserNamePresent(DataUtils.getPropAsString("registerUserName")));
	}
	
	
	@Then("^Verify user cannot login successfully$")
	public void VERIFY_USER_CANNOT_SIGN_IN() throws Throwable {
		AssertResult.pass("There is no error message pop up", signInPage.checkLoginError());
		AssertResult.fail("User is not present on Home Page", homePage.isUserNamePresent(DataUtils.getPropAsString("username")));

	}

	@And("^Click on Facebook button$")
	public void CLICK_FACEBOOK_BTN() {
		signInPage.loginViaFb();
	}

	@And("^Go to a Category page \"([^\"]*)\"$")
	public void GO_TO_CATEGORY_PAGE(String categoryName) {
		homePage.clickShopDropDown();
		homePage.goToCategoriesPage(categoryName);
		waitReady(1000);
	}

	@And("^Go to newsstand \"([^\"]*)\"$")
	public void GO_TO_NEWSSTAND(String newsstandName) throws Throwable {
		footerPage.goToNewsstand(newsstandName);
		waitReady(2000);
		 footerPage.acceptSwitchNewsstand();
		 waitReady(1000);
	}

	@And("^Click to view \"([^\"]*)\" publication$")
	public void CLICK_ON_PUBLICATION(String publicationName) {
		homePage.clickOnCoverImage(publicationName);
		waitReady(2000);
	}
	
	@And("^Click to view publication product page$")
	public void CLICK_TO_VIEW_PUBLICATION() {
		String publicationName = DataUtils.getPropAsString("publicationName");
		homePage.clickOnCoverImage(publicationName);
		waitReady(2000);
	}
	
	@Then("^Get all information about price product$")
	public void GET_INFORMATION_PRICE_PRODUCT() {
		String currencySubscription = productPage.getIssueCurrency();
		String currencyIssue = productPage.getIssueCurrency();
		AssertResult.pass("Currency should be the same", currencySubscription.equals(currencyIssue));
		DataUtils.setProperty("currency", currencyIssue);
		DataUtils.setProperty("issuePrice", productPage.getIssuePrice());
		DataUtils.setProperty("totalPrice", productPage.getSubscribePrice());
		DataUtils.setProperty("totalIssue", productPage.getTotalIssue());
		
		System.out.println("on WWW-----------issue price: " + productPage.getIssuePrice());
		System.out.println("on WWW-----------subsr price: " + productPage.getSubscribePrice());
		System.out.println("on WWW-----------total isse:  " + productPage.getTotalIssue());
		System.out.println("on WWW-----------currency is:  " + currencyIssue);
	}
	

	@When("^Click on BUY ISSUE to add issue to cart$")
	public void CLICK_BUY_ISSUE() {
		productPage.clickBuyIssue();
		waitReady(2000);
	}

	@And("^Click on CHECKOUT button$")
	public void CLICK_CHECKOUT_BTN() {
		checkOutPage.clickCheckoutButton();
	}

	@And("^Click on only SUBSCRIBE button$")
	public void CLICK_SUBSCRIBE_BTN() {
		productPage.clickSubscribe(true);
	}

	@And("^Click on BUY ISSUE button$")
	public void CLICK_BUY_ISSUE_BTN() {
		productPage.clickBuyIssue();
	}

	@And("^On Payment check out page, add credit card information$")
	public void ADD_PAYMENT() throws Throwable {
		if (!checkOutPage.checkPaymentIsExist()) {
			checkOutPage.selectPurchaseCreditCart();
			webWorkFlow.paymentCreditCartProceed();
			waitPageLoading();
		}
	}

	@Then("^Click on Complete Purchase button to purchase$")
	public void CLICK_COMPLETE_PURCHASE() {
		Float subTotal = Float.parseFloat(checkOutPage.getBaseMagazinesPrice());
		Float Tax = Float.parseFloat(checkOutPage.getMagazinesTax());
		Float totalPrice = Float.parseFloat(checkOutPage.getTotalMagazinesPrice());
		String currency = checkOutPage.getCurrency();
		DataUtils.setProperty("subTotal", Float.toString(subTotal));
		DataUtils.setProperty("Tax", Float.toString(Tax));
		DataUtils.setProperty("totalPrice", Float.toString(totalPrice));
		DataUtils.setProperty("currency", currency);
		checkOutPage.clickCompletePurchase();
		waitReady(4000);
	}

	@And("^On Thank you page, click on Start Reading button$")
	public void CLICK_READ_NOW_BTN() {
		AssertResult.pass("ReadNow button isn't present", checkOutPage.isReadBtnPresent());
		checkOutPage.clickReadNowBtn();
		AssertResult.pass("Reader Page isn't present", readerPage.checkReaderModeIsPresent());
	}

	@Then("^Ensure user \"([^\"]*)\" should sign in properly$")
	public void ENSURE_USER_SIGN_IN(String userName) {
		AssertResult.pass("User isn't present in home page", homePage.isUserNamePresent(userName));
	}

	@And("^Click on Forgot Password link$")
	public void CLICK_FORGOT_PASSWORD() {
		signInPage.clickForgotPw();
	}

	@And("^Fill in Enter your Email: \"([^\"]*)\"$")
	public void ENTER_EMAIL_RESET_PASSWORD(String email) {
		signInPage.enterResetEmail(email);
	}

	@When("^Click on Reset Password button$")
	public void CLICK_RESET_PASSWORD() {
		signInPage.clickResetPasswordBtn();
	}


	@And("^Open Reset password email")
	public void OPEN_RESET_PASSWORD_EMAIL() {
		emailPage.openInboxEmail();
	}

	@And("^Go to Create New Password page through hyper-link in email")
	public void CLICK_CREATE_NEW_PASSORD_LINK() {
		emailPage.clickCreateNewPassword();
	}

	@Then("^Search out any magazine$")
	public void SEARCH_OUT_MAGAZINE() {
		String publicationName = DataUtils.getPropAsString("publicationName");
		homePage.sendKeyToSearchBox(publicationName);
		waitReady(2000);
	}

	@And("^Proceed to purchase subscription$")
	public void PURCHASE_SUBSCRIPTION() {
		webWorkFlowPage.purchaseProceed(true, "Credit Cart");
		waitReady(3000);
		AssertResult.pass("Thankyou pannel should be displayed ", homePage.checkThankYouPannelIsPresent());
	}

	@And("^Proceed to purchase single issue \"([^\"]*)\"$")
	public void PURCHASE_SINGLE_ISSUE(String singleIssue) {
		productPage.clickOnRecentIssue(singleIssue);
		webWorkFlowPage.purchaseProceed(false, "Credit Cart");
		waitReady(3000);
		AssertResult.pass("Thankyou pannel should be displayed ", homePage.checkThankYouPannelIsPresent());
	}

	@And("^Go to Library page$")
	public void GO_TO_LIBRARY() {
		homePage.goToLibrary();
		waitReady(4000);
	}

	@Then("^Ensure that there are 2 issues in Library$")
	public void VERIFY_ISSUES_IN_LIBRARY() {
		String publicationName = DataUtils.getPropAsString("publicationName");
		refreshPage();
		int totalIssue = homePage.checkIssueSubcriptionInLibrary(publicationName).size();
		AssertResult.pass("Not sync ! Must be 2 issue in library", totalIssue == 2);
	}
	
	@Then("^Ensure that there is an issues in Library$")
	public void VERIFY_ISSUE_IN_LIBRARY() {
		refreshPage();
		String publicationName = DataUtils.getPropAsString("publicationName");
		int totalIssue = homePage.checkIssueSubcriptionInLibrary(publicationName).size();
		AssertResult.pass("Not sync ! Must be have 1 issue in library", totalIssue == 1);
	}
	
	@Then("^Ensure that there is an subcribe in Library$")
	public void VERIFY_SUBSCRIBE_IN_LIBRARY() {
		refreshPage();
		String publicationName = DataUtils.getPropAsString("subcriptionName");
		int totalIssue = homePage.checkIssueSubcriptionInLibrary(publicationName).size();
		AssertResult.pass("Not sync ! Must be have 1 issue in library", totalIssue == 1);
	}
	
	@And("^Fill in correct credentials username and password$")
	public void FILL_IN_CORRECT_ACCOUNT() {
		String username = DataUtils.getPropAsString("newUser");
		String password = DataUtils.getPropAsString("password");
		signInPage.enterUsername(username);
		signInPage.enterPassword(password);
		signInPage.clickSignInBtn();
		waitReady(5000);
	}
	
	@And("^Login correct credentials NEW username and password$")
	public void FILL_IN_CORRECT_NEW_ACCOUNT() {
		String username = DataUtils.getPropAsString("registerUserName");
		String password = DataUtils.getPropAsString("registerPassword");
		signInPage.enterUsername(username);
		signInPage.enterPassword(password);
		signInPage.clickSignInBtn();
		waitReady(5000);
	}
	@And("^Go to Account Settings > Subscriptions$")
	public void GO_TO_SUBSCRIPTIONS_FROM_ACCOUNT_SETTING() {
		homePage.clickOnAccount();
		homePage.goToAccountSetting();
		settingPage.goToSubriptions();
		waitReady(5000);
	}

	@And("^Go to Account Settings > Payment Information$")
	public void GO_TO_PAYMENT_INFORMATION_FROM_ACCOUNT_SETTING() {
		homePage.clickOnAccount();
		homePage.goToAccountSetting();
		settingPage.goToPaymentPage();
		waitReady(5000);
	}

	@Then("^Verify that payment info is shown correctly as it was set in Mobile$")
	public void VERIFY_PAYMENT_INFO_ON_WEB() {
		AssertResult.pass("First name should be the same", paymentInfoPage.getPaymentFirstName().equals(UserData.FIRST_NAME));
		AssertResult.pass("Last name should be the same", paymentInfoPage.getPaymentLastName().equals(UserData.LAST_NAME));
		AssertResult.pass("Credit Card shoud be like : xxxx-xxxx-xxxx-1111", paymentInfoPage.getPaymentCreditCardNumber().equals(UserData.CART_NUMBER_FORMAT));
		AssertResult.pass("Expire day should be the same", paymentInfoPage.getPaymentExprireDate().replaceAll("\\s+","").equals(UserData.EXPIRE_DATE));
	}
	
	@Then("^Verify that payment info is updated correctly as it was set in Mobile$")
	public void VERIFY_UPDATED_PAYMENT_INFO_ON_WEB() {
		AssertResult.pass("First name should be the same", paymentInfoPage.getPaymentFirstName().equals(UserData.NEW_CREDIT_CARD_INFO[0]));
		AssertResult.pass("Last name should be the same", paymentInfoPage.getPaymentLastName().equals(UserData.NEW_CREDIT_CARD_INFO[1]));
		AssertResult.pass("Credit Card shoud be like : xxxx-xxxx-xxxx-4444", paymentInfoPage.getPaymentCreditCardNumber().equals(UserData.CART_NUMBER_UPDATE_FORMAT));
		AssertResult.pass("Expire day should be the same", paymentInfoPage.getPaymentExprireDate().replaceAll("\\s+","").equals(UserData.EXPIRE_DATE_UPDATE));
	}
	
	@And("^On Payment Information page, add credit card information$")
	public void ADD_PAYMENT_INFO_ON_PAYMENT_INFO_PAGE() throws Throwable {
		if (!paymentInfoPage.checkPaymentIsExist()) {
			paymentInfoPage.selectPurchaseCreditCart();
			webWorkFlow.paymentCreditCartProceed();
			waitPageLoading();
		}
	}

	@And("^On Payment Information page, edit credit card information$")
	public void EDIT_PAYMENT_INFO_ON_PAYMENT_INFO_PAGE() throws Throwable {
		if (paymentInfoPage.checkPaymentIsExist()) {
			paymentInfoPage.clickEditButton();
			waitReady(3000);
			webWorkFlow.paymentCreditCartProceed(UserData.NEW_CREDIT_CARD_INFO);
			waitPageLoading();
		}
	}

	@And("^On Payment Information page, delete credit card information$")
	public void DELETE_PAYMENT_INFO_ON_PAYMENT_INFO_PAGE() throws Throwable {
		if (paymentInfoPage.checkPaymentIsExist()) {
			paymentInfoPage.clickDeleteButton();
			waitReady(3000);
			paymentInfoPage.confirmDelete();
			waitPageLoading();
		}
	}

	@Then("^User has no payment information$")
	public void VERIFY_NO_PAYMENT_INFO() throws Throwable {
		AssertResult.pass("There's no payment info. Delete successfully!", !paymentInfoPage.checkPaymentIsExist());
	}


	@Then("^Ensure that there is an active subscription of \"([^\"]*)\"$")
	public void VERIFY_ACTIVE_SUBSCRIPTION_IN_SUBSCRIPTION_LIST(String subcription) {
		String publicationName = DataUtils.getPropAsString("publicationName");
		AssertResult.pass("Publication should be displayed correct in the account setting",
				settingPage.checkSubcriptionInList(publicationName) == true);

		String publicationStatus = settingPage.getStatusSubcription(subcription);
		AssertResult.pass("Status should be 'Active' ", publicationStatus.equals("Active"));

		String autoRenew = settingPage.getPublicationAtutoRenew(subcription);
		AssertResult.pass("It should be 'Auto Renew on' ", autoRenew.equals("( Auto Renew on)"));
	}

	@Then("^Verify all issues are grouped by Date$")
	public void VERIFY_ISSUES_GROUP_BY_DATE() {
		AssertResult.pass("Library Filter should be 'Publish Date'",
				homePage.getlibraryFilterType().equals("Publish Date"));
	}

	@When("^Select Group by \"([^\"]*)\"$")
	public void SELECT_GROUP_BY(String filterType) {
		homePage.selectLibraryFilterOption(filterType);
		waitReady(3000);
	}

	@When("^Verify all issues are grouped \"([^\"]*)\"$")
	public void VERIFY_ALL_ISSUES_ARE_GROUPED(String filterType) {
		List<String> actualList = homePage.getIssueInLibrary();
		List<String> tmp = new ArrayList(actualList);
		Collections.sort(tmp);
		AssertResult.pass("Issue should be filter by " + filterType, tmp.equals(actualList));
	}

	@And("^Verify the magazine \"([^\"]*)\" should display when searching by keyword as below:$")
	public void VERIFY_MAGAZINE_DISPLAY_WHEN_SEARCHING(String magazine, DataTable table) {
		List<List<String>> data = table.raw();
		for (int i = 1; i < data.size(); i++) {
			String keySearch = data.get(i).get(0);
			String expectedMagazine = data.get(i).get(1);
			Logging.info("keySeach is :" + keySearch + " |||" + "Expected Magazine is :" + expectedMagazine);
			homePage.sendKeyToSearchBox(keySearch);
			AssertResult.pass("Magazine should be displayed", homePage.checkSearchResutl(expectedMagazine));
		}
	}

	@And("^Go to Account Settings > Preferences$")
	public void GO_TO_PREFERENCES_TAB() {
		homePage.clickOnAccount();
		homePage.goToAccountSetting();
		settingPage.goToReferences();
		waitReady(2000);
	}

	@When("^Check allow show adult content while browsing Zinio then click on Save$")
	public void ALLOW_ADULT_CONTENT_SHOWING() {
		settingPage.allowAdultContent();
		settingPage.clickSaveButton();
	}

	@When("^Check not allow show adult content while browsing Zinio then click on Save$")
	public void DO_NOT_ALLOW_ADULT_CONTENT_SHOWING() {
		settingPage.rejectAdultContent();
		settingPage.clickSaveButton();
		waitReady(3000);
	}

	@When("^Check send me email updates then click on Save$")
	public void ALLOW_SEND_EMAIL_UPDATES() {
		settingPage.getCurrentColor();
		settingPage.selectSendEmail(true);
		settingPage.clickSaveButton();
		waitReady(3000);
	}

	@When("^Uncheck send me email updates then click on Save$")
	public void DO_NOT_ALLOW_SEND_EMAIL_UPDATES() {
		settingPage.getCurrentColor();
		settingPage.selectSendEmail(false);
		settingPage.clickSaveButton();
		waitReady(3000);
	}

	@Then("^Verify send me email updates is checked$")
	public void VERIFY_SEND_EMAIL_UPDATES_CHECKED() {
		AssertResult.pass("The send me email updates is checked", settingPage.sendEmailCheckboxStatus());
	}

	@Then("^Verify send me email updates is unchecked$")
	public void VERIFY_SEND_EMAIL_UPDATES_UNCHECKED() {
		AssertResult.pass("The send me email updates is unchecked", !settingPage.sendEmailCheckboxStatus());
	}

	@And("^Find hidden checkbox$")
	public void FIND_HIDDEN_CHECKBOX() {

	}

	@And("^Verify the magazine \"([^\"]*)\" should NOT display when searching by keyword as below:$")
	public void VERIFY_MAGAZINE_NOT_DISPLAY_WHEN_SEARCHING(String magazine, DataTable table) {
		List<List<String>> data = table.raw();
		for (int i = 1; i < data.size(); i++) {
			String keySearch = data.get(i).get(0);
			String expectedMagazine = data.get(i).get(1);
			homePage.sendKeyToSearchBox(keySearch);
			AssertResult.fail("Magazine should be displayed", homePage.checkSearchResutl(expectedMagazine));
		}
	}

	@Then("^Verify category \"([^\"]*)\" is disappeared in shop menu$")
	public void VERIFY_CATEGORIES_DISSAPEAR(String categories) {
		homePage.clickShopDropDown();
		AssertResult.fail("Magazine should be hidden", homePage.checkCategoriesPageIsPresent(categories));
	}

	@Then("^Verify category \"([^\"]*)\" is displayed in shop menu$")
	public void VERIFY_CATEGORIES_DISPLAY(String categories) {
		homePage.clickShopDropDown();
		AssertResult.pass("Magazine should be displayed", homePage.checkCategoriesPageIsPresent(categories));
	}

	@When("^Mouse over on any issue to have the Read Issue with Eye icon appear and click on it$")
	public void READ_ISSUE_IN_LIBRARY() {
		homePage.readAnyIssueInLibrary();
		waitReady(3000);
		AssertResult.fail("Home Page should be hidden when openning the reader mode", homePage.isHomePagePresent());
	}

	@Then("^Verify that the issue is opened in reader$")
	public void OPENED_ISSUE_READER() {
		AssertResult.pass("Reader page is not shown", readerPage.checkReaderModeIsPresent());
	}

	@Then("^Verify reader layout$")
	public void VERIFY_READER_LAYOUT() {
		AssertResult.pass("Zinio icon isn't shown", readerPage.checkZinioIconPresent());
		AssertResult.pass("Table of content isn't shown", readerPage.checkTableOfContentIconPresent());
		AssertResult.pass("Page navigate button isn't shown", readerPage.checkSkipToPageIconPresent());
		AssertResult.pass("Bookmark button isn't shown", readerPage.checkBookmarksIconPresent());
		AssertResult.pass("Fullscreen button isn't shown", readerPage.checkFullScreenIconPresent());
		AssertResult.pass("Zoom button isn't shown", readerPage.checkZoomIconPresent());
		AssertResult.pass("Print button isn't shown", readerPage.checkPrintIconPresent());
	}

	@Then("^Verify tooltip for each element on panel of reader page$")
	public void VERIFY_TOOLTIP_READER_PAGE() {
		AssertResult.pass("Tooltip should be 'Table of contents'",
				readerPage.getToolTipTableOfContent().equals("Table of contents"));
		AssertResult.pass("Tooltip should be 'Skip to page'",
				readerPage.getToolTipPageNavigation().equals("Skip to page"));
		AssertResult.pass("Tooltip should be 'Bookmarks'", readerPage.getToolTipBookmarks().equals("Bookmarks"));
		AssertResult.pass("Tooltip should be 'Toggle Fullscreen'",
				readerPage.getToolTipFullScreen().equals("Toggle Fullscreen"));
		AssertResult.pass("Tooltip should be 'Zoom'", readerPage.getToolTipZoom().equals("zoom"));
		AssertResult.pass("Tooltip should be 'Print'", readerPage.getToolTipPrintBtn().equals("print"));
	}

	@And("^Close the browser tab of the reader$")
	public void CLOSE_BROWSER_TAB_READER() {
		// Need to hover on any element to visible "Exit" element
		readerPage.exitReaderMode();
	}

	@And("^Verify that the browser tab of the reader is closed successfully$")
	public void VERIFY_BROWSER_TAB_IS_CLOSED() {
		AssertResult.fail("Reader Page is still shown", readerPage.checkReaderModeIsPresent());
		AssertResult.pass("Home Page should be shown when closing the reader mode", homePage.isHomePagePresent());

	}

	@And("^Click on the table of contents icon$")
	public void CLICK_TABLE_OF_CONTENTS() {
		readerPage.clickTableOfContentIcon();
		waitReady(2000);
	}

	@Then("^Verity that section list is shown$")
	public void VERIFY_THAT_SECTION_IS_SHOWN() {
		AssertResult.pass("View List Item is not shown in table content", readerPage.checkViewListIsShown());
		AssertResult.fail("Should be more items in the list view", readerPage.getNumViewListItem() == 0);
	}

	@Then("^Verify the layout of section list$")
	public void VERIFY_THE_LAYOUT_SECTION_LIST() {
		AssertResult.fail("Magazine name should not be 'null'", readerPage.getTocItemHearder().equals("null"));
		AssertResult.pass("The line below each section title should be the same with title",
				readerPage.getNumTocLine() == readerPage.getNumViewListItem());
		for (String tocItemTitle : readerPage.getViewListItem()) {
			AssertResult.fail("Section title should not be 'null'", tocItemTitle.equals("null"));
		}
	}

	@And("^Click outside the section list panel$")
	public void CLICK_OUTSIDE_SECTION_LIST() {
		readerPage.clickOutsideSectionList();
		waitReady(2000);
	}

	@Then("^Verify the section list is closed$")
	public void VERIFY_SECTION_LIST_CLOSED() {
		AssertResult.fail("View List Item is still shown in table content", readerPage.checkViewListIsShown());
	}

	@And("^Click on a section name on the section list$")
	public void CLICK_ON_A_SECTION_ON_THE_LIST() {
		readerPage.clickOnSectionNameOnTheList();
		waitReady(2000);
		System.out.println("--- Article List present -----: " + readerPage.checkArticleListPresent());
	}

	@Then("^Verify user can scroll up and down on the article list$")
	public void VERIFY_UER_SCROLL_UP_DOWN() {
		readerPage.scrollToViewTocItem();
	}

	@Then("^Check the article list layout$")
	public void VERIFY_ARTICLE_LIST_LAYOUT() {
		AssertResult.pass("Article list layout is not displayed correct", readerPage.checkArticleListLayout());
	}

	@And("^Click on the Page Navigation icon$")
	public void CLICK_ON_PAGE_NAVIGATION() {
		readerPage.clickSkipToPageIcon();
		waitReady(3000);
	}

	@Then("^Verify Page Navigation list is closed$")
	public void VERIFY_PAGE_NAVIGATION_PRESENT() {
		AssertResult.fail("Page navigation list should be closed", readerPage.checkThumbnailsIsPresent());
	}

	@Then("^The article list and section list are closed$")
	public void VERIFY_ARTICLE_LIST_SECTION_LIST_ARE_CLOSED() {
		VERIFY_SECTION_LIST_CLOSED();
		AssertResult.fail("Article list should be hidden", readerPage.checkArticleListPresent());
	}

	@And("^Click on the > at the right edge of the Page Navigation panel$")
	public void CLICK_EXPAND_THUMBNAIL() {
		currentThumbnailSize = readerPage.getThumbnailsSize();
		readerPage.clickExpandThumbnail();
		waitReady(4000);
	}

	@And("^Click on the < at the right edge of the Page Navigation panel$")
	public void CLICK_NARROW_THUMBNAIL() {
		readerPage.clickNarrowThumbnail();
		waitReady(1000);
	}

	@Then("^Verify Page Navigation list is expanded$")
	public void VERIFY_PAGE_NAVIGATION_LIST_EXPAND() {
		AssertResult.pass("Thumbnail after expand must be bigger than current thumbnail size",
				readerPage.getThumbnailsSize() > currentThumbnailSize);
	}

	@Then("^Verify Page Navigation list is smaller$")
	public void VERIFY_PAGE_NAVIGATION_LIST_SMALLER() {
		AssertResult.pass("Thumbnail after expand must be equal with current thumbnail size",
				readerPage.getThumbnailsSize() == currentThumbnailSize);
	}

	@And("^Click next page button$")
	public void CLICK_NEXT_BTN() {
		readerPage.clickNextPageBtn();
	}

	@And("^Click previous page button$")
	public void CLICK_PREVIOUS_BTN() {
		readerPage.clickPreviousPage();
	}

	@Then("^Left arrow icon, right arrow icon will disappear after 5 seconds on inactivity$")
	public void VERIFY_ARROW_RIGHT_ICON() {
		AssertResult.pass("Next page button should be displayed", readerPage.checkNextPageBtnIsDisplayed());
		AssertResult.pass("Previous page button should be displayed", readerPage.checkPreviousPageBtnIsDisplayed());
		waitReady(6000);
		AssertResult.fail("Next page button should be hidden", readerPage.checkNextPageBtnIsDisplayed());
		AssertResult.fail("Previous page button should be hidden", readerPage.checkPreviousPageBtnIsDisplayed());
	}

	@And("^Click on Bookmarks icon$")
	public void CLICK_BOOKMARKS_ICON() {
		readerPage.clickBookmarksIcon();
		waitReady(2000);
	}

	@Then("^Verify the layout of Bookmarks list$")
	public void VERIFY_LAYOUT_BOOKMARKS_LIST() {
		AssertResult.pass("Bookmarks should be displayed correctly", readerPage.checkBookmarksLayout());
	}

	@And("^Click add bookmark on the Bookmarks list$")
	public void CLICK_ADD_BOOKMARK() {
		readerPage.clickAddBookmarksList();
	}

	@Then("^Verify the bookmark dialog appears$")
	public void VERIFY_BOOKMARK_DIALOG_APPEARS() {
		AssertResult.pass("Bookmarks dialog should be dispalyed", readerPage.checkBookmarkDialogPresent());
		AssertResult.pass("Bookmarks title should be dispalyed", readerPage.checkBookmarkTitlePresent());
		AssertResult.pass("Bookmarks description should be dispalyed", readerPage.checkBookmarkDescriptionPresent());
		AssertResult.pass("Submit Bookmarks button should be dispalyed", readerPage.checkSubmitBookmarkBtnPresent());
	}

	@And("^Add description for the bookmark$")
	public void ADD_BOOKMARK_DESCRIPTION() {
		bookmarkTitle = readerPage.getBookmarkTitleInDialog();
		readerPage.inputBookmarkDescription(UserData.BOOKMARK_DESCRIPTION);
		waitReady(2000);
	}

	@Then("^Verify the bookmarked page appears on the Bookmark list with correct description with special characters$")
	public void VERIFY_BOOKMARKED_WITH_SPECIAL_CHARACTERS_DESCRIPTION() {
		int checkBookmark = 0;
		for (String description : readerPage.getBookmarksDescription()) {
			if (description.equals(UserData.BOOKMARK_SPECIAL_DESCRIPTION))
				checkBookmark += 1;
		}
		AssertResult.fail("Description should be displayed on the bookmark list", checkBookmark == 0);
	}

	@Then("^Verify the bookmarked page appears on the Bookmark list with blank description$")
	public void VERIFY_BOOKMARKED_WITH_BLANK_DESCRIPTION() {
		int checkBookmark = 0;
		for (String description : readerPage.getBookmarksDescription()) {
			if (description.equals(""))
				checkBookmark += 1;
		}
		AssertResult.fail("Description should be blank", checkBookmark == 0);
	}

	@And("^Add description with special characters$")
	public void ADD_BOOKMARK_DESCRIPTION_SPECIAL_CHARACTERS() {
		readerPage.inputBookmarkDescription(UserData.BOOKMARK_SPECIAL_DESCRIPTION);
		waitReady(2000);
	}

	@And("^Leave the description blank$")
	public void LEAVE_DESCRIPTION_BLANK() {
		readerPage.inputBookmarkDescription(" ");
		waitReady(2000);
	}

	@And("^Click on Submit bookmark button$")
	public void CLICK_SUBMIT_BOOKMARK_BUTTON() {
		readerPage.clickSubmitBookmarksBtn();
		waitReady(2000);
	}

	@And("^Verify the bookmarked pages appear on the Bookmark list with correct thumbnail and description$")
	public void VERIFY_BOOKMARKED_PAGES() {
		AssertResult.pass("Bookmarks should be displayed correctly", readerPage.checkBookmarksLayout());
	}

	@And("^Verify that A Thankyou page is displayed with Order ID$")
	public void VERIFY_THANKYOU_PAGE_DISPLAYED_WITH_ORDER_ID() {
		AssertResult.pass("Thankyou page isn't displayed", checkOutPage.checkThankYouPageIsPresent());
		String orderId = checkOutPage.getOrderId();
		DataUtils.setProperty("orderId", orderId);
	}

	@When("^Click x button of any bookmark thumbnail$")
	public void CLICK_X_BUTTON_BOOKMARK_THUMBNAIL() {
		readerPage.deleteBookmark(bookmarkTitle);
	}

	@Then("^Verify the bookmarked is removed$")
	public void VERIFY_BOOKMARKED_REMOVED() {
		AssertResult.pass("Bookmarked page should be removed", readerPage.checkBookmarkIsRemoved(bookmarkTitle));
	}

	@And("^Remove all the bookmarked pages$")
	public void REMOVE_ALL_BOOKMARKED_PAGES() {
		readerPage.deleteAllBookmark();
	}

	@Then("^Verify the all bookmarked  pages are removed$")
	public void VERIFY_ALL_BOOKMARKED_PAGES_REMOVED() {
		AssertResult.pass("ALL Bookmarked pages should be removed", readerPage.checkAllBookmarkAreRemoved());
	}

	@And("^Add more bookmark pages$")
	public void ADD_MORE_BOOKMARK_PAGES() {
		for (int i = 0; i < 3; i++) {
			CLICK_BOOKMARKS_ICON();
			CLICK_ADD_BOOKMARK();
			ADD_BOOKMARK_DESCRIPTION();
			CLICK_SUBMIT_BOOKMARK_BUTTON();
			CLICK_OUTSIDE_SECTION_LIST();
			CLICK_NEXT_BTN();
		}
	}

	@Given("^Go back Zinio page$")
	public void GO_BACK_TO_ZINIO_PAGE() {
		switchToNewTabWindow(false);
	}

	@Given("^Go back Admin page$")
	public void GO_BACK_TO_ADMIN_PAGE() {
		switchToNewTabWindow(true);
		refresh();
		waitReady(2000);
	}

	@Given("^Step test one$")
	public void STEP_ONE() {
		System.out.println("For me test only");

	}

	@Then("^Verify that add bookmark link is shown$")
	public void VERIFY_BOOKMARK_LINK_PRESENT() {
		AssertResult.pass("Bookmark link should be displayed", readerPage.checkBookmarkLinkPresent());
	}

	@Then("^Verify that add bookmark link is NOT shown$")
	public void VERIFY_BOOKMARK_LINK_HIDDEN() {
		AssertResult.fail("Bookmark link should be hidden", readerPage.checkBookmarkLinkPresent());
	}

	//
	// Neef time to troubleshoot current issue
	// WEB - ADMIN will define under this block
	//

	@Given("^Access Zinio Sign-Up Page$")
	public void ACCESS_ZINIO_SIGN_UP_PAGE() throws Throwable {
		goToSignUpPage();
		waitPageLoading();
	}

	@When("^Fill in user name and password as info below then click Sign Up button$")
	public void FILL_IN_REGISTER_USERNAME_PASSWORD(DataTable emailTable) throws Throwable {
		List<List<String>> data = emailTable.raw();
		String username = data.get(1).get(0);
		String password = data.get(1).get(1);
		signUpPage.enterRegisterUserName(username);
		signUpPage.enterRegisterPassword(password);
		signUpPage.enterRegisterConfirmPassword(password);
		signUpPage.clickSignUpBtn();
		waitReady(2000);
	}

	

	@Then("^Ensure user can sign in successfully$")
	public void ENSURE_USER_SIGN_IN_SUCCESSFULLY(DataTable emailTable) throws Throwable {
		List<List<String>> data = emailTable.raw();
		String username = data.get(1).get(0);
		String passWord = data.get(1).get(1);
		openNewTabWithURL();
		goToSignInPage();
		signInPage.enterUsername(username);
		signInPage.enterPassword(passWord);
		signInPage.clickSignInBtn();
		waitReady(2000);
		AssertResult.fail("Error message is shown", signInPage.checkLoginError());
		AssertResult.pass("User login into Home Page", homePage.isUserNamePresent(username));
	}

	@Then("^Ensure user CANNOT sign in successfully$")
	public void ENSURE_USER_CANNOT_SIGN_IN(DataTable emailTable) throws Throwable {
		List<List<String>> data = emailTable.raw();
		String username = data.get(1).get(0);
		String passWord = data.get(1).get(1);
		openNewTabWithURL();
		goToSignInPage();
		signInPage.enterUsername(username);
		signInPage.enterPassword(passWord);
		signInPage.clickSignInBtn();
		waitReady(2000);
		AssertResult.pass("Error message should be displayed", signInPage.checkLoginError());
	}

	@Then("^Ensure user CANNOT sign in successfully after disabled users$")
	public void ENSURE_USER_CANNOT_SIGN_IN_AFTER_DISSABLE_USERS(DataTable emailTable) throws Throwable {
		List<List<String>> data = emailTable.raw();
		String username = data.get(1).get(0);
		String passWord = data.get(1).get(1);
		openNewTabWithURL();
		goToSignInPage();
		signInPage.enterUsername(username);
		signInPage.enterPassword(passWord);
		signInPage.clickSignInBtn();
		AssertResult.pass("Error message is displayed", signInPage.checkLoginError());
	}

	@Then("^Change current language to \"([^\"]*)\" and veriry that it is displayed correctly$")
	public void CHANGE_AND_VERIFY_LANGUAGE(String language) {
		homePage.clickOnLanguage();
		waitReady(1000);
		String langagueCode = ReadJsonFile.getData(language);
		homePage.selectLanguage(language, langagueCode);
		AssertResult.pass("Test case error! Language should be correct as input ", homePage.getCurrentLanguageDisplay().equals(language));
	}
	
	@Then("^Verify that that there is an active subscription in subscription tab$")
	public void VERIFY_SUBSCRIPTION_IN_SUBSCRIPTION_TAB() {
		
		String publicationName = DataUtils.getPropAsString("subscriptionName");
		AssertResult.pass("Publication should be displayed correct in the account setting",
				settingPage.checkSubcriptionInList(publicationName) == true);

		String publicationStatus = settingPage.getStatusSubcription(publicationName);
		
		AssertResult.pass("Status should be 'Active' ", publicationStatus.equals("Active"));

		String autoRenew = settingPage.getPublicationAtutoRenew(publicationName);
		AssertResult.pass("It should be 'Auto Renew on' ", autoRenew.equals("( Auto Renew on)"));
	}
	
	@When("^Step test two$")
	public void STEP_TWO() {
		Logging.info("Step 2");
	}

	@When("^Step test three$")
	public void STEP_THREE() {
		waitReady(2000);
		Logging.info("Step 3");
	}

	
}

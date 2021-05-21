package com.zinio.zenith.identity.steps;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zinio.admin.page.methods.LoginAdminPage;
import com.zinio.admin.page.methods.UsersAdminPage;
import com.zinio.admin.pages.AdminOrdersPage;
import com.zinio.web.data.UserData;
import com.zinio.web.pages.HomePage;
import com.zinio.web.utilities.AssertResult;
import com.zinio.web.utilities.DataUtils;
import com.zinio.web.workflow.AdminWorkFlow;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdminStepDefinition extends AbstractPageStepDefinition {
	
	WebDriver driver = getDriver();
	AdminWorkFlow adminWorkFlowPage = new AdminWorkFlow(driver);
	AdminOrdersPage adminOrdersPage = new AdminOrdersPage(driver);
	WebDriverWait waitUntil;
	LoginAdminPage loginAdminPage = new LoginAdminPage(driver);
	UsersAdminPage userAdminPage = new UsersAdminPage(driver);
	HomePage homePage = new HomePage(driver);

	@Given("^From Admin side$")
	public void FROM_ADMIN_SIDE() { 
		openNewTabWithURL();
	}
	
	@Given("^Login by Zinio Staff account$")
	public void LOGIN_BY_ZINIO_STAFF_ACCOUNT() throws Throwable {
		loginAdminPage.login(UserData.USER_EMAIL, UserData.PASSWORD);
		waitReady(4000);
	}

	@And("^Go to Users landing page$")
	public void GO_TO_USERS_LANDING_PAGE() throws Throwable {
		userAdminPage.clickOnUserTab();
	}

	@And("^Search out user by email \"([^\"]*)\"$")
	public void SEARCH_USER_BY_EMAIL(String emailUser) throws Throwable {
		adminWorkFlowPage.searchEmail(emailUser);
	}
	@Then ("^Verify that the user has been signed up from Android is able to search out by email in Admin")
	public void SEARCH_ANDROID_USER_BY_EMAIL(DataTable emailTable) throws Throwable{
		List<List<String>> data = emailTable.raw();
		String username = data.get(1).get(0);
		adminWorkFlowPage.searchEmail(username);
		List<Map<String, WebElement>> listUserEmail = userAdminPage.getEmailHref();
		listUserEmail.get(0).get("Email").click();
		userAdminPage.clickOnGeneralTab();
		waitReady(2000);
	}
	
	@And("^Go to user details > General Information$")
	public void GO_TO_USER_DETAIL_PAGE() throws Throwable {
		List<Map<String, WebElement>> listUserEmail = userAdminPage.getEmailHref();
		listUserEmail.get(0).get("Email").click();
		userAdminPage.clickOnGeneralTab();
		waitReady(1000);
	}
	
	@And("^Go to user Payment Profile tab$")
	public void GO_TO_PAYMENT_PROFILE_TAB() throws Throwable {
		userAdminPage.clickPaymentProfileTab();
	}

	@And("^Go to user details > Preferences, select project is \"([^\"]*)\"$")
	public void GO_TO_PREFERENCES(String project) throws Throwable {
		List<Map<String, WebElement>> listUserEmail = userAdminPage.getEmailHref();
		listUserEmail.get(0).get("Email").click();
		userAdminPage.clickReferencesTab();
		waitReady(1000);
		userAdminPage.selectProjectReferences(project);
		waitReady(2000);
	}

	@And("^Go to user details > Payment Profile$")
	public void GO_TO_PAYMENT_PROFILE() {
		List<Map<String, WebElement>> listUserEmail = userAdminPage.getEmailHref();
		listUserEmail.get(0).get("Email").click();
		userAdminPage.clickPaymentProfileTab();
		waitReady(2000);
	}

	@And("^Click on Orders tab$")
	public void GO_TO_ORDERS_TAB() {
		userAdminPage.clickOrdersTab();
	}

	@Then("^In Orders tab, there is an order record about the order that user has just purchased$")
	public void VERIFY_ORDER_RECORD_IN_ORDER_TAB() {
		List<Map<String, String>> orderItems = userAdminPage.getItemsTable("Record issue");
		AssertResult.pass("Order in Admin page should be the same with the orderId",
				orderItems.get(0).get("Order ID").equals(DataUtils.getPropAsString("orderId")));
	}

	@And("^Click on Issue Subscriptions tab$")
	public void GO_TO_ISSUE_SUBSCRIPTION_TAB() {
		userAdminPage.clickIssueSubTab();
	}
	
	@And("^Click on Entitlements tab$")
	public void GO_TO_ENTITLEMENTS_TAB() {
		userAdminPage.clickEntitlementsTab();
	}
	
	@Then("^Verify an order item is displayed and Order items are displayed one by one$")
	public void VERIFY_ORDER_ITEMS() {
		List<Map<String, String>> orderItems = userAdminPage.getItemsTable("Order Items");
		AssertResult.pass("Publication Name is not true",
				orderItems.get(0).get("Publication Name").equals(DataUtils.getPropAsString("publicationName")));
		AssertResult.pass("Publication Name is not true",
				orderItems.get(0).get("Transacted Price").equals(String.valueOf((DataUtils.getPropAsString("totalPrice")))));
		AssertResult.pass("Currency is not true", orderItems.get(0).get("Currency").equals(DataUtils.getPropAsString("curency")));
	}
	
	@Given("^Go to Zenith Admin page$")
	public void GO_TO_ADMIN_PAGE() throws Throwable {
		goToZenithAdminPage();
		LOGIN_BY_ZINIO_STAFF_ACCOUNT();
	}

	@Then("^In Issue Subscriptions tab, there is an subscription record about the order that user has just purchased$")
	public void VERIFY_SUBSCRIPTION_RECORD_IN_ISSUE_SUBSCRIPTION_TAB() {
		List<Map<String, String>> orderItems = userAdminPage.getItemsTable("Record issue");
		AssertResult.pass("Publication in Admin page should be the same on the web",
				orderItems.get(0).get("Publication").equals(DataUtils.getPropAsString("publicationName")));
	}
	
	@Then("^In Entitlements tab, there is an entitlements record about the order that user has just purchased$")
	public void VERIFY_ENTITLEMENT_RECORD_IN_ISSUE_SUBSCRIPTION_TAB() {
		List<Map<String, String>> orderItems = userAdminPage.getItemsTable("Record issue");
		AssertResult.pass("Entitlement in Admin page should be the same on the web",
				orderItems.get(0).get("Publication").equals(DataUtils.getPropAsString("publicationName")));
	}
	
	@Then("^Verify option allow showing adult content is selected$")
	public void VERIFY_ALLOW_ADULT_CONTENT_SHOW() {
		AssertResult.pass("Option allow adult content should NOT be selected", userAdminPage.isAllowAdultContent());
	}

	@Then("^Verify that update email preferences is checked$")
	public void VERIFY_UPDATED_EMAIL_CHECKED() throws InterruptedException {
		AssertResult.pass("Email preferences should be checked", userAdminPage.isEmailUpdate());
	}

	@And("^Select project is \"([^\"]*)\"$")
	public void SELECT_PROJECT(String project) throws Throwable {
		userAdminPage.selectProjectReferences(project);
		waitReady(2000);
	}

	@Then("^Verify that update email preferences is NOT checked$")
	public void VERIFY_UPDATED_EMAIL_NOT_CHECKED() throws InterruptedException {
		AssertResult.fail("Email preferences should be NOT checked", userAdminPage.isEmailUpdate());
	}
	
	@Then("^Verify that user is created in Zenith Admin successfully on Users Landing page$")
	public void CHECK_USER_CREATED_SUCCESSFULLY(DataTable emailTable) throws Throwable {
		List<List<String>> data = emailTable.raw();
		String username = data.get(1).get(0);
		AssertResult.pass("User Name is not present on Zinio page", homePage.isUserNamePresent(username));
		openNewTabWithURL();
		adminWorkFlowPage.loginZenithAdminPage();
		adminWorkFlowPage.searchEmail(username);
		List<Map<String, String>> listUserEmail = userAdminPage.getItemsTable("Email Table");
		if (listUserEmail.size() == 1 || listUserEmail.size() == 2) {
			for (int i = 0; i < listUserEmail.size(); i++) {
				String createdUser = listUserEmail.get(i).get("Email");
				AssertResult.pass("Can find created user in Zenith Admin Page", createdUser.equals(username));
			}
		} else {
			AssertResult.fail("Cannot find user name in Zenith Admin Page");
		}
	}
	
	@And("^Change email to \"([^\"]*)\"$")
	public void CHANGE_EMAIL(String newUserEmail) throws Throwable {
		userAdminPage.enterEmail(newUserEmail);
	}

	@Then("^Verify that payment information is displayed as default$")
	public void VERIFY_PAYMENT_INFORMATION_AS_DEFAULT() {
		AssertResult.pass("Defaut payment profile is NOT correct", userAdminPage.checkDefaultPaymentProfile());
	}

	@Then("^Verify that payment information is displayed after edited$")
	public void VERIFY_PAYMENT_INFORMATION_AFTER_EDITED() {
		AssertResult.pass("Edited payment profile is NOt correct", userAdminPage.checkEditedPaymentProfile());
	}

	@Then("^Verify that payment information is displayed after deleted$")
	public void VERIFY_PAYMENT_INFORMATION_AFTER_DELETED() {
		AssertResult.pass("Payment profile should be blank", userAdminPage.checkNotFoundPaymentProfile());
	}

	@And("^Click on Save$")
	public void CLICK_ON_SAVE_BTN() throws Throwable {
		userAdminPage.clickSaveBtn();
		Thread.sleep(2000);
		if (userAdminPage.checkConfirmPopup()) {
			userAdminPage.clickOnDisableUser();
		}
	}

	@And("^Click on Merge button to proceed to MERGE INTO user as email \"([^\"]*)\"$")
	public void CLICK_MERGE_BUTTON_TO_MERGE_INTO_USER(String userMerge) throws Throwable {
		userAdminPage.clickMergeToBtn();
		userAdminPage.enterEmailToSearchField(userMerge);
		Thread.sleep(1000);
		userAdminPage.checkMergerEmail();
		userAdminPage.clickMergeBtn();
		userAdminPage.clickConfirmBtn();
		Thread.sleep(3000);
	}

	@And("^Change Status to \"([^\"]*)\"$")
	public void CHANGE_STATUS_USER(String status) throws Throwable {
		Thread.sleep(3000);
		userAdminPage.changeStatus(status);
	}
	
	@And("^At Order detail, click on General Information tab to verify order info$")
	public void CLICK_GENERAL_INFORMATION_TAB_IN_ORDER_TAB() {
		adminOrdersPage.goToGeneralTab();
		waitReady(2000);
	}
	
	@And("^Open Users Landing page$")
	public void OPEN_USERS_LANDING_PAGE() {
		userAdminPage.clickOnUserTab();
	}

	@When("^Search for the user \"([^\"]*)\"$")
	public void SEARCH_USER_IN_LANDING_PAGE(String userName) throws Throwable {
		userAdminPage.enterSearchEmail(userName);
		waitReady(3000);
	}
	
	@When("^Search for the register user$")
	public void SEARCH_FOR_REGISTER_USER() throws Throwable {
		userAdminPage.enterSearchEmail(DataUtils.getPropAsString("registerUserName"));
		waitReady(3000);
	}
	
	@When("^Search for the created user$")
	public void SEARCH_FOR_CREATE_USER() throws Throwable {
		userAdminPage.enterSearchEmail(DataUtils.getPropAsString("newUser"));
		waitReady(3000);
	}
	
	@When("^Search for the facebook account$")
	public void SEARCH_FOR_FACEBOOK_ACCOUNT() throws Throwable {
		userAdminPage.enterSearchEmail(DataUtils.getPropAsString("fbEmail"));
		waitReady(3000);
	}

	@Then("^There is registered user in the table$")
	public void VERIFY_REGISTERED_USER() throws Throwable {
		List<Map<String, String>> listUserEmail = userAdminPage.getItemsTable("Email Table");
		if (listUserEmail.size() == 1 || listUserEmail.size() == 2) {
			for (int i = 0; i < listUserEmail.size(); i++) {
				String createdUser = listUserEmail.get(i).get("Email");
				AssertResult.pass("Cannot find created user in Zenith Admin Page", createdUser.equals(DataUtils.getPropAsString("registerUserName")));
			}
		} else {
			AssertResult.fail("Cannot find user name in Zenith Admin Page");
		}
	}
	
	@Then("^There is created user$")
	public void VERIFY_THAT_USER_IS_CREATED() throws Throwable {
		List<Map<String, String>> listUserEmail = userAdminPage.getItemsTable("Email Table");
		if (listUserEmail.size() == 1 || listUserEmail.size() == 2) {
			for (int i = 0; i < listUserEmail.size(); i++) {
				String createdUser = listUserEmail.get(i).get("Email");
				AssertResult.pass("Cannot find created user in Zenith Admin Page", createdUser.equals(DataUtils.getPropAsString("username")));
			}
		} else {
			AssertResult.fail("Cannot find user name in Zenith Admin Page");
		}
	}
	
	@When("^Verify 'Registered on' field should be populated with correct flatform code$")
	public void VERIFY_PLATFORM_CODE_ANDROID() {
		AssertResult.pass("Flatform code for Android should be 9903", userAdminPage.getUserInformation().get("FlatformCode").equals("9903"));
	}
	
	@When("^Verify 'Registered on' field should be populated with correct country$")
	public void VERIFY_REGISTERED_COUNTRY() {
		AssertResult.pass("Country should be USA", userAdminPage.getUserInformation().get("Registered On").equals("Zinio " + DataUtils.getPropAsString("country")));
	}
	
	@When("^Verify 'Registered on' field should be populated with facebook account$")
	public void VERIFY_REGISTERED_ON_FACEBOOK() {
		AssertResult.pass("Flatform code for Android should be 9901", userAdminPage.getUserInformation().get("FlatformCode").equals("9901"));
	}
	
	@And("^Go to Orders page$")
	public void GO_TO_ORDER_PAGE() {
		adminOrdersPage.goToOrdersMenu();
		waitReady(1000);
	}
	
	@And("^Open Orders page and search for the order that user has just purchased$")
	public void SEARCH_ORDER_ID() {
		adminOrdersPage.enterOrderId(DataUtils.getPropAsString("orderId"));
		AssertResult.fail("Should be displayed item detail", adminOrdersPage.isFoundOrder());
	}

	@And("^At Order detail, click on Payment tab to verify payment info$")
	public void CLICK_PAYMENT_TAB() {
		adminOrdersPage.goToPaymentTab();
		waitReady(5000);
	}
	
	@Then("^Verify Payment info is displayed correctly as credit card info$")
	public void VERIFY_PAYMENT_INFO() {
		Map<String, String> paymentInfo = adminOrdersPage.getPaymentDisplay();
		AssertResult.pass("Payment method should be credit_card", paymentInfo.get("Method").equals("credit_card"));
		
		AssertResult.pass("Credit Cart type should be 'credit card'", paymentInfo.get("Type").equals("credit card"));
		
		AssertResult.pass("Provider should be 'Visa'", paymentInfo.get("Provider").equals(UserData.CARD_PROVIDER));
		
		AssertResult.pass("Card Number should be hidden", paymentInfo.get("Card Number").equals("**** **** **** 1111"));
		
		AssertResult.pass("Expiration is not correct", paymentInfo.get("Expiration").equals(UserData.EXPIRE_DATE_SORT));
		
		AssertResult.pass("Card Holder Name is not correct",
				paymentInfo.get("Card Holder Name").equals(UserData.FIRST_NAME + " " + UserData.LAST_NAME));
		
		AssertResult.pass("Postal Code is not correct", paymentInfo.get("Postal Code").equals(UserData.ZIPCODE));
		
		AssertResult.pass("Country is not correct", paymentInfo.get("Country").equals(UserData.COUNTRY));
		
		AssertResult.pass("Currency should be correct", paymentInfo.get("Currency Code").equals(DataUtils.getPropAsString("currency")));
		
		AssertResult.pass("Total price should be the same on the web",
				paymentInfo.get("Amount").equals(String.valueOf(DataUtils.getPropAsString("totalPrice"))));
	}
	
	@And("^At Order detail, click on Order Items tab to verify order detai$")
	public void CLICK_ON_ORDERS_ITEMS_TAB() {
		adminOrdersPage.goToOrderItemsTab();
		waitReady(2000);
	}
	
	@Then("^Verify that Order info is displayed correctly$")
	public void VERIFY_ORDER_INFO() {
		Map<String, String> orderInfo = adminOrdersPage.getOrdersDisplay();
		if (DataUtils.getPropAsString("currency").equals("SGD")) {
			DataUtils.setProperty("currency", "SGD (Singapore Dollar)");
		}
		AssertResult.pass("Currentcy should be displayed correctly", orderInfo.get("Currency").equals(DataUtils.getPropAsString("currency")));
		AssertResult.pass("Subtotal should be equal with the deal info",
				orderInfo.get("Subtotal").equals(String.valueOf(DataUtils.getPropAsString("subTotal"))));
		AssertResult.pass("Tax should be equal with the deal info", orderInfo.get("Tax").equals(DataUtils.getPropAsString("Tax")));
		AssertResult.pass("Total should be equal with the deal info",
				orderInfo.get("Total").equals(String.valueOf(DataUtils.getPropAsString("totalPrice"))));
	}
	
	@Then("^Verify Payment Profile info as credit card info$")
	public void VERIFY_PAYMENT_PROFILE() {
		
		Map<String, String> paymentProfile = userAdminPage.getPaymentProfile();
		
		System.out.println("here is data:" + paymentProfile);
		
		AssertResult.pass("Payment method should be credit_card", paymentProfile.get("Card provider").equals(UserData.CARD_PROVIDER));
		
		AssertResult.pass("Card Number should be hidden", paymentProfile.get("Card number").equals("xxxx-xxxx-xxxx-1111"));
		
		AssertResult.pass("Expiration is not correct", paymentProfile.get("Expire date").equals(UserData.EXPIRE_DATE));
		
		AssertResult.pass("First name is not correct", paymentProfile.get("First name").equals(UserData.FIRST_NAME ));
		
		AssertResult.pass("Last name is not correct", paymentProfile.get("Last name").equals(UserData.LAST_NAME));
		
		AssertResult.pass("Zip Code is not correct", paymentProfile.get("Zip / Postal code").equals(UserData.ZIPCODE));
		
		AssertResult.pass("Country is not correct", paymentProfile.get("Country").equals(UserData.COUNTRY));
		
		AssertResult.pass("Address should be correct", paymentProfile.get("Address").equals(UserData.ADDRESS));
		
		AssertResult.pass("City should be correct", paymentProfile.get("City").equals(UserData.CITY));
	}
}

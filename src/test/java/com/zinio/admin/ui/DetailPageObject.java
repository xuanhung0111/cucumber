package com.zinio.admin.ui;

import org.openqa.selenium.WebDriver;

import com.zinio.web.element.BasePage;
import com.zinio.web.element.CheckBox;
import com.zinio.web.element.SelectBox;
import com.zinio.web.element.TextBox;

public class DetailPageObject extends BasePage {

	public DetailPageObject(WebDriver driver) {
		super(driver);
	}

	public BasePage generalInfoTab = new BasePage(getDriver(), "General Information tab",
			"//a[.='General Information' and @role='tab']");

	public BasePage listsTab = new BasePage(getDriver(), "Lists tab", "//a[.='Lists' and @role='tab']");

	public SelectBox listSelectBox = new SelectBox(getDriver(), "List select box",
			"//div[contains(@class, 'btn-group-select')]");

	public SelectBox addArticle = new SelectBox(getDriver(), "Add Article",
			"//div[contains(@class, 'btn-create-wrap')]");

	public BasePage addPublications = new BasePage(getDriver(), "Add Publications",
			"//div[contains(@class, 'btn-create-wrap') " + "and contains(., 'Add Publications')]");

	public BasePage checkAllBox = new BasePage(getDriver(), "Check all boxes",
			"//span[contains(@class, 'zmdi zmdi-plus-square')]");

	public BasePage addtoList = new BasePage(getDriver(), "Add to list",
			"//button[contains(@class, 'btn btn-success')]");

	public BasePage publicationsTab = new BasePage(getDriver(), "Publications tab",
			"//a[.='Publications' and @role='tab']");

	public BasePage projectsTab = new BasePage(getDriver(), "Projects tab", "//a[.='Projects' and @role='tab']");

	public BasePage childAccountsTab = new BasePage(getDriver(), "Child Accounts tab",
			"//a[.='Child Accounts' and @role='tab']");

	public BasePage applicationsTab = new BasePage(getDriver(), "Applications tab",
			"//a[.='Applications' and @role='tab']");

	public BasePage newsstandsTab = new BasePage(getDriver(), "Newsstands tab", "//a[.='Newsstands' and @role='tab']");

	public BasePage categoriesTab = new BasePage(getDriver(), "Categories tab", "//a[.='Categories' and @role='tab']");

	public BasePage subCategoriesTab = new BasePage(getDriver(), "Sub Categories tab",
			"//a[.='Sub Categories' and @role='tab']");

	public BasePage countriesTab = new BasePage(getDriver(), "Countries tab", "//a[.='Countries' and @role='tab']");

	public BasePage pricesTab = new BasePage(getDriver(), "Prices tab", "//a[.='Prices' and @role='tab']");

	public BasePage issuePricesTab = new BasePage(getDriver(), "Issue prices tab",
			"//a[@id='publication-tab___tab___issues']");

	public BasePage priceTiersTab = new BasePage(getDriver(), "Prices tab", "//a[.='Price Tiers' and @role='tab']");

	public BasePage catalogTab = new BasePage(getDriver(), "Catalog tab",
			"//a[@id='publication-tab___tab___catalogs']");

	public BasePage productTab = new BasePage(getDriver(), "Product tab",
			"//a[@id='publication-tab___tab___products']");

	public BasePage paymentProfileTab = new BasePage(getDriver(), "Payment tab",
			"//a[@id='userId-tab___tab___user-payment']");

	public BasePage bannersTabInCampaign = new BasePage(getDriver(), "Banners tab",
			"//a[@id='order-tab___tab___banners']");

	public BasePage bannersTabInNewsstand = new BasePage(getDriver(), "Banners tab",
			"//a[@id='application-tab___tab___banners']");

	public BasePage orderTab = new BasePage(getDriver(), "Order tab", "//a[@id='user-tab___tab___orders']");

	public BasePage orderItemsTab = new BasePage(getDriver(), "Order Items tab",
			"//a[@id='order-tab___tab___order-items']");

	public BasePage publicationNameSubscription = new BasePage(getDriver(), "Publication Name of Subscription",
			"//label[contains(.,'Publication')]/following-sibling::input");

	public BasePage targetsTab = new BasePage(getDriver(), "Targets tab", "//a[@id='order-tab___tab___targets']");

	public BasePage paymentOrderTab = new BasePage(getDriver(), "Payment order tab",
			"//a[@id='order-tab___tab___payment']");

	public BasePage couponTab = new BasePage(getDriver(), "Coupon tab", "//a[@id='order-tab___tab___coupons']");

	public BasePage iTCTab = new BasePage(getDriver(), "ITC tab", "//a[@id='publication-tab___tab___itc']");

	public BasePage metadataTabPublication = new BasePage(getDriver(), "Metadata tab",
			"//a[@id='publication-tab___tab___metadata']");
	public BasePage metadataTabIssue = new BasePage(getDriver(), "Metadata tab",
			"//a[@id='issue-tab___tab___metadata']");

	public BasePage activityTab = new BasePage(getDriver(), "Activity tab",
			"//a[@id='user-tab___tab___activity_logs']");
	// Details Page of Publisher
	// =======================================================================================

	public TextBox publisherNameTextBox = new TextBox(getDriver(), "Publisher Name textbox",
			"//input[@id='publisher-name']");

	public TextBox publisherInternalNameTextBox = new TextBox(getDriver(), "Publisher Internal Name textbox",
			"//input[@id='publisher-internal-name']");

	public BasePage sideInfoPanel = new BasePage(getDriver(), "Side Info panel", "//div[@class='side-info']");

	// Panel Publication
	// ===============================================================================================
	public BasePage catalogPanel = new BasePage(getDriver(), "Catalog Panel",
			"//div[@id='publication-tab___pane___catalogs']");

	// Details Page of Publication
	// =====================================================================================

	public TextBox noOfIssuesTextBox = new TextBox(getDriver(), "No Of Issues textbox",
			"//span[@id='issue-quantity']//preceding-sibling::input");

	public BasePage addIssueSubscriptionButton = new BasePage(getDriver(), "Add button", "//button[.='Add']");

	public BasePage cancelIssueSubscriptionButton = new BasePage(getDriver(), "Cancel button",
			"//button[.='Add']//following-sibling::button");

	public BasePage addProductButton = new BasePage(getDriver(), "Add product button",
			"//div[@class='btn btn-primary dropdown-toggle']");

	public BasePage paymentFirstName = new BasePage(getDriver(), "Payment firstName",
			"//div[.='First name']/following-sibling::div");

	public BasePage paymentLastName = new BasePage(getDriver(), "Payment lastName",
			"//div[.='Last name']/following-sibling::div");

	public BasePage paymentZipCode = new BasePage(getDriver(), "Payment zipCode",
			"//div[.='Zip / Postal code']/following-sibling::div");

	public BasePage paymentCountry = new BasePage(getDriver(), "Payment country",
			"//div[.='Country']/following-sibling::div");

	public BasePage paymentHandler = new BasePage(getDriver(), "Payment handler",
			"//div[.='Payment handler']/following-sibling::div");

	public BasePage paymentCardProvider = new BasePage(getDriver(), "Payment card provider",
			"//div[.='Card provider']/following-sibling::div");

	public BasePage paymentCardNumber = new BasePage(getDriver(), "Card number",
			"//div[.='Card number']/following-sibling::div");

	public BasePage paymentExpirationDate = new BasePage(getDriver(), "Expire date",
			"//div[.='Expire date']/following-sibling::div");

	public BasePage paymentBillingAddress = new BasePage(getDriver(), "Payment billing address",
			"//div[.='Address']/following-sibling::div");

	public BasePage paymentBillingCity = new BasePage(getDriver(), "Payment billing city",
			"//div[.='City']/following-sibling::div");

	public SelectBox presetCombobox = new SelectBox(getDriver(), "Preset combobox",
			"//button[contains(.,'Preset')]//parent::div");

	// Detail Page of User
	// =============================================================================================
	public BasePage catalogSubscriptionsTab = new BasePage(getDriver(), "Catalog Subscription Tabs",
			"//a[@id='userId-tab___tab___catalog_subscriptions']");

	public BasePage freeSubscriptionButton = new BasePage(getDriver(), "Free Subscription",
			"//a[contains(., 'Free Subscription')]");

	public BasePage issueSubscriptionTab = new BasePage(getDriver(), "Issue Subscription Tab",
			"//a[@id='user-tab___tab___issue_subscriptions']");

	public BasePage entitlementTab = new BasePage(getDriver(), "Entitlement Tab",
			"//a[@id='user-tab___tab___entitlements']");

	public BasePage freeEntitlementButton = new BasePage(getDriver(), "Free Entitlement",
			"//a[contains(@class, 'btn-create-wrap') and contains(., 'Free Entitlement')]");

	public BasePage preferencesTab = new BasePage(getDriver(), "Preferences",
			"//a[@id='user-tab___tab___preferences']");

	public BasePage assignTab = new BasePage(getDriver(), "Assign tab", "//a[.='Assign']");

	public BasePage disableUserBtn = new BasePage(getDriver(), "Disbale userId btn", "//button[.='Disable userId']");

	public BasePage resetPassword = new BasePage(getDriver(), "Reset Password Button",
			"//div[contains(@class,'reset-combo')]//button[.='Reset Password']");

	public SelectBox chooseProjectTextBox = new SelectBox(getDriver(), "Choose Project Textbox",
			"//div[@class='reset-combo']//div/child::button/..");

	public BasePage typeInformation = new BasePage(getDriver(), "Type",
			"//*[@class='col-sm-6 col-xs-12'and text()=' Login Type']");

	public BasePage selectedTable = new BasePage(getDriver(), "Selected Publication",
			"//div[text()='SELECTED PUBLICATIONS (0)']");

	public BasePage checkStatus = new BasePage(getDriver(), "Check Enable Status", "//tr[@class='inactive']");

	public BasePage mergeToButton = new BasePage(getDriver(), "Merge to button", "//a[.='Merge to']");

	public BasePage goToSubcriptionsButton = new BasePage(getDriver(), "Go to Subscriptions button",
			"//button[.='Go to Subscriptions']");

	public BasePage divLoading = new BasePage(getDriver(), "Loading div", "//div[@class='loading']");

	public CheckBox updateEmailCheckbox = new CheckBox(getDriver(), "Update Email checkbox",
			"//label[@for='email-update' and contains(@class,'ic-checkbox')]");
	public BasePage adultRadioButton = new BasePage(getDriver(), "Adult Radio Button", "//label[@for='adult-true']");

	public BasePage notAdultRadioButton = new BasePage(getDriver(), "Not Adult Radio Button",
			"//label[@for='adult-false']");
	public BasePage renewSubscriptionButton = new BasePage(getDriver(), "Renew Subscription button",
			"//div[.='Auto-renew']//following::label");

	// Banner tabs
	public BasePage assignBannerButton = new BasePage(getDriver(), "Assign banner",
			"//a[contains(.,'Manage Banners')]");

	public BasePage iconRemoveText3x1 = new BasePage(getDriver(), "Icon Remove Text 3x1",
			"//input[@id='image3x1']/following::div[1]");
	public BasePage iconRemoveText2x1 = new BasePage(getDriver(), "Icon Remove Text 2x1",
			"//input[@id='image2x1']/following::div[1]");
	public BasePage iconRemoveText4x1 = new BasePage(getDriver(), "Icon Remove Text 4x1",
			"//input[@id='image4x1']/following::div[1]");

	public CheckBox radioButton = new CheckBox(getDriver(), "Radio button");
	public SelectBox projectComboBox = new SelectBox(getDriver(), "Project combobox",
			"//div[.='Project']//following-sibling::div");
	public BasePage assignButton = new BasePage(getDriver(), "Assign button", "//button[.='Assign']");
	public CheckBox bannerListCheckBox = new CheckBox(getDriver(), " Banner List checkbox", "Banners List");

	// Order page
	public BasePage cancelSubscriptionOrder = new BasePage(getDriver(), "Cancel Subscription button",
			"//button[.='Cancel Subscription']");

	public BasePage divRefundOrderButton = new BasePage(getDriver(), "Refund Button",
			"//div[contains(@class,'btn-primary')]");

	public BasePage refundOrderButton = new BasePage(getDriver(), "Refund Button", "//button[.='Refund']");

	public SelectBox reasonRefundComboBox = new SelectBox(getDriver(), "Reason refund ComboBox",
			"//label[contains(.,'Reason')]//following-sibling::div[1]");

	public BasePage uploadArea = new BasePage(getDriver(), "Upload Area", "//div[@class='upload-area']");

	public BasePage chooseAnotherCSV = new BasePage(getDriver(), "Choose another CSV", "//a[.='Choose another CSV']");

	public BasePage issueToRefundCombobox = new BasePage(getDriver(), "Issue To Refund combobox", "//select");

	// Campaign page
	public BasePage draftButton = new BasePage(getDriver(), "Draft button", "//button[.='Draft']");
	public BasePage scheduleButton = new BasePage(getDriver(), "Draft button", "//button[.='Schedule']");
	public BasePage retractButton = new BasePage(getDriver(), "Draft button", "//button[.='Retract']");
	public BasePage archiveButton = new BasePage(getDriver(), "Draft button", "//button[.='Archive']");
	public BasePage cloneButton = new BasePage(getDriver(), "Clone button", "//a[.='Clone']");
	public BasePage copyButton = new BasePage(getDriver(), "Copy button", "//button[.='Copy']");
	public SelectBox campaignCombobox = new SelectBox(getDriver(), "Campaign Combobox",
			"//li[.='Choose Campaign']/ancestor::div[1]");

	// Issue
	public TextBox issueNameTextbox = new TextBox(getDriver(), "Issue Display Name textbox", "//input[@id='name']");
	public TextBox legacyIdTextbox = new TextBox(getDriver(), "Legacy Id Textbox", "//input[@id='legacy_identifier']");
	public TextBox coverDateTextbox = new TextBox(getDriver(), "Cover date Textbox",
			"//label[.='Cover Date']/following-sibling::input");
	public TextBox publishDateTextbox = new TextBox(getDriver(), "Cover date Textbox",
			"//label[.='Publish Date']/following-sibling::input");

}

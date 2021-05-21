package com.zinio.admin.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.zinio.web.element.BasePage;
import com.zinio.web.element.CheckBox;
import com.zinio.web.element.SelectBox;
import com.zinio.web.element.Table;
import com.zinio.web.element.TextBox;
import com.zinio.web.utilities.Logging;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;

public class LandingPageObject extends BasePage {

	public LandingPageObject(WebDriver driver) {
		super(driver);
	}

	public BasePage userTab = new BasePage(getDriver(), "Users Tab",
			"//*[@class='menu-item menu-icons']//span[contains(text(), 'Users')]");
	
	public TextBox txtContaintSearch = new TextBox(getDriver(), "Users Tab",
			"//*[@class='filter-wrapper']//form/div/input[@name='containt-text']");
	
	
	public BasePage status = new BasePage(getDriver(), "Status",
			"//*[@name='Status']");
	
	
	public BasePage mergeToBtn = new BasePage(getDriver(), "Merge To Button",
			"//*[@id='user-tab___pane___general']//*[contains(text(), 'Merge to')]");
	
	public BasePage mergeBtn = new BasePage(getDriver(), "Merge Button", 
			"//*[@class='btn btn-success'][contains(text(), 'Merge')]");
	
	public BasePage emailChecked = new BasePage(getDriver(), "Email checked", 
			"//*[@class='form-group']//label");
	
	
	public BasePage confirmBtn = new BasePage(getDriver(), "Confirm Button", 
			"//button[@class='btn btn-primary'][contains(text(), 'Confirm')]");
	
	public TextBox txtEmail = new TextBox(getDriver(), "Text field Email", 
			"//*[@id='email']");
	
	public BasePage saveBtn = new BasePage(getDriver(), "Save Button", 
			"//*[@class='btn btn-success'][contains(text(), 'Save')]");
	
	public BasePage confirmDisabled = new BasePage(getDriver(), "Confirm Disable Button",
			"//*[contains(text(), 'Confirmation')][@class='modal-title']");
			
	
	public BasePage disableUserBtn = new BasePage(getDriver(), "Disable User Button",
			"//button[@class='btn btn-primary'][contains(text(), 'Disable user')]");
	
	
	public CheckBox allowAdultContent = new CheckBox(getDriver(), "Allow Adult Content",
			"//*[@for='adult-true']/span");
	
	public CheckBox rejectAdultContent = new CheckBox(getDriver(), "Reject adult content",
			"//*[@for='adult-false']/span");
	
	
	 public  BasePage adultRadioButton = new BasePage(getDriver(), "Adult Radio Button","//label[@for='adult-true']");

	 public  BasePage notAdultRadioButton= new BasePage(getDriver(), "Not Adult Radio Button","//label[@for='adult-false']");


	 public  BasePage updateEmailCheckbox= new BasePage(getDriver(), "Update Email checkbox", "//label[@for='email-update' and contains(@class,'ic-checkbox')]");
	 
	public List<Map<String, String>> getItemsTable(String tableName)
	{
		Logging.info("Get Table Information");
		return getItemsTable("//table[contains(@class, 'table table-striped table-responsive')]", tableName);
	}
	
	public List<Map<String, WebElement>> getItemsTable(String tableName, boolean isHref)
	{
		Logging.info("Get Table Information");
		return getItemsTable("//table[contains(@class, 'table table-striped table-responsive')]", tableName, isHref);
	}
	
	public TextBox txtSearchEmail = new TextBox(getDriver(), "Text Search Email", 
			"//*[@name='containt-text']");
	
	public BasePage ordersTab = new BasePage(getDriver(), "Orders Tab", 
			"//*[@id='user-tab___tab___orders']");
	
	public BasePage issueSubTab = new BasePage(getDriver(), "Issue SubCription Tab", 
			"//*[@id='user-tab___tab___issue_subscriptions']");
	
	public BasePage entitlementTab = new BasePage(getDriver(), "Entitlements Tab", 
			"//*[@id='user-tab___tab___entitlements']");
	
	public BasePage generalInfoTab = new BasePage(getDriver(), "General Information Tab", 
			"//*[@id='user-tab___tab___general']");
	
	public BasePage preferencesTab = new BasePage(getDriver(), "General Information Tab", 
			"//*[@id='user-tab___tab___preferences']");
	
	public BasePage projectPreferencesTab = new BasePage(getDriver(), "User Tab Pane Preferences", 
			"//*[@id='user-tab___pane___preferences']//button[@type='button']");
	
	public BasePage userOrdersTab = new BasePage(getDriver(), "Orders Tab Pane", 
			"//*[@id='user-tab___tab___orders']");
	
	public BasePage paymentProfileTab = new BasePage(getDriver(), "Payment Profile Tab", 
			"//*[@id='user-tab___tab___user-payment']");
	
	public SelectBox createAccountButton = new SelectBox(getDriver(), "Create Account button",
			"//div[contains(@class,'btn-create') and contains(.,'Create account')]");

	public BasePage createProjectButton = new BasePage(getDriver(), "Create Project button",
			"//a[.=' Create project']");

	public BasePage nextButton = new BasePage(getDriver(), "Next Button",
			"//button[.='Next' and contains(@class,'btn-success')]");

	public BasePage createApplicationButton = new BasePage(getDriver(), "Create Application button",
			"//a[contains(@href,'/applications/create')]");

	public BasePage allPublicationCb = new BasePage(getDriver(), "Select all publication",
			"//input[@id='cbHeader']//following-sibling::label");

	public BasePage removeButton = new BasePage(getDriver(), "Remove button",
			"//div[contains(@class, 'btn-create-wrap')]//a[contains(., 'Remove')]");

	public BasePage commonModal = new BasePage(getDriver(), "Modal container",
			"//div[@role='dialog' and contains(@class, 'fade in')]");

	public BasePage yesNotifiButton = new BasePage(getDriver(), "Button yes in notification",
			"//div[@class='modal-footer']//button[.='Yes']");

	public BasePage createCatalogButton = new BasePage(getDriver(), "Create Catalog button",
			"//a[contains(@href,'/catalogs/create')]");

	public BasePage createPublicationButton = new BasePage(getDriver(), "Create Publication button",
			"//a[contains(@href,'/publications/create')]");

	public BasePage createCategorySetButton = new BasePage(getDriver(), "Create Category Set button",
			"//a[contains(@href,'/categorysets/create')]");

	public BasePage createCategoryButton = new BasePage(getDriver(), "Create Category button",
			"//a[contains(@href,'/create')]");

	public BasePage createNewsstandButton = new BasePage(getDriver(), "Create Newsstand button",
			"//a[contains(@href,'/newsstands/create')]");

	public BasePage createStaffUserButton = new BasePage(getDriver(), "Create Staff User button",
			"//a[contains(@href,'/users/create-staff')]");

	public BasePage createCampaignButton = new BasePage(getDriver(), "Create Campaign button",
			"//a[contains(@href,'/campaigns/create')]");

	public BasePage createCouponButton = new BasePage(getDriver(), "Create Coupon button",
			"//a[contains(.,'Create coupon')]");
	public BasePage assignButton = new BasePage(getDriver(), "Assign button", "//a[contains(@href,'/assign')]");

	public BasePage unssignButton = new BasePage(getDriver(), "Unassign button",
			"//a[@title='Unassign' and @class='btn btn-danger btn-icon']");

	public BasePage updateButton = new BasePage(getDriver(), "Update button",
			"//div[starts-with(@class,'btn') and .='Update']");

	public BasePage resetButton = new BasePage(getDriver(), "Reset button", "//*[.='Reset']");

	public BasePage unassignButton = new BasePage(getDriver(), "Reset button", "//button[contains(.,'Unassign')]");

	public BasePage selectAllCheckbox = new BasePage(getDriver(), "Select All Checkbox",
			"//input[@id='cbHeader']//following-sibling::label");

	public BasePage yesButton = new BasePage(getDriver(), "Yes button", "//button[.='Yes']");

	public BasePage noButton = new BasePage(getDriver(), "No button", "//button[.='No']");

	public BasePage confirmButton = new BasePage(getDriver(), "Confirm button",
			"//button[starts-with(@class,'btn') and .='Confirm']");

	public BasePage unclassifiedAccountTypeLink = new BasePage(getDriver(), "Publisher account link",
			"//a[.='Unclassified']");
	public BasePage partnerAccountTypeLink = new BasePage(getDriver(), "Publisher account link", "//a[.='Partner']");
	public BasePage publisherAccountTypeLink = new BasePage(getDriver(), "Publisher account link",
			"//a[.='Publisher']");
	public BasePage libraryAccountTypeLink = new BasePage(getDriver(), "Publisher account link", "//a[.='Library']");
	public BasePage resellerAccountTypeLink = new BasePage(getDriver(), "Publisher account link", "//a[.='Reseller']");
	public BasePage franchiseeAccountTypeLink = new BasePage(getDriver(), "Publisher account link",
			"//a[.='Franchisee']");
	public BasePage createBannerButton = new BasePage(getDriver(), "Create Banner button",
			"//a[@href='/banners/create']");

	// Filter controls
	// =================================================================================================

	public TextBox searchContentTextBox = new TextBox(getDriver(), "Search Content textbox",
			"//div[@class='filter-wrapper']//form//input[not(@id)]");

	public SelectBox searchOptionComboBox = new SelectBox(getDriver(), "Search Option combobox",
			"//div[contains(@class,'form-search')]//div[contains(@class,'btn-group btn-group-select')]");

	public SelectBox countryComboBox = new SelectBox(getDriver(), "Country combobox",
			"//li[.='Country: All']/ancestor::div[1]");

	public SelectBox publisherComboBox = new SelectBox(getDriver(), "Publisher ID combobox",
			"//div[@name='Publisher ID: All']");

	public SelectBox typeComboBox = new SelectBox(getDriver(), "Type combobox", "//li[.='Type: All']/ancestor::div[1]");

	public SelectBox statusComboBox = new SelectBox(getDriver(), "Status combobox",
			"//li[.='Status: All']/ancestor::div[1]");

	public SelectBox publicationStatusComboBox = new SelectBox(getDriver(), "Publication Status combobox",
			"//li[.='Publication Status: All']/ancestor::div[1]");

	public SelectBox catalogStatusComboBox = new SelectBox(getDriver(), "Catalog Publication Status combobox",
			"//li[.='Catalog Status: All']/ancestor::div[1]");

	public SelectBox tierComboBox = new SelectBox(getDriver(), "Tier combobox", "//li[.='Tier: All']/ancestor::div[1]");

	public SelectBox platformComboBox = new SelectBox(getDriver(), "Platform combobox",
			"//li[.='Platform: All']/ancestor::div[1]");

	public BasePage moreButton = new BasePage(getDriver(), "More Button", "//div[contains(@class,'btn-more')]/div");

	public BasePage contentRatingCheckbox = new BasePage(getDriver(), "Content Rating checkbox",
			"//div[contains(@class,'btn-more')]//label[.='Content Rating']");

	public BasePage typeCheckbox = new BasePage(getDriver(), "Type checkbox",
			"//div[contains(@class,'btn-more')]//label[.='Type']");

	public BasePage statusCheckbox = new BasePage(getDriver(), "Type checkbox",
			"//div[contains(@class,'btn-more')]//label[.='Status']");

	public SelectBox contentRatingComboBox = new SelectBox(getDriver(), "Content Rating combobox",
			"//li[.='Content Rating: All']/ancestor::div[1]");

	public SelectBox issueIDComboBox = new SelectBox(getDriver(), "Issue ID combobox",
			"//span[contains(.,'Issue ID: All')]/ancestor::div[1]");

	public SelectBox publicationIDComboBox = new SelectBox(getDriver(), "Publication ID combobox",
			"//span[contains(.,'Publication ID: All')]/ancestor::div[1]");

	public SelectBox agentType = new SelectBox(getDriver(), "Agent Type: All",
			"//li[.='Agent Type: All']/ancestor::div[1]");

	public SelectBox sourceType = new SelectBox(getDriver(), "Source Type: All",
			"//li[.='Source Type: All']/ancestor::div[1]");

	public SelectBox handler = new SelectBox(getDriver(), "Handler: All", "//li[.='Handler: All']/ancestor::div[1]");

	public SelectBox accountCodeCombobox = new SelectBox(getDriver(), "Account code: ",
			"//li[.='Account Code: All']/ancestor::div[1]");

	public TextBox orderSearch = new TextBox(getDriver(), "Order code: ",
			"//label[.='Order ID']/following::input[@type='text']");

	public TextBox issueSearchTextbox = new TextBox(getDriver(), "Issue search textbox",
			"//label[.='Issue ID']/following::input[@type='text']");

	public BasePage btnGoOrder = new BasePage(getDriver(), "Go button", "//button[.='Go']");

	public SelectBox initiativeCombobox = new SelectBox(getDriver(), "Initiative Combobox",
			"//li[.='Initiative: All']/ancestor::div[1]");

	public SelectBox customerSourceCombobox = new SelectBox(getDriver(), "Customer source Combobox",
			"//li[.='Customer Source: All']/ancestor::div[1]");

	public SelectBox visibilityCombobox = new SelectBox(getDriver(), "Visibility Combobox",
			"//li[.='Visibility: All']/ancestor::div[1]");

	public SelectBox goalCombobox = new SelectBox(getDriver(), "Goal Combobox", "//li[.='Goal: All']/ancestor::div[1]");

	public SelectBox objectTypeCombobox = new SelectBox(getDriver(), "Object Type",
			"//li[.='Object Type: All']/ancestor::div[1]");

	public SelectBox classifierCombobox = new SelectBox(getDriver(), "Classifier Combobox",
			"//li[.='Classifier: All']/ancestor::div[1]");

	// Table & Paging controls
	// =========================================================================================

	public BasePage pageTitle = new BasePage(getDriver(), "Page title", "//div[@class='title-name']//h1");

	public Table landingTable = new Table(getDriver(), "Landing table", "//table[contains(@class,'table-responsive')]");

	public BasePage tableCampaignTarget = new Table(getDriver(), "Campaign Target",
			"//div[@class='ReactVirtualized__Grid " + "ReactVirtualized__Table__Grid']//div");
	public BasePage firstPageButton = new BasePage(getDriver(), "First Page button",
			"//li[@class='pages']/*[.='First']");

	public BasePage previousPageButton = new BasePage(getDriver(), "Previous Page button",
			"//li[@class='pages']/*[.='Previous']");

	public BasePage page1Button = new BasePage(getDriver(), "Page 1 button",
			"//li[starts-with(@class,'page')]/*[.='1']");

	public BasePage page2Button = new BasePage(getDriver(), "Page 2 button",
			"//li[starts-with(@class,'page')]/*[.='2']");

	public BasePage nextPageButton = new BasePage(getDriver(), "Next Page button", "//li[@class='pages']/*[.='Next']");

	public BasePage lastPageButton = new BasePage(getDriver(), "Last Page button", "//li[@class='pages']/*[.='Last']");

	public SelectBox showHideColumnIcon = new SelectBox(getDriver(), "Show/Hide Column icon",
			"//div[starts-with(@class,'extra-columns scrolling')]");

	public BasePage doneButton = new BasePage(getDriver(), "Done button",
			"//div[contains(@class,'extra-columns')]//button[.='Done']");

	public BasePage cancelButton = new BasePage(getDriver(), "Cancel button", "//button[.='Cancel']");

	public SelectBox itemsPerPageButton = new SelectBox(getDriver(), "Items Per Page button",
			"//div[contains(@class,'btn-post-per-page')]");

	public SelectBox exportButton = new SelectBox(getDriver(), "Export button",
			"//div[contains(.,'Export') and contains(@class,'dropdown-toggle')]");

	public BasePage exportLink = new BasePage(getDriver(), "Export link", "//button[.='Export to CSV']");

	public BasePage paginationBar = new BasePage(getDriver(), "Pagination Bar", "//ul[@class='paging']");

	public BasePage sortNameButton = new BasePage(getDriver(), "Sort Name Buton",
			"//div[contains(@class, \"content table-wrapper\")]"
					+ "//div[starts-with(.,\"Name\")]//i[contains(@class, \"ic-acs\")]");

	public BasePage sortIDButton = new BasePage(getDriver(), "Sort ID Button",
			"//div[contains(@class, \"content table-wrapper\")]//div[starts-with(.,\"ID\")]//i[contains(@class, \"ic-acs\")]");

	public BasePage sideInfoPanel = new BasePage(getDriver(), "Side Info panel", "//div[@class='side-info']");

	public BasePage modalDialog = new BasePage(getDriver(), "Modal dialog", "//div[@class='modal-content']");

	public BasePage notFoundIcon = new BasePage(getDriver(), "Not Found icon", "//img[@alt='Not found']");

	public BasePage notFoundIconOrder = new BasePage(getDriver(), "Not Found icon",
			"//i[contains(@class,'zmdi-broken-image')]");

	public BasePage noNotifiButton = new BasePage(getDriver(), "No button in Confirm Notification!",
			"//div[@class='modal-footer']//button[.='No']");

	public BasePage backButton = new BasePage(getDriver(), "Back button",
			"//div[.='Back' and @class='btn btn-default']");

	public BasePage newBackButton = new BasePage(getDriver(), "New Back Button", "//button[@class='btn btn-default']");

	public BasePage mergeButton = new BasePage(getDriver(), "Merge Button", "//button[.='Merge']");

	public BasePage confirmButtonInNotification = new BasePage(getDriver(), "Confirm button", "//button[.='Confirm']");

	public BasePage cancelButtonInNotification = new BasePage(getDriver(), "Cancel button",
			"//div[@class='modal-content']//button[.='Cancel']");

	public BasePage bulkActionsButton = new BasePage(getDriver(), "Bulk Actions button", "//a[.='Bulk Actions']");

	public BasePage closeButton = new BasePage(getDriver(), "Close button", "//button[.='Close']");

	public BasePage stopButton = new BasePage(getDriver(), "Close button", "//button[.='Stop']");

	public BasePage startButton = new BasePage(getDriver(), "Start button", "//button[.='Start']");

	public BasePage continueButton = new BasePage(getDriver(), "Continue button", "//button[.='Continue']");

	public BasePage processingButton = new BasePage(getDriver(), "Processing button", "//button[.='Processing']");

	public BasePage exportButtonInBulkAction = new SelectBox(getDriver(), "Export Button",
			"//button[contains(.,'Export')]");

	public BasePage bulkAddButton = new BasePage(getDriver(), "Bulk Add button", "//a[.='Bulk Add']");

	public BasePage startNewButton = new BasePage(getDriver(), "Start New button", "//button[.='Start New']");

	public BasePage managePublicationButton = new BasePage(getDriver(), "Manage Publication button",
			"//button[contains(.,'Manage Publication')]");

	public SelectBox couponInTargetCombobox = new SelectBox(getDriver(), "Coupon In Target Combobox",
			"//li[.='Select Coupon']/ancestor::div[1]");

	public BasePage addToCampaignButton = new BasePage(getDriver(), "Add to Campaign button",
			"//button[.='Add to Campaign']");

	public BasePage createButton = new BasePage(getDriver(), "Create button", "//a[.='Create']");

	public BasePage allCheckboxInCampaignTarget = new BasePage(getDriver(), "All Checkbox",
			"//div[@class='ReactVirtualized__Table__headerColumn']//label");

	public BasePage manageBannerButton = new BasePage(getDriver(), "Manage banner button",
			"//button[.='Manage Banners']");

	public BasePage addButton = new BasePage(getDriver(), "Add Button", "//button[.='Add']");

	public TextBox startDateTextbox = new TextBox(getDriver(), "Start Date textbox",
			"//div[contains(@class,'form-group')]//div[contains(.,'Start Date')]//input");

	public TextBox endDateTextbox = new TextBox(getDriver(), "End Date textbox",
			"//div[contains(@class,'form-group')]//div[contains(.,'End Date')]//input");

	public TextBox commentTextbox = new TextBox(getDriver(), "Comment textbox", "//textarea");

	public BasePage cancelButtonInActivityTab = new BasePage(getDriver(), "Cancel button",
			"//h4[contains(.,'Comment')]/..//button[.='Cancel']");
	
	// New defined by Hung.Nguyen from e2e_team 
	// =========================================================================================
	
	public Map<String, String> getUserInformation() {

		List<WebElement> userInfo = getDriver().findElements(By.xpath("//div[@class='side-info-content']/div//div[@class='info-row row']/div"));
		
		Map<String, String> hashUserInfo = getDictData(userInfo);
		
		return hashUserInfo;
	}
	
	public Map<String, String> getPaymentProfile() {
		int count =0;
		int count1 =0;
		String paymentKey = null;
		String paymentValue = null;
		
		Logging.info("Getting Payment Profile .......");
		
		Map<String, String> hashPayment = new HashMap<String, String>();
		
		List<WebElement> paymentEven = getDriver().findElements(By.xpath("//*[@class='line payment even']/div"));
		
		List<WebElement> paymentOdd = getDriver().findElements(By.xpath("//*[@class='line payment odd']/div"));
		
		for (int i =0; i< paymentEven.size(); i++) {
			count ++;
			if (i % 2 == 0) {
				paymentKey = paymentEven.get(i).getText();
			} else {
				paymentValue = paymentEven.get(i).getText();
			 }
			if (count % 2 == 0) {
				hashPayment.put(paymentKey, paymentValue);
			}
		}
		for (int j =0; j< paymentOdd.size(); j++) {
			count1 ++;
			if (j % 2 == 0) {
				paymentKey = paymentOdd.get(j).getText();
			} else {
				paymentValue = paymentOdd.get(j).getText();
			 }
			if (count1 % 2 == 0) {
				hashPayment.put(paymentKey, paymentValue);
			}
		}
		return hashPayment;
	}

}

 package com.zinio.admin.pages;
import java.util.*;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zinio.web.element.BasePage;
import com.zinio.web.utilities.Logging;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;

public class AdminUsersPage extends BasePage{

	Map<String, String> tabUserList = getTabList();
	
	public AdminUsersPage(WebDriver driver) {
		super(driver);
		
	}
	/*
	 * *****Declaration Elements ****
	 */
	
	// Admin User Page
	
	public Map<String, String> getTabList()
	{
		Map<String, String> tabList = new HashMap<String, String>();
		tabList.put("generalTab", "user-tab___tab___general");
		tabList.put("prefTab", "user-tab___tab___preferences");
		tabList.put("orderTab", "user-tab___tab___orders");
		tabList.put("entitTab", "user-tab___tab___entitlements");
		tabList.put("issueTab", "user-tab___tab___issue_subscriptions");
		tabList.put("catalogTab", "user-tab___tab___catalog_subscriptions");
		tabList.put("paymentTab", "user-tab___tab___user-payment");
		return tabList;
	}
	String selectProject = "//*[@id='user-tab___pane___preferences']//li[@title='%s']";
	
	@FindBy(xpath = "//*[@class='menu-item menu-icons']//span[contains(text(), 'Users')]")
	WebElementFacade usersMenu;
	
	@FindBy(xpath = "//*[@class='btn-group btn-group-select']//span")
	WebElementFacade filterUser;
	
	@FindBy(xpath = "//*[@class='filter-wrapper']//form/div/input[@name='containt-text']")
	WebElementFacade txtContaint;
	
	@FindBy(className = "zmdi zmdi-close-circle-o")
	WebElementFacade deleteContainText;
	
	@FindBy(xpath = "//*[@class='filter-wrapper']//form//label")
	WebElementFacade searchIcon;
	
	@FindBy(xpath = "//table[@class='table table-striped table-responsive']")
	WebElementFacade gridEmail;
			
	@FindBy(xpath = "//a[@class='ic-back']")
	WebElementFacade backBtn;
			
	String emailTable = "//table[@class='table table-striped table-responsive']";
	String itemsTable = "//table[@class='table table-striped table-responsive']";
	
	// Admin User Details Page
	
	// ALL TAB
	
	@FindBy(id = "user-tab___tab___general")
	WebElementFacade generalInfoTab;
	
	@FindBy(id = "user-tab___tab___orders")
	WebElementFacade ordersTab;
	
	@FindBy(id = "user-tab___tab___entitlements")
	WebElementFacade entitlementTab;
	
	@FindBy(id = "user-tab___tab___issue_subscriptions")
	WebElementFacade issueSubTab;
	
	@FindBy(id = "user-tab___tab___catalog_subscriptions")
	WebElementFacade catalogSubTab;
	
	@FindBy(id = "user-tab___tab___user-payment")
	WebElementFacade paymentTab;
	
	@FindBy(id = "user-tab___tab___preferences")
	WebElementFacade preferencesTab;
	
	
	// General Tab
	
	@FindBy(id = "first_name")
	WebElementFacade txtFirstName;
	
	@FindBy(id = "last_name")
	WebElementFacade txtLastName;
	
	@FindBy(id = "email")
	WebElementFacade txtEmail;
	
	@FindBy(xpath = "//*[contains(text(), 'Reset Password')]")
	WebElementFacade resetPassword;
	
	@FindBy(xpath = "//*[@id='user-tab___pane___general']//div[@class='reset-combo']/div")
	WebElementFacade projectSelection;
	
	@FindBy(name = "Country")
	WebElementFacade countrySelection;
	
	@FindBy(name = "Gender")
	WebElementFacade genderSelection;
	
	@FindBy(css = "placeholder=\"internal_notes\"")
	WebElementFacade textNotes;
	
	@FindBy(name = "Status")
	WebElementFacade userStatus;
	
	@FindBy(xpath = "//*[@class='btn btn-success'][contains(text(), 'Save')]")
	WebElementFacade saveBtn;
	
	@FindBy(xpath = "//*[@class='btn btn-success'][contains(text(), 'Merge')]")
	WebElementFacade mergeBtn;
	
	@FindBy(xpath = "//*[@class='btn btn-default'][contains(text(), 'Cancel')]")
	WebElementFacade cancelBtn;
	
	String userInforEl = "//div[@class='side-info-content']/div//div[@class='info-row row']/div";
	
	@FindBy(xpath = "//*[@id='user-tab___pane___general']//*[contains(text(), 'Merge to')]")
	WebElementFacade mergeToBtn;
	
	@FindBy(name = "containt-text")
	WebElementFacade txtSearchEmail;
	
	@FindBy(xpath = "//*[@class='form-group']//label")
	WebElementFacade emailChecked;
	
	@FindBy(className = "icon icon-remove")
	WebElementFacade removeMergedUser;
	
	//  Preferences Tab
	
	@FindBy(xpath = "//*[@id='user-tab___pane___preferences']//button[@type='button']")
	WebElementFacade projectPreferencesTab;
	
	@FindBy(className = "ic-input ic-checkbox")
	WebElementFacade emailUpdate;
	
	@FindBy(xpath = "//*[@for='adult-true']/span")
	WebElementFacade allowAdultContent;
	
	@FindBy(xpath = "//*[@for='adult-false']/span")
	WebElementFacade rejectAdultContent;
	
	// Orders Tab	
	
	@FindBy(xpath = "//*[@id='user-tab___pane___orders']")
	WebElementFacade userTabPanel;
	
	@FindBy(xpath = "//div[contains(text(), 'Not Found')]")
	WebElementFacade foundOrder;
	
	String orderTableEl = "//*[@id='user-tab___pane___orders']//table[@class='table table-striped table-responsive']";
	
	@FindBy(xpath = "//*[@id='user-tab___pane___orders']//form/label")
	WebElementFacade seachProjectBtn;
	
	@FindBy(xpath = "//*[@id='user-tab___pane___orders']//form/div/input")
	WebElementFacade txtSearchProject;
	
	@FindBy(xpath = "//*[@id='user-tab___pane___orders']//span[contains(text(), 'First')]")
	WebElementFacade firstPageBtn;
	
	@FindBy(xpath = "//*[@id='user-tab___pane___orders']//span[contains(text(), 'Previous')]")
	WebElementFacade previousPageBtn;
	
	@FindBy(xpath = "//*[@id='user-tab___pane___orders']//span[contains(text(), 'Last')]")
	WebElementFacade lastPageBtn;
	
	@FindBy(xpath = "//*[@id='user-tab___pane___orders']//span[contains(text(), 'Next')]")
	WebElementFacade nextPageBtn;
	
	@FindBy(xpath = "//*[@id='user-tab___pane___orders']//form")
	WebElementFacade projectTypeEl;
	
	@FindBy(xpath = "//*[@id='user-tab___pane___orders']//span[contains(text(), 'Agent Type: All')]")
	WebElementFacade agentTypeEl;
	
	@FindBy(xpath = "//*[@id='user-tab___pane___orders']//span[contains(text(), 'Source Type: All')]")
	WebElementFacade sourceTypeEl;
	
	@FindBy(xpath = "//*[@id='user-tab___pane___orders']//span[contains(text(), 'Status: All')]")
	WebElementFacade statusEl;
	
	@FindBy(xpath = "//*[@id='user-tab___pane___orders']//span[contains(text(), 'More')]")
	WebElementFacade moreBtn;
	
	@FindBy(xpath = "//*[contains(text(), 'Confirmation')][@class='modal-title']")
	WebElementFacade confirmDisabled;
	
	@FindBy(xpath = "//button[@class='btn btn-default'][contains(text(), 'Go to Subscriptions')]")
	WebElementFacade gotoSubscriptions;
	
	@FindBy(xpath = "//button[@class='btn btn-primary'][contains(text(), 'Disable user')]")
	WebElementFacade disableUserBtn;
	
	@FindBy(xpath = "//button[@class='btn btn-primary'][contains(text(), 'Confirm')]")
	WebElementFacade confirmBtn;
	
	// Go to All TAB action
	
	public void clickOnGeneralTab()
	{
		Logging.info("Click on General Information Tab");
		generalInfoTab.click();
	}
	
	public void clickOrdersTab()
	{
		Logging.info("Click on Orders Tab");
		ordersTab.click();
	}
	
	public void clickEntitlementTab()
	{
		Logging.info("Click on Entitlement Tab");
		entitlementTab.click();
	}
	
	public void clickIssueSubTab()
	{
		Logging.info("Click on Issue Subscriptions Tab");
		issueSubTab.click();
	}
	
	public void clickCatalogTab()
	{
		Logging.info("Click on Catalog Tab");
		catalogSubTab.click();
	}
	
	public void clickPaymentTab()
	{
		Logging.info("Click on Payment Tab");
		paymentTab.click();
	}
	
	// Action on Elements
	
	public void getTabElement()
	{
	}
	
	public void clickOnUserTab() 
	{
		Logging.info("Click on User Menu");
		usersMenu.click();
	}
	
	public void enterSearchEmail(String userName)
	{
		Logging.info("Enter Email to text field then press Enter button");
		txtContaint.sendKeys(userName);
		try {
			Thread.sleep(2000);
			txtContaint.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void filterEmailId(String userFilter) 
	{
		Logging.info(String.format("Select filter user by :  %s", userFilter));
		Select country = new Select(filterUser);
		country.selectByValue(userFilter);
	}
	
	public void clickOnSearchIcon() 
	{
		Logging.info("Click on Search Icon");
		searchIcon.click();
	}
	
	public List<Map<String, WebElement>> getEmailHref()
	{
		Logging.info("Get Email Information");
		return getItemsTable(emailTable, "Email Table", true);
	}
	
	public List<Map<String, String>> getEmailTable()
	{
		Logging.info("Get Email Information");
		return getItemsTable(emailTable, "Email Table");
	}

	public List<Map<String, String>> getItemsTable()
	{
		Logging.info("Get items table in the list");
		return getItemsTable(itemsTable, "items Table");
	}
	
	public void enterFirstName(String firstName)
	{
		Logging.info("Enter the firt name in the text field: " + firstName);
		txtFirstName.clear();
		txtFirstName.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName)
	{
		Logging.info("Enter the last name in the text field: " + lastName);
		txtLastName.clear();
		txtLastName.sendKeys(lastName);
	}
	
	public void enterEmail(String emailAddress) throws InterruptedException
	{
		Logging.info("Enter the last name in the text field: " + emailAddress);
		Thread.sleep(3000);
		waitForTextToAppear("Email", 3000);
		txtEmail.clear();
		txtEmail.sendKeys(emailAddress);
	}
	
	public void clickResetPassword()
	{
		Logging.info("Click on Reset Password");
		resetPassword.click();
	}
	
	public void selectProject(String projecName)
	{
		Logging.info(String.format("Select project : %s", projecName));
		projectSelection.click();
		List<WebElement> projectList = projectSelection.findElements(By.xpath(String.format("//li[contains(text(), '%s')]", projecName)));
		projectList.get(0).click();
	}
	
	public void selectCountry(String countryName)
	{
		Logging.info(String.format("Select Country : %s", countryName));
		countrySelection.click();
		List<WebElement> countryEl = countrySelection.findElements(By.xpath(String.format("//li[contains(text(), '%s')]", countryName)));
		countryEl.get(0).click();
	}

	public void selectGender(String gender)
	{
		Logging.info(String.format("Select Gender :  %s", gender));
		genderSelection.click();
		List<WebElement> countryEl = countrySelection.findElements(By.xpath(String.format("//li[contains(text(), '%s')]", gender)));
		countryEl.get(0).click();
	}
	
	public void writeNote(String msg)
	{
		Logging.info("Write notes into the text field");
		textNotes.sendKeys(msg);
	}
	
	public void changeStatus(String statusUser)
	{
		Logging.info("Switch status user -> " + statusUser);
		userStatus.click();
		userStatus.findElement(By.xpath(String.format("//li[contains(text(), '%s')]",  statusUser))).click();;
	}
	
	public void clickSaveBtn()
	{
		Logging.info("Click Save Button");
		saveBtn.click();
	}
	
	public void clickCancelBtn()
	{
		Logging.info("Click Cancel Button");
		cancelBtn.click();
	}
	
	public Map<String, String> getUserInformation() {

		Logging.info("Get User Information");
		
		List<WebElement> userInfo = getDriver().findElements(By.xpath(userInforEl));
		
		Map<String, String> hashUserInfo = getDictData(userInfo);
		
		return hashUserInfo;
	}
	
	public void clickMergeToBtn()
	{
		Logging.info("Click Merge Button");
		mergeToBtn.click();
	}
	
	public void enterEmailToSearchField(String emailAddress)
	{
		Logging.info("Enter Email to search Field");
		txtSearchEmail.sendKeys(emailAddress);
		txtSearchEmail.sendKeys(Keys.ENTER);
	}
	
	public void checkMergerEmail()
	{
		Logging.info("Check Merge Email");
		emailChecked.click();
	}
	
	public void removeMergedUser()
	{
		Logging.info("Remove Merged User");
		Actions builder = new Actions(getDriver());
		builder.moveToElement(removeMergedUser).click().perform();
	}
	
	public void clickReferencesTab()
	{
		Logging.info("Click on References Tab ");
		preferencesTab.click();
	}
	
	public void selectProjectReferences(String projectName)
	{
		Logging.info(String.format("Select Project Name :  %s", projectName));
		projectPreferencesTab.click();
		selectProject = String.format(selectProject, projectName);
		getDriver().findElement(By.xpath(selectProject)).click();
	}
	
	public boolean isEmailUpdate()
	{
		Logging.info("Check that Email is updated or not in References Tab");
		return emailUpdate.isSelected();
	}
	
	public void emailUpdate(boolean updated)
	{
		if (updated == true) {
			if (emailUpdate.isSelected() == false) {
				emailUpdate.click();
			}
		} else {
			if (emailUpdate.isSelected() == true) {
				emailUpdate.click();
			}
		}
	}
	
	public boolean isAllowAdultContent()
	{
		Logging.info("Is Allow Adult content : " + allowAdultContent.isSelected());
		return allowAdultContent.isSelected();
	}
	
	public boolean isRejectAdultContent()
	{
		Logging.info("Is Reject Adult content : " + rejectAdultContent.isSelected());
		return rejectAdultContent.isSelected();
	}
	
	public void selectAllowAdult()
	{
		Logging.info("Allowed Adult content");
		allowAdultContent.click();
	}
	
	public void rejectAllowAdult()
	{
		Logging.info("Reject Adult content");
		rejectAdultContent.click();
	}
	
	public List<Map<String, String>> getOrderItemsTable()
	{
		return getItemsTable(orderTableEl, "Order in User Tab");
	}
	
	public List<Map<String, WebElement>> getOrderItemsTableLink()
	{
		return getItemsTable(orderTableEl, "Order in User Tab", true);
	}
	
	public void gotoLastPage()
	{	
		Logging.info("Go to Last page");
		lastPageBtn.click();
	}
	
	public void gotoPreviousPage()
	{	
		Logging.info("Go to Previous page");
		previousPageBtn.click();
	}
	
	public void gotoFirstPage()
	{	
		Logging.info("Go to First page");
		firstPageBtn.click();
	}
	
	public void gotoNextPage()
	{	
		Logging.info("Go to Next page");
		nextPageBtn.click();
	}
	
	public void clickSearchBtn()
	{	
		Logging.info("Click Search Btn");
		seachProjectBtn.click();
	}
	
	public void enterProjectToSearch(String projectID )
	{	
		Logging.info(String.format("Seach project ID: %s", projectID));
		txtSearchProject.sendKeys(projectID);
		seachProjectBtn.click();
	}
	
	public List<WebElement> findElementsWeb(String elementType)
	{
		return userTabPanel.findElements(By.xpath(String.format("//li[contains(text(), '%s')]", elementType)));
	}
	
	public void selectProjectType(String projectType)
	{
		Logging.info(String.format("Select project type is :  %s", projectType));
		projectTypeEl.findElement(By.xpath("//button")).click();
		List<WebElement> countryEl = findElementsWeb(projectType);
		countryEl.get(0).click();
	}
	
	public void selectAgentType(String agentType)
	{
		Logging.info(String.format("Select agent type is :  %s", agentType));
		agentTypeEl.click();
		List<WebElement> agenTypeList = findElementsWeb(agentType);
		agenTypeList.get(0).click();
	}
	
	public void selectSourceType(String sourceType)
	{
		Logging.info(String.format("Select source type is :  %s", sourceType));
		sourceTypeEl.click();
		List<WebElement> sourceTypeList = findElementsWeb(sourceType);
		sourceTypeList.get(0).click();
	}
	
	public void selectStatus(String status)
	{
		Logging.info(String.format("Select status :  %s", status));
		statusEl.click();
		List<WebElement> statusList = findElementsWeb(status);
		statusList.get(0).click();
	}
	
	public boolean checkConfirmPopup()
	{
		Logging.info("Check Confirm Disabled User Pop Up");
		try {
			Logging.info("Confirm: " + confirmDisabled.isDisplayed());
			return confirmDisabled.isDisplayed();
		} catch (Exception e)
		{
			Logging.info("Confirm: false");
			return false;
		}
	}
	
	public void clickOnSubcriptons()
	{	
		Logging.info("Click on Go To Subcriptions");
		gotoSubscriptions.click();
	}
	
	public void clickOnDisableUser()
	{	
		Logging.info("Click on Disabled User");
		disableUserBtn.click();
	}
	
	public void clickConfirmBtn()
	{	
		Logging.info("Click on Confirm Btn");
		confirmBtn.click();
	}
	

	public void clickMergeBtn()
	{	
		Logging.info("Click on Merge Btn");
		mergeBtn.click();
	}
	
}

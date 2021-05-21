package com.zinio.admin.ui;

import org.openqa.selenium.WebDriver;
import com.zinio.web.element.BasePage;
import com.zinio.web.element.CheckBox;
import com.zinio.web.element.SelectBox;
import com.zinio.web.element.TextBox;

public class CreatePageObject extends BasePage {

	public CreatePageObject(WebDriver driver) {
		super(driver);
	}

	public BasePage breadcrumb = new BasePage(getDriver(), "breadcrumb", "//div[@class='breadcrumb']");

	public BasePage pageTitle = new BasePage(getDriver(), "page title", "//div[@class='title-name']//h1");

	public BasePage controlTitle = new BasePage(getDriver(), "control title",
			"//div[contains(@class,'control title-text')]//h3");

	public TextBox accountNameTextBox = new TextBox(getDriver(), "Account Name textbox", "//input[@id='account-name']");

	public SelectBox typeComboBox = new SelectBox(getDriver(), "Type combobox", "//div[@name='Type']");

	public SelectBox countryComboBox = new SelectBox(getDriver(), "Country combobox", "//div[@name='Country']");

	public SelectBox tierComboBox = new SelectBox(getDriver(), "Tier combobox", "//div[@name='Tier']");

	public SelectBox statusComboBox = new SelectBox(getDriver(), "Status combobox", "//div[@name='Status']");

	public SelectBox parentComboBox = new SelectBox(getDriver(), "Parent combobox", "//div[@name='Parent']");

	public TextBox internalNotesTextBox = new TextBox(getDriver(), "Internal Notes textbox",
			"//textarea[@placeholder='Internal Notes']");

	public TextBox websiteTextBox = new TextBox(getDriver(), "Website textbox", "//input[@id='website']");

	public BasePage saveButton = new BasePage(getDriver(), "Save button", "//button[.='Save']");

	public BasePage cancelButton = new BasePage(getDriver(), "Cancel button",
			"//div[@class='form-button']//*[.='Cancel']");

	public BasePage confirmButton = new BasePage(getDriver(), "Confirm button", "//button[.='Confirm']");

	public BasePage iconBack = new BasePage(getDriver(), "Icon back", "//a[@class='ic-back']");

	public BasePage removeButton = new BasePage(getDriver(), "Remove button", "//button[.='Remove']");

	public BasePage browseButton = new BasePage(getDriver(), "Browse button", "//button[.='Browse']");

	// Project Create
	// ==================================================================================================

	public TextBox projectNameTextBox = new TextBox(getDriver(), "Project Name textbox", "//input[@id='project-name']");

	public SelectBox accountNameComboBox = new SelectBox(getDriver(), "Account Name combobox",
			"//div[starts-with(@name,'Account')]");

	public TextBox descriptionTextBox = new TextBox(getDriver(), "Description textbox",
			"//textarea[@placeholder='Description']");

	public TextBox launchDateTextBox = new TextBox(getDriver(), "Launch Date textbox",
			"//label[@for='launch-date']/following::input[1]");

	public SelectBox categorySetComboBox = new SelectBox(getDriver(), "Category Set combobox",
			"//div[@name='Category Set']");

	public BasePage openCalendarButton = new SelectBox(getDriver(), "Open Calendar button", "//span[@class='icon']");

	// Application Create
	// ==============================================================================================

	public TextBox applicationNameTextBox = new TextBox(getDriver(), "Application Name textbox", "//input[@id='name']");

	public SelectBox platformComboBox = new SelectBox(getDriver(), "Platform combobox", "//div[@name='Platform']");

	public SelectBox projectComboBox = new SelectBox(getDriver(), "Project combobox", "//div[@name='Project']");

	public TextBox urlTextBox = new TextBox(getDriver(), "Url textbox", "//input[@id='url']");

	public BasePage noProjectYetLink = new BasePage(getDriver(), "No Project Yet? link",
			"//a[@href='/projects/create']");

	// Catalog Create
	// ==================================================================================================

	public TextBox catalogNameTextBox = new TextBox(getDriver(), "Catalog Name textbox", "//input[@id='catalog-name']");

	public TextBox uploadBulkActionsFile = new TextBox(getDriver(), "Bulk Actions", "//input[@type='file']");

	// Publication Create
	// ==============================================================================================

	public TextBox publicationDisplayNameTextBox = new TextBox(getDriver(), "Publication Display Name textbox",
			"//input[@id='display-name']");

	public TextBox publicationInternalNameTextBox = new TextBox(getDriver(), "Publication Internal Name textbox",
			"//input[@id='internal-name']");

	public TextBox publicationLatinNameTextBox = new TextBox(getDriver(), "Publication Latin Name textbox",
			"//input[@id='latin-name']");

	public SelectBox printableSpreadsComboBox = new SelectBox(getDriver(), "Printable spreads combobox",
			"//div[@name='Printable spreads']");

	public SelectBox printableWatermarkComboBox = new SelectBox(getDriver(), "Printable watermark combobox",
			"//div[@name='Printable watermark']");

	public TextBox seoKeywordsTextBox = new TextBox(getDriver(), "SEO Keywords textbox",
			"//input[@placeholder='SEO Keywords']");

	public TextBox logoTextBox = new TextBox(getDriver(), "Logo textbox", "//input[@id='logo']");

	public SelectBox languageComboBox = new SelectBox(getDriver(), "Language combobox", "//div[@name='Language']");

	public SelectBox bindingComboBox = new SelectBox(getDriver(), "Binding combobox", "//div[@name='Binding']");

	public SelectBox frequencyComboBox = new SelectBox(getDriver(), "Frequency combobox", "//div[@name='Frequency']");

	public TextBox codeTextBox = new TextBox(getDriver(), "Code textbox", "//input[@id='code']");

	public TextBox slugTextBox = new TextBox(getDriver(), "Slug textbox", "//input[@id='slug']");

	public SelectBox publisherComboBox = new SelectBox(getDriver(), "Publisher combobox", "//div[@name='Publisher']");

	public TextBox issuesYearTextBox = new TextBox(getDriver(), "Issues/Year textbox", "//input[@id='no_of_issues']");

	public SelectBox ratingComboBox = new SelectBox(getDriver(), "Rating combobox", "//div[@name='Content Rating']");

	public TextBox taglineTextBox = new TextBox(getDriver(), "Tagline textbox", "//input[@id='tagline']");

	public TextBox issnTextBox = new TextBox(getDriver(), "ISSN textbox", "//input[@id='issn']");

	public TextBox fulfilmentCodeTextBox = new TextBox(getDriver(), "Fulfilment Code textbox",
			"//input[@id='fulfilment_code']");

	public SelectBox circulationTypeComboBox = new SelectBox(getDriver(), "Circulation Type combobox",
			"//div[@name='Circulation Type']");

	public SelectBox defaultCurrencyComboBox = new SelectBox(getDriver(), "Default Currency combobox",
			"//div[@name='Default Currency']");

	public SelectBox publicationParentCombobox = new SelectBox(getDriver(), "Publication Parent combobox",
			"//div[@name='Publication Parent']");

	public SelectBox allowPDFCombobox = new SelectBox(getDriver(), "Allow PDF Combobox",
			"//label[.='Allow PDF']/following-sibling::div");

	public SelectBox allowXMLCombobox = new SelectBox(getDriver(), "Allow XML Combobox",
			"//label[.='Allow XML']/following-sibling::div");

	public SelectBox hasPDFCombobox = new SelectBox(getDriver(), "Has PDF Combobox",
			"//label[.='Has PDF']/following-sibling::div");

	public SelectBox hasXMLCombobox = new SelectBox(getDriver(), "Has XML Combobox",
			"//label[.='Has XML']/following-sibling::div");

	// Category Set Create
	// =============================================================================================

	public TextBox categorySetNameTextBox = new TextBox(getDriver(), "Category Set Name textbox",
			"//input[@id='name']");

	// Category Create
	// =================================================================================================

	public TextBox categoryNameTextBox = new TextBox(getDriver(), "Category Name textbox", "//input[@id='name']");

	public TextBox imageURLTextBox = new TextBox(getDriver(), "Image URL textbox", "//input[@placeholder='Image']");

	public BasePage previewButton = new BasePage(getDriver(), "Preview button", "//div[.='Preview']");

	public BasePage previewImage = new BasePage(getDriver(), "Preview image",
			"//div[contains(@class,'banner-item')]/div[@class='inner']");

	public TextBox uploadImage = new TextBox(getDriver(), "Upload image",
			"//div[contains(@class,'banner-item')]//input");

	// Newsstand Create
	// ================================================================================================

	public TextBox newsstandNameTextBox = new TextBox(getDriver(), "Newsstand Name textbox",
			"//input[@id='display-name']");

	public TextBox newsstandInternalNameTextBox = new TextBox(getDriver(), "Newsstand Internal Name textbox",
			"//input[@id='internal-name']");

	public SelectBox catalogComboBox = new SelectBox(getDriver(), "Catalog combobox", "//div[@name='Catalog']");

	public SelectBox ratingMinComboBox = new SelectBox(getDriver(), "Rating Min combobox",
			"//div[@name='Content Rating Min']");

	public SelectBox ratingMaxComboBox = new SelectBox(getDriver(), "Rating Max combobox",
			"//div[@name='Content Rating Max']");

	public SelectBox currencyComboBox = new SelectBox(getDriver(), "Currency combobox", "//div[@name='Currency']");

	public SelectBox supportXMLComboBox = new SelectBox(getDriver(), "Support XML combobox",
			"//div[@name='Support XML']");

	public SelectBox supportPDFComboBox = new SelectBox(getDriver(), "Support PDF combobox",
			"//div[@name='Support PDF']");

	// Staff User Create
	// ================================================================================================
	public TextBox staffFirstNameTextBox = new TextBox(getDriver(), "Staff FirstName textbox",
			"//input[@id='first_name']");

	public TextBox staffLastNameTextBox = new TextBox(getDriver(), "Staff FirstName textbox",
			"//input[@id='last_name']");

	public TextBox staffEmailTextBox = new TextBox(getDriver(), "Staff Email textbox", "//input[@id='email']");

	public SelectBox genderComboBox = new SelectBox(getDriver(), "Gender combobox", "//div[@name='Gender']");

	// Campaign Create
	// ================================================================================================
	public TextBox startDateTextBox = new TextBox(getDriver(), "Start Date textbox",
			"//label[contains(.,'Start Date')]/following::input[1]");

	public SelectBox startHourComboBox = new SelectBox(getDriver(), "Start hour combobox",
			"//label[contains(.,'Start Hour')]/following-sibling::div");

	public TextBox endDateTextBox = new TextBox(getDriver(), "End Date textbox",
			"//label[contains(.,'End Date')]/following::input[1]");

	public SelectBox endHourComboBox = new SelectBox(getDriver(), "End hour combobox",
			"//label[contains(.,'End Hour')]/following-sibling::div");

	public SelectBox initiativeComboBox = new SelectBox(getDriver(), "Initiative combobox",
			"//div[@name='Initiative']");

	public SelectBox goalComboBox = new SelectBox(getDriver(), "Goal combobox", "//div[@name='Goal']");

	public SelectBox customerSourceComboBox = new SelectBox(getDriver(), "Customer Source combobox",
			"//div[@name='Customer Source']");

	public SelectBox accountCodeComboBox = new SelectBox(getDriver(), "Account Code combobox",
			"//div[@name='Account']");

	public SelectBox visibilityComboBox = new SelectBox(getDriver(), "Visibility combobox",
			"//div[@name='Visibility']");

	public TextBox shortCodeTextbox = new TextBox(getDriver(), "Short code textbox",
			"//label[contains(.,'Short Code')]/following::input[1]");

	public CheckBox channelCheckBox = new CheckBox(getDriver(), "Channel checkbox", "Channel");

	public TextBox amountTextbox = new TextBox(getDriver(), "Amount Text box", "//input[@id='amount_one_proxy']");

	public SelectBox sponsoredRateComboBox = new SelectBox(getDriver(), "Sponsored rate combo box",
			"//li[contains(.,'Choose Sponsored Rate')" + "]/ancestor::div[1]");

	public TextBox sponsoredRateTextBox = new TextBox(getDriver(), "Sponsored rate text box",
			"//div[@class='modal-content']//input");

	public BasePage saveButtonInSponsoredRatePopup = new BasePage(getDriver(), "Save button in Sponsored rate popup",
			"//div[@class='modal-content']//button[.='Save']");

	public BasePage cancelButtonInDialog = new BasePage(getDriver(), "Cancel button in Sponsored rate popup",
			"//div[@class='modal-content']//button[.='Cancel']");

	// Banner Create
	// ====================================================================================================
	public TextBox titleTextbox = new TextBox(getDriver(), "Title of banner", "//input[@id='title']");
	public TextBox titleDetailBanner = new TextBox(getDriver(), "Title of detail banner",
			"//input[@type='text' and @id='title']");
	public TextBox subtitleBanner = new TextBox(getDriver(), "Subtitle", "//input[@id='subtitle']");
	public SelectBox action = new SelectBox(getDriver(), "Select box", "//div[@name='action']");
	public TextBox actionObjectId = new TextBox(getDriver(), "Action Object ID", "//input[@id='action_object_id']");
	public TextBox targetKeyTextBox = new TextBox(getDriver(), "Target key textbox", "//input[@id='target_key']");
	public TextBox targetLayoutTextBox = new TextBox(getDriver(), "Target layout textbox",
			"//input[@id='target_layout']");
	public SelectBox type = new SelectBox(getDriver(), "Type", "//div[@name='Type']");
	public SelectBox status = new SelectBox(getDriver(), "Status", "//div[@name='Status']");
	public TextBox image21URL = new TextBox(getDriver(), "Image 2x1 URL", "//input[@id='image2x1']");
	public TextBox image31URL = new TextBox(getDriver(), "Image 3x1 URL", "//input[@id='image3x1']");
	public TextBox image41URL = new TextBox(getDriver(), "Image 4x1 URL", "//input[@id='image4x1']");

	public TextBox previewBanner21 = new TextBox(getDriver(), "Preview Image with size 2:1",
			"//div[contains(@class,'banner-view-item')][1]");
	public TextBox previewBanner31 = new TextBox(getDriver(), "Preview Image with size 3:1",
			"//div[contains(@class,'banner-view-item')][2]");
	public TextBox previewBanner41 = new TextBox(getDriver(), "Preview Image with size 4:1",
			"//div[contains(@class,'banner-view-item')][3]");

	public TextBox uploadBanner21 = new TextBox(getDriver(), "Upload banner 2x1",
			"//input[@id='image2x1']//following::input[@type='file'][1]");

	public TextBox uploadBanner31 = new TextBox(getDriver(), "Upload banner 3x1",
			"//input[@id='image3x1']//following::input[@type='file'][1]");

	public TextBox uploadBanner41 = new TextBox(getDriver(), "Upload banner 4x1",
			"//input[@id='image4x1']//following::input[@type='file'][1]");

	public CheckBox platformCheckbox = new CheckBox(getDriver(), "Platform checkbox", "Platform");
	public SelectBox newsstandComboBox = new SelectBox(getDriver(), "Newsstand combobox",
			"//li[.='Choose Newsstand']/ancestor::div[1]");
	public SelectBox campaignComboBox = new SelectBox(getDriver(), "Campaign combobox",
			"//li[.='Choose Campaign']/ancestor::div[1]");

	// Publication create
	// ===============================================================================================
	public TextBox cmsIdTextbox = new TextBox(getDriver(), "CMS Id textbox", "//input[@id='site-id']");

	// Free Entitlement
	// =================================================================================================
	public SelectBox newsstandComboBoxInEntitlement = new SelectBox(getDriver(), "Newsstand combobox",
			"//label[contains(.,'Newsstand')]/following::div[1]");

	public SelectBox projectComboBoxInEntitlement = new SelectBox(getDriver(), "Project combobox",
			"//label[contains(.,'Project')]/following::div[1]");
	public BasePage btnSelectPublication = new BasePage(getDriver(), "Select Publication and Issue",
			"//button[@class='btn btn-primary']");

	public BasePage typeComboBoxInEntitlement = new BasePage(getDriver(), "Type filter", "//span[.='Type: All']");

	public TextBox internalNotesTextboxOrder = new TextBox(getDriver(), "Internal notes textbox",
			"//label[contains(.,'Internal notes')]//following::textarea");

	// Product tab
	// ======================================================================================================
	public BasePage cancelButtonInEditProductMode = new BasePage(getDriver(), "Cancel button",
			"//button[.='Cancel' and contains(@class,'btn-sm')]");

}

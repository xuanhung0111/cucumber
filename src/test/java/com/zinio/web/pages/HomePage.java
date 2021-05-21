package com.zinio.web.pages;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zinio.web.element.BasePage;
import com.zinio.web.utilities.Logging;

import net.serenitybdd.core.pages.WebElementFacade;

/**
 * 
 * Author : Hung Nguyen Created on 20/12/2017 Page definition of Home Page is
 * implemented in this class. As Page object model is used, it will make the
 * maintenance easier
 *
 */

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	String shopFeatured = "//*[contains(@class, 'Shop-featured')]//a[contains(text(), '%s')]";
	String userNameXpath = "//*[@class='UserSettings']//div[@class='Dropdown-controls']//span[contains(text(), '%s')]";
	String issueCover = "//*[@class='IssueList-issues']//div[@title='%s']//div[@class='Issue-cover u-coverPlaceholder']";
	String issueTitle = "//*[@class='IssueList-issues']//div[@title='%s']//ul/li[@class='title']";
	String issueDate = "//*[@class='IssueList-issues']//div[@title='%s']//ul/li[@class='date']";
	String categoriesType = "//*[@class='HomeCategory']//span[contains(text(), '%s')]";
	String orderSummary = "//*[contains(@class, 'Checkout-summary')]//div[@class='Table-cell']";
	String indexPage = "//*[@class='Pagination-item']/a[contains(text(), '%')]";
	String previousSlider = "//*[contains(@class,'IssuesSlider')]//*[@class='IssuesSlider-previous']/i";
	String nextSlider = "//*[contains(@class,'IssuesSlider')]//*[@class='IssuesSlider-next']/i";
	String catrgoriesSortingType = "//*[contains(@class, 'Categories-sorting')]//div[contains(text(), '%s')]";
	String catrgoriesLanguageFilter = "//*[contains(@class, 'Categories-languageFilter')]//div[contains(text(), '%s')]";
	String categoriesPage = "//*[contains(@class,'Shop-categories')]//a[contains(text(), '%s')]";
	String languageCode = "//*[@id='user-language-%s']";

	// User Setting

	// @FindBy(xpath = "//*[@class='UserSettings-login']/span[contains(text(), 'Log
	// in')]")
	@FindBy(xpath = "//*[@id='user-logIn']/i")
	WebElementFacade loginBtn;

	@FindBy(xpath = "//*[@class='UserSettings']//div[@class='UserSettings-general Dropdown']//*[@class='Dropdown-controls']")
	WebElementFacade userDropdown;

	@FindBy(xpath = "//*[@class='UserSettings']//div[@class='Dropdown UserSettings-language']//*[@class='Dropdown-controls']")
	WebElementFacade languageDropdown;

	@FindBy(xpath = "//*[contains(text(), 'Account Settings')]")
	WebElementFacade accountSetting;

	@FindBy(xpath = "//*[contains(text(), 'Support')]")
	WebElementFacade support;

	@FindBy(xpath = "//*[contains(text(), 'Sign Out')]")
	WebElementFacade signOut;

	// Web Header

	@FindBy(className = "WebHeader-logo")
	WebElementFacade logoWeb;

	@FindBy(xpath = "//*[@id='menu-shop']/a")
	WebElementFacade shop;

	@FindBy(className = "Shop is-open")
	WebElementFacade expandShop;

	@FindBy(id = "menu-library")
	WebElementFacade myLibrary;

	@FindBy(className = "Explore")
	WebElementFacade explore;

	@FindBy(xpath = "//*[@name='keyword' and @role='combobox']")
	WebElementFacade searchBox;

	@FindBy(xpath = "//*[contains(@class, 'WebHeader-searchIcon')]")
	WebElementFacade searchButton;

	@FindBy(xpath = "//*[contains(@class, 'WebHeader-cartIcon')]")
	WebElementFacade cartIcon;

	@FindBy(xpath = "//*[@class='WebHeader-cart']/span")
	WebElementFacade itemOnCart;

	@FindBy(xpath = "//*[@class='IssueList-viewAll' and contains(@href, 'top-sellers')]")
	WebElementFacade viewTopSeller;

	@FindBy(xpath = "//*[@class='IssueList-viewAll' and contains(@href, 'featured')]")
	WebElementFacade viewFeatured;

	@FindBy(className = "pageTitle--centered")
	WebElementFacade searchedString;

	@FindBy(className = "searchSubtitle")
	WebElementFacade searchResult;

	@FindBy(xpath = "//*[@class='Modal-dialog']/span/i[contains(text(), 'close')]")
	WebElementFacade closeCartPopUp;

	@FindBy(xpath = "//*[@class='IssueList-header']/h1[contains(text(), 'TOP SELLERS')]")
	WebElementFacade topSellersHeader;

	@FindBy(xpath = "//*[@class='IssueList-header']/h1[contains(text(), 'FEATURED')]")
	WebElementFacade featuredHeader;

	@FindBy(className = "HomeCategories-title")
	WebElementFacade categoriesTitle;

	@FindBy(xpath = "//*[@class='Pagination-list']//li[@class='Pagination-previous']")
	WebElementFacade previousPage;

	@FindBy(xpath = "//*[@class='Pagination-list']//li[@class='Pagination-last']")
	WebElementFacade lastPage;

	@FindBy(xpath = "//*[@class='Pagination-list']//li[@class='Pagination-next']")
	WebElementFacade nextPage;

	// After clicked ViewAll button / Or In Categories Page to check header featured
	@FindBy(xpath = "//*[@class='SubHeader-titleBar']//h1")
	WebElementFacade titleHeader;

	// After clicked Shop All option from list feature

	@FindBy(xpath = "//*[@class='IssuesSlider-header']/*[contains(text(), 'TOP SELLERS')]")
	WebElementFacade topSellersSliderHeader;

	@FindBy(xpath = "//*[@class='IssuesSlider-header']/*[contains(text(), 'FEATURED')]")
	WebElementFacade featuredSliderHeader;

	@FindBy(xpath = "//*[@class='IssuesSlider-header']/*[contains(text(), 'NEWS WEEKLIES')]")
	WebElementFacade newsWeekliesSliderHeader;

	@FindBy(xpath = "//*[@class='IssuesSlider-header']/*[contains(text(), 'NEW ARRIVALS')]")
	WebElementFacade newArrivalsSliderHeader;

	@FindBy(xpath = "//*[@class='IssuesSlider-header']//*[contains(@href, 'top-sellers')]")
	WebElementFacade viewAllTopSellers;

	@FindBy(xpath = "//*[@class='IssuesSlider-header']//*[contains(@href, 'featured')]")
	WebElementFacade viewAllFeatured;

	@FindBy(xpath = "//*[@class='IssuesSlider-header']//*[contains(@href, 'news-weeklies')]")
	WebElementFacade viewAllNewsWeeklies;

	@FindBy(xpath = "//*[@class='IssuesSlider-header']//*[contains(@href, 'new-arrivals')]")
	WebElementFacade viewAllNewArrivals;

	// In List Categories Page

	@FindBy(xpath = "//*[contains(@class,'Categories-sorting')]//span")
	WebElementFacade categoriesSortingPage;

	@FindBy(xpath = "//*[contains(@class,'Categories-sorting')]//div[@class='Dropdown-controls']//i")
	WebElementFacade sortArrowDownBtn;

	@FindBy(xpath = "//*[contains(@class, 'Categories-languageFilter')]//span")
	WebElementFacade categoriesLanguageFilter;

	@FindBy(xpath = "//*[contains(@class,'Categories-sorting')]//div[@class='Dropdown-controls']//i")
	WebElementFacade languageArrowDownBtn;

	// In Library

	String magazineInLib = "//*[@title='%s']//li[@class='date']";

	@FindBy(xpath = "//*[@id='libraryFilter']/span")
	WebElementFacade libraryFilterType;

	@FindBy(xpath = "//*[@id='libraryFilter']/i")
	WebElementFacade libraryFilterOption;

	@FindBy(id = "library-purchaseDateFilter")
	WebElementFacade libraryPurchaseDateFilter;

	@FindBy(id = "library-publishDateFilter")
	WebElementFacade libraryPublishDateFilter;

	@FindBy(id = "library-titleAZFilter")
	WebElementFacade libraryTitleAZFilter;

	@FindBy(xpath = "//*[@class='Issue-info']//a")
	List<WebElementFacade> issueList;
	
	@FindBy(xpath = "//*[@class='Issue-overlay']")
	List<WebElementFacade> readIcon;
	
	// Thankyou page
	
	@FindBy(className = "Thankyou")
	WebElementFacade thankYouPannel;
	

	// Actions
	/*
	 * Note: Currently: just use System.out.println for displaying information. Will
	 * instead of by other function later
	 */

	public void clickLoginBtn() {
		Logging.info("Click Login button");
		Logging.info("Is Login button is displayed :  " + loginBtn.isDisplayed());
		loginBtn.click();
	}

	public boolean isUserNamePresent(String userName) {
		Logging.info("Check user name is present on Web");
		userName = userName.replaceAll("@.*", "");
		userNameXpath = String.format(userNameXpath, userName);
		waitABit(3000);
		try {
			WebElement userNameEl = getDriver().findElement(By.xpath(userNameXpath));
			return userNameEl.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void clickOnAccount() {
		Logging.info("Click Dropdown button on Account");
		userDropdown.click();
	}

	public void clickOnLanguage() {
		Logging.info("Click Dropdown button on Language");
		languageDropdown.click();
	}

	public void goToAccountSetting() {
		Logging.info("Go to Account Setting");
		accountSetting.click();
	}

	public void clickSupport() {
		Logging.info("Click on Support button");
		accountSetting.click();
	}

	public void clickSignOut() {
		Logging.info("Click on Sign Out button . Bye Bye !!!");
		signOut.click();
	}

	public void goToHomePage() {
		Logging.info("Go to HomePage");
		logoWeb.click();
	}

	public boolean isHomePagePresent() {
		Logging.info("Check Home Page is present");
		try {
			return logoWeb.isDisplayed();
		} catch (Exception noSuchElement) {
			Logging.info("Home Page is not present");
			return false;
		}
	}

	public void clickShopDropDown() {
		Logging.info("Click Shop Dropdown");
		shop.click();
		waitABit(2000);
	}

	public void waitUntilShopExpandFeatured() {
		WebDriverWait waitUlti = new WebDriverWait(getDriver(), 10);
		waitUlti.until(ExpectedConditions.visibilityOfElementLocated(By.className("Shop is-open")));
	}

	public void selectShopOption(String featured) {
		// here are all options of featured and categories
		// option get from com.zinio.web.data.FeaturedCategories.java
		// Ex: Shop All

		Logging.info("Select shop section: " + featured);
		shopFeatured = String.format(shopFeatured, featured);
		waitABit(5000);
		WebElement featuredEl = getDriver().findElement(By.xpath(shopFeatured));
		featuredEl.click();
	}

	public void goToLibrary() {
		Logging.info("Go to Library");
		myLibrary.click();
	}

	public void goToExplore() {
		Logging.info("Go to Explore Issues");
		explore.click();
	}

	public void sendKeyToSearchBox(String keysearch) {
		Logging.info(String.format("Send key %s in to search box", keysearch));
		searchBox.sendKeys(keysearch);
		Logging.info("Click search button");
		searchButton.click();
	}
	
	public boolean checkSearchResutl(String magazine) {
		Logging.info("Check magazine is shown when seaching");
		String issueCoverEl = String.format(issueCover, magazine);
		try {
			WebElement issueCoverElt = getDriver().findElement(By.xpath(issueCoverEl));
			return issueCoverElt.isDisplayed();
		} catch (Exception noSuchElenment) {
			Logging.info(magazine + " is not displayed when searching");
			return false;
		}
		
	}

	public void clickOnCoverImage(String issueName) {
		Logging.info("Click on Issue Cover");
		issueCover = String.format(issueCover, issueName);
		WebElement issueCoverEl = getDriver().findElement(By.xpath(issueCover));
		issueCoverEl.click();
	}
	
	public void clickOnIssueTitle(String issueName) {
		Logging.info("Click on Issue title");
		issueTitle = String.format(issueTitle, issueName);
		WebElement issueTitleEl = getDriver().findElement(By.xpath(issueTitle));
		issueTitleEl.click();
	}

	public void clickOnIssueDate(String issueName) {
		Logging.info("Click on issue date");
		issueDate = String.format(issueDate, issueName);
		WebElement issueDateEl = getDriver().findElement(By.xpath(issueDate));
		issueDateEl.click();
	}

	public void clickOnCategoriesName(String categoriesName) {
		Logging.info("Click on categories :" + categoriesName);
		categoriesType = String.format(categoriesType, categoriesName);
		WebElement categoriesEl = getDriver().findElement(By.xpath(categoriesType));
		categoriesEl.click();
	}
	
	public boolean checkCategoriesPageIsPresent(String categoriesName) {
		Logging.info("Check Categories Page is present :" + categoriesName);
		categoriesPage = String.format(categoriesPage, categoriesName);
		try {
			return getDriver().findElement(By.xpath(categoriesPage)).isDisplayed();
		} catch (Exception noSuchElenment) {
			Logging.info(categoriesName + " is not displayed");
			return false;
		}
	}
	
	
	public String getTitleHeader() {
		Logging.info("Get Title Header");
		String title = titleHeader.getText();
		Logging.info("Title header is " + title);
		return title;
	}

	public String getSearchedString() {
		Logging.info("check searched string");
		String result = searchedString.getText();
		return result.split("Search Results")[0];
	}

	public String getSearchResult() {
		Logging.info("Get search result");
		String result = searchResult.getText();
		return result.split("Search Results")[0];
	}

	public void clickCartIcon() {
		Logging.info("Click Cart Icon");
		cartIcon.click();
	}

	public String getItemOnCart() {
		Logging.info("Get Item On Cart");
		return itemOnCart.getText();
	}

	public void closeCartPopUp() {
		Logging.info("Close Cart Pop Up");
		closeCartPopUp.click();
	}

	// public List<String> getIssueListHeader()
	// {
	// List <String> listHeader= new ArrayList<String>();
	// List<WebElement> issueListHeaderEl =
	// getDriver().findElements(By.xpath(issueListHeader));
	// for(WebElement el : issueListHeaderEl)
	// {
	// listHeader.add(el.getText());
	// }
	// return listHeader;
	// }

	public boolean isTopSellersPresentAtHomePage() {
		Logging.info("Check Top Sellers header is present at home page");
		try {
			return topSellersHeader.isDisplayed();
		} catch (Exception noSuchEl) {
			return false;
		}
	}

	public boolean isFeaturedPresentAtHomePage() {
		Logging.info("Check Featured header is present at home page");
		try {
			return featuredHeader.isDisplayed();
		} catch (Exception noSuchEl) {
			return false;
		}
	}

	public boolean isCategoriesPresent() {
		Logging.info("Check Categories is present at home page");
		try {
			return categoriesTitle.isDisplayed();
		} catch (Exception noSuchEl) {
			return false;
		}
	}

	public void goBackToPreviousPage() {
		Logging.info("Go Back to Previous Page");
		previousPage.click();
	}

	public void goToNextPage() {
		Logging.info("Go to Last Page");
		lastPage.click();
	}

	public void goToLastPage() {
		Logging.info("Go to Last Page");
		nextPage.click();
	}

	public void goToIndexPage(String numberPage) {
		Logging.info("Go to page: " + numberPage);
		String indexPageEl = String.format(indexPage, numberPage);
		getDriver().findElement(By.xpath(indexPageEl)).click();
	}

	public boolean isTopSellersPresentAtShopAllPage() {
		Logging.info("Check Top Sellers slider header is present at Shop All page");
		try {
			return topSellersSliderHeader.isDisplayed();
		} catch (Exception noSuchEl) {
			return false;
		}
	}

	public boolean isFeaturedPresentAtShopAllPage() {
		Logging.info("Check Featured slider header is present at Shop All page");
		try {
			return featuredSliderHeader.isDisplayed();
		} catch (Exception noSuchEl) {
			return false;
		}
	}

	public boolean isNewsWeekliesPresentAtShopAllPage() {
		Logging.info("Check News Weeklies slider header is present at Shop All page");
		try {
			return newsWeekliesSliderHeader.isDisplayed();
		} catch (Exception noSuchEl) {
			return false;
		}
	}

	public boolean isNewsArrivalPresentAtShopAllPage() {
		Logging.info("Check News Arrival slider header is present at Shop All page");
		try {
			return newArrivalsSliderHeader.isDisplayed();
		} catch (Exception noSuchEl) {
			return false;
		}
	}

	public void clickViewAllTopSellersBtnInShopAllPage() {
		Logging.info("Click View All Top Sellers button in the Shop all page");
		viewAllTopSellers.click();
	}

	public void clickViewAllFeaturedBtnInShopAllPage() {
		Logging.info("Click View All Featured button in the Shop all page");
		viewAllFeatured.click();
	}

	public void clickViewAllNewsWeekliesBtnInShopAllPage() {
		Logging.info("Click View All News Weeklies button in the Shop all page");
		viewAllNewsWeeklies.click();
	}

	public void clickViewAllNewsArrivalsBtnInShopAllPage() {
		Logging.info("Click View All New Arrivals button in the Shop all page");
		viewAllNewArrivals.click();
	}

	public void clickPreviousNextSlider(boolean next, String issueSliderName) {
		// issueSliderName can be : TOP SELLERS | FEATURED | NEWS WEEKLIES | NEW
		// ARRIVALS

		List<WebElement> sliderEl = new ArrayList<WebElement>();
		if (next) {
			Logging.info("Click next slider");
			sliderEl = getDriver().findElements(By.xpath(nextSlider));
		} else {
			Logging.info("Click previous slider");
			sliderEl = getDriver().findElements(By.xpath(previousSlider));
		}
		if (sliderEl.size() != 0) {
			switch (issueSliderName) {
			case "TOP SELLERS":
				sliderEl.get(0).click();
			case "FEATURED":
				sliderEl.get(1).click();
			case "NEWS WEEKLIES":
				sliderEl.get(2).click();
			case "NEW ARRIVALS":
				sliderEl.get(3).click();
			}
		} else {
			Logging.info("Cannot found Element");
		}
	}

	public void clickDotBtnAtShopAllPage(int dotNum, String issueName) {
		// issueSliderName can be : TOP SELLERS | FEATURED | NEWS WEEKLIES | NEW
		// ARRIVALS

		List<WebElement> slickdotsEl = new ArrayList<WebElement>();
		slickdotsEl = getDriver().findElements(By.className("slick-dots"));

		if (slickdotsEl.size() != 0) {
			switch (issueName) {
			case "TOP SELLERS":
				slickdotsEl.get(0).findElements(By.xpath("//li")).get(dotNum).click();
			case "FEATURED":
				slickdotsEl.get(1).findElements(By.xpath("//li")).get(dotNum).click();
			case "NEWS WEEKLIES":
				slickdotsEl.get(2).findElements(By.xpath("//li")).get(dotNum).click();
			case "NEW ARRIVALS":
				slickdotsEl.get(3).findElements(By.xpath("//li")).get(dotNum).click();
			}
		} else {
			Logging.info("Cannot found Element");
		}
	}

	public String getCategoriesSortingType() {
		Logging.info("Get Categories Sorting Type");
		return categoriesSortingPage.getText();
	}

	public void selectCategoriesSortingType(String sortingType) {
		// Categories Sorting Type is : Most Popular or Z-A
		String sortingTypeEl = String.format(catrgoriesSortingType, sortingType);
		sortArrowDownBtn.click();
		WebElement sortingEl = getDriver().findElement(By.xpath(sortingTypeEl));
		sortingEl.click();
	}

	public String getCategoriesLanguageFilter() {
		Logging.info("Get Categories Language Filter");
		return categoriesLanguageFilter.getText();
	}

	public void selectCategoriesLanguageFilter(String languages) {
		// Categories Language Filter is : Englisgh | Soumi |France ...
		String languageFilter = String.format(catrgoriesLanguageFilter, languages);
		languageArrowDownBtn.click();
		WebElement languageEl = getDriver().findElement(By.xpath(languageFilter));
		languageEl.click();
	}

	public void goToCategoriesPage(String categoriesName) {
		// Categories name : Fashion, Food and Wine, Home and Garden...
		String categoriesNameEl = String.format(categoriesPage, categoriesName);
		WebElement el = getDriver().findElement(By.xpath(categoriesNameEl));
		el.click();
	}

	public List<WebElement> checkIssueSubcriptionInLibrary(String magazineName) {
		magazineInLib = String.format(magazineInLib, magazineName);
		List<WebElement> el = getDriver().findElements(By.xpath(magazineInLib));
		return el;
	}

	public String getlibraryFilterType() {
		Logging.info("Get library filter");
		return libraryFilterType.getText();
	}

	public void selectLibraryFilterOption(String filterType) {
		Logging.info("Select Libraty Filter type is " + filterType);
		libraryFilterOption.click();
		waitABit(1000);
		if (filterType.equals("Purchase Date")) {
			libraryPurchaseDateFilter.click();
		} else if (filterType.equals("Publish Date")) {
			libraryPublishDateFilter.click();
		} else {
			libraryTitleAZFilter.click();
		}
	}

	public List<String> getIssueInLibrary() {
		Logging.info("Get Issue in Library");
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < issueList.size(); i++) {
			result.add(issueList.get(i).getText());
		}
		List<String> unique = removeDuplicates(result);
		return unique;
		
	}

	static List<String> removeDuplicates(List<String> list) {

        // Store unique items in result.
        List<String> result = new ArrayList<>();

        // Record encountered Strings in HashSet.
        HashSet<String> set = new HashSet<>();

        // Loop over argument list.
        for (String item : list) {

            // If String is not in set, add it to the list and the set.
            if (!set.contains(item)) {
                result.add(item);
                set.add(item);
            }
        }
        return result;
    }
	
	public void readAnyIssueInLibrary() {
		if (readIcon.get(0).isPresent()) {
			Actions actions = new Actions(getDriver());
			actions.moveToElement(readIcon.get(0).findElement(By.xpath("//div[@class='OverlayContent']//i"))).build().perform();
			waitABit(2000);
			readIcon.get(0).findElement(By.xpath("//div[@class='OverlayContent']//i")).click();
		}
	}
	
	public boolean checkThankYouPannelIsPresent() {
		Logging.info("Check Thankyou Pannel is present");
		try {
			return thankYouPannel.isDisplayed();
		} catch (Exception noSuchEl) {
			return false;
		}
	}
	
	public void selectLanguage(String language, String code) {
		Logging.info("Select language is:" + language);
		languageCode = String.format(languageCode, code);
			getDriver().findElement(By.xpath(languageCode)).click();
	}
	
	public String getCurrentLanguageDisplay() {
		Logging.info("Get currently language display");
		return languageDropdown.findElement(By.xpath("//span")).getText();
	}
	
}

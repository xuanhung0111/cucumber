package com.zinio.web.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.zinio.web.element.BasePage;
import com.zinio.web.utilities.Logging;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProductPage  extends BasePage{

	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	/*
	 * *****Declaration Elements ****
	 */
	
	String recentIssueEl = "//*[@class='date' and contains(text(), '%s')]";
	
	// Product Page
	@FindBy(xpath = "//a[contains(text(), 'BUY ISSUE')]")
	WebElementFacade buyIssue;
	
	@FindBy(xpath = "//a[contains(text(), 'SUBSCRIBE')]")
	WebElementFacade Subcribe;
	
	@FindBy(id = "backIssueModal-subscribeButton")
	WebElementFacade subscriptionOnly;
	
	@FindBy(id = "backIssueModal-backIssueButton")
	WebElementFacade backIssueSubscription;
	
	@FindBy(className = "BackIssueModal")
	WebElementFacade backIssueInSubs;
	
	@FindBy(xpath = "//*[@id='issue-subscribeSection']/span[@class='Product-price']")
	WebElementFacade subPrices;
	
	@FindBy(xpath = "//*[@id='issue-buyIssueSection']/span[@class='Product-price']")
	WebElementFacade issuePrices;
	
	@FindBy(className = "Product-totalIssues")
	WebElementFacade totalIssue;
	
	@FindBy(id = "description")
	WebElementFacade descriptionButton;
	
	@FindBy(id = "details")
	WebElementFacade detailsButton;
	
	@FindBy(className = "IssuesSlider-previous")
	WebElementFacade previousButton;
	
	@FindBy(className = "IssuesSlider-next")
	WebElementFacade nextButton;
	
	@FindBy(className = "slick-dots")
	WebElementFacade slickDotsList;
	
	@FindBy(xpath = "//*[@class='IssuesSlider-header']/a[contains(text(), 'View All')]")
	WebElementFacade viewAllButton;
	
	@FindBy(xpath = "//*[@class='Product-info']/h1")
	WebElementFacade productName;
	
	@FindBy(xpath = "//*[@class='Product-info']/span")
	WebElementFacade publishDay;
	
	@FindBy(xpath = "//*[starts-with(@class,'Product-descriptionTab')]")
	WebElementFacade productDescriptionTab;
	
	@FindBy(xpath = "//*[starts-with(@class,'Product-descriptionTab')]/h5")
	WebElementFacade titleHighlight;
	
	@FindBy(xpath = "//*[starts-with(@class,'Product-descriptionTab')]/")
	WebElementFacade productDescription;
	
	@FindBy(xpath = "//*[starts-with(@class,'Product-detailsTab')]")
	WebElementFacade productDetailsTab;
	
	@FindBy(xpath = "//*[starts-with(@class,'Product-detailsTab')]/p/span[contains(text(), 'COUNTRY')]")
	WebElementFacade productCountry;
	
	@FindBy(xpath = "//*[starts-with(@class,'Product-detailsTab')]/p/span[contains(text(), 'LANGUAGE')]")
	WebElementFacade productLanguage;
	
	@FindBy(xpath = "//*[starts-with(@class,'Product-detailsTab')]/p/span[contains(text(), 'PUBLISHER')]")
	WebElementFacade productPublisher;
	
	@FindBy(xpath = "//*[starts-with(@class,'Product-detailsTab')]/p/span[contains(text(), 'AVAILABLE ON')]")
	WebElementFacade productAvailableOn;
	
	
	// Action
	
	public void clickBuyIssue() {
		Logging.info("Click Buy Issue");
		buyIssue.click();
	}
	public void clickSubscribe(boolean subOnly) {
		Logging.info("Click Subscribe");
		Subcribe.click();
		waitABit(1000);
		if(checkBackIssueInSubs()) {
			Logging.info("Have the optiont to select Subcription or Subcription + Back issue");
			if(subOnly) {
				subscriptionOnly.click();
			} else {
				backIssueSubscription.click();
			}
		}
	}
	
	public boolean checkBackIssueInSubs() {
		Logging.info("Check back issue in subscription");
		try {
			return backIssueInSubs.isDisplayed();
		} catch (Exception noSuchElement) {
			return false;
		}
	}
	
	public String getIssueCurrency() {
		String priceIssue =  issuePrices.getText();
		String[] currentPrice = priceIssue.split(" ");
		Logging.info(String.format("Currency of Issue is : %s ", currentPrice[1]));
		return currentPrice[1];
	}
	
	public String getIssuePrice() {
		String priceIssue =  issuePrices.getText();
		String[] currentPrice = priceIssue.split(" ");
		Logging.info(String.format("Prices of Issue is : %s ", currentPrice[0]));
		return currentPrice[0];
	}
	
	public String getSubscribeCurrency() {
		String priceSubscribe =  subPrices.getText();
		String[] currentPrice = priceSubscribe.split(" ");
		Logging.info(String.format("Currency of Subscribe is : %s ", currentPrice[1]));
		return currentPrice[1];
	}
	
	public String getSubscribePrice() {
		String priceSubscribe =  subPrices.getText();
		String[] currentPrice = priceSubscribe.split(" ");
		Logging.info(String.format("Price of Subscribe is : %s ", currentPrice[0]));
		return currentPrice[0];
	}
	
	public String getTotalIssue() {
		String issueData = totalIssue.getText();
		String[]  numberIssue= issueData.split(" ");
		Logging.info(String.format("Total Issue is: %s ", numberIssue[0]));
		return numberIssue[0];
	}
	
	public void clickDescriptionIssue() {
		Logging.info("Click Desctiption Button");
		descriptionButton.click();
	}
	
	public void clickDetailIssue() {
		Logging.info("Click Details Button");
		detailsButton.click();
	}
	
	public void clickPreviosIssue() {
		Logging.info("Click Previous button");
		previousButton.click();
	}
	
	public void clickNextIssue() {
		Logging.info("Click Next button");
		nextButton.click();
	}
	
	public void selectDots(int dotNum) {
		Logging.info(String.format("Select country :  %s", dotNum));
		Select dotsList = new Select(slickDotsList);
		dotsList.selectByIndex(dotNum);
	}
	
	public void gotoViewAllIssue() {
		Logging.info("Click View All button to view all issues	");
		viewAllButton.click();
	}
	
	public String getNameProduct() {
		String name =  productName.getText();
		Logging.info(String.format("Product name is  %s ", name));
		return name;
	}
	
	public String getPublishDay() {
		String day =  publishDay.getText();
		Logging.info(String.format("Publish Product Day is  %s ", day));
		return day;
	}
	
	public String getTitleHighlightIssue() {
		String highlight =  titleHighlight.getText();
		Logging.info(String.format("Title highlight is  %s ", highlight));
		return highlight;
	}
	
	public String getProductDescription() {
		String desciption =  productDescription.getText();
		return desciption;
	}
	
	public String getProductCountry() {
		String countryName =  productCountry.getText();
		Logging.info(String.format("Product Country is  %s ", countryName));
		return countryName;
	}
	
	public String getProductLanguage() {
		String language =  productLanguage.getText();
		Logging.info(String.format("Product Languages is  %s ", language));
		return language;
	}
	
	public String getProductPublisher() {
		String publisher =  productPublisher.getText();
		Logging.info(String.format("Product Publisher is  %s ", publisher));
		return publisher;
	}
	
	public String getProductAvailable() {
		String deviceAvailable =  productAvailableOn.getText();
		Logging.info(String.format("Product Available on  %s ", deviceAvailable));
		return deviceAvailable	;
	}
	
	public void clickOnRecentIssue(String recentIssue)
	{
		Logging.info("Click on Recent Issue");
		recentIssueEl = String.format(recentIssueEl, recentIssue);
		List<WebElement> userNameEl = getDriver().findElements(By.xpath(recentIssueEl));
		userNameEl.get(0).click();
	}
	
	
}

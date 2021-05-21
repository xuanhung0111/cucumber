package com.zinio.android.page;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zinio.web.utilities.Logging;
import com.zinio.zenith.identity.steps.AndroidDriverManager;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;
import net.serenitybdd.core.pages.WebElementFacade;

public class AndroidSearchTabPage extends BasePageAndroid {

	int timeout = 5;

	public AndroidSearchTabPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	String itemView = "//android.widget.TextView[@text='%s']";
	
	// Account Tab
	@FindBy(xpath = "//android.widget.TextView[@text='Search']")
	WebElement searchTab;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/search_src_text")
	WebElement searchField;
	
	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/tv_category_title")
	List<WebElement> listArtcleCategory;
	
	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/tv_publication_name")
	List<WebElement> listPublicationName;
	
	
	// ---------------Action on element-----------------
	
	public void tapOnSearchTap(){
		Logging.info("Click on Search Tab");
		searchTab.click();
	}
	
//	com.zinio.mobile.android.reader.sbx:id/tv_issue_name

	
	public void searchingArticle(String articleName){
		Logging.info("Searching article name : " + articleName);
		searchField.sendKeys(articleName);
		getDriver().pressKeyCode(66);
	}
	
	public void clickOnArticleName(String articleName) {
		Logging.info("Click on article name : " + articleName);
		for (int i = 0; i < listArtcleCategory.size(); i ++) {
			if (listArtcleCategory.get(i).getText().equals(articleName)) {
				listArtcleCategory.get(i).click();
				break;
			}
		}
	}
	
	public void tapPublicationAfterSearching(String publicationName) {
		Logging.info("Tap publication which is presented : " + publicationName);
		itemView = String.format(itemView, publicationName);
		WebElement publication = getDriver().findElement(By.xpath(itemView));
		publication.click();
	}
	
	public boolean checkPublicationIsPresent(String publicationName) {
		Logging.info("Check publication is present : " + publicationName);
		itemView = String.format(itemView, publicationName);
		try {
			return getDriver().findElement(By.xpath(itemView)).isDisplayed();
		} catch (Exception nosuchElement) {
			return false;
		}
		
	}
}

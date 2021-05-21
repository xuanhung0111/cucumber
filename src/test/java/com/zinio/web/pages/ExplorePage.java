package com.zinio.web.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.zinio.web.element.BasePage;
import com.zinio.web.utilities.Logging;

import net.serenitybdd.core.pages.WebElementFacade;

public class ExplorePage extends BasePage {
	public ExplorePage(WebDriver driver) {
		super(driver);
	}
	
	String articleCard = "//*[@class='ExplorePage']//*[@class='ArticleCard']";
	String articleImg = "//*[@class='ArticleCard-image'][contains(@href,'%s')]";
	String articleTitle = "//*[@class='ArticleCard-content']//a[contains(text(), '%s')]";
	
	// Explore page
	
	@FindBy(className = "ExplorePage")
	WebElementFacade explorePage;
		

	// Action
	
	public boolean isExplorePagePresent() {
		Logging.info("Check Explore Page is present");
		try {
			return explorePage.isDisplayed();
		}  catch (Exception noSuchElement) {
			return false;
		}
	}
	
	public int getArticleCard() {
		List<WebElement> articleCardList = getDriver().findElements(By.xpath(articleCard));
		int numArticle = articleCardList.size();
		Logging.info("Num Article Card in the Explore page is: " + numArticle);
		return numArticle;
	}
	
	public void clickOnArticleImage(String articleName) {
		Logging.info("Click on article image: " + articleName);
		String imgEl = String.format(articleImg, articleName);
		getDriver().findElement(By.xpath(imgEl)).click();
	}
	
	public void clickOnArticleTitle(String articleName) {
		Logging.info("Click on article title: " + articleName);
		String titleEl = String.format(articleTitle, articleName);
		getDriver().findElement(By.xpath(titleEl)).click();
	}
	
}

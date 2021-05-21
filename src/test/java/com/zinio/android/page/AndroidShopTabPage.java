package com.zinio.android.page;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
import net.serenitybdd.core.pages.WebElementFacade;

public class AndroidShopTabPage extends BasePageAndroid {

	int timeout = 5;

	public AndroidShopTabPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	String issueCover = "//android.widget.TextView[@text='%s']";
	
	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/send_button")
	WebElement submitBtn;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Shop']")
	WebElement shopTab;
	
	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/tv_view_all")
	List<WebElement> viewAllList;
	
	public void tapOnShop(){
		Logging.info("Tap on SHOP");
		shopTab.click();
	}
	
	public void tapOnIssueCover(String issueName) {
		Logging.info("Tap on issue name: " + issueName);
		issueCover = String.format(issueCover, issueName);
		WebElement issueCoverEl = getDriver().findElement(By.xpath(issueCover));
		issueCoverEl.click();
	}
	
	public void tapOnViewAllLink(String option){
		// There are a lot of viewall link on the screen
		// If option should marked by : EXPLORE, TOPSELLERS, FEATURED, NEWS WEEKLIES
		if (option.equals("EXPLORE")) viewAllList.get(0).click();
		if (option.equals("TOP SELLERS")) viewAllList.get(1).click();
		if (option.equals("FEATURED")) viewAllList.get(2).click();
		if (option.equals("NEWS WEEKLIES")) viewAllList.get(3).click();
	}
	
}

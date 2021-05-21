package com.zinio.android.page;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zinio.config.CreditCard;
import com.zinio.web.data.UserData;
import com.zinio.web.utilities.Logging;
import com.zinio.zenith.identity.steps.AndroidDriverManager;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import net.serenitybdd.core.pages.WebElementFacade;

public class AndroidExploreTabPage extends BasePageAndroid {

	public AndroidExploreTabPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	String itemView = "//android.widget.TextView[@text='%s']";

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/menu_explore")
	WebElement exploreTab;
	
	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/iv_story_image")
	List<WebElement> imageCover;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/tv_title")
	List<WebElement> publicationTitle;
	
	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/tv_publication_name")
	List<WebElement> publicationName;
	
	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/tv_issue_name")
	List<WebElement> issueName;
	
	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/tv_toolbar_title")
	WebElement toolbarTitle;
	
	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/iv_font_size")
	WebElement fontSizeBtn;
	
	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/iv_view_mode")
	WebElement viewMode;
	
	// Action on Elements
	public void tapOnExploreTab() {
		Logging.info("Tap on Explore tab");
		exploreTab.click();
	}
	
	public void tapOnImgCover(int index) {
		Logging.info("Tap on image cover");
		imageCover.get(index).click();
	}
	
	public String getToolbarTitle() {
		Logging.info("Get toolbar title");
		return toolbarTitle.getText();
	}
	
	public void changeFontSize() {
		Logging.info("Change font size article");
		fontSizeBtn.click();
	}
	
	public void changeModeView() {
		Logging.info("Change mode view article");
		viewMode.click();
	}
}

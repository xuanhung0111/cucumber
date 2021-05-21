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
import junit.framework.Assert;
import net.serenitybdd.core.pages.WebElementFacade;

public class AndroidReadPage extends BasePageAndroid {

	public AndroidReadPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	String itemView = "//android.widget.TextView[@text='%s']";

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/menu_read")
	WebElement readTab;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/iv_view_mode")
	WebElement viewMode;

	@FindBy(xpath = "//android.widget.TextView[@text='LIBRARY']")
	WebElement library;

	@FindBy(xpath = "//android.widget.TextView[@text='BOOKMARKS']")
	WebElement bokmarks;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/tv_publication_name")
	List<WebElement> publicationName;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/tv_issue_name")
	List<WebElement> issueName;

	@FindBy(xpath = "//android.widget.TextView[@text='You don’t have any bookmarks yet.']")
	WebElement emptyBookmarks;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/search_action")
	WebElement searchIcon;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/edit_action")
	WebElement editIcon;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/filter_action")
	WebElement filterIcon;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/overview")
	WebElement overviewIcon;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/bookmark_action")
	WebElement bookmarkAction;

	@FindBy(xpath = "//android.widget.TextView[@text='Pages']")
	WebElement pagesOverview;

	@FindBy(xpath = "//android.widget.TextView[@text='Articles']")
	WebElement articleOverview;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/tv_folio_number")
	List<WebElement> pageNumber;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/tv_reader_mode")
	WebElement readerMode;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/progress_bar")
	WebElement progressLoading;

	// Action on Elements

	public void tapOnReadTab() {
		Logging.info("Tap on Read tab");
		readTab.click();
	}

	public void changeModeView() {
		Logging.info("Change mode view article");
		viewMode.click();
	}

	public boolean checkPublicationInLibrary(String publication) {
		Logging.info("Check that publicaiton is saved in Library");
		for (WebElement pubName : publicationName) {
			if (pubName.getText().equals(publication))
				return true;
		}
		return false;
	}

	public boolean isEmptyBookmark() {
		Logging.info("Check that there is no bookmark");
		try {
			return emptyBookmarks.isDisplayed();
		} catch (Exception noSuchElement) {
			return false;
		}
	}

	public void tapOnEditIcon() {
		Logging.info("Click Edit icon on the right top");
		editIcon.click();
	}

	public void tapOnFilterIcon() {
		Logging.info("Tap on Filter Icon");
		filterIcon.click();
	}

	public void tapOnOverviewIcon() {
		Logging.info("Tap on Overview Icon");
		overviewIcon.click();
	}

	public void tapOnBookMarkIcon() {
		Logging.info("Tap on bookmark Icon");
		bookmarkAction.click();
	}

	public void tapOnPagesOverview() {
		Logging.info("Tap on Pages Overview");
		pagesOverview.click();
	}

	public void tapOnArticlePage() {
		Logging.info("Tap on articles page");
		articleOverview.click();
	}

	public void goToPageOverview(String pageNum) {
		Logging.info("Tap on Pages: " + pageNum);
		for (WebElement pagEl : pageNumber) {
			if (pagEl.getText().equals(pageNum))
				pagEl.click();
		}
	}

	public void tapOnReaderMode() {
		Logging.info("Tap on reader mode");
		readerMode.click();
	}

	public void waitProgressLoadingDisappear() {
		Logging.info("Wait progress loading disappear");
		progressLoading.click();
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		} catch (Exception timeOut) {
			Logging.info("ERROR: Cannot find element");
		}
	}

}

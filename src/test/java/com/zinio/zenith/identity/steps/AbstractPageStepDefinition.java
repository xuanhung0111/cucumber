package com.zinio.zenith.identity.steps;

import java.net.MalformedURLException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zinio.web.element.BasePage;
import com.zinio.web.utilities.AssertResult;
import com.zinio.web.utilities.Logging;
import com.zinio.web.utilities.PropertyUtils;

import cucumber.api.java.After;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AbstractPageStepDefinition {

	protected static WebDriver driver;
	protected static AndroidDriver<AndroidElement> androidDiver;

	protected WebDriver getDriver() {
		if (driver == null) {
			driver =  DriverManager.initLocalDriver();
		}
		return driver;
	}

	protected static AndroidDriver<AndroidElement> getAndroidDriver() throws MalformedURLException {
		if (androidDiver == null) {
			androidDiver = AndroidDriverManager.capabilities();
		}
		return androidDiver;
	}

	
	public void afterAllTest() {
		Logging.info("After All Test: close driver. Bye Bye !!!");
		if (driver == null) {
	        return;
	    }
		driver.quit();
		driver = null;
		if (androidDiver != null) {
			androidDiver.closeApp();
		}
	}

	public void openNewWindow() {
		Logging.info("Open new Window");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open();");

	}

	public void refreshPage() {
		Logging.info("Refresh page");
		driver.navigate().refresh();
	}

	public void goToSignInPage() {
		Logging.info("Go to Sign In page");
		driver.navigate().to("https://www-sbx-web.zinio.com/sign-in");
	}

	public void goToSignUpPage() {
		Logging.info("Go to Sign Up page");
		driver.get("https://www-sbx-web.zinio.com/sign-up");
	}

	public void goToHomePage() {
		Logging.info("Go to Home page");
		driver.get("https://www-sbx-web.zinio.com");
	}

	public void goToZenithAdminPage() {
		Logging.info("Go to Zenith Admin page");
		driver.get("https://sbx-admin.zinio.com");
	}

	public void goToGoogle() {
		Logging.info("Go to Google Page");
		driver.get("https://google.com");
	}

	public void dissMissAlert() {
		driver.switchTo().alert().dismiss();
	}

	public void switchToAnyWindow(String window) {
		/*
		 * Need to push WindowHandle string into this method via
		 * driver.getWindowHandle()
		 */
		driver.switchTo().window(window);
	}

	public void waitReady(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void navigateToUrl(String url) {
		Logging.info("Navigate to url: " + url);
		driver.get(url);
		waitPageLoading();
	}

	public void waitPageLoading() {
		new BasePage(driver, "loading icon", "//i[@class='fa fa-spinner']").waitDisappear();
		new BasePage(driver, "loading icon", "//div[@class='loading']").waitDisappear();
		new BasePage(driver, "loading icon", "//div[contains(@class,'loading-wrapper')]").waitDisappear();
		new BasePage(driver, "loading text", "//*[.='loading...']").waitDisappear();
		new BasePage(driver, "loading text", "//*[.='Loading...']").waitDisappear();
		new BasePage(driver, "Website logo", "//img[contains(@src,'logo.png')]").isDisplayed();
	}

	public void waitElementDisplays(BasePage element) {
		int second = 500;
		int timeout = PropertyUtils.getPropAsInt("timeToWaitSelectBox") * 2;
		while (!element.isDisplayed()) {
			refresh();
			waitPageLoading();
			second = second + 500;
			if (second > timeout)
				break;
		}
	}

	public void refresh() {
		Logging.info("Refresh Page");
		driver.navigate().refresh();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public void clickLinkByText(String text) {
		BasePage element = new BasePage(driver, text, "//a[.='" + text + "']");
		element.click();
		waitPageLoading();
	}

	public void clickControlByText(String text) {
		new BasePage(driver, text, "//*[.='" + text + "']").click();
	}

	public void waitMessage(String message) {
		new BasePage(driver, "Message '" + message + "'", "//*[.='" + message + "']").isDisplayed(5);
	}

	public void shouldShowMessage(String message) {
		if (new BasePage(driver, "Message '" + message + "'", "//*[.='" + message + "']").isDisplayed()) {
			AssertResult.pass(">>> \"" + message + "\" displays", true);
		} else {
			AssertResult.fail(">>> \"" + message + "\" does not display", false);
		}
	}

	public void shouldShowText(String... contents) {
		for (String text : contents) {
			if (new BasePage(driver, "Content '" + text + "'", "//*[.='" + text + "']").isDisplayed()) {
				AssertResult.pass(">>> \"" + text + "\" displays", true);
			} else {
				AssertResult.fail(">>> \"" + contents + "\" does not display", false);
			}
		}
	}

	public void shouldNotShowMessage(String... contents) {
		for (String message : contents) {
			new BasePage(driver, "Message '" + message + "'", "//*[.='" + message + "']").shouldNotBeDisplayed();
		}
	}

	public void shouldShowValidationMessage(String message) {
		if (new BasePage(driver, "Message '" + message + "'",
				"//ul[@class='parsley-errors-list']//" + "li[contains(.,'" + message + "')]").isDisplayed()) {
			AssertResult.pass(">>> \"" + message + "\" displays", true);
		} else {
			AssertResult.fail(">>> \"" + message + "\" does not display", false);
		}
	}

	public boolean check(String description, Object actualValue, Object expectedValue) {
		Logging.info("Compare with actual value: " + actualValue.toString() + " & expected value: "
				+ expectedValue.toString());
		if (actualValue.equals(expectedValue)) {
			Logging.info(">>> " + description);
			return true;
			// AssertResult.pass(">>> \"" + description + "\" displays", true);
		} else {
			String message = description + " - Actual: " + actualValue;
			// AssertResult.fail("Test is FAILED >>> " + message , false);
			Logging.info(">>> " + message);
			return false;
		}
	}

	public void checkAdmin(String description, Object actualValue, boolean isPassed) {
		if (isPassed) {
			AssertResult.pass(">>> " + description, true);

		} else {
			String message = description + " - Actual: " + actualValue;
			AssertResult.fail("Test is FAILED  >>> " + message, false);
		}
	}

	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
			Logging.info("Accept alert!");
		} catch (Exception e) {
			System.out.println("No alert");
		}
	}

	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException exception) {

		}
	}

//	public boolean waitForJSandJQueryToLoad() {
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//
//		// wait for jQuery to load
//		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
//			@Override
//			public Boolean apply(WebDriver webDriver) {
//				try {
//					return ((Long) ((JavascriptExecutor) DriverManager.getDriver())
//							.executeScript("return jQuery.active") == 0);
//				} catch (Exception e) {
//					return true;
//				}
//			}
//		};
//
//		// wait for Javascript to load
//		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
//			@Override
//			public Boolean apply(WebDriver webDriver) {
//				try {
//					return (((JavascriptExecutor) DriverManager.getDriver()).executeScript("return document.readyState")
//							.toString().equals("complete"));
//				} catch (Exception e) {
//					return true;
//				}
//			}
//		};
//
//		return wait.until(jQueryLoad) && wait.until(jsLoad);
//	}

	public void scrollUp() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)", "");
	}

	public void goToLandingPage(String type) {
		String pageTitle = new BasePage(driver, "Page Title", "//h1").getText();
		if (pageTitle != type) {
			clickLinkByText(type);
		}
	}

	public void scrollDown() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void logOut() {
		BasePage logoutLink = new BasePage(driver, "Logout link", "//a[.='Sign out']");
		if (logoutLink.isPresent())
			logoutLink.clickByJavascript();
		waitPageLoading();
	}

	public void backOnBrowser() {
		driver.navigate().back();
	}

	public void openNewTabWithURL(String url) {
		((JavascriptExecutor) driver).executeScript("window.open();", "");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		switchToWindow(tabs.get(1));
		driver.get(url);
	}

	public void openNewTabWithURL() {
		((JavascriptExecutor) driver).executeScript("window.open();", "");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		switchToWindow(tabs.get(tabs.size() - 1));
	}

	public void switchToWindow(String windowName) {
		driver.switchTo().window(windowName);
	}

	public void closeCurrentTab(String windowName, String parentWindow) {
		switchToWindow(windowName);
		driver.close();
		switchToWindow(parentWindow);
	}

	public void switchToNewTabWindow(boolean lastTab) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		if (lastTab) {
			switchToWindow(tabs.get(tabs.size() - 1));
		} else {
			switchToWindow(tabs.get(0));
		}

	}
	
	public String getRandomNumber() {
		DateFormat dateFormat = new SimpleDateFormat("HHmmss");
		Date date = new Date();
		return dateFormat.format(date); 
	}

}

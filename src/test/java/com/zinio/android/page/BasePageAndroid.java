package com.zinio.android.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zinio.web.utilities.Logging;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import junit.framework.Assert;

public class BasePageAndroid {
	
	AndroidDriver<AndroidElement> driver;
	String itemView = "//android.widget.TextView[@text='%s']";

	public BasePageAndroid(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	 public AndroidDriver<AndroidElement> getDriver() {
	        return driver;
	    }
	 
	public void rightLeftSwipe(int timeduration) {

		Dimension size = driver.manage().window().getSize();
		int startx = (int) (size.width * 0.70);
		int endx = (int) (size.width * 0.30);
		int starty = size.height / 2;
		driver.swipe(startx, starty, endx, starty, timeduration);

	}

	public void leftRightSwipe(int timeduration) {
		// duration should be in milliseconds
		Dimension size = driver.manage().window().getSize();
		int startx = (int) (size.width * 0.70);
		int endx = (int) (size.width * 0.30);
		int starty = size.height / 2;
		driver.swipe(endx, starty, startx, starty, timeduration);
	}
	
	public void waitReady(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void tapOnBackBtn() {
		driver.pressKeyCode(AndroidKeyCode.BACK);
	}
	
	public void scrollToView(String textView) {
		String uiautomator ="new UiScrollable(new UiSelector()).scrollIntoView(text(\"%s\"));";
		uiautomator = String.format(uiautomator, textView);
		driver.findElementByAndroidUIAutomator(uiautomator);
	}
	
	public void scrollDownToViewAllItem(String expectedString) {
		getDriver().findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ expectedString + "\").instance(0))");
	}
	
	public void tapOnPublication(String publicationName) {
		Logging.info("Tap on publication or issue : " + publicationName);
		scrollDownToViewAllItem(publicationName);
		itemView = String.format(itemView, publicationName);
		WebElement publication = getDriver().findElement(By.xpath(itemView));
		publication.click();
	}
	
}
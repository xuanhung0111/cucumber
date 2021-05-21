package com.zinio.web.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.zinio.web.element.BasePage;
import com.zinio.web.utilities.Logging;

import net.serenitybdd.core.pages.WebElementFacade;

public class SettingPage extends BasePage {

	public SettingPage(WebDriver driver) {
		super(driver);
	}

	public enum SettingMenu {
		ACCOUNT_INFO("Account information"), PAYMENT_INFO("Payment information"), SUBCRIPTIONS(
				"Subscriptions"), PREFERENCES("Preferences");

		private final String info;

		SettingMenu(String code) {
			this.info = code;
		}

		public String getInfo() {
			return this.info;
		}
	}
	
	String subList = "//*[@class='Publication-name' and contains(text(), '%s')]";
	
	/*
	 * *****Declaration Elements ****
	 */
	// Menu setting

	@FindBy(xpath = "//*[@class='SettingsMenu']//a[contains(text(),'Account information')]")
	WebElementFacade accountInfor;

	//@FindBy(xpath = "//*[@class='SettingsMenu']//a[contains(text(),'Payment information')]")
	@FindBy(id = "accountMenu-payment")
	WebElementFacade paymentInfor;

	@FindBy(id = "accountMenu-subscriptions")
	WebElementFacade subcription;

	@FindBy(id = "accountMenu-prefereneces")
	WebElementFacade preferences;

	// Account Information : Change Password

	@FindBy(id = "currentPassword")
	WebElementFacade currentPassword;

	@FindBy(id = "newPassword")
	WebElementFacade newPassword;

	@FindBy(id = "confirmNewPassword")
	WebElementFacade confirmNewPassword;

	@FindBy(id = "preference-saveButton")
	WebElementFacade saveButton;

	// Preferences

	@FindBy(id = "marketing")
	WebElementFacade emailPreferencesCheckBox;
	
	@FindBy(id = "marketingLabel")
	WebElementFacade emailPreferences;

	@FindBy(id = "allowAdultLabel-1")
	WebElementFacade allowAdultButton;

	@FindBy(id = "allowAdultLabel-0")
	WebElementFacade rejectAdultButton;

	@FindBy(xpath = "//*[@class='Panel-submitButton u-Button' and contains(text(), 'SAVE')]")
	WebElementFacade savePreferences;

	@FindBy(className = "Publication-info")
	List<WebElement> publicationInfo;
	
	/*
	 * *****Below are all actions happen on Setting Page ****
	 */
	// Actions on Menu Setting elements

	public void goToAcountSettingPage() {
		Logging.info("Go to Account Setting Page");
		accountInfor.click();
	}

	public void goToPaymentPage() {
		Logging.info("Go to Payment Page");
		paymentInfor.click();
	}

	public void goToSubriptions() {
		Logging.info("Go to Subcriptions");
		subcription.click();
	}

	public void goToReferences() {
		Logging.info("Go to References");
		preferences.click();
	}

	public void enterCurrentPassword(String Password) {
		Logging.info("Fill in Current Password in text box");
		currentPassword.sendKeys(Password);
	}

	public void enterNewPassword(String Password) {
		Logging.info("Fill in New Password in text box");
		newPassword.sendKeys(Password);
	}

	public void enterConfirmPassword(String Password) {
		Logging.info("Fill in New Password in text box to confirm");
		newPassword.sendKeys(Password);
	}

	public void clickSaveButton() {
		Logging.info("Click on Save button");
		saveButton.click();
	}

	// Actions on Preferences
	
	public void getCurrentColor()
	{
		Logging.info(emailPreferences.getCssValue("color"));
		
		if (emailPreferences.getCssValue("color").equalsIgnoreCase("rgba(3, 169, 244, 1)")) {
			Logging.info("Color is matched");
		}
		else
		{
			Logging.info("NOOOOOO!");
		}
	}

	public void selectSendEmail(Boolean Selected) {
		Logging.info(String.format("Send to me email updates: %s", Selected));
		if (Selected == true) {
			if (emailPreferences.getCssValue("color").equalsIgnoreCase("rgba(0, 0, 0, 0.54)")) {
				emailPreferences.click();
			}
		} 
		else {
			if (emailPreferences.getCssValue("color").equalsIgnoreCase("rgba(3, 169, 244, 1)")) {
				emailPreferences.click();
			}
		}
		
		// Because the checkbox is hidden in the code, must use color to identify the check box is checked or not
		// Checked: rgba(3, 169, 244, 1) emailPreferencesCheckBox.isSelected() == false
		// Unchecked: rgba(0, 0, 0, 0.54) emailPreferencesCheckBox.isSelected() == true
	}
	
	public boolean sendEmailCheckboxStatus()
	{
		if (emailPreferences.getCssValue("color").equalsIgnoreCase("rgba(3, 169, 244, 1)"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void allowAdultContent() {
		Logging.info("Allowed Adult contents");
		allowAdultButton.click();
	}

	public void rejectAdultContent() {
		Logging.info("Allowed Adult contents");
		rejectAdultButton.click();
	}

	public void savePreferenceSetting() {
		Logging.info("Click Save button");
		savePreferences.click();
	}
	
	public boolean checkSubcriptionInList(String subcriptionName) {
		subList = String.format(subList, subcriptionName);
		try {
			System.out.println("----Go inside here----- : + Subscription name is " + subcriptionName);
			return getDriver().findElement(By.xpath(subList)).isDisplayed();
		} catch (Exception noSuchElement) {
			System.out.println("Cannot find element");
			return false;
		}
	}
	
	public String getStatusSubcription(String subcriptionName) {
		String currentStatus = "";
		for(int i =0; i<publicationInfo.size(); i++) {
			try{
				String currentSubcription =  publicationInfo.get(i).findElement(By.xpath("//*[@class='Publication-name']")).getText();
				if (currentSubcription.equals(subcriptionName)) {
					currentStatus=  publicationInfo.get(i).findElement(By.xpath("//*[@class='Publication-status']")).getText();
					Logging.info("Publication status is " + currentStatus);
				}
			} catch (Exception noSuchElement) {
				return "null";
			}
		}
		return currentStatus;
	}
	
	
	public String getPublicationAtutoRenew(String subcriptionName) {
		String autoRenew = "";
		for(int i =0; i<publicationInfo.size(); i++) {
			try{
				String currentSubcription =  publicationInfo.get(i).findElement(By.xpath("//*[@class='Publication-name']")).getText();
				if (currentSubcription.equals(subcriptionName)) {
					autoRenew =  publicationInfo.get(i).findElement(By.xpath("//*[@class='Publication-autoRenew']")).getText();
					Logging.info("Publication autoRenew is " + autoRenew);
				}
			} catch (Exception noSuchElement) {
				return "null";
			}
		}
		return autoRenew;
	}

	public void findHiddenCheckbox()
	{
		emailPreferencesCheckBox.isDisplayed();
	}
	
	
	
}

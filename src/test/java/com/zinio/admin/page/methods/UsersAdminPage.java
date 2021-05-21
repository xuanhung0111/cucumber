package com.zinio.admin.page.methods;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zinio.admin.ui.DetailPageObject;
import com.zinio.admin.ui.LandingPageObject;
import com.zinio.admin.ui.LoginPageObject;
import com.zinio.web.data.UserData;
import com.zinio.web.utilities.Logging;

import net.serenitybdd.core.annotations.findby.By;

public class UsersAdminPage {
	WebDriver driver;
	public String parentWindow, currentWindow;
	LandingPageObject landingPageObject;
	DetailPageObject detailPageObject;;

	public UsersAdminPage(WebDriver driver) {
		this.driver = driver;
		landingPageObject = new LandingPageObject(this.driver);
		detailPageObject = new DetailPageObject(this.driver);
	}

	public void clickOnUserTab() {
		Logging.info("Click on User Menu");
		landingPageObject.userTab.click();
	}

	public void enterSearchEmail(String userName) {
		Logging.info("Enter Email to text field then press Enter button");
		landingPageObject.txtContaintSearch.setText(userName);
		try {
			Thread.sleep(2000);
			landingPageObject.txtContaintSearch.pressKey(Keys.ENTER);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void changeStatus(String statusUser) {
		Logging.info("Switch status user -> " + statusUser);
		landingPageObject.status.click();
		landingPageObject.status.loadElement()
				.findElement(By.xpath(String.format("//li[contains(text(), '%s')]", statusUser))).click();
	}

	public void clickMergeToBtn() {
		Logging.info("Click Merge Button");
		landingPageObject.mergeToBtn.click();
	}

	public void clickMergeBtn() {
		Logging.info("Click on Merge Btn");
		landingPageObject.mergeBtn.click();
	}

	public void checkMergerEmail() {
		Logging.info("Check Merge Email");
		landingPageObject.emailChecked.click();
	}

	public void clickConfirmBtn() {
		Logging.info("Click on Confirm Btn");
		landingPageObject.confirmBtn.click();
	}

	public void enterEmail(String emailAddress) throws InterruptedException {
		Logging.info("Enter the email in the text field: " + emailAddress);
		Thread.sleep(3000);
		landingPageObject.txtEmail.clear();
		landingPageObject.txtEmail.setText(emailAddress);
	}

	public void clickSaveBtn() {
		Logging.info("Click Save Button");
		landingPageObject.saveBtn.click();
	}

	public boolean checkConfirmPopup() {
		Logging.info("Check Confirm Disabled User Pop Up");
		try {
			Logging.info("Confirm: " + landingPageObject.confirmDisabled.isDisplayed());
			return landingPageObject.confirmDisabled.isDisplayed();
		} catch (Exception e) {
			Logging.info("Confirm: false");
			return false;
		}
	}

	public void clickOnDisableUser() {
		Logging.info("Click on Disabled User");
		landingPageObject.disableUserBtn.click();
	}

	public boolean isAllowAdultContent() {
		Logging.info("Is Allow Adult content : " + landingPageObject.allowAdultContent.isSelected());
		return landingPageObject.allowAdultContent.isSelected();
	}

	public List<Map<String, String>> getItemsTable(String tableName) {
		return landingPageObject.getItemsTable(tableName);
	}

	public List<Map<String, WebElement>> getEmailHref() {
		Logging.info("Get Email Information");
		return landingPageObject.getItemsTable("Email Table", true);
	}

	public void enterEmailToSearchField(String emailAddress) {
		Logging.info("Enter Email to search Field");
		landingPageObject.txtSearchEmail.setText(emailAddress);
		landingPageObject.txtSearchEmail.pressKey(Keys.ENTER);
	}

	public void clickOrdersTab() {
		Logging.info("Click on Orders Tab");
		landingPageObject.ordersTab.click();
	}

	public void clickIssueSubTab() {
		Logging.info("Click on Issue Subscriptions Tab");
		landingPageObject.issueSubTab.click();
	}
	
	public void clickEntitlementsTab() {
		Logging.info("Click on Entitlements Tab");
		landingPageObject.entitlementTab.click();
	}

	public void clickOnGeneralTab() {
		Logging.info("Click on General Information Tab");
		landingPageObject.generalInfoTab.click();
	}

	public void clickReferencesTab() {
		Logging.info("Click on References Tab ");
		landingPageObject.preferencesTab.click();
	}

	public void clickPaymentProfileTab() {
		Logging.info("Click on Payment Profile Tab ");
		landingPageObject.paymentProfileTab.click();
	}

	public void selectProjectReferences(String projectName) {
		String selectProject = "//*[@id='user-tab___pane___preferences']//li[@title='%s']";
		Logging.info(String.format("Select Project Name :  %s", projectName));
		landingPageObject.projectPreferencesTab.click();
		selectProject = String.format(selectProject, projectName);
		driver.findElement(By.xpath(selectProject)).click();
	}

	public boolean isEmailUpdate() throws InterruptedException {
		Logging.info("Check that Email is updated or not in References Tab");
		Thread.sleep(1000);
		return landingPageObject.updateEmailCheckbox.getChild("hidden object", "/preceding-sibling::input")
				.loadHiddenElement().isSelected();
	}

	public void selectAllowAdultContent() {
		Logging.info("Select Allow Adult Content");
		landingPageObject.adultRadioButton.click();
	}

	public void rejectAllowAdultContent() {
		Logging.info("Reject Allow Adult Content");
		landingPageObject.notAdultRadioButton.click();
	}

	public boolean checkDefaultPaymentProfile() {
		Logging.info("Checking payment profile");
		if (!detailPageObject.paymentFirstName.getText().equals(UserData.FIRST_NAME))
			return false;
		if (!detailPageObject.paymentLastName.getText().equals(UserData.LAST_NAME))
			return false;
		if (!detailPageObject.paymentZipCode.getText().equals(UserData.ZIPCODE))
			return false;
		if (!detailPageObject.paymentCountry.getText().equals(UserData.COUNTRY))
			return false;
		if (!detailPageObject.paymentHandler.getText().equals("Zenith Braintree"))
			return false;
		if (!detailPageObject.paymentCardProvider.getText().equals("Visa"))
			return false;
		if (!detailPageObject.paymentCardNumber.getText().equals("xxxx-xxxx-xxxx-1111"))
			return false;
		if (!detailPageObject.paymentExpirationDate.getText().equals(UserData.EXPIRE_DATE))
			return false;
		return true;
	}

	public boolean checkEditedPaymentProfile() {
		Logging.info("Checking payment profile");
		if (!detailPageObject.paymentFirstName.getText().equals(UserData.NEW_CREDIT_CARD_INFO[0]))
			return false;
		if (!detailPageObject.paymentLastName.getText().equals(UserData.NEW_CREDIT_CARD_INFO[1]))
			return false;
		if (!detailPageObject.paymentZipCode.getText().equals(UserData.NEW_CREDIT_CARD_INFO[7]))
			return false;
		if (!detailPageObject.paymentCountry.getText().equals("Albania"))
			return false;
		if (!detailPageObject.paymentHandler.getText().equals("Zenith Braintree"))
			return false;
		if (!detailPageObject.paymentCardProvider.getText().equals("MasterCard"))
			return false;
		if (!detailPageObject.paymentCardNumber.getText().equals("xxxx-xxxx-xxxx-4444"))
			return false;
		if (!detailPageObject.paymentExpirationDate.getText().equals(UserData.NEW_CREDIT_CARD_INFO[3]))
			return false;
		return true;
	}

	public boolean checkNotFoundPaymentProfile() {
		Logging.info("Checking payment profile");
		return landingPageObject.notFoundIcon.isDisplayed();
	}

	public void emailUpdate(boolean updated) throws InterruptedException {
		System.out.println("-----Go inside------");
		// System.out.println("-----" +
		// landingPageObject.allowAdultContent.isDisabled());
		// System.out.println("-----" +
		// landingPageObject.allowAdultContent.isSelected());

		landingPageObject.userOrdersTab.click();

		// Thread.sleep(2000);
		// landingPageObject.rejectAdultContent.click();
		// Thread.sleep(2000);
		//
		// landingPageObject.allowAdultContent.click();

		// landingPageObject.emailUpdate.click();
		// if (updated == true) {
		// if (landingPageObject.emailUpdate.isSelected() == false) {
		// landingPageObject.emailUpdate.click();
		// }
		// } else {
		// if (landingPageObject.emailUpdate.isSelected() == true) {
		// landingPageObject.emailUpdate.click();
		// }
		// }
	}

	public void waitReady(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public Map<String, String> getUserInformation() {
		Logging.info("Get User Information");
		waitReady(5000);
		return  landingPageObject.getUserInformation();
		
	}
	
	public Map<String, String> getPaymentProfile() {
		Logging.info("Get Payment Profile");
		waitReady(2000);
		return  landingPageObject.getPaymentProfile();
		
	}
	
}

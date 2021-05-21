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

public class AndroidProductPage extends BasePageAndroid {

	private CreditCard creditCardInfo;

	public AndroidProductPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		creditCardInfo = new CreditCard(UserData.FIRST_NAME, UserData.LAST_NAME, UserData.CART_NUMBER, UserData.CVV,
				"2030", "12", UserData.ADDRESS, UserData.CITY, UserData.ZIPCODE, UserData.COUNTRY);
	}

	String itemView = "//android.widget.TextView[@text='%s']";

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/toolbar_title")
	WebElement toolbarTitle;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/buy_button")
	WebElement buyIssueBtn;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/subscribe_button")
	WebElement subscribeBtn;

	@FindBy(xpath = "//android.widget.Button[@text='Cancel']")
	WebElement cancelSubcribe;

	@FindBy(xpath = "//android.widget.Button[@text='Subscribe']")
	WebElement confirmSubcribe;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/buy_price")
	WebElement issuePrice;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/subscribe_disc_price")
	WebElement subscribePrice;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/subscribe_description")
	WebElement totalIssue;

	// --------Elements on Payment Information section------------

	@FindBy(xpath = "//android.widget.TextView[@text='Payment Information']")
	WebElement paymentTitle;

	@FindBy(xpath = "//android.widget.RadioButton[@text='Credit or Debit card']")
	WebElement creditCardOrDebitCard;
	
	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/card_first_name_field")
	WebElement firstNameField;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/last_name_tip")
	WebElement lastNameField;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/card_number_field")
	WebElement cardNumberField;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/spinner_expires_on_month")
	WebElement monthDropdown;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/spinner_expires_on_year")
	WebElement yearDropdown;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/card_cvv_field")
	WebElement cvvField;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/radio_paypal")
	WebElement paypalRadio;
	
	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/btn_paypal")
	WebElement paypalLabel;
	
	@FindBy(id = "email")
	WebElement emailField;

	@FindBy(id = "password")
	WebElement passwordField;
	
	@FindBy(id = "btnLogin")
	WebElement loginPaypalBtn;
	
	@FindBy(id = "confirmButtonTop")
	WebElement agreeAndContinue1;
	
	@FindBy(xpath = "//android.widget.Button[@text='Agree & Continue']")
	WebElement agreeAndContinue;
	
	@FindBy(id = "com.android.chrome:id/close_button")
	WebElement closeBrowser;
	
	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/address_field")
	WebElement addressField;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/city_field")
	WebElement cityField;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/zip_post_code_field")
	WebElement zipCodeField;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/sp_country")
	WebElement countryField;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/sp_province")
	WebElement provinceField;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/btn_cancel")
	WebElement cancelBtn;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/btn_save")
	WebElement saveBtn;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/btn_continue")
	WebElement purchaseBtn;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/tl_payment_info")
	WebElement paymentInfo;

	// --------Elements on Thank you section------------

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/card_publication_data")
	WebElement cardPublicationData;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/read_button")
	WebElement readIssueBtn;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/back_button")
	WebElement backToShopBtn;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/thank_you_message")
	WebElement thankyouMessage;
	
	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/tv_publication_name")
	WebElement publicationName;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/tv_total_price")
	WebElement totalOrderPrice;

	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/tv_order_contains_content")
	WebElement orderIssueContent;

	// Recent issues 
	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/tv_view_all")
	WebElement viewAllLink;
	
	@FindBy(id = "com.zinio.mobile.android.reader.sbx:id/iv_cover")
	List<WebElement> issueCover;

	// Action on Elements

	public void tapOnBuyIssue() {
		Logging.info("Tap on BUY ISSUE");
		buyIssueBtn.click();
	}

	public void tapOnSubscribe() {
		Logging.info("Tap on SUBSCRIBE");
		subscribeBtn.click();
	}

	public void tapOnCancelSubscribe() {
		Logging.info("Tap on CANCEL SUBSCRIBE");
		cancelSubcribe.click();
	}

	public void tapOnConfirmSubscribe() {
		Logging.info("Tap on CONFIRM SUBSCRIBE");
		try {
			if(confirmSubcribe.isDisplayed()) {
				confirmSubcribe.click();
			}
		} catch (Exception noSuchElement) {
		}
		
	}

	public String getIssueCurrency() {
		Logging.info("Get Currency Issue type");
		int lengthCurerncy =issuePrice.getText().length();
		System.out.println(">>>> Type of currency is " + issuePrice.getText().substring(lengthCurerncy-2, lengthCurerncy));
		return issuePrice.getText().substring(lengthCurerncy-2, lengthCurerncy);
	}

	public String getSubcCurrency() {
		Logging.info("Get Currency Subcription type");
		int lengthCurerncy =subscribePrice.getText().length();
		System.out.println(">>>> Type of currency is " + subscribePrice.getText().substring(lengthCurerncy-2, lengthCurerncy));
		return subscribePrice.getText().substring(lengthCurerncy-2, lengthCurerncy);
		
	}

	public String getIssuePrice(){
		Logging.info("Get Issue price");
		Pattern p = Pattern.compile("\\d*\\,\\d+");
	    Matcher m = p.matcher(issuePrice.getText());
	    while(m.find()){
	        return m.group();
	    }
		return issuePrice.getText();
	}

	public String getSubcribePrice() {
		Logging.info("Get Subcribe price");
		Pattern p = Pattern.compile("\\d*\\,\\d+");
	    Matcher m = p.matcher(subscribePrice.getText());
	    while(m.find()){
	        return m.group();
	    }
		return subscribePrice.getText();
	}

	public String getTotalIssueInSubcribe() {
		Logging.info("Get total issue in Subscribe");
		return totalIssue.getText().split(" ")[1];
	}

	// -------------- Payment Information-------------------------

	public boolean isPaymentProfilePresent() {
		Logging.info("Check payment profile is present or not");
		try {
			return (paymentTitle.isDisplayed() && creditCardOrDebitCard.isDisplayed());

		} catch (Exception noSuchElement) {
			return false;
		}
	}

	public boolean isPaymentExisted() {
		Logging.info("Check payment profile is existed or not");
		try {
			return paymentInfo.isDisplayed();

		} catch (Exception noSuchElement) {
			return false;
		}
	}

	public boolean isPurchaseBtnPresent() {
		Logging.info("Check purchase button is present or not");
		try {
			return purchaseBtn.isDisplayed();

		} catch (Exception noSuchElement) {
			return false;
		}
	}

	public void selectCreditCardMethod() {
		Logging.info("Select credit card method");
		creditCardOrDebitCard.click();
	}

	public void fillInFirstName(String firstName) {
		Logging.info("Fill in first name: " + firstName);
		firstNameField.clear();
		firstNameField.sendKeys(firstName);
	}

	public void fillInLastName(String lastName) {
		Logging.info("Fill in last name: " + lastName);
		lastNameField.clear();
		lastNameField.sendKeys(lastName);
	}

	public void fillInCartNumber(String cardNumber) {
		Logging.info("Fill in card number  " + cardNumber);
		cardNumberField.sendKeys(cardNumber);
	}

	public void selectPaypalMethod() {
		Logging.info("Select paypal method");
		paypalRadio.click();
	}
	
	public void tapOnPaypalLable() {
		Logging.info("Tap on paypal lable");
		paypalLabel.click();
		waitReady(30000);
	}
	
	public void inputEmailPaypal(String emailPaypal) {
		Logging.info("Input email paypal address");
		emailField.clear();
		emailField.sendKeys(emailPaypal);
	}

	public void inputPasswordPaypal(String password) {
		Logging.info("Input password paypal address");
		passwordField.clear();
		passwordField.sendKeys(password);
	}
	
	public void tapOnLoginPaypalBtn() {
		Logging.info("Tap on login button");
		loginPaypalBtn.click();
		waitReady(30000);
	}
	
	public void tapOnAgreeAndCountinueBtn() {
		Logging.info("Tap on Agree and Countinue button");
		try {
//			TouchAction t = new TouchAction(getDriver());
//			t.press(agreeAndContinue).perform();
//			agreeAndContinue1.click();
			Logging.info("Display or not :" + agreeAndContinue.isDisplayed());
			agreeAndContinue.click();
		} catch (Exception noSuchElement) {
			agreeAndContinue.click();
			agreeAndContinue1.click();
		}
		waitReady(30000);
	}
	
	public boolean isLoginPaypalBefore()
	{
		Logging.info("Check that user already login before");
		try {
			return agreeAndContinue.isDisplayed();
		} catch (Exception noSuchElement){
			return false;
		}
	}
	
	public void closeBrowser() {
		Logging.info("Closing browser...");
		closeBrowser.click();
	}
	
	public void selectMonth(String month) {
		Logging.info("Select month is: " + month);
		monthDropdown.click();
		String monthView = String.format(itemView, month);
		scrollDownToViewAllItem(month);
		WebElement monthObj = getDriver().findElement(By.xpath(monthView));
		monthObj.click();

	}

	public void selectYear(String year) {
		Logging.info("Select year is: " + year);
		yearDropdown.click();
		String yearView = String.format(itemView, year);
		scrollDownToViewAllItem(year);
		WebElement yearObj = getDriver().findElement(By.xpath(yearView));
		yearObj.click();
	}

	public void fillInCVVField(String cvv) {
		Logging.info("Fill in cvv field " + cvv);
		cvvField.sendKeys(cvv);
	}

	public void selectCountryName(String countryName) {
		Logging.info("Select country name is: " + countryName);
		String countryView = String.format(itemView, countryName);
		if (countryName.equals("VietNam")) {
			countryField.click();
			scrollDownToViewAllItem(countryName);
			WebElement countryObj = getDriver().findElement(By.xpath(countryView));
			countryObj.click();
		}
	}

	public void selectProvinceName(String province) {
		Logging.info("Select Province name is: " + province);
		provinceField.click();
		scrollDownToViewAllItem(province);
		String provinceView = String.format(itemView, province);
		WebElement provinceEl = getDriver().findElement(By.xpath(provinceView));
		provinceEl.click();
	}

	@Override
	public void scrollDownToViewAllItem(String expectedString) {
		getDriver().findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ expectedString + "\").instance(0))");
	}

	public void fillInAddress(String address) {
		Logging.info("Fill in address: " + address);
		addressField.sendKeys(address);
	}

	public void fillInCity(String city) {
		Logging.info("Fill in city: " + city);
		cityField.sendKeys(city);
	}

	public void fillInZipCode(String zipCode) {
		Logging.info("Fill in Zip Code: " + zipCode);
		zipCodeField.sendKeys(zipCode);
	}

	public void tapOnCancelBtn() {
		Logging.info("Tap on Cancel Button");
		cancelBtn.click();
	}

	public void tapOnSaveBtn() {
		Logging.info("Tap on Save Button");
		saveBtn.click();
	}

	public void tapOnPuchaseBtn() {
		Logging.info("Tap on Purchase Button");
		purchaseBtn.click();
	}

	public void inputProceedThePayment() {
		Logging.info("Proceed fill in purchase method");
		selectCreditCardMethod();
		fillInFirstName(creditCardInfo.getFirstName());
		fillInLastName(creditCardInfo.getLaseName());
		fillInCartNumber(creditCardInfo.getCreditCardNumber());
		selectMonth("12");
		selectYear("2030");
		fillInCVVField(creditCardInfo.getCvv());
		fillInAddress(creditCardInfo.getAddress());
		fillInCity(creditCardInfo.getCity());
		fillInZipCode(creditCardInfo.getZipCode());
		selectCountryName(creditCardInfo.getCountry());
		tapOnSaveBtn();
		waitReady(5000);
	}

	public void updateThePayment() {
		Logging.info("Updating the payment method");
		fillInFirstName(UserData.NEW_CREDIT_CARD_INFO[0]);
		fillInLastName(UserData.NEW_CREDIT_CARD_INFO[1]);
		fillInCartNumber(UserData.NEW_CREDIT_CARD_INFO[2]);
		selectMonth("08");
		selectYear("2031");
		fillInCVVField(creditCardInfo.getCvv());
		tapOnSaveBtn();
		waitReady(5000);
	}
	
	public void addPaymentByPaypalMethod() {
		Logging.info("Adding payment by palpal method");
		selectPaypalMethod();
		tapOnPaypalLable();
		if(!isLoginPaypalBefore()) {
			Logging.info("There is no payment paypal method");
			inputEmailPaypal("xuanhung.nguyen-buyer@zinio.com");
			inputPasswordPaypal("Xu@nhu0ng");
			tapOnLoginPaypalBtn();
		}
		tapOnAgreeAndCountinueBtn();
		fillInAddress(creditCardInfo.getAddress());
		fillInCity(creditCardInfo.getCity());
		fillInZipCode(creditCardInfo.getZipCode());
		selectCountryName(creditCardInfo.getCountry());
		tapOnSaveBtn();
		waitReady(5000);
	}
	
	public String getTitleToolbar() {
		Logging.info("Get title toolbar");
		return toolbarTitle.getText();
	}

	public boolean isThankYouPagePresent() {
		Logging.info("Check Thank you page is present or not");
		try {
			if (!getTitleToolbar().equals("Thank you"))
				return false;
			return thankyouMessage.isDisplayed();
		} catch (Exception noSuchElement) {
			Logging.info("Thank you page is NOT present");
			return false;
		}
	}

	public void tapOnBackToShop() {
		Logging.info("Tap on Back To Shop");
		backToShopBtn.click();
	}
	
	public void tapOnViewAllLink() {
		Logging.info("Tap on View All Link");
		viewAllLink.click();
	}
	
	public void tapOnRecentPublication(int index) {
		Logging.info("Tap on recent publication");
		issueCover.get(index).click();
	}
	
}

package com.zinio.web.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zinio.web.element.BasePage;
import com.zinio.web.utilities.Logging;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;

public class PaymentInfoPage extends BasePage {

	public PaymentInfoPage(WebDriver driver) {
		super(driver);
	}
	/*
	 * *****Declaration Elements ****
	 */
	
	// Purchase with
	
	@FindBy(id = "cartMethodLabel-0")
	WebElementFacade purchaseCartMethod;
	
	@FindBy(id = "paypalMethodLabel-0")
	WebElementFacade purchasePaypalMethod;
	
	@FindBy(id = "payment-editButton")
	WebElementFacade paymentEditBtn;
	
	@FindBy(id = "payment-deleteButton")
	WebElementFacade paymentDeleteBtn;
	
	@FindBy(id = "okButton")
	WebElementFacade confirmDeleteBtn;
	
	@FindBy(id = "cancelButton")
	WebElementFacade confirmCancelBtn;
	
	@FindBy(id = "modal-closeButton")
	WebElementFacade closeModalBtn;
	
	
	// Payment Information

	@FindBy(xpath = "//*[@class='RadioInput-label' and contains (text(), \"Credit Card\")]")
	WebElementFacade creditCard;

	@FindBy(name = "payment.name")
	WebElementFacade firstNameField;

	@FindBy(name = "payment.lastname")
	WebElementFacade lastNameField;

	@FindBy(id = "credit-card-number")
	WebElementFacade cardNumberField;

	@FindBy(id = "expiration")
	WebElementFacade expireDayField;

	@FindBy(id = "cvv")
	WebElementFacade cvvField;

	@FindBy(name = "payment.address")
	WebElementFacade addressField;

	@FindBy(name = "payment.city")
	WebElementFacade cityField;

	@FindBy(name = "payment.postal_code")
	WebElementFacade zipCode;

	@FindBy(name = "payment.country")
	WebElementFacade countrySelection;
	
	@FindBy(id = "payment-saveButton")
	WebElementFacade saveCreditBtn;
	
	@FindBy(id = "cart-removeItemButton")
	WebElementFacade removeItemBtn;
	
	@FindBy(xpath = "//*[contains(text(), 'PayPal')]")
	WebElementFacade payPal;

	@FindBy(xpath = "//*[not(contains(@class, 'disabled')) and contains(text(), 'Save')]")
	WebElementFacade savePaypalButton;
	
	@FindBy(xpath = "//*[contains(@class, 'Checkout-paymentProfile')]")
	WebElementFacade paymentInfo;
	
	// Get Payment Information
	@FindBy(id = "payment-firstName")
	WebElementFacade paymentFirstName;
	
	@FindBy(id = "payment-lastName")
	WebElementFacade paymentLastName;

	@FindBy(xpath = "//*[@id='payment-cardNumber']/div")
	WebElementFacade paymentCardNumber;
	
	@FindBy(id = "payment-expireDate")
	WebElementFacade paymentExpireDate;
	
	// Actions on Purchase With

	public void selectCreditCard() {
		Logging.info("Select Credit Card option");
		creditCard.click();
	}

	public void enterFirstName(String firstName) {
		Logging.info(String.format("Fill in First Name in text box: %s", firstName));
		firstNameField.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		Logging.info(String.format("Fill in Last Name in text box: %s", lastName));
		lastNameField.sendKeys(lastName);
	}

	
	public void enterCardInfo() {
		Logging.info("Enter card information");
		cardNumberField.sendKeys("4111111111111111");
		expireDayField.sendKeys("12/2030");
		cvvField.sendKeys("123");
	}
	
	public void enterCardNumber(String cardNum) {
		Logging.info(String.format("Fill in Card Number: %s", cardNum));
		Logging.info("CartNum-----+++++++ is present " + cardNumberField.isDisplayed());
		cardNumberField.sendKeys(cardNum);
	}

	public void enterExprireDay(String Day) {
		Logging.info(String.format("Fill in Expire Day: %s", Day));
		Logging.info("Day-----+++++++ is present " + expireDayField.isDisplayed());
		expireDayField.sendKeys(Day);
	}

	public void enterCvvNumber(String cvv) {
		Logging.info(String.format("Fill in Expire Day: %s", cvv));
		Logging.info("CVV-----+++++++ is present " + cvvField.isDisplayed());
		cvvField.sendKeys(cvv);
	}

	public void fillAddressField(String Address) {
		Logging.info(String.format("Fill in Address field:  %s", Address));
		addressField.sendKeys(Address);
	}

	public void fillCityField(String City) {
		Logging.info(String.format("Fill in City field:  %s", City));
		cityField.sendKeys(City);
	}

	public void fillZipeCode(String codeNum) {
		Logging.info(String.format("Fill in code number:  %s", codeNum));
		zipCode.sendKeys(codeNum);
	}

	public void selectCountry(String Country) {
		Logging.info(String.format("Select country :  %s", Country));
		Select country = new Select(countrySelection);
		country.selectByValue(Country);
	}

	public void clickSaveCreditBtn() {
		if(checkSaveBtnIsPresent()) {
			Logging.info("Click on Save Credit Card button");
			saveCreditBtn.click();
			waitABit(3000);
		}
	}
	
	public boolean checkSaveBtnIsPresent() {
		Logging.info("Check Save Button is highlight");
		try {
			return saveCreditBtn.isDisplayed();
		} catch (Exception noSuchElement) {
			return false;
		}
	}

	public void selectPaypal() {
		Logging.info("Select Paypal Option");
		payPal.click();
	}

	public void clickSavePaypalButton() {
		Logging.info("Click on Save Paypal button");
		savePaypalButton.click();
	}
	
	public boolean checkPaymentIsExist() {
		Logging.info("Check Payment is Exist or not");
		try {
			return paymentEditBtn.isDisplayed();
		} catch (Exception noSuchElement) {
			Logging.info("There is no payment profile");
			return false;
		}
	}
	
	
	public void selectPurchaseCreditCart() {
		Logging.info("Select purchase with Credit Cart and Debit Cart");
		purchaseCartMethod.click();
	}
	
	public void selectPurchasePaypal() {
		Logging.info("Select purchase with Paypal");
		purchasePaypalMethod.click();
	}
	
	public void clickDeleteButton() {
		Logging.info("Click on Delete button");
		paymentDeleteBtn.click();
	}
	
	public void clickEditButton() {
		Logging.info("Click on Edit button");
		paymentEditBtn.click();
	}
	
	public void confirmDelete() {
		Logging.info("Click on Delete button on Confirmation Modal");
		confirmDeleteBtn.click();
	}
	
	public void confirmCancel() {
		Logging.info("Click on Cancel button on Confirmation Modal");
		confirmCancelBtn.click();
	}
	
	public String getPaymentFirstName() {
		Logging.info("Get payment first name");
		return paymentFirstName.getText();
	}
	
	public String getPaymentLastName() {
		Logging.info("Get payment last name");
		return paymentLastName.getText();
	}
	
	public String getPaymentCreditCardNumber() {
		Logging.info("Get credit card number");
		return paymentCardNumber.getText().split(" /")[0];
	}
	
	public String getPaymentExprireDate() {
		Logging.info("Get payment exprire date");
		return paymentExpireDate.getText();
	}
}

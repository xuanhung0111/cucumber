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

public class CheckoutPage extends BasePage {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	/*
	 * *****Declaration Elements ****
	 */
	String deleteItem = "//*[@class='removeCartItem']/i[contains(text(), 'delete')]";
	String titleItem = "//*[@class='CartItem-details']/*[@class='CartItem-title']";
	String totalIssuePub = "//*[@class='CartItem-details']/*[@class='CartItem-date']";
	String issuePubDate = "//*[@class='CartItem-details']/*[@class='CartItem-date']/span";
	String publicationType = "//*[@class='CartItem-details']//*[starts-with(@class, 'CartItem-type')]";
	String cartItemPrice = "//*[@class='CartItem-price']";
	String orderSummary = "//*[contains(@class, 'Checkout-summary')]//div[@class='Table-cell']";

//	// Checkout Page Pop Up
//
	@FindBy(className = "Cart")
	WebElementFacade cartPage;
	
	@FindBy(className = "Cart--empty")
	WebElementFacade emptyCart;
	
//	List<WebElement> listCartItemEl = getDriver().findElements(By.className("CartItem"));

	@FindBy(className = "Cart-itemCount")
	WebElementFacade itemCount;

//	 @FindBy(xpath = "//*[@class='CartItem-details']/*[@class='CartItem-title']")
//	 WebElementFacade titleItem;

	 @FindBy(xpath = "//*[@class='CartItem-details']/*[@class='CartItem-date']")
	 WebElementFacade totalIssueCart;

	@FindBy(xpath = "//*[@class='removeCartItem']/i[contains(text(), 'delete')]")
	WebElementFacade removeItem;

//	 @FindBy(className = "CartItem-price")
//	 WebElementFacade cartItemPrice;

	@FindBy(className = "Cart-subtotal")
	WebElementFacade cartTotal;
//	List<WebElement> cartTotalPrice = cartTotal.findElements(By.xpath("//span"));

	@FindBy(id = "cart-checkOutButton")
	WebElementFacade checkoutButton;

	@FindBy(xpath = "//*[contains(text(),'Continue Shopping')]")
	WebElementFacade continueButton;

	@FindBy(id = "cart-continueButton")
	WebElementFacade continueButtonEmptyCart;
	
	// Purchase with
	
	@FindBy(id = "cartMethodLabel-0")
	WebElementFacade purchaseCartMethod;
	
	@FindBy(id = "paypalMethodLabel-0")
	WebElementFacade purchasePaypalMethod;
	
	@FindBy(id = "payment-editButton")
	WebElementFacade payentEditBtn;
	
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
	
	// Order summary
	
	@FindBy(id = "checkout-magazinesPrice")
	WebElementFacade magazinesPrice;
	
	@FindBy(id = "checkout-tax")
	WebElementFacade tax;
	
	@FindBy(id = "checkout-total")
	WebElementFacade totalPrice;
	
	@FindBy(name = "coupon.coupon")
	WebElementFacade codeGiftInput;
	
	@FindBy(xpath = "//button[contains(text(), 'Apply')]")
	WebElementFacade applyBtn;
	
	@FindBy(id = "checkout-purchaseButton")
	WebElementFacade completePurchase;
	
	@FindBy(className = "Thankyou")
	WebElementFacade thanksPage;
	
	@FindBy(xpath = "//*[@id='reactApp']//a[contains(text(), 'Continue Shopping')]")
	WebElementFacade continueShoppingThankyouPage;
	
	@FindBy(xpath = "//*[@class='CartList']//a[contains(text(), 'Read Now')]")
	WebElementFacade readNowBtn;
	
	
	// Action

	public String getTotalItemInCart() {
		String numberItem = itemCount.getText().replaceAll("[^0-9]", "");
		Logging.info("You have " + numberItem + "items in Your Cart");
		return numberItem;
	}

	public String getTotalPrice() {
		List<WebElement> cartTotalPrice = cartTotal.findElements(By.xpath("//span"));
		String cartPrice = cartTotalPrice.get(1).getText();
		String[] currentPrice = cartPrice.split(" ");
		Logging.info(String.format("Total Cart Price is  %s ", currentPrice[0]));
		return currentPrice[0];
	}

	public void removeIssueInCart() {
		Logging.info("Remove Issue in Cart");
		removeItem.click();
	}

	public void clickCheckoutButton() {
		Logging.info("Click Checkout button");
		checkoutButton.click();
	}

	public void clickContinueButton() {
		Logging.info("Click Continue Button");
		continueButton.click();
	}

	public void deleteIssueInCart(int item) {
		int numberItem = item;
		int count = 0;
		Logging.info("Delete Issue in Cart");
		List<WebElement> listItems = getDriver().findElements(By.xpath(deleteItem));
		for (WebElement itemEl : listItems) {
			count++;
			itemEl.click();
			if (count == numberItem) {
				break;
			}
		}
	}

	public boolean checkCartPageIsPresent() {
		Logging.info("Check Cart Pop Up is shown");
		try {
			return cartPage.isDisplayed();
		} catch (Exception noSuchElement) {
			return false;
		}
	}

	public int countCartItem() {
		Logging.info("Count number Cart Item is shown");
		List<WebElement> listCartItemEl = getDriver().findElements(By.className("CartItem"));
		return listCartItemEl.size();
	}

	public List<Map<String, String>> getCartInfo() {
		List<WebElement> listCartItemEl = getDriver().findElements(By.className("CartItem"));
		List<Map<String, String>> listCartItem = new ArrayList<Map<String, String>>();

		Map<String, String> hashCart = new HashMap<String, String>();

		if (listCartItemEl.size() == 0) {
			return listCartItem;
		} else {
			for (WebElement cartItemEl : listCartItemEl) {
				String cartTitle = cartItemEl.findElement(By.xpath(titleItem)).getText();
				String totalIssue = cartItemEl.findElement(By.xpath(totalIssuePub)).getText();
				String pubType = cartItemEl.findElement(By.xpath(publicationType)).getText();
				String itemPrice = cartItemEl.findElement(By.xpath(cartItemPrice)).getText().split("")[0];
				String currencyIssue = cartItemEl.findElement(By.xpath(cartItemPrice)).getText().split("")[1];
				String pubDate = null;
				try {
					boolean isPubDatePresent = cartItemEl.findElement(By.xpath(issuePubDate)).isDisplayed();
					if (isPubDatePresent == true) {
						pubDate = cartItemEl.findElement(By.xpath(issuePubDate)).getText();
					}
				} catch (Exception noSuchElement) {
					pubDate = null;
				}
				hashCart.put("Title", cartTitle);
				hashCart.put("Issue", totalIssue);
				hashCart.put("Title", pubType);
				hashCart.put("Date", pubDate);
				hashCart.put("Price", itemPrice);
				hashCart.put("Currency", currencyIssue);
				listCartItem.add(hashCart);
			}
			return listCartItem;
		}
	}

	// Actions on Purchase With

	public void selectCreditCard() {
		Logging.info("Select Credit Card option");
		creditCard.click();
	}

	public void enterFirstName(String firstName) {
		Logging.info(String.format("Fill in First Name in text box: %s", firstName));
		firstNameField.clear();
		firstNameField.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		Logging.info(String.format("Fill in Last Name in text box: %s", lastName));
		lastNameField.clear();
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
		addressField.clear();
		addressField.sendKeys(Address);
	}

	public void fillCityField(String City) {
		Logging.info(String.format("Fill in City field:  %s", City));
		cityField.clear();
		cityField.sendKeys(City);
	}

	public void fillZipeCode(String codeNum) {
		Logging.info(String.format("Fill in code number:  %s", codeNum));
		zipCode.clear();
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

	public String getBaseMagazinesPrice() {
		return magazinesPrice.getText().split(" ")[0];
	}
	
	public String getMagazinesTax() {
		return tax.getText().split(" ")[0];
	}
	
	public String getTotalMagazinesPrice() {
		return totalPrice.getText().split(" ")[0];
	}
	
	public boolean checkCurrencyIsCorrect() {
		if (magazinesPrice.getText().split(" ")[1] != tax.getText().split(" ")[1]) return false;
		if (magazinesPrice.getText().split(" ")[1] != totalPrice.getText().split(" ")[0]) return false;
		return true;
	}
	
	public String getCurrency() {
		return totalPrice.getText().split(" ")[1];
	}
	
	
	public Map<String, String> getCurencyInOrderSummary() {
		Logging.info("Get Order summary");
		List<WebElement> summaryEl = getDriver().findElements(By.xpath(orderSummary));
		Map<String, String> hashOrder = new HashMap<String, String>();
		
		hashOrder.put("Base Price", summaryEl.get(1).getText().split("")[1]);
		hashOrder.put("Tax ", summaryEl.get(3).getText().split("")[1]);
		hashOrder.put("Total", summaryEl.get(5).getText().split("")[1]);
		return hashOrder;
	}
	
	
	public boolean checkCartIsEmpty() {
		Logging.info("Check Cart is Empty");
		try {
			return emptyCart.isDisplayed();
		} catch (Exception noSuchElement) {
			return false;
		}
	}
	
	public boolean checkPaymentIsExist() {
		Logging.info("Check Payment is Exist or not");
		try {
			return payentEditBtn.isDisplayed();
		} catch (Exception noSuchElement) {
			Logging.info("There is no payment profile");
			return false;
		}
	}
	
	public void clickContinuesBtnInEmptyCart() {
		Logging.info("Click countinue button in empty cart");
		continueButtonEmptyCart.click();
	}
	
	public void enterCouponCode(String couponCode) {
		Logging.info("Enter coupon code");
		codeGiftInput.sendKeys(couponCode);
	}
	
	public void applyCouponCode() {
		Logging.info("Click apply coupon code");
		applyBtn.click();
	}
	
	public void clickCompletePurchase() {
		Logging.info("Click Complete Purchase");
		completePurchase.click();
	}
	
	public boolean checkThankYouPageIsPresent() {
		Logging.info("Check thankyou page is present");
		try {
			return thanksPage.isDisplayed();
		} catch (Exception noSuchElement) {
			return false;
		}
	}
	
	public String getOrderId() {
		Logging.info("Get Order Id");
		try {
			String orderId = thanksPage.findElement(By.tagName("h4")).getAttribute("textContent");
			return orderId.replaceAll("\\D+","");
		} catch (Exception noSuchElement) {
			return "0";
		}
	}
	
	public void clickCountinueShopingInThankyouPage() {
		Logging.info("Click Countinue Shopping in Thankyou page");
		continueShoppingThankyouPage.click();
	}
	
	public void clickReadNowBtn() {
		Logging.info("Click on Read Now");
		readNowBtn.click();
	}
	
	public boolean isReadBtnPresent() {
		Logging.info("Check Read Now button is present");
		return readNowBtn.isPresent();
	}
	
	public void selectPurchaseCreditCart() {
		Logging.info("Select purchase with Credit Cart and Debit Cart");
		purchaseCartMethod.click();
	}
	
	public void selectPurchasePaypal() {
		Logging.info("Select purchse with Paypal");
		purchasePaypalMethod.click();
	}
	
}

package com.zinio.web.workflow;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zinio.config.CreditCard;
import com.zinio.web.data.UserData;
import com.zinio.web.element.BasePage;
import com.zinio.web.pages.CheckoutPage;
import com.zinio.web.pages.EmailPage;
import com.zinio.web.pages.HomePage;
import com.zinio.web.pages.ProductPage;
import com.zinio.web.pages.SignInPage;
import com.zinio.web.pages.SignUpPage;
import com.zinio.web.utilities.Logging;

public class WebWorkFlow {
	
     WebDriver driver;
     private SignInPage signInPage;
     private SignUpPage signUpPage;
     private CheckoutPage checkOutPage;
     private CreditCard creditCardInfo;
     private HomePage homePage;
     private ProductPage productPage;
     private EmailPage emailPage;

     public WebWorkFlow(WebDriver driver) {
		this.driver = driver;
		signInPage = new SignInPage(driver);
		signUpPage = new SignUpPage(driver);
		checkOutPage = new CheckoutPage(driver);
		homePage = new HomePage(driver);
		productPage = new ProductPage(driver);
		emailPage = new EmailPage(driver);
		creditCardInfo = new CreditCard(UserData.FIRST_NAME, UserData.LAST_NAME, UserData.CART_NUMBER,  
				UserData.CVV, "2030", "12", UserData.ADDRESS, UserData.CITY, UserData.ZIPCODE, UserData.COUNTRY_KEY);
     }
	
     public void waitReady(long milliseconds) {
 		try {
 			Thread.sleep(milliseconds);
 		} catch (Exception ex) {
 			ex.printStackTrace();
 		}
 	}
     
	public void loginFromSignInPage (String userName, String passWord) throws InterruptedException
	{
		Logging.info("Login Page with valid username and password");
		signInPage.enterUsername(userName);
		signInPage.enterPassword(passWord);
		signInPage.clickSignInBtn();
	}
	
	public void createUserFromSignUpPage (String userName, String passWord)
	{
		Logging.info("Create new account from Sign Up Page");
		signUpPage.enterRegisterUserName(userName);
		signUpPage.enterRegisterPassword(passWord);
		signUpPage.enterRegisterConfirmPassword(passWord);
		signUpPage.clickSignUpBtn();
	}
	
	
	public String convertStringToLowerCase (String convertString)
	{
		Logging.info("Convert string to Upper Case");
		return convertString.toLowerCase().replace(" ", "-");
	}
	
	public void paymentCreditCartProceed() {
		Logging.info("Proceed to purchase");
		checkOutPage.enterFirstName(creditCardInfo.getFirstName());
		waitReady(500);
		checkOutPage.enterLastName(creditCardInfo.getLaseName());
		waitReady(500);
		String windowName = driver.getWindowHandle();

		driver.switchTo().frame(0);
		checkOutPage.enterCardNumber(creditCardInfo.getCreditCardNumber());
		waitReady(500);
		driver.switchTo().window(windowName);
		
		driver.switchTo().frame(1);
		checkOutPage.enterExprireDay("12/2020");
		waitReady(500);
		driver.switchTo().window(windowName);
		
		driver.switchTo().frame(2);
		checkOutPage.enterCvvNumber(creditCardInfo.getCvv());
		waitReady(500);
		driver.switchTo().window(windowName);
		
		checkOutPage.fillAddressField(creditCardInfo.getAddress());
		waitReady(500);
		checkOutPage.fillCityField(creditCardInfo.getCity());
		waitReady(500);
		checkOutPage.fillZipeCode(creditCardInfo.getZipCode());
		waitReady(500);
		checkOutPage.selectCountry(creditCardInfo.getCountry());
		waitReady(2000);
		checkOutPage.clickSaveCreditBtn();
	}
	
	public void paymentCreditCartProceed(String[] newCreditCardInfo) {
		/*
		 * New Credit Card Info should like this 
		 * cardInfo = {"FirsName", "LastName", "4111111111111111", "20/2020", "123", "Ho Chi Minh", ""Le Dai Hanh", "456", "Viet Nam"
		 */
		Logging.info("Proceed to purchase");
		//Logging.info(newCreditCardInfo[1]);
		checkOutPage.enterFirstName(newCreditCardInfo[0]);
		waitReady(500);
		checkOutPage.enterLastName(newCreditCardInfo[1]);
		waitReady(500);
		String windowName = driver.getWindowHandle();

		driver.switchTo().frame(0);
		checkOutPage.enterCardNumber(newCreditCardInfo[2]);
		waitReady(500);
		driver.switchTo().window(windowName);
		
		driver.switchTo().frame(1);
		checkOutPage.enterExprireDay(newCreditCardInfo[3]);
		waitReady(500);
		driver.switchTo().window(windowName);
		
		driver.switchTo().frame(2);
		checkOutPage.enterCvvNumber(newCreditCardInfo[4]);
		waitReady(500);
		driver.switchTo().window(windowName);
		
		checkOutPage.fillAddressField(newCreditCardInfo[5]);
		waitReady(500);
		checkOutPage.fillCityField(newCreditCardInfo[6]);
		waitReady(500);
		checkOutPage.fillZipeCode(newCreditCardInfo[7]);
		waitReady(500);
		checkOutPage.selectCountry(newCreditCardInfo[8]);
		waitReady(2000);
		checkOutPage.clickSaveCreditBtn();
	}
	
	public void getInboxEmail() {
		Logging.info("Get new inbox email");
		emailPage.enterEmail(UserData.USER_EMAIL); // UserData.USER_EMAIL
		emailPage.clickNextEmailBtn();
		waitReady(2000);
		emailPage.enterPassword(UserData.PASSWORD); // 
		emailPage.clickNextPasswordBtn();
		waitReady(2000);
		
	}
	
	public void loginUserProcess(String username, String password) {
		Logging.info("Login user process");
		signInPage.enterUsername(username);
		signInPage.enterPassword(password);
		signInPage.clickSignInBtn();
	}
	
	public void purchaseProceed(boolean isSubs, String paymentMethod) {
		
		Logging.info("Purchase Issue Process .......");
		
		if(isSubs) {
			productPage.clickSubscribe(true);
		} else {
			productPage.clickBuyIssue();
		}
		
		checkOutPage.clickCheckoutButton();
		waitReady(1000);
		
		if(!checkOutPage.checkPaymentIsExist()) {
			if (paymentMethod.equals("Credit Cart")){
				checkOutPage.selectPurchaseCreditCart();
				paymentCreditCartProceed();
			} else {
				checkOutPage.selectPurchasePaypal();
//				paymentProceed();
				// defined later with paypal process
			}
		}
		checkOutPage.clickCompletePurchase();
	}
}

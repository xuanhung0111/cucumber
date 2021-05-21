
package com.zinio.admin.pages;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.zinio.web.element.BasePage;
import com.zinio.web.utilities.Logging;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.findby.By;

public class AdminOrdersPage  extends BasePage{

	public AdminOrdersPage(WebDriver driver) {
		super(driver);
	}
	/*
	 * *****Declaration Elements ****
	 */
	// Admin Orders Page
	
	@FindBy(xpath = "//*[@class='menu-item menu-icons']//span[contains(text(), 'Orders')]")
	WebElementFacade ordersMenu;
	
	@FindBy(xpath = "//*[@class='form-control'][@name='true']")
	WebElementFacade txtOrdersId;
	
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElementFacade goBtn;
	
	@FindBy(className = "notfound")
	WebElementFacade notFound;
	
	@FindBy(id = "order-tab___tab___general")
	WebElementFacade generalInformationTab;
	
	@FindBy(id = "order-tab___tab___order-items")
	WebElementFacade orderItemsTab;
	
	@FindBy(id = "order-tab___tab___payment")
	WebElementFacade paymentTab;
	
	String orderInfoEl = "//*[@class='order-display']//*[@class='col-xs-6']";
	String sideGeneralInfoEl = "//*[@class='col-sm-6 col-xs-12']";
	String sidePaymentInfoEl = "//*[@id='order-tab___pane___payment']//*[@class='info-row row']/div";
	String orderItemsEl = "//*[@id='order-tab___pane___order-items']//table[@class='table table-striped table-responsive']";
	String linePaymentEven = "//*[@id='order-tab___pane___payment']//div[@class='line payment even']/div";
	String linePaymentOdd = "//*[@id='order-tab___pane___payment']//div[@class='line payment odd']/div";
	
	
	// Action
	
	public void goToOrdersMenu() {
		Logging.info("Click on Orders Menu");
		ordersMenu.click();
	}
	
	public void enterOrderId(String orderId) {
		Logging.info("Enter Order Id into text field");
		txtOrdersId.sendKeys(orderId);;
		goBtn.click();
		waitABit(1000);
	}
	
	public boolean isFoundOrder() {
		try {
			Logging.info("Check Order is found ?");
			return notFound.isDisplayed();
		} catch(Exception noSuchElement) {
			return false;
		}
		
	}
	
	public void goToGeneralTab() {
		Logging.info("Click on General Information Tab");
		generalInformationTab.click();
	}
	
	public void goToOrderItemsTab() {
		Logging.info("Click on Order Items Tab");
		orderItemsTab.click();
	}
	
	public void goToPaymentTab() {
		Logging.info("Click on Payment Tab");
		paymentTab.click();
	}
	
	public Map<String, String> getOrdersDisplay() {
		String orderKey = null;
		String orderValue = null;
		int count = 0;
		Logging.info("Get Order Display");
		
		List<WebElement> orderDisplay = getDriver().findElements(By.xpath(orderInfoEl));
		
		Map<String, String> hashOrder = new HashMap<String, String>();
		
		hashOrder.put("Agent Id", orderDisplay.get(0).getText());
		hashOrder.put("Agent Type", orderDisplay.get(1).getText());
//		hashOrder.put("Source Type", orderDisplay.get(2).getText());
		for (int i =2; i< orderDisplay.size(); i++) {
			count ++;
			if (i % 2 == 0) {
				orderKey = orderDisplay.get(i).getText();
			} else {
				orderValue = orderDisplay.get(i).getText();
			 }
			if (count % 2 == 0) {
				hashOrder.put(orderKey, orderValue);
			}
		}
		return hashOrder;
	}
	
	public Map<String, String> getGeneralSideInfo() {
		Logging.info("Get General Side Info");
		
		List<WebElement> sideGenaralInfo = getDriver().findElements(By.xpath(sideGeneralInfoEl));
		
		Map<String, String> hashSide = new HashMap<String, String>();
		
		hashSide.put("ID", sideGenaralInfo.get(1).getText());
		hashSide.put("Remote ID ", sideGenaralInfo.get(2).getText());
		hashSide.put("User ID", sideGenaralInfo.get(4).getText());
		hashSide.put("Status", sideGenaralInfo.get(14).getText());
		return hashSide;
	}
	
	public List<Map<String, String>> getOrderItemsTable()
	{
		return getItemsTable(orderItemsEl, "Order Items");
	}
	
	public Map<String, String> getPaymentSideInfo() {
		
		Logging.info("Get Payment Side Info");
		
		List<WebElement> sidePaymentInfo = getDriver().findElements(By.xpath(sidePaymentInfoEl));
		
		Map<String, String> hashSide = new HashMap<String, String>();
		
		hashSide.put(sidePaymentInfo.get(0).getText(), sidePaymentInfo.get(1).getText());
		hashSide.put(sidePaymentInfo.get(2).getText(), sidePaymentInfo.get(3).getText());
		hashSide.put(sidePaymentInfo.get(4).getText(), sidePaymentInfo.get(5).getText());
		return hashSide;
	}
	
	public Map<String, String> getPaymentDisplay() {
		int count =0;
		int count1 =0;
		String paymentKey = null;
		String paymentValue = null;
		
		Logging.info("Get Payment Display");
		
		Map<String, String> hashPayment = new HashMap<String, String>();
		
		List<WebElement> paymentEven = getDriver().findElements(By.xpath(linePaymentEven));
		
		List<WebElement> paymentOdd = getDriver().findElements(By.xpath(linePaymentOdd));
		
		for (int i =0; i< paymentEven.size(); i++) {
			count ++;
			if (i % 2 == 0) {
				paymentKey = paymentEven.get(i).getText();
			} else {
				paymentValue = paymentEven.get(i).getText();
			 }
			if (count % 2 == 0) {
				hashPayment.put(paymentKey, paymentValue);
			}
		}
		for (int j =0; j< paymentOdd.size(); j++) {
			count1 ++;
			if (j % 2 == 0) {
				paymentKey = paymentOdd.get(j).getText();
			} else {
				paymentValue = paymentOdd.get(j).getText();
			 }
			if (count1 % 2 == 0) {
				hashPayment.put(paymentKey, paymentValue);
			}
		}
		return hashPayment;
	}
	
	
}

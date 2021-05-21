package com.zinio.web.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.zinio.web.element.BasePage;
import com.zinio.web.utilities.Logging;

import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class FooterPage extends BasePage {

	public FooterPage(WebDriver driver) {
		super(driver);
	}

	String footerNewsstand = "//*[@class='Footer-newsstands']//li[contains(@title, '%s')]";

	@FindBy(xpath = "//*[contains(@class, 'bx-close bx-close-link bx-close-inside')]")
	WebElementFacade advBanner;
	
	@FindBy(xpath = "//*[@class='Cookies']//a[contains(text(), 'I ACCEPT')]")
	WebElementFacade acceptPolicy;

	// Footer page

	// Action

	public void goToNewsstand(String newsstand) {
		Logging.info("Go to newsstand: " + newsstand);
		String newsstandName = String.format(footerNewsstand, newsstand);
		WebElement newsstandEl = getDriver().findElement(By.xpath(newsstandName));
		newsstandEl.click();
	}

	public void closeAdvBanner() {
		Logging.info("Closing advertisement banner");
		try {
			if (advBanner.isDisplayed()) {
				Logging.info("Advertisement banner is displayed");
				advBanner.click();
			}
		} catch (Exception noSuchElement) {
			advBanner.click();
		}
	}
	
	public void acceptSwitchNewsstand() {
		Logging.info("Accept switch newsstand");
		try {
			if (acceptPolicy.isDisplayed()) {
				acceptPolicy.click();
			}
		} catch (Exception noSuchElement) {
			Logging.info("There is no banner is displayed");
		}
	}
}

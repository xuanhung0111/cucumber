package com.zinio.web.libraries;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class CloudDriver {

	WebDriver  driver;
	String testString;
	
	public CloudDriver()
	{
		this.testString = "newnew";
	}
	
	public WebDriver getCurrentBrowser(String browser)
	{
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
			driver =new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir")+"/firefoxdriver");
			driver =new FirefoxDriver();
		} else if (browser.equals("safari")){
			System.setProperty("webdriver.safari.driver", System.getProperty("user.dir")+"/safarifriver");
			driver =new SafariDriver();
		} else if (browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/ie");
			driver =new InternetExplorerDriver();
			System.out.println(" ____ " + testString);;
		}
		return driver;
	}
}


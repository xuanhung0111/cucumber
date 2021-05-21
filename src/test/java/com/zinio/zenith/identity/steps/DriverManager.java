package com.zinio.zenith.identity.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.zinio.web.utilities.Logging;
import com.zinio.web.utilities.PropertyUtils;

import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DriverManager {

	private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

	static String browserDriver = PropertyUtils.getPropAsString("defaultBrowser");

	public static WebDriver getDriver() {
		return webDriver.get();
	}

	public static WebDriver initLocalDriver() {
		switch (browserDriver.toLowerCase()) {
		case "firefox":
			return new FirefoxDriver();

		case "chrome":
			return new ChromeDriver();

		case "safari":
			return new SafariDriver();
		case "ie":
			return new InternetExplorerDriver();
		case "edge":
			return new EdgeDriver();
		default:
			Logger.getLogger(PhantomJSDriverService.class.getName()).setLevel(Level.OFF);
			DesiredCapabilities desiredCap = new DesiredCapabilities();
			String[] phantomArgs = new String[] { "--webdriver-loglevel=NONE" };
			desiredCap.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomArgs);
			return new PhantomJSDriver(desiredCap);
		}
	}

	private static WebDriver initRemoteDriver(String browser, String remote_ip) {
		try {
			DesiredCapabilities cap;
			switch (browser) {
			case "firefox":
				cap = DesiredCapabilities.firefox();
				break;
			case "ie":
				cap = DesiredCapabilities.internetExplorer();
				break;
			default:
				cap = DesiredCapabilities.chrome();
				break;
			}
			return new RemoteWebDriver(new URL("http://" + remote_ip + "/wd/hub"), cap) {
			};
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
package com.zinio.zenith.identity.steps;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class IOSDriverManager {

	public static IOSDriver<IOSElement> capabilities() throws MalformedURLException   {
		
		IOSDriver<IOSElement> driver;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6 Plus");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
//		String appActivities2 = "com.zinio.baseapplication.presentation.splash.view.activity.SplashActivity";
//		capabilities.setCapability(MobileCapabilityType.APP, appActivities2);
		capabilities.setCapability("udid", "1ba0d0806f294eef83fa111f2c9bf8b5");
		
		driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		return driver;
	}

}

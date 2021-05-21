package com.zinio.zenith.identity.steps;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidDriverManager {

	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException  {
		AndroidDriver<AndroidElement> driver;

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Devices");
		String app ="com.zinio.mobile.android.reader.sbx";
		String appActivities = "com.zinio.baseapplication.presentation.splash.view.activity.SplashActivity";
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, app);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivities);
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.startActivity(settingsAppPackageName, settingsAppActivityName);
		return driver;
	}

}

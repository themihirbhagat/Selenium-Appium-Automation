package com.automation.test.base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.automation.utils.ConfigReader;
import com.automation.utils.Constants;
import com.automation.utils.DriverManager;
import com.automation.utils.LoggerUtil;

public class BaseTest {

	@BeforeSuite(alwaysRun = true)
	public void cleaner() {
		ConfigReader.loadConstantProperties();    // Loading constant.properties file
	}

	@BeforeClass(alwaysRun = true)
	public void setupDriver() {

		tearDown(); // Calling tearDown() method in case an instance already exist.

		if (Constants.PLATFORM_TYPE.equalsIgnoreCase(Constants.WEB_ENV)) {
			LoggerUtil.info("Setting up WebDriver using below properties:" + "\nURL: " + Constants.URL
					+ "\nPlatformType: " + Constants.PLATFORM_TYPE + "\nBrowser: " + Constants.BROWSER);

			DriverManager.setupWebDriver();

		} else if (Constants.PLATFORM_TYPE.equalsIgnoreCase(Constants.ANDROID_ENV)
				|| Constants.PLATFORM_TYPE.equalsIgnoreCase(Constants.ENV)) {
			DriverManager.setupAppiumDriver();
			LoggerUtil.info("Height: " + DriverManager.getDriver().manage().window().getSize().height + " | Width: "
					+ DriverManager.getDriver().manage().window().getSize().width);
		}
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {

		// Cleanup and quit the WebDriver/AppiumDriver instance
		DriverManager.quitDriver();
	}

}

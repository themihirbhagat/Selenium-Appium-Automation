package com.automation.utils;

import java.io.File;

public class Constants {
	
	private Constants() {  }
	
    public static final String PROPERTYFILE = "src/main/resources/constant.properties";
    
    // Application Environment
    public static final String ENV = ConfigReader.getPropertyValue(PROPERTYFILE, "env");
    
    // PlatformType
    public static final String PLATFORM_TYPE = ConfigReader.getPropertyValue(PROPERTYFILE, "platformType");
    
    
    // Environments
	public static final String WEB_ENV = "web";
	public static final String ANDROID_ENV = "android";
    
    // =========================================================
    // =====				Selenium 						====
    // =========================================================
	
    public static final String URL = ConfigReader.getPropertyValue(PROPERTYFILE, "url");
	
    // Browsers
    public static final String BROWSER =  ConfigReader.getPropertyValue(PROPERTYFILE, "browser");
	
    // Waits
    public static final long WEBDRIVER_IMPLICIT_WAIT = Long.parseLong(ConfigReader.getPropertyValue(PROPERTYFILE, "webDriverImplicitWait"));
    public static final long WEBDRIVER_PAGE_LOAD_TIMEOUT = Long.parseLong(ConfigReader.getPropertyValue(PROPERTYFILE, "webDriverPageLoadTimeout"));
    
    public static final long WEBDRIVER_WAIT_DURATION = Long.parseLong(ConfigReader.getPropertyValue(PROPERTYFILE, "WebDriverWaitDuration"));
    
    // =========================================================
    // =====					Appium 						====
    // =========================================================
    
    // Appium Server
    public static final String APPIUM_SERVER_URL = ConfigReader.getPropertyValue(PROPERTYFILE, "appiumServerURL");
    public static final int APPIUM_SERVER_PORT = Integer.parseInt(ConfigReader.getPropertyValue(PROPERTYFILE, "appiumServerPort"));

    // Mobile device
    public static final String DEVICE_NAME =  ConfigReader.getPropertyValue(PROPERTYFILE, "deviceName_" + PLATFORM_TYPE);
    public static final String PLATFORM_VERSION =  ConfigReader.getPropertyValue(PROPERTYFILE, "platformVersion_" + PLATFORM_TYPE);
    
    public static final String APK_NAME = ConfigReader.getPropertyValue(PROPERTYFILE, "ApkName");
    public static final String APK_PATH = new File("src/main/resources/APK", APK_NAME).getAbsolutePath();
    
    // Waits
    public static final long MOBILEDRIVER_IMPLICIT_WAIT = Long.parseLong(ConfigReader.getPropertyValue(PROPERTYFILE, "mobileDriverImplicitWait"));

    
    // =========================================================
    // =====				User Account 					====
    // =========================================================

    
    public static final String USERNAME_WEB = ConfigReader.getPropertyValue(PROPERTYFILE, "username_web");
    public static final String PASSWORD_WEB = ConfigReader.getPropertyValue(PROPERTYFILE, "password_web");

    public static final String USERNAME_MOBILE = ConfigReader.getPropertyValue(PROPERTYFILE, "username_mobile");
    public static final String PASSWORD_MOBILE = ConfigReader.getPropertyValue(PROPERTYFILE, "password_mobile");
    
}

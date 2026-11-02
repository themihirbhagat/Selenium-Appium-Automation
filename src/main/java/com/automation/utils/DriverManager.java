package com.automation.utils;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;

public class DriverManager {
	
	private static WebDriver webDriver = null;
	private static AppiumDriver appiumDriver = null;
	private static Actions actions;
    
    private static DesiredCapabilities capabilities = new DesiredCapabilities();
    
    private DriverManager() { }   
    
    public static void setupWebDriver() {
        
        if (Constants.BROWSER.equalsIgnoreCase("Chrome")) {
            	
            Map<String, Object> prefs = new HashMap<>();    
            
            ChromeOptions cOptions = new ChromeOptions();  
            
            cOptions.setExperimentalOption("prefs", prefs); 
            
            cOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation")); 
            
            cOptions.setExperimentalOption("useAutomationExtension", false);
            
            cOptions.addArguments("incognito");
            
            webDriver = new ChromeDriver(cOptions);
        } else {   
            throw new IllegalArgumentException("Please specify valid browser name.");
        }

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.WEBDRIVER_IMPLICIT_WAIT));    
        
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.WEBDRIVER_PAGE_LOAD_TIMEOUT));  
        
        webDriver.manage().window().maximize();

        actions = new Actions(webDriver);
    }
    
    public static void setupAppiumDriver() {
        	
    	capabilities.setCapability("platformName", Platform.ANDROID);   
    	
    	capabilities.setCapability("platformVersion", Constants.PLATFORM_VERSION);  
    	
    	capabilities.setCapability("deviceName", Constants.DEVICE_NAME);
    	
    	capabilities.setCapability("automationName", AutomationName.ANDROID_UIAUTOMATOR2);
    	
    	capabilities.setCapability("appium:app", Constants.APK_PATH);
    	
//    	capabilities.setCapability("appium:udid", Constants.DEVICE_NAME);

    	capabilities.setCapability("connectHardwareKeyboard", false);
    	
      capabilities.setCapability("launchTimeout", 100000);

      capabilities.setCapability("commandTimeouts", 70000);
      
      capabilities.setCapability("newCommandTimeout", 20000);    	
		try {
			appiumDriver = new AndroidDriver(new URI(Constants.APPIUM_SERVER_URL).toURL(), capabilities);
		} catch (MalformedURLException | URISyntaxException e) {
			e.printStackTrace();
		}
		
		appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.MOBILEDRIVER_IMPLICIT_WAIT));
	
		actions = new Actions(appiumDriver);
        
    }
    
    public static WebDriver getDriver() { 
    	
        if (appiumDriver != null) {
            return appiumDriver;
        } else if (webDriver != null) {
        	return webDriver;
        } else { 
        	return null;
        }        
    }
    
    public static Actions getActions() { 
    	return actions;
    }
    
    public static void quitDriver() {
        
    	if (appiumDriver != null) {
            appiumDriver.quit();
            appiumDriver = null;
        } else if (webDriver != null) {
        	webDriver.quit();
        	webDriver = null;
        }
    }
}

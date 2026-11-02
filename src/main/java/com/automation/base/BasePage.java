package com.automation.base;


import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.automation.utils.Constants;
import com.automation.utils.DriverManager;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BasePage {
	    public BasePage() {
	    	if (Constants.PLATFORM_TYPE.equals(Constants.WEB_ENV)) {	    		
	    		PageFactory.initElements(new AjaxElementLocatorFactory(DriverManager.getDriver(), (int) Constants.WEBDRIVER_WAIT_DURATION), this);
	    	
	    	} else if (Constants.PLATFORM_TYPE.equals(Constants.ANDROID_ENV)) {
	            PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
	    	}
	    }
}

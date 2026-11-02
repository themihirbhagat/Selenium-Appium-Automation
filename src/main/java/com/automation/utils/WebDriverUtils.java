package com.automation.utils;


public class WebDriverUtils {
	
	private WebDriverUtils() {  }
	
    /**
     * Browser: Navigate to a give url
     * @param url String URL
     */
    public static void openUrl(String url) {
    	DriverManager.getDriver().get(url);
    }

}

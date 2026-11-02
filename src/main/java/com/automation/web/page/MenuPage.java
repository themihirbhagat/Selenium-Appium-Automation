package com.automation.web.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.automation.base.BasePage;

public class MenuPage extends BasePage {
	
	@FindBy(how = How.XPATH ,using = "//div[text()='ACCOUNT']")
	private WebElement accountHeading;

	public boolean verifyAccountHeadingIsDisplayed() {
		return accountHeading.isDisplayed();
	}

}

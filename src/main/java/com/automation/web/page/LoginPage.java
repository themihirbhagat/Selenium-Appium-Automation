package com.automation.web.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.automation.base.BasePage;
import com.automation.utils.Constants;

public class LoginPage extends BasePage {

	@FindBy(how = How.XPATH ,using = "//img[@class='logo']")
	private WebElement logo;

	@FindBy(how = How.XPATH ,using = "//span[text()='Application']")
	private WebElement applicationBtn;


	@FindBy(how = How.XPATH ,using = "//div[text()='To continue, log in']")
	private WebElement loginHeading;

	@FindBy(how = How.XPATH ,using = "//input[@placeholder='Email']")
	private WebElement emailTextField;	

	@FindBy(how = How.XPATH ,using = "//input[@placeholder='Password']")
	private WebElement passwordTextField;	

	@FindBy(how = How.XPATH ,using = "//span[text()='Sign In']/parent::span/parent::button")
	private WebElement signInBtn;	
	
	
	public boolean verifyLogoIsDisplayed() {
		return logo.isDisplayed();
	}

	public boolean verifyApplicationBtnIsDisplayed() {
		return applicationBtn.isDisplayed();
	}

	public boolean verifyLoginHeadingIsDisplayed() {
		return loginHeading.isDisplayed();
	}
	public void setEmailTextField() {
		emailTextField.sendKeys(Constants.USERNAME_WEB);
	}
	public void setPasswordTextField() {
		passwordTextField.sendKeys(Constants.PASSWORD_WEB);
	}
	public void clickSignInBtn() {
		signInBtn.click();
	}
	
	
}

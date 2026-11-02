package com.automation.mobile.page;

import org.openqa.selenium.WebElement;

import com.automation.base.BasePage;
import com.automation.utils.Constants;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BasePage {
	
	// ************************** Email Page *****************************
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button1\")")
	private WebElement okAlertBtn;
	
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"What's your Email?\")")
    private WebElement whatsYourEmailHeading;
   
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"EmailTextField\")")
    private WebElement emailTextField;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Forgot Email?\")")
    private WebElement forgotEmailBtn;
    
    
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Terms and Conditions\")")
    private WebElement readTermsAndConditionsBtn;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Terms And Conditions\")")
    private WebElement termsAndConditionsHeading;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Navigate up\")")
    private WebElement backTermsAndConditionsBtn;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Continue\")")
    private WebElement continueBtn;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"CheckboxAgreeConditions\")")
    private WebElement agreeConditionsAgreeCheckbox;
    
	// ************************** Password Page *****************************
    
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\".com\")")
    private WebElement confirmUserNameBtn;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"What's your Password?\")")
    private WebElement whatsYourPasswordHeading;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"TextInput\")")
    private WebElement passwordTextField;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Forgot Password?\")")
    private WebElement forgotPasswordBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Login\")")
    private WebElement loginBtn;
    
	// ************************** OTP Page *****************************
    
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Enter OTP Code\")")
    private WebElement enterOTPHeading;
    
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"SetupPinCodeScreen\"]/android.view.ViewGroup[2]/android.view.ViewGroup")
    private WebElement otpTextField;
    
    
	// ************************** Review Your Active Sessions Page *****************************
    
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Review Your Active Sessions\")")
    private WebElement reviewYourActiveSessionsHeading;
    
    
    
    
	// ************************** Email Page *****************************
    
	public void clickOkAlertBtn() {
		okAlertBtn.click();
	}
	
	public boolean verifyWhatsYourEmailHeadingIsDisplayed() {
		return whatsYourEmailHeading.isDisplayed();
	}
	
	public void setEmailTextField() {
		emailTextField.sendKeys(Constants.USERNAME_MOBILE);
	}
	
	public boolean verifyForgotEmailBtnIsDisplayed() {
		return whatsYourEmailHeading.isDisplayed();
	}

	public void clickReadTermsAndConditionsBtn() {
		readTermsAndConditionsBtn.click();
	}
    
	public boolean verifyTermsAndConditionsHeadingIsDisplayed() {
		return termsAndConditionsHeading.isDisplayed();
	}
	
	public void clickBackTermsAndConditionsBtn() {
		backTermsAndConditionsBtn.click();
	}
	
	public void clickAgreeConditionsAgreeCheckbox() {
		agreeConditionsAgreeCheckbox.click();
	}
	
	public void clickContinueBtn() throws InterruptedException {
		continueBtn.click();
	}
	
	// ************************** Password Page *****************************
    
	public boolean verifyConfirmUserNameBtnIsDisplayed() {
		return confirmUserNameBtn.isDisplayed();
	}
	public boolean verifyWhatsYourPasswordHeadingIsDisplayed() {
		return whatsYourPasswordHeading.isDisplayed();
	}

    public void setPasswordTextField() {
    	passwordTextField.sendKeys(Constants.PASSWORD_MOBILE);
    }
    
	public boolean verifyForgotPasswordBtnIsDisplayed() {
		return forgotPasswordBtn.isDisplayed();
	}
    
	public void clickLoginBtn() { 
		loginBtn.click();
	}
	
	
	// ************************** OTP Page *****************************
	
	public boolean verifyEnterOTPHeadingIsDisplayed() {
		return enterOTPHeading.isDisplayed();
	}
	
	public void enterOTP(String otp) {
		otpTextField.sendKeys(otp);
	}
    
	// ************************** Review Your Active Sessions Page *****************************
	
	public boolean verifyReviewYourActiveSessionsHeadingIsDisplayed() {
		return reviewYourActiveSessionsHeading.isDisplayed();
	}
    
    
    

}

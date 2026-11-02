package com.automation.test.web.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.automation.test.base.BaseTest;
import com.automation.utils.Constants;
import com.automation.utils.WebDriverUtils;
import com.automation.web.page.LoginPage;
import com.automation.web.page.MenuPage;

public class LoginTest extends BaseTest {

	LoginPage login;
	MenuPage sideMenuPage;
			
	@Test(priority=0,
			description="Verify the Login Screen is displayed and Performs user Sign-in process and confirms that the user has been signed-in successfully") 
	public void loginTest() throws InterruptedException {
		
		WebDriverUtils.openUrl(Constants.URL);
		
		login = new LoginPage();
		
		sideMenuPage = new MenuPage();
		
		// Verify Login screen
		
		assertTrue(login.verifyLogoIsDisplayed(), "Login Page: Logo is not visible.");
		
		assertTrue(login.verifyApplicationBtnIsDisplayed(), "Login Page: Application Button is not visible.");
		
		assertTrue(login.verifyLoginHeadingIsDisplayed(), "Login Page: Login Heading is not visible");
		
		// Signing-in
		
		login.setEmailTextField();
		
		login.setPasswordTextField();
		
		login.clickSignInBtn();
		
		// Verify the user is successfully Signed-in...
		
		assertTrue(sideMenuPage.verifyAccountHeadingIsDisplayed(), "User Is Not Logged-in Successfully!!!");
		
		Thread.sleep(4000);
	}
	


}

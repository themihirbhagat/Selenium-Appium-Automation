package com.automation.test.mobile.tests;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.Test;

import com.automation.mobile.page.LoginPage;
import com.automation.test.base.BaseTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LoginTest extends BaseTest {
	
	LoginPage login;
	
	@Test(priority=0,
			description="Verify the Login Screen is displayed and Performs user Sign-in process and confirms that the user has been signed-in successfully") 
	public void loginTest() throws InterruptedException {
		
		login = new LoginPage();
		
		login.clickOkAlertBtn(); // Accepting the Push Notification Alert
		
		// Verify Whats Your Email Page is visible
		
		assertTrue(login.verifyWhatsYourEmailHeadingIsDisplayed(), "Email Heading is not visible!!!");
		
		assertTrue(login.verifyForgotEmailBtnIsDisplayed(), "Forgot Email button is not visible!!!");
		
		// Verify Terms & Condition pop-up
		
		login.clickReadTermsAndConditionsBtn();
		
		assertTrue(login.verifyTermsAndConditionsHeadingIsDisplayed());
		
		login.clickBackTermsAndConditionsBtn();
		
		// ========== Starting the login process ===========
		
		login.setEmailTextField();
		
		login.clickAgreeConditionsAgreeCheckbox();
		
		login.clickContinueBtn();
		
		// Verify Password screen
		
		assertTrue(login.verifyWhatsYourPasswordHeadingIsDisplayed(), "Password screen is not visible!!!");
		
		assertTrue(login.verifyConfirmUserNameBtnIsDisplayed(), "User is not available!!");
		
		assertTrue(login.verifyForgotPasswordBtnIsDisplayed(), "Forgot Password button is not visisble!!!");
		
		login.setPasswordTextField();
		
		login.clickLoginBtn();
		
		// Verify OTP screen
		
		assertTrue(login.verifyEnterOTPHeadingIsDisplayed(), "OTP screen not visible...");
		
		login.enterOTP(retrieveOTP()); // OTP field not accessible in the current .apk.
		
		// Verify User is logged-in successfully
		
		assertTrue(login.verifyReviewYourActiveSessionsHeadingIsDisplayed(), "User is not logged-in successfully!!!");
		
	}
	
	public String retrieveOTP() {
		RestAssured.baseURI = "https://www.spoofbox.com/ajax.php";

		Response response = given().param("task", "trashmobile-receive")
				.formParam("number", "61476857122")
				.post("/");
		
		assertEquals(response.getStatusCode(), 200, "Unexpected status code");

		// Define a regex pattern to find the OTP
	    String otpPattern = "Your code is: (\\d{6})";

	    // Compile the regex and search for matches
	    Pattern pattern = Pattern.compile(otpPattern);
	    Matcher matcher = pattern.matcher(response.getBody().asString());

	    // Check if the pattern is found and extract the OTP
	    if (matcher.find()) {
	        String otp = matcher.group(1);
	        System.out.println("Extracted OTP: " + otp);
	        return otp;
	    } else {
	        System.out.println("OTP not found in the provided text.");
	        return null;
	    }
	}

}

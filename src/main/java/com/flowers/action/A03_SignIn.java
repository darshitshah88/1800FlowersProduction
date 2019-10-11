package com.flowers.action;

import java.util.Set;

import org.testng.Assert;

import com.flowers.elements.E03_SignIn;
import com.flowers.utils.TestBase;
import com.flowers.utils.Utility;
import com.relevantcodes.extentreports.LogStatus;

public class A03_SignIn extends TestBase {

	E03_SignIn SIElement = new E03_SignIn();
	public String parentWinHandle;

	public void verifySignInTestCase() throws Exception {
		// Start report
		logger = report.startTest("Sign In Pop-up");

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifySwitchWindow() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "Verify current window");

		// Conditional statements - <WINDOW SWITCH>
		parentWinHandle = driver.getWindowHandle();
		Utility.click(Utility.getElementByid(SIElement.menubtnSignIn));
		Utility.implicitlyWait();
		Set<String> winHandles = driver.getWindowHandles();
		for (String handle : winHandles) {
			if (!handle.equals(parentWinHandle)) {
				driver.switchTo().window(handle);
				logger.log(LogStatus.PASS, "Webdriver switched into the pop-up window");
			}
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifySignInTitle() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "Verify the pop-up title");

		// Conditional statements - <PAGE TITLE>
		String pageTitle = driver.getTitle();
		if (pageTitle.contentEquals(obj.getProperty("signInTitle"))) {
			logger.log(LogStatus.PASS, "Sign in pop-up title verified");
		} else {
			logger.log(LogStatus.FAIL, "Sign in pop-up title not verified");
			Assert.assertEquals(pageTitle, obj.getProperty("signInTitle"));
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifySignInWithBlankDataFields() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "Verify if the user proceeds without filling all the mandatory fields");

		// Without entering data into elements, click the button
		Utility.click(Utility.getElementByid(SIElement.btnLSignIn));

		// Conditional statements - <BLANK FIELDS>
		if (!Utility.getElementByxpath(SIElement.validationEmail).getSize().equals(null)
				&& !Utility.getElementByxpath(SIElement.validationPassword).getSize().equals(null)) {
			logger.log(LogStatus.PASS, "Validation messages are displayed on the sign-in pop-up");
		} else {
			logger.log(LogStatus.FAIL, "There's some error while verifying validation messages");
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifySignInWithBlankEmail() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "Verify if a user enters the only password");

		// Clear all elements
		Utility.clear(Utility.getElementByid(SIElement.txtEmail));
		Utility.clear(Utility.getElementByid(SIElement.txtPassword));

		// Enter the only password, click the button
		Utility.sendKeys(Utility.getElementByid(SIElement.txtEmail), obj.getProperty("blankEmail"));
		Utility.sendKeys(Utility.getElementByid(SIElement.txtPassword), obj.getProperty("password"));
		Utility.click(Utility.getElementByid(SIElement.btnLSignIn));

		// Conditional statements - <BLANK EMAIL>
		if (!Utility.getElementByxpath(SIElement.validationEmail).getSize().equals(null)) {
			logger.log(LogStatus.PASS, "Validation messages are displayed on the sign-in pop-up");
		} else {
			logger.log(LogStatus.FAIL, "There's some error while verifying validation messages");
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifySignInWithBlankPassword() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "Verify if a user enters the only email");

		// Clear all elements
		Utility.clear(Utility.getElementByid(SIElement.txtEmail));
		Utility.clear(Utility.getElementByid(SIElement.txtPassword));

		// Enter the only email, click the button
		Utility.sendKeys(Utility.getElementByid(SIElement.txtEmail), obj.getProperty("email"));
		Utility.sendKeys(Utility.getElementByid(SIElement.txtPassword), obj.getProperty("blankPassword"));
		Utility.click(Utility.getElementByid(SIElement.btnLSignIn));

		// Conditional statements - <BLANK PASSWORD>
		if (!Utility.getElementByxpath(SIElement.validationPassword).getSize().equals(null)) {
			logger.log(LogStatus.PASS, "Validation messages are displayed on the sign-in pop-up");
		} else {
			logger.log(LogStatus.FAIL, "There's some error while verifying validation messages");
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifySignInWithInvalidData() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "Verify if a user enters invalid email and password");

		// Clear all elements
		Utility.clear(Utility.getElementByid(SIElement.txtEmail));
		Utility.clear(Utility.getElementByid(SIElement.txtPassword));

		// Enter invalid data into elements, click the button
		Utility.sendKeys(Utility.getElementByid(SIElement.txtEmail), obj.getProperty("invalidEmail"));
		Utility.sendKeys(Utility.getElementByid(SIElement.txtPassword), obj.getProperty("invalidPassword"));
		Utility.click(Utility.getElementByid(SIElement.btnLSignIn));

		// Conditional statements - <INVALID FIELDS>
		if (!Utility.getElementByxpath(SIElement.validationEmail).getSize().equals(null)) {
			logger.log(LogStatus.PASS, "Validation messages are displayed on the sign-in pop-up");
		} else {
			logger.log(LogStatus.FAIL, "There's some error while verifying validation messages");
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifySignInWithInvalidEmail() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "Verify if a user enters invalid email and a valid password");

		// Clear all elements
		Utility.clear(Utility.getElementByid(SIElement.txtEmail));
		Utility.clear(Utility.getElementByid(SIElement.txtPassword));

		// Enter data into elements, click the button
		Utility.sendKeys(Utility.getElementByid(SIElement.txtEmail), obj.getProperty("invalidEmail"));
		Utility.sendKeys(Utility.getElementByid(SIElement.txtPassword), obj.getProperty("password"));
		Utility.click(Utility.getElementByid(SIElement.btnLSignIn));

		// Conditional statements - <EMAIL>
		if (!Utility.getElementByxpath(SIElement.validationEmail).getSize().equals(null)) {
			logger.log(LogStatus.PASS, "Validation messages are displayed on the sign-in pop-up");
		} else {
			logger.log(LogStatus.FAIL, "There's some error while verifying validation messages");
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifySignInWithInvalidPassword() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "Verify if a user enters a valid email and invalid password");

		// Clear all elements
		Utility.clear(Utility.getElementByid(SIElement.txtEmail));
		Utility.clear(Utility.getElementByid(SIElement.txtPassword));

		// Enter data into elements, click the button
		Utility.sendKeys(Utility.getElementByid(SIElement.txtEmail), obj.getProperty("email"));
		Utility.sendKeys(Utility.getElementByid(SIElement.txtPassword), obj.getProperty("invalidPassword"));
		Utility.click(Utility.getElementByid(SIElement.btnLSignIn));

		// Conditional statements - <PASSWORD>
		if (!Utility.getElementByid(SIElement.validationEmailPassword).getSize().equals(null)) {
			logger.log(LogStatus.PASS, "Validation messages are displayed on the sign-in pop-up");
		} else {
			logger.log(LogStatus.FAIL, "There's some error while verifying validation messages");
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifySignInWithValidData() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "Verify if a user enters a valid email and password");

		// Clear all elements
		Utility.clear(Utility.getElementByid(SIElement.txtEmail));
		Utility.clear(Utility.getElementByid(SIElement.txtPassword));

		// Enter data into elements, click the button
		Utility.sendKeys(Utility.getElementByid(SIElement.txtEmail), obj.getProperty("email"));
		Utility.sendKeys(Utility.getElementByid(SIElement.txtPassword), obj.getProperty("password"));
		Utility.click(Utility.getElementByid(SIElement.btnLSignIn));

		// Window switch and reload the page
		driver.switchTo().window(parentWinHandle);
		Utility.pageReload();
		
		// Getting data
		String userName = Utility.getText(Utility.getElementByxpath(SIElement.lblUserName));
		
		// Conditional statements - <PASSWORD>
		if (userName.equals(obj.getProperty("userName"))) {
			logger.log(LogStatus.PASS, userName + " has successfully logged in");
		} else {
			logger.log(LogStatus.FAIL, "There's some error while login");
		}

		// Implicitly wait
		Utility.implicitlyWait();

		// Report ended
		report.endTest(logger);
	}
}
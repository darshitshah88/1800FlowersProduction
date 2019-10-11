package com.flowers.action;

import java.util.Set;

import org.testng.Assert;

import com.flowers.elements.E02_CreateAccount;
import com.flowers.utils.TestBase;
import com.flowers.utils.Utility;
import com.relevantcodes.extentreports.LogStatus;

public class A02_CreateAccount extends TestBase {

	E02_CreateAccount CAElement = new E02_CreateAccount();

	public void verifyCreateAccountTestCase() throws Exception {
		// Start report
		logger = report.startTest("Create Account Pop-up");

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifySwitchWindow() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify current window</b>");

		// Conditional statements - <WINDOW SWITCH>
		String parentWinHandle = driver.getWindowHandle();
		Utility.click(Utility.getElementByid(CAElement.menudropCreateAcc));
		//Utility.implicitlyWait();
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

	public void verifyCreateAccountTitle() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify the pop-up title</b>");

		// Conditional statements - <POP-UP TITLE>
		String pageTitle = driver.getTitle();
		if (pageTitle.contentEquals(obj.getProperty("createAccountTitle"))) {
			logger.log(LogStatus.PASS, "Create account pop-up title verified");
		} else {
			logger.log(LogStatus.FAIL, "Create account pop-up title not verified");
			Assert.assertEquals(pageTitle, obj.getProperty("createAccountTitle"));
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyCreateAccountWithBlankFields() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>All fields have blank, then click on the create account button</b>");

		// Without entering data into elements, click the button
		Utility.click(Utility.getElementByid(CAElement.btnCreateAccount));

		// Conditional statements - <BLANK FIELDS>
		if (!Utility.getElementByxpath(CAElement.validationFirstName).getSize().equals(null)
				&& !Utility.getElementByxpath(CAElement.validationLastName).getSize().equals(null)
				&& !Utility.getElementByxpath(CAElement.validationEmail).getSize().equals(null)
				&& !Utility.getElementByxpath(CAElement.validationPassword).getSize().equals(null)) {
			logger.log(LogStatus.PASS, "Validation messages are displayed on creating account pop-up");
		} else {
			logger.log(LogStatus.FAIL, "There's some error while verifying validation messages");
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyCreateAccountWithInvalidEmail() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Enter the invalid email, then click on the create account button</b>");

		// Clear all elements
		Utility.clear(Utility.getElementByid(CAElement.txtFirstName));
		Utility.clear(Utility.getElementByid(CAElement.txtLastName));
		Utility.clear(Utility.getElementByid(CAElement.txtEmail));
		Utility.clear(Utility.getElementByid(CAElement.txtPassword));

		// Enter data into elements, click the button
		Utility.sendKeys(Utility.getElementByid(CAElement.txtFirstName), obj.getProperty("firstName"));
		Utility.sendKeys(Utility.getElementByid(CAElement.txtLastName), obj.getProperty("lastName"));
		Utility.sendKeys(Utility.getElementByid(CAElement.txtEmail), obj.getProperty("invalidEmail"));
		Utility.sendKeys(Utility.getElementByid(CAElement.txtPassword), obj.getProperty("password"));
		Utility.click(Utility.getElementByid(CAElement.btnCreateAccount));

		// Conditional statements - <EMAIL>
		if (!Utility.getElementByxpath(CAElement.validationEmail).getSize().equals(null)) {
			logger.log(LogStatus.PASS, "Validation message is displayed on creating account pop-up");
		} else {
			logger.log(LogStatus.FAIL, "There's some error while verifying validation message");
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyCreateAccountWithInvalidPassword() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Enter an invalid password, then click on the create account button</b>");

		// Clear all elements
		Utility.clear(Utility.getElementByid(CAElement.txtFirstName));
		Utility.clear(Utility.getElementByid(CAElement.txtLastName));
		Utility.clear(Utility.getElementByid(CAElement.txtEmail));
		Utility.clear(Utility.getElementByid(CAElement.txtPassword));

		// Enter data into elements, click the button
		Utility.sendKeys(Utility.getElementByid(CAElement.txtFirstName), obj.getProperty("firstName"));
		Utility.sendKeys(Utility.getElementByid(CAElement.txtLastName), obj.getProperty("lastName"));
		Utility.sendKeys(Utility.getElementByid(CAElement.txtEmail), obj.getProperty("email"));
		Utility.sendKeys(Utility.getElementByid(CAElement.txtPassword), obj.getProperty("invalidPassword"));
		Utility.click(Utility.getElementByid(CAElement.btnCreateAccount));

		// Conditional statements - <PASSWORD>
		if (!Utility.getElementByxpath(CAElement.validationPassword).getSize().equals(null)) {
			logger.log(LogStatus.PASS, "Validation message is displayed on creating account pop-up");
		} else {
			logger.log(LogStatus.FAIL, "There's some error while verifying validation message");
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyCreateAccount() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Enter valid data, then click on the create account button</b>");

		// Clear all elements
		Utility.clear(Utility.getElementByid(CAElement.txtFirstName));
		Utility.clear(Utility.getElementByid(CAElement.txtLastName));
		Utility.clear(Utility.getElementByid(CAElement.txtEmail));
		Utility.clear(Utility.getElementByid(CAElement.txtPassword));

		// Enter data into elements, click the button
		Utility.sendKeys(Utility.getElementByid(CAElement.txtFirstName), obj.getProperty("firstName"));
		Utility.sendKeys(Utility.getElementByid(CAElement.txtLastName), obj.getProperty("lastName"));
		Utility.sendKeys(Utility.getElementByid(CAElement.txtEmail), obj.getProperty("email"));
		// Utility.sendKeys(Utility.getElementByid(CAccountElement.txtPassword),obj.getProperty("password"));
		Utility.click(Utility.getElementByxpath(CAElement.checkboxText));
		Utility.click(Utility.getElementByid(CAElement.btnCreateAccount));

		// Implicitly wait
		Utility.implicitlyWait();

		// Report ended
		report.endTest(logger);
	}
}

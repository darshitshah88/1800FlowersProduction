package com.flowers.action;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.flowers.elements.E01_Home;
import com.flowers.utils.TestBase;
import com.flowers.utils.Utility;
import com.relevantcodes.extentreports.LogStatus;

public class A01_Home extends TestBase {

	E01_Home HElement = new E01_Home();

	public void verifyHomeTestCase() throws Exception {
		// Start report
		logger = report.startTest("Home Page");

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyBrowserLaunched() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify the website URL</b>");

		// Conditional statements - <URL>
		String URL = driver.getCurrentUrl();
		if (URL.equals(obj.getProperty("URL"))) {
			logger.log(LogStatus.PASS, "Browser launched and navigated to https://www.1800flowers.com/");
		} else {
			logger.log(LogStatus.FAIL, "Navigated to " + URL);
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyHomeTitle() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify the page title</b>");

		// Conditional statements - <PAGE TITLE>
		String pageTitle = driver.getTitle();
		if (pageTitle.contentEquals(obj.getProperty("homeTitle"))) {
			logger.log(LogStatus.PASS, "Home page title verified");
		} else {
			logger.log(LogStatus.FAIL, "Home page title not verified");
			Assert.assertEquals(pageTitle, obj.getProperty("homeTitle"));
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyDisplayLogo() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify that the brand logo is present and left-aligned</b>");

		// Conditional statements - <LOGO>
		if (!Utility.getElementByxpath(HElement.lnkLogo).getSize().equals(null)) {
			logger.log(LogStatus.PASS, "Logo is shown in the upper left-aligned");
		} else {
			logger.log(LogStatus.FAIL, "Logo isn't shown in the upper left-aligned");
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyGDPRNotice() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "</b>Verify that on clicking the date GDPR button</b>");

		// Conditional statements - <GDPR>
		Utility.click(Utility.getElementByxpath(HElement.btnGDPR));
		String GDPRNotice = Utility.getAttribute(Utility.getElementByxpath(HElement.divGDPRNotice), "class");
		if (GDPRNotice.equals(obj.getProperty("GDPRNotice"))) {
			logger.log(LogStatus.PASS, "GDPR button is dismissed, and GDPR notice hides");
		} else {
			logger.log(LogStatus.FAIL, "GDPR button is showing, GDPR notice showing");
		}

		// Implicitly wait
		Utility.implicitlyWait();

		// REPORT ENDED
		report.endTest(logger);
	}

	public void verifyMouseHover() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify mouse howering on the sign-in element</b>");

		Actions action = new Actions(driver);
		action.moveToElement(Utility.getElementByid(HElement.hoverSignIn)).build().perform();
		logger.log(LogStatus.PASS, "Mouse hover on the sign-in element");

		// Implicitly wait
		Utility.implicitlyWait();

		// Report ended
		report.endTest(logger);
	}
}
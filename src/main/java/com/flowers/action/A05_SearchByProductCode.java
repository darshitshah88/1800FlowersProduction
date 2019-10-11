package com.flowers.action;

import org.testng.Assert;

import com.flowers.elements.E05_SearchByProductCode;
import com.flowers.utils.TestBase;
import com.flowers.utils.Utility;
import com.relevantcodes.extentreports.LogStatus;

public class A05_SearchByProductCode extends TestBase {

	E05_SearchByProductCode SBPCElement = new E05_SearchByProductCode();

	public void verifySearchByProductCodeTestCase() throws Exception {
		// Start report
		logger = report.startTest("Search By Product Code");

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyBlankSearch() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify click the search button without entering any product code</b>");

		// Without entering data into element, click the button
		Utility.click(Utility.getElementByid(SBPCElement.txtSearch));
		Utility.click(Utility.getElementByid(SBPCElement.btnSearch));

		// Getting data
		String alertText = driver.switchTo().alert().getText();

		// Conditional statements - <ALERT>
		if (alertText.equals(obj.getProperty("alertSearchText"))) {
			logger.log(LogStatus.PASS, "Validation message is displayed in the pop-up");
			Utility.alertAccept();
		} else {
			logger.log(LogStatus.FAIL, "There's some error while verifying validation message");
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyInvalidSearch() throws Exception {
		// Test case information
		String searchProductCode = obj.getProperty("invalidProductCode");
		logger.log(LogStatus.INFO, "<b>Verify search result for a invalid product code: " + searchProductCode + "</b>");

		// Enter data into element, click the button
		Utility.sendKeys(Utility.getElementByid(SBPCElement.txtSearch), searchProductCode);
		Utility.click(Utility.getElementByid(SBPCElement.btnSearch));

		// Conditional statements - <INVALID SEARCH>
		if (!Utility.getElementByxpath(SBPCElement.validationSearchResult).getSize().equals(null)) {
			logger.log(LogStatus.PASS, "Validation message is displayed for the product code: " + searchProductCode);
		} else {
			logger.log(LogStatus.FAIL, "There's some error while verifying validation message");
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifySearchResultsTitle() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify the page title</b>");

		// Conditional statements - <PAGE TITLE>
		String pageTitle = driver.getTitle();
		if (pageTitle.contentEquals(obj.getProperty("searchResultsTitle"))) {
			logger.log(LogStatus.PASS, "Search result page title verified");
		} else {
			logger.log(LogStatus.FAIL, "Search result page title not verified");
			Assert.assertEquals(pageTitle, obj.getProperty("searchResultsTitle"));
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyValidSearch() throws Exception {
		// Test case information
		String searchProductCode = obj.getProperty("validProductCode1");
		logger.log(LogStatus.INFO, "<b>Verify search result for a valid product code: " + searchProductCode + "</b>");

		// Enter data into element, click the button
		Utility.sendKeys(Utility.getElementByid(SBPCElement.txtSearch), searchProductCode);
		Utility.click(Utility.getElementByid(SBPCElement.btnSearch));

		// Getting data
		String productCode = Utility.getText(Utility.getElementByxpath(SBPCElement.lblProductCode));

		// Conditional statements - <PRODUCT CODE>
		if (productCode.contains(searchProductCode)) {
			logger.log(LogStatus.PASS, "Navigate to product code: " + searchProductCode + " page");
		} else {
			logger.log(LogStatus.FAIL, "There's some error while verifying product code: " + searchProductCode);
		}

		// Implicitly wait
		Utility.implicitlyWait();

		// Report ended
		report.endTest(logger);
	}
}
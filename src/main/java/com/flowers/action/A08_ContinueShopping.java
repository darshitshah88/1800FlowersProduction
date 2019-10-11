package com.flowers.action;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.flowers.elements.E08_ContinueShopping;
import com.flowers.utils.TestBase;
import com.flowers.utils.Utility;
import com.relevantcodes.extentreports.LogStatus;

public class A08_ContinueShopping extends TestBase {

	E08_ContinueShopping CSElement = new E08_ContinueShopping();

	public void verifyContinueShoppingTestCase() throws Exception {
		// Start report
		logger = report.startTest("Continue Shopping Page");

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyContinueShoppingLink() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify continue shopping link navigate to product description page</b>");

		// Conditional statements - <VIEW CART LINK>
		if (!Utility.getElementByxpath(CSElement.lnkContinueShopping).getSize().equals(null)) {
			Utility.click(Utility.getElementByxpath(CSElement.lnkContinueShopping));
			logger.log(LogStatus.PASS, "Continue shopping link is shown, it navigates to product description page");
		} else {
			logger.log(LogStatus.FAIL, "Continue shopping link does not show properly");
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyDatePickerControlOpen() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify that on clicking the date field, date picker control open</b>");

		// Entering data into element, click the delivery date
		Utility.sendKeys(Utility.getElementByid(CSElement.txtZipCode), obj.getProperty("continueShoppingzipCode"));
		Utility.click(Utility.getElementByid(CSElement.calDeliveryDate));

		// Conditional statements - <DATE PICKER OPEN>
		if (!Utility.getElementByid(CSElement.calDatePicker).getSize().equals(null)) {
			logger.log(LogStatus.PASS, "Date picker control is showing");
		} else {
			logger.log(LogStatus.FAIL, "Date picker control is not open properly");
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyCalMonthYear() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify the right month and year for date picker is shown</b>");
		
		// Getting data
		String calMonthYear = Utility.getText(Utility.getElementByxpath(CSElement.calMonthYear)).trim();
		
		// Conditional statements - <MONTH YEAR>
		boolean flag = false;
		while (!flag) {
			if (!calMonthYear.equalsIgnoreCase(obj.getProperty("continueShoppingcalDateMonthYear"))) {
				Utility.click(Utility.getElementByid(CSElement.lnkNext));
				// Getting data
				calMonthYear = Utility.getText(Utility.getElementByxpath(CSElement.calMonthYear)).trim();
			} else {
				flag = true;
				logger.log(LogStatus.PASS, "Correct month and year for date picker is selected");
			}
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyCalStdDate() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify valid standard charge date</b>");

		// Conditional statements - <LIST OF CAL STD CHARGE DATE>
		boolean flag = false;
		WebElement calMonth = Utility.getElementByxpath(CSElement.calMonth);
		List<WebElement> listOfStdDate = Utility.getElementBycssSelector(calMonth, "div.calStdCharge");
		for (WebElement calStdDate : listOfStdDate) {
			// Getting data
			String calStdChargeDate = calStdDate.getText();
			if (calStdChargeDate.equals(obj.getProperty("continueShoppingcalStdDate"))) {
				calStdDate.click();
				logger.log(LogStatus.PASS, "Correct standard charge date for date picker is selected");
				flag = true;
				break;
			}
		}
		if (!flag) {
			logger.log(LogStatus.FAIL, "Standard charge date for date picker has not selected");
			Assert.assertEquals(listOfStdDate, obj.getProperty("continueShoppingcalStdDate"));
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyDatePickerControlClose() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify that the date picker control closed after a date is selected</b>");

		// Conditional statements - <DATE PICKER CLOSED>
		try {
			if (!Utility.getElementByxpath(CSElement.calControl).getSize().equals(null)) {
				logger.log(LogStatus.FAIL, "Date picker control is not close properly");
				Assert.fail("Date picker control is not close properly");
			}
		} catch (Exception e) {
			logger.log(LogStatus.PASS, "Date picker control has closed");
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifySelectedDeliveryDate() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify that selected delivery date gets displayed in the date field</b>");

		// Conditional statements - <SELECTED DELIVERY DATE>
		String calDeliveryDate = Utility.getAttribute(Utility.getElementByid(CSElement.calItemDeliveryDate), "value");
		if (calDeliveryDate.equals(obj.getProperty("continueShoppingitemDeliveryDate"))) {
			logger.log(LogStatus.PASS, "The delivery date is displayed properly in the date field");
		} else {
			logger.log(LogStatus.FAIL, "The delivery date has not displayed in the date field");
			Assert.assertEquals(calDeliveryDate, obj.getProperty("continueShoppingitemDeliveryDate"));
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyAddToCartPopup() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify that clicking on add to cart button takes the user to cart pop-up</b>");

		// Clicking on add to cart button
		Utility.click(Utility.getElementByid(CSElement.btnAddItemToCart));

		// Conditional statements - <NEXT LINK>
		if (!Utility.getElementByxpath(CSElement.headerAddToCart).getSize().equals(null)) {
			logger.log(LogStatus.PASS, "Added to your cart pop-up is displayed");
		} else {
			logger.log(LogStatus.FAIL, "Added to your cart pop-up is not displayed");
		}

		// Implicitly wait
		Utility.implicitlyWait();

		// Report ended
		report.endTest(logger);
	}
}
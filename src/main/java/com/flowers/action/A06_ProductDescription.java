package com.flowers.action;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.flowers.elements.E06_ProductDescription;
import com.flowers.utils.TestBase;
import com.flowers.utils.Utility;
import com.relevantcodes.extentreports.LogStatus;

public class A06_ProductDescription extends TestBase {

	E06_ProductDescription PDPElement = new E06_ProductDescription();

	public void verifyProductDescriptionPageTestCase() throws Exception {
		// Start report
		logger = report.startTest("Product Description Page");

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyProductDescriptionPageTitle() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify the page title</b>");

		// Conditional statements - <PAGE TITLE>
		String pageTitle = driver.getTitle();
		if (pageTitle.contentEquals(obj.getProperty("PDPTitle"))) {
			logger.log(LogStatus.PASS, "Product description page title verified");
		} else {
			logger.log(LogStatus.FAIL, "Product description page title not verified");
			Assert.assertEquals(pageTitle, obj.getProperty("PDPTitle"));
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyBlankDataFields() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify if the user proceeds without filling all the mandatory fields</b>");

		// Without entering data into elements, click the button
		Utility.click(Utility.getElementByid(PDPElement.txtZipCode));
		Utility.click(Utility.getElementByid(PDPElement.btnAddItemToCart));

		// Conditional statements - <BLANK FIELDS>
		if (!Utility.getElementByxpath(PDPElement.validationZipCode).getSize().equals(null)
				&& !Utility.getElementByxpath(PDPElement.validationDeliveryDate).getSize().equals(null)) {
			logger.log(LogStatus.PASS, "Validation messages are displayed on the sign-in pop-up");
		} else {
			logger.log(LogStatus.FAIL, "There's some error while verifying validation messages");
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyDatePickerControlOpen() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify that on clicking the date field, date picker control open</b>");

		// Entering data into element, click the delivery date
		Utility.sendKeys(Utility.getElementByid(PDPElement.txtZipCode), obj.getProperty("zipCode"));
		Utility.click(Utility.getElementByid(PDPElement.calDeliveryDate));

		// Conditional statements - <DATE PICKER OPEN>
		if (!Utility.getElementByid(PDPElement.calDatePicker).getSize().equals(null)) {
			logger.log(LogStatus.PASS, "Date picker control is showing");
		} else {
			logger.log(LogStatus.FAIL, "Date picker control is not open properly");
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyPreviousLink() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify if the previous link is visible for the current month</b>");

		// Conditional statements - <PREVIOUS LINK>
		try {
			if (!Utility.getElementByid(PDPElement.lnkPrev).getSize().equals(null)) {
				logger.log(LogStatus.FAIL, "The previous link is visible for the current month");
				Assert.fail("The previous link is visible for the current month");
			}
		} catch (Exception e) {
			logger.log(LogStatus.PASS, "The previous link is not visible for the current month");
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyNextLink() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify if the next link is visible for the current month</b>");

		// Conditional statements - <NEXT LINK>
		if (!Utility.getElementByid(PDPElement.lnkNext).getSize().equals(null)) {
			logger.log(LogStatus.PASS, "The next link is visible for the current month");
		} else {
			logger.log(LogStatus.FAIL, "The next link is not visible for the current month");
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyNextPreviousLink() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify the next and previous links are navigable</b>");

		// Conditional statements - <NEXT PREVIOUS LINK>
		if (!Utility.getElementByid(PDPElement.lnkNext).getSize().equals(null)) {
			Utility.click(Utility.getElementByid(PDPElement.lnkNext));
			if (!Utility.getElementByid(PDPElement.lnkPrev).getSize().equals(null)) {
				Utility.click(Utility.getElementByid(PDPElement.lnkPrev));
				logger.log(LogStatus.PASS, "The next and previous links are navigable in the date picker control");
			}
		} else {
			logger.log(LogStatus.FAIL, "The next and previous links are not navigable in the date picker control");
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyCalMonthYear() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify the right month and year for date picker is shown</b>");

		// Getting data
		String calMonthYear = Utility.getText(Utility.getElementByxpath(PDPElement.calMonthYear)).trim();
		
		// Conditional statements - <MONTH YEAR>
		boolean flag = false;
		while (!flag) {
			if (!calMonthYear.equalsIgnoreCase(obj.getProperty("calDateMonthYear"))) {
				Utility.click(Utility.getElementByid(PDPElement.lnkNext));
				// Getting data
				calMonthYear = Utility.getText(Utility.getElementByxpath(PDPElement.calMonthYear)).trim();
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
		WebElement calMonth = Utility.getElementByxpath(PDPElement.calMonth);
		List<WebElement> listOfStdDate = Utility.getElementBycssSelector(calMonth, "div.calStdCharge");
		for (WebElement calStdDate : listOfStdDate) {
			// Getting data
			String calStdChargeDate = calStdDate.getText();
			if (calStdChargeDate.equals(obj.getProperty("calStdDate"))) {
				calStdDate.click();
				logger.log(LogStatus.PASS, "Correct standard charge date for date picker is selected");
				flag = true;
				break;
			}
		}
		if (!flag) {
			logger.log(LogStatus.FAIL, "Standard charge date for date picker has not selected");
			Assert.assertEquals(listOfStdDate, obj.getProperty("calStdDate"));
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyDatePickerControlClose() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify that the date picker control closed after a date is selected</b>");

		// Conditional statements - <DATE PICKER CLOSED>
		try {
			if (!Utility.getElementByid(PDPElement.calControl).getSize().equals(null)) {
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
		String calDeliveryDate = Utility.getAttribute(Utility.getElementByid(PDPElement.calItemDeliveryDate), "value");
		if (calDeliveryDate.equals(obj.getProperty("itemDeliveryDate"))) {
			logger.log(LogStatus.PASS, "The delivery date is displayed properly in the date field");
		} else {
			logger.log(LogStatus.FAIL, "The delivery date has not displayed in the date field");
			Assert.assertEquals(calDeliveryDate, obj.getProperty("itemDeliveryDate"));
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyAddToCartPopup() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify that clicking on add to cart button takes the user to cart pop-up</b>");

		// Clicking on add to cart button
		Utility.click(Utility.getElementByid(PDPElement.btnAddItemToCart));

		// Conditional statements - <NEXT LINK>
		if (!Utility.getElementByxpath(PDPElement.headerAddToCart).getSize().equals(null)) {
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
package com.flowers.action;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.flowers.elements.E10_Recipients;
import com.flowers.utils.TestBase;
import com.flowers.utils.Utility;
import com.relevantcodes.extentreports.LogStatus;

public class A10_Recipients extends TestBase {

	E10_Recipients RElement = new E10_Recipients();

	public void verifyRecipientsTestCase() throws Exception {
		// Start report
		logger = report.startTest("Recipients Page");

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyRecipientsTitle() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify the page title</b>");

		// Conditional statements - <PAGE TITLE>
		String pageTitle = driver.getTitle();
		if (pageTitle.contentEquals(obj.getProperty("recipientsTitle"))) {
			logger.log(LogStatus.PASS, "Recipient page title verified");
		} else {
			logger.log(LogStatus.FAIL, "Recipient page title not verified");
			Assert.assertEquals(pageTitle, obj.getProperty("recipientsTitle"));
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyProductDetails() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify the details of the product such as Zip Code, Name, SKU, Qty, Price</b>");

		// Getting data
		String recipientProdSendTo = Utility.getText(Utility.getElementByxpath(RElement.lblProdSendTo));
		String recipientProdName = Utility.getText(Utility.getElementByxpath(RElement.lblProdName));
		String recipientProdCode = Utility.getText(Utility.getElementByxpath(RElement.lblProdCode));
		String recipientProdQty = Utility.getText(Utility.getElementByxpath(RElement.lblProdQty));
		String recipientProdPrice = Utility.getText(Utility.getElementByxpath(RElement.lblProdPrice));
		String prodSendTo = recipientProdSendTo.replace("Send To: ", "");
		String prodCode = recipientProdCode.replace("Item # ", "");
		String prodQty = recipientProdQty.replace("Qty:", "");

		// Conditional statements - <PRODUCT DETAILSE>
		if (prodSendTo.equals(obj.getProperty("recipientProdSendTo"))
				&& recipientProdName.contains(obj.getProperty("recipientProdName"))
				&& prodCode.equals(obj.getProperty("recipientProdCode"))
				&& prodQty.equals(obj.getProperty("recipientProdQty"))
				&& recipientProdPrice.equals(obj.getProperty("recipientProdPrice"))) {
			logger.log(LogStatus.PASS, "Product details are showing correctly");
		} else {
			logger.log(LogStatus.FAIL, "Product details are showing wrong");
			Assert.fail("Product details are showing wrong");
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyBlankFieldsWithCity() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>All fields have blank, then click on the continue to delivery button</b>");

		// Without entering data into elements, click the button
		Utility.click(Utility.getElementByid(RElement.btnContinueDeliver));

		// Conditional statements - <BLANK FIELDS>
		if (!Utility.getElementByxpath(RElement.validationFirstName).getSize().equals(null)
				&& !Utility.getElementByxpath(RElement.validationLastName).getSize().equals(null)
				&& !Utility.getElementByxpath(RElement.validationAddress1).getSize().equals(null)
				&& !Utility.getElementByxpath(RElement.validationPhone).getSize().equals(null)) {
			logger.log(LogStatus.PASS, "Validation messages are displayed on recipient page");
		} else {
			logger.log(LogStatus.FAIL, "There's some error while verifying validation messages");
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyBlankFieldsWithoutCity() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>All fields have blank, then click on the continue to delivery button</b>");

		// Without entering data into elements, click the button
		Select drpCity = new Select(Utility.getElementByid(RElement.drpCity));
		drpCity.selectByValue(obj.getProperty("recipientCity1"));
		Thread.sleep(10000);
		Utility.clear(Utility.getElementByxpath(RElement.txtCity));
		Utility.click(Utility.getElementByid(RElement.btnContinueDeliver));

		// Conditional statements - <BLANK FIELDS>
		if (!Utility.getElementByxpath(RElement.validationFirstName).getSize().equals(null)
				&& !Utility.getElementByxpath(RElement.validationLastName).getSize().equals(null)
				&& !Utility.getElementByxpath(RElement.validationAddress1).getSize().equals(null)
				&& !Utility.getElementByxpath(RElement.validationCity).getSize().equals(null)
				&& !Utility.getElementByxpath(RElement.validationPhone).getSize().equals(null)) {
			logger.log(LogStatus.PASS, "Validation messages are displayed on recipient page");
		} else {
			logger.log(LogStatus.FAIL, "There's some error while verifying validation messages");
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyDefaultTitle() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify the default options selected in title drop-down list</b>");

		// Getting data
		Select drpTitleText = new Select(Utility.getElementByid(RElement.drpTitle));
		WebElement firstOption = drpTitleText.getFirstSelectedOption();
		String selectedTitle = firstOption.getText();

		// Conditional statements - <SELECTED TITLE>
		if (selectedTitle.equals(obj.getProperty("selectedTitle"))) {
			logger.log(LogStatus.PASS, "The title is shown correctly");
		} else {
			logger.log(LogStatus.FAIL, "The title is showing wrong");
			Assert.fail("The title is showing wrong");
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyDefaultLocationType() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify the default options selected in location type drop-down list</b>");

		// Getting data
		Select drpLocationTypeText = new Select(Utility.getElementByid(RElement.drpLocationType));
		WebElement firstOption = drpLocationTypeText.getFirstSelectedOption();
		String selectedLocationType = (firstOption.getText().trim()).replace("\n", "");

		// Conditional statements - <SELECTED LOCATION TYPE>
		if (selectedLocationType.equals(obj.getProperty("selectedLocationType"))) {
			logger.log(LogStatus.PASS, "Location Type is shown correctly");
		} else {
			logger.log(LogStatus.FAIL, "Location Type is showing wrong");
			Assert.fail("Location Type is showing wrong");
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyDefaultCity() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify the default options selected in city drop-down list</b>");

		// Getting data
		Select drpCityText = new Select(Utility.getElementByid(RElement.drpCity));
		WebElement firstOption = drpCityText.getFirstSelectedOption();
		String selectedCity = (firstOption.getText().trim()).replace("\n", "");

		// Conditional statements - <SELECTED CITY>
		if (selectedCity.equals(obj.getProperty("selectedCity"))) {
			logger.log(LogStatus.PASS, "The city is shown correctly");
		} else {
			logger.log(LogStatus.FAIL, "The city is showing wrong");
			Assert.fail("The city is showing wrong");
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyAllTitles() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify that all the options present in the title drop-down list</b>");

		// Conditional statements - <DROPDOWN OPTION OPTIONS>
		int optionCount = 0;
		String[] allOptions = { "Select one", "Mr.", "Mrs.", "Ms.", "Dr." };
		WebElement drpTitle = Utility.getElementByid(RElement.drpTitle);
		List<WebElement> lstTitleOptions = Utility.getDropdownValue(drpTitle, "option");
		for (WebElement titleOption : lstTitleOptions) {
			for (int i = 0; i < allOptions.length; i++) {
				if (titleOption.getText().equals(allOptions[i])) {
					optionCount++;
				}
			}
		}
		if (optionCount == allOptions.length) {
			logger.log(LogStatus.PASS, "All the options present in the title drop-down list");
		} else {
			Utility.click(Utility.getElementByid(RElement.drpTitle));
			logger.log(LogStatus.FAIL, "Insufficient options in the title drop-down list");
			Assert.fail("Insufficient options in the title drop-down list");
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyAllLocationTypes() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify that all the options present in the location type drop-down list</b>");

		// Conditional statements - <DROPDOWN OPTIONS>
		int optionCount = 0;
		String[] allOptions = { "Select One", "Residence1", "Business", "Funeral home", "Hospital", "Apartment",
				"School", "Church" };
		WebElement drpLocationType = Utility.getElementByid(RElement.drpLocationType);
		List<WebElement> lstLocationTypeOptions = Utility.getDropdownValue(drpLocationType, "option");
		System.out.println(lstLocationTypeOptions);
//		String[] abc = new String[lstLocationTypeOptions.size()];
//		for (int i = 0; i < lstLocationTypeOptions.size(); i++) {
//					abc[i] = (lstLocationTypeOptions.get(i).getText().trim()).replace("\n", "");
//		}
		for (WebElement locationTypeOption : lstLocationTypeOptions) {
			for (int i = 0; i < allOptions.length; i++) {
				if ((locationTypeOption.getText().trim()).replace("\n", "").equals(allOptions[i])) {
					optionCount++;
					System.out.println((locationTypeOption.getText().trim()).replace("\n", ""));
				}
			}
		}
		
		// Verify both the lists having same size
		if (optionCount == allOptions.length) {
			logger.log(LogStatus.PASS, "All the options present in the location type drop-down list");
		} else {
			Utility.click(Utility.getElementByid(RElement.drpLocationType));
			logger.log(LogStatus.FAIL, "Insufficient options in the location type drop-down list");
			Assert.fail("Insufficient options in the location type drop-down list");
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyExpectedTitle() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify whether the title drop-down list values are as expected</b>");

		// Create a webelement for the drop-down
		WebElement drpLocationType = Utility.getElementByid(RElement.drpLocationType);
		
		// Retrieve all drop-down options and store in actual list
		List<WebElement> lstLocationTypeOptions = Utility.getDropdownValue(drpLocationType, "option");

		// Conditional statements - <DROPDOWN OPTIONS>
		for (WebElement locationTypeOption : lstLocationTypeOptions) {
			locationTypeOption.click();
		}
		
		// Instantiate Select class with the drop-down webelement
		Select drpTitleText = new Select(Utility.getElementByid(RElement.drpTitle));
		drpTitleText.selectByValue(obj.getProperty("recipientTitle"));

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyExpectedLocationTypes() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify that all the options present in the location type drop-down list</b>");

		// Create a webelement for the drop-down
		WebElement drpLocationType = Utility.getElementByid(RElement.drpLocationType);
		
		// Retrieve all drop-down options and store in actual list
		List<WebElement> lstLocationTypeOptions = Utility.getDropdownValue(drpLocationType, "option");
		
		// Conditional statements - <DROPDOWN OPTIONS>
		for (WebElement locationTypeOption : lstLocationTypeOptions) {
			locationTypeOption.click();
		}
		
		// Instantiate Select class with the drop-down webelement
		Select drpLocationTypeText = new Select(Utility.getElementByid(RElement.drpLocationType));
		drpLocationTypeText.selectByValue(obj.getProperty("recipientLocationType"));

		// Implicitly wait
		Utility.implicitlyWait();
	}
}

//https://stackoverflow.com/questions/22651007/how-to-compare-the-drop-down-options-is-matching-with-the-ui-options-in-selenium
package com.flowers.action;

import org.testng.Assert;

import com.flowers.elements.E07_AddedToYourCart;
import com.flowers.utils.TestBase;
import com.flowers.utils.Utility;
import com.relevantcodes.extentreports.LogStatus;

public class A07_AddedToYourCart extends TestBase {

	E07_AddedToYourCart ATYCElement = new E07_AddedToYourCart();

	public void verifyToYourCartTestCase() throws Exception {
		// Start report
		logger = report.startTest("Added To Your Cart Pop-up");

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyCartShippingProdCode() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify code of the product is added to cart pop-up</b>");

		// Getting data
		String cartShippingProdCode = Utility.getText(Utility.getElementByxpath(ATYCElement.lblShippingProdCode));
		String prodCode = cartShippingProdCode.replace("Item # :    \n", "");

		// Conditional statements - <SHIPPING PRODUCT CODE>
		if (prodCode.equals(obj.getProperty("cartShippingProdCode"))) {
			logger.log(LogStatus.PASS, "Code of the product is showing correctly");
		} else {
			logger.log(LogStatus.FAIL, "Code of the product is showing wrong");
			Assert.assertEquals(prodCode, obj.getProperty("cartShippingProdCode"));
		}
		
		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyCartShippingProdName() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify the name of the product is added to cart pop-up</b>");

		// Getting data
		String cartShippingProdName = Utility.getText(Utility.getElementByxpath(ATYCElement.lblShippingProdName));

		// Conditional statements - <SHIPPING PRODUCT NAME>
		if (cartShippingProdName.contains(obj.getProperty("cartShippingProdName"))) {
			logger.log(LogStatus.PASS, "Name of the product is showing correctly");
		} else {
			logger.log(LogStatus.FAIL, "Name of the product is showing wrong");
			Assert.assertEquals(cartShippingProdName, obj.getProperty("cartShippingProdName"));
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyCartShippingProdQty() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify quantity of the product is added to cart pop-up</b>");

		// Getting data
		String cartShippingProdQty = Utility.getText(Utility.getElementByxpath(ATYCElement.lblShippingProdQty));
		String prodQty = cartShippingProdQty.replace("Quantity : \n", "");

		// Conditional statements - <SHIPPING PRODUCT QUANTITY>
		if (prodQty.equals(obj.getProperty("cartShippingProdQty"))) {
			logger.log(LogStatus.PASS, "Quantity of the product is showing correctly");
		} else {
			logger.log(LogStatus.FAIL, "Quantity of the product is showing wrong");
			Assert.assertEquals(prodQty, obj.getProperty("cartShippingProdQty"));
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyCartShippingProdPrice() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify price of the product is added to cart pop-up</b>");

		// Getting data
		String cartShippingProdPrice = Utility.getText(Utility.getElementByxpath(ATYCElement.lblShippingProdPrice));

		// Conditional statements - <SHIPPING PRODUCT PRICE>
		if (cartShippingProdPrice.equals(obj.getProperty("cartShippingProdPrice"))) {
			logger.log(LogStatus.PASS, "Price of the product is showing correctly");
		} else {
			logger.log(LogStatus.FAIL, "Price of the product is showing wrong");
			Assert.assertEquals(cartShippingProdPrice, obj.getProperty("cartShippingProdPrice"));
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyCartItemsCount() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify added to your cart pop-up should show 1 item(s) in cart</b>");

		// Getting data
		String cartItem = Utility.getText(Utility.getElementByxpath(ATYCElement.lblCartItem));

		// Conditional statements - <SHIPPING PRODUCT PRICE>
		if (cartItem.equals(obj.getProperty("cartItem"))) {
			logger.log(LogStatus.PASS, "1 item(s) in cart is showing correctly");
		} else {
			logger.log(LogStatus.FAIL, "1 item(s) in cart is showing wrong");
			Assert.assertEquals(cartItem, obj.getProperty("cartItem"));
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyCartSubTotals() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify subtotal is added to your cart pop-up</b>");

		// Getting data
		String cartSubTotals = Utility.getText(Utility.getElementByxpath(ATYCElement.lblSubTotals));

		// Conditional statements - <SHIPPING PRODUCT PRICE>
		if (cartSubTotals.equals(obj.getProperty("cartSubTotals"))) {
			logger.log(LogStatus.PASS, "Subtotal in the cart is showing correctly");
		} else {
			logger.log(LogStatus.FAIL, "Subtotal in the cart is showing wrong");
			Assert.assertEquals(cartSubTotals, obj.getProperty("cartSubTotals"));
		}

		// Implicitly wait
		Utility.implicitlyWait();

		// Report ended
		report.endTest(logger);
	}
}
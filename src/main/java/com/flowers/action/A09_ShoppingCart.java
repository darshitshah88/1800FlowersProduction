package com.flowers.action;

import org.testng.Assert;

import com.flowers.elements.E09_ShoppingCart;
import com.flowers.utils.TestBase;
import com.flowers.utils.Utility;
import com.relevantcodes.extentreports.LogStatus;

public class A09_ShoppingCart extends TestBase {

	E09_ShoppingCart SCElement = new E09_ShoppingCart();

	public void verifyShoppingCartTestCase() throws Exception {
		// Start report
		logger = report.startTest("Shopping Cart Page");

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyViewCartLink() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify view cart link navigate to shopping cart page</b>");

		// Conditional statements - <VIEW CART LINK>
		if (!Utility.getElementByid(SCElement.lnkViewCart).getSize().equals(null)) {
			Thread.sleep(10000);
			Utility.click(Utility.getElementByid(SCElement.lnkViewCart));
			logger.log(LogStatus.PASS, "View cart link is shown, it navigates to shopping cart page");
		} else {
			logger.log(LogStatus.FAIL, "View cart link does not show properly");
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyShoppingCartTitle() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify the page title</b>");

		// Conditional statements - <PAGE TITLE>
		String pageTitle = driver.getTitle();
		if (pageTitle.contentEquals(obj.getProperty("shoppingCartTitle"))) {
			logger.log(LogStatus.PASS, "Shopping cart page title verified");
		} else {
			logger.log(LogStatus.FAIL, "Shopping cart page title not verified");
			Assert.assertEquals(pageTitle, obj.getProperty("shoppingCartTitle"));
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyCartQuantity() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify shopping cart quantity after continue shopping</b>");

		// Getting data
		String lblCartQuantity = Utility.getText(Utility.getElementByid(SCElement.lblCartQuantity));

		// Conditional statements - <CART QUANTITY>
		if (lblCartQuantity.equals(obj.getProperty("miniCartQuantity"))) {
			logger.log(LogStatus.PASS, "After continuing shopping cart quantity is showing correctly");
		} else {
			logger.log(LogStatus.FAIL, "After continuing shopping cart quantity is showing wrong");
			Assert.assertEquals(lblCartQuantity, obj.getProperty("miniCartQuantity"));
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyCartSubTotal() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify shopping cart subtotal after continue shopping</b>");

		// Getting data
		String lblCartSubTotal = Utility.getText(Utility.getElementByxpath(SCElement.lblCartSubTotal));

		// Conditional statements - <CART SUBTOTAL>
		if (lblCartSubTotal.equals(obj.getProperty("miniCartSubTotals"))) {
			logger.log(LogStatus.PASS, "After continuing shopping cart subtotal showing correctly");
		} else {
			logger.log(LogStatus.FAIL, "After continuing shopping cart subtotal showing wrong");
			Assert.assertEquals(lblCartSubTotal, obj.getProperty("miniCartSubTotals"));
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyCartDiscount() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify shopping cart discount after removing the item</b>");

		// Getting data
		String lblCartDiscount = Utility.getText(Utility.getElementByxpath(SCElement.lblCartDiscount));

		// Conditional statements - <CART DISCOUNT AFTER REMOVED ITEM>
		if (lblCartDiscount.equals(obj.getProperty("shoppingCartDiscount"))) {
			logger.log(LogStatus.PASS, "After removing the item, cart discount is showing correctly");
		} else {
			logger.log(LogStatus.FAIL, "After removing the item, cart discount is showing wrong");
			Assert.assertEquals(lblCartDiscount, obj.getProperty("shoppingCartDiscount"));
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyItemRemove() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify removing one item from the shopping cart</b>");

		// Clicking on remove button
		Utility.click(Utility.getElementByid(SCElement.btnRemove));
		Thread.sleep(5000);

		// Conditional statements - <REMOVE BUTTON>
		try {
			if (Utility.getElementByid(SCElement.btnRemove).getSize().equals(null)) {
				logger.log(LogStatus.PASS, "Item removed successfully");
			} else {
				logger.log(LogStatus.FAIL, "Item is showing");
				Assert.fail("expected [Only one item should be displayed] but found [Multiple items are showing]");
			}
		} catch (Exception e) {
			logger.log(LogStatus.PASS, "Item removed successfully");
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyRemoveItemCartQuantity() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify shopping cart quantity after removing the item</b>");

		// Getting data
		String lblRemoveItemCartQuantity = Utility.getText(Utility.getElementByid(SCElement.lblRItemCartQuantity));

		// Conditional statements - <CART QUANTITY AFTER REMOVED ITEM>
		if (lblRemoveItemCartQuantity.equals(obj.getProperty("removeItemCartQuantity"))) {
			logger.log(LogStatus.PASS, "After removing the item, cart quantity is showing correctly");
		} else {
			logger.log(LogStatus.FAIL, "After removing the item, cart quantity is showing wrong");
			Assert.assertEquals(lblRemoveItemCartQuantity, obj.getProperty("removeItemCartQuantity"));
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyRemoveItemCartSubTotal() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify shopping cart subtotal after removing the item</b>");

		// Getting data
		String lblRemoveItemCartSubTotal = Utility.getText(Utility.getElementByxpath(SCElement.lblRItemCartSubTotal));

		// Conditional statements - <CART SUBTOTAL AFTER REMOVED ITEM>
		if (lblRemoveItemCartSubTotal.equals(obj.getProperty("removeItemCartSubTotals"))) {
			logger.log(LogStatus.PASS, "After removing the item, cart subtotal showing correctly");
		} else {
			logger.log(LogStatus.FAIL, "After removing the item, cart subtotal showing wrong");
			Assert.assertEquals(lblRemoveItemCartSubTotal, obj.getProperty("removeItemCartSubTotals"));
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyCheckout() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify whether user are able to proceed to checkout</b>");

		// Clicking on checkout button
		Utility.click(Utility.getElementByid(SCElement.btnCheckout));

		// Getting data
		String lblCheckOutGuest = Utility.getText(Utility.getElementByxpath(SCElement.lblCheckOutGuest));

		// Conditional statements - <INVALID SEARCH>
		if (lblCheckOutGuest.equals(obj.getProperty("txtCheckOutGuest"))) {
			logger.log(LogStatus.PASS, "The user is redirected to the recipient's page");
		} else {
			logger.log(LogStatus.FAIL, "There's some error while redirecting to the recipient's page");
			Assert.assertEquals(lblCheckOutGuest, obj.getProperty("txtCheckOutGuest"));
		}

		// Implicitly wait
		Utility.implicitlyWait();

		// Report ended
		report.endTest(logger);
	}
}
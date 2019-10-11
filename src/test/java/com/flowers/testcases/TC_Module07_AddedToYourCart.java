package com.flowers.testcases;

import org.testng.annotations.Test;

import com.flowers.action.A07_AddedToYourCart;
import com.flowers.utils.TestBase;

public class TC_Module07_AddedToYourCart extends TestBase {

	A07_AddedToYourCart ATYCAction = new A07_AddedToYourCart();

	@Test(priority = 1)
	public void verifyToYourCartTestCase() throws Exception {
		ATYCAction.verifyToYourCartTestCase();
	}

	@Test(priority = 2)
	public void verifyCartShippingProdCode() throws Exception {
		ATYCAction.verifyCartShippingProdCode();
	}
	
	@Test(priority = 3)
	public void verifyCartShippingProdName() throws Exception {
		ATYCAction.verifyCartShippingProdName();
	}
	
	@Test(priority = 4)
	public void verifyCartShippingProdQty() throws Exception {
		ATYCAction.verifyCartShippingProdQty();
	}
	
	@Test(priority = 5)
	public void verifyCartShippingProdPrice() throws Exception {
		ATYCAction.verifyCartShippingProdPrice();
	}
	
	@Test(priority = 6)
	public void verifyCartItemsCount() throws Exception {
		ATYCAction.verifyCartItemsCount();
	}
	
	@Test(priority = 7)
	public void verifyCartSubTotals() throws Exception {
		ATYCAction.verifyCartSubTotals();
	}
}
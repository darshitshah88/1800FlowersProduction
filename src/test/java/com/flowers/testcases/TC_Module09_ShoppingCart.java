package com.flowers.testcases;

import org.testng.annotations.Test;

import com.flowers.action.A09_ShoppingCart;
import com.flowers.utils.TestBase;

public class TC_Module09_ShoppingCart extends TestBase {

	A09_ShoppingCart SCAction = new A09_ShoppingCart();

	@Test(priority = 1)
	public void verifyShoppingCartTestCase() throws Exception {
		SCAction.verifyShoppingCartTestCase();
	}

	@Test(priority = 2)
	public void verifyViewCartLink() throws Exception {
		SCAction.verifyViewCartLink();
	}

	@Test(priority = 3)
	public void verifyShoppingCartTitle() throws Exception {
		SCAction.verifyShoppingCartTitle();
	}

	@Test(priority = 4)
	public void verifyCartQuantity() throws Exception {
		SCAction.verifyCartQuantity();
	}

	@Test(priority = 5)
	public void verifyCartSubTotal() throws Exception {
		SCAction.verifyCartSubTotal();
	}
	
	@Test(priority = 6)
	public void verifyItemRemove() throws Exception {
		SCAction.verifyItemRemove();
	}
	
	@Test(priority = 7)
	public void verifyRemoveItemCartQuantity() throws Exception {
		SCAction.verifyRemoveItemCartQuantity();
	}
	
	@Test(priority = 8)
	public void verifyCartDiscount() throws Exception {
		SCAction.verifyCartDiscount();
	}
	
	@Test(priority = 9)
	public void verifyRemoveItemCartSubTotal() throws Exception {
		SCAction.verifyRemoveItemCartSubTotal();
	}
	
	@Test(priority = 10)
	public void verifyCheckout() throws Exception {
		SCAction.verifyCheckout();
	}
}
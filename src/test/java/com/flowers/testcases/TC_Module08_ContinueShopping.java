package com.flowers.testcases;

import org.testng.annotations.Test;

import com.flowers.action.A08_ContinueShopping;
import com.flowers.utils.TestBase;

public class TC_Module08_ContinueShopping extends TestBase {

	A08_ContinueShopping CSAction = new A08_ContinueShopping();

	@Test(priority = 1)
	public void verifyContinueShoppingTestCase() throws Exception {
		CSAction.verifyContinueShoppingTestCase();
	}

	@Test(priority = 2)
	public void verifyContinueShoppingLink() throws Exception {
		CSAction.verifyContinueShoppingLink();
	}

	@Test(priority = 3)
	public void verifyDatePickerControlOpen() throws Exception {
		CSAction.verifyDatePickerControlOpen();
	}

	@Test(priority = 4)
	public void verifyCalMonthYear() throws Exception {
		CSAction.verifyCalMonthYear();
	}

	@Test(priority = 5)
	public void verifyCalStdDate() throws Exception {
		CSAction.verifyCalStdDate();
	}

	@Test(priority = 6)
	public void verifyDatePickerControlClose() throws Exception {
		CSAction.verifyDatePickerControlClose();
	}

	@Test(priority = 7)
	public void verifySelectedDeliveryDate() throws Exception {
		CSAction.verifySelectedDeliveryDate();
	}

	@Test(priority = 8)
	public void verifyAddToCartPopup() throws Exception {
		CSAction.verifyAddToCartPopup();
	}
}
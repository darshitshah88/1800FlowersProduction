package com.flowers.testcases;

import org.testng.annotations.Test;

import com.flowers.action.A06_ProductDescription;
import com.flowers.utils.TestBase;

public class TC_Module06_ProductDescription extends TestBase {

	A06_ProductDescription PDPAction = new A06_ProductDescription();

	@Test(priority = 1)
	public void verifyProductDescriptionPageTestCase() throws Exception {
		PDPAction.verifyProductDescriptionPageTestCase();
	}

	@Test(priority = 2)
	public void verifyProductDescriptionPageTitle() throws Exception {
		PDPAction.verifyProductDescriptionPageTitle();
	}

	@Test(priority = 3)
	public void verifyBlankDataFields() throws Exception {
		PDPAction.verifyBlankDataFields();
	}

	@Test(priority = 4)
	public void verifyDatePickerControl() throws Exception {
		PDPAction.verifyDatePickerControlOpen();
	}

	@Test(priority = 5)
	public void verifyPreviousLink() throws Exception {
		PDPAction.verifyPreviousLink();
	}

	@Test(priority = 6)
	public void verifyNextLink() throws Exception {
		PDPAction.verifyNextLink();
	}

	@Test(priority = 7)
	public void verifyNextPreviousLink() throws Exception {
		PDPAction.verifyNextPreviousLink();
	}

	@Test(priority = 8)
	public void verifyCalMonthYear() throws Exception {
		PDPAction.verifyCalMonthYear();
	}

	@Test(priority = 9)
	public void verifyCalStdDate() throws Exception {
		PDPAction.verifyCalStdDate();
	}

	@Test(priority = 10)
	public void verifyDatePickerControlClose() throws Exception {
		PDPAction.verifyDatePickerControlClose();
	}

	@Test(priority = 11)
	public void verifySelectedDeliveryDate() throws Exception {
		PDPAction.verifySelectedDeliveryDate();
	}

	@Test(priority = 12)
	public void verifyAddToCartPopup() throws Exception {
		PDPAction.verifyAddToCartPopup();
	}
}
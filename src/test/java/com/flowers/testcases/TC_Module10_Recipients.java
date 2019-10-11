package com.flowers.testcases;

import org.testng.annotations.Test;

import com.flowers.action.A10_Recipients;
import com.flowers.utils.TestBase;

public class TC_Module10_Recipients extends TestBase {

	A10_Recipients RAction = new A10_Recipients();

	@Test(priority = 1)
	public void verifyRecipientsTestCase() throws Exception {
		RAction.verifyRecipientsTestCase();
	}

	@Test(priority = 2)
	public void verifyRecipientsTitle() throws Exception {
		RAction.verifyRecipientsTitle();
	}

	@Test(priority = 3)
	public void verifyProductDetails() throws Exception {
		RAction.verifyProductDetails();
	}

	@Test(priority = 4)
	public void verifyBlankFieldsWithCity() throws Exception {
		RAction.verifyBlankFieldsWithCity();
	}

	@Test(priority = 5)
	public void verifyBlankFieldsWithoutCity() throws Exception {
		RAction.verifyBlankFieldsWithoutCity();
	}

	@Test(priority = 6)
	public void verifyDefaultTitle() throws Exception {
		RAction.verifyDefaultTitle();
	}

	@Test(priority = 7)
	public void verifyDefaultLocationType() throws Exception {
		RAction.verifyDefaultLocationType();
	}

	@Test(priority = 8)
	public void verifyDefaultCity() throws Exception {
		RAction.verifyDefaultCity();
	}

	@Test(priority = 9)
	public void verifyAllTitles() throws Exception {
		RAction.verifyAllTitles();
	}

	@Test(priority = 10)
	public void verifyAllLocationTypes() throws Exception {
		RAction.verifyAllLocationTypes();
	}

	@Test(priority = 11)
	public void verifyExpectedTitle() throws Exception {
		RAction.verifyExpectedTitle();
	}

	@Test(priority = 12)
	public void verifyExpectedLocationTypes() throws Exception {
		RAction.verifyExpectedLocationTypes();
	}
}
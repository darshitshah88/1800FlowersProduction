package com.flowers.testcases;

import org.testng.annotations.Test;

import com.flowers.action.A05_SearchByProductCode;
import com.flowers.utils.TestBase;

public class TC_Module05_SearchByProductCode extends TestBase {

	A05_SearchByProductCode SBPCAction = new A05_SearchByProductCode();

	@Test(priority = 1)
	public void verifySearchByProductCodeTestCase() throws Exception {
		SBPCAction.verifySearchByProductCodeTestCase();
	}

	@Test(priority = 2)
	public void verifyBlankSearch() throws Exception {
		SBPCAction.verifyBlankSearch();
	}

	@Test(priority = 3)
	public void verifyInvalidSearch() throws Exception {
		SBPCAction.verifyInvalidSearch();
	}

	@Test(priority = 4)
	public void verifySearchResultsTitle() throws Exception {
		SBPCAction.verifySearchResultsTitle();
	}

	@Test(priority = 5)
	public void verifyValidSearch() throws Exception {
		SBPCAction.verifyValidSearch();
	}
}
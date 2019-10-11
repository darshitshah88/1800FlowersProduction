package com.flowers.testcases;

import org.testng.annotations.Test;

import com.flowers.action.A04_SearchByKeyword;
import com.flowers.utils.TestBase;

public class TC_Module04_SearchByKeyword extends TestBase {

	A04_SearchByKeyword SBKAction = new A04_SearchByKeyword();

	@Test(priority = 1)
	public void verifySearchByKeywordTestCase() throws Exception {
		SBKAction.verifySearchByKeywordTestCase();
	}

	@Test(priority = 2)
	public void verifyBlankSearch() throws Exception {
		SBKAction.verifyBlankSearch();
	}

	@Test(priority = 3)
	public void verifyInvalidSearch() throws Exception {
		SBKAction.verifyInvalidSearch();
	}

	@Test(priority = 4)
	public void verifySearchResultsTitle() throws Exception {
		SBKAction.verifySearchResultsTitle();
	}

	@Test(priority = 5)
	public void verifyNumberOfSearchResults() throws Exception {
		SBKAction.verifyNumberOfSearchResults();
	}

	@Test(priority = 6)
	public void verifySearchResultsFirst() throws Exception {
		SBKAction.verifySearchResultsFirst();
	}

	@Test(priority = 7)
	public void verifyValidSearch() throws Exception {
		SBKAction.verifyValidSearch();
	}
}
package com.flowers.action;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.flowers.elements.E04_SearchByKeyword;
import com.flowers.utils.TestBase;
import com.flowers.utils.Utility;
import com.relevantcodes.extentreports.LogStatus;

public class A04_SearchByKeyword extends TestBase {

	E04_SearchByKeyword SBKElement = new E04_SearchByKeyword();

	public void verifySearchByKeywordTestCase() throws Exception {
		// Start report
		logger = report.startTest("Search By Keyword");

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyBlankSearch() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify click the search button without entering any keyword</b>");

		// Without entering data into elements, click the button
		Utility.click(Utility.getElementByid(SBKElement.btnSearch));

		// Getting data
		String alertText = driver.switchTo().alert().getText();

		// Conditional statements - <ALERT>
		if (alertText.equals(obj.getProperty("alertSearchText"))) {
			logger.log(LogStatus.PASS, "Validation message is displayed in the pop-up");
			Utility.alertAccept();
		} else {
			logger.log(LogStatus.FAIL, "There's some error while verifying validation message");
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyInvalidSearch() throws Exception {
		// Test case information
		String searchKeyward = obj.getProperty("invalidKeyword");
		logger.log(LogStatus.INFO, "<b>Verify search response for a invalid keyword: " + searchKeyward + "</b>");

		// Enter data into element, click the button
		Utility.sendKeys(Utility.getElementByid(SBKElement.txtSearch), searchKeyward);
		Utility.click(Utility.getElementByid(SBKElement.btnSearch));

		// Conditional statements - <INVALID SEARCH>
		if (!Utility.getElementByid(SBKElement.validationSearchResult).getSize().equals(null)) {
			logger.log(LogStatus.PASS, "Validation message is displayed for the keyword: " + searchKeyward);
		} else {
			logger.log(LogStatus.FAIL, "There's some error while verifying validation message");
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifySearchResultsTitle() throws Exception {
		// Test case information
		logger.log(LogStatus.INFO, "<b>Verify the page title</b>");

		// Conditional statements - <PAGE TITLE>
		String pageTitle = driver.getTitle();
		if (pageTitle.contentEquals(obj.getProperty("searchResultsTitle"))) {
			logger.log(LogStatus.PASS, "Search result page title verified");
		} else {
			logger.log(LogStatus.FAIL, "Search result page title not verified");
			Assert.assertEquals(pageTitle, obj.getProperty("searchResultsTitle"));
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyNumberOfSearchResults() throws Exception {
		// Test case information
		String searchKeyward = obj.getProperty("validKeyword1");
		logger.log(LogStatus.INFO, "<b>Verify the total number of results for the keyword: " + searchKeyward + "</b>");

		// Enter data into element, click the button
		Utility.sendKeys(Utility.getElementByid(SBKElement.txtSearch), searchKeyward);
		Utility.click(Utility.getElementByid(SBKElement.btnSearch));

		// Getting data
		String prdouctCount = Utility.getText(Utility.getElementByxpath(SBKElement.lblPrdouctCount));

		// Conditional statements - <NUMBER OF PAGINATION>
		int numberOfProductPerPage = 150;
		double pageCountMin = Double.parseDouble(prdouctCount) / numberOfProductPerPage;
		int pageCountMax = (int) pageCountMin;
		if (pageCountMin > pageCountMax) {
			pageCountMax++;
		}

		// Conditional statements - <PRODUCT TOTAL>
		int sumOfProduct = 0;
		for (int i = 1; i < pageCountMax; i++) {
			WebElement productList = Utility.getElementByxpath(SBKElement.lstProductList);
			List<WebElement> listOfProductName = Utility.getElementByclass(productList, "Product__name");
			sumOfProduct = sumOfProduct + listOfProductName.size();
			Utility.click(SBKElement.lblPageNumber(i));
		}
		WebElement productList = Utility.getElementByxpath(SBKElement.lstProductList);
		List<WebElement> listOfProductName = Utility.getElementByclass(productList, "Product__name");
		sumOfProduct = sumOfProduct + listOfProductName.size();

		// Conditional statements - <TOTAL NUMBER OF PRODUCT>
		if (sumOfProduct == Integer.parseInt(prdouctCount)) {
			logger.log(LogStatus.PASS, "Total number of the results for a keyword: " + searchKeyward + " are verified");
		} else {
			logger.log(LogStatus.FAIL, "Total number of the results for a keyword: " + searchKeyward + " are wrong");
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifySearchResultsFirst() throws Exception {
		// Test case information
		String searchKeyward = obj.getProperty("validKeyword2");
		logger.log(LogStatus.INFO, "<b>Verify the result for keyword: " + searchKeyward + " is displayed on first</b>");

		// Enter data into element, click the button
		Utility.sendKeys(Utility.getElementByid(SBKElement.txtSearch), searchKeyward);
		Utility.click(Utility.getElementByid(SBKElement.btnSearch));

		// Getting data
		String firstProductName = Utility.getText(Utility.getElementByxpath(SBKElement.lblNameProduct));

		// Conditional statements - <RELEVANT SEARCH PRODUCT>
		if (firstProductName.equals(searchKeyward)) {
			logger.log(LogStatus.PASS, "Result for the keyword: " + searchKeyward + " is displayed on first");
		} else {
			logger.log(LogStatus.WARNING, "Result for the keyword: " + searchKeyward + " does not display on first");
		}

		// Implicitly wait
		Utility.implicitlyWait();
	}

	public void verifyValidSearch() throws Exception {
		// Test case information
		String searchKeyward = obj.getProperty("validKeyword3");
		logger.log(LogStatus.INFO, "<b>Verify search response for a valid keyword: " + searchKeyward + "</b>");

		// Enter data into element, click the button
		Utility.sendKeys(Utility.getElementByid(SBKElement.txtSearch), searchKeyward);
		Utility.click(Utility.getElementByid(SBKElement.btnSearch));

		// Getting data
		String prdouctCount = Utility.getText(Utility.getElementByxpath(SBKElement.lblPrdouctCount));

		// Conditional statements - <NUMBER OF PAGINATION>
		int numberOfProductPerPage = 150;
		double pageCountMin = Double.parseDouble(prdouctCount) / numberOfProductPerPage;
		int pageCountMax = (int) pageCountMin;
		if (pageCountMin > pageCountMax) {
			pageCountMax++;
		}

		boolean flag = false;
		for (int i = 0; i < pageCountMax; i++) {
			if (i > 0) {
				Utility.click(SBKElement.lblPageNumber(i));
			}

			// Conditional statements - <PRODUCT NAME SEARCH>
			WebElement productList = Utility.getElementByxpath(SBKElement.lstProductList);
			List<WebElement> listOfProductName = Utility.getElementByclass(productList, "Product__name");

			for (WebElement product : listOfProductName) {
				// Getting data
				String productName = product.getText();
				if (productName.equals(searchKeyward)) {
					flag = true;
					product.click();

					// Conditional statements - <PRODUCT KEYWORD>
					String productDesc = Utility.getText(Utility.getElementByxpath(SBKElement.lblTopLinks));
					if (productDesc.contains(searchKeyward)) {
						logger.log(LogStatus.PASS, "Navigate to keyword: " + searchKeyward + " page");
					} else {
						logger.log(LogStatus.FAIL, "There's some error while verifying keyword: " + searchKeyward);
					}
					listOfProductName.remove(product);
					break;
				}
			}
			if (flag) {
				break;
			}
		}
		if (!flag) {
			logger.log(LogStatus.FAIL, "There's some error while verifying keyword: " + searchKeyward);
		}

		// Implicitly wait
		Utility.implicitlyWait();
		Thread.sleep(5000);

		// Report ended
		report.endTest(logger);
	}
}
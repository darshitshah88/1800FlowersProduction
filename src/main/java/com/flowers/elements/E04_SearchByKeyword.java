package com.flowers.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.flowers.utils.TestBase;

public class E04_SearchByKeyword extends TestBase {
	public String txtSearch = "SearchBox";
	public String btnSearch = "searchBtn";
	public String validationSearchResult = "//td[@class='searchpageerror']";
	public String lblPrdouctCount = "//body/div/div/div/div/div[1]/b[3]";
	public String lstProductList = "//div[@class='Products']";
	public String lblNameProduct = "//div[@class='Product__name']";
	public String lblTopLinks = "//span[@class='topLinks']";

	public WebElement lblPageNumber(int i) {
		WebElement element = null;
		try {
			element = driver
					.findElement(By.xpath("/html[1]/body[1]/div[7]/div[2]/div[2]/div[2]/div[2]/span[1]/a[" + i + "]"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}
}
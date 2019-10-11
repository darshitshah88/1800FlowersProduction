package com.flowers.utils;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility extends TestBase {

	private static int implicitTime = 10;
//	private static int explicitTime = 80;
//	private static WebDriverWait explicitlyWait = new WebDriverWait(driver, explicitTime);

	// Capture screenshot for fail test case
	public static String captureScreenshot(String screenshotName) {
		try {
			TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
			File srcFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
			String dest = "screenshots\\" + screenshotName + ".png";
			File destinationFile = new File(dest);
			FileUtils.copyFile(srcFile, destinationFile);
			return destinationFile.getAbsolutePath();
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot " + e.getMessage());
		}
		return screenshotName + ".png";
	}

	// Get method name for PASS and FAIL
	public static String getName(String methodName) {
		String[] splitMethodName = methodName.split("(?<=.)(?=\\p{Lu})");
		String strMethodName = Arrays.toString(splitMethodName);
		strMethodName = strMethodName.substring(1, strMethodName.length() - 1);
		String covertMethodName = strMethodName.replace(",", "").replace("verify ", "");
		return covertMethodName;
	}

	// Get the web element using ID
	public static WebElement getElementByid(String id) throws Exception {
		WebElement element = null;
		try {
			element = driver.findElement(By.id(id));
			// element =
			// explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
		} catch (Exception e) {
			throw e;
		}
		return element;
	}

	// Get the web element using XPath
	public static WebElement getElementByxpath(String xpath) throws Exception {
		WebElement element = null;
		try {
			element = driver.findElement(By.xpath(xpath));
			// element =
			// explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		} catch (Exception e) {
			throw e;
		}
		return element;
	}

	// Get the web element using list class
	public static List<WebElement> getElementByclass(WebElement listElements, String className) throws Exception {
		List<WebElement> element;
//		List<WebElement> classLocator;
		try {
			element = listElements.findElements(By.className(className));
//			classLocator = listElements.findElements(By.className(className));
//			element = explicitlyWait.until(ExpectedConditions.visibilityOfAllElements(classLocator));
		} catch (Exception e) {
			throw e;
		}
		return element;
	}

	// Get the web element using a list CSS selector
	public static List<WebElement> getElementBycssSelector(WebElement listElements, String cssSelector)
			throws Exception {
		List<WebElement> element;
		List<WebElement> cssSelectorLocator;
		try {
			element = listElements.findElements((By.cssSelector(cssSelector)));
//			cssSelectorLocator = listElements.findElements(By.cssSelector(cssSelector));
//			element = explicitlyWait.until(ExpectedConditions.visibilityOfAllElements(cssSelectorLocator));
		} catch (Exception e) {
			throw e;
		}
		return element;
	}

	public static List<WebElement> getDropdownValue1(WebElement listElements, String option) throws Exception {
		List<WebElement> element;
		try {
			element = listElements.findElements(By.tagName(option));
		} catch (Exception e) {
			throw e;
		}
		return element;
	}

	// Get the element for drop-down list
	public static List<WebElement> getDropdownValue(WebElement listElements, String option) throws Exception {
		List<WebElement> element;
		try {
			element = listElements.findElements(By.tagName(option));
		} catch (Exception e) {
			throw e;
		}
		return element;
	}

	// Click the element
	public static void click(WebElement element) {
		element.click();
	}

	// Sendkeys to the element
	public static void sendKeys(WebElement element, String sendkey) {
		element.sendKeys(sendkey);
	}

	// Clear the element
	public static void clear(WebElement element) {
		element.clear();
	}

	// Get text of the element
	public static String getText(WebElement element) {
		return element.getText();
	}

	// Get attribute of the element
	public static String getAttribute(WebElement element, String name) {
		return element.getAttribute(name);
	}

	// Implicitly wait
	public static void implicitlyWait() {
		driver.manage().timeouts().implicitlyWait(implicitTime, TimeUnit.SECONDS);
	}

	// Reload the page
	public static void pageReload() {
		driver.navigate().refresh();
	}

	// Alert accept
	public static void alertAccept() {
		driver.switchTo().alert().accept();
	}

	// Instantiating the javascript executor and clicking into the element
	public static void javascriptClick(WebElement element, WebDriver driver) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	// Element is displayed or not
//	public static boolean isDisplayed(By by) {
//		boolean flag;
//		try {
//			driver.findElement(by).isDisplayed();
//			flag = true;
//		} catch (Exception e) {
//			System.out.println("Element Not present : " + by);
//			flag = false;
//		}
//		return flag;
//	}
//	
	// Wait for element visible
//	public static void waitForElementVisible(WebDriver driver, WebElement element, ExtentTest logger) {
//		try {
//			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element)); 
//		} catch (Exception e) {
//			logger.log(LogStatus.ERROR, "Element is not found");
//			Assert.assertTrue(element.isDisplayed());
//		}
//	}
}
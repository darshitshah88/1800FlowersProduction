package com.flowers.utils;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {

	public static WebDriver driver;
	public static Properties obj;
	public static ExtentReports report;
	public static ExtentTest logger;
	private ChromeOptions chromeOptions = new ChromeOptions();
	private FirefoxOptions firefoxOptions = new FirefoxOptions();

	@BeforeSuite
	public void startExecution() throws Exception {
		// Load configuration properties file
		obj = new Properties();
		FileInputStream objfile = new FileInputStream("./src/main/java/com/flowers/config/configuation.properties");
		obj.load(objfile);

		if (obj.getProperty("browserName").equals("Chrome")) {
			// Declaration and instantiation of webdriver/objects/variables
			System.setProperty("webdriver.chrome.driver", obj.getProperty("chromeDriver"));
			chromeOptions.addArguments("--disable-notifications");
			// Create an instance of the driver
			driver = new ChromeDriver(chromeOptions);
		} else if (obj.getProperty("browserName").equals("Firefox")) {
			// Declaration and instantiation of webdriver/objects/variables
			System.setProperty("webdriver.gecko.driver", obj.getProperty("firefoxDriver"));
			firefoxOptions.addArguments("--disable-notifications");
			// Create an instance of the driver
			driver = new FirefoxDriver(firefoxOptions);
		} else if (obj.getProperty("browserName").equals("IE")) {
			// Declaration and instantiation of webdriver/objects/variables
			System.setProperty("webdriver.ie.driver", obj.getProperty("IEDriver"));
			// Create an instance of the driver
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("No Matching browser found for  " + obj.getProperty("browserName"));
			stopExecution();
		}
		
		// Delete all cookies
		driver.manage().deleteAllCookies();

		// Maximize the browser window
		driver.manage().window().maximize();

		// Launch the browser and open the application URL
		driver.get(obj.getProperty("URL"));

		// Calling extent report
		report = ExtentReport.GetExtent();
	}

	@AfterMethod
	public void getResult(ITestResult testResult) {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			// Conditional statements - <METHOD NAME FAILED>
			String methodName = Utility.getName(testResult.getMethod().getMethodName());
			System.out.println("Test case status > FAILED - Test case method name > " + methodName);

			// Conditional statements - <SCREENSHOT WITH DATE>
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			Date currentDate = new Date();
			String screenshotPath = Utility.captureScreenshot("img" + dateFormat.format(currentDate));
			String captureImage = logger.addScreenCapture(screenshotPath);
			logger.log(LogStatus.FAIL, "Test case failed snapshot is below " + captureImage);
			logger.log(LogStatus.ERROR, testResult.getThrowable());
		} else {
			// Conditional statements - <METHOD NAME FAILED>
			String methodName = Utility.getName(testResult.getMethod().getMethodName());
			System.out.println("Test case status > PASSED - Test case method name > " + methodName);
		}
	}

	@AfterSuite
	public void stopExecution() throws Exception {
		// It is shut down the web driver instance or destroy the web driver instance
		// driver.quit();

		// It ends the current test and prepares to create an HTML report
		logger.log(LogStatus.PASS, "Browser closed successfully!");
		report.endTest(logger);

		// Writes everything to the log file
		report.flush();

		// Send an email
		SendExtentReportEmail.sendMail();
	}
}
package com.flowers.utils;

import java.util.Locale;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReport {
	
	private static ExtentReports report;
	private static ExtentTest logger;
	
	public static ExtentReports GetExtent() {
		// Initialize extent report
		report = new ExtentReports("extentreport\\1800Flowers.html", true);
		Locale.setDefault(Locale.ENGLISH);
		//report.loadConfig(new File("extentreport\\extent-config.xml"));
		return report;
		
		//https://github.com/priyankshah217/extentreports
	}
	
	public static ExtentTest createTest(String name, String desc) {
		// Starting test
		logger = report.startTest(name, desc);
		return logger;
	}
}
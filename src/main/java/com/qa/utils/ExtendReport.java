package com.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReport {
	
	public static ExtentReports generateExtentreport()
	{
		
		ExtentReports extentreport = new ExtentReports();
		File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtendReports\\TestNGProjectReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Lalit Automation Test NG Project");
		sparkReporter.config().setDocumentTitle("Lalit Report Title");
		sparkReporter.config().setTimeStampFormat("dd/mm/yyyy hh:mm:ss");
		
		extentreport.attachReporter(sparkReporter);
		
		Properties configProp = new Properties();
		File configPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\properties\\config.properties");
		try {
			FileInputStream fisConfigProp = new FileInputStream(configPropFile);
			configProp.load(fisConfigProp);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extentreport.setSystemInfo("Application URL", configProp.getProperty("url"));
		extentreport.setSystemInfo("Browser Name", configProp.getProperty("browser"));
		extentreport.setSystemInfo("User Name", System.getProperty("user.name"));
		
		return extentreport;
	}
	

}

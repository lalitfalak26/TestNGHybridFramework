package com.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.utils.ExtendReport;
import com.qa.utils.Utilities;

public class MyListeners implements ITestListener {
	
	ExtentReports extendreport;
	ExtentTest extendtest;
		
	@Override
	public void onStart(ITestContext context) {
		
		 extendreport = ExtendReport.generateExtentreport();
		
		System.out.println("Execution of Project Test Started");
		
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		
		extendtest = extendreport.createTest(result.getName());
		extendtest.log(Status.INFO, result.getName()+" Started Executing");
	
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extendtest = extendreport.createTest(result.getName());
		extendtest.log(Status.PASS, result.getName()+" Successfully Executed");
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
				
		
		WebDriver driver = null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
		}
		
		String destinationscreenshot = Utilities.captureScreenShot(driver, result.getName());
        
        
		extendtest.addScreenCaptureFromPath(destinationscreenshot);
        extendtest.log(Status.INFO, result.getThrowable());
        extendtest.log(Status.FAIL, result.getName()+" Execution Failed");
	
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		extendtest.log(Status.INFO, result.getThrowable());
		extendtest.log(Status.SKIP, result.getName()+" Execution Skipped");
	
		
	}
	

	@Override
	public void onFinish(ITestContext context) {
		
		extendreport.flush();
		
		String pathofExtendReport = System.getProperty("user.dir")+"\\test-output\\ExtendReports\\TestNGProjectReport.html";
		File extendReportFile = new File(pathofExtendReport);
		try {
			Desktop.getDesktop().browse(extendReportFile.toURI());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("Execution of Project Test Completed");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

}

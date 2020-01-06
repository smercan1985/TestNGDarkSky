package com.darksky.listeners;


import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.darksky.base.BasePage;

public class ExtentReportListener implements ITestListener {
   
	BasePage basePage = new BasePage();

	public void onFinish(ITestContext result) {
		System.out.println("Finished Test name: "+result.getName());
	}

	public void onStart(ITestContext context) {
		Reporter.log("About to begin executing test: "+context.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
	System.out.println("The name of the test case is failed: "+result.getName());
		//screenshot
//		try {
//			basePage.getScreenshot(result.getName());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

	public void onTestSkipped(ITestResult skipped) {
	System.out.println("Skipped test case name is: "+skipped.getName());
		
	}

	public void onTestStart(ITestResult result) {
		System.out.println("Test is started  :"+result.getName());		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test is passed  :"+result.getName());
		
	}

}

	

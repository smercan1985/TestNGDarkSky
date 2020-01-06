package com.darksky.tests;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.darksky.base.BasePage;
import com.darksky.pages.MainPage;
import com.darksky.pages.TimeMachine;
import com.darksky.pages.TimeZone;

public class TimeZoneTest {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	TimeZone timeZone;

	@BeforeMethod
	public void setUp(){
		basePage=new BasePage();
		prop=basePage.initialize_properties();
		driver=basePage.initialize_driver(prop);
		timeZone=new TimeZone(driver);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(description="verify the time table show correct time zone")
	public void verifyTimeZone() throws InterruptedException{
		timeZone.getLocation();
		Thread.sleep(3000);
		int timeFromTimeZone=timeZone.getCurrentTimeWithTimeZone();
				int timeFromTable=timeZone.getTwoHourLatter();
				Assert.assertEquals(timeFromTable, timeFromTimeZone);
	}
	@AfterMethod
	public void tearown(){
		basePage.quitBrowser();
	}
	
	
}

package com.darksky.tests;

import java.util.Properties;

import org.apache.log4j.Priority;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.darksky.base.BasePage;
import com.darksky.pages.MainPage;

public class MainPageTest {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	MainPage mainPage;

	@BeforeMethod
	public void setUp(){
		basePage=new BasePage();
		prop=basePage.initialize_properties();
		driver=basePage.initialize_driver(prop);
		mainPage=new MainPage(driver);
		try {
			mainPage.goToday();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority=1,description=" get today's max and min temp")
	public void getTodayMaxMinTemp() throws InterruptedException{
		mainPage.getMinTemp();
		mainPage.getMaxTemp();
	
	}
	@Test(priority=2,description="verify is today's max tempretor displayed correct")
	public void verifyMaxTemp(){
		int maxInList=mainPage.getMaxTemp();
		int maxDisplay=mainPage.displayMaxTemp();
		Assert.assertEquals(maxInList, maxDisplay);
	}
	@Test(priority=3,description="verify is today's min tempretor displayed correct")
	public void verifyMinTemp(){
		int minInList=mainPage.getMinTemp();
		int minDisplay=mainPage.displayMinTemp();
		Assert.assertEquals(minInList, minDisplay);
	}
	
	@AfterMethod
	public void tearDown(){
		basePage.quitBrowser();
	}
	
}

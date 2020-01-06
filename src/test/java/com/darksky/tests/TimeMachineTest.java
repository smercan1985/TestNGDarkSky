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

public class TimeMachineTest {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	TimeMachine timeMachine;

	@BeforeMethod
	public void setUp(){
		basePage=new BasePage();
		prop=basePage.initialize_properties();
		driver=basePage.initialize_driver(prop);
		timeMachine=new TimeMachine(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=1,description="go to Time machine and get selected date and time tempreture")
	public void doGoTimeMachine() throws InterruptedException{
		timeMachine.getLocation();
		Thread.sleep(3000);
		timeMachine.goTimeMachine();
		Thread.sleep(3000);

		
	}
	@Test(priority=2,description="In the Time machine verify 4 am tempreture")
	public void verify4AmTemp() throws InterruptedException{
		timeMachine.getLocation();
		Thread.sleep(3000);
		timeMachine.goTimeMachine();
		Thread.sleep(3000);
		int result1=timeMachine.getTempInTimeMachine();
		int result2=timeMachine.tempOf4Am();
		Assert.assertEquals(result2, result1);
	}
	
	@AfterMethod
	public void tearDown(){
		basePage.quitBrowser();
	}
}

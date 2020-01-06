package com.darksky.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.darksky.base.BasePage;
import com.darksky.pages.MainPage;
import com.darksky.pages.Registration;
import com.darksky.pages.TimeMachine;
import com.darksky.pages.TimeZone;
import com.darksky.utils.Constants;

public class RegistirationTest {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	Registration registration;

	@BeforeMethod
	public void setUp(){
		basePage=new BasePage();
		prop=basePage.initialize_properties();
		driver=basePage.initialize_driver(prop);
		registration=new Registration(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=1 ,description="entering email and password for register a new account")
	public void doRegister() throws InterruptedException{
		registration.goForRegiste(Constants.REGISTER_EMAIL, Constants.REGISTER_PASSWORD);
	}
	
	
	@Test(priority=2, description="go to do mail box, find registrition email and click verify link for register")
	public void doConfirm() throws InterruptedException{
		registration.goEmailForConfirm(prop.getProperty("username"),prop.getProperty("password"));
	}
	

	@Test(priority=3,description="get login page title for verify loged in")
	public void verifyLoginTitle() throws InterruptedException{
		String title=registration.doLogin(Constants.REGISTER_EMAIL, Constants.REGISTER_PASSWORD);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	
	@AfterMethod
	public void tearDown(){
		basePage.quitBrowser();
	}
	
}

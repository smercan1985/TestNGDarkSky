package com.darksky.pages;

import javax.print.Doc;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.darksky.base.BasePage;
import com.darksky.utils.Constants;
import com.darksky.utils.ElementUtil;

public class Registration extends BasePage {
WebDriver driver;
ElementUtil elementUtil;

By apiBtn=By.xpath("//nav//div//a[contains(text(),'Dark Sky API') ]");
By tryBtn=By.xpath("//div//a[contains(text(),'TRY FOR FREE') ]");
By email=By.cssSelector("input[name='email']");
By password=By.name("password");
By comfir=By.name("confirmation");
By registerBtn=By.xpath("//div//button[contains(text(),'Register') ]");
By signIn=By.xpath("//nav//ul[1]//a[contains(.,'Sign in')]");
By emailId=By.name("loginfmt");
By next1=By.id("idSIButton9");
By pass=By.id("i0118");
By next2=By.id("idSIButton9");
By selectedEmail=By.xpath("//span[text()='Dark Sky Developer Support']");
By link=By.cssSelector("div.PlainText>a");
By loginBtn=By.xpath("//a[text()='Log In']");
By emailLogin=By.id("email");
By passwordLogin=By.id("password");
By loginBtnLogin=By.xpath("//button[text()='Log in']");
public Registration(WebDriver driver) {
	this.driver = driver;
	elementUtil=new ElementUtil(driver);
}

public void goForRegiste(String username, String pass) throws InterruptedException{
	elementUtil.doClick(apiBtn);
	Thread.sleep(2000);
	elementUtil.doClick(tryBtn);
	Thread.sleep(2000);
	elementUtil.doSendKeys(email,username);
	elementUtil.doSendKeys(password, pass);
	elementUtil.doSendKeys(comfir, pass);
	Thread.sleep(2000);
	elementUtil.doClick(registerBtn);
	
}
public void goEmailForConfirm(String username,String password) throws InterruptedException{
	driver.get("https://outlook.live.com/owa/");
	elementUtil.doClick(signIn);
	elementUtil.doSendKeys(emailId, "sonermercan7171@hotmail.com");
	Thread.sleep(3000);
	elementUtil.doClick(next1);
	Thread.sleep(3000);
	elementUtil.doSendKeys(pass, "Mercan@2020@");
	Thread.sleep(3000);
	elementUtil.doClick(next2);
	Thread.sleep(3000);
	elementUtil.doClick(selectedEmail);
	Thread.sleep(3000);
	elementUtil.doClick(link);
	

}
public String doLogin(String myEmail, String myPass) throws InterruptedException{
	elementUtil.doClick(apiBtn);
	Thread.sleep(3000);
	elementUtil.doClick(loginBtn);
	Thread.sleep(3000);
	elementUtil.doSendKeys(emailLogin, myEmail);
	elementUtil.doSendKeys(passwordLogin, myPass);
	Thread.sleep(3000);
	elementUtil.doClick(loginBtnLogin);
	Thread.sleep(3000);
	String loginTitle=elementUtil.waitForGetPageTitle(Constants.LOGIN_PAGE_TITLE);
	return loginTitle;
}

}

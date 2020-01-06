package com.darksky.pages;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.darksky.base.BasePage;
import com.darksky.utils.ElementUtil;
import com.darksky.utils.JavaScriptUtil;

public class TimeMachine extends BasePage{
	WebDriver driver;
	ElementUtil elementUtil;
	
	By input=By.cssSelector("a+input[type=text]");
	By autoComplate=By.cssSelector("div.autocomplete__results__container");
	By timeMachineBtn=By.xpath("//a[@class='button' and contains(.,'Time Machine')]");
	By date=By.cssSelector("button[data-pika-day='27']");
	By temp4am=By.xpath("//div[@class='temperature']//span[@class='val swap']//span[@class='num']");
	By temp4Am=By.xpath("//div[@class='timeline']//div[@class='temps']//span[contains(@style,'0.25;')]");
	By handle=By.className("handle");
	By hours=By.xpath("//div//span [contains(@class,'am') or contains(@class,'pm')]");
	By temp=By.cssSelector("span[style^=opacity]");
	
	public TimeMachine(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	public void autoComplate(){
		String autoText="Ashton Drive, Liberty, MO";
		List<WebElement> locatinList=driver.findElements(autoComplate);
		for (int i = 0; i < locatinList.size(); i++) {
			if (locatinList.get(i).getText().equals(autoText)) {
				locatinList.get(i).click();
				
			}
			break;
		}
	}
	public void getLocation() throws InterruptedException{
		String autoText="Ashton Drive, Liberty, MO";
		elementUtil.getElement(input).clear();
		elementUtil.doSendKeys(input, autoText);
		Thread.sleep(3000);
		
		List<WebElement> locatinList=driver.findElements(autoComplate);
		for (int i = 0; i < locatinList.size(); i++) {
			if (locatinList.get(i).getText().equals(autoText)) {
				locatinList.get(i).click();
				
			}
			break;
		}
		elementUtil.getElement(input).sendKeys(Keys.ENTER);
	}
	public void goTimeMachine() throws InterruptedException {
		JavaScriptUtil.scrollPageDown(driver);
		Thread.sleep(5000);
		elementUtil.doClick(timeMachineBtn);
		Thread.sleep(3000);
		elementUtil.doClick(date);
		
	}
	public int getTempInTimeMachine(){
		WebElement slider=driver.findElement(handle);
		Actions actions=new Actions(driver);
		actions.clickAndHold(slider).moveByOffset(-266,0).perform();
		String tempBySlider =elementUtil.doGetText(temp4am);
		
		int temp4AmInt=Integer.parseInt(tempBySlider.replaceAll("[^\\d.]", ""));
		System.out.println("**4 am tempreture is "+temp4AmInt);
		return temp4AmInt;
	
	}
	public int tempOf4Am(){
	
		List<String> hoursList=new ArrayList<String>();
		List<Integer> tempList=new ArrayList<Integer>();

		List<WebElement>listH=driver.findElements(hours);
		List<WebElement>listT=driver.findElements(temp);
		int temp4am=0;
		String time="4am";
		for (int i = 0; i < listH.size(); i++) {
			String hour=listH.get(i).getText();
			if (!hour.isEmpty()) {
				hoursList.add(listH.get(i).getText());
			}
		}
		for (int i = 0; i < listT.size()-1; i++) {
			
			tempList.add(Integer.parseInt(listT.get(i).getText().replaceAll("[^\\d.]", "")));
		}

		System.out.println(listH.size());
		for (int j = 0; j < hoursList.size(); j++) {
			
			if ((hoursList.get(j)).equals("4am")) {
				
				System.out.println("Time is "+(hoursList.get(j)+" and tepmpreture is "+(tempList.get(j))));
				temp4am=tempList.get(j);
				break;
			
			} 
			
				
			}
		return temp4am;

	}

	
	
	
}

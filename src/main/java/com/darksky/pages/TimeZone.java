package com.darksky.pages;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.darksky.base.BasePage;
import com.darksky.utils.ElementUtil;

public class TimeZone extends BasePage {
WebDriver driver;
ElementUtil elementUtil;

By input=By.cssSelector("a+input[type=text]");
By twoHourLater=By.cssSelector("span.hour:nth-child(3)");



public TimeZone(WebDriver driver) {
	this.driver = driver;
	elementUtil=new ElementUtil(driver);
}
public void getLocation() {
	String autoText="Irvine";
	elementUtil.getElement(input).clear();
	elementUtil.doSendKeys(input, autoText);
	elementUtil.getElement(input).sendKeys(Keys.ENTER);
	
}
public int getCurrentTimeWithTimeZone(){
    ZoneId zoneId = ZoneId.of("America/Chicago");
    LocalTime localTime=LocalTime.now(zoneId);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    String formattedTime=localTime.format(formatter);
    System.out.println("Current time of the day in Los Angeles: " + formattedTime);
    DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("hh");
    String justHour=localTime.format(formatter1);
    int time=Integer.parseInt(justHour.replaceAll("[^\\d.]", ""));
	return time;
}
public int getTwoHourLatter(){
	String hour=elementUtil.doGetText(twoHourLater);
	int twoHourLatter=Integer.parseInt(hour.replaceAll("[^\\d.]", ""));
	return twoHourLatter-2;
	
}

}

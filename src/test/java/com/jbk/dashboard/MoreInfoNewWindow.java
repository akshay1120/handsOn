package com.jbk.dashboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MoreInfoNewWindow 
{
	@Test
	public void verifyMoreInfoNewWindow () throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Akshay%20S%20Jain/Desktop/Selenium/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();

		List<WebElement> moreInfo  =driver.findElements(By.xpath("//a[text()='More info ']"));
		
		ArrayList <String> actNewWindowUrls  = new ArrayList <String>();
		
		ArrayList <String> expNewWindowUrls = new ArrayList <String>();
		expNewWindowUrls.add("file:///C:/Users/Akshay%20S%20Jain/Desktop/Selenium/Selenium%20Softwares/"
				+ "Offline%20Website/Offline%20Website/pages/examples/dashboard.html#");
		expNewWindowUrls.add("file:///C:/Users/Akshay%20S%20Jain/Desktop/Selenium/Selenium%20Softwares/"
				+ "Offline%20Website/Offline%20Website/pages/pdf/python-syllabus.pdf");		
		expNewWindowUrls.add("file:///C:/Users/Akshay%20S%20Jain/Desktop/Selenium/Selenium%20Softwares/"
				+ "Offline%20Website/Offline%20Website/pages/pdf/java-j2ee-syllabus-jbk.pdf");
		expNewWindowUrls.add("file:///C:/Users/Akshay%20S%20Jain/Desktop/Selenium/Selenium%20Softwares/"
				+ "Offline%20Website/Offline%20Website/pages/pdf/selenium-testing-syllabus-jbk.pdf");
		
		String parent = driver.getWindowHandle();
		
		for (WebElement element : moreInfo)
		{
			element.click();
		}
		
		Set <String> allWindows = driver.getWindowHandles();
		
		for(String child : allWindows)
		{
			if(!parent.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				actNewWindowUrls.add(driver.getCurrentUrl());
				driver.close();
			}
		}
		Assert.assertEquals(actNewWindowUrls, expNewWindowUrls);
	}
}
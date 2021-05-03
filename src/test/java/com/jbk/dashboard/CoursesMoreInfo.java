package com.jbk.dashboard;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CoursesMoreInfo 
{
	@Test
	public void verifyCoursesMoreInfo() 
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Akshay%20S%20Jain/Desktop/Selenium/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		
		List<WebElement> MoreInfoTags  =driver.findElements(By.xpath("//a[text()='More info ']"));
		
		ArrayList <String>actMoreInfoTags  = new ArrayList <String>();
		
		ArrayList <String>expMoreInfoTags = new ArrayList <String>();
		expMoreInfoTags.add("More info");
		expMoreInfoTags.add("More info");		
		expMoreInfoTags.add("More info");
		expMoreInfoTags.add("More info");
		
		for (WebElement element : MoreInfoTags)
		{
			actMoreInfoTags.add(element.getText());
		}
		Assert.assertEquals(actMoreInfoTags, expMoreInfoTags);
		driver.close();
	}
}

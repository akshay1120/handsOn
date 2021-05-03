package com.jbk.dashboard;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationMenuText 
{
	@Test
	public void verifyNavigationMenuText() 
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Akshay%20S%20Jain/Desktop/Selenium/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		
		ArrayList <String> actNavigationMenuText = new ArrayList <String>();
		for(int i=2 ; i<8 ; i++)
		{
			String Element = driver.findElement(By.xpath("//li[" + i + "]")).getText();
			actNavigationMenuText.add(Element);
		}
		
		ArrayList <String> expNavigationMenuText = new ArrayList <String>();
		expNavigationMenuText.add("Dashboard");
		expNavigationMenuText.add("Users");
		expNavigationMenuText.add("Operators");
		expNavigationMenuText.add("Useful Links");
		expNavigationMenuText.add("Downloads");
		expNavigationMenuText.add("Logout");
		
		Assert.assertEquals(actNavigationMenuText, expNavigationMenuText);
		driver.close();
	}
}

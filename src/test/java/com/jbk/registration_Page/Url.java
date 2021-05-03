package com.jbk.registration_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Url 
{
	@Test
	public void verifyUrl() 
	{ 	
	 	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/Akshay%20S%20Jain/Desktop/Selenium/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.partialLinkText("Register")).click();
		
		String expectedUrl = "file:///C:/Users/Akshay%20S%20Jain/Desktop/Selenium/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/register.html" ; 
		String actualUrl = driver.getCurrentUrl() ;
		
		Assert.assertEquals(actualUrl, expectedUrl);;
		driver.close();
	}
}

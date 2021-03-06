package com.jbk.login_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Title 
{
	@Test
	public void verifyTitle() 
	{ 	
	 	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/Akshay%20S%20Jain/Desktop/Selenium/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		
		String expectedTitle = "JavaByKiran | Log in" ; 
		String actualTitle = driver.getTitle() ;
		
		Assert.assertEquals(actualTitle, expectedTitle);
		driver.close();
	}
}

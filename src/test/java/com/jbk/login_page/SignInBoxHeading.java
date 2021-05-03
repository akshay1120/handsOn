package com.jbk.login_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInBoxHeading 
{
	@Test
	public void verifySignInBoxHeading() 
	{ 	
	 	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/Akshay%20S%20Jain/Desktop/Selenium/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		
		WebElement signInBoxHeading = driver.findElement(By.xpath("//p"));
	
		String actualSignInBoxHeading = signInBoxHeading.getText();
		String expectedSignInBoxHeading = "Sign in to start your session" ;
	
		Assert.assertEquals(actualSignInBoxHeading, expectedSignInBoxHeading);;
		driver.close();
	}
}

package com.jbk.registration_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlreadyMemberText 
{
	@Test
	public void verifyAlreadyMemberText() 
	{ 	
	 	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/Akshay%20S%20Jain/Desktop/Selenium/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.partialLinkText("Register")).click();
		
		WebElement alreadyMemberLink = driver.findElement(By.partialLinkText("membership"));
	
		String actualAlreadyMemberLinkText = alreadyMemberLink.getText();
		String expectedAlreadyMemberLinkText = "I already have a membership" ;
		
		Assert.assertEquals(actualAlreadyMemberLinkText, expectedAlreadyMemberLinkText);
		driver.close();
	}
}

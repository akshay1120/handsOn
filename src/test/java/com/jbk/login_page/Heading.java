package com.jbk.login_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Heading 
{
	@Test
	public void verifyHeading() 
	{ 	
	 	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Offline%20Website/index.html");
		
		WebElement heading = driver.findElement(By.xpath("//b"));
	
		String actualHeading = heading.getText();
		String expectedHeading = "Java By Kiran" ;
		
		Assert.assertEquals(actualHeading, expectedHeading);
		driver.close();
	}	
}

package com.jbk.dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CopyrightStatement 
{
	@Test
	public void verifyCopyrightStatement () 
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Akshay%20S%20Jain/Desktop/Selenium/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		
		String footer = driver.findElement(By.xpath("//footer")).getText();
		
		String actfooter = footer.substring(44,99);
		String expfooter = "Copyright ? 2005-2019 JavaByKiran. All rights reserved.";
	
		Assert.assertEquals(actfooter, expfooter);
		driver.close();
	}
}
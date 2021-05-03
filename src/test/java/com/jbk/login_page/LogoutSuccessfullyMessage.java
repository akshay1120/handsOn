package com.jbk.login_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutSuccessfullyMessage 
{
	@Test
	public void verifyLogoutSuccessfullyMessage() 
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Akshay%20S%20Jain/Desktop/Selenium/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		
		driver.findElement(By.linkText("LOGOUT")).click();
		
		String actMessage = driver.findElement(By.xpath("//p[2]")).getText();
		String expMessage = "Logout successfully" ;
		
		Assert.assertEquals(actMessage, expMessage);
		driver.close();
	}
}

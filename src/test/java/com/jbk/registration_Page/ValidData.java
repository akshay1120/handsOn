package com.jbk.registration_Page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidData 
{
	@Test
	public void verifyValidSignIn() 
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Akshay%20S%20Jain/Desktop/Selenium/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.partialLinkText("Register")).click();
		
		driver.findElement(By.id("name")).sendKeys("Akshay");
		driver.findElement(By.id("mobile")).sendKeys("9876543210");
		driver.findElement(By.id("email")).sendKeys("akshay@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		
		Alert al = driver.switchTo().alert();
		
		Assert.assertEquals(al.getText() , "User registered successfully.");
		
		al.accept();
	}
}
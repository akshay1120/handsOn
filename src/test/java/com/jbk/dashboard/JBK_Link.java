package com.jbk.dashboard;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JBK_Link 
{
	@Test
	public void verifyJBK_Link () throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Akshay%20S%20Jain/Desktop/Selenium/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		
		String parent = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//a[text()='JavaByKiran']")).click();
		
		Set <String> allWindows = driver.getWindowHandles();
		
		String actWindowTitle = null ;
		String expWindowTitle = "Java Classes in Pune | Selenium Training | Python Courses in pune";
		
		for(String child : allWindows)
		{
			if(!parent.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				actWindowTitle = driver.getTitle();
				System.out.println(actWindowTitle);
			}
		}
		Assert.assertEquals(actWindowTitle, expWindowTitle);
		driver.close();
	}
}

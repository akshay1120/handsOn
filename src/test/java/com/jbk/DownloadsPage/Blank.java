package com.jbk.DownloadsPage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Blank 
{
	@Test
	public void verifyDownloadsCommonBlank() 
	{ 	
	 	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Akshay%20S%20Jain/Desktop/Selenium/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
	
		driver.findElement(By.xpath("//span[text()='Downloads']")).click();
  
	  	List<WebElement> OS =driver.findElements(By.xpath("//tr/td[7]"));
		List<WebElement> vendor =driver.findElements(By.xpath("//tr/td[3]"));
		
		ArrayList <String>actData = new ArrayList <String>();
		
		ArrayList <String>expData = new ArrayList <String>();
		expData.add("Java Development Kit (JDK)");
		expData.add("Google Chrome");
		expData.add("Mozilla Firefox");
		expData.add("Gecko Driver for Latest firefox");
		
		int i=0 ;
		
		for (WebElement element : OS )
		{	
			String com = element.getText();
			
			if (com.equals(""))
			{
				String vname = vendor.get(i).getText();
				System.out.println(vname);
				actData.add(vname);
			}
			i++ ;
		}
		Assert.assertEquals(actData, expData);
	}
}

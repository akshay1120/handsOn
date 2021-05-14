package com.jbk.operatorsPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NamesInAlphabeticalOrder 
{
	WebDriver driver ;
	 
	@Test
	public void Test1()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/Akshay%20S%20Jain/Desktop/Selenium/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("//span[text()='Operators']")).click();
		
		List<WebElement> person =driver.findElements(By.xpath("//tr/td[2]"));
		
		ArrayList <String>actData = new ArrayList <String>();
		
		ArrayList <String>expData = new ArrayList <String>();
		expData.add("Darshit");
		expData.add("Kiran");
		expData.add("Neelam");
		expData.add("Seema");
		expData.add("Varsha");
		
		for (WebElement element : person)
		{
			String name = element.getText();
			
			actData.add(name);
		}
		
		Collections.sort(actData);
		System.out.println(actData);
		
		for (String i : actData)
		{
			System.out.println(i);
		}
		
		Assert.assertEquals(actData, expData);
		driver.close();
	}
}

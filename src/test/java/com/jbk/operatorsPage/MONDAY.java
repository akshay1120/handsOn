package com.jbk.operatorsPage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MONDAY 
{
	@Test 
	public void Verify_State_Name_table ()
	{	
		int i=0 ;
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Akshay%20S%20Jain/Desktop/Selenium/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
	
		driver.findElement(By.xpath("//span[text()='Operators']")).click();
		
		List<WebElement> timing =driver.findElements(By.xpath("//tr/td[6]"));
		List<WebElement> person =driver.findElements(By.xpath("//tr/td[2]"));
		
		ArrayList <String>actData = new ArrayList <String>();
		
		ArrayList <String>expData = new ArrayList <String>();
		expData.add("Kiran");
		expData.add("Neelam");
		expData.add("Seema");
		expData.add("Varsha");
		
		System.out.println("Faculties available on Monday : ");
		
		for (WebElement element : timing)
		{
			String days = element.getText();
			
			if (days.contains("Monday"))
			{
				String faculty = person.get(i).getText();
				System.out.println(faculty);
				actData.add(faculty);
			}
			i++ ;
		}
		Assert.assertEquals(actData, expData);
	}
}

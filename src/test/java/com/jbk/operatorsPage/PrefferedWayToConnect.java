package com.jbk.operatorsPage;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

public class PrefferedWayToConnect
{
	WebDriver driver;
	
	@BeforeSuite
	  public void beforeSuite()
	  {
		  	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("file:///C:/Users/Akshay%20S%20Jain/Desktop/Selenium/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
			driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
			driver.findElement(By.id("password")).sendKeys("123456");
			driver.findElement(By.xpath("//button")).click();
			driver.findElement(By.xpath("//span[text()='Operators']")).click();
	  }
	
	
	// Preffered Way To Contact = Whats App 
	@Test
	public void Test1() 
	{
	  	List<WebElement> ways =driver.findElements(By.xpath("//tr/td[4]"));
		List<WebElement> person =driver.findElements(By.xpath("//tr/td[2]"));
		
	  	ArrayList <String>actData = new ArrayList <String>();
		
		ArrayList <String>expData = new ArrayList <String>();
		expData.add("Kiran");
		expData.add("Neelam");
		expData.add("Seema");
		expData.add("Varsha");
		expData.add("Darshit");
		
		System.out.println("Faculties available on WhatsApp : ");
	
		int i=0 ;
		
		for (WebElement element : ways)
		{
			String contact = element.getText();
			
			if (contact.contains("Whats App"))
			{
				String faculty = person.get(i).getText();
				System.out.println(faculty);
				actData.add(faculty);
			}
			i++ ;
		}
		Assert.assertEquals(actData, expData);
	}
  
 
	
		// Preffered Way To Contact = Phone Call 
		@Test
		public void Test2()
		{
			List<WebElement> ways =driver.findElements(By.xpath("//tr/td[4]"));
			List<WebElement> person =driver.findElements(By.xpath("//tr/td[2]"));
			
			ArrayList <String>actData = new ArrayList <String>();
			
			ArrayList <String>expData = new ArrayList <String>();
			expData.add("Neelam");
			expData.add("Seema");
			expData.add("Varsha");
			
			System.out.println("Faculties available on Phone Call : ");
		
			int i=0 ;
			
			for (WebElement element : ways)
			{
				String contact = element.getText();
				
				if (contact.contains("Phone Call"))
				{
					String faculty = person.get(i).getText();
					System.out.println(faculty);
					actData.add(faculty);
				}
				i++ ;
			}
			Assert.assertEquals(actData, expData);
		}
		
		
		// Preffered Way To Contact = Whats App & Phone Call 
		@Test
		public void Test3()
		{
			List<WebElement> ways =driver.findElements(By.xpath("//tr/td[4]"));
			List<WebElement> person =driver.findElements(By.xpath("//tr/td[2]"));
			
			ArrayList <String>actData = new ArrayList <String>();
			
			ArrayList <String>expData = new ArrayList <String>();
			expData.add("Neelam");
			expData.add("Seema");
			expData.add("Varsha");
			
			System.out.println("Faculties available on both WhatsApp & Phone Call : ");
		
			int i=0 ;
			
			for (WebElement element : ways)
			{
				String contact = element.getText();
				
				if (contact.contains("Whats App") && contact.contains("Phone Call"))
				{
						String faculty = person.get(i).getText();
						System.out.println(faculty);
						actData.add(faculty);
				}
				i++ ;
			}
			Assert.assertEquals(actData, expData);
		}
		
		
		
		// Preffered Way To Contact = Whats App but not Phone Call 
		@Test
		public void Test4()
		{
			List<WebElement> ways =driver.findElements(By.xpath("//tr/td[4]"));
			List<WebElement> person =driver.findElements(By.xpath("//tr/td[2]"));
			
			ArrayList <String>actData = new ArrayList <String>();
			
			ArrayList <String>expData = new ArrayList <String>();
			expData.add("Kiran");
			expData.add("Darshit");
			
			System.out.println("Faculties available on WhatsApp but not on Phone Call : ");
		
			int i=0 ;
			
			for (WebElement element : ways)
			{
				String contact = element.getText();
				
				if (contact.contains("Whats App"))
				{
					if (!contact.contains("Phone Call"))
					{
						String faculty = person.get(i).getText();
						System.out.println(faculty);
						actData.add(faculty);
					}
				}
				i++ ;
			}
			Assert.assertEquals(actData, expData);
			driver.close();
		}
}

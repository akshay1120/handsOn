package com.jbk.DownloadsPage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OS_1 
{
	@Test 
	public void Verify_operatingSystem_LOW_table ()
	{	
		int i=0 ;
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Akshay%20S%20Jain/Desktop/Selenium/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
	
		driver.findElement(By.xpath("//span[text()='Downloads']")).click();
		
		List<WebElement> OS =driver.findElements(By.xpath("//tr/td[5]"));
		List<WebElement> vendor =driver.findElements(By.xpath("//tr/td[3]"));
		
		ArrayList <String>actData = new ArrayList <String>();
		
		ArrayList <String>expData = new ArrayList <String>();
		expData.add("Java Development Kit (JDK)");
		expData.add("Google Chrome");
		expData.add("Mozilla Firefox");
		expData.add("Gecko Driver for Latest firefox");
		
		System.out.println("Vendors having Operating System of 32 bit : ");
		
		for (WebElement element : OS )
		{
			String low = element.getText();
			
			if (low.equals("32bit"))
			{
				String vname = vendor.get(i).getText();
				System.out.println(vname);
				actData.add(vname);
			}
			i++ ;
		}
		Assert.assertEquals(actData,expData);
		driver.close();
	}
	
	@Test
	  public void Verify_operatingSystem_HIGH_table() 
	  {
		  	int i=0 ;
		  	
		 	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("file:///C:/Users/Akshay%20S%20Jain/Desktop/Selenium/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
			driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
			driver.findElement(By.id("password")).sendKeys("123456");
			driver.findElement(By.xpath("//button")).click();
		
			driver.findElement(By.xpath("//span[text()='Downloads']")).click();
	  
		  	List<WebElement> OS =driver.findElements(By.xpath("//tr/td[6]"));
			List<WebElement> vendor =driver.findElements(By.xpath("//tr/td[3]"));
			
			ArrayList <String>actData = new ArrayList <String>();
			
			ArrayList <String>expData = new ArrayList <String>();
			expData.add("Java Development Kit (JDK)");
			expData.add("Google Chrome");
			expData.add("Mozilla Firefox");
			expData.add("Gecko Driver for Latest firefox");
			
			System.out.println("Vendors having Operating System of 64 bit : ");
			
			for (WebElement element : OS )
			{
				String high = element.getText();
				
				if (high.equals("64bit"))
				{
					String vname = vendor.get(i).getText();
					System.out.println(vname);
					actData.add(vname);
				}
				i++ ;
			}
			Assert.assertEquals(actData,expData);  
			driver.close();
	  }
	
	@Test
	  public void Verify_Common() 
	  {
		  	int i=0 ;
		  	
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
			expData.add("Selenium Server Source Jar");
			expData.add("Google Chrome Driver");
			
			System.out.println("Vendors having Operating System common : ");
			
			for (WebElement element : OS )
			{
				String com = element.getText();
				
				if (com.equals("Common"))
				{
					String vname = vendor.get(i).getText();
					System.out.println(vname);
					actData.add(vname);
				}
				i++ ;
			}
			Assert.assertEquals(actData,expData);  
			driver.close();
	  }
	
	
	@Test
	  public void Verify_NONE() 
	  {  	
		 	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("file:///C:/Users/Akshay%20S%20Jain/Desktop/Selenium/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
			driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
			driver.findElement(By.id("password")).sendKeys("123456");
			driver.findElement(By.xpath("//button")).click();
		
			driver.findElement(By.xpath("//span[text()='Downloads']")).click();
	  
			List<WebElement> OS_1 =driver.findElements(By.xpath("//tr/td[5]"));
		  	List<WebElement> OS_2 =driver.findElements(By.xpath("//tr/td[7]"));
			List<WebElement> vendor =driver.findElements(By.xpath("//tr/td[3]"));
			
			ArrayList <String>actData = new ArrayList <String>();
			
			ArrayList <String>expData = new ArrayList <String>();
			expData.add("Selenium Server Standalon Jar");
			
			System.out.println("Vendors having none Operating System  : ");
			
			for (int i=0 ; i<OS_1.size() ; i++ )
			{
				if (!OS_1.get(i).getText().equals("32bit") && !OS_2.get(i).getText().equals("Common"))
				{
					String vname = vendor.get(i).getText();
					System.out.println(vname);
					actData.add(vname);
				}
			}
			Assert.assertEquals(actData,expData);  
			driver.close();
	  }
}

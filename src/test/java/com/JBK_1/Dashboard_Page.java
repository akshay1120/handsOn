package com.JBK_1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Dashboard_Page 
{
	WebDriver driver ;
	
	@BeforeSuite
	public void DashboardPage()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
	}
	
	@Test(priority=1)
	public void verifyUrl() 
	{
		String actUrl = driver.getCurrentUrl();
		String expUrl = "file:///C:/Offline%20Website/pages/examples/dashboard.html";
	
		Assert.assertEquals(actUrl, expUrl);
	}
	
	@Test(priority=2)
	public void verifyTitle() 
	{
		String expectedTitle = "JavaByKiran | Dashboard" ; 
		String actualTitle = driver.getTitle() ;
		
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(priority=3)
	public void verifyCornerHeading () 
	{
		String actCornerHeading = driver.findElement(By.xpath("//span[2]")).getText();
		String expCornerHeading = "Java By Kiran" ;
		
		Assert.assertEquals(actCornerHeading, expCornerHeading);
	}
	
	@Test(priority=4)
	public void verifyMainHeading() 
	{
		String actMainHeading = driver.findElement(By.xpath("//h1")).getText();
		String expMainHeading = "Dashboard Courses Offered" ;
		
		Assert.assertEquals(actMainHeading, expMainHeading);
	}
	
	@Test(priority=5)
	public void verifyUserImage() 
	{
		WebElement UserImage = driver.findElement(By.xpath("//img"));
		
		if(UserImage.isDisplayed()==true)
		{
			System.out.println("UserImage is displayed");
		}
		else
		{
			System.out.println("UserImage is not displayed");
		}
	}
	
	@Test(priority=6)
	public void verifyUserName () 
	{
		String actUserName = driver.findElement(By.xpath("//p[text()='Kiran']")).getText();
		String expUserName = "Kiran" ;
		
		Assert.assertEquals(actUserName, expUserName);
	}
	
	@Test(priority=7)
	public void verifyUserStatus () 
	{
		String actUserStatus  = driver.findElement(By.xpath("//a[text()=' Online']")).getText();
		String expUserStatus  = "Online" ;
		
		Assert.assertEquals(actUserStatus, expUserStatus);
	}
	
	@Test(priority=8)
	public void verifyNavigationMenuText() 
	{
		ArrayList <String> actNavigationMenuText = new ArrayList <String>();
		
		for(int i=2 ; i<8 ; i++)
		{
			String Element = driver.findElement(By.xpath("//li[" + i + "]")).getText();
			actNavigationMenuText.add(Element);
		}
		
		ArrayList <String> expNavigationMenuText = new ArrayList <String>();
		expNavigationMenuText.add("Dashboard");
		expNavigationMenuText.add("Users"); 
		expNavigationMenuText.add("Operators");
		expNavigationMenuText.add("Useful Links");
		expNavigationMenuText.add("Downloads");
		expNavigationMenuText.add("Logout");
		
		Assert.assertEquals(actNavigationMenuText, expNavigationMenuText);
	}
	
	@Test(priority=9)
	public void verifyUsersMenu() 
	{
		driver.findElement(By.xpath("//span[text()='Users']")).click();
		
		String actTitle = driver.getTitle();
		String expTitle = "JavaByKiran | User" ;
				
		Assert.assertEquals(actTitle, expTitle);
		driver.findElement(By.xpath("//span[text()='Dashboard']")).click();
	}
	
	@Test(priority=10)
	public void verifyOperatorsMenu () 
	{
		driver.findElement(By.xpath("//span[text()='Operators']")).click();
		
		String actTitle = driver.getTitle();
		String expTitle = "JavaByKiran | Operators" ;
				
		Assert.assertEquals(actTitle, expTitle);
		driver.findElement(By.xpath("//span[text()='Dashboard']")).click();
	}
	
	@Test(priority=11)
	public void verifyUsefulLinksMenu() 
	{
		driver.findElement(By.xpath("//span[text()='     Useful Links']")).click();
		
		String actTitle = driver.getTitle();
		String expTitle = "JavaByKiran | Useful Links" ;
				
		Assert.assertEquals(actTitle, expTitle);
		driver.findElement(By.xpath("//span[text()='Dashboard']")).click();
	}
	
	@Test(priority=12)
	public void verifyDownloadsMenu () 
	{
		driver.findElement(By.xpath("//span[text()='Downloads']")).click();
		
		String actTitle = driver.getTitle();
		String expTitle = "JavaByKiran | Downloads" ;
				
		Assert.assertEquals(actTitle, expTitle);
		driver.findElement(By.xpath("//span[text()='Dashboard']")).click();
	}
	
	@Test(priority=13)
	public void verifyLeftCornerLogOutMenu() 
	{
		driver.findElement(By.xpath("//span[text()='Logout']")).click();
		
		String actTitle = driver.getTitle();
		String expTitle = "JavaByKiran | Log in" ;
				
		Assert.assertEquals(actTitle, expTitle);
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
	}
	
	@Test(priority=14)
	public void verifyRightCornerLogOutLink() 
	{
		driver.findElement(By.xpath("//li[@class='dropdown user user-menu']")).click();
		
		String actTitle = driver.getTitle();
		String expTitle = "JavaByKiran | Log in" ;
				
		Assert.assertEquals(actTitle, expTitle);
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
	}
	
	@Test(priority=15)
	public void verifyCoursesHeading () 
	{
		List<WebElement> CoursesHeadings  =driver.findElements(By.xpath("//h3"));
		
		ArrayList <String>actCoursesHeadings  = new ArrayList <String>();
		
		ArrayList <String>expCoursesHeadings = new ArrayList <String>();
		expCoursesHeadings.add("Selenium");
		expCoursesHeadings.add("Java / J2EE");		
		expCoursesHeadings.add("Python");
		expCoursesHeadings.add("Php");
		
		for (WebElement element : CoursesHeadings)
		{
			actCoursesHeadings.add(element.getText());
		}
		Assert.assertEquals(actCoursesHeadings, expCoursesHeadings);
	}
	
	@Test(priority=16)
	public void verifyCoursesSubHeading () 
	{
		List<WebElement> CoursesSubHeading  =driver.findElements(By.xpath("//h3//following::p"));
		
		ArrayList <String>actCoursesSubHeadings  = new ArrayList <String>();
		
		ArrayList <String>expCoursesSubHeadings = new ArrayList <String>();
		expCoursesSubHeadings.add("Automation Testing");
		expCoursesSubHeadings.add("Software Development");		
		expCoursesSubHeadings.add("Data Science");
		expCoursesSubHeadings.add("Web Development");
		
		for (WebElement element : CoursesSubHeading)
		{
				actCoursesSubHeadings.add(element.getText());
		}
		Assert.assertEquals(actCoursesSubHeadings, expCoursesSubHeadings);	
	 }
	
	@Test(priority=17)
	public void verifyCoursesMoreInfo() 
	{
		List<WebElement> MoreInfoTags  =driver.findElements(By.xpath("//a[text()='More info ']"));
		
		ArrayList <String>actMoreInfoTags  = new ArrayList <String>();
		
		ArrayList <String>expMoreInfoTags = new ArrayList <String>();
		expMoreInfoTags.add("More info");
		expMoreInfoTags.add("More info");		
		expMoreInfoTags.add("More info");
		expMoreInfoTags.add("More info");
		
		for (WebElement element : MoreInfoTags)
		{
			actMoreInfoTags.add(element.getText());
		}
		Assert.assertEquals(actMoreInfoTags, expMoreInfoTags);
	}
	
	@Test(priority=18)
	public void verifyMoreInfoNewWindow () throws Exception 
	{
		List<WebElement> moreInfo  =driver.findElements(By.xpath("//a[text()='More info ']"));
		
		Set <String> actNewWindowUrls  = new HashSet <String>();
		
		Set <String> expNewWindowUrls = new HashSet <String>();
		expNewWindowUrls.add("file:///C:/Offline%20Website/pages/examples/dashboard.html#");
		expNewWindowUrls.add("file:///C:/Offline%20Website/pages/pdf/python-syllabus.pdf");		
		expNewWindowUrls.add("file:///C:/Offline%20Website/pages/pdf/java-j2ee-syllabus-jbk.pdf");
		expNewWindowUrls.add("file:///C:/Offline%20Website/pages/pdf/selenium-testing-syllabus-jbk.pdf");
		
		String parent = driver.getWindowHandle();
		
		for (WebElement element : moreInfo)
		{
			element.click();
		}
		
		Set <String> allWindows = driver.getWindowHandles();
		
		for(String child : allWindows)
		{
			if(!parent.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				actNewWindowUrls.add(driver.getCurrentUrl());
				driver.close();
			}
		}
		Assert.assertEquals(actNewWindowUrls, expNewWindowUrls);
		driver.switchTo().window(parent);
	}
	
	@Test(priority=19)
	public void verifyFooterStatement () 
	{
		String actfooter = driver.findElement(By.xpath("//footer")).getText();
		String expfooter = "Design for Selenium Automation Test V 2.3.0\n" +"Copyright © 2005-2019 JavaByKiran. All rights reserved.";
	
		Assert.assertEquals(actfooter, expfooter);
	}
	
	@Test(priority=20)
	public void verifyJBK_Link () throws InterruptedException 
	{
		String parent = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//a[text()='JavaByKiran']")).click();
		Thread.sleep(10000);
		
		Set <String> allWindows = driver.getWindowHandles();
		
		String actWindowTitle = null ;
		String expWindowTitle = "Java Classes in Pune | Selenium Training | Python Courses in pune";
		
		for(String child : allWindows)
		{
			if(!parent.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				actWindowTitle = driver.getTitle();
				driver.close();
			}
		}
		Assert.assertEquals(actWindowTitle, expWindowTitle);
		driver.switchTo().window(parent);
	}
	
	@Test(priority=21)
	public void verifySequence () 
	{
		String actSequence = driver.findElement(By.xpath("//ol")).getText();
		String expSequence = "Home Dashboard";
		
		Assert.assertEquals(actSequence, expSequence);
	}
	
	@AfterSuite
	public void closeWindow()
	{
		driver.quit();
	}
}
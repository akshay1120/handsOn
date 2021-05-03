package com.jbk.dashboard;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CoursesSubHeading 
{
	@Test
	public void verifyCoursesSubHeading () 
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Akshay%20S%20Jain/Desktop/Selenium/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		
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
		driver.close();
	}
}

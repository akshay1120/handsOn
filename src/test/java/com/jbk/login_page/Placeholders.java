package com.jbk.login_page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Placeholders 
{
	@Test
	public void verifyPlaceholders() 
	{ 	
	 	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/Akshay%20S%20Jain/Desktop/Selenium/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	
		List<WebElement> Placeholders =driver.findElements(By.xpath("//input"));
	
		ArrayList <String>actPlaceholderText = new ArrayList <String>();
		
		ArrayList <String>expPlaceholderText = new ArrayList <String>();
		expPlaceholderText.add("Email");
		expPlaceholderText.add("Password");
		
		for (WebElement element : Placeholders)
		{
			actPlaceholderText.add(element.getAttribute("placeholder"));
		}
		Assert.assertEquals(actPlaceholderText, expPlaceholderText);
		driver.close();
	}
}
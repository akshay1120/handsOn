package com.jbk.UsersPage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Gender 
{
	@Test 
	public void Verify_State_Name_table ()
	{	
		int i=0 ;
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		
		driver.findElement(By.xpath("//span[text()='Users']")).click();
	
		List<WebElement> gender =driver.findElements(By.xpath("//tr/td[6]"));
		List<WebElement> unames =driver.findElements(By.xpath("//tr/td[2]"));
		
		ArrayList<String>actData = new ArrayList<String>();
		ArrayList<String>expData = new ArrayList<String>();
		expData.add("Kiran");
		expData.add("Sagar");
		
		for(WebElement element : gender)
		{
			String name = unames.get(i).getText();
		
			if (element.getText().equals("Male"))
			{
				System.out.println(name); 
				actData.add(name);
			}
			i++ ;
		}
		Assert.assertEquals(actData, expData);		
	}
}

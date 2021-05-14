package com.jbk.UsersPage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class B 
{
	@Test 
	public void Verify_State_Name_table () 
	{	
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("//span[text()='Users']")).click();
		
		List<WebElement> delete =driver.findElements(By.xpath("//span[text()='Delete']"));
		
		ArrayList<String>actData = new ArrayList<String>();
		ArrayList<String>expData = new ArrayList<String>();
		expData.add("Click to Delete");
		expData.add("Click to Delete");
		expData.add("Click to Delete");
		expData.add("Click to Delete");
		
		for(WebElement element : delete)
		{
			String msg = element.getAttribute("title");
			System.out.println(msg); 
			actData.add(msg);
		}
		Assert.assertEquals(actData, expData);	
	}
}
//span[text()='Delete']
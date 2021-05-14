package com.jbk.AddUserPage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Add_User 
{
	@Test
	
	public void addUser() 
	{
	 	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	 	WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Akshay%20S%20Jain/Desktop/Selenium/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
	
		driver.findElement(By.xpath("//span[text()='Users']")).click();
		driver.findElement(By.xpath("//button[text()='Add User']")).click();
	
		driver.findElement(By.id("username")).sendKeys("ASJ");
		driver.findElement(By.id("mobile")).sendKeys("940000000000000");
		driver.findElement(By.id("email")).sendKeys("aj@gmail.com");
		driver.findElement(By.id("course")).sendKeys("Java");
		driver.findElement(By.id("Male")).click();
		driver.findElement(By.xpath("//select")).sendKeys("M");
		driver.findElement(By.id("password")).sendKeys("asdfg");
		driver.findElement(By.xpath("//button")).click();
		
		Alert al = driver.switchTo().alert();
		Assert.assertEquals(al.getText() , "User Added Successfully. You can not see added user.");
		al.accept();
	}
}

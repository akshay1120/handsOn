package com.jbk.UsersPage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class A 
{
	@Test 
	public void Verify_State_Name_table () throws InterruptedException
	{	
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		
		driver.findElement(By.xpath("//span[text()='Users']")).click();
	
		driver.findElement(By.xpath("//tr[3]//td[8]")).click();
				
		Alert al = driver.switchTo().alert();
        String Message = al.getText();
        System.out.println(Message);
        Thread.sleep(2000);
        al.dismiss();
	}
}

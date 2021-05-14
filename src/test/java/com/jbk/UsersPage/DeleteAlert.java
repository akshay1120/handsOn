package com.jbk.UsersPage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteAlert 
{
	@Test 
	public void verifyDeleteAlert ()
	{	
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		
		driver.findElement(By.xpath("//span[text()='Users']")).click();
	
		List<WebElement> actionCol =driver.findElements(By.xpath("//td[8]"));
		
		String msg1 = "You can not delete Default User" ;
		String msg2 = "Are you sure you want to delete this user" ;
		
		ArrayList <String>actData = new ArrayList <String>();
		
		ArrayList <String>expData = new ArrayList <String>();
		expData.add(msg1);
		expData.add(msg2);
		expData.add(msg1);
		expData.add(msg2);
		
		actionCol.get(0).click();
		Alert al = driver.switchTo().alert();
        String Message = al.getText();
        actData.add(Message);   
        System.out.println(Message);
        al.accept();
        
        for (int i=1 ; i<4 ; i++)
        {
        	 actionCol.get(i).click();
     		 al = driver.switchTo().alert();
             Message = al.getText();
             actData.add(Message);   
             System.out.println(Message);
             
             if(Message==msg1)
             {
             	al.accept();
             }
             
             else if(Message==msg2)
             {
             	al.dismiss();
             } 
        }
       
       
	Assert.assertEquals(actData, expData);		
}
}

package com.jbk.AddUserPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class PrintingDragDownOptions
{
	@Test
	  public void usersTable_1() 
	  {
		  	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("file:///C:/Offline%20Website/index.html");
			driver.manage().window().maximize();
			driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
			driver.findElement(By.id("password")).sendKeys("123456");
			driver.findElement(By.xpath("//button")).click();
	  
			driver.findElement(By.xpath("//span[text()='Users']")).click();
			
			driver.findElement(By.xpath("//button")).click();
			
	  		WebElement State = driver.findElement(By.xpath("//select"));
			
			Select selectstate = new Select(State);
			
			List <WebElement> list = selectstate.getOptions();
			
			for(WebElement element : list)
			{
				System.out.println(element.getText());
			}
	  }
}

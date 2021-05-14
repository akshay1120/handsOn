package com.jbk.usefulLinksPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClickGO 
{
	@Test 
	public void verifyDeleteAlert () throws Exception
	{	
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		
		driver.findElement(By.xpath("//span[text()='     Useful Links']")).click();
		
		List<WebElement> clickCol =driver.findElements(By.xpath("//span[text()='Go !']"));
		
		ArrayList <String>actData = new ArrayList <String>();
		
		ArrayList <String>expData = new ArrayList <String>();
		expData.add("Page not found | javabyKiran");
		expData.add("Page not found | javabyKiran");
		expData.add("Page not found | javabyKiran");
		expData.add("Page not found | javabyKiran");
		expData.add("Live Videos | javabyKiran");
		expData.add("Page not found | javabyKiran");
	
		String parent = driver.getWindowHandle();
		
		for (WebElement element : clickCol)
		{
			element.click();
			Thread.sleep(5000);
		}
		
		Set <String> allWindows = driver.getWindowHandles();
		
		for(String child : allWindows)
		{
			if(!parent.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				actData.add(driver.getTitle());
				System.out.println(driver.getTitle());
				driver.close();
			}
		}
		Assert.assertEquals(actData, expData);
	}
	
}


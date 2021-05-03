package com.jbk.registration_Page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NoData 
{
	@Test
	public void verifyBlankSignIn() 
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/Akshay%20S%20Jain/Desktop/Selenium/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.partialLinkText("Register")).click();
		driver.findElement(By.xpath("//button")).click();
		
		List<WebElement> ErrorMessage =driver.findElements(By.xpath("//div[contains(@id,'error')]"));
		
		ArrayList <String>actErrorMessage = new ArrayList <String>();
		
		ArrayList <String>expErrorMessage = new ArrayList <String>();
		expErrorMessage.add("Please enter Name.");
		expErrorMessage.add("Please enter Mobile.");		
		expErrorMessage.add("Please enter Email.");
		expErrorMessage.add("Please enter Password.");
		
		for (WebElement element : ErrorMessage)
		{
			actErrorMessage.add(element.getText());
		}
		Assert.assertEquals(actErrorMessage, expErrorMessage);
		driver.close();
	}
}

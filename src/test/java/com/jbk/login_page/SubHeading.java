package com.jbk.login_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubHeading 
{
	@Test
	public void verifySubHeading() 
	{ 	
	 	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/Akshay%20S%20Jain/Desktop/Selenium/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		
		WebElement subHeading = driver.findElement(By.xpath("//h4"));
	
		String actualSubHeading = subHeading.getText();
		String expectedSubHeading = "JAVA | SELENIUM | PYTHON" ;
		
		Assert.assertEquals(actualSubHeading, expectedSubHeading);
		driver.close();
	}
}

package com.JBK_1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Registration_Page 
{
	WebDriver driver ;
	
	@BeforeSuite
	public void LoginPage ()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/Akshay%20S%20Jain/Desktop/Selenium/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.partialLinkText("Register")).click();
	}
	
	@Test(priority=1)
	public void verifyUrl() 
	{ 	
		String expectedUrl = "file:///C:/Users/Akshay%20S%20Jain/Desktop/Selenium/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/register.html" ; 
		String actualUrl = driver.getCurrentUrl() ;
		
		Assert.assertEquals(actualUrl, expectedUrl);;
	}
	
	@Test(priority=2)
	public void verifyTitle() 
	{ 	
		String expectedTitle = "JavaByKiran | Registration Page" ; 
		String actualTitle = driver.getTitle() ;
		
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(priority=3)
	public void verifyHeading() 
	{ 	
		WebElement heading = driver.findElement(By.xpath("//b"));
	
		String actualHeading = heading.getText();
		String expectedHeading = "Java By Kiran" ;
		
		Assert.assertEquals(actualHeading, expectedHeading);
	}
	
	@Test(priority=4)
	public void verifyAlreadyMemberText() 
	{ 	
		WebElement alreadyMemberLink = driver.findElement(By.partialLinkText("membership"));
	
		String actualAlreadyMemberLinkText = alreadyMemberLink.getText();
		String expectedAlreadyMemberLinkText = "I already have a membership" ;
		
		Assert.assertEquals(actualAlreadyMemberLinkText, expectedAlreadyMemberLinkText);
	}
	
	@Test(priority=5)
	public void verifyAlreadyMemberLink() 
	{ 
		driver.findElement(By.partialLinkText("membership")).click();
	
		String expectedTitle = "JavaByKiran | Log in" ; 
		String actualTitle = driver.getTitle() ;
		
		Assert.assertEquals(actualTitle, expectedTitle);
		driver.findElement(By.partialLinkText("Register")).click();
	}
	
	@Test(priority=6)
	public void verifyPlaceholders() 
	{ 	
		List<WebElement> Placeholders =driver.findElements(By.xpath("//input"));
	
		ArrayList <String>actPlaceholderText = new ArrayList <String>();
		
		ArrayList <String>expPlaceholderText = new ArrayList <String>();
		expPlaceholderText.add("Name");
		expPlaceholderText.add("Mobile");
		expPlaceholderText.add("Email");
		expPlaceholderText.add("Password");
		
		for (WebElement element : Placeholders)
		{
			actPlaceholderText.add(element.getAttribute("placeholder"));
		}
		Assert.assertEquals(actPlaceholderText, expPlaceholderText);
	}
	
	@Test(priority=6)
	public void verifyBlankSignIn() 
	{
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
	}
	
	@Test(priority=7)
	public void verifyValidSignIn() 
	{
		driver.findElement(By.id("name")).sendKeys("Akshay");
		driver.findElement(By.id("mobile")).sendKeys("9876543210");
		driver.findElement(By.id("email")).sendKeys("akshay@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		
		Alert al = driver.switchTo().alert();
		Assert.assertEquals(al.getText() , "User registered successfully.");
		al.accept();
	}
	
	@AfterSuite
	public void closeWindow()
	{
		driver.quit();
	}
}
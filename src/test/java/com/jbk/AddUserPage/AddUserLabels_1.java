package com.jbk.AddUserPage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddUserLabels_1 
{	
	@Test(dataProvider="getLables")
	
	public void Verify_Labels(String uname,String mobile,String email
		  ,String course,String gender,String state,String pass) 
  {
	 	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	 	WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Akshay%20S%20Jain/Desktop/Selenium/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
	
		driver.findElement(By.xpath("//span[text()='Users']")).click();
		driver.findElement(By.xpath("//button[text()='Add User']")).click();
		
		List<WebElement> labels = driver.findElements(By.xpath("//button//preceding::label"));
  
		ArrayList<String> expLabels =new ArrayList<String>();
		expLabels.add(uname);
		expLabels.add(mobile);
		expLabels.add(email);
		expLabels.add(course);
		expLabels.add(gender);
		expLabels.add(state);
		expLabels.add(pass);
		
		ArrayList<String> actLabels =new ArrayList<String>();
		for(WebElement label : labels) 
		{
			String text= label.getText();
			actLabels.add(text);
		}
		Assert.assertEquals(actLabels, expLabels);
  }
 
	@DataProvider
	  public Object[][] getLables() 
	{
	   return new Object[][] 
	    {
	      new Object[] { "Username", "Mobile", "Email","Courses","Gender","State","Password"},
	    };
	}
}

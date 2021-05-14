package com.jbk.DownloadsPage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class downloadsLables_1 
{
		
	@Test(dataProvider="getLables")
	
	public void Verify_Labels(String sr,String name,String vendor,String version,String lowbit,String highbit,String common,String source) 
		
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	 	WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
	
		driver.findElement(By.xpath("//span[text()='Downloads']")).click();
		
		List<WebElement> labels = driver.findElements(By.xpath("//th"));
  
		ArrayList<String> expLabels =new ArrayList<String>();
		expLabels.add(sr);
		expLabels.add(name);
		expLabels.add(vendor);
		expLabels.add(version);
		expLabels.add(lowbit);
		expLabels.add(highbit);
		expLabels.add(common);
		expLabels.add(source);
		
		ArrayList<String> actLabels =new ArrayList<String>();
		
		for(WebElement label : labels) 
		{
			String text= label.getText();
			actLabels.add(text);
			System.out.println(text);
		}
		Assert.assertEquals(actLabels, expLabels);
	}
	 
		@DataProvider
		  public Object[][] getLables() 
		{
		   return new Object[][] 
		    {
		      new Object[] {"Sr", "Name", "vendor","Version","32bit","64bit","Common","Official Source/n"
		      		+ "*For prevoius and latest releases"},
		    };
		}
}



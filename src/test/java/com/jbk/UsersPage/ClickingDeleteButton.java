package com.jbk.UsersPage;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ClickingDeleteButton 
{
	int row = 2 ;
	
	@Test(dataProvider = "dp")
	  public void usersTable_1(String Msg) throws InterruptedException 
	  {
		  	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("file:///C:/Offline%20Website/index.html");
			driver.manage().window().maximize();
			driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
			driver.findElement(By.id("password")).sendKeys("123456");
			driver.findElement(By.xpath("//button")).click();
	  
			driver.findElement(By.xpath("//span[text()='Users']")).click();
			
			List<WebElement> Delete =driver.findElements(By.xpath("//tr[" + row +"]//td[8]"));
			
			ArrayList <String>actData = new ArrayList <String>();
			
			ArrayList <String>expData = new ArrayList <String>();
			expData.add(Msg);
			
				for (WebElement element : Delete)
				{
					element.click();
					
					Alert al = driver.switchTo().alert();
                    String Message = al.getText();
                    actData.add(Message);
				}
			row ++;
			Assert.assertEquals(actData, expData);
			driver.quit();
	  }
	
	@DataProvider
	public String [][] dp() throws Exception
	{
		FileInputStream fis = new FileInputStream("Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet6");
		
		int row = sh.getPhysicalNumberOfRows();
		
		String[][] data = new String [row-1][sh.getRow(row-1).getLastCellNum()];
		
		for (int i = 1; i < row ; i++) 
		{
			int col=sh.getRow(i).getLastCellNum();
			
			for (int j = 0; j <col; j++) 
			{
				Cell cell=sh.getRow(i).getCell(j);
				DataFormatter df=new DataFormatter();
				data[i-1][j] = df.formatCellValue(cell);
				System.out.print(df.formatCellValue(cell) + "        ");
			}
			System.out.println();
		}
		wb.close();
		return data ;
	}
}

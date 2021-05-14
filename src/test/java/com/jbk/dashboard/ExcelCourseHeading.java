package com.jbk.dashboard;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelCourseHeading 
{
	@Test(dataProvider = "dp")
	  public void usersTable_1(String Head) throws InterruptedException 
	  {
		  	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("file:///C:/Offline%20Website/index.html");
			driver.manage().window().maximize();
			driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
			driver.findElement(By.id("password")).sendKeys("123456");
			driver.findElement(By.xpath("//button")).click();
			
			List<WebElement> Headings =driver.findElements(By.xpath("//h3"));
			
			ArrayList <String>actData = new ArrayList <String>();
			
			ArrayList <String>expData = new ArrayList <String>();
			expData.add(Head);
			
				for (WebElement element : Headings)
				{
					actData.add(element.getText());
					System.out.println(element.getText());
				}
			Assert.assertEquals(actData, expData);
	  }
	
	@DataProvider
	public String [][] dp() throws Exception
	{
		FileInputStream fis = new FileInputStream("Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet5");
		
		int row = sh.getPhysicalNumberOfRows();
		
		String[][] data = new String [row-1][sh.getRow(row-1).getLastCellNum()-2];
		
		for(int i=1 ; i<row ; i++)
		{
			int col = sh.getRow(i).getLastCellNum();
			
			for (int j=0 ; j<col-2 ; j++)
			{
				Cell cell = sh.getRow(i).getCell(j);
				
				if (cell.getCellTypeEnum()==CellType.STRING)
					data[i-1][j]=cell.getStringCellValue();
					
				else if (cell.getCellTypeEnum()==CellType.NUMERIC)
				{
					String value = String.valueOf((long)cell.getNumericCellValue());
					
					data[i-1][j]=value;
				}
				System.out.println(data);
			}
			System.out.println();
		}
		wb.close();
		return data ;
		
	}
}

package com.jbk.AddUserPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragDownOptExcel 
{
	@Test
	  public void usersTable_1() throws Exception
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
			
			ArrayList <String> actDragDownOptions = new ArrayList <String>();
			
			ArrayList <String> expDragDownOptions  = new ArrayList <String>();
			
			WebElement State = driver.findElement(By.xpath("//select"));
			
			Select selectstate = new Select(State);
			
			List <WebElement> list = selectstate.getOptions();
			
			for(WebElement element : list)
			{
				actDragDownOptions.add(element.getText());
				System.out.println(element.getText());
			}
			
			String value=null;
			FileInputStream fis = new FileInputStream("Data.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("Sheet6");
			int row=sh.getPhysicalNumberOfRows();
			
			for (int i=0 ; i<row ; i++) 
			{
				int col=sh.getRow(i).getLastCellNum();
				for (int j=0; j<col ; j++) 
				{
					Cell cell=sh.getRow(i).getCell(j);
					DataFormatter df=new DataFormatter();
					value=df.formatCellValue(cell);
					expDragDownOptions.add(value);
				}
			}
			Assert.assertEquals(actDragDownOptions, expDragDownOptions);
	  }
}

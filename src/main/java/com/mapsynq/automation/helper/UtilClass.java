package com.mapsynq.automation.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilClass {

    private static Logger log = Logger.getLogger(UtilClass.class);
	private WebDriverWait wait;
	protected static XSSFSheet ExcelWSheet;
	protected static XSSFWorkbook ExcelWBook;
	protected static XSSFRow Row;
	protected static XSSFCell Cell;

	public void clickElement(WebDriver driver, WebElement element)
	{
		wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public void clickElementByLocator(WebDriver driver, By bylocator)
	{
		wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(bylocator));
		wait.until(ExpectedConditions.elementToBeClickable(bylocator));

		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(bylocator)).click().build().perform();
	}

	public void mouseoverElementAndClick(WebDriver driver, WebElement element, By locator)
	{
		wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Actions a = new Actions(driver);
		a.moveToElement(element).click().build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		a.moveToElement(driver.findElement(locator)).click().build().perform();
	}

	public String getElementText(WebDriver driver, WebElement element)
	{
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}

	public void selectByValue(WebElement element, String value)
	{
		new Select(element).selectByVisibleText(value);
	}

	public void selectByIndex(WebElement element, int value)
	{
		new Select(element).selectByIndex(value);
	}

	public void setText(WebDriver driver, WebElement element, String text)
	{
		wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.clear();
		element.sendKeys(text);
	}

	public void waitForSeconds(int sec)
	{
		try
		{
			log.info("Sleeping for "+sec+" seconds");
			Thread.sleep(sec * 1000L);
		}
		catch(Exception e)
		{
			log.info("Problem in sleep");
		}
	}
	
	public void waitForElementToAppear(WebDriver driver, WebElement ele) {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public boolean isElementPresent(WebElement ele) {
		try {
			return ele.isDisplayed();
		} catch(Exception e) {
			log.info("Problem in locating element : " + e.toString());
		}
		return false;
	}
	
	public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {   
		   Object[][] tabArray = null;
		   try {
			   FileInputStream ExcelFile = new FileInputStream(FilePath);
			   ExcelWBook = new XSSFWorkbook(ExcelFile);
			   ExcelWSheet = ExcelWBook.getSheet(SheetName);
			   int startRow = 1;
			   int startCol = 1;
			   int ci,cj;
			   int totalRows = ExcelWSheet.getLastRowNum();
			   Row = ExcelWSheet.getRow(0);
			   int totalCols = Row.getLastCellNum();
			   tabArray=new String[totalRows][totalCols];
			   ci=0;
			   for (int i=startRow;i<=totalRows;i++, ci++) {
				  cj=0;
				   for (int j=startCol-1;j<totalCols;j++, cj++){
					   tabArray[ci][cj]=getCellData(i,j);
					   System.out.println(tabArray[ci][cj]);  
						}
					}
				}
			catch (FileNotFoundException e){
				System.out.println("Could not read the Excel sheet");
				e.printStackTrace();
				}
			catch (IOException e){
				System.out.println("Could not read the Excel sheet");
				e.printStackTrace();
				}
			return(tabArray);
			}

		public static String getCellData(int RowNum, int ColNum) throws Exception {
			try{
				Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
				@SuppressWarnings("deprecation")
				int dataType=1;
				if  (dataType == 3) {
					return "";
				}else{
					String CellData = Cell.getStringCellValue();
					return CellData;
				}
			}
				catch (Exception e){
				System.out.println(e.getMessage());
				throw (e);
				}
		}
}
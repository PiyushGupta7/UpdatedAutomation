package com.crm.qa.util;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public String sheetname;

	
	public ExcelUtils(String sheetname)
	{
		try {
		workbook = new XSSFWorkbook("C:\\Users\\piyushgupta7\\eclipse-workspace\\Framework\\TestData\\TestData.xlsx");
		sheet=workbook.getSheet(sheetname);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

	public static int getRowCount()
	{
		int rowCount=0;
		
		try {
			
		rowCount=sheet.getPhysicalNumberOfRows();
		} catch (Exception e) {
			e.printStackTrace();
		}
	return rowCount;
	}
	
	public static int getColCount()
	{
		int colCount=0;
		try {
			
			colCount=sheet.getRow(0).getPhysicalNumberOfCells();
		} catch (Exception e) {
			e.printStackTrace();
		}
	return colCount;
	}
	
	public static String getCellData(int rowNum,int colNum)
	{
		String cellData=null;
		try {
			
			cellData=sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cellData;
	}
	
	public static Object[][] testData(String sheetname)
	{
		ExcelUtils excel=new ExcelUtils(sheetname);
		int rowCount=excel.getRowCount();
		int colCount=excel.getColCount();
	
		
		Object data[][]=new Object[rowCount-1][colCount];
		for(int i=1;i<rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				String cellData=excel.getCellData(i,j);
				data[i-1][j]=cellData;
				System.out.println(cellData);
			}
		}
		return data;
	}
	
	

}

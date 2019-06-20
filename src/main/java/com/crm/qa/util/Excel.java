package com.crm.qa.util;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	
	public  static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public String sheetname;
	
	
public static Object[][] testData(String sheetname) {
	String cellData=null;
	try {
	workbook=new XSSFWorkbook("C:\\Users\\piyushgupta7\\eclipse-workspace\\Framework\\TestData\\TestData.xlsx");
	} catch (IOException e) {
		e.printStackTrace();
	}
	
   sheet=workbook.getSheet(sheetname);
   int rowcount=sheet.getPhysicalNumberOfRows();
   int colcount=sheet.getRow(0).getPhysicalNumberOfCells();
   Object data[][]=new Object[rowcount-1][colcount];
   for(int i=1;i<rowcount;i++)
   {
	   for(int j=0;j<colcount;j++)
	   {
		   cellData = sheet.getRow(i).getCell(j).getStringCellValue();
		   data[i-1][j]=cellData;
	   }
   

}
   return data;



}
}







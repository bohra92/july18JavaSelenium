package com.demoaut.newtours.utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	//reading from excel logic
	public static String[][] getData(String fileName, String sheetName) throws IOException{
		File file = new File(fileName);
		FileInputStream inputFile = new FileInputStream(file);
		Workbook wb= new XSSFWorkbook(inputFile);
		Sheet sh= wb.getSheet(sheetName);
		int rowNum= sh.getLastRowNum() + 1;
		int colNum= sh.getRow(0).getLastCellNum();
		String data[][]=new String [rowNum][colNum];
		for (int i= 0; i<rowNum; i++){
			Row row= sh.getRow(i);
			for (int j=0; j<colNum; j++){
				Cell cell= row.getCell(j);
				//String value= cellToString(cell);
				String value= new DataFormatter().formatCellValue(cell);
				data[i][j]= value;
			}
		}
		return data;
	}
	
	//logic for fetching register and login page data
	public static String[][] getLoginOrRegisterUserData() throws IOException{
		String[][] data= ReadExcel.getData("C:\\Users\\\\M1030501\\\\workspace\\\\java_selenium\\\\JAVA-PROJECT\\\\test.xlsx", "Sheet1");
		return data;
	}
	
	//logic for fetching required flight data 
	public static String[][] getFlightData() throws IOException{
		String[][] data= ReadExcel.getData("C:\\\\Users\\\\M1030501\\\\workspace\\\\java_selenium\\\\JAVA-PROJECT\\\\test.xlsx", "Sheet2");
		return data;
	}
}

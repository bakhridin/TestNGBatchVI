package com.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EXCEL {
	public static String filePath=System.getProperty("user.dir")+"/excel/file.xlsx";
	
	public static Workbook workBook;

	public static void main(String[] args) {
		
		
		try {
			FileInputStream file=new FileInputStream(filePath);
			workBook=new XSSFWorkbook(file);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		Sheet sheet1=workBook.getSheet("Sheet1");
		
		String row1cell1=sheet1.getRow(1).getCell(1).toString();
		System.out.println(row1cell1);

	}

}

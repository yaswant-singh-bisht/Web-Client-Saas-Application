package com.saas.app.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelUtilities {
	public Object[][] getExcelData(String excelFilePath, String sheetName) {
		Object[][] outputData = null;
		FileInputStream file = null;
		XSSFWorkbook rwb = null;
		XSSFSheet rsh = null;
		XSSFCell cell = null;
		
		try {
			file = new FileInputStream(excelFilePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			rwb = new XSSFWorkbook(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		rsh = rwb.getSheet(sheetName);
		int norow = rsh.getPhysicalNumberOfRows();
		int nocol = rsh.getRow(0).getPhysicalNumberOfCells();

		outputData = new Object[norow-1][nocol];
		DataFormatter formatter = new DataFormatter();
		
		for (int i = 1; i < norow; i++) {
			for(int j = 0; j < nocol; j++) {
				cell = rsh.getRow(i).getCell(j);
				outputData[i-1][j] = formatter.formatCellValue(cell);
			}
		
		}
		return outputData;
	}
	
}

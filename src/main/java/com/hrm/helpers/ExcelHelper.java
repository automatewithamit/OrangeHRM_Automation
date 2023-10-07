package com.hrm.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.hrm.reporting.Reporter;

public class ExcelHelper {
	FileInputStream fileInputStream;
	Workbook workbook;

	public ExcelHelper(String filePath) {

		try {
			String dir = System.getProperty("user.dir");
			fileInputStream = new FileInputStream(new File(dir + filePath));

			workbook = new XSSFWorkbook(fileInputStream);

		} catch (IOException e) {
			Reporter.info("IO Exception Occurred in Excel File");
		}
	}

	public Map<String, String> read(String sheetName) {

		Map<String, String> dataMap = new HashMap<>();

		// Access the desired sheet (e.g., Sheet 0)
		Sheet sheet = workbook.getSheet(sheetName);

		// Assume the first row contains column names
		Row headerRow = sheet.getRow(0);

		// Iterate through columns to create keys
		for (Cell cell : headerRow) {
			dataMap.put(cell.toString(), null);
		}

		// Assume the second row contains values
		Row valueRow = sheet.getRow(1);

		// Iterate through values and populate the map
		int columnIndex = 0;
		for (Cell cell : valueRow) {
			String columnName = headerRow.getCell(columnIndex).toString();
			String cellValue = cell.toString();
			dataMap.put(columnName, cellValue);
			columnIndex++;
		}
		try {
			workbook.close();
		} catch (IOException e) {
			System.out.println("Error while closing the workbook");
		}
		return dataMap;
	}

}

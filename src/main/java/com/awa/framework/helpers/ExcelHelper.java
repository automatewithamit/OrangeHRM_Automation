package com.awa.framework.helpers;

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
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.awa.framework.reporting.Reporter;

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
//		for (Cell cell : headerRow) {
//			dataMap.put(cell.toString(), null);
//		}

		// Assume the second row contains values
		Row valueRow = sheet.getRow(1);

		// Iterate through values and populate the map
		int columnIndex = 0;
		for (Cell cell : valueRow) {
			// taking Cells value from from 1st Row
			String columnName = headerRow.getCell(columnIndex).toString();
			// taking cells value from 2nd Row
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

	public Object[][] readExcelData(String sheetName) {
		Object[][] data = null;

		Sheet sheet = workbook.getSheet(sheetName);

		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();

		// Initialize numRowsWithData to 0
		int numRowsWithData = 0;

		for (int i = 1; i <= rowCount; i++) {
			Row row = sheet.getRow(i);

			// Check if the row has data (non-null cells)
			boolean hasData = false;
			for (int j = 0; j < colCount; j++) {
				Cell cell = row.getCell(j);
				if (cell != null) {
					hasData = true;
					break;
				}
			}

			if (hasData) {
				numRowsWithData++;
			} else {
				break; // Exit the loop when a row without data is encountered
			}
		}

		data = new Object[numRowsWithData][colCount];

		for (int i = 1; i <= numRowsWithData; i++) {
			Row row = sheet.getRow(i);

			for (int j = 0; j < colCount; j++) {
				Cell cell = row.getCell(j);

				// Check if cell is null before accessing its properties
				if (cell != null) {
					if (cell.getCellType() == CellType.STRING) {
						data[i - 1][j] = cell.getStringCellValue();
					} else if (cell.getCellType() == CellType.NUMERIC) {
						data[i - 1][j] = cell.getNumericCellValue();
					} else if (cell.getCellType() == CellType.BOOLEAN) {
						data[i - 1][j] = cell.getBooleanCellValue();
					}
					// Add additional conditions for other cell types as needed
				} else {
					// Handle the case where the cell is null (e.g., set a default value)
					data[i - 1][j] = "N/A";
				}
			}
		}

		return data;
	}
}

package com.qacart.todo.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtils {
    private static Workbook workbook;
    private static Sheet sheet;

    // Method to load the Excel file and sheet
    public static void setExcelFile(String filePath, String sheetName) throws IOException {
        FileInputStream inputStream = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(inputStream);
        sheet = workbook.getSheet(sheetName);
    }

    // Method to get data from Excel
    public static Object[][] getExcelData() throws IOException {
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                Cell cell = ((Row) row).getCell(j);
                data[i - 1][j] = cellToString(cell);

            }
        }

        return data;
    }

    // Helper method to convert cell values to String
    private static String cellToString(Cell cell) throws IOException {
        CellType cellType = cell.getCellType();
        switch (cellType) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf((int) cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
    }
    // Close the workbook when done
    public static void closeWorkbook() throws IOException {
        if (workbook != null) {
            workbook.close();
        }
    }

}

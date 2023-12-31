package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelCode {

	public static void main(String[] args) {

		readData();
	}

	public static void readData() {

		String path = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\resources\\Testing Task Tracker -Anshul.xlsx";

		try {
			FileInputStream fis = new FileInputStream(path);

			XSSFWorkbook wb = new XSSFWorkbook(fis);

			XSSFSheet sh = null;

			for (int i = 0; i < wb.getNumberOfSheets(); i++) {

				if (wb.getSheetName(i).equalsIgnoreCase("MGM-Test Cases")) {

					System.out.println("Sheet Found!!!!");

					sh = wb.getSheetAt(i);
					Row firstRow = sh.getRow(0);
					Iterator<Row> rowIt = sh.iterator();
					Iterator<Cell> cellIt = firstRow.cellIterator();
					int rowNum1 = 0;
					int column = 0;
					int cellNum = 0;
					int num = 0;
					while (rowIt.hasNext()) {
						rowIt.next();

						Row row = sh.getRow(rowNum1);

						rowNum1++;

						while (cellIt.hasNext()) {

							cellIt.next();

							if (row.getCell(column).getStringCellValue().equalsIgnoreCase("TC_Id")) {

								cellNum = column;
								System.out.println(cellNum);

							}

							column++;

						}

						column = 0;

						System.out.println(row.getCell(cellNum).getStringCellValue());
						if (row.getCell(cellNum).getStringCellValue().isBlank()) {

							System.out.println("Field is Blank");
							break;

						}

//						else {
//
//
//						}

					}

				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static void writeData(String TG) {

		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\resources\\Book14.xlsx";

		FileInputStream fis;
		XSSFWorkbook wb = null;
		try {
			fis = new FileInputStream(path);

			wb = new XSSFWorkbook(fis);

			XSSFSheet sh = wb.getSheetAt(0);

			Row firstRow = sh.getRow(0);
			int noOfrows = sh.getPhysicalNumberOfRows();
			int noOfCells = firstRow.getLastCellNum();
			System.out.println("Before for");
			for (int i = 0; i < noOfCells; i++) {
				System.out.println("After for");
				String cellName = firstRow.getCell(i).getStringCellValue();
				System.out.println(cellName);
				if (cellName.equalsIgnoreCase("Row")) {
					System.out.println("Inside if " + noOfrows);
					for (int j = 1; j <= noOfrows; j++) {
						System.out.println("Inside if for");
						sh.getRow(j).createCell(i).setCellValue(TG);
						FileOutputStream fos = new FileOutputStream(path);
						System.out.println("Beforedone");
						wb.write(fos);
						System.out.println("Afterdone");
						noOfrows++;

					}

				}

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}

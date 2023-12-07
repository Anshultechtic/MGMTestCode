package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelCode2 {

	@Test
	public void writeExcel() throws IOException {

		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\resources\\Book14.xlsx";

		FileInputStream fis = new FileInputStream(path);

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sh = wb.getSheetAt(0);
		int k = 0;
		int i = 0;

		for (i = 0; i < sh.getPhysicalNumberOfRows(); i++) {

			
			
			
			
		}
		Row firstRow = sh.getRow(i);

		Iterator<Row> rowIt = sh.iterator();

		
		while (rowIt.hasNext()) {
			rowIt.next();

			Iterator<Cell> cellIt = firstRow.cellIterator();

			while (cellIt.hasNext()) {

				cellIt.next();

				System.out.print(firstRow.getCell(k).getStringCellValue() + " ");

				k++;

			}
			k = 0;
			System.out.println();
		}
	}

}

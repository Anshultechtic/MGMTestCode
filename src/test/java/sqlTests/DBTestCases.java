package sqlTests;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.testng.annotations.Test;

import baseTest.BaseClass;
import utils.ExcelCode;

public class DBTestCases extends BaseClass {

	@Test
	public void testRowTable() throws SQLException {
		System.out.println("Hello TC 2");
		ArrayList<String> list = new ArrayList<>();
		ArrayList<Integer> dataTypeRowIDlist = new ArrayList<>();

		Statement stat = connection.createStatement();
		String rowIDTG = null;
		String rowOfRowID = null;
		int dataTypeRowID = 0;
		String columnName = null;
		ResultSet r = stat.executeQuery(
				"SELECT \r\n"
				+ "   \"t-Cell\".\"Row\",\"t-Col\".\"Col\", \"t-Col\".\"Col-Name\"->>'column' as \"ColName\",\r\n"
				+ "   \"t-Item\".\"Cell\", \"t-Item\".\"Item\",\"t-Item\".\"Data\",\r\n"
				+ "	\"t-Row\".\"Share\", \"t-Data\".\"Data-Type\",  \"t-Data\".\"Row-Data\", \"t-Data\".\"Bool-Data\", \r\n"
				+ "	\"t-Data\".\"BigInt-Data\", \r\n"
				+ "	\"t-Data\".\"JSON-Data\"->> '20000174' as mlText\r\n"
				+ "	FROM \"AIC\".\"t-Item\"\r\n"
				+ "	join \"t-Cell\" on \"t-Cell\".\"Cell\" = \"t-Item\".\"Cell\"\r\n"
				+ "	join \"t-Col\" on \"t-Cell\".\"Col\" = \"t-Col\".\"Col\"\r\n"
				+ "	join \"t-Row\" on \"t-Cell\".\"Row\"= \"t-Row\".\"Row\"\r\n"
				+ "	join \"t-Data\" on \"t-Data\".\"Data\" = \"t-Item\".\"Data\" \r\n"
				+ "	 where \"t-Item\".\"Item\" between 50002475 and 50002481;");

		while (r.next()) {

			rowIDTG = r.getString("Row");
			 rowOfRowID = r.getString("Row");
			System.out.println(rowIDTG + " "+  rowOfRowID);
			ExcelCode.writeData(rowIDTG);

		}
	}

}

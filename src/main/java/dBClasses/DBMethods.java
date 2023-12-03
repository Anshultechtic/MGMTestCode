package dBClasses;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import baseTest.BaseClass;

public class DBMethods extends BaseClass {

	private String colID;

	public void testRowTable(long rowID, long ColID) throws SQLException {
		System.out.println("Hello TC 2");
		ArrayList<String> list = new ArrayList<>();
		ArrayList<Integer> dataTypeRowIDlist = new ArrayList<>();

		Statement stat = connection.createStatement();
		String rowIDTG = null;
		String rowOfRowID = null;
		String rowOfRowColName = null;
		int dataTypeRowID = 0;
		String columnName = null;
		ResultSet r = stat.executeQuery("SELECT \r\n"
				+ "   \"t-Cell\".\"Row\",\"t-Col\".\"Col\", \"t-Col\".\"Col-Name\"->>'column' as \"ColName\",\r\n"
				+ "   \"t-Item\".\"Cell\", \"t-Item\".\"Item\",\"t-Item\".\"Data\",\r\n"
				+ "	\"t-Row\".\"Share\", \"t-Data\".\"Data-Type\",  \"t-Data\".\"Row-Data\", \"t-Data\".\"Bool-Data\", \r\n"
				+ "	\"t-Data\".\"BigInt-Data\", \r\n" + "	\"t-Data\".\"JSON-Data\"->> '20000174' as mlText\r\n"
				+ "	FROM \"public\".\"t-Item\"\r\n"
				+ "	join \"t-Cell\" on \"t-Cell\".\"Cell\" = \"t-Item\".\"Cell\"\r\n"
				+ "	join \"t-Col\" on \"t-Cell\".\"Col\" = \"t-Col\".\"Col\"\r\n"
				+ "	join \"t-Row\" on \"t-Cell\".\"Row\"= \"t-Row\".\"Row\"\r\n"
				+ "	join \"t-Data\" on \"t-Data\".\"Data\" = \"t-Item\".\"Data\" \r\n");
//				+ "	 where \"t-Item\".\"Item\" between 50002475 and 50002481;"

		while (r.next()) {

			rowIDTG = r.getString("Row");
			rowOfRowID = r.getString("Row");
			rowOfRowColName = r.getString("ColName");

			System.out.println(rowIDTG + " " + ColID + " " + rowOfRowID + " " + rowOfRowColName);

		}
	}

	public void getRowIDByItemName(String Itemname) {
		Statement stat;
		try {
			stat = connection.createStatement();
			String rowIDTG = null;
			ResultSet r = stat.executeQuery("SELECT \r\n" + "   \"t-Row\".\"Row\" as \"Row\",\r\n"
					+ "   \"t-Col\".\"Col\"  as \"Coli\",  \r\n" + "   \"t-Item\".\"Cell\" as \"Cell-ID\", \r\n"
					+ "   \"t-Col\".\"Col-Name\"->>'column' as \"ColName\",\r\n"
					+ "   \"t-Data\".\"JSON-Data\"->> '20000174' as mlText\r\n" + "	FROM \"public\".\"t-Item\"\r\n"
					+ "	join \"t-Cell\" on \"t-Cell\".\"Cell\" = \"t-Item\".\"Cell\"\r\n"
					+ "	join \"t-Col\" on \"t-Cell\".\"Col\" = \"t-Col\".\"Col\"\r\n"
					+ "	join \"t-Row\" on \"t-Cell\".\"Row\"= \"t-Row\".\"Row\"\r\n"
					+ "	join \"t-Data\" on \"t-Data\".\"Data\" = \"t-Item\".\"Data\"\r\n"
					+ "	where \"JSON-Data\"->> '20000174' = '" + Itemname + "';");

			while (r.next()) {

				rowIDTG = r.getString("Row");
				System.out.println(rowIDTG);

			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void getColIDByItemName(String Itemname) {
		Statement stat;
		try {
			stat = connection.createStatement();
			String colID = null;
			ResultSet r = stat.executeQuery("SELECT \r\n" + "   \"t-Row\".\"Row\" as \"Row\",\r\n"
					+ "   \"t-Col\".\"Col\"  as \"Col\",  \r\n" + "   \"t-Item\".\"Cell\" as \"Cell-ID\", \r\n"
					+ "   \"t-Col\".\"Col-Name\"->>'column' as \"ColName\",\r\n"
					+ "   \"t-Data\".\"JSON-Data\"->> '20000174' as mlText\r\n" + "	FROM \"public\".\"t-Item\"\r\n"
					+ "	join \"t-Cell\" on \"t-Cell\".\"Cell\" = \"t-Item\".\"Cell\"\r\n"
					+ "	join \"t-Col\" on \"t-Cell\".\"Col\" = \"t-Col\".\"Col\"\r\n"
					+ "	join \"t-Row\" on \"t-Cell\".\"Row\"= \"t-Row\".\"Row\"\r\n"
					+ "	join \"t-Data\" on \"t-Data\".\"Data\" = \"t-Item\".\"Data\"\r\n"
					+ "	where \"JSON-Data\"->> '20000174' = '" + Itemname + "';");

			while (r.next()) {

				colID = r.getString("Col");
				System.out.println(colID);

			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void getCellIDByItemName(String Itemname) {
		Statement stat;
		try {
			stat = connection.createStatement();
			String colID = null;
			ResultSet r = stat.executeQuery(" SELECT \r\n" + "   \"t-Row\".\"Row\" as \"Row\",\r\n"
					+ "   \"t-Col\".\"Col\"  as \"Col\",  \r\n" + "   \"t-Item\".\"Cell\" as \"Cell\", \r\n"
					+ "   \"t-Col\".\"Col-Name\"->>'column' as \"ColName\",\r\n"
					+ "   \"t-Data\".\"JSON-Data\"->> '20000174' as mlText\r\n" + "	FROM \"public\".\"t-Item\"\r\n"
					+ "	join \"t-Cell\" on \"t-Cell\".\"Cell\" = \"t-Item\".\"Cell\"\r\n"
					+ "	join \"t-Col\" on \"t-Cell\".\"Col\" = \"t-Col\".\"Col\"\r\n"
					+ "	join \"t-Row\" on \"t-Cell\".\"Row\"= \"t-Row\".\"Row\"\r\n"
					+ "	join \"t-Data\" on \"t-Data\".\"Data\" = \"t-Item\".\"Data\"\r\n"
					+ "	where \"JSON-Data\"->> '20000174' = '" + Itemname + "';");

			while (r.next()) {

				colID = r.getString("Cell");
				System.out.println(colID);

			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void getItemNameByRowIDAndColID(long rowID, long ColID) {

		Statement stat;
		try {
			stat = connection.createStatement();
			String itemName = null;
			ResultSet r = stat
					.executeQuery("SELECT\r\n" + "   \"t-Data\".\"JSON-Data\"->> '20000174' as \"NameOfItem\"\r\n"
							+ "	FROM \"public\".\"t-Item\"\r\n"
							+ "	join \"t-Cell\" on \"t-Cell\".\"Cell\" = \"t-Item\".\"Cell\"\r\n"
							+ "	join \"t-Col\" on \"t-Cell\".\"Col\" = \"t-Col\".\"Col\"\r\n"
							+ "	join \"t-Row\" on \"t-Cell\".\"Row\"= \"t-Row\".\"Row\"\r\n"
							+ "	join \"t-Data\" on \"t-Data\".\"Data\" = \"t-Item\".\"Data\"\r\n"
							+ "	where \"t-Row\".\"Row\" = " + rowID + " and \"t-Col\".\"Col\" = " + ColID + " ;");

			while (r.next()) {

				itemName = r.getString("NameOfItem");
				System.out.println(itemName);

			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void getItemByCellID(long rowID, long ColID) {
		Statement stat;
		int count = 0;
		try {
			stat = connection.createStatement();
			String cellID = null;
		
			ResultSet r = stat
					.executeQuery("SELECT\r\n"
							+ "   \"t-Data\".\"JSON-Data\"->> '20000174' as \"NameOfItem\", \r\n"
							+ "   \"t-Cell\".\"Cell\" as \"Cell\"\r\n"
							+ "	FROM \"public\".\"t-Item\"\r\n"
							+ "	join \"t-Cell\" on \"t-Cell\".\"Cell\" = \"t-Item\".\"Cell\"\r\n"
							+ "	join \"t-Col\" on \"t-Cell\".\"Col\" = \"t-Col\".\"Col\"\r\n"
							+ "	join \"t-Row\" on \"t-Cell\".\"Row\"= \"t-Row\".\"Row\"\r\n"
							+ "	join \"t-Data\" on \"t-Data\".\"Data\" = \"t-Item\".\"Data\"\r\n"
							+ "	where \"t-Row\".\"Row\" = " + rowID + 
							   " and \"t-Col\".\"Col\" = " + ColID + " ;");

			while (r.next()) {
				
				cellID = r.getString("Cell");
				System.out.println( "Cell ID is "+cellID);
				count++;
				

			}
			System.out.println("Number of Item in the Cell =" +count);
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
	}

	public void getItemNameByCelID(long rowID, long ColID) {

	}

	public void getRowID_CelID_ItemID_ItemName(long rowID, long ColID) {

	}

	public void getItemID(long rowID, long ColID) {

	}

	public void getDataID(long rowID, long ColID) {

	}

	public void getUserID(long rowID, long ColID) {

	}

}

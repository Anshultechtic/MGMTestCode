package sqlTests;

import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.SQLConnection;

public class DataBaseTestCases extends SQLConnection {

	@Test
	public void testFormaTable() {

		try {
//			connection = DriverManager.getConnection(url, user, password);
//
//			System.out.println("Connected to PostgreSQL database successfully!");

			String tableName = "t-Item";

			int num = 0;

			DatabaseMetaData databaseMetaData = connection.getMetaData();

			// Get information about the table
			ResultSet tableResultSet = databaseMetaData.getColumns(null, null, tableName, null);

			// Iterate through the result set and print column details
			while (tableResultSet.next()) {
				String columnName = tableResultSet.getString("COLUMN_NAME");
				String dataType = tableResultSet.getString("TYPE_NAME");
				int columnSize = tableResultSet.getInt("COLUMN_SIZE");
				int nullable = tableResultSet.getInt("NULLABLE");
				if (dataType.equals("int4")) {

					dataType = "Integer";

				}
				if (dataType.equals("int8")) {

					dataType = "BigInt";

				}

				if (dataType.equals("_int4")) {

					dataType = "Integer[]";

				}
				if (dataType.equals("_int8")) {

					dataType = "BigInt[]";

				}

//				System.out.println("Column Name: " + columnName);
//				System.out.println("Data Type: " + dataType);
//				System.out.println("Column Size: " + columnSize);
//				System.out.println("Nullable: " + (nullable == DatabaseMetaData.columnNullable ? "YES" : "NO"));

				if (columnName.equalsIgnoreCase("Cell")) {
					Assert.assertEquals(columnName, "Cell");
					Assert.assertEquals(dataType, "BigInt");
					Assert.assertEquals(nullable, 1);

					System.out.println(columnName + " has Data type is " + dataType + " and is "
							+ (nullable == DatabaseMetaData.columnNullable ? "Not Mandatory" : "Mandatory"));

				}

				if (columnName.equalsIgnoreCase("Item")) {
					Assert.assertEquals(columnName, "Item");
					Assert.assertEquals(dataType, "BigInt");
					Assert.assertEquals(nullable, 0);
					System.out.println(columnName + " has Data type is " + dataType + " and is "
							+ (nullable == DatabaseMetaData.columnNullable ? "Not Mandatory." : "Mandatory."));
				}

				if (columnName.equalsIgnoreCase("Inherit")) {

					Assert.assertEquals(columnName, "Inherit");
					Assert.assertEquals(dataType, "BigInt[]");
					Assert.assertEquals(nullable, 1);
					System.out.println(columnName + " has Data type is " + dataType + " and is "
							+ (nullable == DatabaseMetaData.columnNullable ? "Not Mandatory." : "Mandatory."));

				}
				if (columnName.equalsIgnoreCase("Data-Type")) {
					Assert.assertEquals(columnName, "Data-Type");
					Assert.assertEquals(dataType, "BigInt");
					Assert.assertEquals(nullable, 0);
					System.out.println(columnName + " has Data type is " + dataType + " and is "
							+ (nullable == DatabaseMetaData.columnNullable ? "Not Mandatory." : "Mandatory."));

				}

				if (columnName.equalsIgnoreCase("Data-Range")) {
					Assert.assertEquals(columnName, "Data-Range");
					Assert.assertEquals(dataType, "BigInt[]");
					Assert.assertEquals(nullable, 1);

				}

				if (columnName.equalsIgnoreCase("Row-Data")) {
					Assert.assertEquals(columnName, "Row-Data");
					Assert.assertEquals(dataType, "BigInt");
					Assert.assertEquals(nullable, 1);

				}

				if (columnName.equalsIgnoreCase("Bool-Data")) {
					Assert.assertEquals(columnName, "Item");
					Assert.assertEquals(dataType, "BigInt");
					Assert.assertEquals(nullable, 1);

				}

				if (columnName.equalsIgnoreCase("DateTime-Data")) {
					Assert.assertEquals(columnName, "DateTime-Data");
					Assert.assertEquals(dataType, "timestamp");
					Assert.assertEquals(nullable, 1);

				}

				if (columnName.equalsIgnoreCase("Color-Data")) {
					Assert.assertEquals(columnName, "Item");
					Assert.assertEquals(dataType, "Integer");
					Assert.assertEquals(nullable, 1);

				}

				if (columnName.equalsIgnoreCase("Int-Data")) {
					Assert.assertEquals(columnName, "Integer");
					Assert.assertEquals(dataType, "Integer");
					Assert.assertEquals(nullable, 0);

				}

				if (columnName.equalsIgnoreCase("BigInt-Data")) {
					Assert.assertEquals(columnName, "BigInt-Data");
					Assert.assertEquals(dataType, "int8");
					Assert.assertEquals(nullable, 0);

				}
				if (columnName.equalsIgnoreCase("Num-Data")) {
					Assert.assertEquals(columnName, "Item");
					Assert.assertEquals(dataType, "int8");
					Assert.assertEquals(nullable, 0);

				}
				if (columnName.equalsIgnoreCase("JSON-Data")) {
					Assert.assertEquals(columnName, "Item");
					Assert.assertEquals(dataType, "int8");
					Assert.assertEquals(nullable, 0);

				}
				if (columnName.equalsIgnoreCase("Qty-Data")) {
					Assert.assertEquals(columnName, "Item");
					Assert.assertEquals(dataType, "int8");
					Assert.assertEquals(nullable, 0);

				}
				if (columnName.equalsIgnoreCase("Unit-Data")) {
					Assert.assertEquals(columnName, "Item");
					Assert.assertEquals(dataType, "int8");
					Assert.assertEquals(nullable, 0);

				}
				if (columnName.equalsIgnoreCase("Std-Qty-Data")) {
					Assert.assertEquals(columnName, "Item");
					Assert.assertEquals(dataType, "int8");
					Assert.assertEquals(nullable, 0);

				}
				if (columnName.equalsIgnoreCase("Foreign-Data")) {
					Assert.assertEquals(columnName, "Item");
					Assert.assertEquals(dataType, "int8");
					Assert.assertEquals(nullable, 0);

				}
				if (columnName.equalsIgnoreCase("Unit-Data")) {
					Assert.assertEquals(columnName, "Item");
					Assert.assertEquals(dataType, "int8");
					Assert.assertEquals(nullable, 0);

				}

				num++;
				System.out.println();
			}

			System.out.println("Number of Columns are =>" + num);
			Assert.assertEquals(num, 18);

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testRowTable() throws SQLException {
	
		ArrayList<String> list = new ArrayList<>();
		ArrayList<Integer> dataTypeRowIDlist = new ArrayList<>();

		Statement stat = connection.createStatement();
		String name = null;
		int dataTypeRowID = 0;
		String columnName = null;
		ResultSet r = stat.executeQuery(
				"SELECT \"TG\", \"Col\", \"Col-Name\", \"Data-Type\", \"DDT-Source\"\r\n" + "	FROM public.\"t-Col\"");

		while (r.next()) {

			name = r.getString("Col-Name");
			dataTypeRowID = r.getInt("Data-Type");
			columnName = name.split(":")[1].replace("\"", "").replace("}", "").trim();
			list.add(columnName);
			dataTypeRowIDlist.add(dataTypeRowID);

		}

//		System.out.println(list.toString());
//
//		System.out.println(dataTypeRowIDlist.toString());
//
//		for (int i = 0; i < list.size(); i++) {
//
//			if (list.get(i).equals("TG Name") && dataTypeRowIDlist.get(i).equals(20000216)) {
//
//				System.out.println("Passed :- <" + list.get(i) + "> has the dataType " + dataTypeRowIDlist.get(i));
//			} else {
//				System.out.println("Failed :- <" + list.get(i) + "> don't have correct DataType");
//			}
//
//			if (list.get(i).equals("TG") && dataTypeRowIDlist.get(i).equals(20000247)) {
//
//				System.out.println("Passed :- <" + list.get(i) + "> has the dataType " + dataTypeRowIDlist.get(i));
//
//			} else {
//				System.out.println("Failed :- <" + list.get(i) + "> don't have correct DataType");
//			}
//
//		}
//
	}
	
	@Test
	public void testItemCountTable() throws SQLException {
	
		Statement stat = connection.createStatement();
		String name = null;
		int count = 0;
		String columnName = null;
		ResultSet r = stat.executeQuery(
				"SELECT * FROM public.\"t-Col\";");

		while (r.next()) {

			count++;

		}
		
		System.out.println(count);
		
	}
	
	
//
//	@Test
//	public void testColTable() {
//		try {
//			connection = DriverManager.getConnection(url, user, password);
//
//			System.out.println("Connected to PostgreSQL database successfully!");
//
//			String tableName = "t-Col";
//
//			DatabaseMetaData databaseMetaData = connection.getMetaData();
//
//			// Get information about the table
//			ResultSet tableResultSet = databaseMetaData.getColumns(null, null, tableName, null);
//
//			// Iterate through the result set and print column details
//			while (tableResultSet.next()) {
//				String columnName = tableResultSet.getString("COLUMN_NAME");
//				String dataType = tableResultSet.getString("TYPE_NAME");
//				int columnSize = tableResultSet.getInt("COLUMN_SIZE");
//				int nullable = tableResultSet.getInt("NULLABLE");
//
//				System.out.println("Column Name: " + columnName);
//				System.out.println("Data Type: " + dataType);
//				System.out.println("Column Size: " + columnSize);
//				System.out.println("Nullable: " + (nullable == DatabaseMetaData.columnNullable ? "YES" : "NO"));
//				System.out.println();
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testCellTable() {
//		try {
//			connection = DriverManager.getConnection(url, user, password);
//
//			System.out.println("Connected to PostgreSQL database successfully!");
//
//			String tableName = "t-Cell";
//
//			DatabaseMetaData databaseMetaData = connection.getMetaData();
//
//			// Get information about the table
//			ResultSet tableResultSet = databaseMetaData.getColumns(null, null, tableName, null);
//
//			// Iterate through the result set and print column details
//			while (tableResultSet.next()) {
//				String columnName = tableResultSet.getString("COLUMN_NAME");
//				String dataType = tableResultSet.getString("TYPE_NAME");
//				int columnSize = tableResultSet.getInt("COLUMN_SIZE");
//				int nullable = tableResultSet.getInt("NULLABLE");
//
//				System.out.println("Column Name: " + columnName);
//				System.out.println("Data Type: " + dataType);
//				System.out.println("Column Size: " + columnSize);
//				System.out.println("Nullable: " + (nullable == DatabaseMetaData.columnNullable ? "YES" : "NO"));
//				System.out.println();
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	
//	@Test
//	public void testRowIDTable() {
//		try {
//			connection = DriverManager.getConnection(url, user, password);
//
//			System.out.println("Connected to PostgreSQL database successfully!");
//
//			String tableName = "t-RowID";
//
//			DatabaseMetaData databaseMetaData = connection.getMetaData();
//
//			// Get information about the table
//			ResultSet tableResultSet = databaseMetaData.getColumns(null, null, tableName, null);
//
//			// Iterate through the result set and print column details
//			while (tableResultSet.next()) {
//				String columnName = tableResultSet.getString("COLUMN_NAME");
//				String dataType = tableResultSet.getString("TYPE_NAME");
//				int columnSize = tableResultSet.getInt("COLUMN_SIZE");
//				int nullable = tableResultSet.getInt("NULLABLE");
//
//				System.out.println("Column Name: " + columnName);
//				System.out.println("Data Type: " + dataType);
//				System.out.println("Column Size: " + columnSize);
//				System.out.println("Nullable: " + (nullable == DatabaseMetaData.columnNullable ? "YES" : "NO"));
//				System.out.println();
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testItemTable() {
//		try {
//			connection = DriverManager.getConnection(url, user, password);
//
//			System.out.println("Connected to PostgreSQL database successfully!");
//
//			String tableName = "t-Item";
//
//			DatabaseMetaData databaseMetaData = connection.getMetaData();
//
//			// Get information about the table
//			ResultSet tableResultSet = databaseMetaData.getColumns(null, null, tableName, null);
//
//			// Iterate through the result set and print column details
//			while (tableResultSet.next()) {
//				String columnName = tableResultSet.getString("COLUMN_NAME");
//				String dataType = tableResultSet.getString("TYPE_NAME");
//				int columnSize = tableResultSet.getInt("COLUMN_SIZE");
//				int nullable = tableResultSet.getInt("NULLABLE");
//
//				System.out.println("Column Name: " + columnName);
//				System.out.println("Data Type: " + dataType);
//				System.out.println("Column Size: " + columnSize);
//				System.out.println("Nullable: " + (nullable == DatabaseMetaData.columnNullable ? "YES" : "NO"));
//				System.out.println();
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testUserTable() {
//		try {
//			connection = DriverManager.getConnection(url, user, password);
//
//			System.out.println("Connected to PostgreSQL database successfully!");
//
//			String tableName = "t-User";
//
//			DatabaseMetaData databaseMetaData = connection.getMetaData();
//
//			// Get information about the table
//			ResultSet tableResultSet = databaseMetaData.getColumns(null, null, tableName, null);
//
//			// Iterate through the result set and print column details
//			while (tableResultSet.next()) {
//				String columnName = tableResultSet.getString("COLUMN_NAME");
//				String dataType = tableResultSet.getString("TYPE_NAME");
//				int columnSize = tableResultSet.getInt("COLUMN_SIZE");
//				int nullable = tableResultSet.getInt("NULLABLE");
//
//				System.out.println("Column Name: " + columnName);
//				System.out.println("Data Type: " + dataType);
//				System.out.println("Column Size: " + columnSize);
//				System.out.println("Nullable: " + (nullable == DatabaseMetaData.columnNullable ? "YES" : "NO"));
//				System.out.println();
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}

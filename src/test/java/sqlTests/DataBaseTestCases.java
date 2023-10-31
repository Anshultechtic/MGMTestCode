package sqlTests;

import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.testng.annotations.Test;

import baseTest.SQLConnection;

public class DataBaseTestCases extends SQLConnection {

	@Test
	public void tesFormaTable() {

		try {
//			connection = DriverManager.getConnection(url, user, password);
//
//			System.out.println("Connected to PostgreSQL database successfully!");

			String tableName = "t-Format";

			DatabaseMetaData databaseMetaData = connection.getMetaData();

			// Get information about the table
			ResultSet tableResultSet = databaseMetaData.getColumns(null, null, tableName, null);

			// Iterate through the result set and print column details
			while (tableResultSet.next()) {
				String columnName = tableResultSet.getString("COLUMN_NAME");
				String dataType = tableResultSet.getString("TYPE_NAME");
				int columnSize = tableResultSet.getInt("COLUMN_SIZE");
				int nullable = tableResultSet.getInt("NULLABLE");

				System.out.println("Column Name: " + columnName);
				System.out.println("Data Type: " + dataType);
				System.out.println("Column Size: " + columnSize);
				System.out.println("Nullable: " + (nullable == DatabaseMetaData.columnNullable ? "YES" : "NO"));
				System.out.println();
			}
		} catch (SQLException e) {
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

		System.out.println(list.toString());

		System.out.println(dataTypeRowIDlist.toString());

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).equals("TG Name") && dataTypeRowIDlist.get(i).equals(20000216)) {

				System.out.println("Passed");
			}else if(list.get(i).equals("TG") && dataTypeRowIDlist.get(i).equals(20000247)) {
				
				System.out.println("Passed");
				
			}

		}

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

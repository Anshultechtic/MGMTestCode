package sqlTests;

import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

import baseTest.SQLConnection;

public class DataBaseTestCases extends SQLConnection {

	@Test
	public void test() {

		try {
			connection = DriverManager.getConnection(url, user, password);

			System.out.println("Connected to PostgreSQL database successfully!");

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
	
	public void test2() {
		System.out.println("Test 2");
	}
	public void test3() {
		System.out.println("Test 3");
	}
	public void test4() {
		System.out.println("Test 4");
	}
	
	

}

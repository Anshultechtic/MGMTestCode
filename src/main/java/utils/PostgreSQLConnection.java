package utils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostgreSQLConnection {
	public static void main(String[] args) {
		// Database connection parameters
		String url = "jdbc:postgresql://localhost:5432/AIC";
		String user = "postgres";
		String password = "Anshul@123";

		// Create a connection
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to PostgreSQL database successfully!");
			
			 String tableName = "t-Format";

			 DatabaseMetaData databaseMetaData = connection.getMetaData();
			 
	            // Get information about the table
	            ResultSet tableResultSet = databaseMetaData.getColumns(null, null, tableName , null);

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
			e.printStackTrace();
			System.err.println("Failed to connect to the database.");
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		

	}
}

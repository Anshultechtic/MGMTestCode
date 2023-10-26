package baseTest;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

/**
 * Hello world!
 *
 */
public class SQLConnection {

	public SQLConnection sql;
	public Connection connection = null;
	public String url = "jdbc:postgresql://localhost:5432/AIC";
	public String user = "postgres";
	public String password = "Anshul@123";

	public void launchSQLTests() {

		sql = new SQLConnection();


		System.err.println("Failed to connect to the database.");
	}



	@BeforeSuite
	public void sqlTest1() {
		System.out.println("hello");
		launchSQLTests();

	}

	@AfterSuite
	public void sqlTest2() {
		System.out.println("==>Connection Closed<==");
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

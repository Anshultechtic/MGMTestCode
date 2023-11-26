package baseTest;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
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
	public String temp;
	public int count;
	

	public void launchSQLTests() {

		sql = new SQLConnection();

		System.err.println("Failed to connect to the database.");
	}

	
	

	

	

}

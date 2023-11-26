package baseTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class BaseClass {

	public String temp = null;
	int count = 0;
	public String TCid;
	public static Logger logger;
	public WebDriver driver;
	public ArrayList<String> resultStatus = new ArrayList<>();
	public SQLConnection sql;
	public Connection connection = null;
	public String url = "jdbc:postgresql://localhost:5432/AIC";
	public String url2 = "jdbc:postgresql://localhost:5432/TestCaseDetails";
	public String user = "postgres";
	public String password = "Anshul@123";

	public void launchSQLTests() {

		sql = new SQLConnection();

		System.err.println("Failed to connect to the database.");
	}

	
	@BeforeSuite
	public void sqlTest1() {

		try {
			connection = DriverManager.getConnection(url2, user, password);
			System.out.println("Connected to PostgreSQL database successfully!");

		} catch (SQLException e) {
			e.printStackTrace();
		}


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
	@BeforeTest
	public void start() {
		logger = Logger.getLogger("MGM TestCases");
		PropertyConfigurator.configure("log4jFile.properties");
		logger.info("Test Initiated");

	}

	@AfterTest
	public void end() {

		logger.info("Test Finished");

	}

	public String getScreenshot(String testCase, WebDriver driver) {
		logger.info("Taking ScreenShot");
		String desPath = System.getProperty("user.dir") + "\\test-OutputFiles\\";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(desPath + testCase + ".png");
		try {
			FileHandler.copy(src, des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("Taking ScreenShot");
		return desPath + testCase + ".png";

	}

	public void ResultStatuses(ArrayList<String> temp) {

		int i = 0;

		for (String s : temp) {

			i++;
			System.out.println(i + " " + s);
		}

	}

}

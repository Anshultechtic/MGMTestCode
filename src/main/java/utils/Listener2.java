package utils;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.ITestListener;
import org.testng.ITestResult;

import baseTest.BaseClass;

public class Listener2 extends BaseClass implements ITestListener {

	@Override
	public void onTestSuccess(ITestResult result) {

		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = currentDateTime.format(formatter);
		System.out.println("Current Date and Time: " + formattedDateTime);

		try {
			Statement stat = connection.createStatement();
			ResultSet r = stat.executeQuery("insert into\r\n" + "\"Automation_Run_Report\"\r\n"
					+ "(\"Application_id\",\"Run_Type\",\"Testcaseid\",\"TestStatus\", \r\n"
					+ "\"Rundate\",\"StartDateTime\",\"EndDateTime\")\r\n"
					+ "values (125, '"+result.getMethod().getMethodName()+"', 456 ,'Pass', '2023-11-01','2023-11-01 15:15:15', '2023-11-01 15:15:15')");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestFailure(ITestResult result) {

		LocalDateTime currentDateTime = LocalDateTime.now();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = currentDateTime.format(formatter);

		try {
			connection = DriverManager.getConnection(url2, user, password);
			Statement stat = connection.createStatement();
			ResultSet r = stat.executeQuery("insert into\r\n" + "\"Automation_Run_Report\"\r\n"
					+ "(\"Application_id\",\"Run_Type\",\"Testcaseid\",\"TestStatus\", \r\n"
					+ "\"Rundate\",\"StartDateTime\",\"EndDateTime\")\r\n"
					+ "values (256, '"+result.getMethod().getMethodName()+"', 456 ,'Fail', '2023-11-01','2023-11-01 15:15:15', '2023-11-01 15:15:15')");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Current Date and Time: " + formattedDateTime);

	}

}

package utils;

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
	}

	@Override
	public void onTestFailure(ITestResult result) {

		LocalDateTime currentDateTime = LocalDateTime.now();

		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = currentDateTime.format(formatter);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Current Date and Time: " + formattedDateTime);

	}

}

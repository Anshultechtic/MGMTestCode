package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import baseTest.BaseClass;
import baseTest.SQLConnection;

public class ListenerSetUp extends BaseClass implements ITestListener {

	ExtentReports extent = ExtentReportCode.ExtentReport();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	

	@Override
	public void onTestStart(ITestResult result) {
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		this.temp = result.getMethod().getMethodName();

		resultStatus.add(this.temp + " is passed");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		this.temp = result.getMethod().getMethodName();
		resultStatus.add(this.temp + " is Skipped");

	}

	@Override
	public void onTestFailure(ITestResult result) {

		this.temp = result.getMethod().getMethodName();
		resultStatus.add(this.temp + " is failed");
		ResultStatuses(resultStatus);

	}

	@Override
	public void onStart(ITestContext context) {

		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {

		ResultStatuses(resultStatus);

	}

}

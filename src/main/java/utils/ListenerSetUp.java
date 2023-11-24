package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import baseTest.BaseClass;
import baseTest.SQLConnection;

public class ListenerSetUp extends SQLConnection implements ITestListener {

	BaseClass bc;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		this.temp = result.getMethod().getMethodName();

		resultStatus.add(this.temp +" is passed");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		this.temp = result.getMethod().getMethodName();
		resultStatus.add(this.temp);

	}

	@Override
	public void onTestFailure(ITestResult result) {

		this.temp = result.getMethod().getMethodName();
		resultStatus.add(this.temp +" is failed");
		Sample(resultStatus);

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		
		
		
		Sample(resultStatus);

	}

}

package com.saas.app.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.saas.app.reports.Log;

public class ITestListenerClass implements ITestListener {

	//onStart: This method invokes when the test class is instantiated and before executing any test method.
	public void onStart(ITestContext context) {
//		System.out.println("*************** Execution for " + context.getName() + " started ***************");
		Log.info("Execution started for --> " + context.getName());
	}

	//onFinish: This method invokes when all the test methods have run, and calling of all of their configuration methods happens.
	public void onFinish(ITestContext context) {
//		System.out.println("*************** Execution for " + context.getName() + " finished ***************");
		Log.info("Execution completed for --> " + context.getName());
	}

	//onTestStart:  This method invokes every time a test method is called and executed.
	public void onTestStart(ITestResult result) {
//		System.out.println("*************** Execution for test " + result.getName() + " started ***************");
		Log.info(result.getName() + " test started...");
	}

	//onTestSuccess: This method is invoked every time a test case passes (succeeds).
	public void onTestSuccess(ITestResult result) {
//		System.out.println("*************** Execution for test " + result.getName() + " is passed ***************");
		Log.info(result.getName() + " test passed...");
		
	}

	//onTestFailure: This method invokes every time a test case fails.
	public void onTestFailure(ITestResult result) {
//		System.out.println("*************** Execution for test " + result.getName() + " is failed ***************");
		Log.warn(result.getName() + " test failed...");
	}

	//onTestSkipped: This method invokes every time a test skips.
	public void onTestSkipped (ITestResult result) {
//		System.out.println("*************** Execution for test " + result.getName() + " is skipped ***************");
		Log.warn(result.getName() + " test skipped...");
	}

	//onTestFailedButWithinSuccessPercentage: This method invokes when the test method fails as a whole but has passed a certain success percentage, which is defined by the user.
	public void onTestFailedButSuccessPercentage (ITestResult result) {
//		System.out.println("*************** Execution for test " + result.getName() + " is passed as per defined percentage ***************");
		Log.info(result.getName() + " test passed as per defined percentage...");
	}

}
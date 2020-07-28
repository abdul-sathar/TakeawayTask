package com.takeaway.utilities;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TestListeners implements ITestListener {

	protected final Logger logger = LogManager.getLogger(getClass());
	private static ExtentReports extent = ExtentManager.createExtentInstance();
	public static ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
		
		ExtentTest test = extent.createTest(result.getMethod().getDescription());
		extentTest.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String logtext ="Test Method "+ result.getName();
		extentTest.get().log(Status.PASS, MarkupHelper.createLabel(logtext + " PASSED ", ExtentColor.GREEN));
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String exceptionMessage =Arrays.toString(result.getThrowable().getStackTrace());
		
		extentTest.get().fail("<details><summary><b><font color=red>" + "Exception Occured, click here to see details:"+
								"</font></b></summary>" + exceptionMessage.replaceAll(",", "<br>") +
								"</details> \n");
		
		extentTest.get().log(Status.FAIL, MarkupHelper.createLabel("<b>Test Method "+result.getName() + " FAILED</b>",
							ExtentColor.RED));
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		String exceptionMessage =Arrays.toString(result.getThrowable().getStackTrace());
		String logtext ="<b> Test Method "+ result.getName();
		
		extentTest.get().skip("<details><summary><b><font color=yellow>" + "Exception Occured, click here to see details:"+
								"</font></b></summary>" + exceptionMessage.replaceAll(",", "<br>") +
								"</details> \n");
		
		extentTest.get().log(Status.PASS, MarkupHelper.createLabel(logtext + " SKIPPED </b>", ExtentColor.YELLOW));
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		logger.info("========== Test Suite Started ==========");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		logger.info("========== Test Suite Ended ==========");
		extent.flush();
		
	}

}

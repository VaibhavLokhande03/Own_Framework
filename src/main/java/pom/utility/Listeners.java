package pom.utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends Base_Class implements ITestListener {

	ExtentReports extent=Extend_Report_Generator.getreports();
	ThreadLocal<ExtentTest> extenttest=new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
    Library.tast=extent.createTest(result.getClass().getName()+"=="+result.getMethod().getMethodName());
    extenttest.set(Library.tast);	
	} 

	public void onTestSuccess(ITestResult result) {
		extenttest.get().log(Status.PASS, "Test Case Pass");
		Library.tast.addScreenCaptureFromBase64String(getScreenShot());
	}

	public void onTestFailure(ITestResult result) {
		extenttest.get().log(Status.FAIL, "Test Case Fail");		
	}

	public void onTestSkipped(ITestResult result) {
		extenttest.get().log(Status.SKIP, "Test Case Skip");
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
	public static String getScreenShot() {
			TakesScreenshot ts=(TakesScreenshot) driver;
			return ts.getScreenshotAs(OutputType.BASE64);
	}

}

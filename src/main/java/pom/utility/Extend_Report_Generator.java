package pom.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extend_Report_Generator {

	public static ExtentReports Reporter;
	public static ExtentReports getreports() {
		
		String Reportpath="C:\\Users\\HP\\eclipse-workspace\\Own_Framework\\Reports\\index.html";
		ExtentSparkReporter Reporter=new ExtentSparkReporter(Reportpath);
		Reporter.config().setDocumentTitle("Own_Report");
		Reporter.config().setReportName("Automation_Test_Reports");
		Reporter.config().setTheme(Theme.DARK);
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(Reporter);
		extent.setSystemInfo("Project Name", "WebBrowser");
		extent.setSystemInfo("QA", "Vaibhav");
		return extent;
	}
}

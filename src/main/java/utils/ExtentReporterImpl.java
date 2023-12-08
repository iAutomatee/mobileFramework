package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterImpl {

    static ExtentReports extentReports;
    static ExtentSparkReporter reporter;

    public static ExtentReports getReportObject() {
        extentReports = new ExtentReports();
        String path = System.getProperty("user.dir") + "/target/reports/index.html";
        reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("API Demo Automation Results");
        reporter.config().setDocumentTitle("Test Automation Results");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("QA Name", "iAutomate");
        return extentReports;
    }


}

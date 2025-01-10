package org.selenium;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentManager {
    private static ExtentReports extent;

    public synchronized static ExtentReports getInstance() {
        if (extent == null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
            String timestamp = LocalDateTime.now().format(formatter);
            String reportName = String.format("target/TestReport_%s.html", timestamp);
            ExtentSparkReporter spark = new ExtentSparkReporter(reportName);
            extent = new ExtentReports();
            extent.attachReporter(spark);
            spark.config().setDocumentTitle("Automation Report");
            spark.config().setReportName("Test Report");
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        }
        return extent;
    }
}

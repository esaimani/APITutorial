package org.runner;

import java.io.IOException;

import org.basemethods.BaseMethods;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;



@CucumberOptions(features = "src/test/resources/Features", glue = "org/steps", monochrome = true, dryRun = false, tags="@Frame",snippets = SnippetType.CAMELCASE, plugin = {
		"pretty", "html:target/Destination", "json:target/Destination/cucumber.json"},
strict = true)
public class Runnercukes extends AbstractTestNGCucumberTests {

	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;

	@BeforeSuite
	public void StartReport() {
		htmlReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/target/ExtentReports");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
	}
	@BeforeClass
	public void startTest()
	{
		extent.setSystemInfo("Environment", "Automation Testing");
		extent.setSystemInfo("User Name", "Esaimani Navamani");

		htmlReporter.config().setDocumentTitle("Selenium Framework Extent Report");
		htmlReporter.config().setReportName("Selenium Framework Extent Report");
		htmlReporter.config().setTheme(Theme.STANDARD);

		logger = extent.createTest("Functional Testing");
	}

	@AfterMethod
	public void getResult(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.SUCCESS) {

			logger.log(Status.PASS,
					MarkupHelper.createLabel(result.getName()+ " Passed", ExtentColor.GREEN));
		}

		else if (result.getStatus() == ITestResult.FAILURE) {

			logger.fail("Test Case Failed : " + result.getThrowable(), BaseMethods.attachScreenshot());
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
		} else if (result.getStatus() == ITestResult.SKIP) {

			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		}
	}
	
	

	@AfterSuite
	public void endReport() {
		extent.flush();
	}

	
}

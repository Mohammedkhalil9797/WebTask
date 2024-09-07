package com.qacart.todo.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.javafaker.Faker;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.utils.Screenshots;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;


public class BaseTest implements ITestListener {
    protected static WebDriver driver;
    public static ExtentSparkReporter sparkReporter;
    public static  ExtentReports extent;
    public static ExtentTest logger;
    public static Faker faker = new Faker();

    @BeforeMethod
    public void setup(Method method) throws MalformedURLException {

        logger = extent.createTest(method.getName());
        driver = new DriverFactory().initializeDriver();
    }

    @BeforeTest
    public void setupTest() {
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "reportFolder" + File.separator + "MohammedTask.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        sparkReporter.config().setTheme(Theme.DARK);
        extent.setSystemInfo("HostName", "RHEL8");
        extent.setSystemInfo("UserName", "root");
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Automation Tests Results by SDET ADDA");
    }

    @AfterMethod
    public void afterMethod(ITestResult result, Method method) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
            logger.fail(Screenshots.screenShots());
        } else if (result.getStatus() == ITestResult.SKIP) {

            logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASS", ExtentColor.GREEN));

        }
       driver.quit();
    }

    @AfterTest
    public void afterTesT() {
        extent.flush();


    }

@AfterClass
    public void afterClass() {
       driver.quit();
}
}

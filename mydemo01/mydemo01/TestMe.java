package mydemo01.mydemo01;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestMe {
	WebDriver driver;

	ExtentTest test;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
  @Test (priority=1)
  public void TC1() {
	  test=extent.createTest("Test Case 1", "Application Accessiability");
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver_win32\\chromedriver.exe");
	    driver= new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp");
		driver.manage().window().maximize();
		Assert.assertEquals(driver.getTitle(), "Baishali");
  }
  
  @Test (priority=1)
  public void TC2() {
	  test=extent.createTest("Test Case 1", "Application Accessiability");
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver_win32\\chromedriver.exe");
	    driver= new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp");
		driver.manage().window().maximize();
		Assert.assertEquals("11", "11");
  }
  @AfterMethod
  public void getResult(ITestResult result) throws IOException {
	  if(result.getStatus()==ITestResult.FAILURE)
	  {
		  test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"FAILED", ExtentColor.RED));
	  TakesScreenshot snapshot=(TakesScreenshot)driver;
	  File src=snapshot.getScreenshotAs(OutputType.FILE);
	  String Path= System.getProperty("user.dir")+"/test-output/screens/"+result.getName()+".png";
	  FileUtils.copyFile(src, new File(Path));
	  test.addScreenCaptureFromPath(Path, result.getName());
	  test.fail(result.getThrowable());
  }
    else if(result.getStatus()== ITestResult.SUCCESS)
  {
    test.log(Status.PASS,  MarkupHelper.createLabel(result.getName()+"PASSED", ExtentColor.GREEN));
  }
      else
  
    	 
 test.log(Status.PASS,  MarkupHelper.createLabel(result.getName()+"SKIP", ExtentColor.ORANGE));
 test.skip(result.getThrowable());
  }
  


  @BeforeTest
	  public void startReport() {
		  htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/testReport.html");
		  extent = new ExtentReports();
		  extent.attachReporter(htmlReporter);
//		  extent.setSystemInfo("OS", OS);
//		  extent.setSystemInfo("Browser", browser);
//		  htmlReporter.config().setChartVisibilityOnOpen(true);
		  htmlReporter.config().setDocumentTitle("Extent Report Demo");
		  htmlReporter.config().setReportName("Test Report");
//		  htmlReporter.config().setTestVIewChartLocation(ChartLocation.TOP);
		  htmlReporter.config().setTheme(Theme.STANDARD);
		  htmlReporter.config().setTimeStampFormat("EEEE,MMMM dd, yyyy, hh:mm a '('zzz')' ");
  }

  @AfterTest
  
  public void end()
  {
	  extent.flush();
	  }
  }
	 


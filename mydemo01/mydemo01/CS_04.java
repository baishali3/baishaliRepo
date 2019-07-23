package mydemo01.mydemo01;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class CS_04 {
	WebDriver driver;
	 ExtentHtmlReporter htmlReporter;
	 ExtentReports extent;
	 ExtentTest test;
	 
	 @BeforeTest
	 public void startReport()
	 {
	 htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/testReport.html");
	 extent = new ExtentReports();
	 extent.attachReporter(htmlReporter);
	 // extent.setSystemInfo("OS", OS);
	 // extent.setSystemInfo("Browser", browser);
	 // htmlReporter.config().setChartVisibilityOnOpen(true);
	 htmlReporter.config().setDocumentTitle("Extent Report Demo");
	 htmlReporter.config().setReportName("Test Report");
	 // htmlReporter.config().setTestVIewChartLocation(ChartLocation.TOP);
	 htmlReporter.config().setTheme(Theme.STANDARD);
	 htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')' ");
	 }
	 
	 
	 
	 
	 
  @Test (priority=2)
  public void testLogin() {

	  test = extent.createTest("Test Case 1","Login Accessibility");
	   WebElement user = driver.findElement(By.xpath("//input[@id='userName']"));
	 user.sendKeys("lalitha");
	 WebElement pass = driver.findElement(By.xpath("//input[@id='password']"));
	 pass.sendKeys("Password123");
	 driver.findElement(By.xpath("//input[@value='Login']")).click();
	 String E_Title="Home";
	 String A_Title=driver.getTitle();
	 Assert.assertEquals(A_Title, E_Title);  
	  }

  @BeforeClass
 public void open()
 {
 System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
 driver = new ChromeDriver();
 driver.get("http://10.232.237.143:443/TestMeApp");
 driver.manage().window().maximize();
 }
  @BeforeMethod
  public void SignIn() throws InterruptedException 
  {
  System.out.println("Code for SignIn");
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.findElement(By.xpath("//a[contains(text(),'SignIn')]")).click();
  }
	
  
  
  
  @AfterMethod
  public void getResult(ITestResult result) throws IOException, InterruptedException
  {
 
 if(result.getStatus() == ITestResult.FAILURE) {
 test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"FAILED", ExtentColor.RED));
 TakesScreenshot snapshot = (TakesScreenshot)driver;
 File src = snapshot.getScreenshotAs(OutputType.FILE);
 String Path = System.getProperty("user.dir")+"/test-output/screens/result.getName()"+".png";
 FileUtils.copyFile(src,new File(Path));
 test.addScreenCaptureFromPath(Path, result.getName());
 test.fail(result.getThrowable());
 driver.get("http://10.232.237.143:443/TestMeApp");
 }
 else if(result.getStatus()==ITestResult.SUCCESS)
 {
 test.log(Status.PASS,  MarkupHelper.createLabel(result.getName()+"PASSED", ExtentColor.GREEN));
 }
 else
 {
 test.log(Status.SKIP,  MarkupHelper.createLabel(result.getName()+"SKIPPED", ExtentColor.ORANGE));
 }
 System.out.println("Code for LogOut");
 Thread.sleep(5000);
  }

  @AfterTest
  public void tearDown() {
 extent.flush();
  }
	  
  }


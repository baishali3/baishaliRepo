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
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testmeapp.utility.Drivers;

public class OnlineShoppingTest extends Drivers {
	
	ExtentHtmlReporter htmlReporter;
	 ExtentReports extent;
	 ExtentTest test;
	 WebDriver driver=Drivers.getDriver("chrome");
	 
	 @Test (priority=1, enabled=false)
	
     public void testRegistration() throws InterruptedException {
	 WebElement signup= driver.findElement(By.xpath("//a[contains(text(), 'SignUp')]"));
	 signup.click();
	 test = extent.createTest("Test Case 01","Registration");
	 driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("bbnmjkliop");
	 driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("bnm");
	 Thread.sleep(5000);
	 String A_value= driver.findElement(By.xpath("//span[@id='err']")).getText();
	 System.out.println(A_value);
	 String E_value= "Available";
	 Assert.assertEquals(A_value,E_value);
	 
	 driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("jkl");
	 driver.findElement(By.xpath("//input[@name='password']")).sendKeys("bnmjkliop890");
	 driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("bnmjkliop890");
	 driver.findElement(By.xpath("//span[text()='Female']")).click();
	 driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("bnmjkliop@ajkj.com");
	 driver.findElement(By.xpath("//input[@name='mobileNumber']")).sendKeys("8837349480");
	 driver.findElement(By.xpath("//input[@name='dob']")).sendKeys("03/10/1996");
	 driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys("Ramnagar");
	 driver.findElement(By.xpath("//select[@name='securityQuestion']")).sendKeys("What is your favourite color?");
	 driver.findElement(By.xpath("//input[@name='answer']")).sendKeys("black");
	 driver.findElement(By.xpath("//input[@name='Submit']")).click();
	 String E_Title="Login";
	 String A_Title=driver.getTitle();
	 Assert.assertEquals(A_Title, E_Title);
	 }
	 
	 @Test (priority=2)
	  public void testLogin() {
		 test = extent.createTest("Test Case 02","Login Accessibility");
		 driver.findElement(By.xpath("//a[contains(text(), 'SignIn')]")).click();

		  
		   WebElement user = driver.findElement(By.xpath("//input[@id='userName']"));
		 user.sendKeys("bnmjkliop");
		 WebElement pass = driver.findElement(By.xpath("//input[@id='password']"));
		 pass.sendKeys("bnmjkliop890");
		 driver.findElement(By.xpath("//input[@value='Login']")).click();
		 String E_Title="Home";
		 String A_Title=driver.getTitle();
		 Assert.assertEquals(A_Title, E_Title);  
		  }
	 
	 @Test (priority=3)
	  public void testCart() throws InterruptedException {
		 test = extent.createTest("Test Case 03","Cart");
		 
		 driver.findElement(By.xpath("//input[@name='products']")).sendKeys("headphone");
		 driver.findElement(By.xpath("//input[@value='FIND DETAILS']")).click();
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//a[contains(text(),' Add to cart')]")).click();
		 driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
		 String E_Title="Checkout";
		 String A_Title=driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).getText();
		 System.out.println(A_Title);
		 Assert.assertEquals(A_Title, E_Title);
	  }
	 
	 
	 @Test(priority=4)
	  public void testPayment() throws InterruptedException {
	 test = extent.createTest("Test Case 04","Payment Accessibility");
	 driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();
	 driver.findElement(By.xpath("//input[@value='Proceed to Pay']")).click();
	 Thread.sleep(5000);
	 driver.findElement(By.xpath("//*[@id='swit']/div[1]/div/label/i")).click();
	 driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
	 driver.findElement(By.xpath("//input[@name='username']")).sendKeys("123456");
	 driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Pass@456");
	 driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
	 driver.findElement(By.xpath("//input[@value='PASSWORD']")).sendKeys("Trans@456");
	 driver.findElement(By.xpath("//input[@value='PayNow']")).click();
	 String E_Title="Order Details";
	 String A_Title=driver.getTitle();
	 Assert.assertEquals(A_Title, E_Title);
	  }
	 
	 
	 @BeforeTest
	 public void startReport()
	 {
	 htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/testReport.html");
	 extent = new ExtentReports();
	 extent.attachReporter(htmlReporter);
	 htmlReporter.config().setDocumentTitle("Extent Report Demo");
	 htmlReporter.config().setReportName("Test Report");
	 htmlReporter.config().setTheme(Theme.STANDARD);
	 htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')' ");
	 }
	 

	  @BeforeClass
	 public void open()
	 {
	 driver.get("http://10.232.237.143:443/TestMeApp");
	 driver.manage().window().maximize();
	 }
	  
	  
//	  @BeforeMethod
//	  public void SignIn() throws InterruptedException 
//	  {
//	  System.out.println("Code for SignIn");
//	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////	  driver.findElement(By.xpath("//a[contains(text(),'SignIn')]")).click();
//	  }
	  
	  

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

package mydemo01.mydemo01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class CS_03 {
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
	 
	 
	 



	 @Test (priority=1)
	   public void registration() throws InterruptedException {
	 System.setProperty("webdriver.chrome.driver", "C:\\\\Drivers\\\\chromedriver_win32\\\\chromedriver.exe");
	    driver= new ChromeDriver();
	 driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	 driver.manage().window().maximize();
	 WebElement signup= driver.findElement(By.xpath("//a[contains(text(), 'SignUp')]"));
	 signup.click();


	 driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("bnmjkliop");
	 driver.findElement(By.xpath("//input[@name='firstName']")).click();
	 Thread.sleep(10000);
	 String A_value= driver.findElement(By.xpath("//span[@id='err']")).getText();
	 System.out.println(A_value);
	 String E_value= "Available";
	 Assert.assertEquals(E_value, A_value);
	 driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("bnm");
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
	   }
	 }
	 
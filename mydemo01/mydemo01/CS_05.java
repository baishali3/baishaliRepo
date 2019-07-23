package mydemo01.mydemo01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CS_05 {
	WebDriver driver;
  @Test (priority=3)
  public void testCart() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "C:\\\\Drivers\\\\chromedriver_win32\\\\chromedriver.exe");
	    driver= new ChromeDriver();
	 driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	 driver.manage().window().maximize();
	 driver.findElement(By.xpath("//input[@name='products']")).sendKeys("Headphone");
	 driver.findElement(By.xpath("//input[@value= 'FIND DETAILS']")).click();
	 Thread.sleep(5000);
	 driver.findElement(By.xpath("//a[contains(text(),' Add to cart')]")).click();
	 driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
  }
}

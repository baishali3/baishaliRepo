package mydemo01.mydemo01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Utility123 {


 public static WebDriver getDriver(String browser) {
 if(browser.equals("chrome"))
 {
 System.setProperty("webdriver.chrome.driver", "C:\\NexGen Testing Stream\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
 return new ChromeDriver();
 }
 else if(browser.equals("ie"))
 {  System.setProperty("webdriver.ie.driver", "C:\\NexGen Testing Stream\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
 return new InternetExplorerDriver();
 }
 else if(browser.equals("ff"))
 {  System.setProperty("webdriver. gecko.driver", "C:\\NexGen Testing Stream\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
 return new FirefoxDriver();
 }
 else
 {
 return null;
 }
 } }
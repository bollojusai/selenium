package RahulshettyWebsiteMain;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import RahulshettyWebsite.Login_page;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
public  WebDriver driver;	
public Login_page LoginWebSiste;
	public  WebDriver InitilizerDriver()throws IOException{
		Properties pro= new Properties();
		FileInputStream f= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Rahulshetty\\resources\\GlobalData.Properties");
		pro.load(f);
	  String BrowserName=	pro.getProperty("browser");
	  if(BrowserName.equalsIgnoreCase("chrome")) {
	        ChromeOptions options = new ChromeOptions();
	        options.addExtensions(new File("H:\\chromedrive\\extension_4_7_2_0.crx"));
	         driver = new ChromeDriver(options);
	  }
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   driver.manage().window().maximize();
	return driver;
	}
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		File file= new File(System.getProperty("user.dir")+ "//reports//" + testCaseName +".png");
	    FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+ "//reports//" + testCaseName +".png";
		
	}


}
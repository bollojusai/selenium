package RahulshettyWebsiteMain;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import RahulshettyWebsite.Login_page;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
public class BaseShoppingTest{
public  WebDriver driver;	
public Login_page LoginWebSiste;
	public  WebDriver InitilizerDriver()throws IOException{
		Properties pro= new Properties();
		FileInputStream f= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Rahulshetty\\resources\\GlobalData.Properties");
		pro.load(f);
	  String BrowserName=	System.getProperty("browser")!=null ? System.getProperty("browser") : pro.getProperty("browser");
		// String BrowserName=	pro.getProperty("browser");
	  if(BrowserName.contains("chrome")) {
	        ChromeOptions options = new ChromeOptions();
	        options.addExtensions(new File("H:\\chromedrive\\extension_4_7_2_0.crx"));
	        if(BrowserName.contains("headless")) {
	          options.addArguments("headless");
	        }
	         driver = new ChromeDriver(options);
	         driver.manage().window().setSize(new Dimension(1400,900));
	  }
	 else if(BrowserName.equalsIgnoreCase("Edge")){
	  System.setProperty("WebDriver.edge.driver","edge.exe");
		 	driver = new EdgeDriver();	
	  }
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   driver.manage().window().maximize();
	return driver;
	}
	@BeforeMethod(alwaysRun=true)
	public Login_page lanchApplication() throws IOException {
		 driver=InitilizerDriver();
		  LoginWebSiste = new Login_page(driver);
		 LoginWebSiste.Login_URL(driver);
             return LoginWebSiste;
	}
	
	
	public List<HashMap<String, String>> getJsonDataToMap(String filedir) throws IOException {
		String jsonContent = 	FileUtils.readFileToString(new File(filedir),StandardCharsets.UTF_8);
	   ObjectMapper mapper= new ObjectMapper();
	   List<HashMap<String,String>>data=mapper.readValue(jsonContent,new TypeReference<List<HashMap<String,String>>>(){});
		   return data;
	   }
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		File file= new File(System.getProperty("user.dir")+ "//reportss//" + testCaseName +".png");
		
		FileUtils.copyDirectory(source, file);
		return (System.getProperty("user.dir")+ "//reportss//" + testCaseName +".png");
		
	}
	@AfterMethod(alwaysRun=true)
	public void close() {
		driver.close();
	}
	}




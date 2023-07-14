package flightticket;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import RahulshettyWebsite.Login_page;
import RahulshettyWebsite.parent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
public class BaseTestcode extends parent{
	public WebDriver driver;
	public BaseTestcode(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public Login_page LoginWebSiste;

	public WebDriver InitilizerDriver() throws IOException {
		Properties pro = new Properties();
		FileInputStream f = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\Rahulshetty\\resources\\GlobalData.Properties");
		pro.load(f);
		String BrowserName = pro.getProperty("browser");
		if (BrowserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addExtensions(new File("H:\\chromedrive\\extension_4_7_2_0.crx"));
			driver = new ChromeDriver(options);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}

}
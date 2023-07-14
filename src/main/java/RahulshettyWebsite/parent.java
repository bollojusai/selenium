package RahulshettyWebsite;



import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class parent {
	
WebDriver driver;

	public parent(WebDriver driver) {
	   this.driver=driver;
}

	public void WaitVisibility(By findBy) {
		 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
		    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));
	}
	public void invisibility(WebElement ele) throws InterruptedException {
	      //Thread.sleep(1000);
	      WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
		  wait.until(ExpectedConditions.invisibilityOf(ele));
	}
 	public  String TakeScreenshot(String testCaseName) throws IOException {
         TakesScreenshot ts=  (TakesScreenshot)driver;
         File source=ts.getScreenshotAs(OutputType.FILE);
         File file= new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
         FileUtils.copyFile(source, file);
         return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
		
	}
}

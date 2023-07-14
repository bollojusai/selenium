package RahulshettyWebsiteMain;

import java.time.Duration;

import org.openqa.selenium.By;
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
		 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));
	}
	public void invisibility(WebElement ele) throws InterruptedException {
	      
	      WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		  wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
}

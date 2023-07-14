package RahulshettyWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import RahulshettyWebsite.*;

public class OrderSubmitPage extends parent {
	
	WebDriver driver;

			public  OrderSubmitPage(WebDriver driver) {
				super(driver);
				this.driver=driver;
				PageFactory.initElements(driver, this);
				
			}
			@FindBy(css="input[placeholder='Select Country']")
				WebElement EnterCountry;
			@FindBy(css=".ta-item.list-group-item.ng-star-inserted:last-child")
			    WebElement selectoptions;
		    By countyname=By.cssSelector("section[class='ta-results list-group ng-star-inserted']");
		    @FindBy(css=".action__submit")
		    WebElement element;
	     public void selectCountry(String country) {
	    	 Actions a = new Actions(driver);
	 		a.sendKeys(EnterCountry, country).build().perform();
	 		WaitVisibility(By.cssSelector(".ta-results"));
	    	    selectoptions.click();

			}

	     public ConfirmationPage submitOrder()
	 	{
	    	 JavascriptExecutor executor=(JavascriptExecutor)driver;
	    		executor.executeScript("arguments[0].click();", element);
	    		
	 		return new ConfirmationPage(driver);
	 		
	     }
	     
		
	}





	
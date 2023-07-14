package RahulshettyWebsite;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import RahulshettyWebsite.*;

public class ConfirmationPage extends parent {

	
	
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	@FindBy(css = ".hero-primary")
	WebElement confirmationMessage;
	public String getConfirmationMessage()
	{
	ConfirmationPage confirmationPage = new ConfirmationPage(driver);
	confirmationPage.getConfirmationMessage();
   Assert.assertTrue(getConfirmationMessage().equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		return confirmationMessage.getText();
	}
	
}

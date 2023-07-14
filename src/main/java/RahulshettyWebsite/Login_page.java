package RahulshettyWebsite;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class Login_page extends parent {

	WebDriver driver;
	
	
	public  Login_page(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id="userEmail")
		WebElement userEmail;
		@FindBy(id="userPassword")
		WebElement userPassword;
		@FindBy(id="login")
		WebElement login;
		@FindBy(css="[class*='flyInOut']")
		WebElement errorMessage;
		By errrorMessage =By.cssSelector("[class*='flyInOut']");
		public void Login_URL(WebDriver driver) {
			driver.get("https://rahulshettyacademy.com/client");
		}
		
		public Home_Page Login_Credentils(String Email,String Password) {
			userEmail.sendKeys(Email);
			userPassword.sendKeys(Password);
			login.click();
			Home_Page home = new Home_Page(driver);
			return home;
			
		}

		public String getErrorMessage() {
			WaitVisibility(errrorMessage);
			return errorMessage.getText();
			 
		}
	

		

		
	
	
	
	

}

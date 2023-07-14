package RahulshettyWebsite;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Home_Page extends parent {
	WebDriver driver;

	public Home_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}

	@FindBy(css = ".col-lg-4")
	List<WebElement> item;
	@FindBy(css=".ng-animating")
	WebElement invisibil;
	By poducts = By.cssSelector(".col-lg-4");
	By toster=By.cssSelector(".toast-container");
	

	public List<WebElement> products() {
		WaitVisibility(poducts);
		return item;
	}
	public WebElement Products(String ProductName) {
	    WebElement product= products().stream().filter(s->s.findElement(By.cssSelector("b")).getText().contains(ProductName)).findFirst().orElse(null);
	     return product;
	}
	public Cart_Page ProductAddToCart(String ProductName) throws InterruptedException {
	WebElement pro=	Products(ProductName);
	pro.findElement(By.cssSelector("button[class='btn w-10 rounded']")).click();
	WaitVisibility(toster);
	invisibility(invisibil);
	Cart_Page cart = new Cart_Page(driver);
	return cart;
}
	
}

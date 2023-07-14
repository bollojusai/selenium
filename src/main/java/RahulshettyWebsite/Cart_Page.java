package RahulshettyWebsite;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Cart_Page extends parent{
	WebDriver driver;
	public  Cart_Page(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="[routerlink*='cart']")
	WebElement cart;
	@FindBy(css=".cartSection h3")
   private List<WebElement>cartitmes;
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	public void cart() {
		 cart.click();
	}
	public Boolean carproducts(String PoductName) {
		 
	 Boolean match= cartitmes.stream().anyMatch(s->s.getText().equalsIgnoreCase(PoductName));
	return match;
	 
}
	public OrderSubmitPage checkout() {
		checkout.click();
		OrderSubmitPage checkout = new OrderSubmitPage(driver);
		return checkout;
	}
	
}
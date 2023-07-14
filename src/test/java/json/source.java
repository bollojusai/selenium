package json;



import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import RahulshettyWebsite.*;
import RahulshettyWebsiteMain.BaseShoppingTest;



public class source extends BaseShoppingTest{
	String ProductName = "IPHONE 13 PRO";
       @Test(dataProvider="getData",groups= {"Purchase"})
	
		public void test(HashMap<String,String>input) throws IOException, InterruptedException {
		
		Home_Page home =LoginWebSiste.Login_Credentils(input.get("Email"),input.get("Password"));
		
		home.Products(input.get("ProductName"));
		Cart_Page cart = home.ProductAddToCart(input.get("ProductName"));
		
		cart.cart();

		Boolean match = cart.carproducts(input.get("ProductName"));
		Assert.assertTrue(match);
		OrderSubmitPage or= cart.checkout();
		String country = "India";
		or.selectCountry(country);
		or.submitOrder();
	    
	}
@DataProvider




public Object[][] getData() throws IOException {
	/*HashMap<String, String>map= new HashMap<String, String>();
	//map.put("Email", "saibolloju@gamil.com");
	/map.put("Password", "Likithsai9");
	map.put("ProductName", "IPHONE 13 PRO");
	
	HashMap<String, String>map1= new HashMap<String, String>();
	map1.put("Email", "sandhyarani@gmail.com");
	map1.put("Password", "Sandhya&sai1");
	map1.put("ProductName", "ZARA COAT 3");
	*/
List<HashMap<String, String>>data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//json//data.json");
	return  new Object [] [] { {data.get(0)},{data.get(1)}};
}
	
}

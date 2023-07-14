package RahulshettyWebsiteMain;

import org.testng.Assert;

import org.testng.annotations.Test;

//import org.testng.annotations.Listeners;


public class ErrorValidationTest extends BaseShoppingTest  {

  @Test
  public void LoginErrorValidatonTest() {
	  LoginWebSiste.Login_Credentils("saibolloju@gmail.com", "Likithsai9");
	      Assert.assertEquals("Incorrectd email or password.",LoginWebSiste.getErrorMessage());      
  }
  
}

package flightticket;

	import org.testng.annotations.Test;
	import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
	import java.io.IOException;
import FlightTicket.websiteEnter;
import RahulshettyWebsiteMain.BaseTest;
	public class maincode extends BaseTest{
    

	@Test
	public void flight() throws InterruptedException, IOException {
		WebDriver driver= InitilizerDriver();
		websiteEnter enter= new websiteEnter(driver);
		enter.url(driver);
		String OptionToSelelct="Surat";
		enter.firstcity(OptionToSelelct);
		//tocity
		String tocity="Delhi";
		enter.tocity(tocity);
	     //month
	     String month="November 2023";
	     enter.month(month);
	
	     //date
	     String selectday="30";
	    enter.day(selectday);
	  
		 //Fare Type
	    int numbers=5;
		  enter.fairtype(numbers);	
		  //sumbit
		  enter.submit();
		
           driver.quit();
	}

}

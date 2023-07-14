package FlightTicket;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import RahulshettyWebsite.parent;


public class websiteEnter extends parent {
	WebDriver driver;

	public websiteEnter(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[@role='presentation']")
	WebElement firstcancle;
	By fcancle = By.xpath("//span[@role='presentation']");
	@FindBy(xpath = "//p[@class='sc-jlwm9r-1 dRQhOp']")
	WebElement secondcancled;
	By secondcancle = By.xpath("//p[@class='sc-jlwm9r-1 dRQhOp']");
	@FindBy(xpath = "//div[@class='sc-12foipm-34 dVpEne']")
	WebElement city;
	@FindBy(xpath = "//input[@type='text']")
	WebElement cityname;
	By optionslist = By.cssSelector("ul[class='sc-12foipm-39 dMRdWf'] li");
	@FindBy(css = ("ul[class='sc-12foipm-39 dMRdWf'] li"))
	List<WebElement> options;

	@FindBy(xpath = "//input[@type='text']")
	WebElement tocityname;
	By tooptionslist = By.xpath("//ul[@class='sc-12foipm-39 dMRdWf']//li");
	@FindBy(xpath = "//ul[@class='sc-12foipm-39 dMRdWf']//li")
	List<WebElement> tocityoptions;

	@FindBy(css = "[class='DayPicker-Months'] [class='DayPicker-Caption']")
	WebElement month;
	@FindBy(css = "[class='DayPicker-NavBar'] [class='DayPicker-NavButton DayPicker-NavButton--next']")
	WebElement monthclick;
	// dte

	@FindBy(css = "div[class='DayPicker-Month']:nth-child(1) [class='DayPicker-Day']")
	List<WebElement> datecount;
	By daywait = By.cssSelector("div[class='DayPicker-Month']:nth-child(1) [class='DayPicker-Day']");
	@FindBy(css = "span[class='fswTrvl__done']")
	WebElement dateselect;
	By wait = By.cssSelector("span[class='fswTrvl__done']");
	// fairtype
	@FindBy(css = ".sc-12foipm-0.bnZOnB:nth-child(4)")
	WebElement fair;
	// numbers
	@FindBy(xpath = "(//span[@class='sc-12foipm-63 ePVCFi'])[2]")
	WebElement selectnumbers;
	@FindBy(css = "a[class='sc-12foipm-76 fvsOuM']")
	WebElement done;
	// sumit
	By sumitwait = By.cssSelector("div[class='sc-12foipm-90 gUQNRY'] [class='sc-12foipm-91 bwfKFn']");
	By datechoose = By.cssSelector("div[class='DayPicker-Month']:nth-child(1) [class='DayPicker-Day']");
	@FindBy(css = "div[class='sc-12foipm-90 gUQNRY'] [class='sc-12foipm-91 bwfKFn']")
	WebElement submit;

	public void url(WebDriver driver) {
		driver.get(
				"https://www.goibibo.com/?utm_source=google&utm_medium=cpc&utm_campaign=DF-Generic-EM&utm_content=Tickets-Exact&utm_term=%21SEM%21DF%21G%21Generic%21RSA%2112554947352%21121063961722%21654769882497%21e%21flight+ticket+booking%21c%21&gad=1&gclid=Cj0KCQjwyLGjBhDKARIsAFRNgW_xAlXtmPikOGOpusJvCG_VdwGRn_GLCAOPrBqWrIQGrG6zrYREKy8aAu5gEALw_wcB");
		WaitVisibility(fcancle);
		firstcancle.click();
		WaitVisibility(secondcancle);
		secondcancled.click();
	}

	// find first city
	public void firstcity(String name) {
		city.click();
		cityname.sendKeys(name);
		WaitVisibility(optionslist);
		for (WebElement option : options) {
			options.stream().map(s -> s.getText().contentEquals(name));
			option.click();
			break;
		}
	}

	// to city
	public void tocity(String name) {
		tocityname.sendKeys(name);
		WaitVisibility(tooptionslist);
		for (WebElement option : tocityoptions) {
			options.stream().map(s -> s.getText().contentEquals(name));
			option.click();
			break;
		}
	}

	// month
	public void month(String name) {
		while (!month.getText().contains(name)) {
			monthclick.click();
		}
	}

	// day
	public void day(String day) throws InterruptedException {
		// String days= Integer.toString(day);
		for (int i =1 ; i < datecount.size(); i++) {
			 String selectd=datecount.get(i).getText();
			if (selectd.contentEquals(day)) {
				System.out.println(selectd);
				datecount.get(i).click();
                break;
			}

		}
		Thread.sleep(3000);
		
		dateselect.click();
	}

	// fairtype
	public void fairtype(int numbers) {
		fair.click();
		for (int i = 1; i < numbers; i++) {
			selectnumbers.click();
		}
		done.click();
		// select student

	}

	// summit
	public void submit() {
		WaitVisibility(sumitwait);
		driver.findElement(By.cssSelector("div[class='sc-12foipm-90 gUQNRY'] [class='sc-12foipm-91 bwfKFn']")).click();
	}
}
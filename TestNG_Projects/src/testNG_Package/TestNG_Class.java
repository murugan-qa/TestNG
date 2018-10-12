package testNG_Package;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestNG_Class {

	
	static WebDriver driver;
	
	static WebDriverWait exwait;
	@BeforeTest
	//@BeforeMethod
	//@Test
	
	  void Launch() throws InterruptedException {
		 System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://spicejet.com/");
		driver.manage().window().maximize();
		Thread.sleep(300);
		
	}
	//@Test(dependsOnMethods= {"Launch"})
	//@Test(enabled=false)
	//@Test (priority=3)
	@Test
	public static void BookFlight()  {
		driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_rbtnl_Trip_1\"]")).click();
	}
	
	//@Test(dependsOnMethods = {"BookFlight"})	
	//@Test(priority=2)
	@Test(enabled=false)
	public static void select_city() throws InterruptedException{

			exwait = new WebDriverWait(driver, 50);
		    WebElement Departure_City = exwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ctl00_mainContent_ddl_originStation1_CTXT\"]")));
		    Departure_City.click();
		    
			
		}
	@Test
	public static void selectmethod_city() {
		Select alloptions =  new Select(driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_originStation1\"]")));
		//alloptions.selectByVisibleText("Goa (GOI)");
		List<WebElement> o =alloptions.getOptions();
		for(int i=0;i<o.size();i++) {
		System.out.println(o.get(i).getText());
		}
//		WebElement selectedelement =alloptions.getFirstSelectedOption();
//		String ws=selectedelement.getText();
//		System.out.println(ws);
		//System.out.println(count);
	//	alloptions.selectByValue("DEL");
//		for(int i=0; i<alloptions.size();i++) {
//			System.out.println(alloptions.get(i).getText());
//		}
		
	}
	//@Test (priority=1)
	@Test(enabled=false)
	public void cselect_currency() {
		Select currency = new Select(driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_DropDownListCurrency\"]")));
		currency.selectByIndex(2);
		}
				
 //@AfterTest
	void Close_Window() {
		driver.close();
	}
}
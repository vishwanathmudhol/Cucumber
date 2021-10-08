package StepDefinitions;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.cucumber.messages.internal.com.google.common.collect.Table;

public class SearchFlight {
	WebDriver driver;
	@Given("User have flight search option available")
	public void user_have_flight_search_option_available() {
	   System.out.println("Step1");
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\vishwanath.mudhol\\eclipse-workspace\\Cucumber\\Support\\chromedriver.exe");
      driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get("https://www.cleartrip.com/");

	  
	}

	@When("User search for flight between BLR-DEL")
	public void user_search_for_flight_between_blr_del(DataTable table) throws InterruptedException {
		 System.out.println("Step2");
		 java.util.List<String> data = table.row(0);
		 System.out.println("Data fetched is "+data.get(1));
		 
		 driver.findElement(By.xpath("//input[@placeholder='Any worldwide city or airport']")).sendKeys("BLR");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//p[@class='to-ellipsis o-hidden ws-nowrap c-inherit fs-3']")).click();
		Thread.sleep(5000);
		
		System.out.println("BLR is entered");
	}

	@Then("User should be able to see all the available flights between BLR-DEL")
	public void user_should_be_able_to_see_all_the_available_flights_between_blr_del() {
		 System.out.println("Step3");
		 driver.close();
	}	
}

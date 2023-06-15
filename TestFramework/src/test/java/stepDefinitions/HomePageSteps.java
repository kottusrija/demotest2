package stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.test.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class HomePageSteps {
	WebDriver driver;
	private ContextSteps  steps;
	private Logger logger;
	public HomePageSteps(ContextSteps  steps) {
		this.steps=steps;
		this.logger = steps.getLogger();
		driver = steps.getDriver();
	}
	
	
	@Given("The user is on home page")
	public void i_am_on_home_page() {
	    HomePage.using(driver).validateUser();
	}

	@When("The user selects a product and checkout")
	public void i_select_a_product_and_checkout() {
		HomePage.using(driver).navigateToPaperBackBooks();
		HomePage.using(driver).checkOutBook();
	   
	}

	@Then("The user validates the details of product")
	public void i_validate_the_details_of_product() {
		HomePage.using(driver).naviageToCart();
		HomePage.using(driver).validateProductDetails();
	    
	}





}
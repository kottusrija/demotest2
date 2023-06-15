package stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.test.pages.CreateAccountPage;
import com.test.pages.LandingPage;


public class CreateAccountPageSteps {
	WebDriver driver;
	private ContextSteps  steps;
	private Logger logger;
	public CreateAccountPageSteps(ContextSteps  steps) {
		this.steps=steps;
		this.logger = steps.getLogger();
		driver = steps.getDriver();
	}
	
	
	

	@When("The user enters the details and click on continue")
	public void i_enter_the_details_and_click_on_continue() {
		CreateAccountPage.using(driver).enterUserDetails();
	}

	




	@Then("The user sees that new user registration is successful")
	public void i_see_that_new_user_registration_is_successful() {
	    
	}






}
package stepDefinitions;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.test.pages.HomePage;
import com.test.pages.LandingPage;
import com.test.pages.LoginPage;


public class LoginPageSteps {
	WebDriver driver;
	private ContextSteps  steps;
	private Logger logger;
	public LoginPageSteps(ContextSteps  steps) {
		this.steps=steps;
		this.logger = steps.getLogger();
		driver = steps.getDriver();
	}
	
	
	

	@Given("The user is on login page")
	public void i_am_on_login_page() {
	    LandingPage.using(driver).launchApplication();
	    LandingPage.using(driver).clickOnLoginOrRegisterLink();
	}
	
	@When("The user enters valid credentials and click on login button")
	public void i_enter_valid_credentials_and_click_on_login_button() {
		LoginPage.using(driver).Login();
	}
	
	@Then("The user sees user is successfully logged in")
	public void i_see_user_is_successfully_logged_in() {
	    HomePage.using(driver).validateUser();
	}





}

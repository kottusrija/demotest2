package stepDefinitions;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.test.pages.AccountLoginPage;
import com.test.pages.LandingPage;


public class LandingPageSteps {
	
	WebDriver driver;
	
	private ContextSteps  steps;
	private Logger logger;
	public LandingPageSteps(ContextSteps  steps) {
		this.steps=steps;
		this.logger = steps.getLogger();
		driver = steps.getDriver();
	}
	
	
	@Given("The user is on landing page")
	public void i_am_on_landing_page() {
	   
		LandingPage.using(driver).launchApplication();
	    LandingPage.using(driver).validateLaunchPage();
	    logger.info("lauched the app successfully");
	}


	
	@When("The user clicks on Login Or Register link")
	public void i_click_on_login_or_register_link() {
	    LandingPage.using(driver).clickOnLoginOrRegisterLink();
	    logger.info("clicked on login or register link");
	}

	@Then("The user sees Account Login page is displayed")
	public void i_see_account_login_page_is_displayed() {
		AccountLoginPage.using(driver).validateAccountsPage();
		logger.info("successfully navigated to accounts login page");
	}
	
	@Given("The user clicks on continue button for Register")
	public void i_click_on_continue_button_for_register() {
	    AccountLoginPage.using(driver).clickOnRegister();
	}






}
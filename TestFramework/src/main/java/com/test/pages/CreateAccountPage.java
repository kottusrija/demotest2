package com.test.pages;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.test.baseWeb.BasePage;
import com.test.constants.applicationConstants;




public class CreateAccountPage extends BasePage{
	
	@FindBy(xpath = "//input[@id='AccountFrm_firstname']")
	private WebElement firstName; 
	
	@FindBy(xpath = "//input[@id='AccountFrm_lastname']")
	private WebElement lastName;
	
	@FindBy(xpath = "//input[@id='AccountFrm_email']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@id='AccountFrm_address_1']")
	private WebElement address;
	
	@FindBy(xpath = "//input[@id='AccountFrm_city']")
	private WebElement city;
	
	@FindBy(xpath = "//select[@id='AccountFrm_zone_id']")
	private WebElement region;
	
	@FindBy(xpath = "//input[@id='AccountFrm_postcode']")
	private WebElement zip;
	
	@FindBy(xpath = "//input[@id='AccountFrm_loginname']")
	private WebElement loginName;
	
	@FindBy(xpath = "//input[@id='AccountFrm_password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@id='AccountFrm_confirm']")
	private WebElement confirmPassword;
	
	@FindBy(xpath = "//input[@id='AccountFrm_newsletter0']")
	private WebElement noSubscribe;
	
	@FindBy(xpath = "//input[@id='AccountFrm_agree']")
	private WebElement agreeToTerms;
	
	@FindBy(xpath = "//button[@title='Continue']")
	private WebElement continueButton;
	
	
	
	
	
	
	 
	
	
	
	
	
	
	public CreateAccountPage(WebDriver driver) {
		super(driver);
	}
	
	 public static CreateAccountPage using(WebDriver driver) {
	        return new CreateAccountPage(driver);
	    }
	 
	 public void validateLaunchPage(){
		 validatePageTitle(); 
		 waitTillPageLoad();
	 }
	 
	

	public void enterUserDetails() {
		 this.firstName.sendKeys("TestUser");
		 this.lastName.sendKeys("Test");
		 this.email.sendKeys("automationTestApp@gmail.com");
		 this.address.sendKeys("stree1, road 4");
		 this.city.sendKeys("London");
		 selectByVisibleText(this.region,"Greater London");
		 this.zip.sendKeys("12344");
		 this.loginName.sendKeys("AutomationAssignment");;
		 this.password.sendKeys("Test@123");
		 this.confirmPassword.sendKeys("Test@123");
		 this.noSubscribe.click();
		 this.agreeToTerms.click();
		 this.continueButton.click();
		 
	 }
	 

	
	
	

	
	

	@Override
	protected void setPageproperties() {
		this.pageTitle = applicationConstants.TITLE_CREATEACCOUNT_PAGE;
	}
}
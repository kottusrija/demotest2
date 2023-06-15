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




public class LandingPage extends BasePage{
	
	@FindBy(xpath = "//a[normalize-space()='Login or register']")
	private WebElement LoginOrRegisterLink; 
	
	
	
	
	
	
	
	
	public LandingPage(WebDriver driver) {
		super(driver);
	}
	
	 public static LandingPage using(WebDriver driver) {
	        return new LandingPage(driver);
	    }
	 
	 public void launchApplication() {
		 this.driver.get("https://automationteststore.com/");
	 }
	 public void validateLaunchPage(){
		 validatePageTitle(); 
		 waitTillPageLoad();
	 }
	 
	 

	public void clickOnLoginOrRegisterLink() {
		 this.LoginOrRegisterLink.click();
	 }
	 

	

	

	
	@Override
	protected void setPageproperties() {
		this.pageTitle = applicationConstants.TITLE_LANDING_PAGE;
	}
}

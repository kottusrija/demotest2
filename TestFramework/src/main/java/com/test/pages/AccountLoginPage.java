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




public class AccountLoginPage extends BasePage{
	
	@FindBy(xpath = "//button[@title='Continue']")
	private WebElement continueRegister; 
	

	
	
	
	
	
	
	public AccountLoginPage(WebDriver driver) {
		super(driver);
	}
	
	 public static AccountLoginPage using(WebDriver driver) {
	        return new AccountLoginPage(driver);
	    }
	 
	 public void clickOnRegister() {
		 this.continueRegister.click();
	 }
	 
	 public void validateAccountsPage(){
		 validatePageTitle(); 
		 waitTillPageLoad();
	 }
	 

	
	
	

	
	
	@Override
	protected void setPageproperties() {
		this.pageTitle = applicationConstants.TITLE_ACCOUNTS_PAGE;
	}
}

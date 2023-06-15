
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




public class LoginPage extends BasePage{
	
	@FindBy(xpath = "//input[@id='loginFrm_loginname']")
	private WebElement userName;
	
	@FindBy(xpath = "//input[@id='loginFrm_password']")
	private WebElement password;
	
	@FindBy(xpath = "//button[@title='Login']")
	private WebElement loginButton;
	
	
	
	 
	
	
	
	
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	 public static LoginPage using(WebDriver driver) {
	        return new LoginPage(driver);
	    }
	 
	 public void Login() {
		 this.userName.sendKeys("AutomationAssignment");
		 this.password.sendKeys("Test@123");
		 this.loginButton.click();
	 }
	 

	
	
	

	
	@Override
	protected void setPageproperties() {
		this.pageTitle = applicationConstants.TITLE_LANDING_PAGE;
	}
}
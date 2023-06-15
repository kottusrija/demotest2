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
import org.openqa.selenium.interactions.Actions;




public class HomePage extends BasePage{
	
	@FindBy(xpath = "//div[@class='menu_text']")
	private WebElement userName;
	
	
	@FindBy(xpath = "//ul[@class='nav-pills categorymenu']//a[contains(text(),'Books')]")
	private WebElement booksTab;
	
	@FindBy(xpath = "//img[@title='Paperback']/preceding-sibling::a")
	private WebElement paperBack;
	
	@FindBy(xpath = "//a[@title='Paper Towns by John Green']/parent::div/parent::div/following-sibling::div//i")
	private WebElement JohnBook;
	
	@FindBy(xpath = "//a[@title='Paper Towns by John Green']/parent::div/parent::div/following-sibling::div//div[@class='oneprice']")
	private WebElement JohnBookPrice;
	
	@FindBy(xpath = "(//span[@class='menu_text' and contains(text(),'Cart')])[1]")
	private WebElement cart;
	
	@FindBy(xpath = "//table[@class='table table-striped table-bordered']//tr[2]/td[4]")
	private WebElement unitPriceInCart;
	
	@FindBy(xpath = "//table[@class='table table-striped table-bordered']//tr[2]/td[5]")
	private WebElement quantityInCart;
	
	
	
	
	
	
	
	
	
	
	
	
	
	private String price = null;
	 
	
	
	
	
	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	 public static HomePage using(WebDriver driver) {
	        return new HomePage(driver);
	    }
	 
	 public void validateUser() {
		Assert.assertTrue(this.userName.getText().contains("TestUser"));
	 }
	 
	 public void navigateToPaperBackBooks() {
		 Actions actions = new Actions(driver);
		 actions.moveToElement(this.booksTab).perform();
		 this.paperBack.click();
	 }
	 
	 public void checkOutBook() {
		 price = this.JohnBookPrice.getText();
		 this.JohnBook.click();
	 }
	 
	 public void naviageToCart() {
		 this.cart.click();
	 }
	 
	 public void validateProductDetails() {
		 Assert.assertEquals(this.unitPriceInCart.getText(), "$9.99");
		 Assert.assertEquals(this.quantityInCart.getText(), "1");
	 }
	 

	
	
	

	
	@Override
	protected void setPageproperties() {
		this.pageTitle = applicationConstants.TITLE_LANDING_PAGE;
	}
}

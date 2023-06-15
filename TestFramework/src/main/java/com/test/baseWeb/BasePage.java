package com.test.baseWeb;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.test.constants.applicationConstants;
import com.test.pages.PageHeader;
import com.test.utilities.ApplicationProperties;




public abstract class BasePage {

	protected WebDriver driver;
	protected PageHeader header;
	protected int waitTime;
	protected int timeout;
	protected ApplicationProperties appPropertiesWeb;

	protected String pageTitle;
	protected String pageUrl;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		header = PageHeader.getInstance(this.driver);
		appPropertiesWeb = appPropertiesWeb.getInstance("application");
		waitTime = Integer.parseInt(appPropertiesWeb.getProperty(applicationConstants.IMPLICIT_WAIT_TIME)); 
		timeout = Integer.parseInt(appPropertiesWeb.getProperty(applicationConstants.PAGE_LOAD_WAIT_TIME));
		// defaults to title strategy if not set by setPageproperties

		setPageproperties();
	}

	protected abstract void setPageproperties();

   protected WebElement getXpathWaitTagAndText(String tag, String text) {
	   return driver.findElement(By.xpath("//"+tag+"[normalize-space()='"+text+"']"));
   }
   
   
   public void switchToTabByIndex(int index) {
	   ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	   String newTab = tabs.get(index);
	   driver.switchTo().window(newTab);
   }
   
   protected boolean isElementPresent(WebElement ele) {
	   try {
		   waitForElementToBeVisible(waitTime, ele);
		   return ele.isDisplayed();
	   }catch(Exception e) {
		   //e.printStackTrace();
		   return false;
	   }
   }
   
   protected boolean isElementEnabled(WebElement ele) {
	   try {
		   return ele.isEnabled();
	   }catch(Exception e) {
		   //e.printStackTrace();
		   return false;
	   }
   }
  public void switchToFrame(WebElement ele) {
	  this.driver.switchTo().frame(ele);
  }
  
  public void swithToDefaultContent() {
	  this.driver.switchTo().defaultContent();
  }
  
	public String getTitle() {
		return driver.getTitle();
	}

	public String getPageTitle() {
		return this.pageTitle;
	}

	public String getURL() {
		return driver.getCurrentUrl();
	}

	public String getPageURL() {
		return this.pageUrl;
	}
	
	public void validatePageTitle() {
		Assert.assertEquals(getTitle(),getPageTitle());
	}
	
	public void validate(String s1, String s2) {
		Assert.assertEquals(s1,s2);
	}

	public PageHeader PageHeader() {
		return header;
	}

	protected boolean isElementPresent(By by) {
		return !driver.findElements(by).isEmpty();
	}
	
	protected void waitForElementClickable(int timeout, final WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(timeout)).pollingEvery(Duration.ofSeconds(timeout/10))
				.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void selectByVisibleText(WebElement ele,String text) {
		Select s = new Select(ele);
		s.selectByVisibleText(text);
	}

	protected void waitForElementToBeVisible(int timeout, final WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(timeout)).pollingEvery(Duration.ofSeconds(timeout/10))
				.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitTillPageLoad() {
	try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(waitTime));
		wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")); 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickElementWithJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void enterTextWithJs(WebElement element,String text) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].value="+text, element); 
	}
	
	public void scrollIntoView(WebElement ele) {
		try {
		 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ele );
		}catch(Exception e) {
			System.out.println("error while scrolling to view the element");
		}
	}
	
	public void waitForDuration(long time) {
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}

	
	
}

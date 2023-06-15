package stepDefinitions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.test.constants.applicationConstants;
import com.test.frameworkweb.DriverManager;
import com.test.frameworkweb.DriverManagerFactory;
import com.test.frameworkweb.DriverType;
import com.test.utilities.ApplicationProperties;
import com.test.utilities.LoggerProperties;
import com.test.webTest.TestData;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ContextSteps  {
	protected ApplicationProperties appPropertiesWeb,appPropertiesApi;
    private   WebDriver driver;
    protected DriverManager driverManager;
    protected DriverType driverType;
    protected LoggerProperties loggerProperties;
    private static Logger logger;
    
   
    public WebDriver getDriver() {
        return driver;
     }
    
    @Before(order=1)
	public void setup() {
    	loggerProperties = LoggerProperties.getInstance();
    	setLogger(loggerProperties.getLogger());
    	appPropertiesWeb = appPropertiesWeb.getInstance("application");
    	String browser = appPropertiesWeb.getProperty("browser");
		  setBrowserType(browser);
			driverManager = DriverManagerFactory.getDriverManager(driverType);
			driver = driverManager.getDriver();	
			//System.out.println("the driver instance in hooks is:"+driver);
			
	}

    @Before(order=2)
    public void configureWaitTimes() {
    	//System.out.println("hit before of order 2");
        int implicitWaitTime = Integer.parseInt(appPropertiesWeb.getProperty(applicationConstants.IMPLICIT_WAIT_TIME));
        long pageloadWaitTime = Integer.parseInt(appPropertiesWeb.getProperty(applicationConstants.PAGE_LOAD_WAIT_TIME));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitTime));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageloadWaitTime));
    }

    @Before(order=3)
    public void maximizeBrowser() {
    	//System.out.println("hit before of order 3");
        driver.manage().window().maximize();
        System.out.println("driver instance is :"+driver);
    }
    @Before(order=4)
    public void openStartURL() {
		driver.get(TestData.START_URL);	
		//driver.manage().timeouts().pageLoadTimeout(pageloadWaitTime);
	}

    @After
    public void stopBrowser() {
        driverManager.quit();
    }
     
    
    protected void setBrowserType(String browserString) {
     	if(browserString.equals(null)) {
     		browserString = appPropertiesWeb.getProperty(applicationConstants.BROWSER_NAME);
     	}
         if (browserString.equalsIgnoreCase("chrome")) {
             driverType = DriverType.CHROME;
         } else if (browserString.contains("firefox")) {
             driverType = DriverType.FIREFOX;
         } else if (browserString.equalsIgnoreCase("grid-chrome")) {
             driverType = DriverType.GRID_CHROME;
         } else {
             throw new AssertionError("Unsupported Browser");
         }
     }
    
    public static Logger getLogger() {
    	return logger;
    }
    public static void setLogger(Logger logger) {
    	ContextSteps.logger=logger;
    }


}

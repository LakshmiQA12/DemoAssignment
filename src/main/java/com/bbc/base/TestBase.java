/***********************************************************************************************************************************************************************************
* @author : Lakshmi 
* @Description: Test Base class which holds all  Reference variables/methods for drivers.
***********************************************************************************************************************************************************************************/

package com.bbc.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.bbc.pageobjects.CommentsPageObject;
import com.bbc.pageobjects.RegisterPageObject;
import com.bbc.pageobjects.SignInPageObject;
import com.bbc.util.CommonConstants;
import com.bbc.util.WebEventListener;

public class TestBase {

	public static String url ;
	public static String browserName ;
	public static WebDriver driver;
	public static Actions action;
	public static Properties prop;
	
	//WebDriver Event Listeners Variables 
	public static WebEventListener eventListener;
	public static EventFiringWebDriver edriver;
	
	//Extent Reports Variables 
	public ExtentReports extent;
	public ExtentTest extentTest;
	
	//Page Objects Variables  
	public static RegisterPageObject registrationPage ;
	public static SignInPageObject signinPage ;
	public static CommentsPageObject commentsPage ; 
	
	//Assertion Variables
	public Assert asserte;
	
	//Loggers
	public static Logger log = Logger.getLogger(TestBase.class);
		
    static 
	{
		prop = new Properties(); // Creating an object for Property class to read the property file
		try {
			FileInputStream fs = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/bbc/dataprovider/config.properties");
			try {
				prop.load(fs);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void setupBrowser() 
	{
		url = prop.getProperty("BBCCOMMENTSURL");
		browserName = prop.getProperty("BROWSER");
		driver = createWebDriver(browserName);
		action = new Actions(driver);
		
	    registrationPage = new RegisterPageObject();
	    signinPage = new SignInPageObject();
	    commentsPage = new CommentsPageObject();
	    
	}
	
	
	public static WebDriver createWebDriver(String browser)
	{
		
		if(browser.equals("chrome"))
		{
		    System.setProperty("webdriver.chrome.driver", "ChromeDriver//chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		
		else
		{
			System.setProperty("webdriver.gecko.driver", "GeckoDriver//geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		
		edriver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		edriver.register(eventListener);
		driver = edriver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(CommonConstants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(CommonConstants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(url);
		log.info("Launching the URL");
		//WaitHelper.simpleWait(1);
				
		return driver;
				
	}
	
	

}
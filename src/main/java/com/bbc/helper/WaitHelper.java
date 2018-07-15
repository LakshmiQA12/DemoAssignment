/***********************************************************************************************************************************************************************************
* @author : Lakshmi 
* @Description: Helper class holding all Wait Methods.
***********************************************************************************************************************************************************************************/

package com.bbc.helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.bbc.base.TestBase;
import com.google.common.base.Function;
import com.google.common.base.Predicate;

public class WaitHelper extends TestBase {

	static WebDriverWait wait;

	public static void pageloadWait() {
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public static void implicitWait(int waitTimeSeconds) {
		driver.manage().timeouts().implicitlyWait(waitTimeSeconds, TimeUnit.SECONDS);
	}

	/** Explicit Wait Methods **/
	public static WebElement waitUntilLocated(By by, int waitTimeSeconds) {
		try {
			WebElement element = null;
			wait = new WebDriverWait(driver, waitTimeSeconds);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			System.out.println("text coming on screen to be located is  : " + element.getText());
			return element;
		} catch (Exception e) {
			return null;
		}

	}

	public static WebElement clickWhenReady(WebElement elt, int waitTimeSeconds) {
		try {
			WebElement element = null;
			wait = new WebDriverWait(driver, waitTimeSeconds);
			element = wait.until(ExpectedConditions.elementToBeClickable(elt));
			System.out.println("text coming on screen to be clicked  is : " + element.getText());

			return element;
		} catch (Exception e) {
			return null;
		}

	}

	public static WebElement waitUntilVisible(WebElement elt, int waitTimeSeconds) {
		try {
			WebElement element = null;
			wait = new WebDriverWait(driver, waitTimeSeconds);
			element = wait.until(ExpectedConditions.visibilityOf(elt));
			System.out.println("text coming on screen to be visible is  : " + element.getText());
			return element;
		} catch (Exception e) {
			return null;
		}

	}

	public static WebElement waitUntilElementToBeClickable(WebElement elt, int waitTimeSeconds) {
		try {
			WebElement element = null;
			wait = new WebDriverWait(driver, waitTimeSeconds);
			element = wait.until(ExpectedConditions.elementToBeClickable(element));

			return element;
		} catch (Exception e) {
			return null;
		}

	}

	
	
	public static WebElement waitForElementById(String id, int abortAfterSeconds) {
		try {
			driver.manage().timeouts().implicitlyWait(abortAfterSeconds, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, abortAfterSeconds);
			return wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
		} catch (Exception e) {
			return null;
		}
	}

	public static WebElement waitForElementByXPath(String xpath, int abortAfterSeconds) {
		try {
			driver.manage().timeouts().implicitlyWait(abortAfterSeconds, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, abortAfterSeconds);
			return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		} catch (Exception e) {
			return null;
		}

	}

	public static void simpleWait(int waitTimeSeconds) {

		try {
			
			WebDriverWait wait = new WebDriverWait(driver, waitTimeSeconds);
			ExpectedCondition<WebElement> ec = ExpectedConditions.visibilityOfElementLocated(By.id("invalid_id"));
			wait.until(ec);

		} catch (TimeoutException ex) {
			// Ignore the timeout
		} catch (UnhandledAlertException uae) {

		}

	}
	
	/********************** Wait Methods to handle page load timeout error ***************************************************/

	//Wait for JQuery to load
	
	public static boolean waitForJStoLoad() 
	{
	    WebDriverWait wait = new WebDriverWait(driver, 30);
	    ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
	           public Boolean apply(WebDriver Wdriver){
	        	   JavascriptExecutor js1 = (JavascriptExecutor) driver;
	        try {
	          return ((Long)js1.executeScript("return jQuery.active") == 0);
	        }
	        catch (Exception e) {
	          return true;
	        }
	      }
	    };

	   	  return wait.until(jQueryLoad);
	}
	
	//Wait for DOM state is Complete
	
	public static Boolean WaitUntilDocumentIsReady(){
		  
		    WebDriverWait wait = new WebDriverWait(driver, 30);
		    
		    ExpectedCondition<Boolean> pageLoad = new ExpectedCondition<Boolean>() 
		    {
		         public Boolean apply(WebDriver Wdriver)
		         {
		        	 JavascriptExecutor js1 = (JavascriptExecutor) driver;
		        	 try {
		        		  return js1.executeScript("return document.readyState").equals("complete");
				         }
					       
				     catch (Exception e) 
		        	 {
				          return false;
				     }
				     }
				     };
    			   	  return wait.until(pageLoad);
			}
				
				
		
	public static void checkPageIsReady() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		if (js.executeScript("return document.readyState").toString().equals("complete")) {
			System.out.println("Page Is loaded.");
			return;
		}
		else
		{
			System.out.println("Page Is not loaded fully.");
		}
			
	}
	
	
	
	
	/***************************************************Fluent Waits********************************************************************************************/
	
	//Fluent Wait With function-->
	
	public static WebElement fluentWaitTest(final String spath)
	{
		// Create object of FluentWait class and pass WebDriver as input
		 
           FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
           wait.pollingEvery(1, TimeUnit.SECONDS);
           log.info("Polling the DOM for the target WebElement");
           wait.withTimeout(1, TimeUnit.MINUTES);
           wait.ignoring(NoSuchElementException.class);

           // Function :Input as WebDriver and output as WebElement
           WebElement element = wait.until(new Function<WebDriver, WebElement>()  //This Function returns a WebElement 
           {
             // apply method- WebDriver as input
             public WebElement apply(WebDriver arg0) //We are defining the function taking the WebDriver as input 
             {
               WebElement ele = arg0.findElement(By.xpath(spath));
               return ele;
             }

           }
           );

           //If element is found then it will display the status
            System.out.println("Final visible status is >>>>> " + element.isDisplayed());
            return element;

   }

/*****================================================================================================================================================================================**/
	public static void fluentWait()
	{
		
		//Locating an element by polling the dom frequently with timeout wait also given 
		//So as a first step ,give the timeout wait,polling seconds ,exception name 
	    FluentWait<WebDriver> fluentwait = new FluentWait<WebDriver>(driver);
	    fluentwait.withTimeout(5000, TimeUnit.MILLISECONDS);
	    fluentwait.pollingEvery(250, TimeUnit.MILLISECONDS);
	    //fluentwait.withTimeout(2, TimeUnit.MINUTES);
	    fluentwait.ignoring(NoSuchElementException.class);
		
	    
	    //Declaring function with 
	    //WebDriver as input ,WebElement as output
		Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>()
		{
			//Define Function : Locate the element and return the element 
			public WebElement apply(WebDriver fdriver) 
			{
			
				System.out.println("Checking for the element!!");
				WebElement element = fdriver.findElement(By.id("targetid"));
				if(element != null)
				{
					System.out.println("Target element found");
				}
				return element;
			}
		};

    
		fluentwait.until(function); //So this will return an webelement 
       
	}

	
	//We can rewrite the function with boolean as output value as well using Predicate 
	public static void fluentWaitPredicate()
	{
		
		//Locating an element by polling the dom frequently with timeout wait also given 
		
		//So as a first step ,give the timeout wait,polling seconds ,exception name 
	    FluentWait<WebDriver> fluentwait = new FluentWait<WebDriver>(driver);
	    fluentwait.withTimeout(5000, TimeUnit.MILLISECONDS);
	    fluentwait.pollingEvery(250, TimeUnit.MILLISECONDS);
	    //fluentwait.withTimeout(2, TimeUnit.MINUTES);
	    fluentwait.ignoring(NoSuchElementException.class);
		
	    
	    //Declaring function with 
	    //WebDriver as input ,WebElement as output
	    FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(250,  TimeUnit.MILLISECONDS);
		wait.withTimeout(2, TimeUnit.MINUTES);
		wait.ignoring(NoSuchElementException.class); //make sure that this exception is ignored
 
		Predicate<WebDriver> predicate = new Predicate<WebDriver>()
				{
 
					public boolean apply(WebDriver arg0) 
					{
						WebElement element = arg0.findElement(By.id("colorVar"));
						String color = element.getAttribute("color");
						System.out.println("The color if the button is " + color);
						if(color.equals("red"))
						{
							return true;
						}
						return false;
					}
				};
		       
	}
	
	
		
	
}
	
	

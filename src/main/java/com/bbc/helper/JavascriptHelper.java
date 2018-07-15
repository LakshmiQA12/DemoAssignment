/***********************************************************************************************************************************************************************************
* @author : Lakshmi 
* @Description: Helper class holding all Javascript Methods.
***********************************************************************************************************************************************************************************/

package com.bbc.helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.bbc.base.TestBase;

public class JavascriptHelper extends TestBase{
	JavascriptExecutor js ;
	
	public Object executeScript(String script) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		return exe.executeScript(script);
	}
	
	public static void flash(WebElement element)
	{
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String bgcolor  = element.getCssValue("backgroundColor");
        for (int i = 0; i <  15; i++) {
            changeColor("rgb(0,255,0)", element);//1  //Highlight Element 10 times 
            changeColor(bgcolor, element);//2 // Then move back to original colour 
        }
    }
	
    public static void changeColor(String color, WebElement element)
    {
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",  element);

        try {
            Thread.sleep(20);
        }  catch (InterruptedException e) {
        }
     }

    public static void scrollintoview(WebElement element)
    {
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView()", element);
    	 try {
             Thread.sleep(20);
         }  catch (InterruptedException e) {
         }
    	
    }
    
}
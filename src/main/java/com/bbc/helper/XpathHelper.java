/***********************************************************************************************************************************************************************************
* @author : Lakshmi 
* @Description: Helper class holding all Xpath Methods.
***********************************************************************************************************************************************************************************/

package com.bbc.helper;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import com.bbc.base.TestBase;

public class XpathHelper extends TestBase {

	public static WebElement findDivWebElementByXPathClassAndText(String className, String text) {
		return findWebElementByXPathClassAndText("div", className, text);
	}

	public static WebElement findSpanWebElementByXPathClassAndText(String className, String text) {
		return findWebElementByXPathClassAndText("span", className, text);
	}

	public static WebElement findButtonWebElementByXPathClassAndText(String className, String text) {
		return findWebElementByXPathClassAndText("button", className, text);
	}

	public static WebElement findTextAreaWebElementByXPathClassAndText(String className, String text) {
		return findWebElementByXPathClassAndText("x-form-textarea", className, text);
	}

	public static WebElement findButtonWebElementByXPathClassAndText(String text) {
		return findButtonWebElementByXPathClassAndText("x-btn-text", text);
	}

	public static WebElement findWebElementByXPathClassAndText(String elementType, String className, String text) {
		return findByXPath("//" + elementType + "[contains(@class, '" + className + "') and text()='" + text + "']");
	}

	public static WebElement findInputWebElementByXPathInFormWithLabel(String label) {
		return findByXPath("//div[contains(@class, 'x-form-label') and text()='" + label + "']/following::div[1]/input");
	}

	public static WebElement findTdWebElementByAfterDivWithText(String divText, int numTds) {

		return findByXPath("//div[text()='" + divText + "']/following::td[" + numTds + "]");
	}

	public static WebElement findInputWebElementByXPathInFormWithLabel(String label, int divPosition) {
		return findByXPath("//div[contains(@class, 'x-form-label') and text()='" + label + "']/following::div[" + divPosition + "]/input");
	}

	public static WebElement findInputWebElementByXPathBtnDropDownWithLabel(String label) {
		return findByXPath("//div[contains(@class, 'x-form-label') and text()='" + label + "']/following::table/tbody/tr[2]/td[2]/em/button/img");
	}

	public static WebElement findInputWebElementByXPathDropDownWithLabel(String label, int divPosition) {
		return findByXPath("//div[contains(@class, 'x-form-label') and text()='" + label + "']/following::div[" + divPosition + "]/img");
	}

	public static WebElement findSelectOptionWithLabelAndOptionText(String label, String optionText) {
		return findByXPath("//div[contains(@class, 'x-form-label') and text()='" + label + "']/following::select[1]/option[text()='" + optionText + "']");
	}

	public static WebElement findSelectOptionWithIdAndOptionText(String id, String optionText) {
		return findByXPath("//select[contains(@id, '" + id + "')]/option[text()='" + optionText + "']");
	}

	public static WebElement findSelectById(String id) {
		return findByXPath("//select[contains(@id, '" + id + "')]");
	}

	public static WebElement findCheckbox(String checkBoxId) {
		return findByXPath("//div[contains(@id, '" + checkBoxId + "')]/input[1]");
	}

	public static WebElement findSpanWithText(String text) {
		return findByXPath("//span[text()='" + text + "']");
	}

	public static void selectRightClickMenu(String menuDescription) {
		findElemByTypeAndText("a", menuDescription).click();
	}
	
	
	
	public static WebElement findByXPath(String xpath) {

		return driver.findElement(By.xpath(xpath));
	}

	public static WebElement safeFindWebElementById(String id) {
		try {
			return driver.findElement(By.id(id));
		}
		catch (NoSuchElementException nsee) {
			
			return null;
		}
	}

	public static void rightClickWebElement(WebElement webElement) {
		// right click
		action.contextClick(webElement).perform();
	}

	public static void confirmYesAlert() {
		if (isButtonWebElementExist("Yes")) {
			WebElement confirmYesElement = WaitHelper.clickWhenReady(XpathHelper.findButtonWebElementByXPathClassAndText("Yes"),5);
			confirmYesElement.click();

		}

	}

	public static void confirmNoMessage() {
		if (isButtonWebElementExist("No")) {
			WebElement confirmNoElement = findButtonWebElementByXPathClassAndText("No");
			confirmNoElement.click();

		}

	}

	public static void confirmOKMessage() {
		if (isButtonWebElementExist("OK")) {
			WebElement confirmOKElement = WaitHelper.clickWhenReady(XpathHelper.findButtonWebElementByXPathClassAndText("OK") , 5);
			confirmOKElement.click();

		}

	}
	
	public static void  confirmCANCELMessage() {
		if (isButtonWebElementExist("Cancel")) {
			WebElement confirmCancelElement = findButtonWebElementByXPathClassAndText("Cancel");
			confirmCancelElement.click();
			
		}
	}
	


	public static void confirmWarningInfo() {

		if (isButtonWebElementExist("OK")) {
			WebElement confirmExpiryDate = findButtonWebElementByXPathClassAndText("OK");
			confirmExpiryDate.click();
			
		}

		if (isButtonWebElementExist("Yes")) {
			WebElement confirmExpiryDate = findButtonWebElementByXPathClassAndText("Yes");
			confirmExpiryDate.click();
			
		}
	}
	
	public static WebElement findElemByTypeAndText(String elementType, String text) {
		return findByXPath("//" + elementType + "[text() = '" + text + "']");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/********************************************Boolean -Return Value Functions *******************************************************************************************************************/
	
	public static boolean isButtonWebElementExist(String divText) {
		try {
			System.out.println("isbutton");
			WebElement confirmElement = findButtonWebElementByXPathClassAndText(divText);
			return true;
		}
		catch (NotFoundException e) {
			return false;
		}

	}
	
	public static boolean isLabelWebElementExist(String text) {
		try {
			
			WebElement elt = XpathHelper.findByXPath("//label[contains(@class, 'x-form-cb-label') and text()= 'Update Details']");
			return true;
		}
		catch (NotFoundException e) {
			return false;
		}

	}
	
	public static boolean isSpanWebElementExist(String text) {
		try {
			findSpanWithText(text);
			return true;
		}
		catch (NotFoundException e) {
			return false;
		}
	}
	
	
	public static boolean isDivWebElementExist(String className, String divText) {
		try {
			findDivWebElementByXPathClassAndText(className, divText);

			return true;
		}
		catch (NotFoundException e) {
			return false;
		}
	}
	
	
	public static void handleStaleElementForClear() throws IOException {

		try {
			WebElement clearBtnElement = WaitHelper.clickWhenReady(XpathHelper.findButtonWebElementByXPathClassAndText("Clear"),5);
			clearBtnElement.click();
			
		}
		catch (StaleElementReferenceException e) {
			System.out.println("Trying to recover from a stale element :" + e.getMessage());
		}
	}
		 static String actualHexValueColor  ;
		
	public static String getHexaValueColor(String rgbText) {

		String[] hexValue = rgbText.replace("rgba(", "").replace(")", "").split(",");

		int hexValue1 = Integer.parseInt(hexValue[0]);
		hexValue[1] = hexValue[1].trim();
		int hexValue2 = Integer.parseInt(hexValue[1]);
		hexValue[2] = hexValue[2].trim();
		int hexValue3 = Integer.parseInt(hexValue[2]);

		actualHexValueColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);

		System.out.println(actualHexValueColor);

		return actualHexValueColor;

	}

	


   }
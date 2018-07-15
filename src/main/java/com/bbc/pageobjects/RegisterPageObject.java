/***********************************************************************************************************************************************************************************
* @author : Lakshmi 
* @Description: Page Object class holding all REGISTER Page WebElements and it's Methods.
***********************************************************************************************************************************************************************************/

package com.bbc.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.bbc.base.TestBase;
import com.bbc.helper.JavascriptHelper;
import com.bbc.helper.WaitHelper;
import com.bbc.helper.XpathHelper;

public class RegisterPageObject extends TestBase {

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'13 or over')]")
	public WebElement ageElement;

	@FindBy(how = How.CSS, using = "input[id = day-input]")
	public WebElement dayInputElement;

	@FindBy(how = How.CSS, using = "input[id = month-input]")
	public WebElement monthInputElement;

	@FindBy(how = How.CSS, using = "input[id = year-input]")
	public WebElement yearInputElement;

	@FindBy(how = How.NAME, using = "email")
	public WebElement emailElement;

	@FindBy(how = How.CSS, using = "input[id = password-input]")
	public WebElement passwordElement;

	@FindBy(how = How.CSS, using = "input[id = postcode-input]")
	public WebElement postcodeElement;

	@FindBy(how = How.CSS, using = "input[id = gender-input]")
	public WebElement genderElement;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Yes please')]")
	public WebElement emailupdElement;

	@FindBy(how = How.XPATH, using = "//button[contains(@id,'submit-button')]")
	public WebElement registerElement;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Continue')]")
	public WebElement continueElement;

	public RegisterPageObject() {
		PageFactory.initElements(driver, this);
	}

	public void clickRegister() {
		
		driver.switchTo().frame("bbc-blogs-comments-iframe");
		log.info("Switching to Comments Frame");

		WebElement doRegisterElt = WaitHelper
				.clickWhenReady(XpathHelper.findByXPath("//a[contains(text(),'Register')]"), 5);
		JavascriptHelper.flash(doRegisterElt);
		doRegisterElt.click();
		log.info("Clicking Register");

		driver.switchTo().defaultContent();
		log.info("Switching default Content");

	}

	public void registerPageTitle() {
		String registerTitle = driver.getTitle();
		log.info("Retrieving Register Page Title");
		Assert.assertEquals("BBC – Register", registerTitle);
		log.info("Asserting Register Page Title");
		
		
	}

	public void ageSelection() {
		WebElement ageElt = WaitHelper.clickWhenReady(ageElement, 5);
		JavascriptHelper.flash(ageElt);
		ageElt.click();
		log.info("Selecting appropriate age for Registration purpose");
	}

	public void registration(String dayText, String monthText, String yearText, String emailText, String passwordText,
			String postcodeText, String genderText) {

		WebElement dayInputElt = WaitHelper.waitUntilVisible(dayInputElement, 5);
		log.info("Entering date - day value ");
		JavascriptHelper.flash(dayInputElt);
		dayInputElt.clear();
		dayInputElt.sendKeys(dayText);

		WebElement monthInputElt = WaitHelper.waitUntilVisible(monthInputElement, 5);
		log.info("Entering date - Month value ");
		JavascriptHelper.flash(monthInputElt);
		monthInputElt.clear();
		monthInputElt.sendKeys(monthText);

		WebElement yearInputElt = WaitHelper.waitUntilVisible(yearInputElement, 5);
		log.info("Entering date - Year value ");
		JavascriptHelper.flash(yearInputElt);
		yearInputElt.clear();
		yearInputElt.sendKeys(yearText);

		WebElement continueElt = WaitHelper.clickWhenReady(continueElement, 5);
		JavascriptHelper.flash(continueElt);
		continueElt.click();

		WebElement emailElt = WaitHelper.clickWhenReady(emailElement, 5);
		log.info("Entering Email address");
		JavascriptHelper.flash(emailElt);
		emailElt.clear();
		emailElt.sendKeys(emailText);

		WebElement passwordElt = WaitHelper.clickWhenReady(passwordElement, 5);
		log.info("Entering Password");
		JavascriptHelper.flash(passwordElt);
		passwordElt.clear();
		passwordElt.sendKeys(passwordText);

		WebElement postcodeElt = WaitHelper.clickWhenReady(postcodeElement, 5);
		log.info("Entering Postcode");
		JavascriptHelper.flash(postcodeElt);
		postcodeElt.clear();
		postcodeElt.sendKeys(postcodeText);

		WebElement genderElt = WaitHelper.waitUntilVisible(XpathHelper.safeFindWebElementById("gender-input"), 5);
		log.info("Entering Gender");
		Select select = new Select(genderElt);
		select.selectByVisibleText(genderText);

		WebElement emailupdElt = WaitHelper.clickWhenReady(emailupdElement, 5);
		log.info("Selecting Email Updates Options");
		JavascriptHelper.flash(emailupdElt);
		emailupdElt.click();

		WebElement registerElt = WaitHelper.clickWhenReady(registerElement, 5);
		JavascriptHelper.flash(registerElt);
		log.info("Register with the email details");
		registerElt.submit();

	}

	public void verifyRegistration() 
	{
		String registerTitle = driver.getTitle();
		log.info("Verifying Whether the Registration is successful or not");
		if(driver.getTitle().equalsIgnoreCase("BBC – Register – thank you") == true)
		{
			log.info("BBC Registration is Successful : " + driver.getTitle());
		}
		else
		{
			log.error("Something Went Wrong - Registration UnSuccessful : " + driver.getTitle());
		}
		Assert.assertEquals("BBC – Register – thank you", registerTitle);
		
		WebElement continueElt = WaitHelper.clickWhenReady(XpathHelper.findSpanWithText("Continue"), 5);
		JavascriptHelper.flash(continueElt);
		continueElt.click();
		
		WebElement dNameElt = WaitHelper.waitUntilVisible(XpathHelper.safeFindWebElementById("displayName-input"), 5);
		dNameElt.clear();
		log.info("Entering Display Name");
		dNameElt.sendKeys("Test");
			
		WebElement submitContinueElt = WaitHelper.clickWhenReady(continueElement, 5);
		JavascriptHelper.flash(submitContinueElt);
		log.info("Submitting Display Name");
		submitContinueElt.submit();
		
		WebElement verifyEmailElt = WaitHelper.clickWhenReady(XpathHelper.findSpanWithText("Continue"), 5);
		JavascriptHelper.flash(verifyEmailElt);
		verifyEmailElt.click();
		
		WebElement aboutBBCElt = WaitHelper.clickWhenReady(XpathHelper.findSpanWithText("About the BBC Blog"), 5);
		JavascriptHelper.flash(aboutBBCElt);
		
		
		}
		
	 }

     

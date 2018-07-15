/***********************************************************************************************************************************************************************************
* @author : Lakshmi 
* @Description: Page Object class holding all Sign In Page WebElements and it's Methods.
***********************************************************************************************************************************************************************************/

package com.bbc.pageobjects;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.bbc.base.TestBase;
import com.bbc.helper.JavascriptHelper;
import com.bbc.helper.WaitHelper;
import com.bbc.helper.XpathHelper;

public class SignInPageObject extends TestBase {

	@FindBy(how = How.ID, using = "user-identifier-input")
	public WebElement usernameElement;

	@FindBy(how = How.ID, using = "password-input")
	public WebElement passwordElement;

	@FindBy(how = How.ID, using = "displayName-input")
	public WebElement displayNameElement;

	@FindBy(how = How.ID, using = "submit-button")
	public WebElement continueElement;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'No thanks')]")
	public WebElement surveyElt;

	String dnameText = "LA";

	public SignInPageObject() {
		PageFactory.initElements(driver, this);

	}

	public void clickSignin() {
		driver.switchTo().frame("bbc-blogs-comments-iframe");
		log.info("Switching to Comments Frame to click Sign In button");

		WebElement clickSignInElt = WaitHelper
				.clickWhenReady(XpathHelper.findByXPath("//a[contains(text(),'Sign in')]"), 5);
		JavascriptHelper.flash(clickSignInElt);
		log.info("Clicking BBC-SignIn button");
		clickSignInElt.click();

		driver.switchTo().defaultContent();
	}

	public void validateSignInPageTitle() {
		String signInPageTitle = driver.getTitle();
		log.info("Verifying BBC Sign In Page Title");
		Assert.assertEquals("BBC – Sign in", signInPageTitle);
	}

	public void signin(String unameText, String passwordText) {

		WebElement usernameElt = WaitHelper.waitUntilVisible(usernameElement, 5);
		JavascriptHelper.flash(usernameElt);
		usernameElt.clear();
		log.info("Sign In - Entering Username");
		usernameElt.sendKeys(unameText);

		WebElement passwordElt = WaitHelper.waitUntilVisible(passwordElement, 5);
		JavascriptHelper.flash(passwordElt);
		passwordElt.clear();
		log.info("Sign In - Entering Password");
		passwordElt.sendKeys(passwordText);

		WebElement clickSignInElt = WaitHelper
				.clickWhenReady(XpathHelper.findByXPath("//button[contains(@id,'submit-button')]"), 5);
		JavascriptHelper.flash(clickSignInElt);
		log.info("Clicking SignIn button for Login");
		clickSignInElt.submit();
		

		if (!isSignInSuccessful()) {
			if (isDisplayNameExists()) {
				System.out.println("true");
				WebElement dNameElt = WaitHelper.waitUntilVisible(displayNameElement, 5);
				dNameElt.clear();
				log.info("Entering Display Name");
				dNameElt.sendKeys(dnameText);

				WebElement continueElt = WaitHelper.clickWhenReady(continueElement, 5);
				JavascriptHelper.flash(continueElt);
				log.info("Submitting Display Name");
				continueElt.submit();

			}

		}

	  WebElement commentElt = WaitHelper.clickWhenReady(XpathHelper.findByXPath("//h1[contains(text(),'Lorem Ipsum dolar mit')]/following::a[@class='blogs-comments-link']"),
				5);

		JavascriptHelper.flash(commentElt);
		commentElt.click();
		log.info("Clicking Comments");

	}

	public boolean isSignInSuccessful() {
		if (driver.getTitle().equalsIgnoreCase("BBC Blogs - Test Blog - Lorem Ipsum dolar mit") == true) {
			log.info("BBC SignIn Process is Successful : " + driver.getTitle());
			return true;
		} else {
			log.error("Something Went Wrong - SignIn UnSuccessful : " + driver.getTitle());
			return false;
		}

	}

	public boolean isDisplayNameExists() {
		try {
			WebElement displayNameElt = WaitHelper
					.waitUntilVisible(XpathHelper.safeFindWebElementById("displayName-input"), 5);
			return true;
		} catch (NotFoundException e) {
			return false;
		}
	}

}

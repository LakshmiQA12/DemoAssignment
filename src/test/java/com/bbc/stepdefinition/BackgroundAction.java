/***********************************************************************************************************************************************************************************
* @author : Lakshmi 
* @Description: Background Action class holding Step Definitions for Background Common Steps  .
***********************************************************************************************************************************************************************************/

package com.bbc.stepdefinition;

import org.openqa.selenium.WebElement;
import com.bbc.base.TestBase;
import com.bbc.helper.JavascriptHelper;
import com.bbc.helper.WaitHelper;
import com.bbc.helper.XpathHelper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class BackgroundAction {
	@Given("^:  User is navigated to BBC News Articles Comments Page$")
	public void user_is_navigated_to_BBC_News_Articles_Comments_Page() throws Throwable {
		TestBase.setupBrowser();
	}

	@Then("^: User clicks on Comments$")
	public void user_clicks_on_Comments() throws Throwable {
		WebElement clickCommentElt = WaitHelper
				.clickWhenReady(XpathHelper.findByXPath("//a[contains(@class,'blogs-comments-link')]"), 5);
		JavascriptHelper.flash(clickCommentElt);
		clickCommentElt.click();
		

	}
}

/***********************************************************************************************************************************************************************************
* @author : Lakshmi 
* @Description: Page Object class holding all COMMENTS page WebElements and it's Methods.
***********************************************************************************************************************************************************************************/

package com.bbc.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.bbc.base.TestBase;
import com.bbc.helper.JavascriptHelper;
import com.bbc.helper.WaitHelper;
import com.bbc.helper.XpathHelper;

public class CommentsPageObject extends TestBase {

	@FindBy(how = How.XPATH, using = "//a[contains(@class ,'blogs-comments-link')]")
	public WebElement commentElement;

	@FindBy(how = How.NAME, using = "comment")
	public WebElement addcommentElement;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Sign out')]")
	public WebElement signOutElement;

	public CommentsPageObject() {
		PageFactory.initElements(driver, this);

	}

	public void postComments() {

		driver.switchTo().frame("bbc-blogs-comments-iframe");

		WebElement addCommentElt = WaitHelper.waitUntilVisible(addcommentElement, 5);
		JavascriptHelper.flash(addCommentElt);
		addCommentElt.clear();
		addCommentElt.sendKeys("Adding Comments via automation by LA");
		log.info("Adding Comments in the article");

		WebElement postCommentElt = WaitHelper
				.clickWhenReady(XpathHelper.findByXPath("//input[contains(@class,'cmts-submit cmts-button')]"), 5);
		JavascriptHelper.flash(postCommentElt);
		postCommentElt.click();
		log.info("Clicking Post Comment");

		driver.switchTo().defaultContent();
		}

	public void signOut() {
		

		driver.switchTo().frame("bbc-blogs-comments-iframe");
		
		WebElement signOutElt = WaitHelper.clickWhenReady(signOutElement, 5);
		JavascriptHelper.flash(signOutElt);
		signOutElt.click();
		log.info("Clicking Signout");
		
		driver.switchTo().defaultContent();
		
		

	}
}

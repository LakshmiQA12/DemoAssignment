/***********************************************************************************************************************************************************************************
* @author : Lakshmi 
* @Description: A class holding StepDefinitions for all the steps of SignInAndCommentArticle Feature .
***********************************************************************************************************************************************************************************/

package com.bbc.stepdefinition;

import java.util.Map;
import com.bbc.base.TestBase;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignInCommentArticleStepDefn {
	@Given("^: User clicks Sign In on BBC News Articles Comments Page$")
	public void user_clicks_Sign_In_on_BBC_News_Articles_Comments_Page() throws Throwable
	{
		TestBase.signinPage.clickSignin();   
	}

	@When("^: User is in SignIn Page and validates Sign In page title$")
	public void user_is_in_SignIn_Page_and_validates_Sign_In_page_title() throws Throwable 
	{
		TestBase.signinPage.validateSignInPageTitle();   
	}

	@Then("^: User doing the Sign in process with Valid Email Id$")
	public void user_doing_the_Sign_in_process_with_Valid_Email_Id(DataTable signInTable) throws Throwable 
	{
		for(Map<String, String> signinData : signInTable.asMaps(String.class, String.class ))
		{
	    TestBase.signinPage.signin(signinData.get("Username") ,signinData.get("Password"));
		}
	}
	
	@Then("^: User is posting comments for an article$")
	public void user_is_posting_comments_for_an_article() throws Throwable 
	{
		TestBase.commentsPage.postComments();
	   
	}
	
	@Then("^: SignOut$")
	public void signout() throws Throwable
	{
		TestBase.commentsPage.signOut();
	}


}

/***********************************************************************************************************************************************************************************
* @author : Lakshmi 
* @Description: A class holding StepDefinitions for all the steps of RegisterBBC Feature .
***********************************************************************************************************************************************************************************/

package com.bbc.stepdefinition;

import java.util.Map;
import com.bbc.base.TestBase;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterBBCStepDefn {

	@Given("^: User clicks Register in BBC News Articles Comments Page$")
	public void user_clicks_Register_in_BBC_News_Articles_Comments_Page() throws Throwable {
		TestBase.registrationPage.clickRegister();
	}

	@When("^: User is in Registration Page$")
	public void user_is_in_Registration_Page() throws Throwable {
		TestBase.registrationPage.registerPageTitle();
	}

	@Then("^: User clicks the appropriate age selection$")
	public void user_clicks_the_appropriate_age_selection() throws Throwable {
		TestBase.registrationPage.ageSelection();
	}

	@Then("^:  User starts the Registration process$")
	public void user_starts_the_Registration_process(DataTable dobtable) throws Throwable {
		for (Map<String, String> dobdata : dobtable.asMaps(String.class, String.class))
		{
			TestBase.registrationPage.registration(dobdata.get("Day"), dobdata.get("Month"), dobdata.get("Year"),
					dobdata.get("Email"), dobdata.get("Password"), dobdata.get("Postcode"), dobdata.get("Gender"));
		}

		/** Verifying Registration successful or not **/
		TestBase.registrationPage.verifyRegistration();

	}
	
	

}

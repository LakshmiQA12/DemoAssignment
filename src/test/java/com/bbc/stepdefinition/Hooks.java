/***********************************************************************************************************************************************************************************
* @author : Lakshmi 
* @Description: Hooks class which will be called before and after executing each scenario .
***********************************************************************************************************************************************************************************/

package com.bbc.stepdefinition;

import java.io.IOException;
import com.bbc.base.TestBase;
import com.bbc.util.CommonUtility;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import gherkin.formatter.model.Feature;

public class Hooks {

	String fileName;
	Feature feature;

	@Before()
	public void beforeScenario(Scenario scenario) throws IOException {

		System.out.println("**Execution of Feature File Started**");
		System.out.println("Executing Scenario:" + scenario.getName());
		System.out.println(scenario.getClass());

	}

	@After()
	public void afterScenario(Scenario scenario) throws IOException {

		fileName = scenario.getName();

		System.out.println("Finished Scenario:" + scenario.getName());
		scenario.write("Finished Scenario");

		if (scenario.isFailed()) {

			CommonUtility.takeFailedScreenshot(fileName);

		} else {

			CommonUtility.takeScreenshot(fileName);

		}

		TestBase.driver.quit();
	}

}

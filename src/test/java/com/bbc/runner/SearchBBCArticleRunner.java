/***********************************************************************************************************************************************************************************
* @author : Lakshmi 
* @Description: Runner class for SearchArticle feature .(@Manual)
***********************************************************************************************************************************************************************************/

package com.bbc.runner;

import java.io.File;
import org.testng.annotations.AfterClass;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "src//main//java//com//bbc//features//SearchArticle.feature" }, 
                 glue = {"com.bbc.stepdefinition" }, 
                 plugin = { "pretty", "json:target/SearchBBC.json",
				            "html:target/site/cucumber-pretty/SearchBBC.html",
				            "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/ExtentReport.html" }, 
                 monochrome = true, strict = true, dryRun = true)

public class SearchBBCArticleRunner extends AbstractTestNGCucumberTests {

	@AfterClass
	public static void setup() {

		Reporter.loadXMLConfig(new File("src//test//resources//extent-config.xml"));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setTestRunnerOutput("Cucumber Test Runner");

	}
}
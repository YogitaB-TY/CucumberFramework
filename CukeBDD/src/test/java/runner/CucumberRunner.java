package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {".\\src\\test\\java\\features\\DemoWebShopHome.feature"},
		glue = {"stepdefinitions","hook"},
		dryRun = false,
		monochrome = true,
		plugin = {"pretty",
				"html:reports\\cucumberreports.html",
				"json:reports\\cucumberjson.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
	//	tags="@SmokeTest") //@SmokeTest and @Regression-> It will execute only Scenario having both tags
		//@SmokeTest or @RegressionTest-> either smoke or regression
		//not @SmokeTest-> exclude the tag
		
public class CucumberRunner extends AbstractTestNGCucumberTests{
/*
 * Extent report documentation: https://www.toolsqa.com/extent-report/extent-report-for-cucumber-testng-project/
 */
}

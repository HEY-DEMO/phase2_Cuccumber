package cucumber.testrunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;




@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/starHealth.feature", 
	glue = {"cucumber/stepdefinitions"},
	plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/html/ExtentReport.html"})
public class starhealth_testrunner {
}



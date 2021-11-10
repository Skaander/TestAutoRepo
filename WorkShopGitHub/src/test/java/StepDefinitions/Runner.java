package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(monochrome = true, features = "src/test/resources/CreateAmazonAccount.feature", glue = {
		"StepDefinitions" }, plugin = { "pretty", "html:target/test-report", "json:target/test-report.json",
				"json:target/cucumber-report.json", "junit:target/test-report.xml" }

)

public class Runner {

}

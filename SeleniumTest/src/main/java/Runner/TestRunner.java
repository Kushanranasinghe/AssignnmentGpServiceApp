package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	
		
		features = {"src/main/java/Features"},
	//	glue = {"com.cucumber.stepdefinitions"}, monochrome = true,
		glue = {"stepdefs"},monochrome = true,//Your step definitions package.
		tags = "@UserApoinment"
		)

public class TestRunner extends AbstractTestNGCucumberTests{

}
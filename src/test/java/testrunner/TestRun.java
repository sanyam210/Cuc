package testrunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;


import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= {"src\\test\\java\\features"},
		glue={"stepdefinitions"},
		dryRun= false,
		monochrome= true
		)

public class TestRun extends AbstractTestNGCucumberTests {
		@Override 
		@DataProvider(parallel = true)
		public Object[][] scenarios() {
		return super.scenarios();
		    }
}


	

package com.test.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/features/AddProduct.feature" }, plugin = { "pretty",
		"json:target/json-report/cucumber.json",
//		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" 
},
		// tags={"@smoke"},
		glue = { "stepDefinitions" }, monochrome = false)

public class TestRunner extends AbstractTestNGCucumberTests {
//	   @Override
//	    @DataProvider(parallel = true)
//	    public Object[][] scenarios() {
//	        return super.scenarios();
//	    }
}

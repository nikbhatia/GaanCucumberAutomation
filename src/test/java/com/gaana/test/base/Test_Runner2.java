package com.gaana.test.base;

import org.testng.annotations.AfterClass;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = { "@rerun/failed_scenarios.txt" }, tags = "@Gaana", glue = {
		"com.gaana.stepdefinitions","com.gaana.test.base" }, plugin = { "pretty",
				"json:target/cucumber-reports/Cucumber2.json","rerun:rerun/failed_scenarios2.txt" }, monochrome = true)

public class Test_Runner2 extends AbstractTestNGCucumberTests {
	
	@AfterClass
	public void test() {
		Test_Runner.retry_flag++;
	}
	
}
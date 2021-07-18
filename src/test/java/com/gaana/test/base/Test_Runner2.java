package com.gaana.test.base;

import org.testng.annotations.BeforeTest;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = { "@rerun/failed_scenarios.txt" }, tags = "@Gaana", glue = {
		"com.gaana.stepdefinitions","com.gaana.test.base" }, plugin = { "pretty",
				"html:target/cucumber-reports/cucumber.html", "json:target/cucumber-reports/Cucumber2.json" }, monochrome = true)

public class Test_Runner2 extends AbstractTestNGCucumberTests {
	
	
	
}
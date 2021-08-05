package com.gaana.test.base;

import org.testng.annotations.BeforeTest;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = { "@rerun/failed_scenarios2.txt" }, tags = "@Gaana", glue = {
		"com.gaana.stepdefinitions","com.gaana.test.base" }, plugin = { "pretty",
				"json:target/cucumber-reports/Cucumber3.json" }, monochrome = true)

public class Test_Runner3 extends AbstractTestNGCucumberTests {
	
	
	
}
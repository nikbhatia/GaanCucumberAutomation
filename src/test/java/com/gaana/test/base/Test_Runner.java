package com.gaana.test.base;

import java.io.File;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "src/test/java/com/gaana/features/Login" }, tags = "@Gaana", glue = {
		"com.gaana.stepdefinitions","com.gaana.test.base" }, plugin = { "pretty",
				"html:target/cucumber-reports/cucumber.html", "json:target/cucumber-reports/Cucumber.json" }, monochrome = true)

public class Test_Runner extends AbstractTestNGCucumberTests {
	
	private static SessionInitiator session;

	@BeforeSuite
	public void start() {
		File file = new File(DriverInitiator.networkInfoCSVPath);
		if (file.exists())
			file.delete();
	}

	@AfterSuite
	public void tearDown() {

	}

	@Before(timeout = 0)
	public void initTest(Scenario scenario) {
		session = SessionInitiator.getInstance();
		session.initializeSession(scenario);
	}

	@After(timeout = 0)
	public void tearDown(Scenario scenario) {
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("Scenario: " + scenario.getName() + " [" + scenario.getStatus() + "]");
		System.out.println("------------------------------------------------------------------------------------");
		if (scenario.isFailed()) {
			session.takeScreenshot(scenario);
		}
		session.closeSession(scenario);
	}
}
package com.gaana.test.base;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = { "src/test/java/com/gaana/features" }, tags = "@Gaana", glue = {
		"com.gaana.stepdefinitions","com.gaana.test.base" }, plugin = { "pretty",
				"html:target/cucumber-reports/cucumber.html", "json:target/cucumber-reports/Cucumber.json","rerun:rerun/failed_scenarios.txt" }, monochrome = true)

public class Test_Runner extends AbstractTestNGCucumberTests {
	
	private static SessionInitiator session;
	
	EmailableReport er=new EmailableReport();
	public static int totalScenarioCount,passedScenarioCount,failedScenarioCount,scenarioNumber;
	public static StringBuilder subject;
	public static String startDate,endDate,totalTime;
	public static int retry_flag;
	
	
	@BeforeSuite
	public void start() {
		File file = new File(DriverInitiator.networkInfoCSVPath);
		if (file.exists())
			file.delete();
		subject = new StringBuilder();
		subject.append("");
		totalScenarioCount=0;passedScenarioCount=0;failedScenarioCount=0;scenarioNumber=0;retry_flag=0;
		try {
			EmailableReport.out = er.createWriter(System.getProperty("user.dir"));
		} catch (IOException e) {
			System.out.println("file is not generated");
			return;
		}
		startDate=er.startTime();
	}

	@AfterSuite
	public void tearDown() throws IOException {
		
		endDate=er.endTime();		
		totalTime = er.totalTime();
		
		er.startHtml(EmailableReport.out);
		
		er.startResultSummaryTable("testOverview");
		er.updateResultSummaryTable();
		
		er.startScenarioSummaryTable("methodOverview");
		EmailableReport.out.println(subject);
		
		er.endHtml(EmailableReport.out);
		EmailableReport.out.flush();
		EmailableReport.out.close();
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
		if(subject==null){
			subject = new StringBuilder();
		}
		
		if(!(scenario.isFailed() && retry_flag==0)) {
			scenarioNumber++;totalScenarioCount++;
			
			subject.append("<tr><td>")
		       .append(scenarioNumber)
		       .append("</td><td>")
		       .append(scenario.getName())
		       .append("</td><td>")
		       .append(scenario.getStatus())
		       .append("</td></tr>");
			
			if(scenario.isFailed())
				failedScenarioCount++;
			else
				passedScenarioCount++;
		}
		
		if (scenario.isFailed()) {
			session.takeScreenshot(scenario);
		}
		session.closeSession(scenario);
	}
	
	@AfterClass
	public void test() {
		retry_flag=1;
	}
}
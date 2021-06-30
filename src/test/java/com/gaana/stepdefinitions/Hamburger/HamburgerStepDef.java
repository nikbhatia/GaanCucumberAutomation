package com.gaana.stepdefinitions.Hamburger;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.gaana.automation.util.GenericClassMethod;
import com.gaana.automation.util.GenericMethod;
import com.gaana.automation.util.TestNGLogUtility;
import com.gaana.automation.util.URLBuilder;
import com.gaana.pageobjects.Hamburger.HamburgerPO;
import com.gaana.pageobjects.Login.LoginPO;
import com.gaana.test.base.BaseAutomation;
import com.gaana.test.base.PageObjectWrapper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HamburgerStepDef {

	HamburgerPO hamburgerPO = (HamburgerPO) PageObjectWrapper.getObject(HamburgerPO.class);
	GenericMethod generic = new GenericMethod();
	GenericClassMethod genericClass = new GenericClassMethod();
	
	@Then("user clicks on Hamburger icon")
	public void user_click_on_Hamburger_icon() {
		hamburgerPO.clickOnHamburgerIcon();
	}
	
	@Then("user verifies the hamburger list of options {string}")
	public void user_verifies_the_hamburger_list_options(String options) {
	    
		assertTrue(hamburgerPO.validateHamburgerLOV(options), "Hamburger list of options are not as expected..");
	
	}
	
	@Then("user verifies that {string} button is displayed")
	public void user_verifies_that_button_is_displayed(String string) {
		
		assertTrue(hamburgerPO.validateNightModeButton(string), "Night Mode button isn't displayed");
		
	}
	
}

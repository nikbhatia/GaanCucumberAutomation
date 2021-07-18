package com.gaana.stepdefinitions.Ads;

import static org.testng.Assert.assertTrue;

import com.gaana.pageobjects.Ads.AdsPO;
import com.gaana.test.base.PageObjectWrapper;

import cucumber.api.java.en.Then;

public class AdsStepDef {
	
	AdsPO adsPO = (AdsPO) PageObjectWrapper.getObject(AdsPO.class);
	
	
	@Then("user verifies that advertisements are displayed on {string}")
	public void user_verifies_that_advertisements_are_displayed_on(String string) {
		
		assertTrue(adsPO.validatePresenceAdvertisements(), "Advertisements are not displayed on "+string);
		
	}
	
	@Then("user verifies that advertisements are not displayed on {string}")
	public void user_verifies_that_advertisements_are_not_displayed_on(String string) {
		
		assertTrue(adsPO.validateAbsenceAdvertisements(), "Advertisements are displayed on "+string);
		
	}
	
}

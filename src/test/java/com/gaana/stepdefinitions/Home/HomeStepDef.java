package com.gaana.stepdefinitions.Home;

import static org.testng.Assert.assertTrue;

import com.gaana.automation.util.GenericClassMethod;
import com.gaana.automation.util.GenericMethod;
import com.gaana.pageobjects.Home.HomePO;
import com.gaana.pageobjects.Login.LoginPO;
import com.gaana.test.base.PageObjectWrapper;

import cucumber.api.java.en.Then;

public class HomeStepDef {
	
	HomePO homePO = (HomePO) PageObjectWrapper.getObject(HomePO.class);
	GenericMethod generic = new GenericMethod();
	GenericClassMethod genericClass = new GenericClassMethod();
	LoginPO loginPO = (LoginPO) PageObjectWrapper.getObject(LoginPO.class);
	
	
	@Then("user verifies the menu list options {string}")
	public void user_verifies_the_menu_list_options(String options) {
		
		assertTrue(homePO.validateHomeMenuList(options), "Menu list on home page doesn't have values ordered as "+options);
	
	}
	
	@Then("user verifies the Quicklinks {string}")
	public void user_verifies_the_Quicklinks(String options) {
		
		assertTrue(homePO.validateQuickLinks(options), "Quicklinks on home page are not in order as "+options);
		
	}
	
	@Then("user verifies {string} text is displayed on the footer")
	public void user_verifies_text_is_displayed_on_the_footer(String string) {
		assertTrue(homePO.validatePresenceFooterText(string), "Footer text "+string+" is not displayed..");
    	
	}

	@Then("user verifies that Facebook and Twitter icons are displayed")
	public void user_verifies_that_Facebook_and_Twitter_icons_are_displayed() {
		assertTrue(homePO.validatePresenceFooterIcons(), "FB/Twitter icons are not displayed");
    	
	}

	@Then("user verifies the footer links {string}")
	public void user_verifies_the_footer_links(String options) {
		assertTrue(homePO.validateFooterLinks(options), "Footer links on home page are not in order as "+options);
		
	}
	
	@Then("user verifies the options under user icon {string}")
	public void user_verifies_the_options_under_user_icon(String options) {
		assertTrue(homePO.validateUserIconOptions(options), "Options under user icon are not in order as "+options);
		
	}
	
	@Then("user clicks on user icon")
	public void user_clicks_on_user_icon() throws InterruptedException {
	    loginPO.clickOnLoginImg();
	}
	
	@Then("user verifies the Gaana logo is displayed on home page")
	public void user_verifies_the_Gaana_logo_is_displayed_on_home_page() {
		assertTrue(homePO.validatePresenceGaanaLogo(), "Gaana logo is not displayed on home page");
		
	}

	@Then("user verifies the {string} button on the home page")
	public void user_verifies_the_button_on_the_home_page(String string) {
		assertTrue(homePO.validateSubscriptionButton(string), string+" button is not displayed on the home page.");
		
	}

	@Then("user verifies the {string} {string} buttons on the home page")
	public void user_verifies_the_buttons_on_the_home_page(String string, String string2) {
		assertTrue(homePO.validateSubscriptionButton(string,string2), string+" or "+string2+" button is not displayed on the home page.");
		
	}

	@Then("user verifies the language icon on the home page")
	public void user_verifies_the_language_icon_on_the_home_page() {
		assertTrue(homePO.validatePresenceLanguageIcon(), "Language icon is not displayed on home page");
		
	}

	@Then("user verifies the theme icon on the home page")
	public void user_verifies_the_theme_icon_on_the_home_page() {
		assertTrue(homePO.validatePresenceThemeIcon(), "Theme change icon is not displayed on home page");
		
	}

	@Then("user verifies the carousel banner on the home page")
	public void user_verifies_the_carousel_banner_on_the_home_page() {
		assertTrue(homePO.validatePresencecarouselbanner(), "Carousel banner is not displayed on home page");
		
	}

}

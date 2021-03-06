package com.gaana.stepdefinitions.Login;

import cucumber.api.java.en.And;
import org.apache.kafka.common.protocol.types.Field;
import org.testng.Assert;

import com.gaana.automation.util.GenericClassMethod;
import com.gaana.automation.util.GenericMethod;
import com.gaana.automation.util.TestNGLogUtility;
import com.gaana.automation.util.URLBuilder;
import com.gaana.pageobjects.Login.LoginPO;
import com.gaana.test.base.PageObjectWrapper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginStepDef {

	LoginPO loginPO = (LoginPO) PageObjectWrapper.getObject(LoginPO.class);
	GenericMethod generic = new GenericMethod();
	GenericClassMethod genericClass = new GenericClassMethod();
	public static String loginType;

	@Given("user opens the application {string}")
	public void user_opens_the_application(String string) throws InterruptedException {
		 loginPO.navigateToUrl(URLBuilder.getURL(string));
		 Thread.sleep(10000);
	}

	@Then("user logins with {string}")
	public void user_logins_with(String string) throws InterruptedException {
		Thread.sleep(1000);
		loginType = string;
		loginPO.loginCredentials(loginType);
		loginPO.clickOnSignIn();
		loginPO.login_UserGaana(loginType);
	}

	@Given("verifies the user login profile")
	public void verifies_the_user_login_profile() throws InterruptedException {
		Assert.assertTrue(loginPO.getUserName().contains(loginPO.UserName));
		loginPO.clickOnGaanaLogo();
		//TestNGLogUtility.info("Hello");
	}

	@Then("user logouts the app")
	public void user_logouts_the_app() throws InterruptedException {
		Assert.assertTrue(loginPO.LogOut());
	}

	@Then("user validates {string} with value {string}")
	public void validate_androidTv_PageLoad(String label, String value){
           Assert.assertTrue(loginPO.validatePresenceOfElementsOnLoginScreen(label,value));
	}

	@And("user logged in with {string}")
	public void userLogin(String loginType){
		Assert.assertTrue(loginPO.verifyAndroidTvLogin(loginType));
	}



}

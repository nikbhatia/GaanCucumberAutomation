package com.gaana.pageobjects;

import org.openqa.selenium.By;

import com.gaana.automation.util.GenericMethod;
import com.gaana.automation.util.TestNGLogUtility;
import com.gaana.automation.util.YamlReader;
import com.gaana.stepdefinitions.LoginStepDef;
import com.gaana.test.base.BaseAutomation;

public class LoginPO extends BaseAutomation {

	GenericMethod generic = new GenericMethod();

	private By signInBtn = By.xpath("//button[contains(text(),'Log In / Sign Up')]");
	private By loginPopup = By.xpath("//strong[@class='title' and text()='Login/Signup']");

	private By fbLink = By.xpath("//button[contains(text(),'Login with Facebook')]");
	private By fbEmailTxtbox = By.xpath("(//input[@id='email'])[1]");
	private By fbPassTxtbox = By.id("pass");
	private By fbLoginBtn = By.xpath("//input[@name='login']");

	private By googleLink = By.xpath("//button[contains(text(),'Login with Google')]");
	private By gmailTxtbox = By.xpath("//input[@type='email']");
	private By nextBtn = By.xpath("//span[contains(text(),'Next')]");
	private By gmailPasswordTxtbox = By.xpath("//input[@type='password']");

	private By txtEmail = By.xpath("//div[@class='login-input ']//input[@type='text']");
	private By emailPassTxtbox = By.xpath("//input[@type='password']");
	private By emailContinueBtn = By.xpath("//button[@type='submit']");

	private By loginImg = By.xpath("//button[contains(@class,'user_ic')]");
	private By profileLink = By.xpath("//a[contains(@href,'profile')]//span");

	public static By userNameText = By.xpath("//div[contains(@class,'info')]//strong");
	private By logoutBtn = By.xpath("//span[contains(text(),'Log Out')]");
	
	private By gaanaLogo = By.xpath("//header//a[contains(@class,'logo')]");

	public String Email, Password, UserName;
	String parentWinHandle = null;

	public void navigateToUrl(String url) {
		System.out.println("env url is " + url);
		goToPageURL(url);
		wait.waitForPageToLoadCompletely();
		TestNGLogUtility.info(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	}

	public void loginCredentials(String s) {
		this.Email = YamlReader.getAppConfigValue("Users." + s + ".Email");
		this.Password = YamlReader.getAppConfigValue("Users." + s + ".Password");
		this.UserName = YamlReader.getAppConfigValue("Users." + s + ".UserName");
	}

	public String verifyPageTitle() {
		return driver.getTitle();
	}

	public void clickOnSignIn() {
		generic.click(signInBtn);
	}

	public void clickOnEmailTxtBox(String emailId) {
		generic.EnterText(gmailTxtbox, emailId);
	}

	public void clickOnNextBtn() {
		generic.click(nextBtn);
	}

	public void clickOnFbLogin() throws InterruptedException {
		generic.click(fbLink);
	}

	public void EnterFbEmail(String fbID) {
		generic.EnterText(fbEmailTxtbox, fbID);
	}

	public void EnterFbPassword(String pass) {
		generic.EnterText(fbPassTxtbox, pass);
	}

	public void clickOnFbLoginBtn() {
		generic.click(fbLoginBtn);
	}

	public void clickOnLoginImg() throws InterruptedException {
		try {
			generic.click(loginImg);
		} catch (Exception e) {
			Thread.sleep(2000);
			generic.click(loginImg);
		}

	}
	
	public void clickOnGaanaLogo() throws InterruptedException {
		try {
			generic.click(gaanaLogo);
		} catch (Exception e) {
			Thread.sleep(2000);
			generic.click(gaanaLogo);
		}

	}

	public void clickOnProfileLink() throws InterruptedException {
		Thread.sleep(1500);
		generic.JSClick(profileLink);
	}

	public String getUserName() throws InterruptedException {
		// Thread.sleep(2000);
		clickOnLoginImg();
		clickOnProfileLink();
		return generic.getText(userNameText);
	}

	public void enterEmailId(String emailId) {
		try {
			// Thread.sleep(5000);
			generic.customWaitFor_visibility(txtEmail, 5);
			driver.findElement(txtEmail).clear();
			driver.findElement(txtEmail).sendKeys(emailId);
		} catch (Exception e) {
			System.out.println("enterEmailTxtbox exception");
			generic.EnterText(txtEmail, emailId);
		}

	}

	public void enterEmailPassword(String emailPass) throws InterruptedException {
		try {
			generic.EnterText(emailPassTxtbox, emailPass);
		} catch (Exception e) {
			/*
			 * generic.click(By.xpath("//div[@class='bodyloader']")); Thread.sleep(1000);
			 * clickonAeroLink(); generic.EnterText(emailPassTxtbox, emailPass);
			 */

		}

	}

	public void clickOnEmailContinue() {
		generic.click(emailContinueBtn);
	}

	public void clickOnGoogleLogin() throws InterruptedException {
		generic.click(googleLink);
	}

	public void EnterGmailEmail(String gmailID) {
		generic.EnterText(gmailTxtbox, gmailID);
	}

	public void EnterGmailPassword(String gmailPass) {
		generic.EnterText(gmailPasswordTxtbox, gmailPass);
	}

	public void clickOnLogout() {
		generic.JSClick(logoutBtn);
	}

	public boolean LogOut() throws InterruptedException {
		clickOnLoginImg();
		clickOnLogout();
		String txt = generic.getText(signInBtn);
		if (txt.contains("Log In")) {
			return true;
		} else {
			return false;
		}
	}
	
	public void login_UserGaana(String string) throws InterruptedException {
		switch (string) {
		case "Facebook":
			clickOnFbLogin();
			parentWinHandle = generic.getParentWindowHandle();
			generic.switchToNewWindow();
			EnterFbEmail(Email);
			EnterFbPassword(Password);
			clickOnFbLoginBtn();
			generic.switchToParenttWindow(parentWinHandle);
			break;

		case "Google":
			clickOnGoogleLogin();
			parentWinHandle = generic.getParentWindowHandle();
			generic.switchToNewWindow();
			EnterGmailEmail(Email);
			clickOnNextBtn();
			EnterGmailPassword(Password);
			clickOnNextBtn();
			generic.switchToParenttWindow(parentWinHandle);
			break;

		case "GaanaPlus":
		case "NonGaanaPlus":
			enterEmailId(Email);
			clickOnEmailContinue();
			enterEmailPassword(Password);
			clickOnEmailContinue();
			break;
		default:
			System.out.println("The provided userType is invalid");
			break;
		}
	}

}

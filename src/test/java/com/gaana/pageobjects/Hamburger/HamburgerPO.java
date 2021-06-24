package com.gaana.pageobjects.Hamburger;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.gaana.automation.util.GenericMethod;
import com.gaana.automation.util.TestNGLogUtility;
import com.gaana.automation.util.YamlReader;
import com.gaana.stepdefinitions.Login.LoginStepDef;
import com.gaana.test.base.BaseAutomation;

public class HamburgerPO extends BaseAutomation {

	GenericMethod generic = new GenericMethod();

	private By hamburgerIcon = By.xpath("//button[contains(@class,'ham')]");
	private By hamburgerOptions = By.xpath("//div[contains(@class,'nav-pannel')]//*[contains(@class,'link')]//small");
	private By hamburgerButtonOption = By.xpath("//span[contains(text(),'${buttonText}')]");
	private By nightMode_toggle = By.xpath("//label[contains(@class,'form-switch')]");
	
	
	public void clickOnHamburgerIcon() {
		wait.waitForVisibilityOfElement(hamburgerIcon);
		generic.click(hamburgerIcon);
	}

	public boolean validateHamburgerLOV(String options) {
		wait.hardWait(2);
		return generic.validateListOfValues(options, hamburgerOptions);
	}
	
	public boolean validateNightModeButton(String value) {
		boolean flag = false;
		wait.hardWait(2);
		flag = isDisplayed(parameterizedLocator(hamburgerButtonOption, value)) && isDisplayed(nightMode_toggle);
		return flag;
	}

}

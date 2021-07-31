package com.gaana.pageobjects.Home;

import org.openqa.selenium.By;

import com.gaana.automation.util.GenericMethod;
import com.gaana.test.base.BaseAutomation;

public class HomePO extends BaseAutomation {

	GenericMethod generic = new GenericMethod();
	
	private By menuOptions = By.xpath("//section//*[contains(@class,'link')]//small");
	private By quicklinkOptions = By.xpath("//strong[contains(text(),'Quicklinks')]//following-sibling::div//span");
	private By userIconOptions = By.xpath("//*[contains(@class,'lgdrop_pp')]//span");
	private By footerlinkOptions = By.xpath("//div[contains(@class,'row3')]//span");
	private By footerText_xpath = By.xpath("//strong[contains(text(),'${type}')]");
	private By fbIconFooter = By.xpath("//button[contains(@class,'fc')]");
	private By twIconFooter = By.xpath("//button[contains(@class,'tw')]");
	private By logoGaana = By.xpath("//a[contains(@class,'logo')]");
	private By iconLanguage = By.xpath("//button[contains(@class,'lg mr')]");
	private By iconTheme = By.xpath("//button[contains(@class,'thm mr')]");
	private By btnAdFree = By.xpath("//a[contains(@class,'gplus mr')]");
	private By btnGaanaPlus = By.xpath("//a[contains(@class,'gplus mr60')]");
	private By carouselbanner = By.xpath("//section[contains(@class,'banner_carousel')]//li");
	
	
	
	public boolean validateHomeMenuList(String options) {
		wait.hardWait(2);
		return generic.validateListOfValues(options, menuOptions);
	}
	
	public boolean validateQuickLinks(String options) {
		wait.hardWait(2);
		return generic.validateListOfValues(options, quicklinkOptions);
	}
	
	
	public boolean validateUserIconOptions(String options) {
		wait.hardWait(2);
		return generic.validateListOfValues(options, userIconOptions);
	}
	

	public boolean validatePresenceFooterText(String text) {
		boolean flag = false;
		flag = isDisplayed(parameterizedLocator(footerText_xpath,text));
		return flag;
	}
	
	public boolean validatePresenceFooterIcons() {
		boolean flag = false;
		flag = isDisplayed(fbIconFooter) && isDisplayed(twIconFooter);
		return flag;
	}
	
	public boolean validateFooterLinks(String options) {
		wait.hardWait(2);
		return generic.validateListOfValues(options, footerlinkOptions);
	}
	
	public boolean validatePresenceGaanaLogo() {
		boolean flag = false;
		flag = isDisplayed(logoGaana);
		return flag;
	}
	
	public boolean validateSubscriptionButton(String btnName) {
		if (getText(btnGaanaPlus).trim().equalsIgnoreCase(btnName))
			return true;
		return false;
	}
	
	public boolean validateSubscriptionButton(String adNameButton, String gaanaPlusButton) {
		System.out.println(getText(btnGaanaPlus).trim());
		System.out.println(gaanaPlusButton);
		
		System.out.println(getText(btnAdFree).trim());
		System.out.println(adNameButton);
		
		if (getText(btnGaanaPlus).trim().contains(gaanaPlusButton) && getText(btnAdFree).trim().contains(adNameButton))
			return true;
		return false;
	}
	
	public boolean validatePresenceLanguageIcon() {
		boolean flag = false;
		flag = isDisplayed(iconLanguage);
		return flag;
	}
	
	public boolean validatePresenceThemeIcon() {
		boolean flag = false;
		flag = isDisplayed(iconTheme);
		return flag;
	}
	
	public boolean validatePresencecarouselbanner() {
		boolean flag = false;
		if(generic.getElementSize(carouselbanner)>0)
			flag = true;
		return flag;
	}

}

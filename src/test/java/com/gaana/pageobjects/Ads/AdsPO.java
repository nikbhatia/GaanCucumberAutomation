package com.gaana.pageobjects.Ads;

import org.openqa.selenium.By;

import com.gaana.automation.util.GenericMethod;

public class AdsPO {

	GenericMethod generic = new GenericMethod();

	private By ads_xpath = By.xpath("//*[contains(@class,'adunit')]//div");

	public boolean validatePresenceAdvertisements() {
		boolean flag = false;
		int adsCount=generic.getElementSize(ads_xpath);
		if (adsCount >= 2)
			flag = true;
		return flag;
	}
	
	public boolean validateAbsenceAdvertisements() {
		boolean flag = true;
		int adsCount=generic.getElementSize(ads_xpath);
		System.out.println("Before "+adsCount);
		if (adsCount == 0)
			flag = true;
		System.out.println("After "+adsCount);
		return flag;
	}
}

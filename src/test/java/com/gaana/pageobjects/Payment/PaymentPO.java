package com.gaana.pageobjects.Payment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.gaana.automation.util.GenericMethod;
import com.gaana.automation.util.URLBuilder;
import com.gaana.test.base.BaseAutomation;

import cucumber.api.java.en.Then;

public class PaymentPO extends BaseAutomation {

	private By getGaanaPlusLink = By.xpath("//a[contains(@class,'gplus mr60')]");
	private By listgaanaSubscription = By.xpath("//div[contains(@class,'payment_opt')]//div[contains(@class,'li')]");
	private By gaanaSubscriptionCheckbox = By
			.xpath("//span[contains(text(),'${heading}')]//ancestor::div[contains(@class,'li')]//span[@class='checkbox']");
	private By selectedGaanaSubsPack = By.xpath("//div[contains(@class,'selectedPlan')]//small");
	private By paymentType_xpath = By.xpath("//span[contains(@class,'type') and contains(text(),'${type}')]");
	private By cardnumberCC_xpath = By.xpath("//form[contains(@id,'payment_form')]//strong[contains(text(),'Card Number')]");
	private By payNowCC_xpath = By.xpath("//form[contains(@id,'payment_form')]//button[contains(text(),'Pay Now')]");
	private By labelPW_xpath = By.xpath("//form[contains(@class,'paytm-field')]//label[contains(text(),'Link your Paytm Wallet')]");
	private By requestOtpPW_xpath = By.xpath("//form[contains(@class,'paytm-field')]//button[contains(text(),'Request OTP')]");
	private By popularBanksNB_xpath = By.xpath("//div[contains(@class,'pdetail_wrap')]//strong[contains(text(),'Popular Banks')]");
	private By otherBanksNB_xpath = By.xpath("//select[contains(@name,'bankcode')]");
	
	private By cardNumbertxtbox = By.xpath("//input[contains(@name,'card_number')]");
	private By nameOnCardtxtbox = By.xpath("//input[contains(@name,'name_on_card')]");
	private By cardExpiryMonthtxtbox = By.xpath("//input[contains(@name,'card_exp_month')]");
	private By cardExpiryYeartxtbox = By.xpath("//input[contains(@name,'card_exp_year')]");
	private By cardCVVtxtbox = By.xpath("//input[contains(@name,'security_code')]");
	
	private By transactionFailedMsg = By.xpath("//div[contains(@class,'data-container')]//h3");
	
	private By link_aTag_xpath = By.xpath("//a[contains(text(),'${heading}')]");
	
	
	GenericMethod generic = new GenericMethod();

	public void clickOngetGaanaPlusLink() {
		generic.click(getGaanaPlusLink);
		generic.switchToNewWindow();
	}

	public boolean validatePageURL(String URL) {
		String currentURL = driver.getCurrentUrl().trim();
		System.out.println(currentURL);
		String expectedURL = URLBuilder.getURL(URL).trim();
		System.out.println(expectedURL);

		if (currentURL.equalsIgnoreCase(expectedURL))
			return true;
		return false;
	}

	public boolean validateSubscriptionPacksCount(Integer totalsubspacks) {

		List<WebElement> linkElements = driver.findElements(listgaanaSubscription);

		if (linkElements.size() == totalsubspacks)
			return true;
		return false;
	}

	public void clickOnGaanaSubscriptionCheckbox(String packName) {
		generic.click(parameterizedLocator(gaanaSubscriptionCheckbox, packName));
	}

	public boolean validateSubsPackName(String packName) {
		if (getText(selectedGaanaSubsPack).equalsIgnoreCase(packName))
			return true;
		return false;
	}
	
	public boolean validatePaymentMethodsAvailability(String paymentType) {
        boolean flag = false;
        wait.hardWait(2);
		generic.click(parameterizedLocator(paymentType_xpath,paymentType));
    	switch (paymentType.toString()) {
            case "Credit Card/ Debit Card":
                flag = isDisplayed(cardnumberCC_xpath) && isDisplayed(payNowCC_xpath);
                break;
            case "Paytm Wallet":
            	flag = isDisplayed(labelPW_xpath) && isDisplayed(requestOtpPW_xpath);
                break;
            case "Netbanking":
            	flag = isDisplayed(popularBanksNB_xpath) && isDisplayed(otherBanksNB_xpath);
                break;
        }
        return flag;
    }

	public void enterCardDetails(String paymentType, String cardNumber, String cardName, String cardExpMonth, String cardExpYear, String cardCVV) throws InterruptedException {
		generic.click(parameterizedLocator(paymentType_xpath,paymentType));
    	
		/*for(int i=0;i<=4;i++) {
			
			driver.switchTo().frame(i);
			
			switch (i) {
				case 0:
					generic.EnterText(cardNumbertxtbox, cardNumber);
					break;
				case 1:
					generic.EnterText(nameOnCardtxtbox, cardName);
					break;
				case 2:
					generic.EnterText(cardExpiryMonthtxtbox, cardExpMonth);
					break;
				case 3:
					generic.EnterText(cardExpiryYeartxtbox, cardExpYear);
					break;
				case 4:
					generic.EnterText(cardCVVtxtbox, cardCVV);
					break;
			}
			driver.switchTo().defaultContent();
		}*/
		System.out.println("Hello hello");
		Thread.sleep(4000);
		driver.switchTo().frame(0);
		generic.EnterText(cardNumbertxtbox, cardNumber);
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(1);
		generic.EnterText(nameOnCardtxtbox, cardName);
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(2);
		generic.EnterText(cardExpiryMonthtxtbox, cardExpMonth);
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(3);
		generic.EnterText(cardExpiryYeartxtbox, cardExpYear);
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(4);
		generic.EnterText(cardCVVtxtbox, cardCVV);
		driver.switchTo().defaultContent();
	}

	public boolean validateTransactionFailedMessage(String message) {
		if (getText(transactionFailedMsg).equalsIgnoreCase(message))
			return true;
		return false;
	}
	
	public void clickOnlink(String string) {
		generic.click(parameterizedLocator(link_aTag_xpath, string));
	}
	
}

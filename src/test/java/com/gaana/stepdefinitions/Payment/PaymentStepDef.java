package com.gaana.stepdefinitions.Payment;

import static org.testng.Assert.assertTrue;

import com.gaana.pageobjects.Payment.PaymentPO;
import com.gaana.test.base.PageObjectWrapper;

import cucumber.api.java.en.Then;

public class PaymentStepDef {
	
	PaymentPO paymentPO = (PaymentPO) PageObjectWrapper.getObject(PaymentPO.class);
    
	
	@Then("user clicks on Get Gaana Plus link")
	public void user_clicks_on_Get_Gaana_Plus_link() {
		paymentPO.clickOngetGaanaPlusLink();
	}

	
	@Then("user verifies that {string} is displayed")
	public void user_verifies_that_is_displayed(String URL) {
		assertTrue(paymentPO.validatePageURL(URL), URL+" page is not displayed.");
	}


	@Then("user verifies that total of {int} Gaana subscription packs are displayed on subscription page")
	public void user_verifies_that_total_of_Gaana_subscription_packs_are_displayed_on_subscription_page(Integer int1) {
		assertTrue(paymentPO.validateSubscriptionPacksCount(int1), "Total subscription packs are not "+int1);
	}

	@Then("user selects the {string} subscription pack")
	public void user_selects_the_subscription_pack(String packName) {
	    paymentPO.clickOnGaanaSubscriptionCheckbox(packName);
	}

	@Then("user verifies that payment page is opened for {string} subscription pack")
	public void user_verifies_that_payment_page_is_opened_for_subscription_pack(String packName) {
		assertTrue(paymentPO.validateSubsPackName(packName), "Either Payment page is not opened or Subs pack is not properly displayed on payment page");
	}

	@Then("user verifies the modes of payment {string} {string} {string}")
	public void user_verifies_the_modes_of_payment(String CC, String PW, String NB) {
		assertTrue(paymentPO.validatePaymentMethodsAvailability(CC), CC+" payment option is not displayed properly");
		assertTrue(paymentPO.validatePaymentMethodsAvailability(PW), PW+" payment option is not displayed properly");
		assertTrue(paymentPO.validatePaymentMethodsAvailability(NB), NB+" payment option is not displayed properly");
	}

	@Then("user selects {string} and enter the card details {string} {string} {string} {string} {string}")
	public void user_selects_and_enter_the_card_details(String paymentType, String cardNumber, String cardName, String cardExpMonth, String cardExpYear, String cardCVV) throws InterruptedException {
	    paymentPO.enterCardDetails(paymentType, cardNumber, cardName, cardExpMonth, cardExpYear, cardCVV);
	}

	@Then("user verifies that {string} message is failed")
	public void user_verifies_that_message_is_failed(String string) {
		assertTrue(paymentPO.validateTransactionFailedMessage(string), "Transaction failed message is not properly displayed.");
	}
	

	@Then("user clicks on link {string}")
	public void user_clicks_on_link(String string) {
	    paymentPO.clickOnlink(string);
	}

}

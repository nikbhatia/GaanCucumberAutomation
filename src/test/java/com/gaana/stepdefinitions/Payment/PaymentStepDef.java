package com.gaana.stepdefinitions.Payment;

import static org.testng.Assert.assertTrue;

import com.gaana.pageobjects.Payment.PaymentPO;
import com.gaana.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.kafka.common.protocol.types.Field;
import org.testng.Assert;

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

	@Then("user verifies that {string} message is displayed")
	public void user_verifies_that_message_is_displayed(String string) {
		assertTrue(paymentPO.validateTransactionFailedMessage(string), "Transaction failed message is not properly displayed.");
	}
	

	@Then("user clicks on link {string}")
	public void user_clicks_on_link(String string) {
	    paymentPO.clickOnlink(string);
	}
	
	@Then("user selects {string}")
	public void user_selects(String paymentType) {
	    paymentPO.clickPaymentMode(paymentType);
	}

	@Then("user enters the registered paytm mobile number {string}")
	public void user_enters_the_registered_paytm_mobile_number(String string) {
	   paymentPO.enterPaytmNumber(string);
	}

	@Then("user enters the Paytm OTP {string}")
	public void user_enters_the_Paytm_OTP(String string) {
	    paymentPO.enterPaytmOTP(string);
	}

	@Then("user verifies {string} message is displayed")
	public void user_verifies_message_is_displayed(String string) {
		assertTrue(paymentPO.validateInvalidOTPMessage(string), string+ " message is not displayed.");
	}

	@Then("user verifies that banks {string} are displayed as Popular Banks")
	public void user_verifies_that_banks_are_displayed_as_Popular_Banks(String string) {
		assertTrue(paymentPO.validatePopularBanksLOV(string), "NetBanking page doesn't have "+string+" listed banks..");
	}

	@Then("user clicks on {string} from the popular banks list and verifies that it is selected successfully")
	public void user_clicks_on_from_the_popular_banks_list_and_verifies_that_it_is_selected_successfully(String bankName) {
		paymentPO.clickPopularBank(bankName);
		assertTrue(paymentPO.validateSelectedBank(bankName), bankName+" is not selected successfully");
	}

	@Then("user selects the {string} from the Other Banks dropdown and verifies that it is selected successfully")
	public void user_selects_the_from_the_Other_Banks_dropdown_and_verifies_that_it_is_selected_successfully(String bankName) {
		paymentPO.selectOtherBank(bankName);
		assertTrue(paymentPO.validateSelectedBank(bankName), bankName+" is not selected successfully");
	
	}
	
	@Then("user clicks on redeemcoupon button")
	public void clickOnRedeemCoupon(){
		paymentPO.clickOnRedeemCoupon();
	}
	
	@And("user enter the coupon {string}")
	public void setCoupon(String coupon){
		paymentPO.setRedeemCoupon(coupon);
	}
	
	
	@Then("verifies auto renew with payementMethod {string} and cardNumber {string}")
	public void verifyAutoRenew(String paymentMethod, String cardNumber){
		Assert.assertFalse(paymentPO.verifyAutoRenew(paymentMethod,cardNumber));
	}

}

#Author: pravish.mittal

Feature: Test Scenarios for validating Payment functionality

@Gaana @Regression
Scenario Outline: Verify the Gaana packs on the subscription page

		Given user opens the application "homePage"
    Then user logins with "<loginType>"
    Then user clicks on Get Gaana Plus link
    Then user verifies that "subscriptionPage" is displayed
    Then user verifies that total of 4 Gaana subscription packs are displayed on subscription page
    
    Examples:
    |loginType   |
  	|NonGaanaPlus|
  	
 @Gaana @Regression
Scenario Outline: Verify the different kind of payment modes on the payment page

		Given user opens the application "homePage"
    Then user logins with "<loginType>"
    Then user clicks on Get Gaana Plus link
    Then user verifies that "subscriptionPage" is displayed
    Then user selects the "Year Gaana Plus" subscription pack
    Then user clicks on "Buy Now" button
    Then user verifies that payment page is opened for "1 Year Gaana Plus" subscription pack
    Then user verifies the modes of payment "Credit Card/ Debit Card" "Paytm Wallet" "Netbanking"
    
    Examples:
    |loginType   |
  	|NonGaanaPlus|
  	
  	@Gaana @Regression
 Scenario Outline: Verify user is able to buy subscription pack by Credit/Debit card 

		Given user opens the application "homePage"
    Then user logins with "<loginType>"
    Then user clicks on Get Gaana Plus link
    Then user verifies that "subscriptionPage" is displayed
    Then user selects the "Year Gaana Plus" subscription pack
    Then user clicks on "Buy Now" button
    Then user selects "Credit Card/ Debit Card" and enter the card details "<CardNumber>" "<NameonCard>" "<ExpiryMonth>" "<ExpiryYear>" "<CVV>"
    Then user clicks on "Pay Now" button
    Then user verifies that "Sorry, transaction failed" message is failed
    Then user clicks on link "Retry"
    Then user verifies that "subscriptionPage" is displayed 
    Then user logouts the app
    
    Examples:
    |loginType   |    CardNumber   	 |  NameonCard |ExpiryMonth|ExpiryYear|CVV|
  	|NonGaanaPlus|4111 1111 1111 1111|  TestUser   |12         |25        |123|
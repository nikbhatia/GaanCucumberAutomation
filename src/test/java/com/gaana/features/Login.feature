Feature: Test Scenarios for login functionality for different kind of users 

 Scenario Outline: Verify user is able to login into app with different userTypes
 		Given user opens the application "homePage"
    Then user logins with "<loginType>"
    And verifies the user login profile
    Then user logouts the app
    
    Examples:
    |loginType| 
  	|GaanaPlus|
#Author: pravish.mittal

@Gaana @Regression
 Scenario Outline: Verify user is able to login with GaanaPlus credentials

    Given user opens the application "homePage"
    Then user logins with "<loginType>"
    And verifies the user login profile
    Then user logouts the app
    
    Examples:
    |loginType   |
  	|GaanaPlus   |
  	
 @Gaana @Regression
 Scenario Outline: Verify user is able to login with Non-GaanaPlus credentials
    Given user opens the application "homePage"
    Then user logins with "<loginType>"
    And verifies the user login profile
    Then user logouts the app
    
    Examples:
    |loginType   |
  	|NonGaanaPlus   |
  	
 @Gaana @Regression
 Scenario Outline: Verify user is able to login with Facebook credentials
    Given user opens the application "homePage"
    Then user logins with "<loginType>"
    And verifies the user login profile
    Then user logouts the app
    
    Examples:
    |loginType   |
  	|Facebook   |
  	
  	
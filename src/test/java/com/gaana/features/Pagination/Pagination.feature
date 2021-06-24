#Author: pravish.mittal

Feature: Test Scenarios for validating Pagination functionality

@Gaana @Regression
Scenario Outline: Verify pagination for the Home page

		Given user opens the application "homePage"
    Then user logins with "<loginType>"
    Then user verifies pagination of the "Home Page"
    
    Examples:
    |loginType   |   
  	|NonGaanaPlus|
  	
  	
  	@Gaana @Regression
Scenario Outline: Verify pagination for the New Releases page

		Given user opens the application "homePage"
    Then user logins with "<loginType>"
    Then user clicks on "New Releases" link from home page
    Then user verifies pagination of the "New Releases"
    
    Examples:
    |loginType   |   
  	|NonGaanaPlus|
  	
   @Gaana @Regression
Scenario: Verify pagination for the Albums page

		When user opens the application "albumPage"
    Then user verifies pagination of the "Albums"
   
  
    
   @Gaana @Regression
Scenario: Verify pagination for the Artists page

		When user opens the application "artistPage"
    Then user verifies pagination of the "Artists"
   
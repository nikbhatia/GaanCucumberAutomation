#Author: pravish.mittal

Feature: Test Scenarios for Pagination functionality

@Gaana
Scenario Outline: Verify user is able to scroll down to access the entire page

    Given user opens the application "homePage"
    Then user logins with "<loginType>"
    Then user verifies pagination of the "Home Page"
    Then user clicks on "Top Charts" link from home page
    Then user verifies pagination of the "Top Charts"
    Then user clicks on "New Releases" link from home page
    Then user verifies pagination of the "New Releases"
    Then user clicks on "Gaana Videos" link from home page
    Then user verifies pagination of the "Gaana Videos"
    When user opens the application "albumPage"
    Then user verifies pagination of the "Albums"
    When user opens the application "artistPage"
    Then user verifies pagination of the "Artists"
    Then user logouts the app
    
    Examples:
    |loginType   |   
  	|NonGaanaPlus|
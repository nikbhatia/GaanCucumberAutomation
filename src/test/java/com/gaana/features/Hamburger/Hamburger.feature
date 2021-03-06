#Author: pravish.mittal

Feature: Test Scenarios for validating Hamburger functionality

@Gaana @Regression
 Scenario: Verify the Hamburger options for 'non-logged in' user
    Given user opens the application "homePage"
    Then user clicks on Hamburger icon
    Then user verifies the hamburger list of options "Home,Radio,Podcast,My Music,India's Music,Language,Go Ad-Free,Get Gaana Plus,Trending Songs,New Songs,Old Songs,Album,Artist,Lyrics,Music Labels,Genres"
    Then user verifies that "Night Mode" button is displayed
 
@Gaana @Regression
 Scenario Outline: Verify the Hamburger options for NonGaanaPlus user
    Given user opens the application "homePage"
    Then user logins with "<loginType>"
    Then user clicks on Hamburger icon
    Then user verifies the hamburger list of options "Home,Radio,Podcast,My Music,India's Music,Language,Go Ad-Free,Get Gaana Plus,Trending Songs,New Songs,Old Songs,Album,Artist,Lyrics,Music Labels,Genres,Profile,Settings,Log Out"
    Then user verifies that "Night Mode" button is displayed
 
    Examples:
    |loginType   |
  	|NonGaanaPlus|
  	
 @Gaana @Regression
 Scenario Outline: Verify the Hamburger options for GaanaPlus user
    Given user opens the application "homePage"
    Then user logins with "<loginType>"
    Then user clicks on Hamburger icon
    Then user verifies the hamburger list of options "Home,Radio,Podcast,My Music,India's Music,Language,Renew Gaana Plus,Trending Songs,New Songs,Old Songs,Album,Artist,Lyrics,Music Labels,Genres,Profile,Settings,Log Out"
    Then user verifies that "Night Mode" button is displayed
 
    Examples:
    |loginType|
  	|GaanaPlus|
  	

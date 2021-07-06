#Author: pravish.mittal

Feature: Test Scenarios for validating Advertisements functionality
 
    @Gaana @Regression
 Scenario Outline: Verify ads functionality on various pages for NonGaana Plus user
 
    Given user opens the application "homePage"
    Then user logins with "<loginType>"
    Then user verifies that advertisements are displayed on "Home page"
    Then user clicks on "New Releases" link
    Then user verifies that advertisements are displayed on "New Releases page"
    Then user clicks on "Trending" link
    Then user verifies that advertisements are displayed on "Trending page"
    Then user clicks on "Old Hits" link
    Then user verifies that advertisements are displayed on "Old Hits page"
    Then user clicks on "Radio" link
    Then user verifies that advertisements are displayed on "Radio page"
    Then user clicks on "Podcast" link
    Then user verifies that advertisements are displayed on "Podcast page"
    Then user clicks on "My Music" link
    Then user verifies that advertisements are displayed on "My Music page"
    When user opens the application "albumPage"
    Then user verifies that advertisements are displayed on "Albums page"
    When user opens the application "artistPage"
    Then user verifies that advertisements are displayed on "Artists page"
    When user opens the application "Playlistpage"
    Then user verifies that advertisements are displayed on "Playlists page"
    
    Examples:
    |loginType   |   
  	|NonGaanaPlus|
  	
  	@Gaana @Regression
 Scenario: Verify ads functionality on various pages for 'Non-logged in' user
 
    Given user opens the application "homePage"
    Then user verifies that advertisements are displayed on "Home page"
    Then user clicks on "New Releases" link
    Then user verifies that advertisements are displayed on "New Releases page"
    Then user clicks on "Trending" link
    Then user verifies that advertisements are displayed on "Trending page"
    Then user clicks on "Old Hits" link
    Then user verifies that advertisements are displayed on "Old Hits page"
    Then user clicks on "Radio" link
    Then user verifies that advertisements are displayed on "Radio page"
    Then user clicks on "Podcast" link
    Then user verifies that advertisements are displayed on "Podcast page"
    When user opens the application "albumPage"
    Then user verifies that advertisements are displayed on "Albums page"
    When user opens the application "artistPage"
    Then user verifies that advertisements are displayed on "Artists page"
    When user opens the application "Playlistpage"
    Then user verifies that advertisements are displayed on "Playlists page"
    
    
  @Gaana @Regression
 Scenario Outline: Verify ads functionality on various pages for GaanaPlus user
 
    Given user opens the application "homePage"
    Then user logins with "<loginType>"
    Then user verifies that advertisements are not displayed on "Home page"
    Then user clicks on "New Releases" link
    Then user verifies that advertisements are not displayed on "New Releases page"
    Then user clicks on "Trending" link
    Then user verifies that advertisements are not displayed on "Trending page"
    Then user clicks on "Old Hits" link
    Then user verifies that advertisements are not displayed on "Old Hits page"
    Then user clicks on "Radio" link
    Then user verifies that advertisements are not displayed on "Radio page"
    Then user clicks on "Podcast" link
    Then user verifies that advertisements are not displayed on "Podcast page"
    Then user clicks on "My Music" link
    Then user verifies that advertisements are not displayed on "My Music page"
    When user opens the application "albumPage"
    Then user verifies that advertisements are not displayed on "Albums page"
    When user opens the application "artistPage"
    Then user verifies that advertisements are not displayed on "Artists page"
    When user opens the application "Playlistpage"
    Then user verifies that advertisements are not displayed on "Playlists page"
    
    Examples:
    |loginType|   
  	|GaanaPlus|
  	
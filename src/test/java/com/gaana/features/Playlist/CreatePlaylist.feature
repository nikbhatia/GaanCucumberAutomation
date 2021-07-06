#Author: pravish.mittal

Feature: Test Scenarios for validating playlist functionality

 @Gaana @Regression
 Scenario: Verify clean up playlist functionality
 
    Given user opens the application "homePage"
    Then user logins with "GaanaPlus"
    Then user clicks on "My Music" link
    Then user clean ups the "Test Playlist"
    Then user logouts the app
    Then user logins with "NonGaanaPlus"
    Then user clicks on "My Music" link
    Then user clean ups the "Test Playlist"

@Gaana @Regression
 Scenario Outline: Verify create playlist functionality for Gaana Plus user
 
    Given user opens the application "homePage"
    Then user logins with "<loginType>"
    Then user clicks on "My Music" link
    Then user clicks on "Create Playlist" button
    And user creates "Test Playlist"
    Then user verifies the created playlist
    Then user deletes the playlist and verifies playlist is deleted successfully
    
    Examples:
    |loginType|
  	|GaanaPlus|
  	
  	@Gaana @Regression
 Scenario Outline: Verify create playlist functionality for Non-Gaana Plus user
 
    Given user opens the application "homePage"
    Then user logins with "<loginType>"
    Then user clicks on "My Music" link
    Then user clicks on "Create Playlist" button
    And user creates "Test Playlist"
    Then user verifies the created playlist
    Then user deletes the playlist and verifies playlist is deleted successfully
    
    Examples:
    |loginType|
  	|NonGaanaPlus|
    
    
  @Gaana @Regression
 Scenario Outline: Verify edit playlist functionality for Gaana Plus user
 
    Given user opens the application "homePage"
    Then user logins with "<loginType>"
    Then user clicks on "My Music" link
    Then user clicks on "Create Playlist" button
    And user creates "Test Playlist"
    Then user verifies the created playlist
    Then user edits the playlist name "Test Playlist_Upd"
    Then user deletes the playlist and verifies playlist is deleted successfully
    
    Examples:
    |loginType|
  	|GaanaPlus|
  	
  	 @Gaana @Regression
 Scenario Outline:  Verify edit playlist functionality for Non-Gaana Plus user
 
    Given user opens the application "homePage"
    Then user logins with "<loginType>"
    Then user clicks on "My Music" link
    Then user clicks on "Create Playlist" button
    And user creates "Test Playlist"
    Then user verifies the created playlist
    Then user edits the playlist name "Test Playlist_Upd"
    Then user deletes the playlist and verifies playlist is deleted successfully
    
    Examples:
    |loginType|
  	|NonGaanaPlus|
  	
   @Gaana @Regression
 Scenario Outline: Verify add song functionality into playlist for Gaana Plus user
 
    Given user opens the application "homePage"
    Then user logins with "<loginType>"
    Then user clicks on "My Music" link
    Then user clicks on "Create Playlist" button
    And user creates "Test Playlist"
    Then user verifies the created playlist
    Then user adds a song in playlist
    Then user clicks on "My Music" link
    Then user verifies that song is added successfully in playlist
    Then user deletes the playlist and verifies playlist is deleted successfully
    
    Examples:
    |loginType|
  	|GaanaPlus|
  	
  	 @Gaana @Regression
 Scenario Outline: Verify add song functionality into playlist for Non-Gaana Plus user
 
    Given user opens the application "homePage"
    Then user logins with "<loginType>"
    Then user clicks on "My Music" link
    Then user clicks on "Create Playlist" button
    And user creates "Test Playlist"
    Then user verifies the created playlist
    Then user adds a song in playlist
    Then user clicks on "My Music" link
    Then user verifies that song is added successfully in playlist
    Then user deletes the playlist and verifies playlist is deleted successfully
    
    Examples:
    |loginType|
  	|NonGaanaPlus|
  	
 @Gaana @Regression
 Scenario Outline: Verify delete song functionality from the playlist for Gaana Plus user
 
    Given user opens the application "homePage"
    Then user logins with "<loginType>"
    Then user clicks on "My Music" link
    Then user clicks on "Create Playlist" button
    And user creates "Test Playlist"
    Then user verifies the created playlist
    Then user adds a song in playlist
    Then user clicks on "My Music" link
    Then user verifies that song is added successfully in playlist
     Then user deletes the added song from the playlist
    Then user verifies that song is deleted successfully from the playlist
    Then user deletes the playlist and verifies playlist is deleted successfully
    
    Examples:
    |loginType|
  	|GaanaPlus|
  	
  	@Gaana @Regression
 Scenario Outline: Verify delete song functionality from the playlist for Non-Gaana Plus user
 
    Given user opens the application "homePage"
    Then user logins with "<loginType>"
    Then user clicks on "My Music" link
    Then user clicks on "Create Playlist" button
    And user creates "Test Playlist"
    Then user verifies the created playlist
    Then user adds a song in playlist
    Then user clicks on "My Music" link
    Then user verifies that song is added successfully in playlist
     Then user deletes the added song from the playlist
    Then user verifies that song is deleted successfully from the playlist
    Then user deletes the playlist and verifies playlist is deleted successfully
    
    Examples:
    |loginType|
  	|NonGaanaPlus|
  	
  	
  @Gaana @Regression
 Scenario Outline: Verify delete playlist functionality for Gaana Plus user
 
    Given user opens the application "homePage"
    Then user logins with "<loginType>"
    Then user clicks on "My Music" link
    Then user clicks on "Create Playlist" button
    And user creates "Test Playlist"
    Then user verifies the created playlist
    Then user deletes the playlist and verifies playlist is deleted successfully
    
    Examples:
    |loginType|
  	|GaanaPlus|
  	
 @Gaana @Regression
 Scenario Outline: Verify delete playlist functionality for Non-Gaana Plus user
 
    Given user opens the application "homePage"
    Then user logins with "<loginType>"
    Then user clicks on "My Music" link
    Then user clicks on "Create Playlist" button
    And user creates "Test Playlist"
    Then user verifies the created playlist
    Then user deletes the playlist and verifies playlist is deleted successfully
    
    Examples:
    |loginType|
  	|NonGaanaPlus|
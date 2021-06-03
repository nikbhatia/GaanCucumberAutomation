Feature: Test Scenarios for creating playlist

@Gaana
 Scenario Outline: Verify user is able to create playlist
 
    Given user opens the application "homePage"
    Then user logins with "<loginType>"
    Then user clicks on "My Music" link
    Then user clicks on "Create Playlist" button
    And user creates "Test Playlist"
    Then user verifies the created playlist
    Then user edits the playlist name "Test Playlist_Upd"
    Then user adds a song in playlist
    Then user clicks on "My Music" link
    Then user verifies that song is added successfully in playlist
    Then user deletes the added song from the playlist
    Then user verifies that song is deleted successfully from the playlist
    Then user deletes the playlist and verifies playlist is deleted successfully
    
    Examples:
    |loginType   |
  	|GaanaPlus   |

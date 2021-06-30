Feature: Test scenario for Gaana page

  @Gaana
  Scenario: To verify elements present inside three dot dropdown in song page
    Given user opens the application "Songpage"
    And user clicks on threedot link
    Then user verifies the elements "Share,Add To Playlist,Add To Queue,Download,View Lyrics,Get Song Info,View Album,View Artist" on the pop up


  @Gaana
  Scenario: To verify elements present inside three dot dropdown in Album page
    Given user opens the application "Album"
    And user clicks on threedot link
    Then user verifies the elements "Share,Add To Playlist,Add To Queue,Download,Get Album Info" on the pop up

  @Gaana
  Scenario: To verify elements present inside three dot dropdown in playlist page
    Given user opens the application "Playlistpage"
    And user clicks on threedot link
    Then user verifies the elements "Share,Add To Playlist,Add To Queue,Download,Get Playlist Info" on the pop up



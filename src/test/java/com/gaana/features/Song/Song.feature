Feature: Test scenario for Gaana page

  @Gaana
  Scenario: Verify three dot functionality in songs page

    Given user opens the application "Songpage"
    And user clicks on threedot link
    Then user verifies the elements "Share,Add To Playlist,Add To Queue,Download,View Lyrics,Get Song Info,View Album,View Artist" on the pop up


  @Gaana
  Scenario: Verify three dot functionality in Album page
    Given user opens the application "Album"
    And user clicks on threedot link
    Then user verifies the elements "Share,Add To Playlist,Add To Queue,Download,Get Album Info" on the pop up

  @Gaana
  Scenario: Verify three dot functionality in playlist page
    Given user opens the application "Playlistpage"
    And user clicks on threedot link
    Then user verifies the elements "Share,Add To Playlist,Add To Queue,Download,Get Playlist Info" on the pop up

  @Gaana
 Scenario: Verify three dot functionality in lyrics page
  Given user opens the application "Lyricspage"
  And user clicks on threedot link
  Then user verifies the elements "Share,Add To Playlist,Add To Queue,Download,Get Song Info,View Album,View Artist" on the pop up

  @Gaana
 Scenario: Verify three dot functionality in podcast page
   Given user opens the application "podcastPage"
   And user clicked on first podcast
   And user clicks on threedot link
   Then user verifies the elements "Share,Add To Playlist,Add To Queue,Download" on the pop up
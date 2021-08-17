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

  @Gaana
  Scenario Outline: Verify songs marked as favourite appear inside my music section
    Given user opens the application "homePage"
    And user clicks on first trending song
    Then user logins with "<loginType>"
    And user clicks on favourite button
    Then user clicks on "My Music" link
    Then verifies favourite song is present inside the "Favourite Songs" section

    Examples:
      | loginType    |
      | SimpleUser |

  @Gaana
  Scenario Outline: Verify artist marked as favourite appear inside my music section
    When user opens the application "artistPage"
    Then user logins with "<loginType>"
    And user clicks on first artist
    And user clicks on favourite button
    Then user clicks on "My Music" link
    Then verifies favourite song is present inside the "Favourite Artists" section


    Examples:
      | loginType    |
      | SimpleUser |

  @Gaana
  Scenario Outline: Verify album marked as favourite appear inside my music section
    Given user opens the application "albumPage"
    Then user logins with "<loginType>"
    And user clicks on first artist
    And user clicks on favourite button
    Then user clicks on "My Music" link
    Then verifies favourite song is present inside the "Favourite Albums" section

    Examples:
      | loginType    |
      | SimpleUser |

  @Gaana
  Scenario Outline: Verify playlist marked as favourite appear inside my music section
    Given user opens the application "Playlistpage"
    Then user logins with "<loginType>"
   # And user clicks on first artist
    And user clicks on favourite button
    Then user clicks on "My Music" link
    Then verifies favourite song is present inside the "Favourite Playlists" section

    Examples:
      | loginType    |
      | SimpleUser |

  @Gaana
  Scenario:  Verify language selection in the Gaana site for non logged in user
    Given user opens the application "homePage"
    Then user clicks on language
    Then user verifies the languages "हिन्दी Hindi,English,ਪੰਜਾਬੀ Punjabi,తెలుగు Telugu,தமிழ் Tamil,भोजपुरी Bhojpuri,বাংলা Bengali,മലയാളം Malayalam,ಕನ್ನಡ Kannada,मराठी Marathi,ગુજરાતી Gujarati,हरयाणवी Haryanvi,اردو Urdu,অসমীয়া Assamese,राजस्थानी Rajasthani,ଓଡ଼ିଆ Odia" on the language pop up
    Then user verifies update button gets disabled on unselecting all the selected languages
    Then user verifies submitted language is selected on opening the language pop up

  @Gaana
  Scenario Outline:  Verify language selection in the Gaana site for non Gaana plus user
    Given user opens the application "homePage"
    Then user logins with "<loginType>"
    Then user clicks on language
    Then user verifies the languages "हिन्दी Hindi,English,ਪੰਜਾਬੀ Punjabi,తెలుగు Telugu,தமிழ் Tamil,भोजपुरी Bhojpuri,বাংলা Bengali,മലയാളം Malayalam,ಕನ್ನಡ Kannada,मराठी Marathi,ગુજરાતી Gujarati,हरयाणवी Haryanvi,اردو Urdu,অসমীয়া Assamese,राजस्थानी Rajasthani,ଓଡ଼ିଆ Odia" on the language pop up
    Then user verifies update button gets disabled on unselecting all the selected languages
    Then user verifies submitted language is selected on opening the language pop up
    Then user clicks on user icon
    Then user navigates to display and language tab in settings section
    Then user verifies language selected in display and language section



    Examples:
      | loginType    |
      | SimpleUser   |
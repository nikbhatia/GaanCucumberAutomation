Feature: Test Scenarios of Search

  Author: nikhil.bhatia@gaana.com

  @Gaana1
  Scenario Outline: Verify Trending  "<results>" for "<loginType>" user
    Given user opens the application "homePage"
    Then  user logins with "<loginType>"
    And   user search with the "Trending" keyword
    And   verify result available for "<results>"


    Examples:
      |loginType   | results           |
      |GaanaPlus   |  Top Results      |
      |GaanaPlus   |    Playlists      |
      |GaanaPlus   |    Songs          |
      |GaanaPlus   |      Podcasts     |
      |GaanaPlus   |    Albums         |

  @Gaana1
  Scenario Outline: Verify Trending  "<results>" for "Non Logged In" user
    Given user opens the application "homePage"
    And   user search with the "Trending" keyword
    And   verify result available for "<results>"


    Examples:
        | results           |
        |  Top Results      |
        |    Playlists      |
        |    Songs          |
        |      Podcasts     |
        |    Albums         |


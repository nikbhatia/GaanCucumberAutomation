Feature: Test Scenarios of podcast page

  Author: nikhil.bhatia@gaana.com

  @Gaana
 Scenario Outline: Verify presence of headings on padcast page
    Given user opens the application "homePage"
    Then user logins with "<loginType>"
    When user opens the application "podcastPage"
    And  user verifies "Breadcrumb Title" with value "Gaana" "Podcast"
    And  user verifies "Page Heading" with value "Podcast"
    Then user verifies Sections and its headings
    And  user verifies "Gaana Tagline" with value "Bas Bajna Chahiye Gaana"

    Examples:
      |loginType   |
      |GaanaPlus   |
      |NonGaanaPlus|
      |Facebook    |

  @Gaana
 Scenario Outline: Verify podcast played from podcast page
    Given user opens the application "homePage"
    Then user logins with "<loginType>"
    When user opens the application "podcastPage"
    And  user verifies "Breadcrumb Title" with value "Gaana" "Podcast"
    Then  user clicked on first podcast
    And   user verifies podcast heading and breadcrumb for podcast
    Then  user played the podcast
    And   user verifies podcast is being played

    Examples:
      |loginType   |
      |GaanaPlus   |
      |NonGaanaPlus|
      |Facebook    |

  @Gaana
  Scenario Outline: Verify sorting on podcast page
    Given user opens the application "homePage"
    Then  user logins with "<loginType>"
    When  user opens the application "podcastPage"
    Then  user clicked on first podcast
    And   user verifies "Episode Headings" with value "Episode" "Uploaded On" "Duration"
    And   user verifies sorting is working correctly

    Examples:
      |loginType   |
      |GaanaPlus   |
      |NonGaanaPlus|
      |Facebook    |

  @Gaana
  Scenario Outline: Verify markfav functionality on podcast page
    Given user opens the application "homePage"
    Then  user logins with "<loginType>"
    When  user opens the application "podcastPage"
    Then  user clicked on first podcast
    Then  user mark podcast as favourite
    When  user opens the application "myMusicPage"
    Then  user mark podcast season and episode as favourite
    And   user verifies podcast season and episode added under favourite section



    Examples:
      |loginType   |
      |GaanaPlus   |
      |NonGaanaPlus|
      |Facebook    |



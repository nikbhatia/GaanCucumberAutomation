
Feature: Test Scenarios for video songs

  @Gaana @Video
  Scenario Outline: Verify video songs for GaanaPlus user
    Given user opens the application "homePage"
    Then user logins with "<loginType>"
    When user opens the application "videoPage"
    Then user clicks on video and verify the video title

    Examples:
      |loginType   |
      |GaanaPlus   |


  @Gaana @Video
  Scenario Outline: Verify Videos play time on every video tab for GaanaPlus user
    Given user opens the application "homePage"
    Then user logins with "<loginType>"
    When user opens the application "videoPage"
    Then click on video and verify the video time

    Examples:
      |loginType   |
      |GaanaPlus   |

  @Gaana @Video
  Scenario Outline: Verify video songs for Non-GaanaPlus user
    Given user opens the application "homePage"
    Then user logins with "<loginType>"
    When user opens the application "videoPage"
    Then user clicks on video and verify the video title

    Examples:
      |loginType   |
      |NonGaanaPlus   |

  @Gaana @Video2
  Scenario Outline: Verify Videos tabs on video page for Non-GaanaPlus user
    Given user opens the application "homePage"
    Then user logins with "<loginType>"
    When user opens the application "videoPage"
    Then user clicks on gaanavideo tabs

    Examples:
      |loginType   |
      |NonGaanaPlus   |

  @Gaana @Video
  Scenario Outline: Verify Videos play time on every video tab for Non-GaanaPlus user
    Given user opens the application "homePage"
    Then user logins with "<loginType>"
    When user opens the application "videoPage"
    Then click on video and verify the video time

    Examples:
      |loginType   |
      |NonGaanaPlus   |

  @Gaana @Video
  Scenario: Verify video songs for Non-loggedin user
    Given user opens the application "homePage"
    When user opens the application "videoPage"
    Then user clicks on video and verify the video title

  @Gaana @Video
  Scenario: Verify Videos tabs on video page for Non-loggedin user
    Given user opens the application "homePage"
    When user opens the application "videoPage"
    Then user clicks on gaanavideo tabs


  @Gaana @Video
  Scenario: Verify Videos play time on every video tab for Non-loggedin user
    Given user opens the application "homePage"
    When user opens the application "videoPage"
    Then click on video and verify the video time

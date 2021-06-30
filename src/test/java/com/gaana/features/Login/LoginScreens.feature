Feature: Test Scenarios for validating Login functionality on multiple login screens


  @Gaana @Regression
  Scenario Outline: Verify User is able to Login on android Tv Login Page

    Given user opens the application "androidTv"
   Then  user validates "AndroidTv Heading" with value "Connect Android TV"
    And  user logged in with "<loginType>"

    Examples:
      |loginType   |
      |GaanaPlus   |

  @Gaana @Regression
  Scenario Outline: Verify User is able to Login on android Tv Login Page

    Given user opens the application "androidTv"
    Then  user validates "AndroidTv Heading" with value "Connect Android TV"
    And  user logged in with "<loginType>"

    Examples:
      |loginType   |
      |NonGaanaPlus|



  @Gaana @Regression
  Scenario Outline: Verify User is able to Login via Quick Silver Login Page

    Given user opens the application "quickSilverLogin"
#    Then user validates login screen for android tv
#    Then  user logins with "<loginType>"

    Examples:
      |loginType   |
      |GaanaPlus   |


  @Gaana @Regression
  Scenario Outline: Verify User is able to Login via Quick Silver Login Page

    Given user opens the application "quickSilverLogin"
#    Then user validates login screen for android tv
#    Then  user logins with "<loginType>"

    Examples:
      |loginType   |
      |NonGaanaPlus|



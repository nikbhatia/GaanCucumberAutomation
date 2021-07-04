#Author: pravish.mittal

Feature: Test Scenarios for validating Home page functionality

  @Gaana @Regression
  Scenario Outline: Verify the footer section on the home page for NonGaanaPlus user
    Given user opens the application "homePage"
    Then user logins with "<loginType>"
    Then user verifies "Bas Bajna Chahiye Gaana" text is displayed on the footer
    Then user verifies that Facebook and Twitter icons are displayed
    Then user verifies the footer links "Advertise on Gaana.com,Terms of Use,Privacy Policy,Feedback,Report an Issue,Partners,Sitemap,FAQ"
    Then user verifies the Quicklinks "Albums,Genres,Artists,New Release,Trending Songs,Trending Albums,Lyrics,Old Songs,Video,Podcasts"

    Examples: 
      | loginType    |
      | NonGaanaPlus |

  @Gaana @Regression
  Scenario Outline: Verify the footer section on the home page for GaanaPlus user
    Given user opens the application "homePage"
    Then user logins with "<loginType>"
    Then user verifies "Bas Bajna Chahiye Gaana" text is displayed on the footer
    Then user verifies that Facebook and Twitter icons are displayed
    Then user verifies the footer links "Advertise on Gaana.com,Terms of Use,Privacy Policy,Feedback,Report an Issue,Partners,Sitemap,FAQ"
    Then user verifies the Quicklinks "Albums,Genres,Artists,New Release,Trending Songs,Trending Albums,Lyrics,Old Songs,Video,Podcasts"

    Examples: 
      | loginType |
      | GaanaPlus |

  @Gaana @Regression
  Scenario: Verify the footer section on the home page for 'Non-logged in' user
    Given user opens the application "homePage"
    Then user verifies "Bas Bajna Chahiye Gaana" text is displayed on the footer
    Then user verifies that Facebook and Twitter icons are displayed
    Then user verifies the footer links "Advertise on Gaana.com,Terms of Use,Privacy Policy,Feedback,Report an Issue,Partners,Sitemap,FAQ"
    Then user verifies the Quicklinks "Albums,Genres,Artists,New Release,Trending Songs,Trending Albums,Lyrics,Old Songs,Video,Podcasts"

 @Gaana @Regression
 Scenario Outline: Verify the different icons/buttons on home page for NonGaanaPlus user
    Given user opens the application "homePage"
    Then user logins with "<loginType>"
    Then user verifies the Gaana logo is displayed on home page
    And user verifies the "Go Ad Free" "Get Gaana Plus" buttons on the home page
    And user verifies the language icon on the home page
    And user verifies the theme icon on the home page
    And user verifies the carousel banner on the home page
    Examples:
    |loginType   |
  	|NonGaanaPlus|
  	
  	 @Gaana @Regression
 Scenario Outline: Verify the different icons/buttons on home page for GaanaPlus user
    Given user opens the application "homePage"
    Then user logins with "<loginType>"
    Then user verifies the Gaana logo is displayed on home page
    And user verifies the "Renew Gaana Plus" button on the home page
    And user verifies the language icon on the home page
    And user verifies the theme icon on the home page
    And user verifies the carousel banner on the home page
    Examples:
    |loginType   |
  	|GaanaPlus|
  	
  	 @Gaana @Regression
 Scenario: Verify the different icons/buttons on home page for 'Non-logged in' user
    Given user opens the application "homePage"
    Then user verifies the Gaana logo is displayed on home page
    And user verifies the "Go Ad Free" "Get Gaana Plus" buttons on the home page
    And user verifies the language icon on the home page
    And user verifies the theme icon on the home page
    And user verifies the carousel banner on the home page
   
  	
  @Gaana @Regression
  Scenario Outline: Verify the options under user icon for NonGaanaPlus user
    Given user opens the application "homePage"
    Then user logins with "<loginType>"
    Then user clicks on user icon
    Then user verifies the options under user icon "Profile,Languages,Settings,Log Out,Night Mode"
    Then user verifies that "Night Mode" button is displayed

    Examples: 
      | loginType    |
      | NonGaanaPlus |

  @Gaana @Regression
  Scenario Outline: Verify the options under user icon for GaanaPlus user
    Given user opens the application "homePage"
    Then user logins with "<loginType>"
    Then user clicks on user icon
    Then user verifies the options under user icon "Profile,Languages,Settings,Log Out,Night Mode"
    Then user verifies that "Night Mode" button is displayed

    Examples: 
      | loginType |
      | GaanaPlus |

  @Gaana @Regression
  Scenario Outline: Verify the home page Menu list options for NonGaanaPlus user
    Given user opens the application "homePage"
    Then user logins with "<loginType>"
    Then user verifies the menu list options "All,Trending,New Releases,Old Hits,Moods & Genres,Radio,Podcast,My Music"

    Examples: 
      | loginType    |
      | NonGaanaPlus |

  @Gaana @Regression
  Scenario Outline: Verify the home page Menu list options for GaanaPlus user
    Given user opens the application "homePage"
    Then user logins with "<loginType>"
    Then user verifies the menu list options "All,Trending,New Releases,Old Hits,Moods & Genres,Radio,Podcast,My Music"

    Examples: 
      | loginType |
      | GaanaPlus |

  @Gaana @Regression
  Scenario: Verify the home page Menu list options for 'Non-logged in' user
    Given user opens the application "homePage"
    Then user verifies the menu list options "All,Trending,New Releases,Old Hits,Moods & Genres,Radio,Podcast,My Music"

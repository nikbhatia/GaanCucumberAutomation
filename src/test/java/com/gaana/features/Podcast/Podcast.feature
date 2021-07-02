Feature: Test Scenarios of podcast page

  Author: nikhil.bhatia@gaana.com

  @Gaana1
 Scenario Outline: Verify headings,Breadcrumbs,sections on podcast page for GaanaPlus user
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


  @Gaana1
  Scenario Outline: Verify headings,Breadcrumbs,sections on podcast page for Non GaanaPlus user
    Given user opens the application "homePage"
    Then user logins with "<loginType>"
    When user opens the application "podcastPage"
    And  user verifies "Breadcrumb Title" with value "Gaana" "Podcast"
    And  user verifies "Page Heading" with value "Podcast"
    Then user verifies Sections and its headings
    And  user verifies "Gaana Tagline" with value "Bas Bajna Chahiye Gaana"

    Examples:
      |loginType   |
      |NonGaanaPlus|

  @Gaana1
  Scenario: Verify headings,Breadcrumbs,sections on podcast page for Non Logged In user
    Given user opens the application "homePage"
    When user opens the application "podcastPage"
    And  user verifies "Breadcrumb Title" with value "Gaana" "Podcast"
    And  user verifies "Page Heading" with value "Podcast"
    Then user verifies Sections and its headings
    And  user verifies "Gaana Tagline" with value "Bas Bajna Chahiye Gaana"



  @Gaana1
 Scenario Outline: Verify podcast played from podcast page for Gaana Plus user
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


  @Gaana1
  Scenario Outline: Verify podcast played from podcast page for Non Gaana Plus user
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
      |NonGaanaPlus|

  @Gaana1
  Scenario: Verify podcast played from podcast page for Non Logged In user
    Given user opens the application "homePage"
    When user opens the application "podcastPage"
    And  user verifies "Breadcrumb Title" with value "Gaana" "Podcast"
    Then  user clicked on first podcast
    And   user verifies podcast heading and breadcrumb for podcast
    Then  user played the podcast
    And   user verifies podcast is being played


  @Gaana1
  Scenario Outline: Verify sorting on podcast page for Gaana Plus user
    Given user opens the application "homePage"
    Then  user logins with "<loginType>"
    When  user opens the application "particularPodcast"
    And   user verifies "Episode Headings" with value "Episode" "Uploaded On" "Duration"
    And   user verifies sorting is working correctly

    Examples:
      |loginType   |
      |GaanaPlus   |

  @Gaana1
  Scenario Outline: Verify sorting on podcast page for Non Gaana Plus user
    Given user opens the application "homePage"
    Then  user logins with "<loginType>"
    When  user opens the application "particularPodcast"
    And   user verifies "Episode Headings" with value "Episode" "Uploaded On" "Duration"
    And   user verifies sorting is working correctly

    Examples:
      |loginType   |
      |NonGaanaPlus|

  @Gaana1
  Scenario: Verify sorting on podcast page for Non Logged In User
    Given user opens the application "homePage"
    When  user opens the application "particularPodcast"
    And   user verifies "Episode Headings" with value "Episode" "Uploaded On" "Duration"
    And   user verifies sorting is working correctly


  @Gaana2
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






























#      |/consumer_promo_term_and_condition.html|
#      |/configuration.xml|
#      |/crossdomain.xml|
#      |/euc.html|
#      |/FreeLookUp_TnC.html|
#      |/gaanaplus-cancellationpolicy.html|
#      |/gaanatnc_uk.html|
#      |/haptik-tnc.html|
#      |/healthcheck.php|
#      |/iTunes_terms.html|
#      |/Limited_Period_Special_Offer_TnC.html|
#      |/LimitedPeriodSpecialOffer_TnC.html|
#      |/mgflyaway_terms_and_conditions.html|
#      |/NewYearOffer.html|
#      |/onePlusone-terms.html|
#      |/privacy_policy_eu.html|
#      |/ps.html|
#      |/Republic_TnC.html|
#      |/secureplus.php|
#      |/SpecialOffer_TnC.html|
#      |/terms_and_conditions.html|
#      |/Terms_conditions_subscription_deleted.html|
#      |/terms-conditions-free_lookup.html|
#      |/terms-conditions-ROI.html|
#      |/terms-conditions-studentpack.html|
#      |/terms-conditions.html|
#      |/TheChainsmokers_terms_and_conditions.html|
#      |/tnc_paytm.html|
#      |/TIL.html|
#      |/Valentine_TnC.html|
#      |/under_rmaintainence.jpg|
#      |/windows8_terms_and_conditions.htm|
#      |/widgets|
#      |/tnc/*|
#      |/sitemap/*|
#      |/cache/*|
#      |https://gaana.com/lyrics/amp/*|
#      |https://gaana.com/song/amp/*|
#      |/consumer_promo_term_and_condition.html|
#      |/disclaimer.html|
#      |/euc.html|
#      |/FreeLookUp_TnC.html|
#      |/gaanaplus-cancellationpolicy.html|
#      |/gaanatnc_uk.html|
#      |/haptik-tnc.html|
#      |/iTunes_terms.html|
#      |/Limited_Period_Special_Offer_TnC.html|
#      |/LimitedPeriodSpecialOffer_TnC.html|
#      |/mgflyaway_terms_and_conditions.html|
#      |/NewYearOffer.html|
#      |/onePlusone-terms.html|
#      |/privacy_policy_eu.html|
#      |/Republic_TnC.html|
#      |/SpecialOffer_TnC.html|
#      |/terms_and_conditions.html|
#      |/Terms_conditions_subscription_deleted.html|
#      |/terms-conditions-free_lookup.html|
#      |/terms-conditions-ROI.html|
#      |/terms-conditions-studentpack.html|
#      |/terms-conditions.html|
#      |/TheChainsmokers_terms_and_conditions.html|
#      |/TIL.html|
#      |/tnc_paytm.html|
#      |/Valentine_TnC.html|
#      |/windows8_terms_and_conditions.html|
#
#
#
#






































































































































































































































































































































































































































































































































































































































































































































































































































































































































































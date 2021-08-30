Feature: Test scenario for player

  @Gaana
  Scenario: To verify the player functionality
    Given user opens the application "homePage"
    And user clicks on first trending song
    Then user clicks on play button
    Then user verifies the player is opened
    Then user verifies next song icon is enabled after song is played some time
    Then user verifies play option is changed to pause
    Then user verifies the next song shown in the player is same as appearing in Queue list
    Then user verifies user able to remove song from the queue list
    And user clicks on clear list button
    Then user verifies clear Queue pop up is opened
    Then user verifies all the songs in the queue is removed from clear list pop up


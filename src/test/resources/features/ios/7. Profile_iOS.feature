@test-set:regression
Feature: Profile features on Mobile Application | iOS Environment

  Background:
    Given the user accesses to MAFAO iOS application
    When checks if user is already logged in
    And enters a valid secret code and taps on confirm
    Then the user is logged in on MAFAO mobile application

  Scenario: Log out from iOS
    Given the user is on marketplace screen
    When user goes to profile screen
    And clicks on log out
    Then the user is logged out successfully
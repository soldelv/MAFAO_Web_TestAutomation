@test-set:regression
Feature: Favorites features on Mobile Application | iOS Environment

  Background:
    Given the user accesses to MAFAO iOS application
    When checks if user is already logged in
    And enters a valid secret code and taps on confirm
    Then the user is logged in on MAFAO mobile application

  Scenario Outline: Add products as Favorite from product screen
    Given the user is on marketplace screen
    When taps on <product_1> from marketplace
    And taps on the heart icon to add the product as a favorite
    And goes to favorite section
    Then <product_1> is displayed on Favorites list
    Examples:
      |  product_1    |
      |  Baby clothes |

  Scenario Outline: Create and remove an alert
    Given the user is on marketplace screen
    When the user searches for <keyword> on the searchbar
    And products related to <keyword> are displayed
    And taps on create an alert
    And goes to favorite section
    And taps on Alerts
    Then <keyword> alert is displayed
    And tap on delete alert
    Then alert was successfully deleted
    Examples:
      |  keyword   |
      |  Football  |

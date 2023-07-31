Feature: Home features on Mobile Application | iOS Environment

  Background:
    Given the user accesses to MAFAO iOS application
    When checks if user is already logged in
    And enters a valid secret code and taps on confirm
    Then the user is logged in on MAFAO mobile application


  @SmokeTest @RegressionTest
  Scenario: HOME | Display/Scroll products in Marketplace
    Given the user is on marketplace screen
    When scrolls down on the home
    Then the user can see the products listed

  @SmokeTest @RegressionTest
  Scenario Outline: HOME | Search Products by keyword
    Given the user is on marketplace screen
    When the user searches for <keyword> on the searchbar
    Then products related to product <keyword> are displayed
    Examples:
      |   keyword   |
      |   Football  |

  Scenario: HOME | Filter products by category
    Given the user is on marketplace screen
    When taps on Informatique from Home
    Then products related to the category are displayed
    And taps on Hardware from Home
    Then products related to the category are displayed
    And taps on Sport from Home
    Then products related to the category are displayed
    And taps on Toys and Accessories from Home
    Then products related to the category are displayed
    And taps on Home, Kitchen and Office from Home
    Then products related to the category are displayed
    And taps on Hypermarket from Home
    Then products related to the category are displayed
    And taps on Equipement from Home
    Then products related to the category are displayed
    And taps on Fêtes from Home
    Then products related to the category are displayed
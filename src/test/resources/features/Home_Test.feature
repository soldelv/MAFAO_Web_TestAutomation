@test-set:regression
Feature: Mobile App: Home
  Test coverage:
  - Display products in Marketplace
  - Search products
  - Filter products by category

  Background:
    Given the user accesses to MAFAO application
    When the user enters valid credentials
    Then the user is logged in on MAFAO mobile application

  Scenario: Display products in Marketplace
    Given the user is on marketplace screen
    When scrolls down on the home
    Then the user can see the products listed

   @Ignore
  Scenario Outline: Search products by keyword
    Given the user is on marketplace screen
    When the user searches for <keyword> on the searchbar
    Then products with word <keyword> are displayed
    Examples:
      |   keyword   |
      |   football  |
      #|   shirt     |

  Scenario Outline: Filter products by category
    Given the user is on marketplace screen
    When taps on <category> from Home
    Then products related to <category> are displayed
    Examples:
      |   category   |
      |   Sport      |
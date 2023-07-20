@test-set:regression
Feature: Favorites features in MAFAO APP Mobile for Android
  Test coverage: Add and remove products from favorites list

  # USER LOGIN
  #Background:
  #  Given the user accesses to MAFAO application
  #  When the user enters valid credentials
  #  Then the user is logged in on MAFAO mobile application

    # USER ALREADY LOGGED IN
  Background:
    Given the user accesses to MAFAO application
    When the user enters just pincode
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

@test-set:regression
Feature: Orders features on Mobile Application | iOS Environment

    # USER ALREADY LOGGED IN
  Background:
    Given the user accesses to MAFAO iOS application
    When the user enters just pincode
    Then the user is logged in on MAFAO mobile application

  Scenario Outline: Add and remove a product from cart
    Given the user is on marketplace screen
    When taps on <product_1> from marketplace
    And taps on plus icon
    And taps on minus icon
    And add <product_1> to cart
    And goes to orders screen
    Then <product_1> is displayed on Orders list
    And taps on trash icon to remove product from the list
    Then the product was removed successfully
    Examples:
      |    product_1    |
      | 3 in 1 Multipod |


  Scenario Outline: Purchase successfully by Paypal
    Given the user is on marketplace screen
    When taps on <product_1> from marketplace
    And add <product_1> to cart
    And goes to orders screen
    And taps pay your order
    And the user logs into Paypal and confirm the payment
    Then your order has been registered screen should be displayed
    Examples:
      |  product_1     |
      | Football Ball  |

  Scenario Outline: Purchase successfully by MAFAO wallet
    Given the user is on marketplace screen
    When scrolls down and taps on <product_1> from marketplace
    And add <product_1> to cart
    And goes to orders screen
    And taps on change payment method
    And selects MAFAO wallet as a payment method
    And taps pay your order
    Then your order has been registered screen should be displayed
    Examples:
      |  product_1 |
      | Postcards  |

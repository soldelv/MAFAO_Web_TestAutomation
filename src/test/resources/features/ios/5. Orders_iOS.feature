Feature: Orders features on Mobile Application | iOS Environment

  Background:
    Given the user accesses to MAFAO iOS application
    When checks if user is already logged in
    And enters a valid secret code and taps on confirm
    Then the user is logged in on MAFAO mobile application

  Scenario Outline: ORDERS | Add and remove a product from cart
    Given the user is on marketplace screen
    When taps on <product_name> from marketplace
    And taps on plus icon
    And taps on minus icon
    And add <product_name> to cart
    And goes to orders screen
    Then <product_name> is displayed on Orders list
    And taps on trash icon to remove product from the list
    Then the product was removed successfully
    Examples:
      |  product_name   |
      | 3 in 1 Multipod |

    Scenario Outline: ORDERS | Check out successfully by Paypal
    Given the user is on marketplace screen
    When taps on <product_name> from marketplace
    And add <product_name> to cart
    And goes to orders screen
    And taps pay your order
    And the user logs into Paypal and confirm the payment
    Then your order has been registered screen should be displayed
    Examples:
      |  product_name  |
      | Football Ball  |

  Scenario Outline: ORDERS | Check out successfully by MAFAO wallet
    Given the user is on marketplace screen
    When scrolls down and taps on <product_name> from marketplace
    And add <product_name> to cart
    And goes to orders screen
    And taps on change payment method
    And selects MAFAO wallet as a payment method
    And taps pay your order to finish the purchase
    Then your order has been registered screen should be displayed
    Examples:
      | product_name |
      |   Postcards  |

  Scenario Outline: ORDERS | Paid Order tab display after checkout & Transaction Details
    Given the user is on marketplace screen
    And goes to orders screen
    And user goes to Pay Order tab
    Then the order with <product_name> is on the list
    And taps on the order with <product_name>
    Then paid order transaction details are displayed
    Examples:
      |  product_name |
      |   Postcards   |


@test-set:regression
Feature: Seller Account features | MAFAO Odoo Environment

  Background:
    Given The user access to MAFAO homepage
    When the user clicks on Login with Keycloak button
    And the user logs in as a seller with valid credentials
    Then seller dashboard page displays correctly

  @user-type:seller
  Scenario: Add Pickup Location
    Given the seller goes to Seller Pickup Location screen
    When clicks on create
    And fills Merchants Pick up Location form and clicks on save
    Then the new location is on pick up list

  @user-type:seller
  Scenario: Add products
    Given the seller goes to New Product screen
    When fills information of new product form
    And fills variants details of new product form
    And uploads images for the new product
    And fills inventory of new product form
    And selects pick up location
    And creates a group of discounts
    And clicks on Request To Approve button
    Then the new product is on Pending list
@test-set:regression
Feature: Priority features | MAFAO Odoo Environment

  Background:
    Given The user access to MAFAO homepage

  @user-type:admin
  Scenario: Login as an admin in MAFAO website
    Given the user logs in as an admin
    When admin dashboard page displays correctly
    Then the user logs out

  @user-type:seller
  Scenario: Login with Keyloack in MAFAO website
    Given the user clicks on Login with Keycloak button
    When the user logs in as a seller with valid credentials
    And seller dashboard page displays correctly
    Then the user logs out

  @user-type:seller
  Scenario: Reset pincode
    Given the user clicks on Reset Pin Code
    When enters a registered mobile number - odoo
    And enters OTP code received - odoo
    And the new pincode twice and clicks on Confirm button
    Then passcode changed successful message must be displayed
    And redirects you to Login page again
    And the user clicks on Login with Keycloak button
    And the user logs in as a seller with valid credentials
    Then seller dashboard page displays correctly

  @user-type:seller
  Scenario: Sign up as a Seller
    Given the user clicks on Login with Keycloak button
    When the user logs in as a seller with valid credentials
    And seller dashboard page displays correctly
    Then the user logs out

  @user-type:seller
  Scenario: Add Pickup Location
    When the user clicks on Login with Keycloak button
    And the user logs in as a seller with valid credentials
    And seller dashboard page displays correctly
    And the seller goes to Seller Pickup Location screen
    When clicks on create
    And fills Merchants Pick up Location form and clicks on save
    Then the new location is on pick up list

  @user-type:seller
  Scenario: Add products
    When the user clicks on Login with Keycloak button
    And the user logs in as a seller with valid credentials
    And seller dashboard page displays correctly
    And the seller goes to New Product screen
    And fills information of new product form
    And fills variants details of new product form
    And uploads images for the new product
    And fills inventory of new product form
    And selects pick up location
    And creates a group of discounts
    And clicks on Request To Approve button
    Then the new product is on Pending list

  @user-type:admin
  Scenario: Approve Product as an Admin
    Given The user clicks on User icon
    When the user logs in as an admin
    And admin dashboard page displays correctly
    And admin clicks on Pending button from Marketplace Products section
    And chooses the first product from the list
    And clicks on approve button
    And clicks on Approve and Publish
    Then the product recently approved is no longer displayed in the list

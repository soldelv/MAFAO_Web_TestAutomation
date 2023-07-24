@test-set:regression
Feature: Login features | MAFAO Odoo Environment

  Background:
    Given The user access to MAFAO homepage
    When The user is on Login Page

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
@smoke
Feature: Verification of registered user information in account page

  Scenario: User logins into account and verifies address, email, phone number for registered user
    Given User navigates to 'url'
    And   User clicks on login link on different viewports
    When  User logs in with 'username' and 'password'
    Then  User asserts user name on account page reflects 'Jaime Guitron'
    Then  User asserts email-address on account page reflects 'jguitron@ashleyfurniture.com'
    Then  User asserts phone number on account page reflects '887-766-5547'
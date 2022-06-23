Feature: Verification of creating new address in account tab
@bolts
  Scenario: User adds new address to existing account in account tab
    Given User navigates to "url"
    And   User clicks on login link on different viewports
    When  User logs in with "username" and "password"
    And   User clicks on "addressbook" in account
    And   User creates new address in account tab
    And   User inputs generated new address data into fields
    And   User enters personal information into create new address tab
    And   User deletes saved address




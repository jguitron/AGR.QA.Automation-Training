Feature: User Verifies Address Functionality for Registered User
@WIP

  Scenario: User edits address in account page and creates new address
    Given User navigates to "url"
    And   User clicks on login link on different viewports
    When  User logs in with "username" and "password"
    And   User clicks on "addressbook" in account
    Then  User clicks on "edit" button in saved address
    And   User edits First Name and Last Name in edit address to "paige", "lafon"
    And   User asserts field change in address tab
    And   User makes edited address to "make-default"
    And   User asserts created address is now primary address
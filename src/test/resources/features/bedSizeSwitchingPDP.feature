Feature: Verification of Bed Size Switching on PDP
  @glitterglamgarrett
  Scenario: User Changes between different bed size verifying switching occurs
    Given User navigates to "url"
    When  User clicks on search bar
    And   User search's "Chime 12 Inch Hybrid Twin Mattress in a Box, White, large" in search bar
    And   User clicks on search icon
    And   User chooses "Chime 12 Inch Hybrid Twin Mattress in a Box, White, large" in plp
    And   User asserts "twin" bed size displayed on PDP
    Then  User changes bed size in PDP to ones not currently displayed by "4" mattress and asserts change

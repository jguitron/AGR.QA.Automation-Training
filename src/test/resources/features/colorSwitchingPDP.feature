@smoke @regression
Feature: Verification of Color Switching on PDP

  Scenario: User Changes between different colors schemes verifying switching occurs
    Given User navigates to 'url'
    And   User search's 'Darcy Loveseat' in search bar
    And   User chooses 'Darcy Loveseat, Cobblestone, large' in plp
    And   User asserts 'Cobblestone' color displayed on PDP
    Then  User changes color scheme in PDP to ones not currently displayed by colors different colors and asserts change
      | Salsa       |
      | Mocha       |
      | Cafe        |
      | Cobblestone |
      | Blue        |
      | Black       |
      | Steel       |

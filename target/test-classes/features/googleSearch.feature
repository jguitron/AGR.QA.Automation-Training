
  Feature: Google search
    Search argument and verify search functionality behavior.

    @smoke
    Scenario: User enters value and checks search bar works correctly
      Given User is on google home page
      When User clicks on search bar
      And User types "Tesla" in search bar and clicks enter
      Then User should see "Tesla" in results page

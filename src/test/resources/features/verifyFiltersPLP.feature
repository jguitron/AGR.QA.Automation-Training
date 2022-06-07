Feature: Verify PLP filters changes results of products in PLP

  Scenario: User chooses product filters and verifies filter changes
    Given  User navigates to "url"
    Then   User Hovers over header and clicks on "Sofas" category
    Then   User clicks on item filters in PLP and asserts change
    Then   User clears all from filters
    Then   User clicks on item filters in plp and asserts change






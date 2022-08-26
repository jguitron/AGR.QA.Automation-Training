@smoke
Feature: Verify PLP filters changes results of products in PLP

  Scenario: User chooses product filters and verifies filter changes
    Given  User navigates to 'url'
    Then   User Hovers over header and clicks on 'furniture/living-room/sofas/' category
    Then   User clicks on item filters in PLP and asserts change with filters
      | lifestyle           |
      | facetProductWidthIn |
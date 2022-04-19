@smoke
Feature: Add Whitesburg Dining Table to cart and remove, validating cart reflects removal

  Scenario: User adds Whitesburg table to cart
    Given User navigates to "url"
    And  User clicks on the search bar
    Then User search's Whitesburg Dining Table in search bar
    And  User clicks search icon
    Then User clicks on Whitesburg Dining Table
    And  User clicks Add Item to Cart Mobile
    And User is in cart page
    When  User validates item in cart
    And   User Removes item from cart
    Then  User Validates cart is 0 qty


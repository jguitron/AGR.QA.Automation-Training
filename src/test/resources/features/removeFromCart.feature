@smoke
Feature: Add Whitesburg Dining Table to cart and remove, validating cart reflects removal

  Scenario: User adds Whitesburg table to cart
    Given User navigates to "url"
    And  User clicks on search bar
    Then User search's "Whitesburg Dining Table" in search bar
    And  User clicks on search icon
    Then User chooses "Whitesburg Dining Table, , large" in plp
    And  User clicks on Add Item to Cart
    And  User clicks on cart
    And  User Removes item from cart
    Then User Validates cart is 0 qty


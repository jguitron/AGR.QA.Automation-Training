@glitterglamgarrett
Feature: Verification of Item removed from cart
  Scenario: User Adds item to cart and removes from mini cart
    Given User navigates to "url"
    And   User clicks on the search bar
    Then  User search's "Ultra Luxury Euro Top with Memory Foam Queen Mattress" in search bar
    Then  user clicks on search icon
    Then  User clicks on "Ultra Luxury ET with Memory Foam Queen Mattress, White, large" in pdp
    Then  User clicks on Add Item to Cart
    Then  User Removes item from mini cart
    Then  User asserts items removed from mini cart and is 0 qty

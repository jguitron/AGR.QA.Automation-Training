@garrett
Feature: Verification of Item removed from cart
  Scenario: User Adds item to cart and removes from mini cart
    Given User navigates to "url"
    And   User clicks on search bar
    Then  User search's "Ultra Luxury Euro Top with Memory Foam Queen Mattress" in search bar
    Then  User clicks on search icon
    Then  User chooses "Ultra Luxury ET with Memory Foam Queen Mattress, White, large" in plp
    Then  User clicks on Add Item to Cart
    Then  User Removes item from mini cart
    Then  User asserts qty in mini cart is "0"

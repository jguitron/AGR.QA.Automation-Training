@smoke
Feature: Verification of Item removed from cart
  Scenario: User Adds item to cart and removes from mini cart
    Given User navigates to "url"
    Then  User search's "Ultra Luxury Memory Foam" in search bar
    Then  User chooses "Ultra Luxury Firm Tight Top with Memory Foam King Mattress, White, large" in plp
    Then  User clicks on Add Item to Cart
    Then  User Removes item from mini cart
    Then  User asserts items in mini cart is "0" qty


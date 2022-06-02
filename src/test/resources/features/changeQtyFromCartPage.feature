@smoke @wip
Feature: When Item is Added to Cart, Qty can be changed in Cart Page

  Scenario: User Adds 8 Chime Inch Innerspring Twin Mattress to Cart
    Given User navigates to "url"
    When  User clicks on search bar
    And   User search's "Chime 8 Inch Innerspring Twin Mattress" in search bar
    And   User clicks on search icon
    And   User chooses "8 Inch Chime Innerspring Twin Mattress in a Box, White, large" in plp
    And   User clicks on Add Item to Cart
    Then  User clicks on cart
    Then  User changes Qty from 1 to 2 in cart
    Then  Assert total number of items in cart is 2



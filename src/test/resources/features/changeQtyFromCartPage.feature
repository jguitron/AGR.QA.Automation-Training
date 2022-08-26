@smoke
Feature: When Item is Added to Cart, Qty can be changed in Cart Page

  Scenario: User Adds 8 Chime Inch Innerspring Twin Mattress to Cart
    Given User navigates to 'url'
    And   User search's 'Chime 8 Inch Innerspring Twin Mattress' in search bar
    And   User chooses '8 Inch Chime Innerspring Twin Mattress in a Box, White, large' in plp
    And   User clicks on Add Item to Cart
    Then  User clicks on cart icon
    Then User clicks on Confirm button to confirm the zip code
    Then  User changes Qty from '1' to '2' in cart
    Then  Assert cart is reflecting 'My Cart (2 items)' QTY change
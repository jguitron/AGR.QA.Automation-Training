@smoke
Feature: When Item is Added to Cart, Qty can be changed in Cart Page

  Scenario: User Adds 8 Inch Innerspring Twin Mattress in a Box to Cart
    Given User navigates to "url"
    When  User clicks on the search bar
    And   User search's 8 Inch Innerspring Twin Mattress in a Box in Search bar
    And   User clicks search icon
    And   User clicks on 8 Inch Innerspring Twin Mattress in a Box
    And    User clicks on Add Item to Cart
    Then  User is in cart page
    Then  User changes Qty from 1 to 2
    Then  Assert total number of items in cart is 2

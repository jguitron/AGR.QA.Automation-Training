@test
Feature: Verification of 3 Items added to cart is reflected in "mini cart logo" as 3 total items

  Background:
    Given User navigates to "url"

  Scenario Outline: User adds 1st items to cart
    When  User clicks on the search bar
    And   User search's sofa in search bar
    And   User clicks on "<itemName>"
    Then  User clicks on Add Item to Cart
    Examples:
      | itemName                       |
      | Darcy Sofa, Cobblestone, large |
      | Bladen Sofa, Coffee, large     |


  Scenario: User adds 2nd item to cart
    Given User backspaces to previous PLP
    When  User clicks on Soletren Sofa
    And   User clicks on Add Item to Cart


  Scenario: User Adds 3rd item to cart
    Given User backspaces to previous PLP
    When  User clicks on Calion Sofa


  Scenario: User verifies count in cart is equal to total amount added
    Given  Asserts total is equal to total added  in cart


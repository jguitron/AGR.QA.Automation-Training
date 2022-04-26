Feature: Verification of Save for Later button in mini cart
@glittergarrett
  Scenario: User saves for later in Mini Cart
    Given User navigates to "url"
    And   User clicks on search bar
    And   User search's "Chime 8 Inch Innerspring Queen Mattress" in search bar
    And   user clicks on search icon
    Then  User chooses "8 Inch Chime Innerspring Queen Mattress in a Box, White, large" in plp
    And   User clicks on Add Item to Cart
    And   User clicks on save for later
    And   User Logs in
    Then  User clicks on cart icon
    Then  User asserts "8 Inch Chime Innerspring Queen Mattress in a Box, White, large" saved items in cart
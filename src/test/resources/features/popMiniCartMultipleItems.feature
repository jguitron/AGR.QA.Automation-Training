Feature: Verify Popup on Mobile reflects multiple items added

  Scenario: User adds one item and asserts total in popup
    Given User navigates to "url"
    When  User clicks on search bar
    And   User search's "Chime 8 Inch Innerspring Queen Mattress" in search bar
    And   User clicks on search icon
    Then  User chooses "8 Inch Chime Innerspring Queen Mattress in a Box, White, large" in plp
    Then  User change qty from 1 to 2 in PDP
    And   User clicks on Add Item to Cart
    Then  User asserts items in popup is "Chime 8 Inch Innerspring Queen Mattress" qty or item
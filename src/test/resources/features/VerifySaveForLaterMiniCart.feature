Feature: Verification of Save for Later button in mini cart

  Scenario: User saves for later in Mini Cart
    Given User is on AshleyFurniture's main home page
    When  User clicks on X-close button to close iframe popup
    And   User clicks on the search bar
    And   User search's B600008392 in search bar
    Then  User adds Delta Children Mercer Crib to cart
    And   User clicks on save for later
    And   User Logs in
    Then  User clicks on cart icon
    Then  User asserts saved items in cart
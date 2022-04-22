Feature: Verification of Save for Later button in mini cart

  Scenario: User saves for later in Mini Cart
    Given User navigates to "url"
    And   User clicks on the search bar
    And   User search's "Delta Children Mercer Crib" in search bar
    And   User clicks search icon
    Then  User clicks on "Delta Children Mercer 6-in-1 Convertible Crib with Storage Trundle, Black/Gray, large" in pdp
    And   User clicks on Add Item to Cart
    And   User clicks on save for later
    And   User Logs in
    Then  User clicks on cart icon
    Then  User asserts "Delta Children Mercer 6-in-1 Convertible Crib with Storage Trundle" saved items in cart
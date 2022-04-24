Feature: Verification of Save for Later button in mini cart

  Scenario: User saves for later in Mini Cart
    Given User navigates to "url"
    And   User clicks on search bar
    And   User search's "Delta Children Mercer Crib" in search bar
    And   user clicks on search icon
    Then  User chooses "Delta Children Mercer 6-in-1 Convertible Crib with Storage Trundle, Black/Gray, large" in plp
    And   User clicks on Add Item to Cart
    And   User clicks on save for later
    And   User Logs in
    Then  User clicks on cart icon
    Then  User asserts "Delta Children Mercer 6-in-1 Convertible Crib with Storage Trundle" saved items in cart
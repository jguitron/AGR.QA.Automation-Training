
Feature: Verification of eligible and non eligible protection plans per zipcode

  Scenario: 33606 Zip Code with eligible protection plan
  CartSizeVerification.feature
    When User clicks on X-close button to close iframe popup
    When  User clicks on Location Icon
    Then  User changes zipcode to 33606
    Then  User clicks update button
    And   User clicks on the search bar
    Then  User search's 7500538 in search bar
    Then  User Adds Darcy Sofa SKU: 750053 to cart
    And   User Validates 1.5 FPP is eligible for furniture

@smoke
Feature: Verify State Recycling fee is displayed in Cart, Shipping and billing pages when user select a CA store.

  Scenario: User sets store as Florida store
    Given User navigates to "url"
    Then User finds closest store by "90011"

  Scenario: User adds Mattress to cart and validate recycling fee for CA store
    Then  User searches for SKU "M69511" and clicks on it
    Then  User clicks on Add Item to Cart
    Then User navigate to cart page
    Then User Verifies Recycle Fee is displayed
    Then User clicks on Secure Check out button
    Then User enters customer info on Secure Checkout Delivery Page
      | "FName"       |
      | "LName"       |
      | "100 Main St" |
      | "Apt 12"      |
      | "Los Angeles" |
      | "California"  |
      | "90011"       |
      | "6126543265"  |
      | "qa@test.com" |
    Then User clicks on Continue as Guest button
@smoke
Feature: Verify State Recycling fee is displayed in Shipping and billing pages when user select a CA store and not displayed for non - CA stores

  Scenario: Verify recycle fee is available when CA store is selected.
    Given User navigates to "url"
    Then User finds closest store by "90011"
    Then  User searches for SKU "M69511" and clicks on it
    Then  User clicks on Add Item to Cart
    Then User navigate to cart page
    Then User clicks on Secure Check out button
    Then User enters customer info on Secure Checkout Delivery Page
      | FName       |
      | LName       |
      | 100 Main St |
      | Apt 12      |
      | Los Angeles |
      | California  |
      | 90011       |
      | 6126543265  |
      | qa@test.com |
    Then User clicks on Continue as Guest button
    Then User clicks on Use Original button on PopUp window
    Then User Verifies Recycle Fee is displayed on SecureCheckOut Shipping Page only for CA store
    Then User clicks on continue to billing and payment button
    Then User Verifies Recycle Fee is displayed on SecureCheckOut Billing Page only for CA store

  Scenario: Verify recycle fee is NOT available when non- CA store is selected.
    Given User navigates to "url"
    Then User finds closest store by "28262"
    Then  User searches for SKU "M69511" and clicks on it
    Then  User clicks on Add Item to Cart
    Then User navigate to cart page
    Then User clicks on Secure Check out button
    Then User enters customer info on Secure Checkout Delivery Page
      | FName          |
      | LName          |
      | 100 Main St    |
      | Apt 12         |
      | Charlotte      |
      | North Carolina |
      | 28262          |
      | 6126543265     |
      | qa@test.com    |
    Then User clicks on Continue as Guest button
    Then User clicks on Use Original button on PopUp window
    Then User Verifies Recycle Fee is displayed on SecureCheckOut Shipping Page only for CA store
    Then User clicks on continue to billing and payment button
    Then User Verifies Recycle Fee is displayed on SecureCheckOut Billing Page only for CA store


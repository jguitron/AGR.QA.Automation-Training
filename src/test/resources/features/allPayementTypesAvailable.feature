@smoke @regression  @bstack
Feature: Verification of available payment types in cart page
  As a user, I should be able to choose desired payment method; CC, AA, PL, Caddipay, Acima or PP

  Scenario: User sets store as Florida store, search for an item, add item to cart and navigate to Cart Page
    Given User navigates to "url"
    Then User finds closest store by "33544"
    Then User searches for SKU "A2000223" and clicks on it
    Then User clicks on Add Item to Cart
    Then User navigate to cart page
    Then User clicks on Confirm button to confirm the zip code
    Then User clicks on Secure Check out button
    Then User fills in customer and shipping info using auto address selection
      | QA                     |
      | Tester                 |
      | 26222 Golden Maple Rd, |
      | Wesley Chapel          |
    Then User clicks on Continue as Guest button
    Then User clicks on continue to billing and payment button
    Given User is on Billing and Payment Page
    Then Credit card Payment option is available
    And Credit card Payment option fields are displayed
    Then Ashley Advantage Payment option is available
    Then User clicks on Ashley Advantage Payment option
    And Ashley Advantage Payment option logos and fields are displayed
    Then Progressive leasing Payment option is available
    Then User clicks on Progressive leasing Payment option
    And Progressive leasing Payment option logos and fields are displayed
    Then Acima Payment option is available
    Then Caddipay Payment option is available
    Then User clicks on Caddipay Payment option
    Then User verifies that Caddipay page is launched then close the window
    Then User verifies Paypal Payment option is available
    Then User clicks on Paypal Payment option and verifies paypal window is launched




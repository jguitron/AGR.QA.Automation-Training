@regression  @smoke @wip
Feature: Verify State Recycling fee is displayed in Cart, Shipping and billing pages when user select a CA store.

  Scenario: User sets store as Florida store
    Given User is on AshleyFurniture's main home page
    When  User clicks on X-close button to close iframe popup
    Then user set the closet store by "90011"

  Scenario: User adds Mattress to cart and validate recycling fee for CA store
    Then  User search for a SKU "M69511" and clicks on it
    Then  User adds items to cart
    Then User navigate to cart page
    Then User Verifies Recycle Fee is displayed
    Then User clicks on Secure Check out button
    Then User enters customer info "FName" , "LName" ,"100 Main St", "Apt 12", "Los Angeles", "California", "90011", "6126543265", "qa@test.com" on Secure Checkout Delivery Page
    Then User clicks on Continue as Guest button
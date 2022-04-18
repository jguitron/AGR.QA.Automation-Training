@regression  @smoke
Feature: Verify Pop up message is displayed if Progressive payment is selected with a Protection plan

  Scenario: User sets store as Florida store
    Given User is on AshleyFurniture's main home page
    When  User clicks on X-close button to close iframe popup
    Then user set the closet store by "33606"

  Scenario: User adds item with Furniture PP to cart and navigate to billing page
    Then  User search for a SKU "APK-12020-3R" and clicks on it
    Then User verifies that FPP available on PDP
    Then  User adds items to cart
    Then User navigate to cart page
    Then User clicks on Secure Check out button
    Then User enters customer info "FName" , "LName" ,"100 Main St", "Apt 12", "Tampa", "Florida", "33606", "6126543265", "qa@test.com" on Secure Checkout Delivery Page
    Then User clicks on Continue as Guest button
    Then User clicks on Use Original button on PopUp window
    Then User clicks on continue to billing and payment button
    Then User clicks on Progressive leasing Payment option
    Then User verifies that Progressive Popup for ProtectionPlan is displayed
    Then User click on Continue with Progressive Leasing button in Progressive popup msg

  Scenario: User Navigate back to cart and remove existing item
    Then User navigate back to cart page
    Then User remove item from cart
    Then User closes browser





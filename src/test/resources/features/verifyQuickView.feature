Feature: Verification of quick view in PDP
  @garrett
  Scenario: Navigate to the PDP page and click on quick view and verify tab
    Given User navigates to "url"
    When  User Hovers over header and clicks on "Sofas" category
    Then  User clicks on quick view in PLP
    Then  User clicks on arrows switching between products in PLP
    Then  User changes color scheme in quick view and asserts change mobile skip included
      | Slate       |
      | Coffee      |
    And   User change qty from 1 to 2 in PLP quick view
    And   User clicks on Add Item to Cart mobile skip
    Then  User clicks on learn more and closes
    And   User clicks x to exit quick view
    And   User asserts items in mini cart is "2" qty

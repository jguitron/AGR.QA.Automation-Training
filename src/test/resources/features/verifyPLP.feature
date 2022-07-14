Feature: Verification of PLP through search results
@smoke @WIP
  Scenario: User verifies PLP page components through search
    Given User navigates to "url"
    And   User search's "Sofas" in search bar
    Then  User checks for "Learn More" button is present
    Then  User asserts "prequal" in learn how popup with "Prequalify Now"
    Then  User asserts "apply" in learn how popup with "Apply Now"
    Then  User clicks second page of inventory and asserts that "page-2" is "2"
    Then  User clicks next button icon and lands user on page "3"
    Then  User clicks on last page of inventory and asserts page


    Scenario: User verifies PLP page components through navigation drawer
      Given User navigates to "url"
      When  User Hovers over header and clicks on "furniture/living-room/sofas/" category
      Then  User checks for "Learn More" button is present
      Then  User asserts "prequal" in learn how popup with "Prequalify Now"
      Then  User asserts "apply" in learn how popup with "Apply Now"
      Then  User clicks second page of inventory and asserts that "page-2" is "2"
      Then  User clicks next button icon and lands user on page "3"
      Then  User clicks on last page of inventory and asserts page

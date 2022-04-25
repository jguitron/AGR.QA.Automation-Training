@glitterglamgarrett

Feature: Verification of login functionality via heart icon on pdp

  Scenario: User adds item to wish list via heart icon
    Given User navigates to "url"
    When  User clicks on search bar
    And   User search's "Rachael Ray Yum-O Non-Stick Bakeware 3 Piece Oven Lovin Cookie Pan Set" in search bar
    Then  User clicks search icon
    And   User clicks on Heart Icon in plp
    And   User Logs in
    Then  Assert user is logged in via name displays in header

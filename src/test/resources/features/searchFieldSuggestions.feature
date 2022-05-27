Feature: Verification of search field shows searched item suggestions
@garrett
  Scenario: User types in sofa in search bar and verifies suggestions return
    Given User navigates to "url"
    And   User clicks on search bar
    Then  User search's "Table" in search bar
    Then  User asserts in search bar for search suggestions returns top results for "Table"
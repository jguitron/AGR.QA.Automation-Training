Feature: Verification of search field shows searched item suggestions
@smoke
  Scenario: User types in sofa in search bar and verifies suggestions return
    Given User navigates to "url"
    Then  User search's "Table" in search bar
    Then  User asserts in search bar for search suggestions returns top results for "Table"
Feature: Search Test
  As a user I should be able submit search request

  @SeverityLevel.CRITICAL @TestCaseId("example-1")
  Scenario: Search Checking for unauthorized user
    Given I open home page
    When I perform search by request "Syma"
    Then URL of product search page should be valid
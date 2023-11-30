Feature: Google search functionality

  Scenario: Test the Google search functionality
    Given I am on the "https://www.google.com/" url
    When I search "Atliq Technology" into the search bar
    And I press enter
    Then I should be navigated to the search options


Feature: SearchFeature
  This feature deals with the search functionality of the application
  Scenario: Search for one specific item in a shop
    Given user navigates to shop page
    And enters iphone12 as name of product to search
    And   clicks on the search button
    Then  all products related to our request will be displayed

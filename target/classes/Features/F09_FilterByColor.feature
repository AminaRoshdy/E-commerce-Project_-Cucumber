@smoke
Feature: User Filter products by color

  Scenario: verify filter products by color
    Given Open list of Apperal  category and select Shoes sub category
    And page of shoes sub category open successfully
    When select a color
    Then the products are filtered by selected color
    And the selected color appear in details page of products
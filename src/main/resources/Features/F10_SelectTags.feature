@smoke
Feature: User select different tags and filter  products by selected tag

  Scenario: verify select tags and filter of products
    Given Open list of Apperal  category and select Shoes sub category
    And page of shoes sub category open successfully
    When the list of tags appears successfully
    Then select a tag
    And the products are filtered by selected tag
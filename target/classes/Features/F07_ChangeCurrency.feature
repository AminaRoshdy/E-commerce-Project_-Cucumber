@smoke
Feature: User change currency on E-commerce site

  Scenario: Verify user can change currency to Euro successfully
    Given Search by "Laptop"
    And Search result appear successfully
    When Change Currency to "Euro"
    Then The currency of products is changes to Euro successfully

  Scenario: Verify user can change currency to dollar successfully
    Given Search by "Laptop"
    And Search result appear successfully
    When Change Currency to "US Dollar"
    Then The currency of products is changes to dollar successfully
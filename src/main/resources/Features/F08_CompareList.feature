@smoke
Feature: User can Add products on compare list

  Scenario: verify add product to compare list from search result page
    Given Search by "Laptop"
    When Buttons of AddToComapreList appear successfully on searchlist
    And click on button AddToComapreList of first product
    Then selected product is added to compare list successfully

  Scenario: verify add product to wishes list from product details page
    Given Search by "Laptop"
    When Search result appear successfully
    And open details page of a product
    And add current product to compare list from details page
    Then selected product is added to compare list successfully


@smoke
Feature: User can Add and remove products on Wishes list

  Scenario: verify add product to wishes list from search result page
    Given Search by "Laptop"
    When Buttons of AddToWishesList appear successfully on searchlist
    And click on button AddToWishesList of first product
    Then selected product is added to wishes list successfully


  Scenario: verify add product to wishes list from product details page
    Given Search by "Laptop"
    When Search result appear successfully
    And open details page of a product
    And add current product to wishes list
    Then selected product is added to wishes list successfully

  Scenario: verify Remove product from wishes list
    Given Search by "Laptop"
    When Buttons of AddToWishesList appear successfully on searchlist
    And click on button AddToWishesList of first product
    And Open Wishes List
    And Remove the product from wishes list
    Then the product is removed successfully from wishes wishes list







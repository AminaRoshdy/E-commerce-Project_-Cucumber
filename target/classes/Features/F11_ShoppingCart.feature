@smoke
Feature: User can Add products on shopping cart

  Scenario: verify add product to wishes list from search result page
    Given Search by "Laptop"
    When Search result appear successfully
    And Buttons of add to shopping cart appear successfully on search list
    And Add first product to Shopping cart
    Then selected product is added to shopping cart successfully


  Scenario: verify add product to shopping cart "from details page of the product"
    Given Search by "Laptop"
    When Search result appear successfully
    And open details page of a product
    And Button of Add shopping cart is displayed and enabled
    And Add Current Product to shopping cart
    Then selected product is added to shopping cart successfully


  Scenario: verify remove products from shopping cart
    Given Search by "Laptop"
    When Search result appear successfully
    And Buttons of add to shopping cart appear successfully on search list
    And Add first product to Shopping cart
    And Open shopping cart
    And Remove all products from shopping cart
    Then The products are removed from shopping cart successfully
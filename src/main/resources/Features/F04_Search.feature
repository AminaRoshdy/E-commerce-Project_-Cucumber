@smoke
  Feature: user can search for a product on e-commerce web site

    Scenario: verify user search for a product successfully
      Given Search by "Laptop"
      When Search result appear successfully
      Then The products of Title "Laptop" appear on search result

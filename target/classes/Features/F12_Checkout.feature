@smoke
Feature: Registered user can checkout product from on E-commerce web site

  Scenario: verify user checkout products successfully
    Given user Click on Rigster Link
    And user enter regiseration data "Amina" and "Shams" and "test77@aa.com" and "12345678"
    And Search by "Laptop"
    When Search result appear successfully
    And Buttons of add to shopping cart appear successfully on search list
    And Add first product to Shopping cart
    And Open shopping cart
    And Approve the service terms and Click on checkout
    And Enter the shipping details "Cairo" and "Maadi" and "1234" and "01023333444"
    Then checkout complete successfully
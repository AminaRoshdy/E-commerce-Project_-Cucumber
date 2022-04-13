@smoke
Feature: registered user change password and login with new password on E-commerce web site

  Scenario: verify user register successfully
    Given user Click on Rigster Link
    And user enter regiseration data "Amina" and "Shams" and "test11@aa.com" and "12345678"
    When Open My Account Page
    And Open change password page
    And Enter new and confirm password "12345678","11223344","11223344" and click change password
    Then the password is changed successfully


  Scenario: verify User Login with new password successfully
    Given Click on Login Link
    When user enter "test11@aa.com" and "11223344", and click login button
    Then User LOgin Successfully



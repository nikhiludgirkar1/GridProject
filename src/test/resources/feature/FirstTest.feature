@saucedemo
Feature: Sauce demo test

  @logintest
  Scenario: Login demo
    Given user navigates to portal
    When user enters username "standard_user"
    And user enters password "secret_sauce"
    And user clicks on login button
    Then login is successful
    When user adds "backpack" to cart
    And user clicks on cart link
    Then product "Sauce Labs Backpack" should be added to cart
    When user clicks on checkout button
    And user enters "fn" in first name text box in checkout information page
    And user enters "ln" in last name text box in checkout information page
    And user enters "11111" in postal code in checkout information page
    And user clicks on continue button in checkout information page
    Then product "Sauce Labs Backpack" should be added to cart
    When user clicks on finish button
    Then user verifies Thank you message
    And user opens page in new tab

#  @Api-test
#  Scenario: Api Test
#    Given User should be able to create weather station with valid weather details
#    Given user should get success response for valid external id passed in earlier test case


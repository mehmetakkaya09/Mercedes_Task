Feature: Cart Operations in hepsiburada.com

  User Story :

  User should be able to add two products to the cart at the same time and increase the quantity of these products in the cart

  Background: Login Functionality
    Given user navigates to homepage
    When user logs in with valid credentials

  Scenario: Verify the increase by adding two items to the cart and increasing the quantity of one item in the cart
    When user deletes old products from the cart
    And user types "laptop" in the search box
    And user adds the first and third products from the search result to the cart
    And user navigates to the cart page
    Then verify items in cart
    When user increases the quantity of any product
    Then verify the increase in product quantity and amount together
    When user returns to homepage without making a purchase
    And user logs out
    Then verify that logout is done

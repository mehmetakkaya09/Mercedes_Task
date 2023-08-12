Feature: Cart Operations in hepsiburada.com

  User Story :

  User should be able to add two products to the cart at the same time and increase the quantity of these products in the cart

  Background: Login Functionality
    Given user is on the homepage "Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com"
    When user logs in with valid credentials "task mercedes"

  Scenario: Verify the increase by adding two items to the cart and increasing the quantity of one item in the cart
    When user deletes old products from the cart
    And user types "laptop" in the search box
    And user adds the 1st and 3rd products from the search result to the cart
    And user navigates to the cart page "Sepetim"
    Then verify items in cart
    When user increases the quantity of product 1
    Then verify the increase in product quantity and amount together
    When user returns to homepage without making a purchase
    And user logs out
    Then verify that logout is done "Giriş Yap"

@update
Feature: Account Update in hepsiburada.com

  User Story :

  User should be able to update their account information.

  Background: Login Functionality
    Given user is on the homepage "Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com"
    When user logs in with valid credentials from "Giriş Yap"
    Then verify account name as "task mercedes"
    When user deletes old products from the cart

  Scenario: Birthday Update
    When user clicks on "Kullanıcı Bilgilerim"
    Then verify that user is on the "Üyelik bilgilerim" page
    When user changes the birthdate
    And user clicks on update button
    Then verify the update
    When user logs out
    Then verify that logout is done "Giriş Yap"






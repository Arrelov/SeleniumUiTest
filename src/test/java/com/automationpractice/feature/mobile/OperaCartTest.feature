#language: en
Feature: Opera Mobile devices cart test

  Background:
    Given Set browser window size 400 x 900
    Given Set browser "opera"

#  Smoke test
  Scenario: Go to the cart page
    Given I open main page
    When I click to cart button
    Then I see cart page

#  Item counter test
  Scenario: Put Printed Summer Dress in cart and get 1 item in cart
    Given Cart is empty
    When I click add to cart button for the dress
    Then  I see 1 item(s) in cart

#  Item counter test 2
  Scenario: Put another Printed Summer Dress in cart and get 2 item in cart
    Given I open main page
    And Cart is empty
    When I click add to cart button for the dress
    And I click add to cart button for the dress
    Then  I see 2 item(s) in cart

#  Item counter test remove items from cart
  Scenario: Delete all from cart
    Given I open main page
    And Cart is empty
    When I click add to cart button for the dress
    And I click button to remove dress from cart
    Then  Cart is empty
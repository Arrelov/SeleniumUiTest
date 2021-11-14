#language: en
Feature: Mobile devices cart test

  Background:
    Given Set browsersize 400 x 900
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
    Then  I see one item in cart

#  Item counter test 2
  Scenario: Put another Printed Summer Dress in cart and get 2 item in cart
    When I click add to cart button for the dress
    Then  I see two items in cart
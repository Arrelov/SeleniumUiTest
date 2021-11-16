#language: en
Feature: Chrome Mobile devices cart test

  Background:
    Given Set browser window size 400 x 900
    Given Set browser "chrome"

#  Smoke test
  Scenario: Go to the cart page by cart button
    Given I open main page
    When I click to cart button
    Then I see cart page

#  Item counter test
  Scenario: Put Printed Summer Dress in cart and get 1 item in cart
    Given Cart is empty
    When I click add to cart button for the Printed Summer Dress
    Then  I see 1 item(s) in cart

#  Item counter test 2 same items
  Scenario: Put two Printed Summer Dresses in cart and get 2 items in cart
    Given I open main page
    And Cart is empty
    When I click add to cart button for the Printed Summer Dress
    And I click add to cart button for the Printed Summer Dress
    Then  I see 2 item(s) in cart

#  Item counter test remove items from cart
  Scenario: Delete all items from cart
    Given I open main page
    And Cart is empty
    When I click add to cart button for the Printed Summer Dress
    And I click button to remove dress from cart
    Then  Cart is empty

    #  Item counter test 2 different items and remove
  Scenario: Put two different dresses in cart and get 2 item in cart
    Given I open main page
    *     Cart is empty
    *     I click add to cart button for the Printed Summer Dress
    *     I click add to cart button for the Printed Chiffon Dress
    *     I see 2 item(s) in cart
    When  I click button to remove dress from cart
    *     I click button to remove dress from cart
    Then  Cart is empty
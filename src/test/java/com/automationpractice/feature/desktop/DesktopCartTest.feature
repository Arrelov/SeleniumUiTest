#language: en
Feature: Chrome Desktop cart test

  Background:
    Given Set browser "chrome"

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
    When I click add to cart button for the dress
    Then  I see 2 item(s) in cart

#  Item counter test remove items from cart
  Scenario: Delete all from cart
    When I click button to remove dress from cart
    Then  Cart is empty



# Перейти на страницу с товарами
# Положить в корзину товар
# Нажать на кнопку с корзиной
# Проверить, что в корзине товар


#  Иду на вкладку DRESSES
#  Навожу курсор на Printed Chiffon Dress
#  Делаю клик
#  Во всплывающем окне жму Add to cart
#  Вижу заголовок There is 1 item in your cart.
#  Жму Proceed to checkout
#  Проверяю, что я на странице корзины (http://automationpractice.com/index.php?controller=order)
#  Проверяю, что надпись гласит Your shopping cart contains: 1 Product
#  Проверяю, что в корзине один товар
#  Удаляю товар из тележки кликом на значок корзины
#  Проверяю, что в корзине пусто


#  Иду на вкладку DRESSES
#  Навожу курсор на Printed Chiffon Dress
#  Жму Add to cart


#  Навести курсор на элемент
#  Открыть браузер в режиме инкогнито


#  Открыть браузер в вертикальной ориентации, как будто на телефоне
#  Найти корзину

#  Проверка в разных браузерах
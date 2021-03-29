Feature: Checking Cash on delivery Feature

  Background:
    Given user has already logged on into system
      | username                  | password  |
#      | sumanth.fr@outlook.com    | Login@123 |
      | sumanth.1.reddy@gmail.com | Login@123 |

  Scenario: Login with individual user and search for products , change qty to 2 and checkout with cash on delivery
    Given user is in home page " Sumanth  Reddy"
    Then user gets the title of the page
    And page title should be "YouKraft"
    And click on search
    Then search for Item "Nice Cotton Hand Gloves Free Size"
    And Click on search button
    And Search for gloves and click on gloves "Nice Cotton Hand Gloves Free Size"
    And Check the price of the product
    And check the avalability of product
    And change the Pincode to "560064"
    And Change the QTY to 2 by clicking on + button
    And click on add to cart
    And click on go to cart
    Then Check the price and quantity in check out page
    And Validate the total Price with QTY * price
    And click on proceed to checkout
    And click on continue
    And select payment mode as Cash on delivery
    And place and order
    Then confirm the text "Your order is Successful"
    Then Logout of portal


  Scenario: Login with individual user and search for products , change qty to 5 and checkout with cash on delivery
    Given user is in home page " Sumanth  Reddy"
    Then user gets the title of the page
    And page title should be "YouKraft"
    And click on search
    Then search for Item "Green Panel MDF Exterior Grade 5.5 MM"
    And Click on search button
    And Search for gloves and click on gloves "Green Panel MDF Exterior Grade 5.5 MM"
    And Check the price of the product
    And check the avalability of product
    And change the Pincode to "560001"
    And Change the QTY to 5 by clicking on + button
    And click on add to cart
    And click on go to cart
    Then Check the price and quantity in check out page
    And Validate the total Price with QTY * price
    And click on proceed to checkout
    And click on continue
    And select payment mode as Cash on delivery
    And place and order
    Then confirm the text "Your order is Successful"
    Then Logout of portal


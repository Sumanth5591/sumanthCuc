Feature: Negative Test case as the Increasing Quantity above stock.

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
    Then search for Item "Dzire Safety Shoes-9"
    And Click on search button
    And Search for gloves and click on gloves "Dzire Safety Shoes 9"
    And Check the price of the product
    And check the avalability of product
    And change the Pincode to "560064"
    And Change the QTY to one aboveQTY Present by clicking on + button
    And Press + button QYT times
    And Press + button one more time
    Then click on add to cart
    And Alert will pop up check the Quantity should match avaliable Quantity
    And click on ok on alert
    And Logout of portal

  Scenario: Login with individual user and search for products , change qty to 2 and checkout with cash on delivery
    Given user is in home page " Sumanth  Reddy"
    Then user gets the title of the page
    And page title should be "YouKraft"
    And click on search
    Then search for Item "Zoom Safety Clear Goggles-Clear-Free Size"
    And Click on search button
    And Search for gloves and click on gloves "Zoom Safety Clear Goggles Clear Free Size"
    And Check the price of the product
    And check the avalability of product
    And change the Pincode to "560001"
    And Change the QTY to one aboveQTY Present by clicking on + button
    And Press + button QYT times
    And Press + button one more time
    Then click on add to cart
    And Alert will pop up check the Quantity should match avaliable Quantity
    And click on ok on alert
    And Logout of portal


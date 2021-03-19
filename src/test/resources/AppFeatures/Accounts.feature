Feature: Account Page Feature

  Background: 
    Given user has already logged on into system
      | username             | password |
      | sumanth@vcnrtech.com |    123456 |

  Scenario: Account page title
    Given user is in account page
    When user gets the title of the page
    Then page title should be "My account - My Store"

  Scenario: Account page check sections
    Given user is in account page
    Then user gets account section
      | Order history and details |
      | My credit slips           |
      | My addresses              |
      | My personal information   |
      | My wishlists              |
    And accounts section count should be 5
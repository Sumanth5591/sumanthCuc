Feature: Login page feature

  Scenario: Login page title
    Given user is on login page
    When user gets to secret code page
    Then user gets the title of the page
    Then page title should be "YouKraft"

  Scenario: Forgot Password link
    Given user is on login page
    When user gets to secret code page
    Then login button link should be displayed

  Scenario: Login with correct credentials
    Given user is on login page
    When user gets to secret code page
    Then user is on login page and click on Login button
    When user enters username "sumanth.1.reddy@gmail.com"
    And user enters password "Login@123"
    And user clicks on Login button
    Then user gets the title of the homepage
    And page title should be "YouKraft"
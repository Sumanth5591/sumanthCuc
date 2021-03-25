Feature: Registration page feature

  Scenario: user tires registration with valid data
    Given User as Individual customer and tires to register
    When User clicks on SignUp button
    And Select Individual tab on SignUp page
    And Enter the Random First Name
    And Enter the Random Last Name
    And Enter the Random PhoneNumber
    And Enter the Random AadharCard
    And Enter the Random PanNumber
    And Enter the Random password
    And Enter the Random confirmPassword
    Then user clicks on submit button in registration page
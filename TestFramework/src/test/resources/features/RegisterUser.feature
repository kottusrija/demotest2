

Feature: Register User

  Background: To launch the application and navigate to registration page
    Given The user is on landing page
    When The user clicks on Login Or Register link
    Then The user sees Account Login page is displayed
  
  Scenario: To Register a user
    Given The user clicks on the continue button for Register
    When The user enters the details and click on continue
    Then The user sees that new user registration is successful

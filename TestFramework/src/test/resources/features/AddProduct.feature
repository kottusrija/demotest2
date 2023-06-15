Feature: Login user and Add product

Background: To login with credentials
Given The user is on Login page
When The user enters valid credentials and click on login button
Then The user is successfully logged in

Scenario: To check out a product and validate details
Given The user is on homepage
When The user selects a product and checkout
Then The user validates the details of product
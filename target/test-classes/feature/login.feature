Feature: Login Feature
    In order to perform successful Login
    As a User
    I Have to enter correct username  and Password

  Scenario: Login to RoyalPage website with "valid" user
    Given User navigate to website
    When user validates the website title
    Then user enters "<usename>" username
    And user enters "<password>" Password
    And user clicks on the submit button

 Examples:
	|usename|password|
	|practice|SuperSecretPassword!|
	|practice|SuperSecretPassword|
	|practice1|SuperSecretPassword|
	|practice1|admin|
	

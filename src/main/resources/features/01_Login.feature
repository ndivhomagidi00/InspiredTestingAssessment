
Feature: Login


  Scenario Outline: As a user I want to login to the shopping site

    Given I navigate to the site
    Then I enter "<username>" and "<password>" and click login button
    Then I validate using logout button

    Examples:
      |username  |password|
      |nmagidi@inspiredtesting.com|ndivho112|


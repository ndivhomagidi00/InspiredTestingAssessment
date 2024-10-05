
Feature: AddItemToCart


  Scenario Outline: User should navigate to computers tab and add a desktop to cart



    Given I on the site
    Then I enter "<username>" and "<password>" and click login button to login
    Then I validate that i am logged in
    Then I click on computers
    Then I select desktops
    Then I click build my own cheap computer
    And I click add to cart button
    Then I proceed with my order
    When I capture billing "<city>" "<Adress1>" "<ZipCode>" "<Phone Number>"
    And I click continue button
    Then I confirm my order
    And I validate and print out the order number

    Examples:
      |username  |password|city|Adress1|ZipCode|Phone Number|
      |nmagidi@inspiredtesting.com|ndivho112|Centurion|12 Silwer-Eike|0173|0837250200|

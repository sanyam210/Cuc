
Feature: Title of your feature

  @searchfunctionality
  Scenario Outline: verify the search functionality of the webapplication
    Given user enters the name "<name>" in the search box
    When user clicks on search button
    Then user verifies the name of searched item

    Examples: 
      | name   |
      | Tomato |

  @addtocart
  Scenario Outline: verify add to cart functionality of the webapplication
    Given user enters the name "<name>" in the search box
    When user clicks on add to cart button
    Then user clicks on cart button and verify item

    Examples: 
      | name   |
      | Tomato |

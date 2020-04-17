Feature: Login to amazon to purchase a product
  Description: Login to amazon mobile application and search for an item and add to cart and purchase it

  Scenario: Login into app
    Given user launches the app
    
   Scenario: Search the product
    Given Hamburger Menu is Displayed
    Then  User clicks on hamburger Menu
    And User moves to setting submenu
    And User select the country as 'Australia'
    And User navigates back to Home Page
    And User clicks on Sign-In Button
    When User logged in using username, password and click signIn Button
    Then User should see that home page is displayed
    When User searches for '65-inch TV'
    And User click on one of the TV's displays except first and Last
    And User Add the Product to cart
    
    Scenario: Checkout the product 
    Given CartPageHeader is Displayed
    Then  User verify the name, Price and description of the product

Feature:Shopping and Pay by Check

  Scenario Outline: Shopping and Pay by Check
    Given  User open page https://mystore-testlab.coderslab.pl in browser
    When User logs in
    And  User select and chose Hummingbird Printed Sweater to buy
    And  User chose size <size>
    And  User chose <count> products
    And  User add products to the shopping card
    And  User click Proceed to checkout
    And  User confirms address
    And User chose Prestashop
    And  User chose Pay by Check
    And User agree to the terms of service
    And  User clicks "order with an obligation to pay"
    Then Save a screenshot of the order confirmation and the amount
    And Close browser
     Examples:
      |size |count|
      |L    |2    |




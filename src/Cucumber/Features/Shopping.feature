Feature:Shopping and Pay by Check

  Scenario Outline: Shopping and Pay by Check
    Given  User open page https://mystore-testlab.coderslab.pl in browser
    When User logs in
    And  User selects and chooses Hummingbird Printed Sweater to buy
    And  User chooses size <size>
    And  User chooses <count> products
    And  User adds products to the shopping card
    And  User clicks Proceed to checkout
    And  User confirms address
    And User chooses Prestashop "pick up in store"
    And  User chooses Pay by Check
    And User agree to the terms of service
    And  User clicks "order with an obligation to pay"
   Then Save a screenshot of the order confirmation and the amount
    And User clicks on you profile
    And User chooses "order history and details"
    And Close browser
     Examples:
      |size |count|
      |L    |2    |




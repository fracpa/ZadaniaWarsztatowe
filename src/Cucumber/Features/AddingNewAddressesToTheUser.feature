Feature:Adding new addresses to the user https://mystore-testlab.coderslab.pl

  Scenario Outline: Adding new addresses to the user  https://mystore-testlab.coderslab.pl
     Given  Page https://mystore-testlab.coderslab.pl opened in browser
    When User clicks Sign in
    And  User completes Email
    And  User completes Password
    And  User clicks SignIn
    And  User clicks Addresses
    And  User clicks in Create new address
    And User completes <alias>, <address>, <city>, <zippostalcode>, <country>, <phone>
    And  User clicks Save
    And Save a screenshot of the order confirmation and the amount
    Then Added <alias> are correct
    And  User deletes address <alias>
    And The address is deleted
    And Close browser
    Examples:
      |alias                   |address                     |city       |zippostalcode  |country        |phone     |
      |Adres korespondecyjny   |ul. Bohaterów Monte Cassino |Sopot      |81-767         |United Kingdom |987654321 |
      |Adres rejestracyjny firmy  |ul. Targ Sienny             |Gdańsk     |80-806         |United Kingdom |123456789 |




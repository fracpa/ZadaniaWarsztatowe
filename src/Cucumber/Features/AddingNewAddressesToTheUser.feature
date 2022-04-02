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
    Then Added <alias> are correct
    And  User deletes address <alias>
    And The address is deleted
    Examples:
      |alias                   |address                     |city       |zippostalcode  |country        |phone     |
      |Adres korespondecyjny   |ul. Bohaterów Monte Cassino |Sopot      |81-767         |United Kingdom |987654321 |




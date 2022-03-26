Feature:Adding new addresses to the user https://mystore-testlab.coderslab.pl

  Scenario Outline: Adding new addresses to the user  https://mystore-testlab.coderslab.pl
     Given  Page https://mystore-testlab.coderslab.pl opened in browser
    When User click Sign in
    And  User completes Email Paulinka1609@wp.pl
    And  User completes Password Paulinaqwer
    And  User click SignIn
    And  User click Addresses
    And  User click in Create new address
    And User completes <alias>, <address>, <city>, <zippostalcode>, <country>, <phone>
    And  User click Save
    Then Added <alias> are correct
    And  User delete address <alias>
    And The address is deleted
    Examples:
      |alias                   |address                     |city       |zippostalcode  | country        |phone     |
      |Adres korespondecyjny   |ul. Bohaterów Monte Cassino |Sopot      |81-767         | United Kingdom |987654321 |




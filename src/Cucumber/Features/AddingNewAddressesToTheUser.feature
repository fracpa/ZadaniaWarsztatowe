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
    Examples:
      |alias                   |address                     |city       |zippostalcode  | country        |phone     |
      |Adres domowy            |ul. Franciszkańska          |Warszawa   |00-200         | United Kingdom |123456789 |
      |Adres korespondecyjny   |ul. Bohaterów Monte Cassino |Sopot      |81-767         | United Kingdom |987654321 |




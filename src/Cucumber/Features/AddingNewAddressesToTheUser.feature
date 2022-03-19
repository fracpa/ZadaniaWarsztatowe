Feature:Adding new addresses to the user https://mystore-testlab.coderslab.pl

  Scenario Outline: Adding new addresses to the user  https://mystore-testlab.coderslab.pl
     Given  Page https://mystore-testlab.coderslab.pl opened in browser
    When User Click Sign in
    And  User completes Email Paulinka1609@wp.pl
    And  User completes Password Paulinaqwer
    And  User Click SignIn
    And  User Click Addresses
    And  User Click Create new address
    And User completes <alias>, <address>, <city>
    Then Added addresses are correct

    Examples:
      |alias        |address  |city
      |A            |Warszawa |Warszawa





Feature:Create new user in  https://mystore-testlab.coderslab.pl

  Scenario Outline: Create new user in  https://mystore-testlab.coderslab.pl
    Given  Page https://mystore-testlab.coderslab.pl opened in browser
    When User Click Sign in
    And User Click No account? Create one here
    And  User completes Social title
    And  User completes First name <firstname>
    And  User completes Last name <lastname>
    And  User completes the email address filed
    And  User completes Password filed
    And  User completes Birthdate filed
    And  User Click Save
    Then User is on the site https://mystore-testlab.coderslab.pl/index.php

    Examples:

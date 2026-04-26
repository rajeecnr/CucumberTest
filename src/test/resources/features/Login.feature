Feature: Login functionality

@login
  Scenario Outline: verify login success and locked users
    Given user is on login page
    When user enters "<username>" and "<password>"
    And clicks on login button
    Then login result should be "<result>"
  Examples:

  |username| |password| |result|
  |standard_user| |secret_sauce| |success|
  |locked_out_user| |secret_sauce| |locked|


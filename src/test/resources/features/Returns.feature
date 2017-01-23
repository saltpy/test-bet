Feature: A bet has the promised return

  Scenario: First time user bets on English Premier League
  	Given I have whitelisted cookies
    And I am on the English Premier League landing page
    When I add a 5 pence bet to my betslip
    Then my betslip is correct

Feature: Email testing with Mailosaur

@emailtest
Scenario: Basic usage
    Given the API key is set for Mailosaur
    When I call the Mailosaur API
    And I search for the password reset email I sent earlier
    Then that email should be sent from "Support" at "447418611918"


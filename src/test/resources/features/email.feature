Feature: Email testing with Mailosaur

Scenario: Basic usage
    Given the API key is set for Mailosaur
    When I call the Mailosaur API
    And I search for the password reset email I sent earlier
    Then that email should be sent from "Support" at "noreply@acme.com"


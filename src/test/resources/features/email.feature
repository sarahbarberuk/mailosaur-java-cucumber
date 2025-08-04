Feature: Email testing with Mailosaur

@emailtest
Scenario: Basic usage
    Given the Mailosaur API client is setup
    When I search for the "test" email I sent earlier
    Then that email should be sent from "Support" at "no-reply@acme.com"
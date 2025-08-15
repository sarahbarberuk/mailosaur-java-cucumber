Feature: SMS testing with Mailosaur

@smstest
Scenario: Basic SMS usage
    Given the Mailosaur API client is setup for SMS
    When I search for an SMS sent to "123456789"
    Then that SMS should be sent from "123456787"
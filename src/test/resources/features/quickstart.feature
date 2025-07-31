Feature: Quick start testing with Mailosaur

  Scenario: Check Mailosaur API works by checking we can access email inbox
    Given a Mailosaur API key is configured
    When I connect to the Mailosaur API
    Then I should see at least one inbox

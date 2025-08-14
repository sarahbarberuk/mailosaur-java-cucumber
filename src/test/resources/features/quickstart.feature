Feature: Quick start testing with Mailosaur

@quickstarttest
Scenario: Check the Mailosaur API works by checking we can access an email inbox
  Given the Mailosaur API client is setup
  When I connect to the Mailosaur API
  Then I should see at least one inbox

# Using Cucumber and Java to test the Mailosaur API

## How to run the tests

### General setup

1. Create a Mailosaur account on mailosaur.com
2. Get your API key and server ID
3. Create a .env file from .env.template and enter the correct environment variables

### Email testing setup

1. Create an email inbox in Mailosaur and give it a name
2. Send an email to the Mailosaur inbox and verify it arrived in the Mailosaur webapp's inbox.
3. In email.feature file, update any varialbes to match the email you sent - e.g. change no-reply@acme.com to your own email address.

### Runnng the Cucumber tests

Run the tests with `mvn clean test`

## What about the stuff in the docs that's not very Cucumber-specific?

This includes:

- Test email addresses
- Find an email
- Time range for searching
- "No matching messages" troubleshooting
- Other ways to fetch emails
- List current inbox contents
- Searching for multiple messages
- Common test scenarios
- Testing basic properties
- Testing carbon-copy recipients
- Testing email contents
- Plain text content
- HTML content
- Testing links
- Clicking a link
- Testing verification codes
- Testing attachments
- Save an attachment to disk
- Encoding attachments
- Testing images and web beacons
- Sending an email
- Include attachments
- Replying to an email
- Forwarding a message to email
- Deleting messages
- Deleting an individual message
- Delete all messages

  ALL THIS CAN JUST BE COPIED FROM THE SELENIUM EMAIL TESTING DOCS, USING THE JAVA CODE EXAMPLES. AS IT'S NOT TEST-FRAMEWORK-SPECIFIC.

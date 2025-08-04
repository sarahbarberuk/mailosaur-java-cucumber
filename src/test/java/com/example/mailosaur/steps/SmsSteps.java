package com.example.mailosaur.steps;

import com.mailosaur.MailosaurClient;
import com.mailosaur.models.Message;
import com.mailosaur.models.SearchCriteria;
import io.cucumber.java.en.*;
import io.github.cdimascio.dotenv.Dotenv;

import static org.junit.Assert.*;

public class SmsSteps {

    private MailosaurClient client;
    private Message message;
    private String serverId;

    @Given("Mailosaur API client is setup")
    public void mailosaur_api_client_is_setup() {
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("MAILOSAUR_API_KEY");
        serverId = dotenv.get("MAILOSAUR_SERVER_ID");
        assertNotNull("MAILOSAUR_API_KEY must be set", apiKey);
        assertNotNull("MAILOSAUR_SERVER_ID must be set", serverId);
        assertFalse("MAILOSAUR_API_KEY must not be empty", apiKey.isEmpty());
        assertFalse("MAILOSAUR_SERVER_ID must not be empty", serverId.isEmpty());
        client = new MailosaurClient(apiKey);
        assertNotNull("Client should be initialized", client);
    }

    @When("I search for an SMS sent to {string}")
    public void i_search_for_an_sms_sent_to(String phoneNumber) throws Exception {
        // Setup search criteria
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.withSentTo(phoneNumber);

        // Search for the message
        message = client.messages().get(serverId, searchCriteria);
        
    }

    @Then("that SMS should be sent from {string}")
    public void that_sms_should_be_sent_from(String phoneNumber) {
        assertNotNull("Expected to find a message", message);
        assertNotNull("Message sender should not be null", message.from());
        assertEquals(phoneNumber, message.from().get(0).phone());
    }
}

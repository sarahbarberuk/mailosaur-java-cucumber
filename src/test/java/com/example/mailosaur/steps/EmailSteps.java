package com.example.mailosaur.steps;
import com.mailosaur.MailosaurClient;
import com.mailosaur.models.Message;
import com.mailosaur.models.SearchCriteria;
import io.cucumber.java.en.*;
import io.github.cdimascio.dotenv.Dotenv;

import static org.junit.Assert.*;

public class EmailSteps {

    private MailosaurClient client;
    private Message message;
    private String serverId;

    @Given("the Mailosaur API client is setup")
    public void the_mailosaur_api_client_is_setup() {
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

    @When("I search for the {string} email I sent earlier")
    public void i_search_for_the_email_i_sent_earlier(String subject) throws Exception {
        SearchCriteria criteria = new SearchCriteria().withSubject(subject);
        message = client.messages().get(serverId, criteria);
        assertNotNull("Message not found", message);
    }

    @Then("that email should be sent from {string} at {string}")
    public void that_email_should_be_sent_from_at(String name, String emailAddress) {
        assertEquals(name, message.from().get(0).name());
        assertEquals(emailAddress, message.from().get(0).email());
    }
}

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

    @Given("the API key is set for Mailosaur")
    public void the_api_key_is_set() {
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("MAILOSAUR_API_KEY");
        serverId = dotenv.get("MAILOSAUR_SERVER_ID");

        assertNotNull("MAILOSAUR_API_KEY must be set", apiKey);
        assertNotNull("MAILOSAUR_SERVER_ID must be set", serverId);
        assertFalse("MAILOSAUR_API_KEY must not be empty", apiKey.isEmpty());
        assertFalse("MAILOSAUR_ must not be empty", serverId.isEmpty());
        
        client = new MailosaurClient(apiKey);
    }

    @When("I call the Mailosaur API")
    public void i_call_the_mailosaur_api() {
        assertNotNull("Client should be initialized", client);
    }

    @When("I search for the {string} email I sent earlier")
    public void i_search_for_the_email(String subject) throws Exception {
        SearchCriteria criteria = new SearchCriteria().withSubject("Password reset");
        message = client.messages().get(serverId, criteria);
    }

    @Then("that email should be sent from {string} at {string}")
    public void that_email_should_be_sent_from_at(String name, String emailAddress) {
        assertEquals(name, message.from().get(0).name());
        assertEquals(emailAddress, message.from().get(0).email());
    }
}

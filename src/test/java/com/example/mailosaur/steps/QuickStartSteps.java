package com.example.mailosaur.steps;

import io.github.cdimascio.dotenv.Dotenv;
import com.mailosaur.MailosaurClient;
import com.mailosaur.models.Server;
import io.cucumber.java.en.*;
import static org.junit.Assert.*;
import java.util.List;

public class QuickStartSteps {

    private String apiKey;
    private MailosaurClient client;
    private List<Server> emailServers;

    @Given("a Mailosaur API key is configured")
    public void a_mailosaur_api_key_is_configured() {
        Dotenv dotenv = Dotenv.load();
        apiKey = dotenv.get("MAILOSAUR_API_KEY");
        
        assertNotNull("MAILOSAUR_API_KEY must be set", apiKey);
        assertFalse("MAILOSAUR_API_KEY must not be empty", apiKey.isEmpty());
    }

    @When("I connect to the Mailosaur API")
    public void i_connect_to_the_mailosaur_api() throws Exception {
        client = new MailosaurClient(apiKey);

        // Make a simple API call to get a list of email severs
        emailServers = client.servers().list().items();
    }

    @Then("I should see at least one inbox")
    public void i_should_see_at_least_one_inbox() {
        assertNotNull("Server list should not be null", emailServers);
        assertFalse("Expected at least one inbox/server", emailServers.isEmpty());
    }
}

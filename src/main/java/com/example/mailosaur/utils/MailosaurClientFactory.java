package com.example.mailosaur.utils;

import com.mailosaur.MailosaurClient;
import io.github.cdimascio.dotenv.Dotenv;

public class MailosaurClientFactory {
    private static MailosaurClient client;
    private static String serverId;

    public static MailosaurClient getInstance() {
        if (client == null) {
            Dotenv dotenv = Dotenv.load();
            serverId = dotenv.get("MAILOSAUR_SERVER_ID");
            String apiKey = dotenv.get("MAILOSAUR_API_KEY");
            client = new MailosaurClient(apiKey);
        }
        return client;
    }

    public static String getServerId() {
        return serverId;
    }
}

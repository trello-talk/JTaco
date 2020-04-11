package io.trellotalk.jtaco;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class Config extends Properties {

    private static final File FILE = new File("config.ini");
    private static final Config CFG = new Config();

    public enum Key {

        TRELLO_API_KEY("api_key"),
        TRELLO_TOKEN("trello_token"),
        DISCORD_TOKEN("discord_token");

        private final String value;

        Key(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public enum General {
        BOT_PREFIX("prefix"),
        BOT_PRESENCE("bot_presence");

        private final String value;

        General(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    private Config() {
        if (CFG != null)
            throw new IllegalStateException();

        // @formatter:off
        try { this.initialize(); }
        catch (IOException e) { e.printStackTrace(); }
        // @formatter:on
    }

    private void initialize() throws IOException {

        if (FILE.createNewFile()) {
            List<String> values = new java.util.ArrayList<>();

            values.add("#Here, you will put your Trello API Key, Trello OAUTH Token" +
                "(The both can be get in https://trello.com/app-key)");
            values.add("#and your BOT Secret Token (From Discord. Get this key in https://discord.com/developers)");

            for (Key value : Key.values()) {
                values.add(value.toString() + '=');
            }

            values.add("");

            for (General value : General.values()) {
                if(value.toString() == "bot_presence"){
                    values.add("#This is the \"Playing...\" default. You can change this here. (Default = Under development)");
                    values.add(value.toString() + '=' + "Under development");
                    values.add("");
                } else if(value.toString() == "prefix") {
                    values.add("#This is the bot prefix. (Default = T!)");
                    values.add(value.toString() + '=' + "T!");
                    values.add("");
                } else {
                    values.add(value.toString() + '=');
                }
            }
            FileUtils.writeLines(FILE, values);
            throw new IllegalStateException("No configuration file found, a template file has been created.");
        }
        else load(new FileInputStream(FILE.getName()));
    }

    public static String getValue(Key key) {
        return (String) CFG.get(key.value);
    }

    public static String getValue(General general) {
        return (String) CFG.get(general.value);
    }
}

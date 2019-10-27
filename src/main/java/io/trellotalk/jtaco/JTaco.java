package io.trellotalk.jtaco;

import io.trellotalk.jtaco.cmd.CommandHandler;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;

public class JTaco extends ListenerAdapter {

    /** Discord bot application token */
    private static final String TOKEN = "YOUR SECRET TOKEN HERE";

    /** Text being displayed under the bots name (game being played) */
    private static final String GAME = "Under development";

    public static void main(String[] args) throws LoginException {
        new JDABuilder(TOKEN).addEventListeners(new JTaco()).setActivity(Activity.playing(GAME)).build();
    }


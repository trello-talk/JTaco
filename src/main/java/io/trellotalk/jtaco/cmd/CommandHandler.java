package io.trellotalk.jtaco.cmd;

import io.trellotalk.jtaco.auth.TrelloAuth;
import io.trellotalk.jtaco.json.JsonHandler;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.apache.commons.lang3.ArrayUtils;

import java.io.IOException;
import java.util.ArrayList;

public class CommandHandler {

    public static void process(MessageReceivedEvent event) {

        Message msg = event.getMessage();
        String content = msg.getContentRaw();
        MessageChannel channel = event.getChannel();

        if (msg.getAuthor().isBot())
            return;

        String[] elements = content.split(" ");
        String sCommand = elements[0];

        Command command = Command.find(sCommand);
        String[] params = ArrayUtils.remove(elements, 0);

        if (params.length < command.minParams) {
            channel.sendMessage( msg.getAuthor().getAsMention() + " You didn't supply enough arguments!");
            return;
        }

        String result = "";

        switch(command) {
            case UNKNOWN: result = "Unrecognized command"; break;
        }
        if (!result.isBlank())
            channel.sendMessage(result).queue();
    }


    public static java.util.List<String> getUserBoards(String userId) {

        try {
            return JsonHandler.getUserInfo(userId, new TrelloAuth()).getBoardList();
        }
        catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}

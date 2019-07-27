package com.bot.rpgbot;

import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

/**
 *
 * @author Charlie Hands
 */
public class MainListener implements MessageCreateListener{
    public final HashMap<String,CommandAction> commands = new HashMap<>();
    private final CommandAction defaultCommand = (MessageCreateEvent e) -> {
        e.getChannel().sendMessage("Sorry, there is no command with this name!");
    };
    public MainListener(){
        commands.put("!image",e -> {
            e.getChannel().sendMessage(new EmbedBuilder().setImage(new File("src/main/images/download.jpg")));
            e.getChannel().sendMessage("Image Sent");
        });
        commands.put("!database",e -> {
            try {
                e.getChannel().sendMessage("" + new DBConnect().databaseTest());
            } catch (SQLException|ClassNotFoundException ex) {
                Logger.getLogger(MainListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    @Override
    public void onMessageCreate(MessageCreateEvent e) {
        if(e.getMessage().getContent().startsWith("!"))commands.getOrDefault(e.getMessage().getContent().split(" ")[0],defaultCommand).action(e);
    }
}

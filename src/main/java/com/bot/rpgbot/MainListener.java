package com.bot.rpgbot;

import java.io.File;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

/**
 *
 * @author Charlie Hands
 */
public class MainListener implements MessageCreateListener{

    @Override
    public void onMessageCreate(MessageCreateEvent e) {
        switch(e.getMessage().getContent()){
            case "!image": 
                //e.getChannel().sendMessage(new EmbedBuilder().setImage(img,"jpeg"));
                e.getChannel().sendMessage(new EmbedBuilder().setImage(new File("src/main/images/download.jpg")));
                e.getChannel().sendMessage("Image Sent");
                break;
        }
    }
    
}

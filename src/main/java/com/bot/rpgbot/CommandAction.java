package com.bot.rpgbot;

import org.javacord.api.event.message.MessageCreateEvent;

/**
 * 
 * @author Charlie
 */
public interface CommandAction {
    //Probably only need to pass the MessageCreateEvent to get the users involved from rather than list 
    //a load of parameters
    //This will be the specified action that a command will do e.g. adding an item to inventory
    //Will specify commands in a different class (Probs where commands are stored)
    public void action(MessageCreateEvent e);

}

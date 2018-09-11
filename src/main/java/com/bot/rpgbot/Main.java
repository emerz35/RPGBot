package com.bot.rpgbot;

import java.util.Random;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import java.util.Scanner;

/**
 *
 * @author Charlie Hands
 */
public class Main {
    static String token;
    public static final Random r = new Random();
    private final PlayerFactory playerFactory = new PlayerFactory();
    public Main(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Token:");
        token = scanner.next();//System.getenv("token");
        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

        System.out.println("You can invite me by using the following url: " + api.createBotInvite());
        
        api.addMessageCreateListener(new MainListener());

        api.addServerJoinListener(event -> {
            System.out.println("Joined server " + event.getServer().getName());
            event.getServer().addServerMemberJoinListener(e -> playerFactory.createPlayer(e.getUser()));
        });
        api.addServerLeaveListener(event -> System.out.println("Left server " + event.getServer().getName()));
    }
    /**
     * The main bot class to run, adds message create listeners
     *
     * @param args The arguments for the program.
     */
    public static void main(String[] args) {
        new Main();
        
    }
}

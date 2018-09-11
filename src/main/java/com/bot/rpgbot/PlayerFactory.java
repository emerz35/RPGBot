package com.bot.rpgbot;

import com.bot.items.armour.Armour;
import com.bot.objects.Player;
import com.bot.items.weapons.Weapon;
import org.javacord.api.entity.user.User;

/**
 *
 * @author Charlie Hands
 */
public class PlayerFactory {
    private Weapon starterWeapon;
    private Armour starterArmour;
    public Player createPlayer(User user){
        //Create Player and add to database
        return new Player(starterWeapon, starterArmour, user);
    }
}

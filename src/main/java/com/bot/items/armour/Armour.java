package com.bot.items.armour;

import com.bot.items.Item;
import com.bot.objects.Player;
import com.bot.rpgbot.AttackEvent;

/**
 *
 * @author Charlie Hands
 */
public interface Armour extends Item{
    public void defend(int damage, AttackEvent attack);
    public void setPlayer(Player player);
}

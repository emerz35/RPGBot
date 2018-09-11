package com.bot.items.weapons;

import com.bot.items.Item;
import com.bot.rpgbot.AttackEvent;

/**
 *
 * @author Charlie
 */
public interface Weapon extends Item{
    public int attack(AttackEvent attack);
}

package com.bot.objects;

import com.bot.items.armour.Armour;
import com.bot.rpgbot.AttackEvent;
import com.bot.items.weapons.Weapon;

/**
 *
 * @author Charlie Hands
 */
public abstract class Object {
    private Weapon weapon;
    private Armour armour;
    public Object(Weapon weapon, Armour armour){
        this.weapon = weapon;
        this.armour = armour;
    }
    public void defend(int damage, AttackEvent attack){
        armour.defend(damage, attack);
    }
    public int attack(AttackEvent attack){
        return weapon.attack(attack);
    }
    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }
    public void setArmour(Armour armour){
        this.armour = armour;
    }
    public abstract void die();
}

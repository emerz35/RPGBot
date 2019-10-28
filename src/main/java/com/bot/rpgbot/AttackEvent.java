package com.bot.rpgbot;

import com.bot.entities.Entity;

/**
 *
 * @author Charlie
 */
public class AttackEvent {
    private Entity defender;
    private Entity attacker;
    
    public Entity getAttacker(){
        return attacker;
    }
    
    public Entity getDefender(){
        return defender;
    }
    
    public void attackEvent(){
        defender.defend(attacker.attack(this),this);
    }
}

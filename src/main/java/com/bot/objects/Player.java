package com.bot.objects;

import com.bot.containers.Storage;
import com.bot.items.Item;
import com.bot.items.armour.Armour;
import com.bot.items.weapons.Weapon;
import org.javacord.api.entity.user.User;

/**
 *
 * @author Charlie Hands
 */
public class Player extends Object{
    private final User user;
    private final Storage<Item> items = new Storage();
    private int money = 100;
    public Player(Weapon weapon, Armour armour, User user){
        super(weapon,armour);
        this.user = user;
    }

    @Override
    public void die() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    public User getUser(){
        return user;
    }
    public int getMoney(){
        return money;
    }
    public void setMoney(int money){
        this.money = money;
    }
    public void addMoney(int change){
        this.money += change;
    }
    public boolean checkMoney(int cost){
        return this.money >= cost;
    }
    public Storage getInventory(){
        return items;
    }
}

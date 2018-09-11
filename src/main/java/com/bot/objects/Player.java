package com.bot.objects;

import com.bot.items.Item;
import com.bot.items.armour.Armour;
import com.bot.items.weapons.Weapon;
import java.util.LinkedList;
import java.util.List;
import org.javacord.api.entity.user.User;

/**
 *
 * @author Charlie Hands
 */
public class Player extends Object{
    private final User user;
    private final List<Item> items = new LinkedList<>();
    private int money = 100;
    public Player(Weapon weapon, Armour armour, User user){
        super(weapon,armour);
        this.user = user;
    }

    @Override
    public void die() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    public void addItem(Item item){
        items.add(item);
    }
    public void removeItem(Item item){
        items.remove(item);
    }
    public void getItem(int pos){
        items.get(pos);
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
}

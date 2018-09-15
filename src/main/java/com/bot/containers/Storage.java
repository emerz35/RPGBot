package com.bot.containers;
import java.util.HashMap;
/**
 *
 * @author Charlie Hands
 * @param <T> 
 */
public class Storage<T> extends HashMap<T,Integer>{
    public void add(T item){
        if(containsKey(item)) put(item,get(item)+1);
        else put(item,1);
    }
    @Override
    public Integer remove(Object key){
        if(get((T)key) > 1) {
            put((T)key,get((T)key)-1);
            return get((T)key)+1;
        }
        return super.remove(key);
    }
    public void removeAllOf(T key){
        super.remove(key);
    }
}

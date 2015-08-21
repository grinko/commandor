package com.grinko.model.character;

/**
 * Created by grinko on 16.8.15.
 */
public class PersonageFactory {
    public static BaseCommando getPersByType(String type) {
        if ("SNIPER".equals(type)) {
            return new Sniper();
        } else if ("SOLDIER".equals(type)) {
            return new Soldier();
        } else {
            return new Soldier();
        }
    }
}

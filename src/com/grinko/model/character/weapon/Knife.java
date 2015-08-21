package com.grinko.model.character.weapon;

import com.grinko.model.character.Coordinates;

/**
 * Created by grinko on 16.8.15.
 */
public class Knife implements IWeapon {

    private final int damage = 5;
    private final int distance = 1;

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getDistance() {
        return distance;
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void hitTo(Coordinates coordinates) {

    }
}

package com.grinko.model.character.weapon;

import com.grinko.model.character.Coordinates;

/**
 * Created by grinko on 16.8.15.
 */
public class Bomb implements IWeapon, IBomb{

    private final int damage = 20;
    private final int distance = 0;
    private final int damageRadius = 3;

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getDistance() {
        return distance;
    }

    @Override
    public void hitTo(Coordinates coordinates) {

    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public int getDamageRadius() {
        return damageRadius;
    }
}

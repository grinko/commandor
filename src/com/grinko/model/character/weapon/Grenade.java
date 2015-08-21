package com.grinko.model.character.weapon;

import com.grinko.model.character.Coordinates;

/**
 * Created by grinko on 16.8.15.
 */
public class Grenade implements IWeapon, IBomb{

    private final int damage = 10;
    private final int distance = 3;
    private final int damageRadius = 2;

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

package com.grinko.model.character.weapon;

import com.grinko.model.character.Coordinates;

/**
 * Created by grinko on 16.8.15.
 */
public class Pistol implements IWeapon, IFireWeapon {

    private final int damage = 5;
    private final int distance = 3;
    private final int cartridgeCapacity = 10;
    private int roundsNumber = 0;

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
    public int getCartridgeCapacity() {
        return cartridgeCapacity;
    }

    @Override
    public int getRoundsNumber() {
        return roundsNumber;
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void addRounds(int rounds) {
        this.roundsNumber = (this.roundsNumber + rounds) > this.cartridgeCapacity
                ? this.cartridgeCapacity : this.roundsNumber + rounds;
    }
}

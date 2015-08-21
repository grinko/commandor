package com.grinko.model.character.weapon;

/**
 * Created by grinko on 16.8.15.
 */
public interface IFireWeapon {

    int getCartridgeCapacity();
    int getRoundsNumber();
    void addRounds(int rounds);
}

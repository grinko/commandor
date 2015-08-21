package com.grinko.model.character.weapon;

import com.grinko.model.character.Coordinates;

/**
 * Created by grinko on 16.8.15.
 */
public interface IWeapon {
    int getDamage();
    int getDistance();
    void hitTo(Coordinates coordinates);

    String getName();
}

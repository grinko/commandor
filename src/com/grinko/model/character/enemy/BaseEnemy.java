package com.grinko.model.character.enemy;

import com.grinko.model.character.Coordinates;
import com.grinko.model.character.weapon.IWeapon;

import java.util.List;

/**
 * Created by grinko on 20.8.15.
 */
public abstract class BaseEnemy {
    private String name;
    private Coordinates coordinates;
    private int health;

    public BaseEnemy(String name, Coordinates coordinates, int health) {
        this.name = name;
        this.coordinates = coordinates;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

}

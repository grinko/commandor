package com.grinko.model.character.enemy.animal;

import com.grinko.model.character.Coordinates;
import com.grinko.model.character.enemy.BaseEnemy;

/**
 * Created by grinko on 19.8.15.
 */
public abstract class BaseAnimal extends BaseEnemy{

    private int damage;

    public BaseAnimal(String name, Coordinates coordinates, int health, int damage) {
        super(name, coordinates, health);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}

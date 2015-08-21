package com.grinko.model.character.enemy.man;

import com.grinko.model.character.Coordinates;
import com.grinko.model.character.enemy.BaseEnemy;
import com.grinko.model.character.weapon.IWeapon;

import java.util.List;

/**
 * Created by grinko on 20.8.15.
 */
public abstract class BaseEnemyMan extends BaseEnemy{

    private int level;
    private List<IWeapon> weapons;

    public BaseEnemyMan(String name, int level, Coordinates coordinates, int health, List<IWeapon> weapons) {
        super(name, coordinates, health);
        this.level = level;
        this.weapons = weapons;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<IWeapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<IWeapon> weapons) {
        this.weapons = weapons;
    }
}

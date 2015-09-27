package com.grinko.model.character.enemy.man;

/**
 * Created by grinko on 27.9.15.
 */
public enum EnemyManProperties {
    DEFAULT_STUPID_ENEMY ("Stupid Enemy", 1, 10);

    private String name;
    private int initLevel;
    private int initHealth;

    EnemyManProperties(String name, int initLevel, int initHealth) {
        this.name = name;
        this.initLevel = initLevel;
        this.initHealth = initHealth;
    }

    public String getName() {
        return name;
    }

    public int getInitLevel() {
        return initLevel;
    }

    public int getInitHealth() {
        return initHealth;
    }
}

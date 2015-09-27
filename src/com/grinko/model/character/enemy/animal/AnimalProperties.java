package com.grinko.model.character.enemy.animal;

/**
 * Created by grinko on 27.9.15.
 */
public enum AnimalProperties {
    DEFAULT_BEAR ("Bear", 30, 10),
    DEFAULT_WOLF ("Wolf", 5, 2);

    private String name;
    private int initialHealth;
    private int damage;

    AnimalProperties(String name, int initialHealth, int damage) {
        this.name = name;
        this.initialHealth = initialHealth;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getInitialHealth() {
        return initialHealth;
    }

    public int getDamage() {
        return damage;
    }
}

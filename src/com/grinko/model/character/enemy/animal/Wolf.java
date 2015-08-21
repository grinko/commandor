package com.grinko.model.character.enemy.animal;

import com.grinko.model.character.Coordinates;

/**
 * Created by grinko on 19.8.15.
 */
public class Wolf extends BaseAnimal {
    private int health = 5;
    private int damage = 2;
    private Coordinates coordinates;

    public Wolf(Coordinates coord) {
        super("Wolf", coord, 5, 2);    //TODO avoid magic numbers (maybe move to InitConstants or create enum)
    }
}

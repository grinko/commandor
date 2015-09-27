package com.grinko.model.character.enemy.animal;

import com.grinko.model.character.Coordinates;

/**
 * Created by grinko on 19.8.15.
 */
public class Wolf extends BaseAnimal {

    public Wolf(Coordinates coord) {
        super(AnimalProperties.DEFAULT_WOLF.getName(), coord,
                AnimalProperties.DEFAULT_WOLF.getInitialHealth(), AnimalProperties.DEFAULT_WOLF.getDamage());
    }
}

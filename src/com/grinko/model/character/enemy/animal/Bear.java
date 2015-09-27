package com.grinko.model.character.enemy.animal;

import com.grinko.model.character.Coordinates;

/**
 * Created by grinko on 19.8.15.
 */
public class Bear extends BaseAnimal {

    public Bear(Coordinates coord) {
        super(AnimalProperties.DEFAULT_BEAR.getName(), coord,
                AnimalProperties.DEFAULT_BEAR.getInitialHealth(), AnimalProperties.DEFAULT_BEAR.getDamage());
    }
}

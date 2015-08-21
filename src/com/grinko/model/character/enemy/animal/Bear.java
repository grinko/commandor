package com.grinko.model.character.enemy.animal;

import com.grinko.model.character.Coordinates;

/**
 * Created by grinko on 19.8.15.
 */
public class Bear extends BaseAnimal {

    public Bear(Coordinates coord) {
        super("Bear", coord, 30, 10);//TODO avoid magic numbers (maybe move to InitConstants or create enum)
    }
}

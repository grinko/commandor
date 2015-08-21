package com.grinko.model.character.enemy.man;

import com.grinko.model.character.Coordinates;
import com.grinko.model.character.InitConstants;

/**
 * Created by grinko on 20.8.15.
 */
public class StupidEnemy extends BaseEnemyMan {
    public StupidEnemy(Coordinates coordinates) {
        super("Stupid Enemy", 1, coordinates, 10, InitConstants.getStupidEnemyInitWeapon());
        //TODO avoid magic numbers (maybe move to InitConstants or create enum)
    }
}

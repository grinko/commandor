package com.grinko.model.character.enemy.man;

import com.grinko.model.character.Coordinates;
import com.grinko.model.character.InitConstants;

/**
 * Created by grinko on 20.8.15.
 */
public class StupidEnemy extends BaseEnemyMan {
    public StupidEnemy(Coordinates coordinates) {
        super(EnemyManProperties.DEFAULT_STUPID_ENEMY.getName(), EnemyManProperties.DEFAULT_STUPID_ENEMY.getInitLevel(),
                coordinates, EnemyManProperties.DEFAULT_STUPID_ENEMY.getInitHealth(), InitConstants.getStupidEnemyInitWeapon());
    }
}

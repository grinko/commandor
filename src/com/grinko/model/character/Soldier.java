package com.grinko.model.character;

/**
 * Created by grinko on 16.8.15.
 */
public class Soldier extends BaseCommando {
    public Soldier() {
        super(InitConstants.DEFAULT_COORDINATES, InitConstants.INIT_HEALTH, InitConstants.getSoldierInitWeapon(), 1);//TODO magic number
    }
}

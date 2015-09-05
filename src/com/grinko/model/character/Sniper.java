package com.grinko.model.character;

/**
 * Created by grinko on 16.8.15.
 */
public class Sniper extends BaseCommando{

    public Sniper() {
        super(InitConstants.DEFAULT_COORDINATES, InitConstants.INIT_HEALTH,
                InitConstants.getSniperInitWeapon(),
                InitConstants.DEFAULT_START_LEVEL);
    }

}

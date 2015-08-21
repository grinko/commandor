package com.grinko.model.character;

/**
 * Created by grinko on 16.8.15.
 */
public interface ICommando {
    void shootToXY();
    int getHealth();
    int getMaxDistanceForShoot();
    int getMaxDistanceForGrenade();
    void throwGrenadeToXY();
}

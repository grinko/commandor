package com.grinko.model.character;

import com.grinko.model.character.weapon.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by grinko on 16.8.15.
 */
public class InitConstants {

    public final static int INIT_HEALTH = 20;
    public final static Coordinates DEFAULT_COORDINATES = new Coordinates(0, 0);
    public final static int MAX_WEAPON = 3;
    public final static int DEFAULT_START_LEVEL = 1;

    public static List<IWeapon> getSniperInitWeapon() {
        IWeapon sniperRifle = new SniperRifle();
        IWeapon knife = new Knife();
        List<IWeapon> weapons = new ArrayList<IWeapon>(InitConstants.MAX_WEAPON);
        weapons.add(sniperRifle);
        weapons.add(knife);
        return weapons;
    }

    public static List<IWeapon> getSoldierInitWeapon() {
        IWeapon assaultRifle = new AssaultRifle();
        IWeapon knife = new Knife();
        List<IWeapon> weapons = new ArrayList<IWeapon>(InitConstants.MAX_WEAPON);
        weapons.add(assaultRifle);
        weapons.add(knife);
        return weapons;
    }

    public static List<IWeapon> getStupidEnemyInitWeapon() {
        IWeapon pistol = new Pistol();
        List<IWeapon> weapons = new ArrayList<IWeapon>(InitConstants.MAX_WEAPON);
        weapons.add(pistol);
        return weapons;
    }
}

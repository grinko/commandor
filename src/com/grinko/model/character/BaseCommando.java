package com.grinko.model.character;

import com.grinko.map.GameMap;
import com.grinko.map.GameMap.*;
import com.grinko.model.character.weapon.IWeapon;

import java.util.List;

/**
 * Created by grinko on 16.8.15.
 */
//TODO rework interfaces and abstract classes
public class BaseCommando implements IMove{

    private String name;
    private String type;
    private int level;
    private Coordinates coordinates;
    private int health;
    private List<IWeapon> weapons;
    private int hitCounter;

    public BaseCommando() {
        this.coordinates = new Coordinates(0, 0);
    }

    public BaseCommando(Coordinates coordinates, int health, List<IWeapon> weapons, int level) {
        this.coordinates = coordinates;
        this.health = health;
        this.weapons = weapons;
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public List<IWeapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<IWeapon> weapons) {
        this.weapons = weapons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void incLevel() {
        this.level++;
    }

    public int getHitCounter() {
        return hitCounter;
    }

    public void setHitCounter(int hitCounter) {
        this.hitCounter = hitCounter;
    }

    @Override
    public String moveUp() {
        FIELD_CONTENT fieldType = GameMap.checkMoveAbility(coordinates.getX() - 1, coordinates.getY());
        return move(fieldType, coordinates.getX() - 1, coordinates.getY());
    }

    @Override
    public String moveDown() {
        FIELD_CONTENT fieldType = GameMap.checkMoveAbility(coordinates.getX() + 1, coordinates.getY());
        return move(fieldType, coordinates.getX() + 1, coordinates.getY());
    }

    @Override
    public String moveLeft() {
        FIELD_CONTENT fieldType = GameMap.checkMoveAbility(coordinates.getX(), coordinates.getY() - 1);
        return move(fieldType, coordinates.getX(), coordinates.getY() - 1);
    }

    @Override
    public String moveRight() {
        FIELD_CONTENT fieldType = GameMap.checkMoveAbility(coordinates.getX(), coordinates.getY() + 1);
        return move(fieldType, coordinates.getX(), coordinates.getY() + 1);
    }

    private String move(FIELD_CONTENT fieldType, int x, int y) {
        String message = "";
        switch (fieldType) {
            case BORDER:
                message = "You cannot go here: BORDER";
                break;
            case ROAD:
                coordinates.setX(x);
                coordinates.setY(y);
                message = "ROAD";
                break;
            case TREE:
                //speed should reduce
                coordinates.setX(x);
                coordinates.setY(y);
                message = "FOREST";
                break;
            case MAN:
                message = "Here is a man";
                break;
            case MOUNTAIN:
                message = "You cannot go here without equipment: MOUNTAIN";
                break;
            case WATER:
                message = "You cannot go here without equipment: RIVER";
                break;
            case UNDEFINED:
                message = "Happened something strange. You can not go here for undefined reason.";
                break;
            default:
                message = "Happened something strange. You can not go here for undefined reason.";
                break;
        }
        return message;
    }
}

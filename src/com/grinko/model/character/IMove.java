package com.grinko.model.character;

/**
 * Created by grinko on 16.8.15.
 */
public interface IMove {
    String moveUp();
    String moveDown();
    String moveLeft();
    String moveRight();

    Coordinates getCoordinates();
}

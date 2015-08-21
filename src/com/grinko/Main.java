package com.grinko;

import com.grinko.engine.GameEngine;
import com.grinko.map.GameMap;
import com.grinko.model.character.Sniper;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //GameMap.printMap(new Sniper().getCoordinates());
        GameEngine.startGame();
    }
}

package com.grinko.engine;

import com.grinko.map.GameMap;
import com.grinko.map.WelcomeScreen;
import com.grinko.model.character.*;
import com.grinko.model.character.weapon.IWeapon;

import java.util.Scanner;

/**
 * Created by grinko on 16.8.15.
 */
public class GameEngine {
    private static boolean isExitGame = false;

    private static BaseCommando pers;
    private static Coordinates persCoordinates = new Coordinates(0, 0);
    public static void startGame() {

        String persTypeName[] = WelcomeScreen.choosePersonage();
        pers = PersonageFactory.getPersByType(persTypeName[1]);
        pers.setName(persTypeName[0]);
        pers.setType(persTypeName[1]);
        clearConsole();
        GameMap.printScreen(persCoordinates, pers, "Let's move");
        Scanner in = new Scanner(System.in);
        while (true) {
            String actionStr = in.next();

            Character action = actionStr.length() == 1 ? actionStr.toLowerCase().charAt(0) : new Character(' ');
            String moveMessage = "";

            switch (action) {
                case 'w':
                    moveMessage = pers.moveUp();
                    clearConsole();
                    GameMap.printScreen(pers.getCoordinates(), pers, moveMessage);
                    break;
                case 's':
                    moveMessage = pers.moveDown();
                    clearConsole();
                    GameMap.printScreen(pers.getCoordinates(), pers, moveMessage);
                    break;
                case 'a':
                    moveMessage = pers.moveLeft();
                    clearConsole();
                    GameMap.printScreen(pers.getCoordinates(), pers, moveMessage);
                    break;
                case 'd':
                    moveMessage = pers.moveRight();
                    clearConsole();
                    GameMap.printScreen(pers.getCoordinates(), pers, moveMessage);
                    break;
                case 'i':
                    displayItemList();
                    break;
                case 'p':
                    clearConsole();
                    GameMap.printScreen(pers.getCoordinates(), pers, moveMessage);
                    break;
                case 'n':
                    clearConsole();
                    GameMap.printInnerScreen(pers.getCoordinates(), pers, moveMessage);
                    break;
                case '9':
                    exitGame();
                    break;
                default:
                    break;
            }

        }
    }

    private static void displayItemList() {
        //implement
        clearConsole();
        System.out.println("Your weapons:");
        for(IWeapon item : pers.getWeapons()) {
            System.out.println(item.getName() + "[damage:" + item.getDamage() + ", distance:" + item.getDistance() + "]");
        }
        System.out.println();
        System.out.println("p - RETURN");
    }

    public static void saveGame() {

    }

    public static void exitGame() {
        isExitGame = true;
        System.out.println("Closing game.");
        System.exit(0);
    }

    public static void loadGame() {

    }

    public final static void clearConsole() {
        //System.console().reader().read();
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                //Runtime.getRuntime().exec("clear");
                final String ANSI_CLS = "\u001b[2J";
                final String ANSI_HOME = "\u001b[H";
                System.out.print(ANSI_CLS + ANSI_HOME);
                System.out.flush();
            }
        } catch (final Exception e) {
            //  Handle any exceptions.
        }

    }
}

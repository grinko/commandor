package com.grinko.map;

import com.grinko.engine.GameEngine;
import com.grinko.model.character.BaseCommando;
import com.grinko.model.character.Coordinates;
import com.grinko.model.character.enemy.BaseEnemy;
import com.grinko.model.character.enemy.animal.Bear;
import com.grinko.model.character.enemy.animal.Wolf;
import com.grinko.model.character.enemy.man.BaseEnemyMan;
import com.grinko.model.character.enemy.man.StupidEnemy;

import java.util.*;

/**
 * Created by grinko on 16.8.15.
 */
public class GameMap {

    public enum FIELD_CONTENT {BORDER, MOUNTAIN, WATER, TREE, MAN, ROAD, UNDEFINED};

    private static final int MAP_MAX_X = 20;
    private static final int MAP_MAX_Y = 40;

    private static String[][] map = {
            {"^","^","^","^","^","^","^","^","^","^","^","^","^","^",".",".",".",".",".",".",".",".",".",".",".","T","T",".",".",".",".",".",".",".",".",".",".",".",".","."},
            {".",".",".",".",".",".",".","^","^","^","^","^","^",".",".",".",".",".",".","o",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".","T","T"},
            {".",".",".",".",".",".",".",".","^","^","^",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".","T",".",".",".",".",".",".",".",".","T","~"},
            {"~",".",".",".",".",".",".",".",".","^","^",".",".",".",".",".","o",".",".",".",".",".","^",".",".",".",".",".",".",".",".",".",".",".",".",".","~","~","~","~"},
            {".","~","~","~","~","~","~",".",".",".",".",".",".",".",".",".",".",".",".",".","^","^","^","^",".",".",".",".",".",".",".",".",".",".",".","~","~","~","~","~"},
            {".","T",".","T","T","T",".","~","~",".","~","~","~","~","~","~","~","~",".","^","^","^","~","~","~","~","~","~","~","~","~","~","~","~","~","~","~","~","~","~"},
            {".","T","T","T","T","T","T",".",".",".","T",".",".",".",".",".",".",".","~","~","~","~",".",".",".",".",".",".",".",".",".","~","~","~","~","~","~","~","~","~"},
            {".",".","T","T",".","T","^",".",".",".","T","T",".",".","T","T",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".","~","~","~","~","~","~","~"},
            {".",".",".",".",".","^","^","^","^","T","T",".",".",".","T","T",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".","~","~","~"},
            {".","o",".",".",".",".","^","^","^","^",".",".",".",".",".","T",".",".",".",".","o",".",".",".",".",".",".","T",".",".",".",".",".",".",".",".",".",".","~","~"},
            {".",".",".",".",".",".","^","^","^","^",".",".",".",".",".","T",".",".",".",".",".",".",".",".",".",".",".","T",".",".",".",".",".",".",".",".",".",".",".","."},
            {".",".",".",".",".",".",".",".",".",".",".",".",".","T","T","T",".",".",".",".",".",".",".",".",".","T","T","T",".",".",".",".",".",".",".",".",".",".",".","."},
            {".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".","T","T",".",".",".",".",".",".",".",".",".","T",".","."},
            {".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".","T",".","T",".",".",".",".",".",".",".","T","T","T","T"},
            {".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".","T",".",".",".",".",".",".","T","T","T","T","T",".",".",".",".",".",".",".",".",".","."},
            {".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".","T","T","T","T","T","T","T","T","T",".",".",".",".",".","T","T","T"},
            {".","^","^",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".","T","T","T","T","T","T","T","T","T","T","T",".",".","T","T"},
            {"^","^","^","^","^","T","T",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".","T",".","T","T","T","T","T","T",".",".",".","T","T",".","T","T"},
            {"^","^","^","^","^","^","T","T",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".","T","T","T","T",".","T","T",".",".",".","T","T","T","."},
            {"^","^","^","^","^","^","^","T","T","T",".",".",".","T",".",".",".",".",".",".",".",".",".",".",".",".","T","T","T",".",".",".",".",".",".",".",".","T","T","."}
            };
    private static HiddenFieldContent[][] hiddenMap = new HiddenFieldContent[MAP_MAX_X][MAP_MAX_Y];

    static {
        randomFillHiddenMap();
    }

    private static void randomFillHiddenMap() {
        for (int i = 0; i < MAP_MAX_X + MAP_MAX_Y; i++) {//TODO random number of events
            int x = randInt(0, MAP_MAX_X - 1);
            int y = randInt(0, MAP_MAX_Y - 1);
            hiddenMap[x][y] = randomField();
        }
    }

    private static HiddenFieldContent randomField() {
        int i = randInt(0, 6);
        HiddenFieldContent result;
        switch (i) {
            case 0:
                result = HiddenFieldContent.PISTOL;
                break;
            case 1:
                result = HiddenFieldContent.WOLF;
                break;
            case 2:
                result = HiddenFieldContent.BEAR;
                break;
            case 3:
                result = HiddenFieldContent.PIT;
                break;
            case 4:
                result = HiddenFieldContent.OPTICAL_SIGHT;
                break;
            case 5:
                result = HiddenFieldContent.PEOPLE;
                break;
            case 6:
                result = HiddenFieldContent.ROUNDS_BOX;
                break;
            default:
                result = HiddenFieldContent.ROUNDS_BOX;
                break;
        }
        return result;
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public static void printScreen(Coordinates personCoordinates, BaseCommando pers, String message) {
        printInfoLine(pers);
        printMessageLine(message);
        printMap(personCoordinates);
        printHints(personCoordinates);
    }

    private static void printHints(Coordinates coordinates) {
        if (hiddenMap[coordinates.getX()][coordinates.getY()] != null) {
            System.out.print(hiddenMap[coordinates.getX()][coordinates.getY()].getMessage());
            System.out.println("Press n+Enter.");
        }
    }

    private static void printMessageLine(String message) {
        System.out.println(message);
    }

    private static void printInfoLine(BaseCommando pers) {
        System.out.print(pers.getType() + " " + pers.getName());
        System.out.print(" | ");
        System.out.println("Level: " + pers.getLevel());
    }

    private static void printMap(Coordinates personCoordinates) {
        for(int row = 0; row < map.length; row++) {
            for(int col = 0; col < map[0].length; col++) {
                if (!(row == personCoordinates.getX() && col == personCoordinates.getY())) {
                    System.out.print(map[row][col]);
                } else {
                    System.out.print(WelcomeScreen.PERSONAGE);
                }
            }
            printControlKeys(row);
            System.out.println();
        }
    }

    private static void printControlKeys(int row) {
        if (row == 1) {
            System.out.print(" | Control Keys:");
        } else
        if (row == 2) {
            System.out.print(" | w+Enter - UP");
        } else
        if (row == 3) {
            System.out.print(" | s+Enter - DOWN");
        } else
        if (row == 4) {
            System.out.print(" | a+Enter - LEFT");
        } else
        if (row == 5) {
            System.out.print(" | d+Enter - RIGHT");
        } else
        if (row == 7) {
            System.out.print(" | i+Enter - Items");
        } else
        if (row == MAP_MAX_X - 1) {
            System.out.print(" | 9+Enter - Exit");
        } else {
            System.out.print(" | ");
        }
    }

    public static FIELD_CONTENT checkMoveAbility(int x, int y) {
        if (x < 0 || y < 0 || x >= MAP_MAX_X || y >= MAP_MAX_Y) {
            return FIELD_CONTENT.BORDER;
        }
        if (map[x][y].equals(".")) {
            return FIELD_CONTENT.ROAD;
        }
        if (map[x][y].equals("T")) {
            return FIELD_CONTENT.TREE;
        }
        if (map[x][y].equals("o")) {
            return FIELD_CONTENT.MAN;
        }
        if (map[x][y].equals("^")) {
            return FIELD_CONTENT.MOUNTAIN;
        }
        if (map[x][y].equals("~")) {
            return FIELD_CONTENT.WATER;
        }
        return FIELD_CONTENT.UNDEFINED;
    }

    public static void printInnerScreen(Coordinates coordinates, BaseCommando pers, String moveMessage) {
        HiddenFieldContent hiddenFieldContent = hiddenMap[coordinates.getX()][coordinates.getY()];
        System.out.print(hiddenFieldContent.getMessage());
        if ("ATTACK".equals(hiddenFieldContent.getEventType())) {
            printAttackScreen(hiddenFieldContent, pers);
        }
        if ("FIND".equals(hiddenFieldContent.getEventType())) {
            printFindScreen();
            //TODO implement [put the stuff into items]
        }
        if ("ACCIDENT".equals(hiddenFieldContent.getEventType())) {
            printAccidentScreen();
        }

    }

    private static void printAccidentScreen() {
        System.out.println("... and died. Game over looser");
        System.out.println("Press 9+Enter to exit game");
        //TODO implement variants without death
        //TODO fix [user can just ignore n+Enter and continue the game]
    }

    private static void printFindScreen() {
        System.out.println("Do you want to put it into you backpack?");
        System.out.println("Press p+Enter to return on previous screen");
        //TODO implement
    }

    private static void printAttackScreen(HiddenFieldContent hiddenFieldContent, BaseCommando pers) {
        String[][] fightingMap = {
                {".",".",".",".",".",".",".",".",".",".","."},
                {".",".",".",".",".",".",".",".",".",".","."},
                {".",".",".",".",".",".",".",".",".",".","."},
                {".",".",".",".",".",".",".",".",".",".","."},
                {".",".",".",".",".","@",".",".",".",".","."},
                {".",".",".",".",".",".",".",".",".",".","."},
                {".",".",".",".",".",".",".",".",".",".","."},
                {".",".",".",".",".",".",".",".",".",".","."},
                {".",".",".",".",".",".",".",".",".",".","."},
                {".",".",".",".",".",".",".",".",".",".","."}};
        Coordinates persOnFightFieldCoord = new Coordinates(4, 5);//TODO rid of hardcoded coordinates
        List<BaseEnemy> enemyList = new ArrayList<>();
        int objNumber = 0;
        if (hiddenFieldContent.equals(HiddenFieldContent.WOLF)) {
            objNumber = randInt(1, 10);//TODO randInt(0,10) if 0 then Wolves were frightened and ran away
            for (int i = 0; i < objNumber; i++) {
                int x = randInt(0, fightingMap.length - 1);
                int y = randInt(0, fightingMap[0].length - 1);
                fightingMap[x][y] = "o";
                Coordinates coord = new Coordinates(x, y);
                enemyList.add(new Wolf(coord));
            }
        }
        if (hiddenFieldContent.equals(HiddenFieldContent.BEAR)) {
            objNumber = randInt(1, 3);//TODO randInt(0,3) if 0 then Bears were frightened and ran away
            for (int i = 0; i < objNumber; i++) {
                int x = randInt(0, fightingMap.length - 1);
                int y = randInt(0, fightingMap[0].length - 1);
                fightingMap[x][y] = "o";
                Coordinates coord = new Coordinates(x, y);
                enemyList.add(new Bear(coord));
            }
        }
        if (hiddenFieldContent.equals(HiddenFieldContent.PEOPLE)) {
            objNumber = randInt(1, 5);//TODO randInt(0,10) if 0 then Enemies were frightened and ran away
            for (int i = 0; i < objNumber; i++) {
                int x = randInt(0, fightingMap.length - 1);
                int y = randInt(0, fightingMap[0].length - 1);
                fightingMap[x][y] = "o";
                Coordinates coord = new Coordinates(x, y);
                enemyList.add(new StupidEnemy(coord));
            }
        }

        Coordinates aimCoordinates = new Coordinates(0,0);
        printFightingMap(fightingMap, aimCoordinates);
        fight(fightingMap, aimCoordinates, enemyList, pers, persOnFightFieldCoord);



    }

    private static void printFightingMap(String[][] fightingMap, Coordinates aimCoordinates) {
        System.out.println("Find your aim with w,a,s,d keys + Enter.");
        System.out.println("Press f+Enter for shooting. ");
        for(int row = 0; row < fightingMap.length; row++) {
            for(int col = 0; col < fightingMap[0].length; col++) {
                if (row == aimCoordinates.getX() && col == aimCoordinates.getY()) {
                    System.out.print("x");
                } else {
                    System.out.print(fightingMap[row][col]);
                }
            }
            //printControlKeys(row);
            System.out.println();
        }
        System.out.println("u+Enter to exit");
    }


    //TODO move to GameEngine
    private static void fight(String[][] fightingMap, Coordinates aimCoord, List<BaseEnemy> enemyList, BaseCommando pers, Coordinates persOnFightFieldCoord) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String actionStr = in.next();

            Character action = actionStr.length() == 1 ? actionStr.toLowerCase().charAt(0) : new Character(' ');
            String moveMessage = "";
            //TODO make sure you can move your target on that particular cell
            switch (action) {
                case 'w':
                    aimCoord.setX(aimCoord.getX() - 1);
                    GameEngine.clearConsole();
                    printFightingMap(fightingMap, aimCoord);
                    break;
                case 's':
                    aimCoord.setX(aimCoord.getX() + 1);
                    GameEngine.clearConsole();
                    printFightingMap(fightingMap, aimCoord);
                    break;
                case 'a':
                    aimCoord.setY(aimCoord.getY() - 1);
                    GameEngine.clearConsole();
                    printFightingMap(fightingMap, aimCoord);
                    break;
                case 'd':
                    aimCoord.setY(aimCoord.getY() + 1);
                    GameEngine.clearConsole();
                    printFightingMap(fightingMap, aimCoord);
                    break;
                case 'f':
                    //SHOOT
                    GameEngine.clearConsole();
                    printFightingMap(fightingMap, aimCoord);
                    boolean isShootAtTarget = false;
                    for (BaseEnemy enemy : enemyList) {
                        if (enemy.getCoordinates().getX() == aimCoord.getX()
                                && enemy.getCoordinates().getY() == aimCoord.getY()) {
                            persShootAtEnemy(fightingMap, pers, enemy, persOnFightFieldCoord);
                            System.out.println();
                            isShootAtTarget = true;
                        }
                    }
                    Iterator<BaseEnemy> iterator = enemyList.iterator();
                    while (iterator.hasNext()) {
                        BaseEnemy enemy = iterator.next();
                        if (enemy.getHealth() <= 0) {
                            iterator.remove();
                        }
                    }
                    if (!isShootAtTarget) {
                        System.out.println("You shot at an empty field. Aim at the enemy!");
                    }
                    if (!enemyList.isEmpty() && enemyList.get(0) instanceof BaseEnemyMan) {
                        enemiesShootAtPers(enemyList, pers, persOnFightFieldCoord);
                    }
                    if (pers.getHealth() <= 0) {
                        System.out.println("You were killed by the enemies. Press 9+Enter to exit game.");
                    }
                    break;
                /*case 'n':
                    GameEngine.clearConsole();
                    GameMap.printInnerScreen(pers.getCoordinates(), pers, moveMessage);
                    break;*/
                case 'u':
                    GameEngine.clearConsole();
                    GameMap.printScreen(pers.getCoordinates(), pers, moveMessage);
                    break;
                case '9':
                    GameEngine.exitGame();
                    break;
                default:
                    break;
            }

        }
    }

    private static void enemiesShootAtPers(List<BaseEnemy> enemyList, BaseCommando pers, Coordinates persOnFightFieldCoord) {
        for (BaseEnemy enemy : enemyList) {
            double distance = Math.sqrt((persOnFightFieldCoord.getX() - enemy.getCoordinates().getX())
                    * (persOnFightFieldCoord.getX() - enemy.getCoordinates().getX())
                    + (persOnFightFieldCoord.getY() - enemy.getCoordinates().getY())
                    * (persOnFightFieldCoord.getY() - enemy.getCoordinates().getY()));

            int maxDistance = ((BaseEnemyMan) enemy).getWeapons().get(0).getDistance();
            int defaultDamage = ((BaseEnemyMan) enemy).getWeapons().get(0).getDamage();
            int enemyLevel = ((BaseEnemyMan) enemy).getLevel();
            Random random = new Random();
            int actualDamage = Math.round(defaultDamage * randInt(1, enemyLevel) / randInt(1, 10));
            if(distance < maxDistance) {
                pers.setHealth(pers.getHealth() - actualDamage);
                System.out.println("Enemy has shoot at you and reduced your health on " + actualDamage + "points.");
                System.out.println("Your health: " + pers.getHealth());
            }
        }

    }

    private static void persShootAtEnemy(String[][] fightingMap, BaseCommando pers, BaseEnemy enemy, Coordinates persOnFightFieldCoord) {
        //TODO implement choosing of active weapon (i.e. split hands and items)
        int maxDistance = pers.getWeapons().get(0).getDistance();
        int defaultDamage = pers.getWeapons().get(0).getDamage();
        String weaponType = pers.getWeapons().get(0).getName();

        int persLevel = pers.getLevel();

        double distance = Math.sqrt((persOnFightFieldCoord.getX() - enemy.getCoordinates().getX())
                * (persOnFightFieldCoord.getX() - enemy.getCoordinates().getX())
                + (persOnFightFieldCoord.getY() - enemy.getCoordinates().getY())
                * (persOnFightFieldCoord.getY() - enemy.getCoordinates().getY()));
        //TODO think about game balance
        int actualDamage = Math.round(defaultDamage * randInt(1, persLevel) / randInt(1, 10));
        if (distance < maxDistance) {
            enemy.setHealth(enemy.getHealth() - actualDamage);
            pers.setHitCounter(pers.getHitCounter() + actualDamage);
            //TODO implement nonlinear level upgrade
            if (pers.getHitCounter() >= 10) {
                pers.setLevel(pers.getLevel() + 1);
                pers.setHitCounter(pers.getHitCounter() - 10);
                System.out.println("COngrats, you've received level UP");
            }
            System.out.println("You've shoot the enemy and reduced his health on " + actualDamage + "points.");
            if (enemy.getHealth() <= 0) {
                System.out.println("The enemy is dead. ");
                fightingMap[enemy.getCoordinates().getX()][enemy.getCoordinates().getY()] = ".";
            }
            //TODO implement reducing of number of bullets
        } else {
            System.out.println("Your rifle cannot shoot on such distance!");
        }

    }

}

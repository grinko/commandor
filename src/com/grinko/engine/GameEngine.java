package com.grinko.engine;

import com.grinko.map.GameMap;
import com.grinko.map.WelcomeScreen;
import com.grinko.model.character.*;
import com.grinko.model.character.enemy.BaseEnemy;
import com.grinko.model.character.enemy.animal.BaseAnimal;
import com.grinko.model.character.enemy.man.BaseEnemyMan;
import com.grinko.model.character.weapon.IWeapon;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
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
        moveControl();

    }

    public static void moveControl() {
        Scanner in = new Scanner(System.in);
        while (true) {
            String actionStr = in.next();

            Character action = actionStr.length() == 1 ? actionStr.toLowerCase().charAt(0) : new Character(' ');
            String moveMessage = "";
            if (pers.getHealth() <= 0 && !"9".equals(action.toString())) {
                System.out.println("Your pers is dead. Press 9+Enter to exit game.");
                continue;
            }

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
                //Runtime.getRuntime().exec("cls");
                for (int i = 0; i < 500; i++) {
                    System.out.println();
                }
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

    public static void fight(String[][] fightingMap, Coordinates aimCoord, List<BaseEnemy> enemyList, BaseCommando pers, Coordinates persOnFightFieldCoord) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String actionStr = in.next();

            Character action = actionStr.length() == 1 ? actionStr.toLowerCase().charAt(0) : new Character(' ');
            String moveMessage = "";
            //TODO make sure you can move your target on that particular cell
            if (pers.getHealth() <= 0 && !"9".equals(action)) {
                System.out.println("You were killed by the enemies. Press 9+Enter to exit game.");
            }
            switch (action) {
                case 'w':
                    aimCoord.setX(aimCoord.getX() - 1);
                    clearConsole();
                    GameMap.printFightingMap(fightingMap, aimCoord, enemyList);
                    break;
                case 's':
                    aimCoord.setX(aimCoord.getX() + 1);
                    clearConsole();
                    GameMap.printFightingMap(fightingMap, aimCoord, enemyList);
                    break;
                case 'a':
                    aimCoord.setY(aimCoord.getY() - 1);
                    clearConsole();
                    GameMap.printFightingMap(fightingMap, aimCoord, enemyList);
                    break;
                case 'd':
                    aimCoord.setY(aimCoord.getY() + 1);
                    clearConsole();
                    GameMap.printFightingMap(fightingMap, aimCoord, enemyList);
                    break;
                case 'f':
                    //SHOOT
                    clearConsole();
                    GameMap.printFightingMap(fightingMap, aimCoord, enemyList);
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
                    if (!enemyList.isEmpty() && enemyList.get(0) instanceof BaseAnimal) {
                        animalsAttackPers(fightingMap, enemyList, pers, persOnFightFieldCoord);
                        GameMap.printFightingMap(fightingMap, aimCoord, enemyList);
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
                    clearConsole();
                    GameMap.printScreen(pers.getCoordinates(), pers, moveMessage);
                    break;
                case '9':
                    exitGame();
                    break;
                default:
                    break;
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
        int actualDamage = Math.round(defaultDamage * GameMap.randInt(1, persLevel) / GameMap.randInt(1, 10));
        if (distance < maxDistance) {
            enemy.setHealth(enemy.getHealth() - actualDamage);
            pers.setHitCounter(pers.getHitCounter() + actualDamage);
            //TODO implement nonlinear level upgrade
            if (pers.getHitCounter() >= 10) {
                pers.incLevel();
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
            int actualDamage = Math.round(defaultDamage * GameMap.randInt(1, enemyLevel) / GameMap.randInt(1, 10));
            if(distance < maxDistance) {
                pers.setHealth(pers.getHealth() - actualDamage);
                System.out.println("Enemy has shoot at you and reduced your health on " + actualDamage + "points.");
                System.out.println("Your health: " + pers.getHealth());
            }
        }

    }

    private static void animalsAttackPers(String[][] fightingMap, List<BaseEnemy> enemyList, BaseCommando pers, Coordinates persOnFightFieldCoord) {
        for (BaseEnemy enemy : enemyList) {
            if (GameMap.isNeighboardCell(enemy.getCoordinates(), persOnFightFieldCoord)) {
                pers.setHealth(pers.getHealth() - ((BaseAnimal)enemy).getDamage());
                System.out.println("Animal hits you. Damage is " + ((BaseAnimal)enemy).getDamage());
                System.out.println("Your health is " + pers.getHealth());
            } else {
                GameMap.moveToXY(enemy, fightingMap, persOnFightFieldCoord);//TODO print info
                System.out.println("enemy moved to X="+enemy.getCoordinates().getX() + ", Y=" + enemy.getCoordinates().getY());
                //use Directions in the out info
            }
        }
    }
}

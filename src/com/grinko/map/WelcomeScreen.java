package com.grinko.map;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by grinko on 16.8.15.
 */
public class WelcomeScreen {

    //welcome
    private static String welcomeMessage = "Hello gamer, let's dive into world of Special Forces missions.";
    private static String choosePersonage = "Choose personage: ";
    private static String chooseNumber = "Choose number: ";
    private static String pressEnter = "Press Enter:";

    //map objects
    private static String mountainMapLegend = "^ - Mountain";
    private static String pathMapLegend = ". - Road/Route/Pathway";
    private static String treeMapLegend = "T - Tree/Forest";
    private static String waterMapLegend = "~ - River/Water/Lake";
    private static String wallMapLegend = "| and _ - Wall/Door";
    private static String manMapLegend = "o - Man";
    public final static String PERSONAGE = "@";

    public static Scanner in = new Scanner(System.in);
    public static int question;

    public static String name;
    public static String command;
    private static String persType;

    public static String[] choosePersonage() {
        System.out.println(welcomeMessage);
        System.out.println("What is your name?");
        name = in.next();
        exitIfTypedExit(name);
        String result[] = new String[2];
        result[0] = name;
        boolean isVariantChoosen = false;
        while (!isVariantChoosen) {
            printPersonageVariants();
            try {
                command = in.next();
                exitIfTypedExit(command);
                question = Integer.parseInt(command);

            } catch (Exception ex) {
                System.out.println("Choose one of the variants above plz");
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            switch (question) {
                case 1:
                    System.out.println("Hello sniper " + name);
                    persType = "SNIPER";
                    isVariantChoosen = true;
                    break;
                case 2:
                    System.out.println("Hello soldier " + name);
                    persType = "SOLDIER";
                    isVariantChoosen = true;
                    break;
                default:
                    System.out.println("Choose one of the variants above plz");
                    break;
            }
        }

        result[1] =  persType;
        System.out.println("Press Enter to start");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static void exitIfTypedExit(String command) {
        if (command.equalsIgnoreCase("exit")){
            System.out.println("Closing game.");
            System.exit(0);
        }
    }


    private static void printPersonageVariants() {
        System.out.println("Choose your personage: ");
        System.out.println("1: Sniper");
        System.out.println("2: Soldier");
    }

}

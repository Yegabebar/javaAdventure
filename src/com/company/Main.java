package com.company;

import com.company.miscellaneous.Scores;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    /**
     * The player will be stuck on this menu until he will input a String corresponding to one of the supported cases.
     * The 3rd choice is a cheat code to set up the game with harder settings for the player
     * @param args
     */
    public static void main(String[] args) {

        boolean keepUp = true;
        //While the play doesn't
        while(keepUp) {
            System.out.println("Choose between the following options");
            System.out.println("1 - Start game");
            System.out.println("2 - View Highscores");
            System.out.println("3 - Quit");

            String userInput = getPlayerInput();
            switch (userInput) {
                case "1" -> {
                    Game.start("normal");
                }
                case "2" -> {
                    Scores.getScoreBoard();
                }
                case "3" -> {
                    return;
                }
                case "hit me with a brick" -> {
                    Game.start("hardcore");
                }
                default -> {
                    System.out.println("Option not available, please try again");
                }
            }
        }
    }

    /**
     * Function used each time we need a string from the player
     * @return the String written by the player
     */
    public static String getPlayerInput() {
        Scanner sc = new Scanner(System.in);
        String userInput= null;
        try {
            userInput = sc.nextLine();
        } catch (Exception e) {
            System.out.println("Sorry wrong input, please try again");
        }

        return userInput;
    }
}



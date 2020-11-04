package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game.startGame();
    }
/*        boolean keepPlaying = true;

        while (keepPlaying) {
            System.out.println("Choose between the following options");
            System.out.println("1 - Start game");
            System.out.println("2 - Quit");

            String userInput = getPlayerInput();
            switch (userInput) {
                case "1" -> {
                    Game.startGame();
                }
                case "2" -> {
                    return;
                }
                default -> {
                    System.out.println("Option not available, please try again");
                }
            }
        }
    }*/

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



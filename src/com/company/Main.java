package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean keepPlaying = true;

        while (keepPlaying) {
            System.out.println("Choose between the following options");
            System.out.println("1 - Start game");
            System.out.println("2 - Quit");

            int userInput = getPlayerInput();
            switch (userInput) {
                case 1 -> {
                    Game.start();
                }
                case 2 -> {
                    return;
                }
                default -> {
                    System.out.println("Option not available, please try again");
                }
            }
        }
    }

    public static int getPlayerInput() {
        Scanner sc = new Scanner(System.in);
        int userInput = 0;
        try {
            userInput = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Sorry wrong input, please try again");
        }
        sc.nextLine();
        return userInput;
    }
}



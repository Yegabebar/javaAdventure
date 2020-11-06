package com.company.miscellaneous;

import java.util.Map;
import java.util.TreeMap;

public class Scores {
    private static Map<Long,String> scoreBoard = new TreeMap();

    public static void getScoreBoard() {
        for (Map.Entry<Long, String> entry : scoreBoard.entrySet()) {
            System.out.println("=== HIGHSCORES ==");
            System.out.println(entry.getValue() + " " + entry.getKey());
            System.out.println("=================");
        }
    }

    public static void setScore(Long score, String pseudo) {
        scoreBoard.put(score,pseudo);
    }
}

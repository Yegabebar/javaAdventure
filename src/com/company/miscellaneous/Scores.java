package com.company.miscellaneous;

import java.util.Map;
import java.util.TreeMap;

public abstract class Scores {
    private static Map<Long,String> scoreBoard = new TreeMap();

    /**
     * Calls the scoreboard sorted by ascending score key. (default behavior of a Treemap)
     */
    public static void getScoreBoard() {
        System.out.println("=== HIGHSCORES ==");
        for (Map.Entry<Long, String> entry : scoreBoard.entrySet()) {
            System.out.println(entry.getValue() + " " + entry.getKey()+" seconds");
        }
        System.out.println("=================");
    }
    /**
     * Writes a new score/nickname couple into the scoreboard each time the function is called
     */
    public static void setScore(Long score, String nickname) {
        scoreBoard.put(score,nickname);
    }
}

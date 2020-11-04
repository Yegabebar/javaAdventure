package com.company.miscellaneous;

public class Events{


    public static boolean eventRandomizer(double triggeringPercentage){
        boolean eventIsHappening = false;
        double criticalHitRand = Math.random();
        if (criticalHitRand<triggeringPercentage){
            eventIsHappening = true;
        }
        return eventIsHappening;
    }



}

package com.example.bowling;

import java.util.Random;

public class Game {

    int totalScore = 0;
    int roundCounter = 0;
    int rollCount = 0;
    int pins = 10;

    public int score() {
        return totalScore;
    }

    public void pins(int roll) {
        totalScore += roll;
    }

    public void roll(int downPins) {
        Random rand = new Random();
        rollCount++;
        if(rollCount == 2 ){
            roundCounter++;
            rollCount = 0;
        }
        int downed = rand.nextInt(downPins) +1;
        pins(downed);
        pins -= downed;
    }
}

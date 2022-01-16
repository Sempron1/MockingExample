package com.example.bowling;

import java.util.Random;

public class Game {

    int totalScore = 0;
    int roundCounter = 0;
    int rollCount = 0;
    int downedPins = 0;
    int pins = 10;

    public int score() {
        return totalScore;
    }

    public void pins(int roll) {
        totalScore += roll;
    }

    public void roll(int downedPins) {
        Random rand = new Random();
        rollCount++;
        if(rollCount == 2 ){
            roundCounter++;
            rollCount = 0;
        }
        this.downedPins = rand.nextInt((10 - downedPins)) +1;
        pins(this.downedPins);
        pins -= this.downedPins;
    }
}

package com.example.bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    int totalScore = 0;
    int roundCounter = 1;
    int rollCount = 0;
    int downedPins = 0;
    int pins = 10;
    int[] roundPoints = new int[9];
    List<Integer> rollPoints = new ArrayList<>();

    public int score() {
        return totalScore;
    }

    public void pins(int roll) {
        totalScore += roll;
    }

    public void roll(int downedPins) {
        Random rand = new Random();
        rollCount++;

        this.downedPins = rand.nextInt((10 - downedPins)) +1;
        pins(this.downedPins);
        roundPoints[roundCounter -1] += this.downedPins;
        rollPoints.add(this.downedPins);
        pins -= this.downedPins;
        if(rollCount == 2 ){
            roundCounter++;
            rollCount = 0;
        }
    }
}

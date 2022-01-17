package com.example.bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    boolean strike = false;
    boolean spare = false;
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
        addPointsToPreviousRound(strike);

        rollCount++;
        this.downedPins = rand.nextInt((10 - downedPins)) +1;
        pins(this.downedPins);
        roundPoints[roundCounter -1] += this.downedPins;
        rollPoints.add(this.downedPins);
        pins -= this.downedPins;
        isStrike(this.downedPins);
        if(rollCount == 2 ){
            isSpare(pins);
            strike = false;

            roundCounter++;
            rollCount = 0;
        }
    }

    private void isSpare(int pins) {
        if(pins == 0){
            addRollPointsToPreviousRound();
            this.pins = 10;
        }
    }

    public void isStrike(int downedPins){
        if(downedPins == 10){
            strike = true;
            rollPoints.add(0);
            roundCounter++;
            rollCount = 0;
            pins = 10;
        }
    }
    public void addPointsToPreviousRound(boolean strike){
        if(strike){
            roundPoints[roundCounter -3] += roundPoints[roundCounter -2];
            pins(roundPoints[roundCounter -2]);
        }
    }

    public void addRollPointsToPreviousRound() {

            roundPoints[roundCounter -3] += rollPoints.get(rollPoints.size() -2);
            pins(rollPoints.get(rollPoints.size() -2));


    }
}

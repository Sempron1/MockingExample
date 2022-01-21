package com.example.bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    boolean strike = false;
    boolean spare = false;
    int totalScore = 0;
    static int bonus = 0;
    int roundCounter = 1;
    int rollCount = 0;
    int downedPins = 0;
    int pins = 10;
    int[] roundPoints = new int[12];
    List<Integer> rollPoints = new ArrayList<>();

    public int score() {
        if(roundCounter > 10 && strike)
            return totalScore -=20;
        else
            return totalScore;
    }

    public void pins(int roll) {
        totalScore += roll;
    }

    public void roll(int downedPins) {
        if(roundCounter == 11 && !strike && !spare ){
            finish();
        }
        rollCount++;
        this.downedPins = downedPins;
        pins(this.downedPins);
        roundPoints[roundCounter-1] += this.downedPins;
        rollPoints.add(this.downedPins);

        addPointsToPreviousRoundStrike(strike);
        addRollPointsToPreviousRoundSpare(spare);
        pins -= this.downedPins;
        isStrike(this.downedPins);
        if(roundCounter > 10 && strike){
            rollCount = 0;
            bonus++;
        }
        if(rollCount == 2){
            isSpare(pins);
            strike = false;
            roundCounter++;
            rollCount = 0;
            pins = 10;
        }

    }


    public void bowling() {
        Random rand = new Random();
        int bowlingThrow = downedPins = rand.nextInt((10 - downedPins));
        roll(bowlingThrow);

    }

    public void isSpare(int pins) {
        if(pins <=0){
            spare = true;
            this.pins = 10;
        }
    }

    public void isStrike(int downedPins){
        if(downedPins == 10 && rollCount%2 != 0){
            strike = true;
            roundCounter++;
            rollCount = 0;
            pins = 10;
        }
    }

    public void addPointsToPreviousRoundStrike(boolean strike){
        if(rollPoints.size() >= 3 && strike){
            if(rollPoints.get(rollPoints.size() -3) == 10){
                int previousRolls = rollPoints.get(rollPoints.size() -2) +  rollPoints.get(rollPoints.size() -1);
                int newScore = rollPoints.get(rollPoints.size() -3) + previousRolls;
                rollPoints.set(rollPoints.size()-3,newScore);
                pins(previousRolls);
            }
        }
    }

    public void addRollPointsToPreviousRoundSpare(boolean spare) {
        if(roundCounter == 11 && spare){
           totalScore -= rollPoints.get(rollPoints.size() - 1);
            finish();
        }
        if(spare && rollCount%2 != 0){
            pins(rollPoints.get(rollPoints.size() -1));
            this.spare = false;
        }

    }

    public void finish() {
            System.out.println("Game Finished!");
            System.out.println("Your score is: " + score());
    }
}

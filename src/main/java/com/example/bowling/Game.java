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
    List<Integer> rollList = new ArrayList<>();

    public int score() {
        if (roundCounter > 10 && strike)
            return totalScore -= 20;
        else
            return totalScore;
    }

    public void addRollToScore(int roll) {
        totalScore += roll;
    }

    public void roll(int downedPins) {
        rollCount++;
        this.downedPins = downedPins;
        addRollToScore(this.downedPins);
        rollList.add(this.downedPins);
        addPointsToPreviousRoundStrike(strike);
        addRollPointsToPreviousRoundSpare(spare);
        pins -= this.downedPins;
        isStrike(this.downedPins);
        strikeBonusRounds();
        startNextRound();
    }

    private void strikeBonusRounds() {
        if (roundCounter > 10 && strike) {
            rollCount = 0;
            bonus++;
        }
    }

    private void startNextRound() {
        if (rollCount == 2) {
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
        finish();
        roll(bowlingThrow);

    }

    public void isSpare(int pins) {
        if (pins <= 0) {
            spare = true;
            this.pins = 10;
        }
    }

    public void isStrike(int downedPins) {
        if (downedPins == 10 && rollCount % 2 != 0) {
            strike = true;
            roundCounter++;
            rollCount = 0;
            pins = 10;
        }
    }

    public void addPointsToPreviousRoundStrike(boolean strike) {
        if (rollList.size() >= 3 && strike) {
            if (rollList.get(position(3)) == 10) {
                int previousRolls = rollList.get(position(2)) + rollList.get(position(1));
                int newScore = rollList.get(position(3)) + previousRolls;
                rollList.set(position(3), newScore);
                addRollToScore(previousRolls);
            }
        }
    }

    private int position(int pos) {
        return rollList.size() - pos;
    }

    public void addRollPointsToPreviousRoundSpare(boolean spare) {
        if (roundCounter == 11 && spare) {
            totalScore -= rollList.get(position(1));
            finishMessage();
        }
        if (spare && rollCount % 2 != 0) {
            addRollToScore(rollList.get(position(1)));
            this.spare = false;
        }

    }

    public void finish() {
        if (roundCounter == 12 && strike) {
            finishMessage();
        } else if (roundCounter == 11 && !strike && !spare) {
            finishMessage();
        }
    }

    public void finishMessage() {
        System.out.println("Game Finished!");
        System.out.println("Your score is: " + score());
    }
}

package com.example.bowling;

import java.util.Random;

public class Game {

    int totalScore = 0;
    int roundCounter = 0;
    int rollCount = 0;

    public int score() {
        return totalScore;
    }

    public void pins(int roll) {
        totalScore += roll;
    }

    public void roll() {
        rollCount++;
        if(rollCount == 2 )
            roundCounter++;


    }
}

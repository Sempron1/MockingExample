package com.example.bowling;

import java.util.Random;

public class Game {

    int totalScore = 0;

    public int score() {
        return totalScore;
    }

    public int pins(int roll) {
        totalScore += roll;
        return totalScore;
    }

}

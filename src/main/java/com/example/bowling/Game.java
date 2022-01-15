package com.example.bowling;

import java.util.Random;

public class Game {

    int totalScore = 0;

    public int score() {
        return totalScore;
    }

    public void pins(int roll) {
        totalScore += roll;
    }

}

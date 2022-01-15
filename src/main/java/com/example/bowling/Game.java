package com.example.bowling;

import java.util.Random;

public class Game {

    int totalScore = 0;

    public int score() {
        return totalScore;
    }

    public int addScore(int score) {
        totalScore += score;
        return totalScore;
    }
}

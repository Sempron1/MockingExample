package com.example.bowling;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {


    @Test
    void ScoreMethodShouldReturnTotalScore() {
        Game game = new Game();

        int result = game.score();
        assertEquals(game.totalScore,result);
    }

    @Test
    void AddScoreMethodShouldIncreaseTotalScore() {
        Game game = new Game();
        int score = 10;
        int result = game.addScore(score);
        assertEquals(10,result);
    }
    
}
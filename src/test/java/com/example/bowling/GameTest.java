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

        int result = game.addScore(10);
        assertEquals(10,result);
    }
    
}
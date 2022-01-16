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
    void knockedDownedPinsShouldIncreaseTotalScore() {
        Game game = new Game();
        game.pins(10);
        var result = game.score();
        assertEquals(10,result);
    }

    @Test
    void roundShouldIncreaseAfterTwoRolls() {
        Game game = new Game();
        game.roll(3);
        game.roll(3);
        assertEquals(1,game.roundCounter);
    }

    @Test
    void rollCountShouldResetAfterEverySecondRoll() {
        Game game = new Game();
        game.roll(3);
        game.roll(3);
        assertEquals(0,game.rollCount);
    }

    @Test
    void rollMethodShouldKnockDownPinsAndAddToTotalScore() {
        Game game = new Game();
        game.roll(1);
        assertEquals(1,game.score());
    }

}
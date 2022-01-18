package com.example.bowling;

import org.junit.jupiter.api.Test;

import java.util.Random;

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
        assertEquals(2,game.roundCounter);
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

    @Test
    void AfterRollMethodIsCalledTheTotalPinsLeftShouldDecreaseDependingOnKnockedDownPins() {
        Game game = new Game();
        game.roll(1);
        assertEquals(9, game.pins);
    }

    @Test
    void AfterTwoRollsAddTheTotalScoreToRoundPointList() {
        Game game = new Game();
        game.roll(1);
        game.roll(1);

        assertEquals(2,game.roundPoints[0]);
    }

    @Test
    void AfterFourRollsRoundTwoShouldHaveStartedAndRoundTwoPointsShouldHaveIncreased() {
        Game game = new Game();
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);

        assertEquals(2,game.roundPoints[1]);
    }

    @Test
    void ListShouldSaveEveryScoreFromEveryIndividualRoll() {
        Game game = new Game();
        game.roll(1);
        game.roll(1);
        assertEquals(1, game.rollPoints.get(0));
        assertEquals(1, game.rollPoints.get(1));
    }


    @Test
    void WhenYouGetAStrikeNextRoundPointsShouldGoToThePreviousRoundPoints() {
        Game game = new Game();


        game.roll(1);
        game.isStrike(10);
        game.roll(1);
        game.roll(1);
        for (int i = 0; i < game.roundPoints.length; i++) {
            System.out.println("index: "+ i + " R: " +game.roundPoints[i]);
        }

        assertEquals(3, game.roundPoints[0]);
        assertEquals(5,game.score());
    }

    @Test
    void WhenYouGetASpareNextRollPointsShouldGoToThePreviousRoundPoints() {
        Game game = new Game();

        game.roll(5);
        game.roll(5);
        game.roll(1);
        game.roll(5);


        assertEquals(11,game.roundPoints[0]);
    }

    @Test
    void WhenThePlayerGetsAStrikeNextRoundShouldImmediatelyStart() {
        Game game = new Game();
        game.roll(1);
        game.isStrike(10);
        assertEquals(2, game.roundCounter);
    }

    @Test
    void TwoStrikesInARow() {
        Game game = new Game();

        game.roll(10);
        game.roll(10);
        game.roll(1);
        game.roll(1);

        for (var r : game.rollPoints) {
            System.out.println(r);
        }

        for (int i = 0; i < game.roundPoints.length; i++) {
            System.out.println("index: "+ i + " R: " +game.roundPoints[i]);
        }
        assertEquals(20,game.roundPoints[0]);
        assertEquals(12,game.roundPoints[1]);
    }

    @Test
    void TwoSparesInARow() {
        Game game = new Game();

        game.roll(5);
        game.roll(5);


    }



}
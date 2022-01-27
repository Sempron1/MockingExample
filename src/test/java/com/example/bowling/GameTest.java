package com.example.bowling;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {


    @Test
    void scoreMethodShouldReturnTotalScore() {
        Game game = new Game();

        int result = game.score();
        assertEquals(game.totalScore, result);
    }

    @Test
    void knockedDownedPinsShouldIncreaseTotalScore() {
        Game game = new Game();
        game.addRollToScore(10);
        var result = game.score();
        assertEquals(10, result);
    }

    @Test
    void roundShouldIncreaseAfterTwoRolls() {
        Game game = new Game();
        game.roll(3);
        game.roll(3);
        assertEquals(2, game.roundCounter);
    }

    @Test
    void rollCountShouldResetAfterEverySecondRoll() {
        Game game = new Game();
        game.roll(3);
        game.roll(3);
        assertEquals(0, game.rollCount);
    }

    @Test
    void rollMethodShouldKnockDownPinsAndAddToTotalScore() {
        Game game = new Game();
        game.roll(1);
        assertEquals(1, game.score());
    }

    @Test
    void afterRollMethodIsCalledTheTotalPinsLeftShouldDecreaseDependingOnKnockedDownPins() {
        Game game = new Game();
        game.roll(1);
        assertEquals(9, game.pins);
    }


    @Test
    void listShouldSaveEveryScoreFromEveryIndividualRoll() {
        Game game = new Game();
        game.roll(1);
        game.roll(1);
        assertEquals(1, game.rollList.get(0));
        assertEquals(1, game.rollList.get(1));
    }


    @Test
    void whenYouGetAStrikeNextRoundPointsShouldGoToThePreviousRoundPoints() {
        Game game = new Game();


        game.roll(10);
        game.roll(1);
        game.roll(1);


        assertEquals(12, game.rollList.get(0));
        assertEquals(14, game.score());
    }

    @Test
    void whenYouGetASpareNextRollPointsShouldGoToThePreviousRoundPoints() {
        Game game = new Game();

        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);


        assertEquals(25, game.score());
    }

    @Test
    void whenThePlayerGetsAStrikeNextRoundShouldImmediatelyStart() {
        Game game = new Game();
        game.roll(10);

        assertEquals(2, game.roundCounter);
    }

    @Test
    void twoStrikesInARowShouldStillGetTheirOwnBonusRolls() {
        Game game = new Game();

        game.roll(10);
        game.roll(10);
        game.roll(1);
        game.roll(1);

        assertEquals(21, game.rollList.get(0));
        assertEquals(12, game.rollList.get(1));
    }

    @Test
    void twoSparesOfFiveShouldEqual25TotalPoints() {
        Game game = new Game();

        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);


        assertEquals(25, game.score());

    }

    @Test
    void threeStrikesInARowShouldEqual50TotalPoints() {
        Game game = new Game();
        game.roll(10);
        game.roll(10);
        game.roll(10);

        assertEquals(30, game.rollList.get(0));
        assertEquals(50, game.score());
    }

    @Test
    void tenStrikesInARowPlusBonusRollsShouldBe300Points() {
        Game game = new Game();

        for (int i = 0; i < 12; i++) {
            game.roll(10);
        }

        assertEquals(300, game.score());
    }

    @Test
    void tenSparesInaRowPlusBonusShouldBe150Points() {
        Game game = new Game();

        for (int i = 0; i < 21; i++) {
            game.roll(5);
        }
        assertEquals(150, game.score());
    }

    @Test
    void nonSpareRollShouldNotAddNextRollToScore() {
        Game game = new Game();
        game.roll(2);
        game.roll(3);
        game.roll(2);
        game.roll(3);
        assertEquals(10, game.score());

    }

}
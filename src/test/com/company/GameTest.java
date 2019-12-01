package com.company;


import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class GameTest {
    @Test
    public void rollBallTest() {
        boolean inRange = false;
        int begin = 0;
        int end = 11;
        int roll = Game.rollBall(9);
        if ((roll <= end) && (roll >= begin)) {
            inRange = true;
        }
        assertTrue(inRange);
    }

    @Test
    public void OnlyOneTest() {
        int result = Game.scoreGame(1, 1);
        assertEquals(20, result);
    }

    @Test
    public void SpareTest() {
        int result = Game.scoreGame(5, 5);
        assertEquals(155, result);
    }

    @Test
    public void All0Test() {
        int result = Game.scoreGame(0, 0);
        assertEquals(0, result);
    }

    @Test
    public void All9Test() {
        int result = Game.scoreGame(9, 1);
        assertEquals(190, result);
    }

    @Test
    public void StrikeTest() {
        int result = Game.scoreGame(10, 0);
        assertEquals(300, result);
    }

    @Test
    @Parameters({"10"})
    public void checkIsMaxTest(int score) {
        assertTrue(Game.checkMax(score));
    }

    @Test
    @Parameters({"0", "9", "-1"})
    public void checkIsNotMaxTest(int score) {
        assertFalse(Game.checkMax(score));
    }
}
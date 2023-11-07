package org.test.game.core.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.test.game.core.GameService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameServiceImplTest {
    private GameService gameService;

    @BeforeEach
    public void setUp() {
        gameService = new GameServiceImpl();
    }

    @Test
    public void testIsPalindromeWithPalindrome() {
        assertTrue(gameService.isPalindrome("racecar"));
    }

    @Test
    public void testIsPalindromeWithNonPalindrome() {
        assertFalse(gameService.isPalindrome("hello"));
    }

    @Test
    public void testPalindromeScore() {
        assertEquals(7, gameService.palindromeScore("racecar"));
    }

    @Test
    public void testPalindromeScoreWithSpaces() {
        assertEquals(10, gameService.palindromeScore("hello world"));
    }
}

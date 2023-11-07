package org.test.game.core.impl;

import org.junit.Before;
import org.junit.Test;
import org.test.game.core.GameBoard;
import org.test.game.core.GameService;
import org.test.game.entity.Player;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameBoardImplTest {
    private GameBoard gameBoard;
    private Player player0;
    private GameService gameService;

    @Before
    public void setup() {
        gameService = mock(GameService.class);
        when(gameService.isPalindrome("racecar")).thenReturn(true);
        when(gameService.isPalindrome("notpalindrome")).thenReturn(false);
        when(gameService.palindromeScore("racecar")).thenReturn(7);

        player0 = new Player("Alice");

        Player player1 = new Player("Bob");
        player1.increaseScore(10);

        Player player2 = new Player("Charlie");
        player2.increaseScore(15);

        Player player3 = new Player("David");
        player3.increaseScore(5);

        Player player4 = new Player("Janis");
        player4.increaseScore(3);

        HashSet<Object> players = new HashSet<>();

        gameBoard = new GameBoardImpl(Set.of(player0, player1, player2, player3, player4), gameService);
    }

    @Test
    public void testPlayWithPalindrome() {
        gameBoard.play(player0, "racecar");
        assertEquals(7, player0.getScore());
        assertTrue(player0.getSetOfPalindrome().contains("racecar"));
    }

    @Test
    public void testPlayWithNonPalindrome() {
        gameBoard.play(player0, "notpalindrome");
        assertEquals(0, player0.getScore());
        assertFalse(player0.getSetOfPalindrome().contains("notpalindrome"));
    }

    @Test
    public void testGetBest5Players() {

        List<Player> bestPlayers = gameBoard.getBest5Players(gameBoard.getAllPlayers());
        assertEquals(5, bestPlayers.size());

        assertEquals("Charlie", bestPlayers.get(0).getName());
        assertEquals("Bob", bestPlayers.get(1).getName());
        assertEquals("David", bestPlayers.get(2).getName());
        assertEquals("Janis", bestPlayers.get(3).getName());
        assertEquals("Alice", bestPlayers.get(4).getName());
    }
}

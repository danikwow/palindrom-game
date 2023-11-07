package org.test.game.core.impl;

import org.test.game.core.GameBoard;
import org.test.game.core.GameService;
import org.test.game.entity.Player;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GameBoardImpl implements GameBoard {
    private final Set<Player> players;

    private final GameService gameService;

    public GameBoardImpl(Set<Player> players, GameService service) {
        this.players = players;
        this.gameService = service;
    }

    public void play(Player player, String palindrome) {
        if (players.contains(player)) {
            if (gameService.isPalindrome(palindrome)) {
                if (player.addPalindromeToSet(palindrome)) {
                    int score = gameService.palindromeScore(palindrome);
                    player.increaseScore(score);
                    System.out.println("Player " + player.getName() + " earned " + score);
                }
            } else {
                System.out.println("It's not a palindrome");
            }
        } else {
            System.out.println("Can't find player with that Name");
        }
    }

    public List<Player> getBest5Players(Set<Player> players) {
        return players.stream()
                .sorted(Comparator.comparingLong(Player::getScore).reversed())
                .collect(Collectors.toList()).subList(0, Math.min(players.size(), 5));
    }


    public Set<Player> getAllPlayers() {
        return players;
    }
}

package org.test.game.core;

import org.test.game.entity.Player;

import java.util.List;
import java.util.Set;

public interface GameBoard {
    void play(Player player, String palindrome);

    List<Player> getBest5Players(Set<Player> players);
    Set<Player> getAllPlayers();
}

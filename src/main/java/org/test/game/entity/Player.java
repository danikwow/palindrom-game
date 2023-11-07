package org.test.game.entity;

import java.util.HashSet;
import java.util.Set;

public class Player extends User {
    private long score;
    private final Set<String> setOfPalindrome;

    {
        setOfPalindrome = new HashSet<>();
        score = 0L;
    }

    public Player(String name) {
        super(name);
    }

    public long getScore() {
        return score;
    }

    public boolean addPalindromeToSet(String palindrome) {
        if (setOfPalindrome.contains(palindrome)) {
            return false;
        } else {
            return setOfPalindrome.add(palindrome);
        }
    }

    public void increaseScore(long newScore) {
        this.score += newScore;
    }

    public Set<String> getSetOfPalindrome() {
        return setOfPalindrome;
    }
}

package org.test.game.core.impl;

import org.test.game.core.GameService;

public class GameServiceImpl implements GameService {
    @Override
    public boolean isPalindrome(String palindrome) {
        return palindrome.replaceAll("\\W","")
                .equalsIgnoreCase(new StringBuilder(palindrome.replaceAll("\\W",""))
                                                                .reverse().toString());
    }

    @Override
    public int palindromeScore(String palindrome) {
        return palindrome.replaceAll(" ", "").length();
    }
}

package com.blind75.problems.arrays_and_hashing.p002_valid_anagram.p002_valid_anagram;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagramFirstTry implements ValidAnagram {
    @Override
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> countByChar = new HashMap<>();
        for (Character c : s.toCharArray()) {
            countByChar.merge(c, 1, Integer::sum);
        }
        for (Character c : t.toCharArray()) {
            Integer count = countByChar.get(c);
            if (count == null || count == 0) {
                return false;
            } else {
                countByChar.put(c, count - 1);
            }
        }
        return true;
    }
}

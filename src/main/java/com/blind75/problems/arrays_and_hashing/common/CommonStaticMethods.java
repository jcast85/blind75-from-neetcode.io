package com.blind75.problems.arrays_and_hashing.common;

import java.util.HashMap;
import java.util.Map;

public class CommonStaticMethods {
  private CommonStaticMethods() {}

  public static boolean isAnagram(String s, String t) {
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

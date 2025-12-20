package com.blind75.problems.arrays_and_hashing.group_anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramsWithHashStringAsMapKey implements GroupAnagrams {
  @Override
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> anagramMap = new HashMap<>();
    for (String str : strs) {
      String key = getHash(str);
      List<String> stringList;
      if(anagramMap.containsKey(key)) {
        stringList = anagramMap.get(key);
      } else {
        stringList = new ArrayList<>();
      }
      stringList.add(str);
      anagramMap.put(key, stringList);
    }
    return anagramMap.values().stream().toList();
  }

  private static final int MAX_CHAR = 26;

  private static String getHash(String str) {
    StringBuilder hash = new StringBuilder();
    int[] countByChar = new int[MAX_CHAR];
    for (Character c : str.toCharArray()) {
      int charIndex = c - 'a';
      countByChar[charIndex]++;
    }
    for (int j : countByChar) {
      hash.append(j);
      hash.append("-");
    }
    return hash.toString();
  }
}

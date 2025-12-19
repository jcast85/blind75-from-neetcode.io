package com.blind75.problems.arrays_and_hashing.group_anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramsUsingStrDigestAsMapKey implements GroupAnagrams {
  @Override
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<Map<Character, Integer>, List<String>> anagramMap = new HashMap<>();
    for (String str : strs) {
      Map<Character, Integer> key = getCharFrequencyMap(str);
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

  private static Map<Character, Integer> getCharFrequencyMap(String str) {
    Map<Character, Integer> countByChar = new HashMap<>();
    for (Character c : str.toCharArray()) {
      countByChar.merge(c, 1, Integer::sum);
    }
    return countByChar;
  }
}

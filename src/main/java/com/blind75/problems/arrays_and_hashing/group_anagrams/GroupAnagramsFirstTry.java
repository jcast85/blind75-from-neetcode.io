package com.blind75.problems.arrays_and_hashing.group_anagrams;

import com.blind75.problems.arrays_and_hashing.common.CommonStaticMethods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramsFirstTry implements GroupAnagrams {
  @Override
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> anagramMap = new HashMap<>();
    for (String str : strs) {
      boolean isNewKey = true;
      for (String key : anagramMap.keySet()) {
        if(CommonStaticMethods.isAnagram(str, key)) {
          anagramMap.get(key).add(str);
          isNewKey = false;
          break;
        }
      }
      if(isNewKey) {
        ArrayList<String> anagramGroup = new ArrayList<>();
        anagramGroup.add(str);
        anagramMap.put(str, anagramGroup);
      }
    }
    return anagramMap.values().stream().toList();
  }
}

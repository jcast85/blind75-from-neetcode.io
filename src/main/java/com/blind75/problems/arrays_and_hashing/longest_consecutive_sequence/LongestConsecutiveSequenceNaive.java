package com.blind75.problems.arrays_and_hashing.longest_consecutive_sequence;

import java.util.*;

public class LongestConsecutiveSequenceNaive implements LongestConsecutiveSequence {
  @Override
  public int longestConsecutive(int[] nums) {
    Map<Integer, Boolean> hasNext = new HashMap<>();
    for (int num : nums) {
      if(hasNext.containsKey(num+1)) {
        hasNext.put(num, true);
      } else {
        hasNext.put(num, false);
      }
      if(hasNext.containsKey(num-1)) {
        hasNext.put(num-1, true);
      }
    }
    Map<Integer, Set<Integer>> longestConsecutiveSequenceByElement = new HashMap<>();
    for (Integer key : hasNext.keySet()) {
      Set<Integer> longestConsecutiveSequenceForElement;
      if(longestConsecutiveSequenceByElement.containsKey(key)) {
        longestConsecutiveSequenceForElement = longestConsecutiveSequenceByElement.get(key);
      } else {
        longestConsecutiveSequenceForElement = new HashSet<>();
        if(hasNext.get(key) == true) {
          if(longestConsecutiveSequenceByElement.containsKey(key + 1)) {
            longestConsecutiveSequenceForElement = longestConsecutiveSequenceByElement.get(key + 1);
          }
        }
      }
      longestConsecutiveSequenceForElement.add(key);
      longestConsecutiveSequenceByElement.put(key, longestConsecutiveSequenceForElement);
      if(hasNext.get(key) == true) {
        longestConsecutiveSequenceByElement.put(key + 1, longestConsecutiveSequenceForElement);
      }
    }

    int longestConsecutiveSequence = 0;
    for (Set<Integer> longestConsecutiveSequenceForElement : longestConsecutiveSequenceByElement.values()) {
      if(longestConsecutiveSequenceForElement.size() > longestConsecutiveSequence) {
        longestConsecutiveSequence = longestConsecutiveSequenceForElement.size();
      }
    }
    return longestConsecutiveSequence;
  }
}

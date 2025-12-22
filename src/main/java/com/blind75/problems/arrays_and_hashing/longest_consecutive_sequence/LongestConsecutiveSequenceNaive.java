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
    Set<Integer> alreadyUsed = new HashSet<>();
    int maxLengthSequence = 0;
    for (Integer key : hasNext.keySet()) {
      if(alreadyUsed.contains(key)) {
        continue;
      }
      int currentLengthSequence = 1;
      int i=1;
      while(Boolean.TRUE.equals(hasNext.get(key - i))) {
        currentLengthSequence++;
        alreadyUsed.add(key - i);
        i++;
      }
      i=0;
      while(Boolean.TRUE.equals(hasNext.get(key + i))) {
        currentLengthSequence++;
        alreadyUsed.add(key + i);
        i++;
      }
      if(currentLengthSequence > maxLengthSequence) {
        maxLengthSequence = currentLengthSequence;
      }
    }
    return maxLengthSequence;
  }
}

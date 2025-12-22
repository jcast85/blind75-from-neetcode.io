package com.blind75.problems.arrays_and_hashing.longest_consecutive_sequence;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequenceOptimized implements LongestConsecutiveSequence {
  @Override
  public int longestConsecutive(int[] nums) {
    Set<Integer> numSet = new HashSet<>();
    for (int num : nums) {
      numSet.add(num);
    }
    int maxLengthSequence = 0;
    for (Integer key : numSet) {
      if(numSet.contains(key-1)) {
        continue;
      }
      int currentLengthSequence = 0;
      int i=0;
      while(numSet.contains(key + i)) {
        currentLengthSequence++;
        i++;
      }
      if(currentLengthSequence > maxLengthSequence) {
        maxLengthSequence = currentLengthSequence;
      }
    }
    return maxLengthSequence;
  }
}

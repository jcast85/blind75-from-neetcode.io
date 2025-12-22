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
    Set<Integer> alreadyUsed = new HashSet<>();
    int maxLengthSequence = 0;
    for (Integer key : numSet) {
      if(alreadyUsed.contains(key)) {
        continue;
      }
      int currentLengthSequence = 0;
      int i=1;
      while(numSet.contains(key - i)) {
        currentLengthSequence++;
        alreadyUsed.add(key - i);
        i++;
      }
      i=0;
      while(numSet.contains(key + i)) {
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

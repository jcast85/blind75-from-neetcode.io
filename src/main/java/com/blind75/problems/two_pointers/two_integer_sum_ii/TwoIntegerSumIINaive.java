package com.blind75.problems.two_pointers.two_integer_sum_ii;

import java.util.HashMap;
import java.util.Map;

public class TwoIntegerSumIINaive implements TwoIntegerSumII {
  @Override
  public int[] twoSum(int[] numbers, int target) {
    Map<Integer, Integer> missingAddendumMap = new HashMap<>();
    Map<Integer, Integer> indexByNumber = new HashMap<>();
    for (int i=0; i<numbers.length; i++) {
      missingAddendumMap.put(numbers[i], target - numbers[i]);
      indexByNumber.put(numbers[i], i);
    }
    for (Map.Entry<Integer, Integer> integerIntegerEntry : missingAddendumMap.entrySet()) {
      if(missingAddendumMap.containsKey(integerIntegerEntry.getValue())) {
        int index1 = indexByNumber.get(integerIntegerEntry.getValue());
        int index2 = indexByNumber.get(integerIntegerEntry.getKey());
        if(index1 == index2) {
          continue;
        }
        return TwoIntegerSumIICommonStaticMethods.returnIndex(index1, index2);
      }
    }
    return new int[0];
  }
}

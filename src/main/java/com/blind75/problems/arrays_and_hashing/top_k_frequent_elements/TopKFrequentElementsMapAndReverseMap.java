package com.blind75.problems.arrays_and_hashing.top_k_frequent_elements;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TopKFrequentElementsMapAndReverseMap implements TopKFrequentElements {
  @Override
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> frequencyByNumber = new HashMap<>();
    Map<Integer, HashSet<Integer>> numbersByFrequency = new HashMap<>();
    int maxCount = 0;
    for (int num : nums) {
      Integer prevFreq = (frequencyByNumber.get(num) == null) ? 0 : frequencyByNumber.get(num);
      Integer newFreq = prevFreq + 1;
      frequencyByNumber.put(num, newFreq);
      HashSet<Integer> integerListToRemoveFrom = (numbersByFrequency.get(prevFreq) == null) ? new HashSet<>() : numbersByFrequency.get(prevFreq);
      integerListToRemoveFrom.remove(num);
      numbersByFrequency.put(prevFreq, integerListToRemoveFrom);
      HashSet<Integer> integerListToAddTo = (numbersByFrequency.get(newFreq) == null) ? new HashSet<>() : numbersByFrequency.get(newFreq);
      integerListToAddTo.add(num);
      numbersByFrequency.put(newFreq, integerListToAddTo);
      if(newFreq > maxCount) {
        maxCount = newFreq;
      }
    }
    int[] result = new int[k];
    int resultIndex = 0;
    for(int key = maxCount; key > 0; key--) {
      if(numbersByFrequency.get(key) != null) {
        for (Integer num : numbersByFrequency.get(key)) {
          result[resultIndex] = num;
          resultIndex++;
        }
      }
      if(resultIndex == k) {
        break;
      }
    }
    return result;
  }
}

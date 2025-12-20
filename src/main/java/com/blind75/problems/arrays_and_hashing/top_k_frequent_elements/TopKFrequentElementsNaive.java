package com.blind75.problems.arrays_and_hashing.top_k_frequent_elements;

import java.util.HashMap;
import java.util.Map;

public class TopKFrequentElementsNaive implements TopKFrequentElements {
  @Override
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> frequencyByNumber = new HashMap<>();
    for (int num : nums) {
      frequencyByNumber.merge(num, 1, Integer::sum);
    }
    return frequencyByNumber.entrySet().stream()
      .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
      .toList()
      .subList(0, k).stream()
      .map(Map.Entry::getKey)
      .mapToInt(Integer::intValue)
      .toArray();
  }
}

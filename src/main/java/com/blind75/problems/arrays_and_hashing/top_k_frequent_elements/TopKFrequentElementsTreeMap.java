package com.blind75.problems.arrays_and_hashing.top_k_frequent_elements;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TopKFrequentElementsTreeMap implements TopKFrequentElements {
  @Override
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> frequencyByNumber = new TreeMap<>();
    for (int num : nums) {
      frequencyByNumber.merge(num, 1, Integer::sum);
    }
    int entryToSkipNumber = frequencyByNumber.size() - k;
    int[] result = new int[k];
    Iterator<Map.Entry<Integer, Integer>> iterator = frequencyByNumber.entrySet().iterator();
    for(int i = 0; i < frequencyByNumber.size(); i++) {
      if(i < entryToSkipNumber) {
        iterator.next();
        continue;
      }
      result[i - entryToSkipNumber] = iterator.next().getKey();
    }
    return result;
  }
}

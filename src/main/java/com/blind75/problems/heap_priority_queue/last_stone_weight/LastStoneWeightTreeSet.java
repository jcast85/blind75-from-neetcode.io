package com.blind75.problems.heap_priority_queue.last_stone_weight;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class LastStoneWeightTreeSet implements LastStoneWeight {
  @Override
  public int lastStoneWeight(int[] stones) {
    TreeMap<Integer, Integer> stoneTreeMap = new TreeMap<>();
    IntStream.of(stones).forEach(stone -> stoneTreeMap.put(stone, stoneTreeMap.getOrDefault(stone, 0) + 1));
    int stoneCount = stones.length;
    while (stoneCount > 1) {
      Map.Entry<Integer, Integer> lastEntry;

      lastEntry = stoneTreeMap.lastEntry();
      int first = lastEntry.getKey();
      if(lastEntry.getValue() == 1) {
        stoneTreeMap.pollLastEntry();
      } else {
        stoneTreeMap.put(first, lastEntry.getValue() - 1);
      }
      stoneCount--;

      lastEntry = stoneTreeMap.lastEntry();
      int second = lastEntry.getKey();
      if(lastEntry.getValue() == 1) {
        stoneTreeMap.pollLastEntry();
      } else {
        stoneTreeMap.put(second, lastEntry.getValue() - 1);
      }
      stoneCount--;

      int diff = first - second;
      if (diff > 0) {
        stoneTreeMap.put(diff, stoneTreeMap.getOrDefault(diff, 0) + 1);
        stoneCount++;
      }
    }
    return stoneTreeMap.isEmpty() ? 0 : stoneTreeMap.firstKey();
  }
}

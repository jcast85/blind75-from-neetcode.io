package com.blind75.problems.p18_last_stone_weight;

import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LastStoneWeightTreeSet implements LastStoneWeight {
  @Override
  public int lastStoneWeight(int[] stones) {
    TreeSet<Integer> stoneSet = IntStream.of(stones)
      .boxed()
      .collect(Collectors.toCollection(TreeSet::new));
    while (stoneSet.size() > 1) {
      int first = stoneSet.removeLast();
      int second = stoneSet.removeLast();
      int diff = first - second;
      if (diff > 0) {
        stoneSet.add(diff);
      }
    }
    return stoneSet.isEmpty() ? 0 : stoneSet.getFirst();
  }
}

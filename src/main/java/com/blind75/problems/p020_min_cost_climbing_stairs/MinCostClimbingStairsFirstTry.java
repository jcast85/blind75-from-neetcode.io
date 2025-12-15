package com.blind75.problems.p020_min_cost_climbing_stairs;

import java.util.*;

public class MinCostClimbingStairsFirstTry implements MinCostClimbingStairs {
  private record IntArrayKey(int[] a) {

    @Override
      public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IntArrayKey(int[] a1))) return false;
        return Arrays.equals(this.a, a1);
      }

      @Override
      public int hashCode() {
        return Arrays.hashCode(a);
      }

      @Override
      public String toString() {
        return Arrays.toString(a);
      }
    }

  @Override
  public int minCostClimbingStairs(int[] cost) {
    Map<IntArrayKey, List<Integer>> cache = new HashMap<>();
    List<Integer> steps = minCostClimbingStairs(cost, cache);
    return getSumOfIndexedValues(cost, steps, 0);
  }

  private int getSumOfIndexedValues(int[] cost, List<Integer> steps, int offset) {
    return steps.stream()
      .map(index -> cost[index + offset])
      .reduce(0, Integer::sum);
  }

  private List<Integer> minCostClimbingStairs(int[] cost, Map<IntArrayKey, List<Integer>> cache) {
    List<Integer> result = new ArrayList<>();
    if(cost.length == 1) {
      result.add(0);
      return result;
    }
    if(cost.length == 2) {
      if(cost[0] <= cost[1]) {
        result.add(0);
      } else {
        result.add(1);
      }
      return result;
    }
    int[] firstToSecondLastValueArray = Arrays.copyOfRange(cost, 0, cost.length - 1);
    int[] secondToLastValueArray = Arrays.copyOfRange(cost, 1, cost.length);

    IntArrayKey key1 = new IntArrayKey(firstToSecondLastValueArray);
    IntArrayKey key2 = new IntArrayKey(secondToLastValueArray);

    List<Integer> firstToSecondLastIndexArray;
    if (!cache.containsKey(key1)) {
      firstToSecondLastIndexArray = minCostClimbingStairs(firstToSecondLastValueArray, cache);
      cache.put(key1, firstToSecondLastIndexArray);
    }
    firstToSecondLastIndexArray = new ArrayList<>(cache.get(key1));

    List<Integer> secondToLastIndexArray;
    if (!cache.containsKey(key2)) {
      secondToLastIndexArray = minCostClimbingStairs(secondToLastValueArray, cache);
      cache.put(key2, secondToLastIndexArray);
    }
    secondToLastIndexArray = new ArrayList<>(cache.get(key2));

    boolean isFirstToUse = secondToLastIndexArray.getFirst() != 0;
    boolean isLastToUse = firstToSecondLastIndexArray.getLast() != cost.length - 2;
    int firstToSecondLastCaseSum = getSumOfIndexedValues(cost, firstToSecondLastIndexArray, 0)
      + (isLastToUse ? cost[cost.length - 1] : 0);
    int secondToLastCaseSum = getSumOfIndexedValues(cost, secondToLastIndexArray, 1)
      + (isFirstToUse ? cost[0] : 0);
    if(firstToSecondLastCaseSum <= secondToLastCaseSum) {
      if(isLastToUse) {
        firstToSecondLastIndexArray.add(cost.length - 1);
      }
      return new ArrayList<>(firstToSecondLastIndexArray);
    } else {
      for (int i=0; i<secondToLastIndexArray.size(); i++) {
        secondToLastIndexArray.set(i, secondToLastIndexArray.get(i) + 1);
      }
      if(isFirstToUse) {
        secondToLastIndexArray.addFirst(0);
      }
      return new ArrayList<>(secondToLastIndexArray);
    }
  }
}
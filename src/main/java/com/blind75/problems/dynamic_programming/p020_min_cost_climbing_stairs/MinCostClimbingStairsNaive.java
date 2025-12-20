package com.blind75.problems.dynamic_programming.p020_min_cost_climbing_stairs;

public class MinCostClimbingStairsNaive implements MinCostClimbingStairs {
  private static final class IntArrayKey {
    private final int[] a;

    private IntArrayKey(int[] a) {
      this.a = a;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof IntArrayKey other)) return false;
      return java.util.Arrays.equals(this.a, other.a);
    }

    @Override
    public int hashCode() {
      return java.util.Arrays.hashCode(a);
    }

    @Override
    public String toString() {
      return java.util.Arrays.toString(a);
    }
  }

  @Override
  public int minCostClimbingStairs(int[] cost) {
    java.util.Map<IntArrayKey, java.util.List<Integer>> cache = new java.util.HashMap<>();
    java.util.List<Integer> steps = minCostClimbingStairs(cost, cache);
    return getSumOfIndexedValues(cost, steps, 0);
  }

  private int getSumOfIndexedValues(int[] cost, java.util.List<Integer> steps, int offset) {
    return steps.stream()
      .map(index -> cost[index + offset])
      .reduce(0, Integer::sum);
  }

  private java.util.List<Integer> minCostClimbingStairs(int[] cost, java.util.Map<IntArrayKey, java.util.List<Integer>> cache) {
    java.util.List<Integer> result = new java.util.ArrayList<>();
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
    int[] firstToSecondLastValueArray = java.util.Arrays.copyOfRange(cost, 0, cost.length - 1);
    int[] secondToLastValueArray = java.util.Arrays.copyOfRange(cost, 1, cost.length);

    IntArrayKey key1 = new IntArrayKey(firstToSecondLastValueArray);
    IntArrayKey key2 = new IntArrayKey(secondToLastValueArray);

    java.util.List<Integer> firstToSecondLastIndexArray;
    if (!cache.containsKey(key1)) {
      firstToSecondLastIndexArray = minCostClimbingStairs(firstToSecondLastValueArray, cache);
      cache.put(key1, firstToSecondLastIndexArray);
    }
    firstToSecondLastIndexArray = new java.util.ArrayList<>(cache.get(key1));

    java.util.List<Integer> secondToLastIndexArray;
    if (!cache.containsKey(key2)) {
      secondToLastIndexArray = minCostClimbingStairs(secondToLastValueArray, cache);
      cache.put(key2, secondToLastIndexArray);
    }
    secondToLastIndexArray = new java.util.ArrayList<>(cache.get(key2));

    boolean isSecondToUse = secondToLastIndexArray.get(0) != 0
      && cost[0]>secondToLastValueArray[0]
      && secondToLastValueArray.length > 2;
    boolean isFirstToUse = !isSecondToUse && secondToLastIndexArray.get(0) != 0;
    boolean isSecondLastToUse = firstToSecondLastIndexArray.get(firstToSecondLastIndexArray.size()-1) != cost.length - 2
      && firstToSecondLastValueArray[firstToSecondLastValueArray.length-1] < cost[cost.length-1]
      && firstToSecondLastValueArray.length > 2;
    boolean isLastToUse = !isSecondLastToUse && firstToSecondLastIndexArray.get(firstToSecondLastIndexArray.size()-1) != cost.length - 2;
    int firstToSecondLastCaseSum = getSumOfIndexedValues(cost, firstToSecondLastIndexArray, 0)
      + (isLastToUse ? cost[cost.length - 1] : 0)
      + (isSecondLastToUse ? cost[cost.length - 2] : 0);
    int secondToLastCaseSum = getSumOfIndexedValues(cost, secondToLastIndexArray, 1)
      + (isFirstToUse ? cost[0] : 0)
      + (isSecondToUse ? cost[1] : 0);
    if(firstToSecondLastCaseSum <= secondToLastCaseSum) {
      if(isLastToUse) {
        firstToSecondLastIndexArray.add(cost.length - 1);
      }
      if(isSecondLastToUse) {
        firstToSecondLastIndexArray.add(cost.length - 2);
      }
      return new java.util.ArrayList<>(firstToSecondLastIndexArray);
    } else {
      for (int i=0; i<secondToLastIndexArray.size(); i++) {
        secondToLastIndexArray.set(i, secondToLastIndexArray.get(i) + 1);
      }
      if(isFirstToUse) {
        secondToLastIndexArray.add(0, 0);
      }
      if(isSecondToUse) {
        secondToLastIndexArray.add(0, 1);
      }
      return new java.util.ArrayList<>(secondToLastIndexArray);
    }
  }
}

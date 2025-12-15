package com.blind75.problems.p020_min_cost_climbing_stairs;

public class MinCostClimbingStairsAvoidingUselessSum implements MinCostClimbingStairs {
  private static final class IndexListAndValueSum {
    private final java.util.List<Integer> indexes;
    private final int valueSum;

    private IndexListAndValueSum(java.util.List<Integer> indexes, int valueSum) {
      this.indexes = indexes;
      this.valueSum = valueSum;
    }


    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof IndexListAndValueSum other)) return false;
      return this.valueSum == other.valueSum
        && java.util.Objects.equals(this.indexes, other.indexes);
    }

    @Override
    public int hashCode() {
      return java.util.Objects.hash(indexes, valueSum);
    }

    @Override
    public String toString() {
      return "IndexListAndValueSum{" +
        "indexes=" + indexes +
        ", valueSum=" + valueSum +
        '}';
    }
  }

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
    java.util.Map<IntArrayKey, IndexListAndValueSum> cache = new java.util.HashMap<>();
    IndexListAndValueSum steps = minCostClimbingStairs(cost, cache);
    return steps.valueSum;
  }

  private IndexListAndValueSum minCostClimbingStairs(int[] cost, java.util.Map<IntArrayKey, IndexListAndValueSum> cache) {
    java.util.List<Integer> result = new java.util.ArrayList<>();
    if(cost.length == 1) {
      result.add(0);
      return new IndexListAndValueSum(result, cost[0]);
    }
    if(cost.length == 2) {
      int min = Math.min(cost[0], cost[1]);
      if(cost[0] <= cost[1]) {
        result.add(0);
      } else {
        result.add(1);
      }
      return new IndexListAndValueSum(result, min);
    }
    int[] firstToSecondLastValueArray = java.util.Arrays.copyOfRange(cost, 0, cost.length - 1);
    int[] secondToLastValueArray = java.util.Arrays.copyOfRange(cost, 1, cost.length);

    IntArrayKey key1 = new IntArrayKey(firstToSecondLastValueArray);
    IntArrayKey key2 = new IntArrayKey(secondToLastValueArray);

    IndexListAndValueSum firstToSecondLastIndexArray;
    if (!cache.containsKey(key1)) {
      firstToSecondLastIndexArray = minCostClimbingStairs(firstToSecondLastValueArray, cache);
      cache.put(key1, firstToSecondLastIndexArray);
    }
    firstToSecondLastIndexArray = new IndexListAndValueSum(new java.util.ArrayList<>(cache.get(key1).indexes), cache.get(key1).valueSum);

    IndexListAndValueSum secondToLastIndexArray;
    if (!cache.containsKey(key2)) {
      secondToLastIndexArray = minCostClimbingStairs(secondToLastValueArray, cache);
      cache.put(key2, secondToLastIndexArray);
    }
    secondToLastIndexArray = new IndexListAndValueSum(new java.util.ArrayList<>(cache.get(key2).indexes), cache.get(key2).valueSum);

    boolean isSecondToUse = secondToLastIndexArray.indexes.get(0) != 0
      && cost[0]>secondToLastValueArray[0]
      && secondToLastValueArray.length > 2;
    boolean isFirstToUse = !isSecondToUse && secondToLastIndexArray.indexes.get(0) != 0;
    boolean isSecondLastToUse = firstToSecondLastIndexArray.indexes.get(firstToSecondLastIndexArray.indexes.size()-1) != cost.length - 2
      && firstToSecondLastValueArray[firstToSecondLastValueArray.length-1] < cost[cost.length-1]
      && firstToSecondLastValueArray.length > 2;
    boolean isLastToUse = !isSecondLastToUse && firstToSecondLastIndexArray.indexes.get(firstToSecondLastIndexArray.indexes.size()-1) != cost.length - 2;
    int firstToSecondLastCaseSum = firstToSecondLastIndexArray.valueSum
      + (isLastToUse ? cost[cost.length - 1] : 0)
      + (isSecondLastToUse ? cost[cost.length - 2] : 0);
    int secondToLastCaseSum = secondToLastIndexArray.valueSum
      + (isFirstToUse ? cost[0] : 0)
      + (isSecondToUse ? cost[1] : 0);
    if(firstToSecondLastCaseSum <= secondToLastCaseSum) {
      int newSum = firstToSecondLastIndexArray.valueSum;
      if(isLastToUse) {
        firstToSecondLastIndexArray.indexes.add(cost.length - 1);
        newSum += cost[cost.length - 1];
      }
      if(isSecondLastToUse) {
        firstToSecondLastIndexArray.indexes.add(cost.length - 2);
        newSum += cost[cost.length - 2];
      }
      return new IndexListAndValueSum(new java.util.ArrayList<>(firstToSecondLastIndexArray.indexes), newSum);
    } else {
      for (int i=0; i<secondToLastIndexArray.indexes.size(); i++) {
        secondToLastIndexArray.indexes.set(i, secondToLastIndexArray.indexes.get(i) + 1);
      }
      int newSum = secondToLastIndexArray.valueSum;
      if(isFirstToUse) {
        secondToLastIndexArray.indexes.add(0, 0);
        newSum += cost[0];
      }
      if(isSecondToUse) {
        secondToLastIndexArray.indexes.add(0, 1);
        newSum += cost[1];
      }
      return new IndexListAndValueSum(new java.util.ArrayList<>(secondToLastIndexArray.indexes), newSum);
    }
  }
}
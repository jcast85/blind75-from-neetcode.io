package com.blind75.problems.p020_min_cost_climbing_stairs;

public class MinCostClimbingStairsAvoidingUselessSumAndCopyOfRange implements MinCostClimbingStairs {
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

  @Override
  public int minCostClimbingStairs(int[] cost) {
    java.util.Map<java.util.List<Integer>, IndexListAndValueSum> cache = new java.util.HashMap<>();
    java.util.List<Integer> costAsList = java.util.Arrays.stream(cost).boxed().toList();
    IndexListAndValueSum steps = minCostClimbingStairs(costAsList, cache);
    return steps.valueSum;
  }

  private IndexListAndValueSum minCostClimbingStairs(java.util.List<Integer> costAsList, java.util.Map<java.util.List<Integer>, IndexListAndValueSum> cache) {
    java.util.List<Integer> result = new java.util.ArrayList<>();
    if(costAsList.size() == 1) {
      result.add(0);
      return new IndexListAndValueSum(result, costAsList.get(0));
    }
    if(costAsList.size() == 2) {
      int min = Math.min(costAsList.get(0), costAsList.get(1));
      if(costAsList.get(0) <= costAsList.get(1)) {
        result.add(0);
      } else {
        result.add(1);
      }
      return new IndexListAndValueSum(result, min);
    }
    java.util.List<Integer> firstToSecondLastValueArray = costAsList.subList(0, costAsList.size() - 1);
    java.util.List<Integer> secondToLastValueArray = costAsList.subList(1, costAsList.size());

    IndexListAndValueSum firstToSecondLastIndexArray;
    if (!cache.containsKey(firstToSecondLastValueArray)) {
      firstToSecondLastIndexArray = minCostClimbingStairs(firstToSecondLastValueArray, cache);
      cache.put(firstToSecondLastValueArray, firstToSecondLastIndexArray);
    }
    firstToSecondLastIndexArray = new IndexListAndValueSum(new java.util.ArrayList<>(cache.get(firstToSecondLastValueArray).indexes), cache.get(firstToSecondLastValueArray).valueSum);

    IndexListAndValueSum secondToLastIndexArray;
    if (!cache.containsKey(secondToLastValueArray)) {
      secondToLastIndexArray = minCostClimbingStairs(secondToLastValueArray, cache);
      cache.put(secondToLastValueArray, secondToLastIndexArray);
    }
    secondToLastIndexArray = new IndexListAndValueSum(new java.util.ArrayList<>(cache.get(secondToLastValueArray).indexes), cache.get(secondToLastValueArray).valueSum);

    boolean isSecondToUse = secondToLastIndexArray.indexes.get(0) != 0
      && costAsList.get(0)>secondToLastValueArray.get(0)
      && secondToLastValueArray.size() > 2;
    boolean isFirstToUse = !isSecondToUse && secondToLastIndexArray.indexes.get(0) != 0;
    boolean isSecondLastToUse = firstToSecondLastIndexArray.indexes.get(firstToSecondLastIndexArray.indexes.size()-1) != costAsList.size() - 2
      && firstToSecondLastValueArray.get(firstToSecondLastValueArray.size()-1) < costAsList.get(costAsList.size()-1)
      && firstToSecondLastValueArray.size() > 2;
    boolean isLastToUse = !isSecondLastToUse && firstToSecondLastIndexArray.indexes.get(firstToSecondLastIndexArray.indexes.size()-1) != costAsList.size() - 2;
    int firstToSecondLastCaseSum = firstToSecondLastIndexArray.valueSum
      + (isLastToUse ? costAsList.get(costAsList.size() - 1) : 0)
      + (isSecondLastToUse ? costAsList.get(costAsList.size() - 2) : 0);
    int secondToLastCaseSum = secondToLastIndexArray.valueSum
      + (isFirstToUse ? costAsList.get(0) : 0)
      + (isSecondToUse ? costAsList.get(1) : 0);
    if(firstToSecondLastCaseSum <= secondToLastCaseSum) {
      int newSum = firstToSecondLastIndexArray.valueSum;
      if(isLastToUse) {
        firstToSecondLastIndexArray.indexes.add(costAsList.size() - 1);
        newSum += costAsList.get(costAsList.size() - 1);
      }
      if(isSecondLastToUse) {
        firstToSecondLastIndexArray.indexes.add(costAsList.size() - 2);
        newSum += costAsList.get(costAsList.size() - 2);
      }
      return new IndexListAndValueSum(new java.util.ArrayList<>(firstToSecondLastIndexArray.indexes), newSum);
    } else {
      for (int i=0; i<secondToLastIndexArray.indexes.size(); i++) {
        secondToLastIndexArray.indexes.set(i, secondToLastIndexArray.indexes.get(i) + 1);
      }
      int newSum = secondToLastIndexArray.valueSum;
      if(isFirstToUse) {
        secondToLastIndexArray.indexes.add(0, 0);
        newSum += costAsList.get(0);
      }
      if(isSecondToUse) {
        secondToLastIndexArray.indexes.add(0, 1);
        newSum += costAsList.get(1);
      }
      return new IndexListAndValueSum(new java.util.ArrayList<>(secondToLastIndexArray.indexes), newSum);
    }
  }
}
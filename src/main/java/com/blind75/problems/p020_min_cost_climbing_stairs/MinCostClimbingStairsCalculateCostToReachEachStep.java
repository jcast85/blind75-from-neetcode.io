package com.blind75.problems.p020_min_cost_climbing_stairs;

public class MinCostClimbingStairsCalculateCostToReachEachStep implements MinCostClimbingStairs {
  @Override
  public int minCostClimbingStairs(int[] cost) {
    int n = cost.length;
    int[] costToReachEachStepArray = new int[n];

    costToReachEachStepArray[0] = cost[0];
    costToReachEachStepArray[1] = cost[1];

    for (int i = 2; i < n; i++) {
      costToReachEachStepArray[i] = cost[i] + Math.min(costToReachEachStepArray[i-1], costToReachEachStepArray[i-2]);
    }

    return Math.min(costToReachEachStepArray[n-1], costToReachEachStepArray[n-2]);
  }
}

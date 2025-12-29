package com.blind75.problems.dynamic_programming.climbing_stairs;

public class ClimbingStairsRecursive implements ClimbingStairs {
  @Override
  public int climbStairs(int n) {
    if(n == 2) {
      return 2;
    }
    if(n <= 1) {
      return 1;
    }
    return climbStairs(n-1) + climbStairs(n-2);
  }
}

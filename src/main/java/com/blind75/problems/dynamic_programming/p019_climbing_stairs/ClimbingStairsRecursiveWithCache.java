package com.blind75.problems.dynamic_programming.p019_climbing_stairs;

import java.util.HashMap;

public class ClimbingStairsRecursiveWithCache implements ClimbingStairs {
  @Override
  public int climbStairs(int n) {
    HashMap<Integer, Integer> cache = new HashMap<>();
    cache.put(0, 1);
    cache.put(1, 1);
    cache.put(2, 2);
    return climbStairs(n, cache);
  }

  private int climbStairs(int n, HashMap<Integer, Integer> cache) {
    if(n <= 2) {
      return cache.get(n);
    }
    if(cache.containsKey(n)) {
      return cache.get(n);
    }
    Integer firstCount;
    if(cache.containsKey(n - 1)) {
      firstCount = cache.get(n - 1);
    } else {
      firstCount = climbStairs(n - 1, cache);
    }
    Integer secondCount;
    if(cache.containsKey(n - 2)) {
      secondCount = cache.get(n - 2);
    } else {
      secondCount = climbStairs(n - 2, cache);
    }
    cache.put(n, firstCount + secondCount);
    return firstCount + secondCount;
  }
}

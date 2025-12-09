package com.blind75.problems.p19_climbing_stairs;

public class ClimbingStairsFirstTry implements ClimbingStairs {
  @Override
  public int climbStairs(int n) {
    int count = 1;
    System.out.print(count);
    int changeFactorFromBernoulli = 0;
    for(int k = 0; k < n-changeFactorFromBernoulli; k++) {
      changeFactorFromBernoulli = changeFactorFromBernoulli + 1;
      int currentValue = 1;
      boolean isValueToAdd = false;
      for(int j = 0; j <= k; j++) {
        if(n-j-changeFactorFromBernoulli>0) {
          currentValue *= (n-j-changeFactorFromBernoulli);
          isValueToAdd = true;
        }
      }
      if(isValueToAdd) {
        int value = currentValue / getFattoriale(k+1);
        System.out.print(" + " + value);
        count += value;
      }
    }
    System.out.println(" = " + count);
    return count;
  }

  private int getFattoriale(int n) {
    return n == 0 ? 1 : n * getFattoriale(n-1);
  }
}

package com.blind75.problems.p19_climbing_stairs;

public class ClimbingStairsFromFormula implements ClimbingStairs {
  @Override
  public int climbStairs(int n) {
    int count = 0;
    int changeFactorFromBernoulli = 0;
    for(int k = 0; k <= n-changeFactorFromBernoulli; k++) {
      int currentValue = (ClimbingStairsCommonStaticMethods.getFattoriale(n-changeFactorFromBernoulli).divide(
        ClimbingStairsCommonStaticMethods.getFattoriale(k)).divide(
        ClimbingStairsCommonStaticMethods.getFattoriale(n-changeFactorFromBernoulli-k))).intValue();
      System.out.print((k==0 ? "" : " + ") + currentValue);
      count += currentValue;
      changeFactorFromBernoulli++;
    }
    System.out.println(" = " + count);
    return count;
  }
}

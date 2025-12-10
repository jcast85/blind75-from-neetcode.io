package com.blind75.problems.p19_climbing_stairs;

import java.math.BigInteger;

public class ClimbingStairsFirstTry implements ClimbingStairs {
  @Override
  public int climbStairs(int n) {
    int count = 1;
    System.out.print(count);
    int changeFactorFromBernoulli = 0;
    for(int k = 0; k < n-changeFactorFromBernoulli; k++) {
      changeFactorFromBernoulli = changeFactorFromBernoulli + 1;
      BigInteger currentValue = BigInteger.ONE;
      boolean isValueToAdd = false;
      for(int j = 0; j <= k; j++) {
        if(n-j-changeFactorFromBernoulli>0) {
          currentValue = currentValue.multiply(BigInteger.valueOf(n-j-changeFactorFromBernoulli));
          isValueToAdd = true;
        }
      }
      if(isValueToAdd) {
        BigInteger value = currentValue.divide(ClimbingStairsCommonStaticMethods.getFattoriale(k+1));
        System.out.print(" + " + value);
        count += value.intValue();
      }
    }
    System.out.println(" = " + count);
    return count;
  }
}

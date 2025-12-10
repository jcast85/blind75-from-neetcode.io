package com.blind75.problems.p19_climbing_stairs;

public class ClimbingStairsFirstTry implements ClimbingStairs {
  @Override
  public int climbStairs(int n) {
    int count = 1;
    System.out.print(count);
    int changeFactorFromBernoulli = 0;
    for(int k = 0; k < n-changeFactorFromBernoulli; k++) {
      changeFactorFromBernoulli = changeFactorFromBernoulli + 1;
      java.math.BigInteger currentValue = java.math.BigInteger.ONE;
      boolean isValueToAdd = false;
      for(int j = 0; j <= k; j++) {
        if(n-j-changeFactorFromBernoulli>0) {
          currentValue = currentValue.multiply(java.math.BigInteger.valueOf(n-j-changeFactorFromBernoulli));
          isValueToAdd = true;
        }
      }
      if(isValueToAdd) {
        java.math.BigInteger value = currentValue.divide(getFattoriale(k+1));
        System.out.print(" + " + value);
        count += value.intValue();
      }
    }
    System.out.println(" = " + count);
    return count;
  }

  static java.math.BigInteger getFattoriale(int n) {
    return n == 0 ? java.math.BigInteger.ONE : java.math.BigInteger.valueOf(n).multiply(getFattoriale(n-1));
  }
}

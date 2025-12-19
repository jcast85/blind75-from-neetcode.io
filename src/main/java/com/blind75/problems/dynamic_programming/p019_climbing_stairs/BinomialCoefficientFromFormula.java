package com.blind75.problems.dynamic_programming.p019_climbing_stairs;

public class BinomialCoefficientFromFormula implements BinomialCoefficient {
  @Override
  public int binomialCoefficient(int n) {
    int count = 0;
    for(int k = 0; k <= n; k++) {
      int currentValue = (ClimbingStairsCommonStaticMethods.getFattoriale(n).divide(
        ClimbingStairsCommonStaticMethods.getFattoriale(k)).divide(
        ClimbingStairsCommonStaticMethods.getFattoriale(n-k))).intValue();
      System.out.print((k==0 ? "" : " + ") + currentValue);
      count += currentValue;
    }
    System.out.println(" = " + count);
    return count;
  }
}
